package com.example.algovisualizer;

import java.util.Random;

public class DataUtils {

    public static int[] createRandomArray(int size) {
        Random random = new Random();

            int n = size;
            int[] arr =new int[n];
            for(int i=0;i<n;i++)
            {
                arr[i] = random.nextInt(21);
            }
            return arr;

    }
}
