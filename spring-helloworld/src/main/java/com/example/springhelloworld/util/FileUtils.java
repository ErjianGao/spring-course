package com.example.springhelloworld.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileUtils {
    /**
     * 获取指定文件大小
     * @param path
     * @return
     */
    public static long getSize(Path path) {
        try {
            return Files.size(path);
        } catch (IOException e) {
            throw new RuntimeException("操作错误！无法对指定文件执行操作");
        }
    }
}

