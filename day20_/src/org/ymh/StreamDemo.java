package org.ymh;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Author :ymh
 */
public class StreamDemo {
    public static void main(String[] args) throws IOException {
        Stream<String> lines = Files.lines(Paths.get("heroes.txt"), Charset.forName("utf-8"));
        ArrayList<Hero> heroes = new ArrayList<>();
        lines.forEach(str -> {
            String[] split = str.split("\t");
            Hero hero = new Hero();
            hero.setId(Integer.parseInt(split[0]));
            hero.setName(split[1]);
            hero.setLoc(split[2]);
            hero.setSex(split[3]);
            hero.setBirth(Integer.parseInt(split[4]));
            hero.setDeath(Integer.parseInt(split[5]));
            hero.setPower(Integer.parseInt(split[6]));
            heroes.add(hero);
        });
        // 1. 找到武将中武力前三的hero对象, 提示流也可以排序
        List<Hero> list = heroes.stream().sorted((a, b) -> -(a.getPower() - b.getPower())).limit(3).collect(Collectors.toList());
        System.out.println("武力值排行前三的武将");
        System.out.println(list.get(0) + "武力值为" + list.get(0).getPower());
        System.out.println(list.get(1) + "武力值为" + list.get(1).getPower());
        System.out.println(list.get(2) + "武力值为" + list.get(2).getPower());
        System.out.println("----------------------------------------");
        // 2. 按出生地分组
        Map<String, List<Hero>> mapByLoc = heroes.stream().collect(Collectors.groupingBy(hero -> hero.getLoc()));
        System.out.println("按出生地分组如下");
        mapByLoc.forEach((key, value) -> {
            System.out.println(key + value);
        });
        System.out.println("-------------------------------------------------");
        // 3. 找出寿命前三的武将
        List<Hero> list2 = heroes.stream().sorted((a, b) -> -((a.getDeath() - a.getBirth()) - (b.getDeath() - b.getBirth()))).collect(Collectors.toList());
        System.out.println("寿命排行前三的武将");
        System.out.println(list2.get(0) + "年龄为" + (list2.get(0).getDeath() - list2.get(0).getBirth()) + "岁");
        System.out.println(list2.get(1) + "年龄为" + (list2.get(1).getDeath() - list2.get(1).getBirth()) + "岁");
        System.out.println(list2.get(2) + "年龄为" + (list2.get(2).getDeath() - list2.get(2).getBirth()) + "岁");
        System.out.println("---------");
        // 4. 女性寿命最高的
        Optional<Hero> hero1 = heroes.stream().filter(hero -> hero.getSex().equals("女")).max((h1, h2) -> {
            {
                int age1 = h1.getDeath() - h1.getBirth();
                int age2 = h2.getDeath() - h2.getBirth();
                return age1 - age2;
            }
        });
        Hero hero = hero1.get();
        System.out.println("女性中寿命最长的是" + hero + "活了" + (hero.getDeath() - hero.getBirth()));
        System.out.println("-----------------------------------------------------");
        // 5. 找出武力排名前三  100, 99, 97 97 ==> 4个人 "吕布", "张飞", "关羽", "马超"
        int i=0;
        int num = 0;
        List<Hero> list3 = heroes.stream().sorted((a, b) -> {
            return  -(a.getPower() - b.getPower());
        }).collect(Collectors.toList());
        while (i<4){
            if(list3.get(num++) !=list3.get(num)){
                i++;
            }
        }
        List<Hero> powerList = list3.stream().limit(num).collect(Collectors.toList());
        System.out.println("找出武力排名前三  100, 99, 97 97 ==> 4个人 \"吕布\", \"张飞\", \"关羽\", \"马超\" 如下：");
        System.out.println(powerList);
        System.out.println("-----------");
        //6.按照年龄段分组 0-20 21-40 41-60 60以上
        Map<String, List<Hero>> listByAge = heroes.stream().collect(Collectors.groupingBy(hero2 -> {
            if (hero2.getAge() >= 0 && hero2.getAge() <= 20) {
                return "年龄为0-20";
            } else if (hero2.getAge() >= 21 && hero2.getAge() <= 40) {
                return "年龄为21-40";
            } else if (hero2.getAge() >= 41 && hero2.getAge() <= 60) {
                return "年龄为41-60";
            } else {
                return "年龄为60以上";
            }
        }));
        System.out.println("按照年龄段分组 0-20 21-40 41-60 60以上 如下：");
        listByAge.forEach((key, value) -> {
            System.out.println(key + "年龄段的武将为" + value);
        });

        System.out.println("--------------------------------------------------");
        //7.按照武断分组：>=90,80-89,70-79,<70
        Map<String, List<Hero>> listByPower = heroes.stream().collect(Collectors.groupingBy(hero2 -> {
            if (hero2.getPower() >= 90) {
                return "武力值在90以上的武将";
            } else if (hero2.getAge() >= 80 && hero2.getAge() <= 89) {
                return "武力值在80-89之间的武将";
            } else if (hero2.getAge() >= 70 && hero2.getAge() <= 79) {
                return "武力值在70-79之间的武将";
            } else {
                return "武力值在70以下的武将";
            }
        }));
        System.out.println("按照武断分组：>=90,80-89,70-79,<70如下:");
        listByPower.forEach((key, value) -> {
            System.out.println(key + value);
        });

        System.out.println("--------------------------------------------------");
        //7.按照出生地分组以后，统计各组人数
        HashMap<String, Integer> countMap = new HashMap<>();
        int count = 1;
        for (Map.Entry<String, List<Hero>> entry : mapByLoc.entrySet()) {
            //键相同，值覆盖
            String key = entry.getKey();
            countMap.put(key, count++);
        }
        System.out.println("按照出生地分组以后，统计各组人数:");
        countMap.forEach((key, value) -> {
            System.out.println("住在" + key + "的人数为" + value);
        });
    }
}
