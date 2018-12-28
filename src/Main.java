import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class Main {
	public static void main(String[] args) {

		int[] A = { 5, 2, 4, 6, 1, 3, 2, 6 };
		for (int i : A) {
			System.out.print(i + " ");
		}
		System.out.println();
		Main.Sort(A, 1, A.length);
		for (int i : A) {
			System.out.print(i + " ");
		}
	}

	public static void Sort(int[] A, int p, int r) {
		if (p < r) {
			int q = (p + r) / 2;
			Sort(A, p, q);
			Sort(A, q + 1, r);
			Merge(A, p, q, r);
		}
	}

	public static void Merge(int[] A, int p, int q, int last_second) {
		int[] l = new int[q - p + 1];
		int[] r = new int[last_second - q];
		int[] A_tmp = new int[A.length];
		int leftInx = 0, rightInx = 0;
		for (int i = p - 1; i < q; i++) {
			l[leftInx++] = A[i];
		}
		for (int i = q; i < last_second; i++) {
			r[rightInx++] = A[i];
		}

		int temp_leftInx = 0, temp_rigthInx = 0, temp_AInx = p - 1;
		while (temp_leftInx < l.length && temp_rigthInx < r.length) {
			if (l[temp_leftInx] <= r[temp_rigthInx]) {
				A_tmp[temp_AInx++] = l[temp_leftInx++];
			} else {
				A_tmp[temp_AInx++] = r[temp_rigthInx++];
			}
		}
		while (temp_leftInx < l.length) {
			A_tmp[temp_AInx++] = l[temp_leftInx++];
		}
		while (temp_rigthInx < r.length) {
			A_tmp[temp_AInx++] = r[temp_rigthInx++];
		}
		for (int i = p - 1; i < last_second; i++) {
			A[i] = A_tmp[i];
		}
	}

	@Test
	public void positiveTest() {
		int[] A = { 5, 2, 4, 6, 1, 3, 2, 6 };
		int[] expeted = { 1, 2, 2, 3, 4, 5, 6, 6 };
		Main.Sort(A, 1, A.length);
		assertArrayEquals(expeted, A);
	}

}
