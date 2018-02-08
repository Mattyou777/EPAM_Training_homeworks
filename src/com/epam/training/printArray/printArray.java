package com.epam.training.printArray;

import java.util.ArrayList;

/**
 * Created by Matt on 08.02.2018.
 */
public class printArray {
    //prints from the top left corner clockwise
    public static void print(int [][] arr){
        int mini=0;
        int minj=-1;
        int maxi=arr.length-1;
        int maxj=arr[0].length-1;
        int size=arr.length*arr[0].length;
        ArrayList list = new ArrayList(arr.length*arr[0].length);
        main:
        while (size!=0){
            for (int j=++minj;j<=maxj;j++){
                list.add(arr[mini][j] + " ");
                if(list.size()==size)
                    break main;
            }
            for (int i=++mini;i<=maxi;i++){
                list.add(arr[i][maxj] + " ");
                if(list.size()==size)
                    break main;
            }
            for (int j=--maxj;j>=minj;j--){
                list.add(arr[maxi][j] + " ");
                if(list.size()==size)
                    break main;
            }
            for (int i=--maxi;i>=mini;i--) {
                list.add(arr[i][minj] + " ");
                if(list.size()==size)
                    break main;
            }
        }
        list.forEach(System.out::print);

    }
//prints from the top right corner counterclockwise
    public static void printRev(int [][] arr){
        int mini=0;
        int minj=0;
        int maxi=arr.length-1;
        int maxj=arr[0].length;
        int size=arr.length*arr[0].length;
        ArrayList list = new ArrayList(arr.length*arr[0].length);
        main:
        while (size!=0){
            for (int j=--maxj;j>=minj;j--){
                list.add(arr[mini][j] + " ");
                if(list.size()==size)
                    break main;
            }
            for (int i=++mini;i<=maxi;i++){
                list.add(arr[i][minj] + " ");
                if(list.size()==size)
                    break main;
            }
            for (int j=++minj;j<=maxj;j++){
                list.add(arr[maxi][j] + " ");
                if(list.size()==size)
                    break main;
            }
            for (int i=--maxi;i>=mini;i--) {
                list.add(arr[i][maxj] + " ");
                if(list.size()==size)
                    break main;
            }
        }
        list.forEach(System.out::print);

    }

    public static void main(String[] args) {
        int[][] matrixB = {
                {1,4,5},
                {2,5,2}
        };
        print(matrixB);
    }
}
