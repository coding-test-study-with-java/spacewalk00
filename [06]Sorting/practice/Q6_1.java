import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.Collections;
import java.util.Arrays;
//import java.util.List;
//import java.util.ArrayList;

//4.683s
public class Q6_1 {
    public static void main(String args[]) throws IOException {
      //long beforeTime = System.currentTimeMillis();
      
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
      StringTokenizer str = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(str.nextToken());
     
      Integer[] nums = new Integer[N]; //int[] X
      for(int i=0; i<N; i++) {
          nums[i] = Integer.parseInt(br.readLine());
      }
      Arrays.sort(nums, Collections.reverseOrder()); //Collections.sortX
      
      for(int i=0; i<N; i++) {
        System.out.print(nums[i] + " ");
      }
      
      /*
      5.541s
      List<Integer> list = new ArrayList<>();
      for(int i=0; i<N; i++) {
          list.add(Integer.parseInt(br.readLine()));
      }
      
      Collections.sort(list, Collections.reverseOrder());
      for(Integer i:list) {
          System.out.println(i + " ");
      }*/
      
      //long endTime = System.currentTimeMillis();
      //System.out.println("\n시간차이(s) : "+(endTime - beforeTime) / 1000.0);
    }
}