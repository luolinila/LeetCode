package 公司命名2306;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public long distinctNames(String[] ideas) {
        Set<String>[] set = new HashSet[26];
        Arrays.setAll(set, i -> new HashSet<>());
        for (String idea : ideas) {
            set[idea.charAt(0) - 'a'].add(idea.substring(1));
        }

        long ans = 0;
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < i; j++) {
                int m = 0;
                for (String s : set[i]) {
                    if(set[j].contains(s)){
                        m ++;
                    }
                }
                ans += (long) (set[i].size() - m) * (set[j].size() - m);
            }
        }
        return ans * 2;
    }
}
