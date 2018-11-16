package main.java.algorithms.sorts.insertion;

/**
 * 算法导论中文版第三版
 * 2.1节 插入排序
 *
 *
 */
public class InsertionSort {
    public void insertionSort(int[] array){
        for (int i = 1; i < array.length; i++){
            int key = array[i];
            //将i元素插入到array[1...i-1]中
            int j = i -1;
            while (j >= 0 && array[j] > key){
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    public static void main(String[] args){
        int[] array = {3,8,6,65,45,34,54,67,97,56,57};
        for (int i = 0; i < 11; i++){
            System.out.println(array[i]);
        }
        System.out.println("-----------------------");
        InsertionSort sort = new InsertionSort();
        sort.insertionSort(array);
        for (int i = 0; i < 11; i++){
            System.out.println(array[i]);
        }
    }
}
