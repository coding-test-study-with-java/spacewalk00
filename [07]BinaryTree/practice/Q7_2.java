import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;
//40ms
public class Q7_2 {
    public static int N, M;
    
    public static int binary_tree(int[] riceCake, int start, int end) {
        int result = 0;
        while(start <= end) {
            int mid = (start + end) / 2;
            
            int sum = 0;
            for(int i=0; i<N; i++) {
                if(riceCake[i] >= mid) { //조건 필수
                    sum += riceCake[i] - mid;
                }
            }
            
            if(sum < M) { //부족할 때
                end = mid - 1;
            }
            else { //많거나 같을 때
                result = mid;
                start = mid + 1;
            }
        }
        return result;
    }
    
    public static void main(String args[]) throws IOException {
      long beforeTime = System.currentTimeMillis();
      
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      
      int[] riceCake = new int[N];
      StringTokenizer st2 = new StringTokenizer(br.readLine());
      //int max = -1;
      for(int i=0; i<N; i++) {
          riceCake[i] = Integer.parseInt(st2.nextToken());
          /*if(max < riceCake[i]) {
            max = riceCake[i];
          }*/
      }
      //떡 길이 중 가장 긴거
      int end = Arrays.stream(riceCake).max().getAsInt();
      
      //Arrays.sort(riceCake); 
      //int end = riceCake[N - 1]; 
      //int end = max; 
      int result = binary_tree(riceCake, 0, end);
      
      System.out.println(result);
      long endTime = System.currentTimeMillis();
      System.out.println("\n시간차이(ms) : "+(endTime - beforeTime));
    }
}