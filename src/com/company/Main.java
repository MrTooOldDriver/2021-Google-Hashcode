package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
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
        int D = in.nextInt(), I = in.nextInt(), S = in.nextInt(), V = in.nextInt(), F = in.nextInt();
        for (int i = 0; i < S; i++) {
            int start = in.nextInt();
            int end = in.nextInt();
            String name = in.next();
            int length = in.nextInt();
            System.out.println(start + " " + end + " " + name + " " + length);
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


    }


}
