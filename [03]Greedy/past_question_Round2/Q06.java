package past_question_Round2;

import java.util.*;

//무지의 먹방 라이브
/*정확성: 42.9
효율성: 57.1
합계: 100.0 / 100.0*/
public class Q06 {
    class Food {
        int time;
        int idx;
        Food(int time, int idx) {
            this.time = time;
            this.idx = idx;
        }
    }

    //오름차순 - 시간
    Comparator<Food> CompTime = new Comparator<Food>() {
        public int compare(Food a, Food b) {
            return a.time - b.time;
        }
    };
    //오름차순 - 순서
    Comparator<Food> CompIdx = new Comparator<Food>() {
        public int compare(Food a, Food b) {
            return a.idx - b.idx;
        }  
    };
    
    public int solution(int[] food_times, long k) {
        List<Food> foods = new ArrayList<Food>();
        
        int n = food_times.length;
        for(int i=0; i<n; i++) {
            foods.add(new Food(food_times[i], i+1));
        }
        
        foods.sort(CompTime); //시간 순으로 정렬
        
        int pretime = 0;
        int i = 0;
        for(Food f : foods) {
            long diff = f.time - pretime;
            if(diff != 0) {
                long spend = diff * n;
                if(spend <= k) {
                    k -= spend;
                    pretime = f.time;
                } else {
                    k %= n;
                    foods.subList(i, food_times.length).sort(CompIdx);
                    return foods.get(i+(int)k).idx;
                }
            }
            ++i;
            --n;
        }
    
        return -1;
    }
}