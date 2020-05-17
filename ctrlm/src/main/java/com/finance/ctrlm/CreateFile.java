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

        //Creating with JSONObject object
//        JSONObject UserInfo = new JSONObject();
//        JSONObject CategoriesInfo = new JSONObject();
//        UserInfo.put("Name", App.userName);
//        UserInfo.put("Income", Prueba.income);
//        UserInfo.put("SavingGoal", Prueba.savingAmount);
//        UserInfo.put("TotalSavings", Prueba.totalSavings);
//        for(int i = 0; i < Prueba.objectList.length; i++){
//            CategoriesInfo.put("CategoryName" + (i+1), Prueba.objectList[i].Name);
//            CategoriesInfo.put("Times" + (i+1), Prueba.objectList[i].Times);
//            CategoriesInfo.put("SpentMoney" + (i+1), Prueba.objectList[i].SpentMoney);
//        }
//        UserInfo.put("Categories", CategoriesInfo);

        try {
            String name = DateTime.ZonedTimeAndDate()+".json";
            FileWriter file = new FileWriter("\\C:\\Users\\kgrac\\Desktop\\CtrlM\\JSON\\"+name);
            file.write(jsonObject.toJSONString());
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("JSON file created: " + jsonObject);
    }



    public static void readJson(String fileName){
        JSONParser parser = new JSONParser();
        try{
//            String Name = infoUser.Get("Name");
//            System.out.println(Name);

            Object obj = parser.parse(new FileReader(fileName));
            JSONObject jsonObject = (JSONObject) obj;

            String User1 = (String) jsonObject.get("User1");
            System.out.println("Data Json: " + User1);
            String keyValueT = User1.replaceAll(",",":");
            String[] keyValue = keyValueT.split(":");
            int length = Math.floorDiv(keyValue.length,2);
            String[] Key = new String[length];
            String[] Value = new String[length];
            for(int i = 1; i < (keyValue.length-1); i = i + 2) {
                if(Key[i].startsWith("{") || Value[i].startsWith("{")){
                    i--;
                }
                else {
                    Key[i] = keyValue[i];
                    Value[i] = keyValue[i + 1];
                    System.out.println(Key[i] + ": " + Value[i]);
                }
            }

////            // recorrer arreglo
////            JSONArray leng= (JSONArray) jsonObject.get("lenguajes_favoritos");
////            System.out.println("lenguajes_favoritos:");
////            Iterator iterator =leng.iterator();
////            while (iterator.hasNext()) {
////                System.out.println(iterator.next());
////            }
        }catch(Exception ex){
            System.err.println("Error: "+ex.toString());
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
