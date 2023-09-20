/**
 * 뉴스 클러스터링
 * LEVEL 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/17677
 * 
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 * 
 * 1차 풀이: 정확성 61.0....
 * 2차 풀이: 교집합 합집합 계산하는 부분 변경 후 성공
 */
import java.util.*;

class Solution {
    public static List<String> str1List;
    public static List<String> str2List;
    
    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        System.out.println(str1 + str2);
        
        str1List = makeSet(str1);
        str2List = makeSet(str2);
        
        List<String> overlap = new ArrayList<>();
        List<String> whole = new ArrayList<>();
        
        for(String s : str1List) {
            if(str2List.remove(s)) {
                overlap.add(s);
            }
            whole.add(s);
        }
        for(String s : str2List) {
            whole.add(s);
        }
        System.out.println(overlap);
        System.out.println(whole);
        
        /*
        //아래 주석대로 했더니 -> 61점이었음
        for(String s : str1List) {
            if(str2List.contains(s)) {
                overlap.add(s);
            } 
        }
        int forWholeCnt = 0;
        int cnt1 = 0, cnt2 = 0;
        for(String temp : overlap) {
            if(str1List.contains(temp)) {
                cnt1++;
            }
            if(str2List.contains(temp)) {
                cnt2++;
            }
            int who = Math.max(cnt1, cnt2);
            cnt1 = 0; cnt2 = 0;
            forWholeCnt += who;
        }
        System.out.println(forWholeCnt);
        int entire = (str1List.size() - overlap.size())
        + (str2List.size() - overlap.size()) + forWholeCnt;*/
        double result = 0;
        if(whole.size() == 0) {
            result = 1;
        } else {
            result = (double) overlap.size() / whole.size();
        }        
        return (int) (result * 65536);
        
        /*double result = 0;
        if (entire > 0) {
            result = (double)overlap.size() / entire * 65536;
            //System.out.println("결과:"+result);
        } else {
            return 65536;
        }
        return (int)result;*/
    }
    
    
    public static boolean isAlaphabet(char str) {
        if(('a' <= str && 'z' >= str)
               || ('A' <= str && 'Z' >= str)) {
            return true;
        }
        return false;
    }
    
    public static List<String> makeSet(String str) {
        List<String> strList = new ArrayList<>();
        
        int[] strAlaph = new int[str.length()];        
        Arrays.fill(strAlaph, 0);
        
        for(int i=0; i<str.length(); i++) {
            if(strAlaph[i] == 1) {
                if((i+1) < str.length() && isAlaphabet(str.charAt(i+1))) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str.charAt(i));
                    sb.append(str.charAt(i+1));
                    strList.add(sb.toString());
                    
                    strAlaph[i+1] = 1;
                }
            } else {
                if(isAlaphabet(str.charAt(i))) {
                    strAlaph[i] = 1;
                    if((i+1) < str.length() && isAlaphabet(str.charAt(i+1))) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(str.charAt(i));
                        sb.append(str.charAt(i+1));
                        
                        strList.add(sb.toString());
                        strAlaph[i+1] = 1;
                    }
                }                 
            }
        }
        return strList;
    }
}