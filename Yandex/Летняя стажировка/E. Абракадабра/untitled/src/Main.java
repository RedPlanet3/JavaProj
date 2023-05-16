import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static int incSum( int [] answ)
    {
        int sum = 0;
        for (int num : answ)
            sum += num;
        return sum;
    }

        public static long wods(int n, int k, long[] pos, long[] diff, int[] str)
        {
            long sum = 0;
            int count;
            int m;
            int l;
            int position;
            int [] answ = new int[26];
            boolean limit = false;
            int []visit = new int[str.length];
            for(int r = 0; r < str.length; r++) {
                limit = false;
                count = 0;
                while (!limit && count++ < k) {
                    m = 1;
                    visit = new int[str.length];
                    answ = new int[26];
                    l = 0;
                    position = r;
                    while (!limit && l < count) {
                        visit[position] += 1;
                        if (visit[position] == 26) {
                            limit = true;
                            break;
                        }
                        answ[(str[position] + (visit[position] - 1) * diff[position]) % 26] = 1;
                        l++;
//                        m = l / str.length + 1;
//                        if (m == 26) limit = true;
                        position = pos[position] - 1;
                    }
                    sum += incSum(answ);
                    if (limit) {
                        sum += (long) (k - count) * incSum(answ);
                        break;
                    }
                }
            }
            return sum;
        }

    public static int[] charToInt(char[] nums)
    {
        int[] answ = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
            answ[i] = nums[i] - 'a';
        return answ;
    }

        public static long[] strToLong(String[] nums)
        {
            long[] answ = new long[][nums.length];
            for (int i = 0; i < nums.length; i++)
                answ[i] = Long.parseLong(nums[i]);
            return answ;
        }
        public static void main(String[] args) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            long[] nk = strToLong(reader.readLine().trim().split(" "));
            int[] str = charToInt(reader.readLine().toCharArray());
            long[] pos = strToLong(reader.readLine().trim().split(" "));
            long[] diff = strToLong(reader.readLine().trim().split(" "));
            System.out.println(wods(nk[0], nk[1], pos, diff, str));
    }
}

//1000000000
//2147483647