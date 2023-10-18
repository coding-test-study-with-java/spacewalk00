/**
 * 파일명 정렬
 * - 1차 풀이 : 정렬 전까지 단계만 풀이함. 미완
 * https://school.programmers.co.kr/learn/courses/30/lessons/17686
*/

import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = {};
        List<String> result = new ArrayList<>();
        List<String> HEAD = new ArrayList<>();
        List<String> NUMBER = new ArrayList<>();
        List<String> TAIL = new ArrayList<>();
        
        for(int i=0; i<files.length; i++) {
            String[] file = files[i].split("");
            
            int numStart = 0;
            for(int j=0; j<file.length; j++) {
                if('0' <= file[j].charAt(0) && file[j].charAt(0) <= '9') {
                    numStart = j;
                    break;
                }
                HEAD.add(file[j]);
            }
            int numCnt = 0;
            int tailStart = 0;
            for(int j=numStart; j<file.length; j++) {
                if(numCnt >= 5 && !('0' <= file[j].charAt(0) && file[j].charAt(0) <= '9')) {
                    tailStart = j;
                    break;
                }
                NUMBER.add(file[j]);
                numCnt++;
            }
            for(int j=tailStart; j<file.length; j++) {
                TAIL.add(file[j]);
            }          
            
            System.out.println("HEAD"+Arrays.toString(HEAD.toArray()));
            System.out.println("NUMBER"+Arrays.toString(NUMBER.toArray()));
            System.out.println("TAIL"+Arrays.toString(TAIL.toArray()));
            HEAD.clear();
            NUMBER.clear();
            TAIL.clear();
        }
        
        return answer;
        
    }
}