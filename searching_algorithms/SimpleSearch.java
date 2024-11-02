package searching_algorithms;

public class SimpleSearch {

    static int simple_search(int[] arr, int key)
    {
        // Simply tranverse the list to find a key and return it's position
        for (int i = 0; i < arr.length - 1; i++)
        {
            if (arr[i] == key) {return i;}
        }

        return -1; // If the key doesn't exists in the list
    }

    static String checkIfExists(int[] arr, int key)
    {
        int myBool = simple_search(arr, key);

        if (myBool == -1) {return "Value are not in the list.";}

        return "Value are in position: " + myBool;
    }


    public static void main(String[] args) {
        int[] myArr = new int[]{3, 7, 9, 10, 15, 21, 45, 46};

        System.out.println(checkIfExists(myArr, 21));
    }
}
