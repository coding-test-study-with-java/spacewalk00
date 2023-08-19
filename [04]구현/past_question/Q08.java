import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
//import java.util.stream.Collectors;

//문자열 재정렬
public class Q08 {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        
        List<Character> charList = new ArrayList<>();
        int sum = 0;
        for(int i=0; i<str.length();i++) {
            char c = str.charAt(i);
            if(c >= 'A' && c <= 'Z') {
                charList.add(c);
            } else {
                sum += c - '0';
            }
        }
        Collections.sort(charList);
        
        //문자리스트를 String으로 변환 (stream 사용하는 방법)
        /*String result = charList.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining());
        */
        StringBuilder sb = new StringBuilder();
        for(Character ch : charList) {
            sb.append(ch);
        }
        String result = sb.toString();
        System.out.println(result+""+sum);
    }
}