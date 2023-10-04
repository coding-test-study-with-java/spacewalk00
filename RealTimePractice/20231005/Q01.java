import java.util.*;
class Solution {
    Map<String, String> map = new HashMap<>();
    
    public String[] solution(String[] record) {
        int cnt = 0; //change 카운트
        for(int i=0; i<record.length; i++) {
            String[] element = record[i].split(" ");
            
            if(element[0].equals("Leave")) {
                continue;
            } else if(element[0].equals("Enter")) {
                map.put(element[1], element[2]);
            } else {//change
                map.put(element[1], element[2]);
                cnt++;
            }
        }
        String[] answer = new String[record.length - cnt];
        int idx = 0;
        for(int i=0; i<record.length; i++) {
            String[] element = record[i].split(" ");
            String nickname = map.get(element[1]);
              
            if(element[0].equals("Enter")){
                answer[idx++] = nickname + "님이 들어왔습니다.";
            } else if(element[0].equals("Leave")) {
                answer[idx++] = nickname + "님이 나갔습니다.";
            }
        }
        return answer;
    }
}