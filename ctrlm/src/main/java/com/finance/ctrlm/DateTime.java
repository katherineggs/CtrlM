package com.finance.ctrlm;

import java.io.IOException;

//import weka.classifiers.Classifier;
//import weka.classifiers.Evaluation;
//import weka.core.*;
//import weka.core.converters.ArffLoader;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class DateTime{
    // Date and Time
    public static String ZonedTimeAndDate() {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter form =DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String currentDate = date.format(form);
        System.out.println(currentDate);

        return currentDate;
    }
    public static String yesterday(){
        LocalDate today = LocalDate.now();
        LocalDate yesterday = today.minus(1, ChronoUnit.DAYS);
        DateTimeFormatter form =DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String yesterdayDate = yesterday.format(form);
        return yesterdayDate;

    }
//    static int[] data = {100, 20, 30, 115, 80, 17, 112};
//    static int[] dates = {1,2,3,4,5,6,7};
//    public static Instances getData ()throws IOException{
//        int numData = data.length;//7
//        int numDates = dates.length;//7
//        String[] nameAtts = {"Date","Data"};
//        ArrayList<weka.core.Attribute> attributes = new ArrayList<>();
//        ArrayList<Integer> instances = new ArrayList<>();
//        for(int i = 0; i < data.length; i++){
//            instances.add(data[i]);
//        }
//        attributes.add(new weka.core.Attribute(nameAtts[0], numDates));
//        attributes.add(new weka.core.Attribute(nameAtts[1], numData));
//
//        Instances dataRaw = new Instances("Amount: date",attributes,0);
//        double[] instVal = new double[numData];
//
//        for(int i = 0; i < dataRaw.numAttributes(); i++){
//            instVal[i] = dataRaw.attribute(0).addStringValue(Integer.toString(dates[i]));
//        }
//        dataRaw.add(new DenseInstance(1.0, instVal));
////        for(int i = 0; i < nameAtts.length; i++) {
////            weka.core.Attribute actual = new weka.core.Attribute(nameAtts[i], i);
////            if(i == 0) {
////                for(int obj = 0; obj < numData; obj++) {
////                    instances.add(new SparseInstance(2));//weight to one, all values missing, reference to dataset null.
////                }
////            }
////            for(int sec = 0; sec < numDates; sec++) {
////                if(nameAtts[i].equals(nameAtts[0])) {
////                    instances.get(sec).setValue(actual, dates[sec]);
////                }
////                else {
////                    instances.get(sec).setValue(actual, data[sec]);
////                }
////            }attributes.add(actual);
////        }
////        Instances newDataset = new Instances("Dataset", attributes, instances.size());
////        for(Instance i : instances) {
////            newDataset.add(i);
////        }
//        return dataRaw;
//    }
//
//    public static void LinearRegression ()throws Exception{ //learning from the expenses record
//        Instances data = getData();
//        data.setClassIndex(data.numAttributes() - 1);
//        System.out.println(data.toString());
//        Classifier classify = new weka.classifiers.functions.LinearRegression();
//        classify.buildClassifier(data);
//        Evaluation evaluate = new Evaluation(data);
//        evaluate.evaluateModel(classify,data);
//        System.out.println("\n");
//        System.out.println(evaluate.toSummaryString());
//    }
}