package algorithm.my.sort;

import java.util.ArrayList;

public class MyPermutation {
    
    public MyPermutation(){
        System.out.println("open constructor");
    }
    
    public static void permutation() {
        int[] arr = {1,2,3,4};
        int n = arr.length;
        subPermutation(arr, n);
    }
    
    public static void subPermutation(int[] arr, int n) { 
        if(n == 1){
            for(int i=0; i<arr.length ; i++) {
                if(i<arr.length-1){
                    System.out.print(arr[i]+", ");    
                }else {
                    System.out.println(arr[i]);
                }
            }
            return;
        }
        else {
            for(int i=0 ; i<n ; i++) {
             swap(arr, i, n-1);
             subPermutation(arr,n-1);
             swap(arr, i, n-1); 
            }
        }
    }
    
    public static void swap(int[] arr, int i,int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
