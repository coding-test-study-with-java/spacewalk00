import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;
//18548ms (입력값 교재 예제)
public class Q7_1 {
    public static int[] dongbin;
    
    public static String binary_search(int key, int start, int end) {
        if(start <= end) {
            int mid = (start + end) / 2;
            if(dongbin[mid] == key) {
                return "yes";
            }
            else if(dongbin[mid] < key) {
                binary_search(key, mid+1, end);
            }
            else {
                binary_search(key, start, mid-1);
            }
        }

        //start와 end 지점에 찾아야하는 수가 있을 경우, 재귀 방식 적용이 안됨.
        //26~27구문이 없으면 -> return mid를 보내도, 마지막 줄인 return no를 꼭 통과함. 
        //반복문으로 풀면, 아무 문제가 없음...
        if(dongbin[start] == key || dongbin[end] == key) {
            return "yes";
        }
        return "no";
    }    
    
    public static void main(String args[]) throws IOException  {
        //long beforeTime = System.currentTimeMillis();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        dongbin = new int[N];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            dongbin[i] = Integer.parseInt(st1.nextToken());
        }
        
        int M = Integer.parseInt(br.readLine());
        int[] guest = new int[M];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            guest[i] = Integer.parseInt(st2.nextToken());
        }
        //이진 탐색 전에 정렬하기
        Arrays.sort(dongbin);
    
        for(int i=0; i<M; i++) {
            System.out.print(binary_search(guest[i], 0, N-1));
            if(i != M-1) {
                System.out.print(" ");
            }
        }
        //long endTime = System.currentTimeMillis();
        //System.out.println("\n시간차이(ms) : "+(endTime - beforeTime));
    }
}