package Sort_Algorithm;


public class Quick_Sort {
    int[] A = {21,23,1,4,87,3,16,78,43,56,29,77,65,98}; 
    
    public void QuickSort(int left, int right)
    {
        if (right-left <= 0)
            return;
        else
        {
            int pivot = A[right];
            int partition = PartitionFunc(left,right,pivot);
            QuickSort(partition+1,right);
            QuickSort(left,partition-1);
        }
    }
    
    public int PartitionFunc(int left, int right, int pivot)
    {
        int leftPointer = left-1;
        int rightPointer = right;
        
        
        return 1;
    }
}
