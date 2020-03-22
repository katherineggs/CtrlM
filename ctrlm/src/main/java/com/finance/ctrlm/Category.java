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
            categoriesList[cont] = NewCategory[iN];
            cont++;
        }
        model.addAttribute("categoriesList", categoriesList);
    }

    //List to save the created objects (categories)
    static int sizeOfObjectList = 0;
    static int cont2 = 0;
    static Category objectsList [] = new Category[sizeOfObjectList];

    //static Category objectsList [] = Arrays.copyOf(Category.categoriesList,Category.categoriesList.length,Category[].class);

    //Method to create the object and save it in the list
    public static void CreateObject(){

        Category tempObjects[] = objectsList;
        sizeOfObjectList += categoriesList.length;
        objectsList = new Category[sizeOfObjectList];

        for(int i = 0; i < sizeOfObjectList - categoriesList.length; i++){
            objectsList[i] = tempObjects[i];

        }

        for(int j = 0; j < objectsList.length ; j++){
            objectsList[j] = new Category(categoriesList[j]);
            System.out.println(objectsList[j].Name);
        }


        //IMPRIME (SOLO PARA VER SI FUNCIONA)
        System.out.println("\n\naqui empieza el segundo print");
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
