package main.java.algorithms.sorts.heap;


public class HeapSort {
    public int getParent(int i){
        return (i - 1)/2;
    }

    public int getLeftChild(int i){
        return (i + 1) * 2 - 1;
    }

    public int getRightChild(int i){
        return (i + 1) * 2;
    }

    public void maxHeapify(int[] array, int heapSize, int i){
        int largest = i;
        int left = getLeftChild(i);
        if (left < heapSize && array[left] > array[i]){
            largest = left;
        }
        int right = getRightChild(i);
        if (right < heapSize && array[right] > array[largest]){
            largest = right;
        }
        if (largest != i){
            int tmp = array[i];
            array[i] = array[largest];
            array[largest] = tmp;
            maxHeapify(array, heapSize, largest);
        }

    }

    public void buildMaxHeap(int[] array){
        for (int i = (array.length - 2)/2; i >= 0; i--){
            maxHeapify(array, array.length, i);
        }
    }

    public void heapSort(int[] array){
        buildMaxHeap(array);
        int heapSize = array.length;
        for (int i = array.length - 1; i > 0; i--){
            int tmp = array[i];
            array[i] = array[0];
            array[0] = tmp;
            maxHeapify(array, --heapSize, 0);
        }
    }

    public static void main(String[] args){
        int[] array = {3,8,6,65,45,34,54,67,97,56,57};
        HeapSort sort = new HeapSort();
        sort.heapSort(array);
        for (int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }
    }

}
