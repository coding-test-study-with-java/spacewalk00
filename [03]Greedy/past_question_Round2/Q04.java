package past_question_Round2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//만들 수 없는 금액 (지난번 풀이 과정과 동일)
public class Q04 {
     public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String s[] = br.readLine().split(" ");
        Integer coin[] = new Integer[N];
        int target = 1;

        for(int i=0; i<N; i++) {
            coin[i] = Integer.parseInt(s[i]);
        }

        Arrays.sort(coin);

        for(int i=0; i<N; i++) {
            if(target < coin[i]) {
                break;
            }
            target += coin[i];
        }

        System.out.println(target);
    }
}
