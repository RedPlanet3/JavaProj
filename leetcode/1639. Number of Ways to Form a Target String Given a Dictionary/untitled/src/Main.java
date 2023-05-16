
public class Main {
    final int MOD = 1000000000 + 7;

    public long avaliblePref(long[][]pref, int position, long mult, int ind)
    {
        long ch = 0;
        for (int i = ind + 1; i < pref[position].length; i++)
            ch += pref[position][i];
        return ch * mult % MOD;
    }
    public long count(int[][]poss,long[][]pref, int ind, int position, long mult)
    {
        long ch = 0;
        if (position < poss.length - 1)
        {
            for (int i = ind + 1; i < poss[position].length; i++) {
                    if (poss[position][i] > 0 )
                    {
                        if (pref[position][i] > 0)
                            return pref[position][i] * mult % MOD;
                        else pref[position][i] = count(poss, pref, i, position + 1, poss[position][i] % MOD) + avaliblePref(pref, position + 1, mult, i);
                    }
//                if (ch == 0) ch = pref[position][i] * mult % MOD;
                if (pref[position][i] != -1) {
                    ch += pref[position][i] * mult % MOD;
//                    ch %= MOD;
                }
            }
        }
//        else if (position == poss.length - 1)
//        {
//            for (int i = ind + 1; i < poss[position].length; i++)
//                ch += poss[position][i];
//            if (ch == 0) return -1;
//            //pref[position][ind + 1] = ch * mult % MOD;
//            return ch * mult % MOD;
//        }
        return ch;
    }

    public void fullPoss(char[] str, int[][]poss, int [][]indexes, char[] target)
    {
        for (int i = 0; i < indexes.length; i++)
        {
            for (int j = indexes[i][0]; j < indexes[i][1] + 1; j++)
                if (str[j] == target[i])
                    poss[i][j] += 1;
        }
    }

    public int numWays(String[] words, String target) {
        int ind = words[0].length() - target.length();
        int [][]indexes = new int[target.length()][2];
        for(int i = 0; i < target.length(); i++)
            indexes[i] = new int[]{i, ind++};
        long[][]pref = new long[target.length()][words[0].length()];
        int[][]poss = new int[target.length()][words[0].length()];
        char[] tg = target.toCharArray();
        for (String str : words)
            fullPoss(str.toCharArray(), poss, indexes, tg);
        for(int i = 0; i < poss[0].length; i++)
        {
            pref[pref.length - 1][i] = poss[pref.length - 1][i];
        }
        long answ = count(poss,pref, -1, 0, 1);
        if (answ == -1) return 0;

        return (int)(answ % MOD);
    }

