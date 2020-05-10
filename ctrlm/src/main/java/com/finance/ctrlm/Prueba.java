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
    static boolean repeated;

    public static void addCategory(String name, Model model){
        repeated = false;
        String[] categoriesList = name.split(",");
        size += categoriesList.length   ;
        Category[] temp = objectList;
        objectList = new Category[size];

        //assign previous elements to objectList
        for(int i = 0; i < size - categoriesList.length; i ++) {
            if(temp[i] != null) {
                objectList[i] = new Category(temp[i].Name);
            }        }
        for(int i = 0; i < categoriesList.length; i++){
            for(int a = 0; a < temp.length; a++) {
                if(temp.length != 0 && temp[a] != null) {
                    if (categoriesList[i].equals(temp[a].Name)) {
                        repeated = true;
                    }
                } else{
                    objectList[contObj] = new Category(categoriesList[i]);
                }
            }if(!repeated){
                objectList[contObj] = new Category(categoriesList[i]);
            } else{
                contObj --;
            }
            contObj ++;
        }
        namesList = new String[objectList.length];

        for(int copy = 0; copy < objectList.length; copy++){
            if(objectList[copy] != null) {
                namesList[copy] = objectList[copy].Name;
            }
        }
        System.out.println("\nPrint objectList");
        for(int x = 0; x < objectList.length; x++){
            if(objectList[x] != null) {
                System.out.println(objectList[x].Name);
            }
        }

        System.out.println("\nPrint nameList");
        for(int y = 0; y < namesList.length; y++){
            if(namesList[y] != null) {
                System.out.println(namesList[y]);
            }
        }

        model.addAttribute("categoriesList", namesList);
    }

    static int expensesCount = 0;
    static int index = 0;
    static int lastMoneyValue;
    static int totalMoneyValue;
    static int timesCounter;
    static String[] expensesList = new String[expensesCount];
    public static void CalculateExpenses(String category, int money, Model model){
        String[] expenseTemp;
        String expense;

        for(int search = 0; search < objectList.length; search++){
            if(objectList[search] != null) {
                if (objectList[search].Name.equals(category)) {
                    lastMoneyValue = objectList[search].SpentMoney;
                    totalMoneyValue = lastMoneyValue + money;
                    objectList[search].SpentMoney = totalMoneyValue;

                    timesCounter = objectList[search].Times;
                    timesCounter++;
                    objectList[search].Times = timesCounter;
                }
                System.out.println("\n" + objectList[search].Name + " = " + objectList[search].SpentMoney + ", Times: " + objectList[search].Times);
            }
        }

        expensesCount++;
        expenseTemp = expensesList;
        expensesList = new String[expensesCount];
        for (int i = 0; i < expensesList.length -1; i++){
            expensesList[i] = expenseTemp[i];
        }
        expense = category + " Q" + money;
        expensesList[index] = expense;
        index++;

        System.out.println("--------------------------------------");

        model.addAttribute("expensesList", expensesList);
        model.addAttribute("categoriesList", namesList);
        model.addAttribute("objectList", objectList);
    }


    public static int TotalIncome;
    static int Balance;
    public static void Incomes(int IncomeAmount, Model model){
        TotalIncome = IncomeAmount;
        Balance = IncomeAmount - lastMoneyValue;

        System.out.println("income: " + TotalIncome);
        System.out.println("Balance: " + Balance);

        model.addAttribute("TotalIncome", TotalIncome);
        model.addAttribute("Balance", Balance);
    }

}
