package past_question_Round2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//곱하기 혹은 더하기
public class Q02 {
     public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        int answer = 0;
        
        for(char c : str.toCharArray()) {
            int number = Character.digit(c, 10);

            if(answer <= 1 || number <= 1) {
                answer += number;
            } else {
                answer *= number;
            }
        }
        System.out.println(answer);
     }
}
