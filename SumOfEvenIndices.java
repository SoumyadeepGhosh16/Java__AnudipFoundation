//wap to print the sum of elements of the even index from int array

public class SumOfEvenIndices {

    public static int countSum(int[] nums){

        //int variable to count the sum
        int sum = 0;

        //for loop to traverse through the array
        for(int i = 0;i<nums.length;i++){
            if(i%2==0){
                //calculating the sum of even indexed elements
                sum = sum + nums[i];
            }
        }

        return sum;
    }
    
    public static void main(String[] args) {
        
        int[] nums = {23,18,34,67,45,10};

        System.out.println(countSum(nums));
    }
}
