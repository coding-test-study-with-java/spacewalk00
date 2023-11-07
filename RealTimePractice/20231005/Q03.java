/**
 * [소수찾기]
 * https://school.programmers.co.kr/learn/courses/30/lessons/42839
 * 
 * 순열(재귀), 에라토스테니스의 체 개념 정리 추가
 * https://dune-plant-e5f.notion.site/4-ba7b8c461eea45398f07cfee7762042e?pvs=4
 */
import java.util.*;

class Solution {
    public Set<Integer> set = new HashSet<>();
    public char[] arr;
    public boolean[] visited; 
    
    public int solution(String numbers) {
        int answer = 0;
        arr = new char[numbers.length()];
        visited = new boolean[numbers.length()];
        
        for(int i=0; i<numbers.length(); i++) {
            arr[i] = numbers.charAt(i);
        }
        
        recursion("", 0);
        answer = set.size();
        return answer;
    }
    
    public void recursion(String str, int idx) {
        int num;
        if(str != "") {
            num = Integer.parseInt(str);
            if(isPrime(num)) {
                set.add(num);
            }
        }        
        if(idx == arr.length) {
            return;
        }
        for(int i=0; i<arr.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                recursion(str+arr[i], idx+1);
                visited[i] = false;
            }
        }
    }
    
    public boolean isPrime(int num) {
        if(num == 0 || num == 1) {
            return false;
        }
        for(int i=2; i*i<=num; i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;        
    }
}
//이전 미완성 풀이
/*import java.util.*;

class Solution {
    public boolean isPrime(int num) {
        if(num == 0 || num == 1) {
            return false;
        }
        for(int i=2; i<num; i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
    public int solution(String numbers) {
        int cnt = 0;
        String[] nums = numbers.split("");
        Set<Integer> resultNum = new HashSet<>();
        
        //StringBuilder sb = new StringBuilder();
        for(int i=0; i<nums.length; i++) {
            
            //숫자 조합하는 아이디어 생각 ing.......................
            
            
            //System.out.println("숫자 "+nums[i]);
            sb.append(nums[i]);
            String temp = sb.toString();
            temp.replaceAll("0", "");
            System.out.println("숫자 "+temp);
            
            int tempInt = Integer.parseInt(temp);
            resultNum.add(tempInt);
            
            if(isPrime(tempInt)) {
                if(!resultNum.contains(tempInt)) {
                    cnt++;
                }
            }
        }
        //int answer = 0;
        return cnt;
    }
}*/