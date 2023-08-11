package past_question_Round2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//볼링공 고르기 
public class Q05 {
    public static void main(String args[]) throws IOException { 
        long beforeTime = System.currentTimeMillis();

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st1 = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st1.nextToken());
        int M = Integer.parseInt(st1.nextToken());

        st1 = new StringTokenizer(bf.readLine());
        
        int[] weightArr = new int[11]; //M 최대: 10

        for(int i=0; i<N; i++) {
            int temp = Integer.parseInt(st1.nextToken());
            weightArr[temp] += 1;
        }

        int result = 0;
        for(int i=1; i<= M; i++) {
            N -= weightArr[i]; //무게가 i인 볼링공의 개수 제외 (A가 선택할 수 있는 개수) 제외
            result += weightArr[i] * N; //B가 선택하는 경우의 수와 곱하기
        }
        System.out.println(result);
        long endTime = System.currentTimeMillis();

        System.out.println("\n시간차이(s) : "+(endTime - beforeTime) / 1000.0);
    }
}
