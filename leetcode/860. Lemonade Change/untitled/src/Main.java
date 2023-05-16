public class Main {

    public static boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int bill : bills)
        {
            if (bill == 5)
                five++;
            else if (bill == 10 && five > 0) {
                ten++;
                five--;
            }
            else if (bill == 20)
            {
                if (ten > 0)
                {
                    if (five > 0)
                    {
                        ten--;
                        five--;
                    }
                    else
                        return false;
                }
                else if (five > 2)
                    five -= 3;
                else return false;
            }
            else return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("true: " + lemonadeChange(new int[]{5,5,5,10,20}));
        System.out.println("false: " + lemonadeChange(new int[]{10,10}));
        System.out.println("false: " + lemonadeChange(new int[]{5,5,10,10,20}));
    }
}