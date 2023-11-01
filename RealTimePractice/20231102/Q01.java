/**
 * 퇴사
 * https://www.acmicpc.net/problem/14501
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Q01 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //N

        int[][] info = new int[N][2];

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken()); 
            int P = Integer.parseInt(st.nextToken());
            info[i][0] = T; 
            info[i][1] = P;
        }
        int max = -1;
        int temp = 0;
        int j = 0;
        for(int i=0; i<N; i++) {
            while(j < N && ((j + info[j][0]) <= N)) {
                temp += info[j][1];
                j = j + info[j][0];
                
                //System.out.println("현재 j index는?"+j);
                //System.out.println("while문 안에 확인 좀 해보자"+temp+"다음꺼꺼"+(j+info[j][0]));
            }
            if(max < temp) {
                max = temp;
            }
            temp = 0;
            j = 0;
        }

        System.out.println(max);
    }
}