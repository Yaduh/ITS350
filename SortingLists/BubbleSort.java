package sortinglists;

import java.util.Arrays;

public class BubbleSort {                           
    public static void bubbleSort(int number[]) { // [3,5,6,1]
        // iterate through the array
        for (int i = 1; i<number.length; i++){ // checks the array as many times as there are numbers in the array.
            for(int k = 0; k<number.length-1; k++){ // compare left to right element length-1 because there wouldnt be a k+1 for the last element.
                if (number[k]>number[k+1]){ // if left element is greater than the right element
                   swap(number, k, k+1); // swap numbers
                }
            }
        }
    }
    public static void swap(int list[], int n1, int n2) {
        // n1 = n2
        // n2 = n1
        int temp = list[n1]; // make a copy of number k
        list[n1] = list[n2]; // Swap Values: number [k] = number [k+1]
        list[n2] = temp; // number [k+1] = number [k] (copy)
    }

    public static void main(String[] args) {
        int []list = {3,5,6,1};
        System.out.println("Before" + Arrays.toString(list));
        bubbleSort(list);
        System.out.println("After" + Arrays.toString(list));
    }
}
