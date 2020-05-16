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

    //addCategory variables
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
        System.out.println("\n");

        model.addAttribute("categoriesList", namesList);
    }

    //CalculateExpenses variables
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
                System.out.println(objectList[search].Name + " = " + objectList[search].SpentMoney + ", Times: " + objectList[search].Times);
            }
        }

        //Expenses List to print
        expensesCount++;
        expenseTemp = expensesList;
        expensesList = new String[expensesCount];
        for (int i = 0; i < expensesList.length -1; i++){
            expensesList[i] = expenseTemp[i];
        }
        expense = category + " Q " + money;
        expensesList[index] = expense;
        index++;

        //Calculate balance
        int totalExpense = 0;
        int SubBalance = 0;
        for(int objCant = 0; objCant < objectList.length; objCant++){
            totalExpense += objectList[objCant].SpentMoney;
            SubBalance = income - totalExpense;
        }

        for(int j = 0; j < savingsList.length; j++){
            totalSavings += savingsList[j];
            Balance = SubBalance - totalSavings;
        }
        balance = "Q " + Balance;

        //Prints to see if works
        System.out.println("\nincome: " + TotalIncome);
        System.out.println("balance: " + balance);
        System.out.println("\nMost: " + mostExpend());
        System.out.println("Least: " + leastExpend());

        //--------------------- Model ------------------------
        model.addAttribute("categoriesList", namesList);
        //Income
        model.addAttribute("TotalIncome", TotalIncome);
        model.addAttribute("balance", balance);
        //Expenses
        model.addAttribute("expensesList", expensesList);
        model.addAttribute("objectList", objectList);
        //Savings
        model.addAttribute("totalSavings", totalSavings);
        model.addAttribute("savingsList", savingsList);
        //Most and Least Expenses
        model.addAttribute("mostExpend", mostExpend());
        model.addAttribute("leastExpend", leastExpend());

    }

    //Income variables
    static int income;
    public static String TotalIncome;
    static int Balance;
    public static String balance;

    public static void Incomes(int IncomeAmount){
        income = IncomeAmount;
        TotalIncome = "Q " + IncomeAmount;
    }

    //Saving variables
    static int savingAmount;
    static int savingsCount = 0;
    static int index2 = 0;
    static int[] savingsList = new int[savingAmount];
    public  static int totalSavings = 0;

    public static void Saving(int SavingAmount){
        savingAmount = SavingAmount;
        int[] savingsTemp;
        int saving;

        //Expenses List to print
        savingsCount++;
        savingsTemp = savingsList;
        savingsList = new int[savingsCount];
        for (int i = 0; i < savingsList.length -1; i++){
            savingsList[i] = savingsTemp[i];
        }
        saving = savingAmount;
        savingsList[index2] = saving;
        index2++;

        //Prints to see if works
        System.out.println("\nPrint Savings List");
        for(int i = 0; i <savingsList.length; i++){
            System.out.println(savingsList[i]);
        }
    }


    public static String mostExpend(){
        int moneyExpend = 0;
        String categoryExpend = "";
        String amount = "";
        for(int i = 0; i < objectList.length; i++){
            if(moneyExpend < objectList[i].SpentMoney){
                categoryExpend = objectList[i].Name;
                amount = Integer.toString(objectList[i].SpentMoney);

            }
        }
        return categoryExpend + " Q" + amount;
    }


    public static String leastExpend(){
        int moneyExp;
        String categoryExpend = "";
        String amount = "";
        for(int i = 0; i < objectList.length; i++){
            moneyExp = objectList[i].SpentMoney;
            for(int b =0; b < objectList.length; b++) {
                if (moneyExp > objectList[b].SpentMoney) {
                    categoryExpend = objectList[b].Name;
                    amount = Integer.toString(objectList[b].SpentMoney);
                }
                else {
                    moneyExp = objectList[b].SpentMoney;
                }
            }
        }
        return categoryExpend + " Q" + amount;
    }
}
