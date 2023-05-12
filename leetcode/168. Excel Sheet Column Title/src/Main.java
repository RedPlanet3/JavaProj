public class Main {
    public String convertToTitle(int columnNumber) {
        StringBuilder row = new StringBuilder();
        char tmp;
        while (columnNumber > 0)
        {
            columnNumber--;
//            if (columnNumber % 26 == 0) {
//                columnNumber--;
//                tmp = 'Z';
//            }
//            else
//                tmp = (char)('A' + columnNumber % 26 - 1);
            row.insert(0,(char)('A' + columnNumber % 26));
            columnNumber = columnNumber / 26;
        }
        return row.toString();
    }

    public static void main(String[] args) {
        Main ds = new Main();
        System.out.println("A: " + ds.convertToTitle(1));
        System.out.println("C: " + ds.convertToTitle(3));
        System.out.println("Z: " + ds.convertToTitle(26));
        System.out.println("AC: " + ds.convertToTitle(29));
        System.out.println("AB: " + ds.convertToTitle(28));
        System.out.println("ZY: " + ds.convertToTitle(701));
    }
}
