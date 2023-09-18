/**
 * 카카오 2020 키패드 누르기
 * LEVEL 1
 * https://school.programmers.co.kr/learn/courses/30/lessons/67256
 * 
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 * 
 * 1차 풀이: '이동하는 코드 누락'
 * 2차 풀이: 성공
 */
class Solution {
    public static final int[][] location = {
        {0,0}, {0,1}, {0,2}, 
        {1,0}, {1,1}, {1,2}, 
        {2,0}, {2,1}, {2,2},
        {3,0}, {3,1}, {3,2}
    };
    
    public String solution(int[] numbers, String hand) {
        StringBuilder result = new StringBuilder();

        //numbers check
        int[] now_left = {3, 0}; //*
        int[] now_right = {3, 2}; //#     
        int length = numbers.length;
        
        for(int i=0; i<length; i++) {
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                result.append("L");
                now_left[0] = location[numbers[i]-1][0];
                now_left[1] = location[numbers[i]-1][1];
            }
            else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                result.append("R");
                now_right[0] = location[numbers[i]-1][0];
                now_right[1] = location[numbers[i]-1][1];
            }
            else {
                //2, 5, 8, 0(11)
                int[] temp = new int[2];
                switch(numbers[i]) {
                    case 2: 
                        temp[0] = 0; temp[1] = 1;
                        //temp = {0, 1}; illegal start of expression
                        break;
                    case 5:
                        temp[0] = 1; temp[1] = 1;
                        break;
                    case 8:
                        temp[0] = 2; temp[1] = 1;
                        break;
                    case 0:
                        temp[0] = 3; temp[1] = 1;
                        break;
                    default:
                        break;
                }
                //거리구하기 (절댓값 => Math.abs)
                int temL = Math.abs(temp[0] - now_left[0]) + Math.abs(temp[1] - now_left[1]);
                /*int temp1 = temp[0] - now_left[0];                
                temp1 = temp1 < 0 ? (temp1) * (-1) : (temp1);
                int temp2 = temp[1] - now_left[1];                
                temp2 = temp2 < 0 ? (temp2) * (-1) : (temp2);
                int temL = temp1 + temp2;*/
                int temR = Math.abs(temp[0] - now_right[0]) + Math.abs(temp[1] - now_right[1]);
                
                if(temL < temR) {
                    result.append("L");
                    now_left[0] = temp[0];
                    now_left[1] = temp[1];
                } else if(temL > temR) {
                    result.append("R");
                    now_right[0] = temp[0];
                    now_right[1] = temp[1];
                } else {
                    if(hand.equals("left")) {
                        result.append("L");   
                        now_left[0] = temp[0];
                        now_left[1] = temp[1];
                    } else if(hand.equals("right")) {
                        result.append("R");
                        now_right[0] = temp[0];
                        now_right[1] = temp[1];
                    }
                }                
            }
        }     
        return result.toString();
    }
}