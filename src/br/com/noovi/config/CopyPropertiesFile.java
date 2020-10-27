package br.com.noovi.config;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CopyPropertiesFile {

    public static String getDays() throws IOException {
        String days = "" ;
        Properties prop = new Properties();
            FileInputStream file = new FileInputStream("C:\\Win32App\\Betta\\app.properties");
            if(file != null){
                prop.load(file);
                days = prop.getProperty("prop.file.days");
            }else{
                System.out.println(" Arquivo de configuracao nao foi criado ou nao esta no diretorio correto ");
            }
            return days;
    }

    public static String getPath() throws IOException {
        String path ="";
        Properties prop = new Properties();
        FileInputStream file = new FileInputStream("C:\\Win32App\\Betta\\app.properties");
        if(file != null){
            prop.load(file);
            path = prop.getProperty("prop.file.pathfile");
        }else{
            System.out.println(" Arquivo de configuracao nao foi criado ou nao esta no diretorio correto ");
        }
        return path;
    }
}
