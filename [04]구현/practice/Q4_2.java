import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q4_2 {
    public static void main(String args[]) throws IOException {
       BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
       int N = Integer.parseInt(bf.readLine());
       int count = 0;
       
       String hour, minute, second;
       for(int h=0; h<N+1; h++) {
           hour = String.valueOf(h);
           for(int m=0; m<60; m++) {
               minute = String.valueOf(m);
               for(int s=0; s<60; s++) {
                   second = String.valueOf(s);
                   if(hour.contains("3") || minute.contains("3") || second.contains("3")) {
                       count++;
                   }
               }
           }
       }
       
       System.out.println(count);
    }
}