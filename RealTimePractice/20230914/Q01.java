/**
 * 카카오 키패드 누르기
 * https://school.programmers.co.kr/learn/courses/30/lessons/67256
 * 미완성
 */
class Solution {
    //public static final int dx[] = {0, 0, -1, 1}; //상하좌우
    //public static final int dy[] = {-1, 1, 0, 0};
    
    public String solution(int[] numbers, String hand) {
        StringBuilder result = new StringBuilder();
        
        int[][] keypad = new int[3][4];
        int value = 1;
        for(int i = 0; i < 3; i++) {
            for(int j=0; j < 4; j++) {
                keypad[i][j] = value++;
                //*:10 0: 11 #:12
            }
        }
        
        //numbers check
        int[] now_left = {3, 0}; //*
        int[] now_right = {3, 2}; //#     
        int length = numbers.length;
        
        for(int i=0; i<length; i++) {
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                result.append("L");
            }
            else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                result.append("R");
            }
            else {
                //2, 5, 8, 0(11)
                //거리 구하기
                int[] temp = new int[2];
                switch(numbers[i]) {
                    case 2: 
                        temp[0] = 0;
                        temp[1] = 1;
                        //temp = {0, 1};
                        break;
                    case 5:
                        temp[0] = 1;
                        temp[1] = 1;
                        //temp = {1, 1};
                        break;
                    case 8:
                        temp[0] = 2;
                        temp[1] = 1;
                        //temp = {2, 1};
                        break;
                    case 0:
                        temp[0] = 3;
                        temp[1] = 1;
                        //temp = {3, 1};
                        break;
                    default:
                        break;
                }
                int temp1 = temp[0] - now_left[0];                
                temp1 = temp1 < 0 ? (temp1) * (-1) : (temp1);
                int temp2 = temp[1] - now_left[1];                
                temp2 = temp2 < 0 ? (temp2) * (-1) : (temp2);
                int temL = temp1 + temp2;
                
                
                temp1 = temp[0] - now_right[0];                
                temp1 = temp1 < 0 ? (temp1) * (-1) : (temp1);
                temp2 = temp[1] - now_right[1];                
                temp2 = temp2 < 0 ? (temp2) * (-1) : (temp2);
                int temR = temp1 + temp2;
                
                if(temL < temR) {
                    result.append("L");
                } else if(temL > temR) {
                    result.append("R");
                } else {
                    if(hand.equals("left")) {
                        result.append("L");           
                    } else if(hand.equals("right")) {
                        result.append("R");
                    }
                }
                
                /*
                처음에 잘못 생각함: 좌표 거리로 구할 수 있다고 착각했음
                double distance_l = Math.pow((temp[0] - now_left[0]), 2) + Math.pow((temp[1] - now_left[1]), 2);
                double distance_r = Math.pow((temp[0] - now_right[0]), 2) + Math.pow((temp[1] - now_right[1]), 2);
                
                if(distance_l > distance_r) {
                    result.append("L");
                } else if(distance_l < distance_r) {
                    result.append("R");
                } else {
                    if(hand.equals("left")) {
                        result.append("L");           
                    } else if(hand.equals("right")) {
                        result.append("R");
                    }
                }*/
                
                
            }
        }     
        return result.toString();
    }
    
}