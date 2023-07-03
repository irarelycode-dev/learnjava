package com.datastructures.arrays;

public class AdjacentFlowers {

    private static boolean adjacentFlowers(int[] flowerbed, int k) {
        if (k == 0) return true;
        int len = flowerbed.length;
        if ((len % 2 == 0 && k > len / 2) || (len % 2 != 0 && k > (len / 2) + 1)) return false;
        if (len == 1 && flowerbed[0] == 0) return true;
        if (len == 1 && flowerbed[0] == 1) return false;
        for (int i = 0; i < len; ++i) {
            if ((i == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0) || (i == len - 1 && flowerbed[i] == 0 && flowerbed[i - 1] == 0) || (i != 0 && i != len - 1 && flowerbed[i] == 0 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0)) {
                k--;
                flowerbed[i] = 1;
                if(k==0) return true;
            }
        }
        return k == 0;
    }

    public static void main(String[] args) {
        System.out.println(adjacentFlowers(new int[]{0, 0, 1, 0, 0}, 1));
    }
}

//[0,0,1,0,0]