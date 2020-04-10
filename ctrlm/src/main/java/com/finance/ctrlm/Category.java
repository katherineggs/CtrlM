package com.finance.ctrlm;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import org.springframework.ui.Model;

public class Category {
    //Attributes
    static String Name;
    static int Times;
    static int SpentMoney;

    //Constructor
    Category(String name){
        this.Name = name;

    }

    public  static void setName(String name){
        Name = name;
    }

    //List to save the categories entered
    static int size = 0;
    static int cont = 0;
    static String categoriesList [] = new String[size];


    //Method to add the categories to the list
    public static void addCategory(String name, Model model){
        Boolean firstRound = true;
        String[] temp = categoriesList;
        String[] NewCategory = name.split(",");
        size += NewCategory.length;
        categoriesList = new String[size];

        for(int i = 0; i < size - NewCategory.length; i ++) {
            categoriesList[i] = temp[i];
        }
        for(int iN = 0; iN < NewCategory.length; iN++) {
            for(int a = 0; a <NewCategory.length; a++){
                if(temp.length != 0){
                    if(!NewCategory[iN].equals(temp[a])) {
                        categoriesList[cont] = NewCategory[iN];
                    }
                    else{
                        cont --;
                    }
                } else{
                    categoriesList[cont] = NewCategory[iN];
                }
            }
            cont ++;
        }
        model.addAttribute("categoriesList", categoriesList);
    }

    //List to save the created objects (categories)
    static int cont2 = 0;
    static Category objectsList [] = new Category[cont2];

    //Method to create the object and save it in the list
    public static void CreateObject(){

        System.out.println("\n\n PRINT categoriesList");
        for(int x = 0; x < categoriesList.length; x++){
            System.out.println(categoriesList[x]);
        }

        String temporal [] = categoriesList;

        System.out.println("\n\n PRINT temporal");
        for(int y = 0; y < temporal.length; y++){
            System.out.println(temporal[y]);
        }

        System.out.println("\n\n 1ER PRINT");
        for(int newObj = 0; newObj < categoriesList.length; newObj++){
            cont2++;
            objectsList = new Category[cont2];
            objectsList[newObj] = new Category(temporal[newObj]);

            System.out.println(objectsList[newObj].Name);
            
        }


        System.out.println("\n\n PRINT objectList");
        for(int x = 0; x < objectsList.length; x++){
            System.out.println(objectsList[x].Name);
        }

    }


    //Method to assign values to the object

    //Method to assign amounts (to the object)
    public static void CalculateExpenses(int Times, int SpentMoney){
        int TimesCounter;
        int MoneyCounter;



    }



}
