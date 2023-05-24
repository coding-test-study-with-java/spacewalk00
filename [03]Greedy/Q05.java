import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q05 {
    public static int combination(int n, int r) {
        if(n == r || r == 0) {
            return 1;
        }
        else {
            return combination(n-1, r-1) + combination(n-1, r);
        }
    }
    
    public static void main(String args[]) throws IOException { 
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st1 = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int M = Integer.parseInt(st1.nextToken());
        
        int[] arr = new int[n];
        
        int[] weight = new int[M+1];
        for(int i=1; i<=M; i++) {
            weight[i] = 0;
        }
        
        StringTokenizer st2 = new StringTokenizer(bf.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
            weight[arr[i]]++;
        }
        
        int overlapCount = 0;
        for(int i=1; i<=M; i++) {
            if(weight[i] >= 2) {
               overlapCount += combination(weight[i], 2);
            }
        }
        System.out.println(combination(n, 2) - overlapCount);
    }
}