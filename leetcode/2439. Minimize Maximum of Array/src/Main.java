public class Main {

    public int minimizeArrayValue(int[] nums) {
        int max = 0;
        double cur = 0;
        for (int i = 0; i < nums.length; i++)
        {
            cur += nums[i];
            max = Math.max(max, (int)Math.ceil(cur / (i + 1)));
        }
        return max;
    }

    public static void main(String[] args) {
        Main ds = new Main();
        System.out.println("5: " + ds.minimizeArrayValue(new int[]{3,7,1,6}));
        System.out.println("10: " + ds.minimizeArrayValue(new int[]{10, 1}));
        System.out.println("16: " + ds.minimizeArrayValue(new int[]{13,13,20,0,8,9,9}));
        System.out.println("8: " + ds.minimizeArrayValue(new int[]{6,9,3,8,14}));
    }
}



//13 20
//14 19
//15 18
//16 17
//17 16
//
//0 8


//5 10 = 15
//6 9  = 15
//7 8  = 15
//8 7  = 15
//
//10 + 5 = 15
//15 / 2 = 7,5
//
//i = (i + i - 1) - (i + i - 1) / 2;
//
//10 5
//
//
//7 10
//9 8