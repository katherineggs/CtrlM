package com.finance.ctrlm;

import org.apache.tomcat.jni.File;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.awt.print.PrinterException;
import java.io.*;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.naming.Name;

public class CreateFile {
    static HashMapp<String,String> infoUser = new HashMapp<>();
    static JSONObject UserInfo = new JSONObject();
    static JSONObject CategoriesInfo = new JSONObject();
    public static void fileCreate() {
        //Creating a JSONObject object
        UserInfo.put("Name", App.userName);
        UserInfo.put("Income", Prueba.income);
        UserInfo.put("SavingGoal", Prueba.savingAmount);
        UserInfo.put("TotalSavings", Prueba.totalSavings);

        for(int i = 0; i < Prueba.objectList.length; i++){
            CategoriesInfo.put("CategoryName" + (i+1), Prueba.objectList[i].Name);
            CategoriesInfo.put("Times" + (i+1), Prueba.objectList[i].Times);
            CategoriesInfo.put("SpentMoney" + (i+1), Prueba.objectList[i].SpentMoney);
        }
        UserInfo.put("Categories", CategoriesInfo);


//        infoUser.Put("Name", App.userName);
//        infoUser.Put("Income", (Prueba.TotalIncome));
//        infoUser.Put("Saving Goal",Integer.toString(Prueba.savingAmount));
//        infoUser.Put("Total Savings", Integer.toString(Prueba.totalSavings));
//        for(int i = 0; i < Prueba.objectList.length; i ++){
//            HashMapp<String,String> infoCategory = new HashMapp<>();//removable
//            infoCategory.Put("Category Name "+(i+1),Prueba.objectList[i].Name);
//            infoCategory.Put("Money Spent "+(i+1), Integer.toString(Prueba.objectList[i].SpentMoney));
//            infoCategory.Put("Times Spent " +(i+1), Integer.toString(Prueba.objectList[i].Times));
//            infoUser.Put("Category"+(i+1), infoCategory.toString());//removable
//        }
//
//        jsonObject.put("User1", infoUser.toString());

        try {
            FileWriter file = new FileWriter("C:\\Users\\andreareyes\\Desktop\\estructuras\\CtrlM\\JSON\\user1.json");
            file.write(UserInfo.toJSONString());
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("JSON file created: " + UserInfo);
    }



    public static void readJson(){
        JSONParser parser = new JSONParser();
        try{
//            String Name = infoUser.Get("Name");
//            System.out.println(Name);


            Object obj = parser.parse(new FileReader("C:\\Users\\andreareyes\\Desktop\\estructuras\\CtrlM\\JSON\\file.json"));

            JSONObject jsonObject = (JSONObject) obj;
            String Name = (String) UserInfo.get("Name");
            System.out.println("Data Json: " + Name);

//            // recorrer arreglo
//            JSONArray leng= (JSONArray) jsonObject.get("lenguajes_favoritos");
//            System.out.println("lenguajes_favoritos:");
//            Iterator iterator =leng.iterator();
//            while (iterator.hasNext()) {
//                System.out.println(iterator.next());
//            }

        }catch(Exception ex){
            System.err.println("Error: "+ex.toString());
        }finally{

        }
    }

}
