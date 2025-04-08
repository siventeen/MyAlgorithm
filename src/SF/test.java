package SF;

public class test {
    public static void main(String[] args) {
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            sb.append('1');

        }
        System.out.println(sb.toString());
    }
}
