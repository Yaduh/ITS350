package SortingLists;

public class MergeSort {
    void mergeSort(int [] position){
        int length = position.length;
        int midPoint = position.length/2;
        int leftSize = midPoint;
        int rightSize = length-midPoint;
        int leftP[] = new int [midPoint];
        int rightP[] = new int [length-midPoint];
    
        for (int i = 0; i<leftP.length; i++){
            leftP[i] = position[i];
        }
        for(int i = 0; i<rightP.length; i++){
            rightP[i]=position[i];

        }
        void merge(int sorted[], int left[], int right[]){
            int i =0, k=0, j=0;
            while(i<left.length && j<right.length){
                if(left[i] < right[j]){
                    sorted[k] = left[i];
                    i++;
                }else{
                    sorted[k] = left[i];
                    i++;
                }
                    sorted[k] = right[j];
                    j++;
                }
                k++;
            }
            while(i<left.length){

            }
            while(j<right.length){
                sorted[k] = right[j];
                j++;
                k++;
            }
        }
        }
    
    public static void main(String[] args) {
        
    }

