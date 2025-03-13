import java.util.Arrays;

public class MergeSorting {

    static void mergeSort(int[] arr, int left, int right)
    {
        
        if(left<right)
        {
            int mid = left+(right-left)/2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid+1, right);
            merge(arr,left,mid,right);
        }

    }
    static void merge(int[] arr, int left,int mid,int right)
    {
        int[] leftArr = new int[mid-left+1];
        int[] rightArr = new int[right-mid];

        for(int i=0;i<leftArr.length;i++)
        leftArr[i] = arr[left+i];
        for(int j=0;j<rightArr.length;j++)
        rightArr[j] = arr[mid+1+j];

        int i=0,j=0,k=left;

        while(i<leftArr.length && j < rightArr.length)
        {
            if(leftArr[i] < rightArr[j])
            arr[k++] = leftArr[i++];
            else
            arr[k++] = rightArr[j++];
        }

        while(i < leftArr.length)
        arr[k++] = leftArr[i++];
        while(j < rightArr.length)
        arr[k++] = rightArr[j++];
    }
    public static void main(String[] args) {
        int arr[] = {24,9,29,14,19,27};

        System.out.println("Original: "+Arrays.toString(arr));
        long startTime = System.nanoTime();
        mergeSort(arr, 0, arr.length-1);
        long endTime = System.nanoTime();

        System.out.println("Final: "+Arrays.toString(arr));
        System.out.println("Time: "+(endTime-startTime));

    }
    
}
