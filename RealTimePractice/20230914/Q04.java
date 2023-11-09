/**
 * 보석 쇼핑
 * LEVEL 3
 * https://school.programmers.co.kr/learn/courses/30/lessons/67258
 * 
 * 미완성
 * 1차 풀이: firstIndex를 어떻게 구할지 더 고민해야 함.
 * 2차 풀이: 33점/100점 (시간 초과) 이유는 주석에 달아놓음.
 * 3차 풀이: 100점/100점
 */
import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int kind = new HashSet<>(Arrays.asList(gems)).size();
        
        int[] answer = new int[2];
        int length = Integer.MAX_VALUE, start = 0;
        
        Map<String, Integer> map = new HashMap<>();
        
        for(int end=0; end < gems.length; end++) {
            map.put(gems[end], map.getOrDefault(gems[end], 0) + 1);
            
            while(map.get(gems[start]) > 1) {
                map.put(gems[start], map.get(gems[start]) - 1);
                start++;
            }
            
            if(map.size() == kind && length > (end - start)) {
                length = end - start;
                answer[0] = start+1;
                answer[1] = end+1;
            }
        }
        return answer;
    }
} 
/*
[2차 풀이] 
정확성: 33.3
효율성: 0.0
합계: 33.3 / 100.0

- 틀린이유
1. map에 보석 종류당 개수를 저장해서 시간 초과가 발생했던 것
   -> map에 저장하면서, 시작index의 보석 개수 체크하면서 중복되면 시작index를 증가시키고, 맵에 있는 해당 보석을 감소시킴.
2. 종류를 set으로 받은건 잘했는데, (값을 저장하기보단) 길이만으로 보석이 최소 1개씩 있는지 파악 가능.

- 결론
시작인덱스와 끝인덱스를 어떻게 효율적으로 조정하는가가 관건이었음. 업데이트는 길이가 최소일때만 해주는 작업도 중요했음.
map의 getOrDefault, put, get 메소드 중요.

import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = {0, 0};
        
        if(gems.length == 0) { 
            return answer;
        }
        
        Set<String> kind = new HashSet<>();
        for(int i=0; i<gems.length; i++) {
            kind.add(gems[i]);
        }
        
        int minLength = 100001; int[] minIndex = {0, 0};
        int[] tempIndex = {0, 0}; //첫, 마
        
        for(int s=0; s<gems.length; s++) {
            tempIndex[0] = s;
            
            Map<String, Integer> kindCntMap = new HashMap<>();
            for(String g : kind) {
                kindCntMap.put(g, 0);
            }
            
            for(int i=s; i<gems.length; i++) {
                kindCntMap.put(gems[i], kindCntMap.get(gems[i]) + 1);
                
                if(!kindCntMap.containsValue(0)) { //한번씩 다 나왔다면
                    tempIndex[1] = i;
                    if((tempIndex[1] - tempIndex[0]) < minLength) {
                        minLength = tempIndex[1] - tempIndex[0];
                        minIndex[0] = tempIndex[0];
                        minIndex[1] = tempIndex[1];
                    }
                    break;
                }
            }
        }
        answer[0] = minIndex[0] + 1;
        answer[1] = minIndex[1] + 1;
        return answer;
    }
}*/