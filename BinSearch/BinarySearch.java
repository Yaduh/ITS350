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

    

    public static int recursiveBinarySearch(int arr[], int start, int end, int key) {

        if (end >= start) {
            int mid = start + end / 2;
            if (arr[mid] == key)
                return mid;
    
                if (arr[mid] > key)
                return recursiveBinarySearch(arr, start, mid - 1, key);
    
            
            return recursiveBinarySearch(arr, mid + 1, end, key);
        }
    
        return -1;
    }
    public static void main(String[] args) {
        int key = 67;
        int index = recursiveBinarySearch(new int[]{3, 22, 27, 47, 57, 67, 89, 91, 95, 99}, 0, 10, key);
        System.out.println(67 + " index: " + index);
        if(index<0){
            System.out.println(key + " is not present");
        }else{
            System.out.println(key + " is present at index: " + index);
        }

    }
}
