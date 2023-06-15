public class DArray {
    public long[] theArray;
    public int nElements;

    public DArray(int max) {
        theArray = new long[max];
        nElements = 0;
    }

    public void insert(long value) {
        theArray[nElements++] = value;
    }

    public void display() {
        for (int j = 0; j < nElements; j++)
            System.out.print(theArray[j] + " ");
        System.out.println("");
    }

    public void mergeSort() {
        long[] workspace = new long[nElements];
        recMergeSort(workspace, 0, nElements - 1);
    }

    public void recMergeSort(long[] workSpace, int lowerBound, int upperBound) {
        if (lowerBound == upperBound)
            return;
        else {
            int mid = (lowerBound + upperBound) / 2;
            recMergeSort(workSpace, lowerBound, mid);
            recMergeSort(workSpace, mid + 1, upperBound);
            merge(workSpace, lowerBound, mid +1, upperBound);
        }
    }

    private void merge(long[] workSpace, int lowPtr, int highPtr, int upperBound) {
        int j = 0;
        int lowerBound = lowPtr;
        int mid = highPtr - 1;
        int n = upperBound - lowerBound + 1;
        while (lowPtr <= mid && highPtr <= upperBound) {
            if (theArray[lowPtr] < theArray[highPtr])
                workSpace[j++] = theArray[lowPtr++];
            else
                workSpace[j++] = theArray[highPtr++];
        }

        while (lowPtr <= mid)
            workSpace[j++] = theArray[lowPtr++];
        while (highPtr <= upperBound)
            workSpace[j++] = theArray[highPtr++];
        for (j = 0; j < n; j++)
            theArray[lowerBound + j] = workSpace[j];
    }
}
