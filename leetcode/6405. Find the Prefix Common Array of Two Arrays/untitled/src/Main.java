import java.util.HashSet;

public class Main {
    public static int[] findThePrefixCommonArray(int[] A, int[] B) {
        int []com = new int[A.length];
        HashSet<Integer> setA = new HashSet<>();
        HashSet<Integer> setB = new HashSet<>();
        for (int i = 0; i < A.length; i++)
        {
            setA.add(A[i]);
            setB.add(B[i]);
            HashSet<Integer> tmp = new HashSet<>(setA);
            tmp.retainAll(setB);
            com[i] = tmp.size();
        }
        return com;
    }

    public static void main(String[] args) {
        System.out.println("0 2 3 4: " + findThePrefixCommonArray(new int[]{1,3,2,4}, new int[]{3,1,2,4}));
        System.out.println("0,1,3: " + findThePrefixCommonArray(new int[]{2,3,1}, new int[]{3,1,2}));

    }
}