    public static void main(String[] args) {
        Main ds = new Main();
        System.out.println("6: " + ds.numWays(new String[]{"acca","bbbb","caca"}, "aba"));
//        System.out.println("4: " + ds.numWays(new String[]{"abba","baab"}, "bab"));
//        System.out.println("24: " + ds.numWays(new String[]{"cbdbc","adbbd","dcbbb","bcacc","acccb"}, "bbcc"));
//        System.out.println("677452090: " + ds.numWays(new String[]{"cbabddddbc","addbaacbbd","cccbacdccd","cdcaccacac","dddbacabbd","bdbdadbccb","ddadbacddd","bbccdddadd","dcabaccbbd","ddddcddadc","bdcaaaabdd","adacdcdcdd","cbaaadbdbb","bccbabcbab","accbdccadd","dcccaaddbc","cccccacabd","acacdbcbbc","dbbdbaccca","bdbddbddda","daabadbacb","baccdbaada","ccbabaabcb","dcaabccbbb","bcadddaacc","acddbbdccb","adbddbadab","dbbcdcbcdd","ddbabbadbb","bccbcbbbab","dabbbdbbcb","dacdabadbb","addcbbabab","bcbbccadda","abbcacadac","ccdadcaada","bcacdbccdb"},
//                "bcbbcccc"));
//        System.out.println("2: " + ds.numWays(new String[]{"bcc","cdc","ccd","dac"}, "ca"));
//        System.out.println("555996654: " + ds.numWays(new String[]{"cabbaacaaaccaabbbbaccacbabbbcb","bbcabcbcccbcacbbbaacacaaabbbac","cbabcaacbcaaabbcbaabaababbacbc","aacabbbcaaccaabbaccacabccaacca","bbabbaabcaabccbbabccaaccbabcab","bcaccbbaaccaabcbabbacaccbbcbbb","cbbcbcaaaacacabbbabacbaabbabaa","cbbbbbbcccbabbacacacacccbbccca","bcbccbccacccacaababcbcbbacbbbc","ccacaabaaabbbacacbacbaaacbcaca","bacaaaabaabccbcbbaacacccabbbcb","bcbcbcabbccabacbcbcaccacbcaaab","babbbcccbbbbbaabbbacbbaabaabcc","baaaacaaacbbaacccababbaacccbcb","babbaaabaaccaabacbbbacbcbababa","cbacacbacaaacbaaaabacbbccccaca","bcbcaccaabacaacaaaccaabbcacaaa","cccbabccaabbcbccbbabaaacbacaaa","bbbcabacbbcabcbcaaccbcacacccca","ccccbbaababacbabcaacabaccbabaa","caaabccbcaaccabbcbcaacccbcacba","cccbcaacbabaacbaaabbbbcbbbbcbb","cababbcacbabcbaababcbcabbaabba","aaaacacaaccbacacbbbbccaabcccca","cbcaaaaabacbacaccbcbcbccaabaac","bcbbccbabaccabcccacbbaacbbcbba","cccbabbbcbbabccbbabbbbcaaccaab","acccacccaabbcaccbcaaccbababacc","bcacabaacccbbcbbacabbbbbcaaaab","cacccaacbcbccbabccabbcbabbcacc","aacabbabcaacbaaacaabcabcaccaab","cccacabacbabccbccaaaaabbcacbcc","cabaacacacaaabaacaabababccbaaa","caabaccaacccbaabcacbcbbabccabc","bcbbccbbaaacbaacbccbcbababcacb","bbabbcabcbbcababbbbccabaaccbca","cacbbbccabaaaaccacbcbabaabbcba","ccbcacbabababbbcbcabbcccaccbca","acccabcacbcbbcbccaccaacbabcaab","ccacaabcbbaabaaccbabcbacaaabaa","cbabbbbcabbbbcbccabaabccaccaca","acbbbbbccabacabcbbabcaacbbaacc","baaababbcabcacbbcbabacbcbaaabc","cabbcabcbbacaaaaacbcbbcacaccac"},
//                "acbaccacbbaaabbbabac"));
//        System.out.println("555996654: " + ds.numWays(new String[]{"bcbccbccacccacaababcbcbbacbbbc","ccacaabaaabbbacacbacbaaacbcaca","bacaaaabaabccbcbbaacacccabbbcb","bcbcbcabbccabacbcbcaccacbcaaab","babbbcccbbbbbaabbbacbbaabaabcc","baaaacaaacbbaacccababbaacccbcb","babbaaabaaccaabacbbbacbcbababa","cbacacbacaaacbaaaabacbbccccaca","bcbcaccaabacaacaaaccaabbcacaaa","cccbabccaabbcbccbbabaaacbacaaa","bbbcabacbbcabcbcaaccbcacacccca","ccccbbaababacbabcaacabaccbabaa","caaabccbcaaccabbcbcaacccbcacba","cccbcaacbabaacbaaabbbbcbbbbcbb","cababbcacbabcbaababcbcabbaabba","aaaacacaaccbacacbbbbccaabcccca","cbcaaaaabacbacaccbcbcbccaabaac","bcbbccbabaccabcccacbbaacbbcbba","cccbabbbcbbabccbbabbbbcaaccaab","acccacccaabbcaccbcaaccbababacc","bcacabaacccbbcbbacabbbbbcaaaab","cacccaacbcbccbabccabbcbabbcacc","aacabbabcaacbaaacaabcabcaccaab","cccacabacbabccbccaaaaabbcacbcc","cabaacacacaaabaacaabababccbaaa","caabaccaacccbaabcacbcbbabccabc","bcbbccbbaaacbaacbccbcbababcacb","bbabbcabcbbcababbbbccabaaccbca"},
//                "acbaccacbbaaabbbabac"));
//        System.out.println("595572814: " + ds.numWays(new String[]{"cabbaacaaaccaabbbbacca","bbcabcbcccbcacbbbaacac","cbabcaacbcaaabbcbaabaa","aacabbbcaaccaabbaccaca","bbabbaabcaabccbbabccaa","bcaccbbaaccaabcbabbaca","cbbcbcaaaacacabbbabacb","cbbbbbbcccbabbacacacac","bcbccbccacccacaababcbc","ccacaabaaabbbacacbacba","bacaaaabaabccbcbbaacac","bcbcbcabbccabacbcbcacc","babbbcccbbbbbaabbbacbb","baaaacaaacbbaacccababb","babbaaabaaccaabacbbbac","cbacacbacaaacbaaaabacb","bcbcaccaabacaacaaaccaa","cccbabccaabbcbccbbabaa","bbbcabacbbcabcbcaaccbc","ccccbbaababacbabcaacab","caaabccbcaaccabbcbcaac","cccbcaacbabaacbaaabbbb","cababbcacbabcbaababcbc","aaaacacaaccbacacbbbbcc","cbcaaaaabacbacaccbcbcb","bcbbccbabaccabcccacbba","cccbabbbcbbabccbbabbbb","acccacccaabbcaccbcaacc","bcacabaacccbbcbbacabbb","cacccaacbcbccbabccabbc","aacabbabcaacbaaacaabca","cccacabacbabccbccaaaaa","cabaacacacaaabaacaabab","caabaccaacccbaabcacbcb","bcbbccbbaaacbaacbccbcb","bbabbcabcbbcababbbbcca"},
//                "acbaccacbbaaabbbabac"));
//        System.out.println("595572814: " + ds.numWays(new String[]{"bbcabbbacbccbaaaabbbbbcccbcbab","bbbcaacbbabcacbcbabbcabbbcacaa","cabcbacabbacccccacccbabcbccbcc","cbbaacbbbcccbbcbcaacbbaaccbaac","bcacccccabbbaccbcbcacbcabaacab","bbbbabcbbacccabcaccabaaabaaabc","bcbcbacababcbaabaacbabbbcbbacb","cbaacbcccbacbcbbccbbabbabbbcab","bcaccabcabaacbaaabccaabcbabcac","bcababaaaccabccbcccababbbbcbaa","bbbbacccacababbcacaacbbcbcbabb","baacaabbcaccbbacabcbaccaaaaabc","bbcbaaaccbcbbcbaaaccbbbbbbbacc","abbcacbababbbcbbcaacbbaaaabaca","abccbcbbcacabaacccacaacbcbcbaa","cbccaaaacbccbaabbcccbcacbaccba","bbacbaabaccaabcaacaacccbbbbcba","ccbbbaaaacaaacabababaacccbaaca","cccacacaaabaaaabcaccabcacbbccb","bccaacacccccaaaabacbcbbcccabbb","bcbaabacbaaabbcbaabaacaacabaca","cbccccccbaccbcaaaccacccaacaccc","bbbabbabaaaccccbbabbbcababacca","acaaacabccacabcbcaaacccaabbacb","aaaccabbbbbaacacabcbacccbbaaab","cbbcababababcaabcbaacccbcbacca","aacabcacbccaababbacbabcbcbbcab","caaaaabbccccbcccaabacccabacaba","bbcbaabacbccaabaccababaabbccba","cbabcacbbbacaaababcaaccccbabba","caabbcaaaacbcabccbcbcccbbbbacc","bccabaaaaabbcabbbcabaabbcbbaaa","baaabaccccaccbcacaacccbbcbacaa","bccacaacbaabaacbbacbcabaaacbbb","cabcbccbccbcacabcaacbbbaabaabc","accaaccbaccbbbaacacabacbaccaac","cabaabaabcbabbcaaacccbbaccbcaa","bcabbccabbaccaaaabacbbbbbcacba","bbccbbcacaaabaaaaaccacbcacbabb","ccbabaccbbacbbbaaabccbaabcccbc","ccbcccacacabcbaacbbcbcbacacaac","acacccbcbaabcacbcbbaababbcabca","aabcbbcaaabcbbaaacbbcbcabbaacc","aaacacbabaabbbacaaacbacbaabbaa","bbabacbbbabcaabbbacabbacbaccaa","ccabacacaccacabacccabcccaacbcb","cbbcbbaaabbbbaabcccbcbaacbbacb"},
//                "acabbaabcabbbcbacacb"));
//        System.out.println("16: " + ds.numWays(new String[]{"abab","baba","abba","baab"}, "abba"));

    }
}