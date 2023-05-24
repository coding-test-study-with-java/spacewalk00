import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Q04 {
    public static void main(String args[]) throws IOException { 
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(bf.readLine());
        int[] arr = new int[n];
        
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    
        Arrays.sort(arr);
        
        int checkNum = 1;
        for(int i=0; i<n; i++) {
            if(checkNum < arr[i]) { //새로운 동전 단위가 클 때, 중간에 빔.
                break;
            }
            checkNum += arr[i];
        }
        
        System.out.println(checkNum);
    }
}