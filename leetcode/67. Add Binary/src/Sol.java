public class Sol {

//    Example 1:
//    Input: a = "11", b = "1"
//    Output: "100"

//    Example 2:
//    Input: a = "1010", b = "1011"
//    Output: "10101"

//    1011
//    1010
//    10101
//
//    01234 = 5
//    99999
//       99
//    5 - 2 = 3

    public String addBinary(String a, String b) {
        String big = a.length() > b.length() ? a: b;
        String smal = a.length() <= b.length() ? a: b;
        char []answ = new char[big.length() + 1];
        answ[0] = '1';
        boolean plusOne = false;
        for (int i = 0; i < big.length(); i++)
            answ[i + 1] = big.charAt(i);
        int endSmal = smal.length() - 1;
        for (int i = answ.length - 1; i > 0; i--)
        {
            if (endSmal > -1)
            {
                if (plusOne) {
                    if (answ[i] == '1') {
                        answ[i] = '0';
                        plusOne = true;
                    }
                    else {
                        answ[i] = '1';
                        plusOne = false;
                    }
                }
                if (smal.charAt(endSmal) == '1') {
                    if (answ[i] == '1') {
                        answ[i] = '0';
                        plusOne = true;
                    }
                    else
                        answ[i] = '1';
                }
                endSmal--;
            }
            else if (plusOne) {
                if (answ[i] == '1') {
                    answ[i] = '0';
                    plusOne = true;
                }
                else {
                    answ[i] = '1';
                    plusOne = false;
                }
            }
            else
                return String.copyValueOf(answ).substring(1);
        }
        if (a.equals("0") || b.equals("0"))
            return String.copyValueOf(answ).substring(1);
        return String.copyValueOf(answ);
    }

    public static void main(String[] args) {
        System.out.println("0:\t" + new Sol().addBinary("0", "0"));
        System.out.println("1:\t" + new Sol().addBinary("0", "1"));
        System.out.println("1:\t" + new Sol().addBinary("1", "0"));
        System.out.println("10:\t" + new Sol().addBinary("1", "1"));
        System.out.println("100:\t" + new Sol().addBinary("11", "1"));
        System.out.println("10101:\t" + new Sol().addBinary("1010", "1011"));
        System.out.println("11:\t" + new Sol().addBinary("11", "0"));
        System.out.println("11:\t" + new Sol().addBinary("10", "1"));
        System.out.println("11001:\t" + new Sol().addBinary("11000", "1"));
    }

}
