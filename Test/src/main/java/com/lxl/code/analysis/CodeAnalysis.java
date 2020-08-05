package com.lxl.code.analysis;

import java.io.*;

/**
 * @author 刘晓亮
 * @date 2020/8/4 16:26
 */
public class CodeAnalysis {

    // 有效代码行数
    int code = 0;
    // 注释行数
    int notes = 0;
    // 空行数
    int emptyLine = 0;
    // 总行数
    int totle = 0;

    public void codeAnalysis(File file) {
        if (file == null) {
            return;
        }
        if (!file.isDirectory()) {
            // 如果是文件
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
                String lineStr = null;
                boolean isMultiNote = false;
                while ((lineStr = bufferedReader.readLine()) != null) {
                    // 总行数
                    this.totle++;
                    if ("".equals(lineStr)) {
                        // 空行数
                        this.emptyLine++;
                        continue;
                    }
                    if (lineStr.startsWith("/*")) {
                        this.notes++;
                        if (!isMultiNote) {
                            isMultiNote = true;
                        }
                    }
                    if (lineStr.startsWith("//")) {

                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            // 如果是文件夹
            File[] files = file.listFiles();
            for (File f : files) {
                // 递归统计
                codeAnalysis(f);
            }
        }
    }

    public static void main(String[] args) {
        CodeAnalysis codeAnalysis = new CodeAnalysis();
        File file = new File("C:\\Users\\76260\\Desktop\\code");
        codeAnalysis.codeAnalysis(file);
        System.out.println("总行数：" + codeAnalysis.totle);
        System.out.println("有效代码行数：" + codeAnalysis.code);
        System.out.println("注释行数：" + codeAnalysis.notes);
        System.out.println("空行数：" + codeAnalysis.emptyLine);
    }
}
