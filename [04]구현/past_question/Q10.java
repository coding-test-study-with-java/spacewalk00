/**
 * 자물쇠와 열쇠 - 2020 카카오 신입 공채
 * https://school.programmers.co.kr/learn/courses/30/lessons/60059
 * 1. 자물쇠 영역 확장 후
 * 2. 키 회전
 * 3. key와 lock이 알맞게 맞물리는 지 확인
 */
class Solution {
    public void match(int[][] newLock, int[][] key, int rotation, int x, int y) {
        int len = key.length;
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                if(rotation == 0) { //0
                    newLock[x+i][y+j] += key[i][j];
                } else if (rotation == 1) { //90
                    newLock[x+i][y+j] += key[j][len-i-1];
                } else if (rotation == 2) { //180
                    newLock[x+i][y+j] += key[len-i-1][len-j-1];
                } else { //270
                    newLock[x+i][y+j] += key[len-j-1][i];
                }
            }
        }        
    }
    
    public boolean check(int[][] newLock, int key_len, int lock_len) {
        for(int i = 0; i < lock_len; i++) {
            for(int j = 0; j < lock_len; j++) {
                if(newLock[(key_len - 1) + i][(key_len - 1) + j] != 1) return false;
            }
        }
        return true;
    }
    
    public boolean solution(int[][] key, int[][] lock) {
        for(int x = 0; x < (key.length - 1) + lock.length; x++) { //이동 횟수: key.length - 1 + lock.length
            for(int y = 0; y < (key.length - 1) + lock.length; y++) {
                
                //0, 90, 180, 270 -> (4번 회전)
                for(int r = 0; r < 4; r++) {
                    int[][] newLock = new int[lock.length + key.length * 2][lock.length + key.length * 2]; //확장 배열 생성
                    for(int i = 0; i < lock.length; i++) {
                        for(int j = 0; j < lock.length; j++) {
                            newLock[i + (key.length - 1)][j + (key.length - 1)] = lock[i][j]; //확장 배열 초기화                         
                        }
                    }
                    //newLock배열에 key배열을 더해서 합친 게 전부 1이면 true
                    match(newLock, key, r, x, y);
                    if(check(newLock, key.length, lock.length)) return true;
                }
            }
        }
        return false;
    }
}