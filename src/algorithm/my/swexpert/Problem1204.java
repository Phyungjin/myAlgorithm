package algorithm.my.swexpert;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
     
public class Problem1204 {
    public static StringBuilder sb = new StringBuilder();
    public static StringTokenizer stk;
     
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine()); //10
         
        for(int i=1 ; i<=num ; i++) { // level 1~10
            int[] scores = new int[101];
            StringBuilder level = new StringBuilder(br.readLine());
             
            stk = new StringTokenizer(br.readLine());
            while(stk.hasMoreTokens()) {
                scores[Integer.parseInt(stk.nextToken())]++;
            }
            int pointer = 0;
            int max = scores[0];
            for(int j=1; j<scores.length ; j++) {
                if(scores[pointer]<=scores[j])
                    pointer = j;
            }
            sb.append("\n#"+level+" "+pointer);
        }
         
        System.out.println(sb);
    }
}

