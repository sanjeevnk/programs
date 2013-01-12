/** Sedgewick's partitioning approach */
 public class QuickSelect {

private static Random random = new Random();

public static Comparable select(Comparable[] a, int k) {
 if (k = a.length) {
 throw new RuntimeException("Selected element out of bounds");
 }

shuffle(a);

int lo = 0, hi = a.length - 1;
 while (hi > lo) {
 int i = partition(a, lo, hi);
 if (i > k)
 hi = i - 1;
 else if (i < k)
 lo = i + 1;
 else
 return a[i];
 }
 return a[lo];
 }

private static int partition(Comparable[] a, int lo, int hi) {
 int i = lo;
 int j = hi + 1;
 Comparable v = a[lo];
 while (true) {
 // find item on lo to swap
 while (less(a[++i], v))
 if (i == hi)
 break;
 // find item on hi to swap
 while (less(v, a[--j]))
 if (j == lo)
 break; // redundant since a[lo] acts as sentinel
 // check if pointers cross
 if (i >= j)
 break;
 exch(a, i, j);
 }
 // put v = a[j] into position
 exch(a, lo, j);
 // with a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
 return j;
 }

public static void shuffle(Object[] a) {
 int n = a.length;
 for (int i = 0; i < n; i++) {
 int r = i + uniform(n - i); // between i and N-1
 Object temp = a[i];
 a[i] = a[r];
 a[r] = temp;
 }
 }

/**
 * Return an integer uniformly between 0 and N-1.
 */
 public static int uniform(int N) {
 return random.nextInt(N);
 }

// is v < w ?
 private static boolean less(Comparable v, Comparable w) {
 return (v.compareTo(w) < 0);
 }

// exchange a[i] and a[j]
 private static void exch(Object[] a, int i, int j) {
 Object swap = a[i];
 a[i] = a[j];
 a[j] = swap;
 }

// Read strings from standard input, sort them, and print.
 public static void main(String[] args) {
 // Read input from StdIn here
 // String[] a = new String[]{"aa", "aaa", "bb", "ab", "ca", "bc",
 // "cab", "cc", "cad" };
 Integer[] a = new Integer[] { 2, 11, 10, 6, 8, 99, 7, 100, 101, 28,
 9 };
 int k = 2;
 Object kth = Quick.select(a, k - 1); // returns a[k-1]
 System.out.println(k + "th smallest element in given array = "
 + kth);
 }
 }
