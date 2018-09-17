package com.springboot.sort;

/**
 * @Author: ningzhefeng
 * @Description: 快速排序
 * @Date: 上午10:54 2018/9/17
 * @return:
 *
 * 快速排序使用分治法（Divide and conquer）策略来把一个串行（list）分为两个子串行（sub-lists）。
 *
 * 快速排序又是一种分而治之思想在排序算法上的典型应用。本质上来看，快速排序应该算是在冒泡排序基础上的递归分治法。
 *
 * https://github.com/hustcc/JS-Sorting-Algorithm/blob/master/6.quickSort.md
 */
public class QuickSort {
    /**
     * 算法步骤
     * 1：从数列中挑出一个元素，称为 “基准”（pivot）;
     * 2：重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
     * 3：递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序；
     *
     * 递归的最底部情形，是数列的大小是零或一，也就是永远都已经被排序好了。虽然一直递归下去，但是这个算法总会退出，因为在每次的迭代（iteration）中，它至少会把一个元素摆到它最后的位置去。
     * @param args
     */
    public static void main(String[] args) {
        int[] arrs = {7, 6, 4, 4, 6, 8, 9, 1, 3, 4};
        sort(arrs,0,arrs.length-1);
        for (int i = 0; i < arrs.length; i++) {
            System.err.print(arrs[i] + ",");
        }
    }


    public static int[] sort(int[] arrs,int left, int right) {
        if (left < right) {
            int partitionIndex = quickSort(arrs, left, right);
            sort(arrs, left, partitionIndex - 1);
            sort(arrs, partitionIndex + 1, right);
        }
        return arrs;
    }


    private static int quickSort(int[] arr, int left, int right) {
        // 设定基准值（pivot）
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
