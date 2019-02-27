package algorithm.my.backjun;

import java.util.Scanner;
import java.util.ArrayList;
public class PrintStar {
    public void printStar() {//10991
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
        for(int i=0 ; i<n ; i++) {
            for(int j=0; j<i+n ; j++) {
               if(j>=n-i-1) {
                   if((j-n+i+1) % 2 == 0)
                       System.out.print("*");
                   else
                       System.out.print(" ");
               }else {
                   System.out.print(" ");
               }
            }
            System.out.println();
        } 
    }
    
    public void printStar2() {//10992
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
        int num1 = n-1;
        int num2 = n-1;
        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<n*2-1 ; j++) {
                if(i < n-1) {
                    if(j == num1 || j == num2) {
                        System.out.print("*");
                        if(j == num2){
                            System.out.print(" ");
                            break;
                        }
                    }else {
                        System.out.print(" ");
                    }
                }else {
                    System.out.print("*");
                }
            }

            if(i < n-1){
                System.out.println();
                num1--;
                num2++;
                for(int j=0 ; j<=num2+1 ; j++){
                    System.out.print(" ");
                }
                System.out.println();

            }
        }
    }

}
