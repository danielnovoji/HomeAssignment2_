public class Ex4Homework {
    public static void main(String[] args) {
        int[] arr = {1,3,5,7,5,3,1};
        int checker = checkArray(arr);
        System.out.println(checker);

    }

    public static int checkArray(int[] array) {
        int up = -1;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < array[i + 1]) {
                up = i + 1;
            } else
                break;
        }
        if (up != -1 && up != array.length - 1) {
            for (int j = up; j < array.length - 1; j++)
                if (array[j] > array[j + 1]) {
                } else {
                    up = -1;
                }
        } else {
            up = -1;
        }
        return up;
    }
}

