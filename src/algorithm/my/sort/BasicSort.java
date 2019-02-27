package algorithm.my.sort;
import java.util.Arrays;

public class BasicSort {
    public void bubbleSort(){
        int[] arr = {9,5,1,6,2};
        System.out.println("before "+Arrays.toString(arr));
        for(int i=0 ; i<arr.length-1 ; i++) { // rotation num
            for(int j=0 ; j<arr.length-i-1 ; j++) {
                if(arr[j]>arr[j+1]) { //swap
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }                    
            }
        }
        System.out.println("after bubbleSort " + Arrays.toString(arr));
    }
    
    public void selectionSort() {
        int[] arr = {9,5,1,6,2};
        System.out.println("before "+Arrays.toString(arr));
        
        for(int i=0; i<arr.length-1 ; i++) {
            int pointer = i;
            for(int j=i+1 ; j<arr.length ; j++) {
                if(arr[pointer] > arr[j]){ //swap
                    pointer = j;
                }
            }
            int temp = arr[pointer];
            arr[pointer] = arr[i];
            arr[i] = temp;
        }
        
        System.out.println("after selectionSort " + Arrays.toString(arr));
    }
    
    public void insertionSort() {
        int[] arr = {9,5,1,6,2};
        
        System.out.println("before"+Arrays.toString(arr));
        for(int i=1; i<arr.length ; i++) {
            int pointer = i;
            int currentNum = arr[i];
            for(int j=i-1 ; j>-1 ; j--) {
                if(currentNum < arr[j]) {  //** currentNum
                    pointer = j;
                }else
                    break; //** important
            }
            int temp = arr[pointer];
            arr[pointer] = arr[i];
            arr[i] = temp;
        }
                System.out.println("after insertionSort " + Arrays.toString(arr));
    }
}
