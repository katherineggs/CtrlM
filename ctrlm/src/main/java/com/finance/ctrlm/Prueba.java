package com.finance.ctrlm;

import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class Prueba {
    static class Category{
        //Attributes
        public String Name;
        public int Times;
        public int SpentMoney;

        //Constructor
        Category(String Name){
            this.Name = Name;
        }
    }

    static int size = 0;
    static int contObj = 0;
    static int contNames = 0;
    static Category objectList[] = new Category[size];
    static String[] namesList = new String[objectList.length];

    public static void addCategory(String name, Model model){
        String[] categoriesList = name.split(",");
        size += categoriesList.length;
        Category[] temp = objectList;
        objectList = new Category[size];

        for(int i = 0; i < size - categoriesList.length; i ++) {
            objectList[i] = new Category(temp[i].Name);
        }
        for(int i = 0; i < categoriesList.length; i++){
            for(int a = 0; a < categoriesList.length; a++){
                if(temp.length != 0){
                    if(!categoriesList[i].equals(temp[a].Name)) {
                        objectList[contObj] = new Category(categoriesList[i]);

                    } else{
                        contObj = contObj - 2;
                    }
                } else{
                    objectList[contObj] = new Category(categoriesList[i]);
                }
            }contObj ++;
        }
        namesList = new String[objectList.length];

        for(int copy = 0; copy < objectList.length; copy++){
            namesList[copy] = objectList[copy].Name;
        }

        System.out.println("\nPrint objectList");
        for(int x = 0; x < objectList.length; x++){
            System.out.println(objectList[x].Name);
        }

        System.out.println("\nPrint nameList");
        for(int y = 0; y < namesList.length; y++){
            System.out.println(namesList[y]);
        }

        model.addAttribute("categoriesList", namesList);
    }


    public static void CalculateExpenses(String category, int money, Model model){
        int lastMoneyValue;
        int totalMoneyValue;
        int TimesCounter;

        for(int search = 0; search < objectList.length; search++){
            if(objectList[search].Name.equals(category)){
                lastMoneyValue = objectList[search].SpentMoney;
                totalMoneyValue = lastMoneyValue + money;
                objectList[search].SpentMoney = totalMoneyValue;

                TimesCounter = objectList[search].Times;
                TimesCounter++;
                objectList[search].Times = TimesCounter;


            }
            System.out.println("\n" + objectList[search].Name + " = " + objectList[search].SpentMoney + ", Times: " + objectList[search].Times);

        }
        System.out.println("--------------------------------------");

        model.addAttribute("categoriesList", namesList);
        model.addAttribute("objectList", objectList);
    }

}
