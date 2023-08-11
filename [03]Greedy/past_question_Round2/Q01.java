package past_question_Round2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

//모험가 길드
public class Q01 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] people = new int[N];
        for(int i=0; i<N; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(people);

        //한 그룹에 최소한의 모험가가 있어야 그룹 수의 최댓값을 구할 수 있음.
        int answer = 0;
        int count = 0;
        for(int i=0; i<N; i++) {
            count++;
            if(count >= people[i]) {
                answer++;
                count = 0;
            }
        }
        System.out.println(answer);
    }
}
