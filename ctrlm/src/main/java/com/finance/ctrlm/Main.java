package com.finance.ctrlm;

import org.springframework.ui.Model;

import java.util.Arrays;

public class Main {

    //List with created objects (categories)
    static int size = 0;
    static int cont = 0;
    static Category objectsList [] = new Category[size];

    //static Category objectsList [] = Arrays.copyOf(Category.categoriesList,Category.categoriesList.length,Category[].class);



    //Method to add a new category and create the object
    public static void NewCategory(String name, Model model){
        Category.addCategory(name, model);

        Category temp[] = objectsList;
        size += Category.categoriesList.length;
        objectsList = new Category[size];

        for(int i = 0; i < size - Category.categoriesList.length; i++){
            objectsList[i] = temp[i];

        }

        for(int j = 0; j < objectsList.length ; j++){
            objectsList[j] = new Category(Category.categoriesList[cont]);
            cont++;
            System.out.println(objectsList[j].Name);
        }


        //IMPRIME (SOLO PARA VER SI FUNCIONA)
        System.out.println("\n\naqui empieza el segundo print");
        for(int x = 0; x < objectsList.length; x++){
            System.out.println(objectsList[x].Name);
        }

    }



    //Method to assign amounts (to the object)
    public static void CalculateExpenses(int Times, int SpentMoney){
        int TimesCounter;
        int MoneyCounter;



    }

    //Method to assign values to the object


}
