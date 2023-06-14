package Q6_2;

//Person 클래스 선언 -> 정렬을 위해 Comparable 인터페이스를 구현현
public class Person implements Comparable<Person> {
    private String name;
    private int score;
    
    public Person(String name, int score) {
        this.name = name;
        this.score = score;
    }
    
    public Person() {
        name = "";
        score = -1;
    }
    
    public String getName() {
        return name;
    }
    
    public int getScore() {
        return score;
    }
    
    @Override
    public int compareTo(Person other) {
        if (this.score < other.score) {
            return -1;
        }
        return 1;
    }
    
    @Override
    public String toString() {
        return name + " " + score;
    }
}