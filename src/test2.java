import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        boolean[][] arrays = new boolean[10][7];
//0
        arrays[0][0] = true;
        arrays[0][1] = true;
        arrays[0][2] = true;
        arrays[0][3] = true;
        arrays[0][4] = true;
        arrays[0][5] = true;
        arrays[0][6] = false;
//1
        arrays[1][0] = false;
        arrays[1][1] = false;
        arrays[1][2] = true;
        arrays[1][3] = true;
        arrays[1][4] = false;
        arrays[1][5] = false;
        arrays[1][6] = false;
//2
        arrays[2][0] = false;
        arrays[2][1] = true;
        arrays[2][2] = true;
        arrays[2][3] = false;
        arrays[2][4] = true;
        arrays[2][5] = true;
        arrays[2][6] = true;
//3
        arrays[3][0] = false;
        arrays[3][1] = true;
        arrays[3][2] = true;
        arrays[3][3] = true;
        arrays[3][4] = true;
        arrays[3][5] = false;
        arrays[3][6] = true;
//4
        arrays[4][0] = true;
        arrays[4][1] = false;
        arrays[4][2] = true;
        arrays[4][3] = true;
        arrays[4][4] = false;
        arrays[4][5] = false;
        arrays[4][6] = true;
//5
        arrays[5][0] = true;
        arrays[5][1] = true;
        arrays[5][2] = false;
        arrays[5][3] = true;
        arrays[5][4] = true;
        arrays[5][5] = false;
        arrays[5][6] = true;
//6
        arrays[6][0] = true;
        arrays[6][1] = true;
        arrays[6][2] = false;
        arrays[6][3] = true;
        arrays[6][4] = true;
        arrays[6][5] = true;
        arrays[6][6] = true;
//7
        arrays[7][0] = false;
        arrays[7][1] = true;
        arrays[7][2] = true;
        arrays[7][3] = true;
        arrays[7][4] = false;
        arrays[7][5] = false;
        arrays[7][6] = false;
//8
        arrays[8][0] = true;
        arrays[8][1] = true;
        arrays[8][2] = true;
        arrays[8][3] = true;
        arrays[8][4] = true;
        arrays[8][5] = true;
        arrays[8][6] = true;
//9
        arrays[9][0] = true;
        arrays[9][1] = true;
        arrays[9][2] = true;
        arrays[9][3] = true;
        arrays[9][4] = true;
        arrays[9][5] = false;
        arrays[9][6] = true;

        Scanner sc  =  new Scanner(System.in);
        String str = sc.nextLine();

        int length = str.length();
        int result = 0;
        boolean[] previous = new boolean[]{false,false,false,false,false,false,false};
        for (int i = 0; i < length; i++) {
//            int charValue = Integer.parseInt(str,i);
            int charValue = str.charAt(i)-'0';
            for (int j = 0; j < 7; j++) {
                if (arrays[charValue][j] ^ previous[j]){
                    result++;
                }
            }
            previous = arrays[charValue];
        }
        System.out.println(result);
    }
}
