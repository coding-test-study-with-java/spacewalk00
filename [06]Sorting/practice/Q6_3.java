import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.Collections;
import java.util.Arrays;

//0.003s
public class Q6_3 {
    //두 배열의 원소 교체
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        Integer[] a = new Integer[N];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            a[i] = Integer.parseInt(st2.nextToken());
        }
        Integer[] b = new Integer[N];
        StringTokenizer st3 = new StringTokenizer(br.readLine());
         for(int i=0; i<N; i++) {
            b[i] = Integer.parseInt(st3.nextToken());
        }
        
        Arrays.sort(a);
        Arrays.sort(b, Collections.reverseOrder());
        
        int sum = 0;
        for(int i=0; i<K; i++) {
            sum += b[i];
        }
        for(int i=K; i<N; i++) {
            sum += a[i];
        }
        System.out.println(sum);
    }
}