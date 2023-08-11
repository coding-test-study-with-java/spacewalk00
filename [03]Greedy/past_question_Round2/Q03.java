package past_question_Round2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//문자열 뒤집기
public class Q03 {
    public static void main(String args[]) throws IOException { 
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();

        int count0 = 0; //문자열 모두 0으로 바꾸는 경우
        int count1 = 0; //문자열 모두 1로 바꾸는 경우
        
        if (str.charAt(0) == '1') {
            count0++;
        } else {
            count1++;
        }

        for(int i=1; i<str.length() - 1; i++) {
            if(str.charAt(i) != str.charAt(i+1)) {
                if(str.charAt(i+1) == '1') {
                    count0++;
                }
                else {
                    count1++;
                }
            }
        }
        System.out.println(Math.min(count0, count1));
    }
}
