class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length < 1)
            return "";
        int ind = -1;
        boolean b = true;
        char tmp;
        while (b)
        {
            ind++;
            if(ind >= strs[0].length())
            {
                b = false;
                break;
            }
            tmp = strs[0].charAt(ind);
            for(int i = 1; i < strs.length; i++)
            {
                if(ind >= strs[i].length())
                {
                    b = false;
                    break;
                }
                if (strs[i].charAt(ind) != tmp) {
                    b = false;
                    break;
                }
            }
        }
        return (strs[0].substring(0, ind));
    }

    public static void main(String[] args) {
        Solution sp = new Solution();
        System.out.println(sp.longestCommonPrefix(new String[]{"", "12344", "12345678", "1234546"}));
    }
}