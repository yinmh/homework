package org.ymh.spider;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        HttpURLConnection url = (HttpURLConnection) new
                URL("https://tieba.baidu.com/p/2256306796?red_tag=1781367364").openConnection();
        InputStream in = url.getInputStream();
        int len =0;
        byte[] bytes = new byte[1024];

        while ((len=in.read(bytes))!=-1){
            String str = new String(bytes, 0, len, "utf-8");
            ArrayList<String> imgList = getSrc(str);
            ArrayList<String> list = new ArrayList<>();
            for (String s : imgList) {
                if (s.endsWith(".jpg"))
                    Download(s);
            }
        }
    }

    public static ArrayList<String> getImgList(String str) {
        ArrayList<String> list = new ArrayList<>();
        Pattern compile = Pattern.compile("<img.*src=(.*?)[^>]*?>");
        Matcher matcher = compile.matcher(str);
        while (matcher.find()) {
                list.add(matcher.group());
        }
        return list;
    }
    public static ArrayList<String> getSrc(String path){
        ArrayList<String> srcList = new ArrayList<>();
        Pattern compile = Pattern.compile("[a-zA-z]+://[^\\s]*");
        Matcher matcher = compile.matcher(path);
        while (matcher.find()) {
            srcList.add(matcher.group().substring(0,matcher.group().length() - 1));
        }
        return srcList;
    }
    private static void Download(String s) {
        int count=0;
        try {
            HttpURLConnection url = (HttpURLConnection) new
                    URL(s).openConnection();
            InputStream in = url.getInputStream();
            UUID uuid = UUID.randomUUID();
            FileOutputStream fo = new FileOutputStream(new File(uuid+".jpg"));
            byte[] buf = new byte[1024];
                int length = 0;
                System.out.println("开始下载:" + url);
                while ((length = in.read(buf)) != -1) {
                    fo.write(buf, 0, length);
                }

                in.close();
                fo.close();
                System.out.println(uuid+".jpg" + "下载完成");

        } catch (Exception e) {
            System.out.println("下载失败");
        }
    }

}