package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    //file in
        Path currentPath = Paths.get("Problem",args[0]).toAbsolutePath();
        System.out.println(currentPath.toString());
        File myObj = new File(currentPath.toString());
        Scanner in = null;

        //Initialize Cars
        ArrayList<Car> cars = new ArrayList();

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

            //Set up streets info for each cars
            String streets[] = new String[pass-1];

            for (int j = 0; j < pass; j++) {
                String intersection = in.next();

                // The first street is ignored
                if (j != 0) {
                    streets[j-1] = intersection;
                }

                System.out.println(intersection);
            }
            cars.add(new Car(streets));
        }
        System.out.println(D + " " + I + " " + S + " " + V + " " + F);

        //模拟算法
        HashMap<String, Integer> roadStatus = new HashMap<>();

        // Skip the first sec since nothing happen when sec = 0
        for (int sec = 1; sec < D; sec++) {

        }


    }


}
