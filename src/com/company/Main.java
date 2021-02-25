package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    //file in
        Path currentPath = Paths.get("Problem",args[0]).toAbsolutePath();
        System.out.println(currentPath.toString());
        File myObj = new File(currentPath.toString());
        Scanner in = null;
        try {
            in = new Scanner(myObj);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //file in over
        int D = in.nextInt(), I = in.nextInt(), S = in.nextInt(), V = in.nextInt(), F = in.nextInt();
        System.out.println(S);
        Integer[][] intersectionArray = new Integer[S+1][S+1];
        String[][] intersectionName = new String[S+1][S+1];
        for (int i = 0; i < S; i++) {
            int start = in.nextInt();
            int end = in.nextInt();
            String name = in.next();
            int length = in.nextInt();
            System.out.println(start + " " + end + " " + name + " " + length);
            intersectionArray[start][end] = 1;
            intersectionName[start][end] = name;
        }
        for (int i = 0; i < V; i++) {
            int pass = in.nextInt();
            System.out.print(pass);
            for (int j = 0; j < pass; j++) {
                String intersection = in.next();
                System.out.println(intersection);
            }
        }
        System.out.println(D + " " + I + " " + S + " " + V + " " + F);

        ArrayList<String> resultList = new ArrayList<String>();
        int count = 0;
        for (int j = 0; j <= S; j++) {
            ArrayList<String> tempStreetList = new ArrayList<String>();
            for (int i = 0; i <= S; i++) {
                //System.out.println(i);
                if ((intersectionArray[i][j]!=null)&&(intersectionArray[i][j] == 1)){
                    tempStreetList.add(intersectionName[i][j]);
                }
            }
            if (tempStreetList.size() > 0){
                count++;
                resultList.add(Integer.toString(j));
                resultList.add(Integer.toString(tempStreetList.size()));
                for (String s : tempStreetList) {
                    resultList.add(s + " 1");
                }
            }
        }

//        System.out.println("test code start");
//        System.out.println(count);
//        for (String s : resultList) {
//            System.out.println(s);
//        }
        printResultToFile(count,resultList,args[0]);

    }

    public static void printResultToFile(int totalCount,ArrayList<String> resultList, String inputFileName){
        try {
            FileWriter myWriter = new FileWriter(inputFileName+"_result.txt");
            myWriter.write(totalCount+"\n");
            for (String s : resultList) {
                myWriter.write(s+"\n");
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
