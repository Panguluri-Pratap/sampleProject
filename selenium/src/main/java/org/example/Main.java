package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        FileInputStream fis=  new FileInputStream("config.properties");
        Properties configProp=new Properties();
        configProp.load(fis);
        System.out.println(configProp.getProperty("browser"));
        System.out.println(configProp.getProperty("url"));
        }
    }
