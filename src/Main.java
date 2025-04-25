import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] numbers=generate(1,100,10000);
        mergesort(numbers,0,numbers.length - 1);
        display(numbers);
        System.out.println();
    }

 public static int[] generate(int l, int h, int s) {
        Random rand = new Random();
        int[] result = new int[s];
        for (int i = 0; i < s; i++) {
            result[i] = rand.nextInt(h - l + 1) + l;
        }
        return result;
    }
  public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }
  public static void display(int[]a){
     for(int x: a){
         System.out.print(x );
         System.out.print("\t");
     }
  }
}