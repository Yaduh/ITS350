package SortingLists;

import java.util.Arrays;

public class BubbleSort {                           // [k,k+1]
    public static void bubbleSort(int position[]) { // [8,7,6,5]
        for (int i = 1; i<position.length; i++){
            for(int k = 0; k<position.length-1; k++){ // iterate through positions[]
                if (position[k]>position[k+1]){ // if element in position k is smaller than element in position k+1
                   swap(position, k, k+1); // swap positions
                }
            }
        }
    }
    public static void swap(int list[], int n1, int n2) {
        
        int temp = list[n1]; // make a copy of position k
        list[n1] = list[n2]; // Swap Values: position [k] = position [k+1]
        list[n2] = temp; // position [k+1] = position [k] (copy)
    }
    public static void main(String[] args) {
        int []list = {3,5,6,1};
        System.out.println("Before" + Arrays.toString(list));
        bubbleSort(list);
        System.out.println("After" + Arrays.toString(list));
    }
}
