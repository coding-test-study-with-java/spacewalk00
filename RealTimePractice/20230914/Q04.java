/**
 * 보석 쇼핑
 * LEVEL 3
 * https://school.programmers.co.kr/learn/courses/30/lessons/42587
 * 
 * 미완성
 * 1차 풀이: firstIndex를 어떻게 구할지 더 고민해야 함.
 * 
 */
import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = {};
        String lastKind = "";
        List<String> kind = new ArrayList<>();
        for(int i=0; i<gems.length; i++) {
            if(!kind.contains(gems[i])) {
                kind.add(gems[i]);
                lastKind = gems[i]; 
            }
        }
        int[] kindCnt = new int[kind.size()]; //종류: 0, 1, 2, ..
        Arrays.fill(kindCnt, 0);
        List<Integer> lastKindIndex = new ArrayList<>();
        for(int i=0; i<gems.length; i++) {
            if(lastKind.equals(gems[i])) {
                lastKindIndex.add(i); //인덱스 위치
            }
        }
        
        int firstIndex = 0, lastIndex = 0;
        for(int index : lastKindIndex) {
            //index는 lastIndex의 후보
            for(int i=0; i<=index; i++) {
                kindCnt[i]++;
                
                int totalExist = 1;
                for(int value : kindCnt) {
                    if(value == 0) {
                        totalExist = 0;
                        break;
                    }
                }
                if(totalExist == 1) {
                    //firstIndex = i; //처음 값을 못찾았다.
                    lastIndex = index;
                    break;
                }
            }
            Arrays.fill(kindCnt, 0);
        }
        answer[0] = firstIndex + 1;
        answer[1] = lastIndex + 1;
        return answer;
    }
}