import java.util.Arrays;


//二分法查找
public class BinarySearchDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] number={43,6,10,331,22,3,192,59,20,1,90};
		//数据必须有序
		Arrays.sort(number);
		int index=binarySearch(number,90);
		System.out.println(index);
	}

	private static int binarySearch(int[] arr,int x){
		int start=0;
		int end=arr.length-1;
		int middle=-1;
		while(start<=end){
			middle=(start+end)/2;
			if(x==arr[middle]){
				return middle;
			}else if(x<arr[middle]){
				end=middle-1;
			}else{
				start=middle+1;
			}
		}
		return -1;
	}
}
