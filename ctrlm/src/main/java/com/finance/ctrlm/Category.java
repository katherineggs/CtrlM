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
    static int sizeOfObjectList = 0;
    static int cont2 = 0;
    static Category objectsList [] = new Category[sizeOfObjectList];

    //Method to create the object and save it in the list
    public static void CreateObject(){

        sizeOfObjectList += categoriesList.length;
        objectsList = new Category[sizeOfObjectList];

        System.out.println("\n\n 1ER PRINT");
        for(int newObj = 0; newObj < categoriesList.length; newObj++){
            objectsList[newObj] = new Category(categoriesList[cont2]);
            cont2++;
            System.out.println(objectsList[newObj].Name);
        }


        System.out.println("\n\n 2do PRINT");
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
