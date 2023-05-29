import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q4_3 {
    //왕실 나이트
    public static void main(String args[]) throws IOException {
       BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
       String str = bf.readLine();
       
       int column = str.charAt(0) -'a' + 1;
       int row = str.charAt(1) - '0';
       
       //8가지 이동값 정의
       int[] x = {2, 2, -1, 1, -2, -2, -1, 1};
       int[] y = {1, -1, -2, -2, -1, 1, 2, 2};
       
       int result = 0;
       int next_column, next_row;
       
       for(int i=0; i<8; i++) {
           next_column = column + x[i];
           if(!(next_column >= 1 && next_column <= 8)) {
               continue;
           }
           next_row = row + y[i];
           if(next_row >= 1 && next_row <=8) {
               result++;
           }
       }
       System.out.println(result);
    }
}