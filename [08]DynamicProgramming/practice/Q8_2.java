import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
//개미 전사
public class Q8_2 {
    public static void main(String args[]) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int N = Integer.parseInt(br.readLine());
      
      String[] input = br.readLine().split(" ");
      int[] food = new int[N];
      for(int i=0; i<N; i++) {
          food[i] = Integer.parseInt(input[i]);
      }
      
      int[] dp = new int[N];
      dp[0] = food[0];
      dp[1] = Math.max(food[0], food[1]);
      for(int i=2; i<N; i++) {
          dp[i] = Math.max(dp[i-1], dp[i-2] + food[i]);
      }
      
      System.out.println(dp[N-1]);
    }
}