//package com.finance.ctrlm;
//
//import org.json.simple.JSONObject;
//import java.io.FileWriter;
//import java.io.IOException;
//
//public class CreateFile {
//    public static void fileCreate() {
//        //Creating a JSONObject object
//        JSONObject jsonObject = new JSONObject();
//        HashMapp<String,String> infoUser = new HashMapp<>();
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
//
//        try {
//            //"C:\\Users\\andreareyes\\Desktop\\estructuras\\CtrlM\\JSON\\file.txt"
//            //"C:\\Users\\kgrac\\Desktop\\CtrlM\\JSON\\file.txt"
//            FileWriter file = new FileWriter("C:\\Users\\andreareyes\\Desktop\\estructuras\\CtrlM\\JSON\\file.txt");
//            file.write(jsonObject.toJSONString());
//            file.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//            System.out.println("hola");
//        }
//        System.out.println("JSON file created: " + jsonObject);
//    }
//}
