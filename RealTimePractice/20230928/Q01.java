import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = {};        
        List<Integer> list = new ArrayList<>();
        
        String[] arr = s.split("\\{|\\},\\{|\\}");     
        Arrays.sort(arr, new Comparator<String>(){
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });
        
        /*for(int i=0; i<arr.length; i++) {
            System.out.println(arr[i]);
        }*/
        
        for(int i=0; i<arr.length; i++) {
            //안하면 java.lang.NumberFormatException: For input string: ""
            if(arr[i].equals("")) { 
                continue;
            }
            String[] t = arr[i].split(",");
            for(int j=0; j<t.length; j++) {
                if(!list.contains(Integer.parseInt(t[j]))) {
                    list.add(Integer.parseInt(t[j]));
                }
            }
        }
        answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
        
        
        /*String[] newS = s.split("\\{\\}\\,");
        for(int i=0; i<newS.length; i++) {
            System.out.println(newS[i]);
        }*/
        /*int left = 0;
        List<List<Integer>> totalArr = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '{') {
                left++;
            } else if(s.charAt(i) == '}') {
                left--;
                if(left == 0) {
                    totalArr.add(arr);
                    arr.clear();
                    break;
                }
            } else if(s.charAt(i) == ",") {
                if(left == 1) {
                    continue;
                } else {
                    arr.add(s.chatAt(i));
                }
            } else {
                arr.add(s.charAt(i));
            }
        }
        System.out.println(totalArr.toString());*/        
    }
}