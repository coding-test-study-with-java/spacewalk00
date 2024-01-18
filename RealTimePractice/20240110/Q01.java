/**
 * 행운의 문자열
 * [DFS]
 * https://www.acmicpc.net/problem/1342
 * 
 * 
 * 영소문자로 만든 문자열의 길이와 testcase의 문자열의 길이가 같을때 count를 올린다.
 * 단, 두 가지 조건을 비교해야 한다.
 * 1. 알파벳이 존재하는지 check
 * 2. 이전 알파벳과 현재 알파벳이 같은지 check
 */
import java.util.*;
import java.io.*;

public class MyClass {
    
    static char[] alphabet = new char[27];
    static int count = 0;
    
    public static void DFS(int temp_len, String temp, int str_len) {
        if(temp_len == str_len) {
            count++;
            return;
        }
        
        for(int i=0; i<26; i++) { //26개의 알파벳
            //해당 알파벳이 없다면 pass
            if(alphabet[i] == 0) {
                continue;
            }
            //temp 문자열에 마지막 문자열과 같다면 pass
            if(temp != "" && temp.charAt(temp.length() - 1) == (char)('a' + i)) {
                continue;
            }
            alphabet[i]--; //사용했으니 빼주고.
            DFS(temp_len + 1, temp + (char) ('a' + i), str_len);
            alphabet[i]++; // 앞줄에서 해당문자에 대한 DFS를 했으니 그 위 분기로 다시 원 위치
        }
    }
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        
        //알파벳 종류를 세어야지... a의 개수는 alphabet[0]에 있겠군
        for(int i=0; i<str.length(); i++) {
            alphabet[str.charAt(i)-'a']++;
        }
        
        //가지고 있는 알파벳으로 문자열 만들어야지... 초기값세팅해줘야지..
        DFS(0, "", str.length());
        
        System.out.println(count);
    }
}

/*
Map 자료형을 활용해서 값 저장하는 방법.

import java.util.*;
import java.io.*;

public class MyClass {
    
    public static List<Integer> list;
    public static int sum = 0;
    
    public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		Map<Character, Integer> map = new HashMap<>();
		for(int i=0; i<s.length(); i++) {
		    if(map.containsKey(s.charAt(i))) {
		        map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
		    } else {
		        map.put(s.charAt(i), 1); //초기화
		    }
		}
		
		list = new ArrayList<>(map.values());
		for(int i=0; i<list.size(); i++) {
		    list.set(i, list.get(i) - 1);
		    method(i, 1, s.length());
		    list.set(i, list.get(i) + 1);
		}
		
		System.out.println(sum);
    }
    
    public static void method(int lastIndex, int depth, int maxDepth) {
        if(depth == maxDepth) {
            sum++;
            return;
        }
        for(int i=0; i<list.size(); i++) {
            if(list.get(i) > 0 && lastIndex != i) {
                list.set(i, list.get(i) - 1);
                method(i, depth + 1, maxDepth);
                list.set(i, list.get(i) + 1);
            }
        }
    }
    
}*/