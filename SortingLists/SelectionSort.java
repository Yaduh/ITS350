package sortinglists;

import java.util.Arrays;

class SelectionSort{
    public static void selection(int list[]){
       for(int i=0; i<list.length-1; i++){
           int minimumSwapPos = i;
           for(int j = i+1; j<list.length; j++){ // i+1: skip chekcing sorted elements 
               if(list[j]<list[minimumSwapPos]){
                   minimumSwapPos = j;
               }
           }
           if(minimumSwapPos!=i)
                BubbleSort.swap(list, minimumSwapPos, i);
       }
    }
    public static void selection(String list[]){
        for(int i=0; i<list.length-1; i++){
            int minimumSwapPos = i;
            for(int j=i+1; j<list.length; j++){
                if(list[j].compareToIgnoreCase(list[minimumSwapPos])<0){
                    minimumSwapPos = j;
                }
            }
            if(list[i].compareToIgnoreCase(list[minimumSwapPos])!=0){
                String temp = list[i];
                list[i] = list[minimumSwapPos];
                list[minimumSwapPos] =temp;
            }
        }
    }
    public static void main(String args[]){
        int [] list = {30, 1, 6, 3, 2, 0};
        System.out.println("Before: "+Arrays.toString(list));
        selection(list);
        System.out.println("After: "+Arrays.toString(list));
        String [] name = {"Sara", "Ali", "ali", "Bryar"};
        System.out.println("Before: "+Arrays.toString(name));
        selection(name);
        System.out.println("After: "+Arrays.toString(name));
    }
}