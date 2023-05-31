import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Q4_1 {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        ArrayList<String> arr = new ArrayList<>();
        while(st.hasMoreTokens()) {
            arr.add(st.nextToken());
        }
        
        int x = 1, y = 1;
        for(String s : arr) {
            char c = s.charAt(0);
            switch(c) {
                case 'L':
                    if(y > 1) {
                        y -= 1;
                    }
                    break;
                case 'R':
                    if(y < N) {
                        y += 1;
                    }
                    break;
                case 'U':
                    if(x > 1) {
                        x -= 1;
                    }
                    break;
                case 'D':
                    if(x < N) {
                        x += 1;
                    }
                    break;
                default:
                    break;
            }
        }
        System.out.println(x+" "+y);
    }
}

/*
 * 
나동빈 풀이
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N을 입력받기
        int n = sc.nextInt();
        sc.nextLine(); // 버퍼 비우기
        String[] plans = sc.nextLine().split(" ");
        int x = 1, y = 1;

        // L, R, U, D에 따른 이동 방향 
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        char[] moveTypes = {'L', 'R', 'U', 'D'};

        // 이동 계획을 하나씩 확인
        for (int i = 0; i < plans.length; i++) {
            char plan = plans[i].charAt(0);
            // 이동 후 좌표 구하기 
            int nx = -1, ny = -1;
            for (int j = 0; j < 4; j++) {
                if (plan == moveTypes[j]) {
                    nx = x + dx[j];
                    ny = y + dy[j];
                }
            }
            // 공간을 벗어나는 경우 무시 
            if (nx < 1 || ny < 1 || nx > n || ny > n) continue;
            // 이동 수행 
            x = nx;
            y = ny;
        }

        System.out.println(x + " " + y);
    }

}
 */