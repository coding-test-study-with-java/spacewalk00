package Q6_2;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

//성적 낮은 순서로 학생 출력하기
//10.667s
public class Q6_2 {
    public static void main(String args[]) throws IOException {
      //long beforeTime = System.currentTimeMillis();
      
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int N = Integer.parseInt(br.readLine());

      List<Person> list = new ArrayList<>();
      
      for(int i=0; i<N; i++) {
          StringTokenizer st = new StringTokenizer(br.readLine());
          String name = st.nextToken();
          int score = Integer.parseInt(st.nextToken());
          list.add(new Person(name, score));
      }
      
      Collections.sort(list);
      
      StringBuilder sb = new StringBuilder();
      for(int i=0; i<list.size(); i++) {
        sb.append(list.get(i).getName()).append(" ");
      }
      System.out.println(sb);
    //   for(Person p : list) {
    //       System.out.print(p.getName() + " ");
    //   }
      //long endTime = System.currentTimeMillis();
      //System.out.println("시간차이(s) : "+(endTime - beforeTime) / 1000.0);
    }
}