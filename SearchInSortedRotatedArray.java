// LeetCode Problem #33 - https://leetcode.com/problems/search-in-rotated-sorted-array/

class SearchInSortedRotatedArray {
    public int search(int[] arr, int key) {
        
	
	if(arr == null || arr.length == 0) {
		return -1;
	}
	
	if(arr.length == 1 && arr[0] == key) {
		return 0;
	} else if(arr.length == 2 ) {
		if(arr[0] == key ) return 0;
		else if( arr[1] == key ) return 1;
        else return -1;
	}
	
	int pivot = findPivot(arr, 0, arr.length-1);
    System.out.println(pivot);
        
	if(arr[0] <= key && arr[pivot] >= key) {
        return binarySearch(arr, 0, pivot, key);
    }
        
	if(arr[0] > key && arr[pivot] > key) {
		return binarySearch(arr, pivot+1, arr.length-1, key);
	} 
        
    return -1;

}

int findPivot(int []arr, int start, int end) {
	int mid = (start + end)/2;
	
	if(mid == start) {
		if(arr[start] >= arr[end]) 
			return start;
		else
			return end;
	}
		
	if(arr[start] < arr[mid] )
		return findPivot(arr, mid, end);
	else 
		return findPivot(arr, start, mid-1);

}


int binarySearch(int []arr, int start, int end, int key) {
    System.out.println(start + ", " + end);
	
    
    if(start > end) return -1;
    
	int mid = (start + end )/2;
    
    System.out.println(arr[mid] + ", " + key);
	
    
    if(arr[mid] == key ) {
        System.out.println(mid);
		return mid;
	}
    
    if(start == end) {
        return -1;
    }
	
	if(arr[mid] > key ) {
		return binarySearch(arr, start, mid-1, key );
	} else {
		return binarySearch(arr, mid+1, end, key);
	}
		
}

}
