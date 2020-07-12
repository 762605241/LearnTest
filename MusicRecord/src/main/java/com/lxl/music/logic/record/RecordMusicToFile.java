package com.lxl.music.logic.record;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class RecordMusicToFile {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        File file = new File("C:\\Users\\76260\\Desktop\\音乐.txt");
        Scanner scanner = new Scanner(System.in);
        HashSet<String> musicSet = new HashSet<String>();
        String temp = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while (null != (temp = reader.readLine())) {
                musicSet.add(temp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("已记录歌曲：");
        System.out.println("============================================================");
        musicSet.stream().forEach(x -> System.out.println(x));
        System.out.println("============================================================");
        while (true) {
            System.out.println("请输入：");
            temp = scanner.nextLine();
            if (musicSet.contains(temp)) {
                System.out.println("已存在");
            } else {
                musicSet.add(temp);
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
                    writer.write(temp);
                    writer.newLine();
                    writer.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("添加成功");
            }
        }
    }
}
