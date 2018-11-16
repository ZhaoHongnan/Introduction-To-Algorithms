package main.java.algorithms.sorts.merge;

/**
 * 2.3.1归并排序
 */
public class MergeSort {
    public void mergeSort(int[] array, int start, int end){
        if (start < end){
            int mid = (start + end)/2;
            mergeSort(array, start, mid);
            mergeSort(array, mid + 1, end);
            merge(array, start, mid, end);
        }
    }

    public void merge(int[] array, int start, int mid, int end){
        int sizeL = mid - start + 1;
        int sizeR = end - mid;
        int[] arrayL = new int[sizeL + 1];
        int[] arrayR = new int[sizeR + 1];
        int l = 0;
        for (int i = start; i <= mid; i++){
            arrayL[l] = array[i];
            l++;
        }
        arrayL[l] = Integer.MAX_VALUE;
        int r = 0;
        for (int j = mid + 1; j <= end; j++){
            arrayR[r] = array[j];
            r++;
        }
        arrayR[r] = Integer.MAX_VALUE;
        l = 0;
        r = 0;
        for (int i = start; i <= end; i++){
            if (arrayL[l] >= arrayR[r]){
                array[i] = arrayR[r];
                r++;
            } else {
                array[i] = arrayL[l];
                l++;
            }
        }


    }

    public static void main(String[] args){
        int[] array = {3,8,6,65,45,34,54,67,97,56,57};
        for (int i = 0; i < 11; i++){
            System.out.println(array[i]);
        }
        System.out.println("-----------------------");
        MergeSort sort = new MergeSort();
        sort.mergeSort(array, 0, 10);
        for (int i = 0; i < 11; i++){
            System.out.println(array[i]);
        }
    }
}
