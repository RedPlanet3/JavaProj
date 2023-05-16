import java.util.TreeSet;

class SmallestInfiniteSet {

    TreeSet<Integer> set;
    TreeSet<Integer> del;
    public SmallestInfiniteSet() {
        set = new TreeSet<>();
        set.add(1);
        del = new TreeSet<>();
    }

    public int popSmallest() {
        if (!set.isEmpty()) {
            del.add(set.first());
            int i = set.first() + 1;
            while (del.contains(i)) i++;
            set.add(i);
            return set.pollFirst();
        }
        return 0;
    }

    public void addBack(int num) {
        if (del.contains(num)) del.remove(num);
        set.add(num);
    }
}


//["SmallestInfiniteSet","addBack","popSmallest","popSmallest","popSmallest","addBack","popSmallest","popSmallest","popSmallest"]
public class Main {
    public static void main(String[] args) {

          SmallestInfiniteSet obj = new SmallestInfiniteSet();
          obj.addBack(2);
        System.out.println(obj.popSmallest());
        System.out.println(obj.popSmallest());
        System.out.println(obj.popSmallest());
        obj.addBack(1);
        System.out.println(obj.popSmallest());
        System.out.println(obj.popSmallest());
        System.out.println(obj.popSmallest());
    }
}
