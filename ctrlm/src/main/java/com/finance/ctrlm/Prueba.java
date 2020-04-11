package com.finance.ctrlm;

import org.springframework.ui.Model;

public class Prueba {
    static class Categ{
        String name;
        Categ(String Name){
            this.name = Name;
        }
    }

    public static void addCategory(String name){
        String[] categoriesList = name.split(",");
        int size = categoriesList.length;
        Categ objectList[] = new Categ[size];
        for(int i = 0; i< size; i++){
            String using = categoriesList[i];
            objectList[i] = new Categ(using);
        }
        for(int x = 0; x < objectList.length; x++){
            System.out.println(objectList[x].name);
        }
    }
}
