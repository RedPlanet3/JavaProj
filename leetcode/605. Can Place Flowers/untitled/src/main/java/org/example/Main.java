package org.example;

public class Main {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        boolean right;
        boolean left;
        for (int i = 0; i < flowerbed.length; i++)
        {
            if (n == 0)
                break;
            right = false;
            left = false;
            if (flowerbed[i] == 0)
            {
                if (i == 0 || flowerbed[i - 1] == 0)
                    left = true;
                if (i == flowerbed.length - 1 || (i < (flowerbed.length - 1) && flowerbed[i + 1] == 0) )
                    right = true;
                if (left && right) {
                    n--;
                    flowerbed[i] = 1;
                }
            }
        }
        return n == 0;
    }
    public static void main(String[] args) {
        System.out.println("true:" + new Main().canPlaceFlowers(new int[]{1,0,0,0,1}, 1));
        System.out.println("false:" + new Main().canPlaceFlowers(new int[]{1,0,0,0,1}, 2));
        System.out.println("true:" + new Main().canPlaceFlowers(new int[]{0}, 1));
        System.out.println("true:" + new Main().canPlaceFlowers(new int[]{0,0}, 1));
        System.out.println("false:" + new Main().canPlaceFlowers(new int[]{1,1}, 1));
        System.out.println("false:" + new Main().canPlaceFlowers(new int[]{0,1}, 1));
        System.out.println("true:" + new Main().canPlaceFlowers(new int[]{0,1}, 0));
    }
}