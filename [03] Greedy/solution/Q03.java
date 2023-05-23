import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q03 {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        
        int result = 0;
        if(str != null) {
            StringTokenizer str1 = new StringTokenizer(str, "0");
            StringTokenizer str2 = new StringTokenizer(str, "1");
            
            result = Math.min(str1.countTokens(), str2.countTokens());
            System.out.println(result);
        }
    }
}