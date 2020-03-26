
/*
 * 冒泡排序算法
 */
public class BubbleSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		bubble();
	}
	
	public static void bubble(){
		int[] nums={203,33,683,1022,12,467};
		int temp=0; 	
		//控制比较的轮数
		for (int i = 0; i < nums.length-1; i++) {
			//控制每轮比较的次数
			for (int j = 0; j < nums.length-i-1; j++) {
				if(nums[j]>nums[j+1]){
					temp=nums[j];
					nums[j]=nums[j+1];
					nums[j+1]=temp;
				}
			}
		}
		
		for (int i : nums) {
			System.out.println(i);
		}
		
	}

}
