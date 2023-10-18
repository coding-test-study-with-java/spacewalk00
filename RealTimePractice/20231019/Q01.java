/**
 * 정확성: 82.6
 * 합계: 82.6 / 100.0
 * 뒤에 있는 큰 수 찾기
 * https://school.programmers.co.kr/learn/courses/30/lessons/154539
 */
import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        int no = 1;
        List<Integer> result = new ArrayList<>();        
        for(int i=0; i<numbers.length; i++) {
            no = 1;
            for(int j=i+1; j<numbers.length; j++) {
                if(numbers[j] > numbers[i]) {
                    result.add(numbers[j]);
                    no = 0;
                    break;
                }
            }
            if(no == 1) {
                result.add(-1);
            }
        }        
        answer = result.stream().mapToInt(i -> i).toArray();  
        return answer;
    }
}