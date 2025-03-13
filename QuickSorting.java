import java.util.Arrays;
public class QuickSorting
{
    static void Quick(int[] arr, int low, int high)
    {
        if(low<high)
        {
            // int pivot = medianOfThree(arr, low, high); // Get median as pivot
            // Swap(arr, low, pivot);
            int pivotIndex = Partition(arr,low,high);
            Quick(arr,low,pivotIndex-1);
            Quick(arr,pivotIndex+1,high);
        }
    }
    static int Partition(int[] arr, int low, int high)
    {
        int pivot = arr[low];
        int i=low+1;
        int j=high;

        while(i<=j)
        {
            while (i<=j && arr[i]<=pivot) 
            {
                i++;   
            }
            while (i<=j && arr[j]>=pivot) 
            {
                j--;   
            }
            if(i < j)
            Swap(arr,i,j);
        }
        Swap(arr,low,j);
        return j;
    }
    static void Swap(int[] arr,int i,int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    // static int medianOfThree(int[] arr, int low, int high) {
    //     int mid = (low + high) / 2;
        
    //     if ((arr[low] <= arr[mid] && arr[mid] <= arr[high]) || (arr[high] <= arr[mid] && arr[mid] <= arr[low])) 
    //         return mid;
    //     else if ((arr[mid] <= arr[low] && arr[low] <= arr[high]) || (arr[high] <= arr[low] && arr[low] <= arr[mid])) 
    //         return low;
    //     else 
    //         return high;
    // }
    public static void main(String[] args) {
        int arr[] = {24,9,29,14,19,27};

        System.out.println("Original: "+Arrays.toString(arr));
        long startTime = System.nanoTime();
        Quick(arr, 0, arr.length-1);
        long endTime = System.nanoTime();

        System.out.println("Original: "+Arrays.toString(arr));

        System.out.println("Time taken: " + (endTime - startTime) + " nanoseconds");
    }
}