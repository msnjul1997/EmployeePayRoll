package com.emppayrolltest;

import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmpPayRollTest {
    @Test
    public void checkFileExists()
    {
        File file = new File("EmpDetails.json");
        Assertions.assertTrue(file.exists());
    }
    @Test
    public void deleteThenCheckIfExists(){
        File file =  new File("TestFile.txt");
        file.delete();
        Assertions.assertTrue(file.exists());
    }
    @Test
    public void createADirectory() {
        File file =  new File("TestFolder");
        file.mkdir();
        Assertions.assertTrue(file.exists());
    }
    @Test
    public void listAllFiles() {
        String dir = "C:\\Users\\santh\\OneDrive\\Desktop\\BridgeLabz\\EmployeePayRoll";
        List<Path> pathList = new ArrayList<>();
        try {
            pathList = Files.list(Paths.get(dir))
                    .collect(Collectors.toList());
            System.out.println(pathList);
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void watchService() {
        String dir = "C:\\Users\\santh\\OneDrive\\Desktop\\BridgeLabz\\EmployeePayRoll";
        try {
            Files.list(Paths.get(dir))
                    .filter(Files::isRegularFile)
                    .forEach(n-> System.out.println(n));
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
