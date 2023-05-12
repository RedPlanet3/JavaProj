//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.HashMap;
//
//
//class Stack
//{
//    static StringBuilder answ = new StringBuilder();
//    static HashMap<String, Long> dictVal = new HashMap<>();
//    static ArrayList<Object[]> arr = new ArrayList<>();
//    public static void pushAll(long n, String val)
//    {
//        arr.add(new Object[]{val,n});
//        if (!dictVal.containsKey(val))
//            dictVal.put(val,0L);
//        dictVal.put(val,dictVal.get(val) + n);
//    }
//
//    public static void popAll(long n)
//    {
//        while (n > 0)
//        {
//            if (n - (long)back()[1] < 0)
//            {
//                Object[] tmp = back();
//                tmp[1] = (long)tmp[1] - n;
//                dictVal.put((String) tmp[0],dictVal.get((String) tmp[0]) - n);
//                n = 0;
//            }
//            else
//            {
//                Object[] tmp = back();
//                n = n - (long)tmp[1];
//                pop();
//                dictVal.put((String) tmp[0],dictVal.get((String) tmp[0]) - (long)tmp[1]);
//            }
//        }
//    }
//    public static void pop()
//    {
//        arr.remove(arr.size() - 1);
//    }
//
//    public static Object[] back()
//    {
//        return arr.get(arr.size() - 1);
//
//    }
//    public static void   getVal(String val)
//    {
//        if (!dictVal.containsKey(val))
//            answ.append(0).append('\n');
//        else
//            answ.append(dictVal.get(val)).append('\n');
//    }
//
//    public static void  getValBad(String val)
//    {
//        int ch = 0;
//        for (Object[] str: arr) {
//            if (str[0].equals(val))
//                ch += (long)str[1];
//        }
//        answ.append(ch).append('\n');
//    }
//    public static void printRes()
//    {
//        System.out.println(answ);
//    }
//
//}
//public class Main {
//    public static void main(String[] args) throws IOException {
//        Stack train = new Stack();
//        BufferedReader in = new BufferedReader(new FileReader("input.txt"));
//        int n = Integer.parseInt(in.readLine());
//        String []str;
//        for (long i = 0L; i < n; i++){
//            str = in.readLine().trim().split(" ");
//            switch (str[0]) {
//                case ("add") -> train.pushAll(Long.parseLong(str[1]), str[2]);
//                case ("delete") -> train.popAll(Long.parseLong(str[1]));
//                case ("get") -> train.getVal(str[1]);
//            }
//        }
//        in.close();
//        train.printRes();
//    }
//}