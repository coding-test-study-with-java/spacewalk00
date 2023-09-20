//2018 KAKAO [1차] 비밀지도
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            answer[i] = Integer.toBinaryString(arr1[i] | arr2[i]);//비트 연산자
            answer[i] = answer[i].replace('0', ' ');
            answer[i] = answer[i].replace('1', '#');

            while (answer[i].length() < n) {
                answer[i] = ' ' + answer[i]; //n자리수될때까지 앞에 공백 추가
            }
        }

        return answer;
        
        /*int[][] map = new int[n][n];
        
        int k = 0;
        for(int i=0; i<n; i++) { 
            //arr1[0] 과 arr2[0] 비교
            String map1Temp = Integer.toBinaryString(arr1[i]);
            if(map1Temp.length() != n) {
                StringBuilder sb = new StringBuilder();
                for(int j=0; j<(n-map1Temp.length()); j++) {
                    sb.append(0);
                }
                sb.append(map1Temp);
                map1Temp = sb.toString();            
            }
            
            String map2Temp = Integer.toBinaryString(arr2[i]);
            if(map2Temp.length() != n) {
                StringBuilder sb = new StringBuilder();
                for(int j=0; j<(n-map2Temp.length()); j++) {
                    sb.append(0);
                }
                sb.append(map2Temp);
                map2Temp = sb.toString();            
            }
            //System.out.println(map1Temp);
            //System.out.println(map2Temp);
            
            if(map1Temp.charAt(k%5) == '0' && map2Temp.charAt(k%5) == '0') {
                map[i][k%5] = 0;
            } else { //벽
                map[i][k%5] = 1;
            }
            k++;
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        
        String[] answer = {};
        return answer;*/
    }
}