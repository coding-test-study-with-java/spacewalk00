/**
 * 뱀 - 삼성전자 SW 역량 테스트
 * 
*/
import java.io.*;
import java.util.*;

public class Q11 {
    public static int[] dx = {1,0,-1,0}; //상하좌우
	public static int[] dy = {0,1,0,-1};
    public static int d = 0;

    public static int N;
    public static int map[][];
    
    public static Map<Integer, String> moveInfo; //방향 전환 기록
    public static List<int[]> snake = new ArrayList<>(); //뱀의 위치

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); //N * N
        int K = Integer.parseInt(br.readLine()); //K: 사과개수

        map = new int[N][N];
        moveInfo = new HashMap<>(); //해시맵: string 저장하기 용이, 시간 조회하기 좋아서

        for(int i=0; i<K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken()) - 1;
            int Y = Integer.parseInt(st.nextToken()) - 1; 
            map[X][Y] = 1; //사과 O
        }
        int L = Integer.parseInt(br.readLine()); //뱀의 방향 변환 횟수
        for(int i=0; i<L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());

            String d = st.nextToken();
            moveInfo.put(t, d);
        }

        solve();
    }

    public static void solve() {
        snake.add(new int[] {0, 0});

        int time = 0;
        int px = 0;
        int py = 0;

        while(true) {
            int nx = px + dx[d];
            int ny = py + dy[d];
            time++;

            //벽 부딪힘
            if(nx < 0 || ny < 0 || nx >= N || ny >= N) {
                break;
            }

            //몸통 부딪힘
            int crash = 0;
            for(int[] t : snake) {
                if(nx == t[0] && ny == t[1]) {
                    crash = 1;
                }
            }
            if(crash == 1) {
                break;
            }

            //안 부딪히면 이동하기
            if(map[ny][nx] == 1) {
                map[ny][nx] = 0;
                snake.add(new int[] {nx, ny});
            } else {
                snake.add(new int[] {nx, ny});
                snake.remove(0);
            }

            //방향 전환
            if(moveInfo.containsKey(time)) {
                String data = moveInfo.get(time);
                if(data.equals("D")) {
                    d++;
                    if(d == 4) {
                        d = 0;
                    } 
                } else {
                    d--;
                    if(d == -1) {
                        d = 3;
                    }
                }
            }
            px = nx;
            py = ny;
        }

        System.out.println(time);
    }
}



/*
//뱀의 위치 표현할 때: List<int[]>가 아닌 Queue로 한 버전

import java.io.*;
import java.util.*;

public class MyClass {
    //오하좌상
    public static int[] dx = {1,0,-1,0}; 
	public static int[] dy = {0,1,0,-1};

    public static int d = 0;
    public static int N;
    public static int map[][];
    public static Map<Integer, String> moveInfo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); //N * N
        int K = Integer.parseInt(br.readLine()); //K: 사과개수

        map = new int[N][N];
        moveInfo = new HashMap<>(); //해시맵: string 저장하기 용이, 시간 조회하기 좋아서

        for(int i=0; i<K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken()) - 1;
            int Y = Integer.parseInt(st.nextToken()) - 1; 
            map[X][Y] = 1; //사과 O
        }
        int L = Integer.parseInt(br.readLine()); //뱀의 방향 변환 횟수
        for(int i=0; i<L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());

            String d = st.nextToken();
            moveInfo.put(t, d);
        }

        solve();
    }

    public static void solve() {
        Queue<Point> q = new LinkedList<>(); //뱀의 위치 정보
        q.add(new Point(0, 0));

        int time = 0;
        int px = 0;
        int py = 0;

        while(true) {
            int nx = px + dx[d];
            int ny = py + dy[d];
            time++;

            //벽 부딪힘
            if(nx < 0 || ny < 0 || nx >= N || ny >= N) {
                break;
            }

            //if(q.contains(new Point(nx, ny))) {
            //    break;
            //} x

            //몸통 부딪힘
            int crash = 0;
            Iterator iter = q.iterator();
		    while(iter.hasNext()) {
		        Point tempP = (Point)iter.next();
		        if(tempP.x == nx && tempP.y == ny) {
		            crash = 1;
		        }
		    }
		    if(crash == 1) {
		        break;
		    }

            //안 부딪히면 이동하기
            if(map[ny][nx] == 1) {
                map[ny][nx] = 0;
                q.add(new Point(nx, ny));
            } else {
                q.add(new Point(nx, ny));
                q.poll();
            }

            //방향 전환
            if(moveInfo.containsKey(time)) {
                String data = moveInfo.get(time);
                if(data.equals("D")) {
                    d++;
                    if(d == 4) {
                        d = 0;
                    } 
                } else {
                    d--;
                    if(d == -1) {
                        d = 3;
                    }
                }
            }
            px = nx;
            py = ny;
        }

        System.out.println(time);
    }

    public static class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
 */