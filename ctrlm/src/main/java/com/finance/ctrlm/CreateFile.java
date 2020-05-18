package com.finance.ctrlm;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.awt.print.PrinterException;
import java.io.*;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.naming.Name;

public class CreateFile {
    static HashMapp<String,String> infoUser = new HashMapp<>();
    static JSONObject jsonObject = new JSONObject();
    static HashMapp<String,String> infoCategory = new HashMapp<>();
    public static void fileCreate() {
        infoUser.Put("Name", App.userName);
        infoUser.Put("Income", (Prueba.TotalIncome));
        infoUser.Put("Saving Goal",Integer.toString(Prueba.savingAmount));
        infoUser.Put("Total Savings", Integer.toString(Prueba.totalSavings));
        for(int i = 0; i < Prueba.objectList.length; i ++){
            infoCategory.Put("Category Name "+(i+1),Prueba.objectList[i].Name);
            infoCategory.Put("Money Spent "+(i+1), Integer.toString(Prueba.objectList[i].SpentMoney));
            infoCategory.Put("Times Spent " +(i+1), Integer.toString(Prueba.objectList[i].Times));
        }
        infoUser.Put("Categories", infoCategory.toString());
        jsonObject.put("User1", infoUser.toString());

        try {
            String name = DateTime.ZonedTimeAndDate()+".json";
            String path = File.separator+"Users"+File.separator+"andreareyes"+File.separator+"Desktop"+File.separator+"estructuras"+File.separator+"CtrlM"+File.separator+"JSON/";
            FileWriter file = new FileWriter(path+"/"+name);
            file.write(jsonObject.toJSONString());
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("JSON file created: " + jsonObject);
    }

    public static HashMapp readJson(String fileName){
        JSONParser parser = new JSONParser();
        try{
            Object obj = parser.parse(new FileReader(fileName));
            JSONObject jsonObject = (JSONObject) obj;

            String User1 = (String) jsonObject.get("User1");
            System.out.println("Data Json: " + User1);
            String keyValueT = User1.replaceAll(",",":");
            String KV = keyValueT.substring(1);
            String[] keyValue = KV.split(":");

            int length = (keyValue.length);
            String[] Key = new String[length];
            String[] Value = new String[length];
            int position = 0;
            for(int i = 0; i < (keyValue.length-1); i = i + 2) {
                if(keyValue[i+1].startsWith(" {") || keyValue[i].equals(" ") || keyValue[i].startsWith(" }") || keyValue[i+1].startsWith(" [")){
                    if(keyValue[i+1].startsWith(" [")){
                        Key[position] = keyValue[i];
                        Value[position] = keyValue[i + 1] + keyValue[i+2];
                    }
                    else {
                        Key[position] = keyValue[i];
                        i--;
                        Value[position] = keyValue[i + 1];
                    }
                } else {
                    Key[position] = keyValue[i];
                    Value[position] = keyValue[i + 1];
                }
                position++;
            }
            HashMapp user = new HashMapp();
            for (int i = 0; i < Key.length; i++){
                if( !Key[i].startsWith(" }") || !Key[i].startsWith(" ")) {
                    user.Put(Key[i], Value[i]);
                    System.out.println(Key[i] + ": " + Value[i]);
                }
            }
            return user;
        }catch(Exception ex){
            System.err.println("Errorr: "+ex.toString());
            return null;
        }
    }

    public static String lastModified(String path){
        java.io.File directory = new java.io.File(path);
        java.io.File[] allFiles = directory.listFiles(java.io.File::isFile);
        long lastModifiedTime = Long.MIN_VALUE;
        java.io.File chosenFile = null;

        if(allFiles != null){
            for (java.io.File file : allFiles){
                if(file.lastModified() > lastModifiedTime){
                    chosenFile = file;
                    lastModifiedTime = file.lastModified();
                }
            }
        }
        String name = chosenFile.getName();
        return  name;
    }

}
