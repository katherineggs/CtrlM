package com.finance.ctrlm;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class CreateFile {
    public static void fileCreate() {
        //Creating a JSONObject object
        JSONObject jsonObject = new JSONObject();
        Map infoUser = new LinkedHashMap();
        infoUser.put("Name", "Andrea");
        infoUser.put("Income", Prueba.TotalIncome);
        for(int i = 0; i < Prueba.objectList.length; i ++){
            Map infoCategory = new LinkedHashMap();
            infoCategory.put("categoryName"+(i+1),Prueba.objectList[i].Name);
            infoCategory.put("Money Spent"+(i+1), Prueba.objectList[i].SpentMoney);
            infoUser.put("Category"+(i+1), infoCategory);
        }
        //Inserting key-value pairs into the json object
        jsonObject.put("User1", infoUser);

        try {
            FileWriter file = new FileWriter("C:\\Users\\kgrac\\Desktop\\CtrlM\\JSON\\file.txt");
            file.write(jsonObject.toJSONString());
            file.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("JSON file created: "+jsonObject);
    }
}
