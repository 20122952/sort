package com.springboot.sort;

import java.util.Arrays;

/**
 * @Author: ningzhefeng
 * @Description:  归并排序
 * @Date: 上午9:43 2018/9/17
 * @return:
 *
 * 归并排序（Merge sort）是建立在归并操作上的一种有效的排序算法。该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。
 * 作为一种典型的分而治之思想的算法应用，归并排序的实现由两种方法：
 * 自上而下的递归（所有递归的方法都可以用迭代重写，所以就有了第 2 种方法）；
 * 自下而上的迭代；
 *
 * https://github.com/hustcc/JS-Sorting-Algorithm/blob/master/5.mergeSort.md
 */
public class MergeSort {
    /**
     * 算法步骤
     * 申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列；
     *
     * 设定两个指针，最初位置分别为两个已经排序序列的起始位置；
     *
     * 比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置；
     *
     * 重复步骤 3 直到某一指针达到序列尾；
     *
     * 将另一序列剩下的所有元素直接复制到合并序列尾。
     *
     * @param args 查分成最小单元进行排序，在一步一步向上合并排序
     */
    public static void main(String[] args) {
        int[] arrs = {7, 5, 4, 3, 6, 8, 9, 1, 3, 4};
        int[] ints = mergeSort(arrs);
        for (int i = 0; i < ints.length; i++) {
            System.err.print(ints[i] + ",");
        }
    }


    public static int[] mergeSort(int[] arrs) {
        if (arrs.length < 2) {
            return arrs;
        }
        int middle = (int)Math.floor(arrs.length/2);
        int[] left = Arrays.copyOfRange(arrs,0,middle);
        int[] right = Arrays.copyOfRange(arrs,middle,arrs.length);
        return merge(mergeSort(left), mergeSort(right));

    }

    private static int[] merge(int[] left, int[] right) {

        int result[] = new int[left.length+right.length];
        int i=0;
        while (left.length >0 && right.length>0){
            if(left[0] <= right[0]){
                result[i++] = left[0];
                left = Arrays.copyOfRange(left,1,left.length);
            }else{
                result[i++] = right[0];
                right = Arrays.copyOfRange(right,1,right.length);
            }
        }

        while (left.length>0){
            result[i++] = left[0];
            left = Arrays.copyOfRange(left,1,left.length);
        }

        while (right.length>0){
            result[i++] = right[0];
            right = Arrays.copyOfRange(right,1,right.length);
        }

        return result;

    }
}
