package mergesort;
import java.util.*;

public class Mergesort {
    //--1 merge sort---
    public static void mergeSortDesc(int[] array, int left, int right){
        if (left < right){
            int mid = (left + right)/ 2;
            mergeSortDesc(array, left, mid);
            mergeSortDesc(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }
    
    private static void merge(int [] array, int left, int mid, int right){
    int n1 = mid - left + 1;
    int n2 = right - mid;
    
    int [] L = new int[n1];
    int [] R = new int[n2];
    
    for (int i = 0; i < n1; ++i)
        L [i] = array[left + i];
    for (int j = 0; j < n2; ++j)
        R [j] = array[mid + 1 + j];
    
    int i = 0, j = 0;
    int k = left;
    while (i < n1 && j < n2){
        if(L[i] >= R[j]){
            array [k++] = L[i++];
        } else {
            array [k++] = R[j++];
        }
            
    }
    while (i < n1) array[k++] = L[i++];
    while (j < n2) array[k++] = R[j++];
    }
    
    //--2 counting sort
    public static void countingSortDesc(int[] array){
        int max = Arrays.stream(array).max().orElse(0);
        int[] count = new int [max + 1];
        
        for(int num : array){
            count[num]++;
        }
        
        int index = 0;
        for (int i = count.length - 1; i >= 0; i--){
            while (count[i]-- > 0) {
                array[index++] = i;
            }
        }
        
    }
    
    public static void main(String[] args) {
        int[] datamerge = {45, 23, 67, 12, 89, 34};
        int[] datacounting = {99, 78, 96, 10, 88, 30};
        
        // merge sort
        int[] mergeSorted = datamerge;
        mergeSortDesc(mergeSorted, 0, mergeSorted.length - 1);
        System.out.println("Array sebelum di merge sort dan counting sort: " +
            Arrays.toString(datamerge) + Arrays.toString(datacounting));
        System.out.println("Hasil merge sort: " + Arrays.toString(datamerge));
        
        //counting sort
        int[] countingSorted = datacounting;
        countingSortDesc(countingSorted);
        System.out.println("Hasil counting sort: " + Arrays.toString(datacounting));
    }
    
}
