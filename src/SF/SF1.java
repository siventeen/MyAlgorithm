package SF;

import java.util.Scanner;

public class SF1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        String str=sc.nextLine();
        int[] dp=new int[n];

        if(str.charAt(0)=='0'){
            dp[0]=0;
        }else{
            dp[0]=1;
        }
        for (int i = 1; i < n; i++) {
            if(str.charAt(i)=='0'){
                dp[i]=Math.max(dp[i-1]-1,0);
            }else{
                dp[i]=Math.max(dp[i-1]+1,1);
            }
        }

        int ans=0;
        for (int i = 0; i < n; i++) {
            if(dp[i]>ans){
                ans=dp[i];
            }
        }
        System.out.println(ans);

    }
}
