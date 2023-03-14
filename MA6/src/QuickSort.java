
public class QuickSort<T extends Comparable<T>> extends Sorter<T> {
	
	
	public Indexed<T> sort(Indexed<T> data) {
		sortHelper(data, 0, data.getSize() - 1);
		return data;
	}

	// MA6 TODO: implement recursive solution
	private void sortHelper(Indexed<T> data, int start_bound, int end_bound) {
		// verify that the start and end index have not overlapped
		if (start_bound < end_bound) {
			// calculate the pivotIndex
			int pivotIndex = partition(data, start_bound, end_bound);
			// sort the left sub-array
			sortHelper(data, start_bound, pivotIndex);
			// sort the right sub-array
			sortHelper(data, pivotIndex + 1, end_bound);
		}
	}

	private int partition(Indexed<T> data, int startIndex, int endIndex) {
		T[] array = (T[]) new Comparable[data.getSize()];
		for (int i = startIndex; i <= endIndex; i++) {
			array[i] = data.getElementAt(i);
		}
		int pivotIndex = (startIndex + endIndex) / 2;
		T pivotValue = array[pivotIndex];
		startIndex--;
		endIndex++;

		while (true) {
			// start at the FIRST index of the sub-array and increment  until we find a value that is > pivotValue
			do
				startIndex++;
			while (array[startIndex].compareTo(pivotValue) < 0);

			// start at the LAST index of the sub-array and increment until we find a value that is < pivotValue
			do
				endIndex--;
			while (array[endIndex].compareTo(pivotValue) > 0);

			if (startIndex >= endIndex)
				return endIndex;

			// swap values at the startIndex and endIndex
			T temp = array[startIndex];
			array[startIndex] = array[endIndex];
			array[endIndex] = temp;

			for (int i = startIndex; i <= endIndex; i++)
				data.setElementAt(array[i], i);
		}
	}
}

