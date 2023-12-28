# Bubble sort 

public class Main
{
	public static void main(String[] args) {
	    
	    int[] nums = {9,7,5,3,1};
	    int temp;
		
	    for(int i =0; i <nums.length ; i++){
	        for(int j =0; j< nums.length-i-1 ; j++){
	            if(nums[j]>nums[j+1]){
	                temp = nums[j];
	                nums[j] = nums[j+1];
	                nums[j+1] = temp;
	            }
	        }
	        
	    }
	    
	    System.out.println();
	    
	    for(int i=0;i<nums.length;i++){
	        System.out.print(nums[i] + " ");
	    }
		
	}
}