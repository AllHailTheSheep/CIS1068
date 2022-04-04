package lab8;

public class lab8 {
  /* sets every item in A[] to initialValue */
  public static void initialize(int A[], int initialValue) {
    for (int i = 0; i < A.length; i++) {
      A[i] = initialValue;
    }
    return;
  }

  /* returns the average of the items in A
   * Be careful: A[] is an array of int and the method returns
   * double. What do we do to handle this? */
  public static double average(int A[]) {
    double sum = 0;
    for (int num : A) {
      sum += (double) num;
    }
    return sum / A.length;
  }

  /* returns the number of times that x appears in A[] */
  public static int numOccurrences(int A[], int x) {
    int count = 0;
    for (int num : A) {
      if (num == x) {
        count += 1;
      }
    }
    return count;
  }


  /* returns the index of the first occurrence of
   * x in A[] or -1 if x doesn't exist in A[] */
  public static int find(int A[], int x) {
    for (int i = 0; i < A.length; i++) {
      if (A[i] == x) {
        return i;
      }
    }
    return -1;
  }

  /* Returns the index of the first occurrence of
   * item within the first n elements of A[] or -1
   * if item is not among the first n elements of A[] */
  public static int findN(int A[], int item, int n) {
    for (int i = 0; i < A.length; i++) {
      if (A[i] == item && i < n) {
        return i;
      }
    }
    return -1;
  }

  /* returns the index of the last occurrence of
   * x in A[] or -1 if x doesn't exist in A[] */
  public static int findLast(int A[], int x) {
    for (int i = A.length - 1; i > 0; i--) {
      if (A[i] == x) {
        return i;
      }
    }
    return -1;
  }

  /* returns the largest item found in A */
  public static int largest(int A[]) {
    int largest_n = 0;
    for (int n : A) {
      if (n > largest_n) {
        largest_n = n;
      }
    }
    return largest_n;
  }

  /* returns the index of the largest item found in A */
  public static int indexOfLargest(int A[]) {
    int largest_n = 0;
    for (int n : A) {
      if (n > largest_n) {
        largest_n = n;
      }
    }
    return find(A, largest_n);
  }

  /* returns the index of the largest odd number
   * in A[] or -1 if A[] contains no odd numbers */
  public static int indexOfLargestOdd(int A[]) {
    int largest_n = 0;
    for (int n : A) {
      if (n > largest_n && n % 2 == 1) {
        largest_n = n;
      }
    }
    return find(A, largest_n);
  }

  /* inserts n into A[] at A[index] shifting all */
  /*  the previous items one place to the right. For example */
  /*  if A is  */
  /*   |---+---+---+---+---+---+---+---+---+---| */
  /*   | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | */
  /*   |---+---+---+---+---+---+---+---+---+---| */
  /*   | 5 | 7 | 6 | 9 | 4 | 3 | 0 | 0 | 0 | 0 | */
  /*   |---+---+---+---+---+---+---+---+---+---| */

  /*   and we call insert(A, 15, 1), A then becomes */

  /*   |---+----+---+---+---+---+---+---+---+---| */
  /*   | 0 |  1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | */
  /*   |---+----+---+---+---+---+---+---+---+---| */
  /*   | 5 | 15 | 7 | 6 | 9 | 4 | 3 | 0 | 0 | 0 | */
  /*   |---+----+---+---+---+---+---+---+---+---| */
  /*  the element in A[] that's in the right-most */
  /*    position is removed.                      */
  /*                                              */
  /*  if index < 0 or index >= A.length-1, the method */
  /*                                    does nothing */
  public static void insert(int A[], int n, int index) {
    int[] temp = new int[A.length];
    System.arraycopy(A, 0, temp, 0, index);
    System.arraycopy(A, index, temp, index + 1, A.length - index - 1);
    temp[index] = n;
    for (int i = 0; i < A.length; i++) {
      A[i] = temp[i];
    }
    return;
  }

  /* returns a new array consisting of all of the
   * elements of A[] */
  public static int[] copy(int A[]) {
    int[] temp = new int[A.length];
    System.arraycopy(A, 0, temp, 0, A.length);
    return temp;
  }

  /* Returns a new array consisting of all of the
     first n elements of A[]. If n>A.length, returns a
     new array of size n, with the first A.length elements
     exactly the same as A, and the remaining n-A.length elements
     set to 0. If n<=0, returns null. */
  public static int[] copyN(int A[], int n) {
    if (n <= 0) {return null;}
    int[] temp = new int[n];
    for (int i = 0; i < n; i++) {
      if (i < A.length) {
        temp[i] = A[i];
      } else {
        temp[i] = 0;
      }
    }
    return temp;
  }

  /* returns a new array consisting of all of the
   * elements of A[] followed by all of the
   * elements of B[]. For example, if 
   A[] is: {10,20,30} and 
   B[] is: {5, 9, 38}, the method returns the
   array : {10,20,30,5,9,38} */
  public static int[] copyAll(int A[], int B[]) {
    int[] temp = new int[A.length + B.length];
    System.arraycopy(A, 0, temp, 0, A.length);
    System.arraycopy(B, 0, temp, A.length, B.length);
    return temp;
  }

  /* reverses the order of the elements in A[].
   * For example, if A[] is:
   {10,20,30,40,50}, after the method, A[] would
   be {50,40,30,20,10} */
  public static void reverse(int A[]) {
    int t;
        for (int i = 0; i < A.length / 2; i++) {
            t = A[i];
            A[i] = A[A.length - i - 1];
            A[A.length - i - 1] = t;
        }
    return;
  }

  /* Extra credit:
   *
   * Returns a new array consisting of all of the
   * elements of A, but with no duplicates. For example,
   * if A[] is {10,20,5,32,5,10,9,32,8}, the method returns
   * the array {10,20,5,32,9,8} */
  public static int[] uniques(int A[]) {
    int[] temp = new int[A.length];
    int temp_index = 0;
    for (int i = 0; i < A.length; i++) {
      int test = 0;
      for (int j = 0; j < A.length; j++) {
        if (A[i] == A[j] && i != j) {
          test = 1;
        }
      }
      if (test == 0) {
        temp[temp_index] = A[i];
        temp_index++;
      }
    }
    return copyN(temp, temp_index);
  }

  public static void main(String[] args) {

    return;
  }
}
