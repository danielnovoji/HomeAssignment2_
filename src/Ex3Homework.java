public class Ex3Homework {
    public static void main(String[] args) {
        int [] originalArray = {5,7,4,2,3,5,5,6,2,1,3,4};
        int length = originalArray.length;
        length=arrayDupeRemover(originalArray,length);
        for (int i=0;i<length;i++){
            System.out.print(originalArray[i] + " ");
        }
    }
    public static int arrayDupeRemover (int[] originalArray, int length) {

        for (int i = 0 ; i<length;i++) {
            for (int j=i+1; j<length;j++){
                if (originalArray[i]==originalArray[j]){
                    int remove = j;
                    for (int m = j+1; m<length;m++,remove++){
                        originalArray[remove] = originalArray[m];
                    }
                    j--;
                    length--;
                }
            }
        }
        int[] array = new int [length];
        for (int i=0;i<length;i++){
            array[i]=originalArray[i];
        }
        return length;
    }
}
