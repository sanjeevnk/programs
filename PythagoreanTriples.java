public class PythTriples {

public static int pythtriples(int[] pyth) {
  int n = pyth.length;

	// No duplicate removal algo is used before sort, to avoid the cost of
	// O(n),as this will be taken care of below,in for loop.
	// (Trivial) Shifting mechanism should be used in
	// array with new length in-place(trivial)in case,
	// either the element occurring in multiple places is 0 or neg integer

	// Square all the numbers – O(n) time complexity.
	for (int i = 0; i < n; i++) {
		pyth[i] = pyth[i] * pyth[i];
	}

	// Sort them – O(n * log n) time complexity
	Arrays.sort(pyth);

	if (n < 3) {
		return -1; // error : No of elements must be >= 3
	}

	// Simple case
	if (n == 3) {
		if (pyth[2] == pyth[1] + pyth[0])
			return 1;
		else
			return 0;
	}

	// Compare pair-wise: if(a[i] == (a[j] + a[k]) then, it’s a triple),
	// k<i, j<i
	// O(k* n * n) time complexity, where k is nearly n/3, can be
		int triples = 0, foundtripleLarge = 0;
		for (int i = 2; i < n; i++) {
				for (int j = 0; j < i; j++) {
					for (int k = i - 1; k >= 0; k--) {
						// If already found, don’t compare again for 3SUM. Avoids
							// unnecessary check for duplicates
						if (foundtripleLarge == pyth[i]) {
							break;
						}
						if (pyth[i] == (pyth[j] + pyth[k])) {
							System.out.println("triples found:" + pyth[i] + "="
									+ pyth[j] + " + " + pyth[k]);
							triples++; // Counter for triples
							foundtripleLarge = pyth[i];
							break;
						}
					}
				}
		}
		return triples;
	}
}
