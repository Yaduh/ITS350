package BinSearch;
public class BinarySearch {
    
   
    static int binarySearch(int key, int array[]){
        int start = 0;
        int end = array.length-1;
        while(start<=end){
            int mid = (start+end/2);
            if(array[mid]==key){
                return mid;
            }
            if(key<array[mid]){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return -1;
    }

    static int bSearch(int key, int array[]){
        return recursiveBinarySearch(key, array, 0, array.length-1);
    }

    static int recursiveBinarySearch(int key, int array[], int start, int end){
        if(start<=end){
            int mid = (start+end)/2;
            if(key==array[mid])
                return mid;
            if(key<array[mid])
                return recursiveBinarySearch(key, array, start, mid-1);
            else
                return recursiveBinarySearch(key, array, mid+1, end);
        }
        return -1;
    }
    public static void main(String[] args) {
        int array[] = new int[]{3, 22, 27, 47, 57, 67, 89, 91, 95, 99};
        int key = 67;
        int index = bSearch(key, array);
        System.out.println(key + " index: " + index);
        if(index<0){
            System.out.println(key + " is not present");
        }else{
            System.out.println(key + " is present at index: " + index);
        }

    }
}
