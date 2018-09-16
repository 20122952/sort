package com.springboot.javasort;

/**
 * 选择排序
 * 选择排序是一种简单直观的排序算法，
 * 无论什么数据进去都是 O(n²) 的时间复杂度。
 * 所以用到它的时候，数据规模越小越好。
 * 唯一的好处可能就是不占用额外的内存空间了吧。
 */
public class SelectSort {
    /**
     * 算法步骤
     * 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置
     * 再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
     * 重复第二步，直到所有元素均排序完毕。
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arrs = {7, 6, 4, 4, 6, 8, 9, 1, 3, 4};
        selectSort(arrs);
        for (int i = 0; i < arrs.length; i++) {
            System.err.print(arrs[i] + ",");
        }
    }

    public static void selectSort(int[] arrs) {
        // 总共要经过 N-1 轮比较
        for (int i = 0; i < arrs.length - 1; i++) {
            int min = i;
            // 每轮需要比较的次数 N-i
            for (int j = i + 1; j < arrs.length; j++) {
                if (arrs[j] < arrs[min]) {
                    min = j;
                }
            }

            if (min != i) {
                int temp = arrs[i];
                arrs[i] = arrs[min];
                arrs[min] = temp;
            }
        }
    }

}
