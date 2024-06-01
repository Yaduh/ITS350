package sortinglists;

import java.util.Arrays;

public class MergeSort {
    void mergeSort(int list[]){
        int length = list.length;
        
        if(length<2){ // Base case
            return;
        }
        int mid = length/2;
        int leftP[]=new int[mid];
        int rightP[]=new int[length-mid];
        for(int i=0; i<leftP.length; i++){
            leftP[i] = list[i];
        }
        for(int i=mid; i<length; i++){
            rightP[i-mid] = list[i];
        }
        // recursive case
        mergeSort(leftP);
        mergeSort(rightP);
        //Combining
        merge(list, leftP, rightP);
    }
        void merge(int sorted[], int left[], int right[]){
            int i=0, j=0, k=0;
            while(i<left.length && j<right.length){
                if(left[i] < right[j]){
                    sorted[k] = left[i];
                    i++;
                }else{
                    sorted[k] = right[j];
                    j++;
                }
                k++;
            }
            while(i<left.length){
                sorted[k] = left[i];
                i++;
                k++;
            }
            while(j<right.length){
                sorted[k] = right[j];
                j++;
                k++;
            }
        }
    
    public static void main(String[] args) {
        MergeSort ob = new MergeSort();
        int list[] = {40, 2, 0, 1, 9, 6, 0};
        ob.mergeSort(list);
        System.out.println(Arrays.toString(list));
    }
}