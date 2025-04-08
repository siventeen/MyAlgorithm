package Examination.xiaohongshu;

import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int id = scanner.nextInt();
        int[][] powers = new int[n][m];
        int[] personPower = new int[n];
        int ans = 1;
        for (int i = 0; i < n; i++) {
            int temp = 0;
            for (int j = 0; j < m; j++) {
                powers[i][j] = scanner.nextInt();
                temp+=powers[i][j];
            }
            personPower[i] = temp;
        }
        for (int i = 0; i < n; i++) {
            if (personPower[i]>personPower[id-1] || (personPower[i]==personPower[id-1] && i<id-1)){
                ans++;
            }
        }
        System.out.println(ans);
    }
}
