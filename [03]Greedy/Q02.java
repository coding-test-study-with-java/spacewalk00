import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q02 {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        
        char[] strArr = str.toCharArray(); 
        int size = strArr.length;
        
        int sum = 0;
        for(int i = 0; i < size; i++) {
            if(i == 0) {
                sum = strArr[i] - '0';
            }
            else if(i != 0 && strArr[i-1] == '0') {
                sum = sum + (strArr[i] - '0');
            } 
            else {
                sum = sum * (strArr[i] - '0');
            }
        }
        System.out.println(sum);
    }
}