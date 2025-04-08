package SF;

import java.util.Scanner;

public class SF2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        String str=sc.nextLine();
        if(n<=0){
            System.out.println(0);
            return;
        }
        long[] dp=new long[n];
        dp[0]=1;
        for (int i = 1; i < n; i++) {
            if(str.charAt(i)=='1'||str.charAt(i)=='0'){
                if(str.charAt(i-1)=='1'&&i>1){
                    dp[i]=dp[i-1]+dp[i-2];
                    continue;
                }
                if(str.charAt(i-1)=='1'&&i==1){
                    dp[i]=dp[i-1]+1;
                    continue;
                }
                dp[i]=dp[i-1];

            }else{
                dp[i]=dp[i-1];
            }
        }

        System.out.println(dp[n - 1]%1000000007);

    }
}
