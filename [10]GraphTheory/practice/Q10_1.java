import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
//팀 결성 -> 서로소 집합 알고리즘
public class Q10_1 {
    public static int[] parent;
    
    //특정 원소가 속한 집합을 찾기
    public static int find_parent(int n1) {
        if (parent[n1] != n1) { //루트노드가 아니라면
            parent[n1] = find_parent(parent[n1]);
        }
        return parent[n1];
    }

    //두 원소가 속한 집합을 합치기
    public static void union_parent(int n1, int n2) {
        int a = find_parent(n1);
        int b = find_parent(n2);
        if(a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); //0번 ~N번 학생
        int M = Integer.parseInt(st.nextToken()); //연산의 개수

        parent = new int[N+1];
        for(int i=1; i<=N; i++) {
            parent[i] = i;
        }

        for(int i=0; i<M; i++) {
            String[] input = br.readLine().split(" ");
            int kindOf = Integer.parseInt(input[0]);
            int n1 = Integer.parseInt(input[1]);
            int n2 = Integer.parseInt(input[2]);

            //같은 팀 여부 확인 YES, NO
            if (kindOf == 0) {//union
                union_parent(n1, n2);
            }
            else {//find
                if(find_parent(n1) == find_parent(n2)) {
                    System.out.println("YES"); //루트 노드가 같으면 
                }
                else {
                    System.out.println("NO");
                }
            }
        }

    }
}
