package solutions;

/**
 * 605. 种花问题
 * 假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 *
 * 给你一个整数数组  flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。另有一个数 n ，能否在不打破种植规则的情况下种入 n 朵花？能则返回 true ，不能则返回 false。
 *
 *
 *
 * 示例 1：
 *
 * 输入：flowerbed = [1,0,0,0,1], n = 1
 * 输出：true
 */
public class S0605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        for(int i = 0; i < len; i++) {
            if(flowerbed[i]==0 && canFlower(i, flowerbed)) {
                flowerbed[i] = 1;
                n--;
            }
        }
        return n<=0;
    }

    public boolean canFlower(int i, int[] flowerbed) {
        int len = flowerbed.length;
        if(i==0) {
            return i+1<len?flowerbed[i+1] == 0:true;
        } else if (i==len-1) {
            return flowerbed[i-1] == 0;
        } else {
            return flowerbed[i-1]==0 && flowerbed[i+1]==0;
        }
    }
}
