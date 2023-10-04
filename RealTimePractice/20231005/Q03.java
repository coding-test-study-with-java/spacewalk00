//미완성

import java.util.*;

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
            /*sb.append(nums[i]);
            String temp = sb.toString();
            temp.replaceAll("0", "");
            System.out.println("숫자 "+temp);
            
            int tempInt = Integer.parseInt(temp);
            resultNum.add(tempInt);
            
            if(isPrime(tempInt)) {
                if(!resultNum.contains(tempInt)) {
                    cnt++;
                }
            }*/
        }
        //int answer = 0;
        return cnt;
    }
}