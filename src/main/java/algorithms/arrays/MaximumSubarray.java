package main.java.algorithms.arrays;

/**
 * 分治策略求解最大子数组
 *
 */
public class MaximumSubarray {
    public Result findMaxCrossingSubarray(int[] array, int low, int mid, int high){
        int leftSum = Integer.MIN_VALUE;
        int leftIndex = 0;
        int sum = 0;
        for (int i = mid; i >= low; i--){
            sum = sum + array[i];
            if (leftSum < sum){
                leftSum = sum;
                leftIndex = i;
            }
        }
        int rightSum = Integer.MIN_VALUE;
        int rightIndex = 0;
        sum = 0;
        for (int i = mid + 1; i <= high ; i++){
            sum = sum + array[i];
            if (rightSum < sum){
                rightSum = sum;
                rightIndex = i;
            }
        }
        Result result = new Result();
        result.sum = leftSum + rightSum;
        result.start = leftIndex;
        result.end = rightIndex;
        return result;
    }

    public Result findMaximumSubarray(int[] array, int low, int high){
        if (low == high){
            Result result = new Result();
            result.sum = array[low];
            result.start = low;
            result.end = high;
            return result;
        }
        int mid = (low + high)/2;
        Result leftResult = findMaximumSubarray(array, low, mid);
        Result rightResult = findMaximumSubarray(array, mid + 1, high);
        Result middleResult = findMaxCrossingSubarray(array, low, mid, high);
        if (leftResult.sum >= rightResult.sum && leftResult.sum >= middleResult.sum){
            return leftResult;
        } else if (rightResult.sum >= leftResult.sum && rightResult.sum >= middleResult.sum){
            return rightResult;
        } else {
            return middleResult;
        }
    }

    public class Result{
        public int sum;
        public int start;
        public int end;
    }

    public static void main(String[] args){
        int[] array = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        MaximumSubarray maximumSubarray = new MaximumSubarray();
        Result result = maximumSubarray.findMaximumSubarray(array, 0, 15);
        System.out.println("sum = " + result.sum + ", start = " + result.start + ", end = " + result.end);
    }

}
