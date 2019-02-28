package algorithm.my.backjun;
import java.util.Scanner;
import java.lang.Math;

public class DynamicProgramming {
    
    public void q1463BottomUp() { // bottom up
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[] dp = new int[num +1];
        for(int i=2 ; i<dp.length ; i++) { // i = 0 -> 0, i = 1 -> 0
            dp[i] = dp[i-1] + 1;
            if(i % 2 == 0) dp[i] = Math.min(dp[i], dp[i/2]+1);
            
            if(i % 3 == 0) dp[i] = Math.min(dp[i], dp[i/3]+1);
        }
        System.out.println(dp[num]);
    }
    
    public void q1463TopDown() { // top down
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        System.out.println(subTopDown(num));
    }
    
    public int subTopDown(int num) {
        int minNum = 0;
        if(num == 0 || num ==1)
            return 0;
        else {
            minNum = subTopDown(num-1)+1;
            if(num % 2 == 0)
                minNum = Math.min(minNum, subTopDown(num/2) + 1);
            if(num % 3 == 0)
                minNum = Math.min(minNum, subTopDown(num/3) + 1);
            return minNum;
        }
    }
}
