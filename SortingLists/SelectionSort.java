package sortinglists;

import java.util.Arrays;

class SelectionSort{
    public static void selection(int list[]){
       for(int i=0; i<list.length-1; i++){
           int min = i;
           for(int j = i+1; j<list.length; j++){
               if(list[j]<list[min]){
                   min = j;
               }
           }if(min!=i)
           BubbleSort.swap(list, min, i);
       }
    }
    public static void selection(String list[]){
        for(int i=0; i<list.length-1; i++){
            int min = i;
            for(int j=i+1; j<list.length; j++){
                if(list[j].compareToIgnoreCase(list[min])<0){
                    min = j;
                }
            }
            if(list[i].compareToIgnoreCase(list[min])!=0){
                String temp = list[i];
                list[i] = list[min];
                list[min] =temp;
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