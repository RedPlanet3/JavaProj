import java.util.ArrayList;

public class Main {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int pushInd = 0;
        int popInd = 0;
        int i = 1;
        while (popInd < pushed.length && i < pushed.length + 1)
        {
            if (pushInd > -1 && pushed[pushInd] == popped[popInd]) {
                popInd++;
                pushInd--;
            } else {
                pushInd++;
                if (pushInd > -1 && i < pushed.length) pushed[pushInd] = pushed[i];
                else break;
                i++;
            }
        }
        return pushInd == -1;
    }
    public static void main(String[] args) {
        Main ds = new Main();
        System.out.println("true: " + ds.validateStackSequences(new int[]{1,2,3,4,5}, new int[]{4,5,3,2,1}));
        System.out.println("false: " + ds.validateStackSequences(new int[]{1,2,3,4,5}, new int[]{4,3,5,1,2}));
        System.out.println("false: " + ds.validateStackSequences(new int[]{4,0,1,2,3}, new int[]{4,2,3,0,1}));
    }
}