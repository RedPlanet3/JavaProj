public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.romanToInt("III")); //3
        System.out.println(s.romanToInt("LVIII")); //58
        System.out.println(s.romanToInt("MCMXCIV")); //1994
        System.out.println(s.romanToInt("XXVII")); //27
        System.out.println(s.romanToInt("")); //0
    }
}
