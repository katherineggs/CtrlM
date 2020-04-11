package com.finance.ctrlm;

import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

public class Prueba {
    static class Categ{
        String name;
        Categ(String Name){
            this.name = Name;
        }
    }
    static int size = 0;
    static int contObj = 0;
    static int contNames = 0;
    static Categ objectList[] = new Categ[size];

    public static void addCategory(String name, Model model){
        String[] categoriesList = name.split(",");
        size += categoriesList.length;
        Categ[] temp = objectList;
        objectList = new Categ[size];
        String[] namesList = new String[objectList.length];

        for(int i = 0; i < size - categoriesList.length; i ++) {
            objectList[i] = new Categ(temp[i].name);
        }
        for(int i = 0; i < categoriesList.length; i++){
            for(int a = 0; a < categoriesList.length; a++){
                if(temp.length != 0){
                    if(!categoriesList[i].equals(temp[a].name)) {
                        objectList[contObj] = new Categ(categoriesList[i]);

                    } else{
                        contObj = contObj - 2;
                    }
                } else{
                    objectList[contObj] = new Categ(categoriesList[i]);
                }
            }contObj ++;
        }
        System.out.println("\nPrint");
        for(int x = 0; x < objectList.length; x++){
            System.out.println(objectList[x].name);
        }

        model.addAttribute("categoriesList", namesList);
    }
}
