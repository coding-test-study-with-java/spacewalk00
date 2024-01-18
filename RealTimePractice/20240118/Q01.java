/**
 * [부등호]
 * https://www.acmicpc.net/problem/2529
 * 
 * [DFS]
 */
import java.util.*;
import java.io.*;

public class MyClass {
    public static int k;
    public static String[] signs;
    public static boolean[] visited;
    public static List<String> cases = new ArrayList<>();
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        
        signs = br.readLine().split(" ");
        
        for(int i=0; i<10; i++) {
            visited = new boolean[10];
            visited[i] = true;
            dfs(i, 0, i+""); 
            visited[i] = false; 
        }
        
        System.out.println(cases.get(cases.size()-1)); 
        System.out.println(cases.get(0));
    }
    
    public static void dfs(int start, int cnt, String temp) {
        if(temp.length() == k+1) {
            cases.add(temp);
            return;
        }
        
        for(int i=0; i<10; i++) {
            if(!visited[i]) {
                String s = signs[cnt]; // >, <
                
                if(s.equals(">")) {
                    
                    if(start > i) {
                        visited[i] = true;
                        dfs(i, cnt+1, temp+i);
                        visited[i] = false;
                    }
                    
                } else {
                    
                    if(start < i) {
                        visited[i] = true;
                        dfs(i, cnt+1, temp+i);
                        visited[i] = false;
                    }
                    
                }
            }
        }
    }
}
