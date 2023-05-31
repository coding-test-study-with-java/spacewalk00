package past_question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Q07 {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        int[] digits = Stream.of(str.split("")).mapToInt(Integer::parseInt).toArray();
        //System.out.print(Arrays.toString(digits));
        
        int sum_front=0, sum_back=0;
        for(int i=0; i<digits.length; i++) { //digits.length는 커봤자 8임.
            if(0<=i && i<digits.length/2) {
                sum_front += digits[i];
            } else {
                sum_back += digits[i];
            }
        }
        if(sum_front == sum_back) {
            System.out.println("LUCKY");
        } else {
            System.out.println("READY");
        }
        
    }
}
