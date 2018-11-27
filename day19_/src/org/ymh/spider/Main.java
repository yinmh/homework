package org.ymh.spider;

import java.io.*;
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
        BufferedReader r = new BufferedReader(new InputStreamReader(in));
        String line =null;
        StringBuffer sb = new StringBuffer();
        while ((line=r.readLine())!=null){
            sb.append(line);
        }
        ArrayList<String> imgList = getSrc(sb.toString());
        for (String s : imgList) {
            if (s.endsWith(".jpg")) {
                String[] split = s.split("src=\"");
                Download(split[1]);

            }
        }
    }

    public static ArrayList<String> getSrc(String html){
        ArrayList<String> srcList = new ArrayList<>();
        Pattern compile = Pattern.compile("<img class=\"BDE_Image\" src=\"(.*?)\"");
        Matcher matcher = compile.matcher(html);
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