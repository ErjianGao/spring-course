package com.example.springhelloworld.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtilsTest {
    @Test
    public void test_getSize_nofile() {
        // 此处要注意，老师给出的代码中已经捕获了IOException，并且抛出RuntimeException，所以预期应该是RuntimeException
        Assertions.assertThrows(RuntimeException.class, () -> {
            Path path = Paths.get("e:\\nofile.txt");
            FileUtils.getSize(path);
        });
    }

    @Test
    public void test_getSize() {
        Path path = Paths.get("e:\\abc.txt");
        Assertions.assertEquals(0, FileUtils.getSize(path));
    }
}
