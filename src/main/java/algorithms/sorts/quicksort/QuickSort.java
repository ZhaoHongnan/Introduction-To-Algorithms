package main.java.algorithms.sorts.quicksort;

/**
 * 快速排序
 */
public class QuickSort {
    public void quickSort(int[] array, int start, int end){
        if (start < end){
            int mid = partition(array, start, end);
            quickSort(array, start, mid - 1);
            quickSort(array, mid + 1, end);
        }
    }

    public int partition(int[] array, int start, int end){
        int key = array[end];
        int i = start - 1;
        for (int j = start; j < end; j++){
            if (array[j] <= key){
                i++;
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }
        array[end] = array[i + 1];
        array[i + 1] = key;
        return i + 1;
    }

    public static void main(String[] args){
        int[] array = {3,8,6,65,45,34,54,67,97,56,57};
        for (int i = 0; i < 11; i++){
            System.out.println(array[i]);
        }
        System.out.println("-----------------------");
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(array, 0, 10);
        for (int i = 0; i < 11; i++){
            System.out.println(array[i]);
        }
    }
}
