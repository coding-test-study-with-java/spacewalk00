/*
 * 정확성: 32.1
 * 효율정: 0.0
 * 합계: 32.1 / 100.0 ...
 */
class Solution {
    public int solution(int[] food_times, long k) {
        int answer = -1;
        
        int stoppedIdx = -2;
        int len = food_times.length;
        int s = 0;
        
        for(int i=0 ;; i++) {
            if(k <= s) {
                stoppedIdx = i % len;
                
                int n = 0;
                while(n < len) {
                    if(food_times[stoppedIdx] != 0) {
                        break;
                    }
                    stoppedIdx = (stoppedIdx + 1) % len;
                    n++;
                }
                break;
            }
            if(food_times[i % len] == 0) {
                continue;
            }
            s++;
            food_times[i % len]--;
        }
           
        answer = (stoppedIdx + 1) % len; //0번 음식부터로 설정해서 1 더해줌.
        return answer;
    }
}