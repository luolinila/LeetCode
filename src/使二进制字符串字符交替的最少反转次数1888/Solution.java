package 使二进制字符串字符交替的最少反转次数1888;

class Solution {
    public int minFlips(String s) {
        String s2 = s+s;
        int left = 0;
        int currentNum1 = 0;
        int currentNum2 = 0;
        int ans = Integer.MAX_VALUE;
        int k = s.length();

        for(int right=0;right<s2.length();right++){
            if((right%2==0&&s2.charAt(right)=='0')||(right%2==1&&s2.charAt(right)=='1')){
                currentNum1 ++;
            }else{
                currentNum2 ++;
            }

            if(right-left+1<k){
                continue;
            }

            ans = Math.min(Math.min(ans,currentNum1),currentNum2);

            if((left%2==0&&s2.charAt(left)=='0')||(left%2==1&&s2.charAt(left)=='1')){
                currentNum1 --;
            }else{
                currentNum2 --;
            }
            left++;
        }

        return ans;
    }
}
