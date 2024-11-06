package 查找给定哈希值的子串2156;

class Solution {
    public String subStrHash(String S, int power, int mod, int k, int hashValue) {
        char[] s = S.toCharArray();
        int n = s.length;
        // 用秦九韶算法计算 s[n-k:] 的哈希值，同时计算 pk=power^k
        long hash = 0, pk = 1;
        for (int i = n - 1; i >= n - k; i--) {
            hash = (hash * power + (s[i] & 31)) % mod;
            pk = pk * power % mod;
        }
        int ans = hash == hashValue ? n - k : 0;
        // 向左滑窗
        for (int i = n - k - 1; i >= 0; i--) {
            // 计算新的哈希值，注意 +mod 防止计算出负数
            hash = (hash * power + (s[i] & 31) - pk * (s[i + k] & 31) % mod + mod) % mod;
            if (hash == hashValue) {
                ans = i;
            }
        }
        return S.substring(ans, ans + k);
    }
}
