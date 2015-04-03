package realEstate;

import java.util.Arrays;

public class SortedList {
	public static int[] list = new int[100]; //create a list refference
	private int currentPosition; // store the current position of the list
        
        //give raw values to array
        public SortedList(){
            int result = find(0);
            for(int i=result; i<list.length;i++)
            list[i] = -1;
        }
	// Make empty method will Delete all elements on list
	public void makeEmpty() {
		Arrays.fill(list, -1);
	}

	// find method will Returns the position of the first element
	public int find(int element) {
		int i = 1;
		for (; i < list.length && list[i]!= -1; i++) {
			if (element==list[i]) {
				currentPosition = i;
				return i;
			}
		}
		currentPosition = i;
		return 101;
	}
	// insert an element to the list
	public void insert(int element) {
		int i = 0;
		while (list[i] != -1)
			i++;
		list[i] = element;
		insertionSort(list);
		currentPosition = i;
	}

	// remove an element from the list
	public void remove(int element) {
		int i = find(element);
		list[i] = -1;
		insertionSort(list);
		currentPosition = i;
	}

	// implement the insertion Sort
	public void insertionSort(int[] sortList) {
		int n = sortList.length;
		for (int j = 1; j < n && sortList[j] != -1; j++) {
			int key = sortList[j];
			int i = j - 1;
			while ((i > -1) && (sortList[i] > key)) {
				sortList[i + 1] = sortList[i];
				i--;
			}
			sortList[i + 1] = key;
		}
	}

	// This method will give the next element of the list
	public int next() {
		if (currentPosition == (list.length - 1)) {
			currentPosition = 0;
			return list[currentPosition];
		}
		currentPosition++;
		return list[currentPosition];
	}
	
	}
        public void setPosition(){
            currentPosition = 0;        
        }
}

