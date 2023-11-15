/**
 * [신입사원]
 * https://www.acmicpc.net/problem/1946
 * 정렬 Comparable 인터페이스 구현하는 것.. 이제 안보고 풀때 됐다.
 */
import java.util.*;
import java.io.*;

class Rank implements Comparable<Rank> {
    int doc;
    int inter;
    
    Rank(int doc, int inter) {
        this.doc = doc;
        this.inter = inter;
    }
    
    @Override
    public int compareTo(Rank r) {
        return (this.doc > r.doc) ? 1 : -1;
    }
}

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int case_cnt = Integer.parseInt(br.readLine());
        
        for(int i=0; i<case_cnt; i++) {
            int N = Integer.parseInt(br.readLine());
            List<Rank> list = new ArrayList<>();
            
            for(int j=0; j<N; j++) {
                String[] str = br.readLine().split(" ");
                int doc = Integer.parseInt(str[0]);
                int inter = Integer.parseInt(str[1]);
                list.add(new Rank(doc, inter));
            }
            
            Collections.sort(list);
            
            int cnt = 1;
            int min = list.get(0).inter;
            for(int j=0; j<N; j++) {
                if(list.get(j).inter < min) {
                    cnt++;
                    min = list.get(j).inter;
                }
            }
            System.out.println(cnt);
        }

    }
}
