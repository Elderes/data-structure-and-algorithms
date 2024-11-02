package searching_algorithms;

public class BinarySearch {

    static int binary_search(int[] arr, int key)
    {
        int left = 0;
        int right = arr.length -1 ;

        while (left <= right)
        {
            int mid = left + (right - left) / 2;

            if (arr[mid] == key)
            {
                return mid;
            }

            else if (key < arr[mid])
            {
                right = mid - 1;
            }

            else
            {
                left = mid + 1;
            }
        }
        return -1;
        
    }

    public static void main(String[] args) {
        int[] myArr = new int[]{3, 7, 9, 10, 15, 21, 45, 46};

        System.out.println(binary_search(myArr, 21));
    }
}
