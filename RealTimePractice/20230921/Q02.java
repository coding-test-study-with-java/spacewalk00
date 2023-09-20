//2018 KAKAO [3차] n진수 게임
class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        p--;
        
        String temp = "";
        for(int i=0; temp.length() < t*m; i++) {
            temp += Integer.toString(i, n).toUpperCase();
        }
        for(int i=0; i<t; i++) {
            sb.append(temp.charAt(i*m+p));
        }
        return sb.toString();  
    }
}