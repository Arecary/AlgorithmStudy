package ershua;

public class LC27 {

    public int removeElement(int[] nums, int val) {
        int last = nums.length - 1;
        int length = nums.length;
        for(int i= 0; i <= last;){
            if (nums[i] == val) {
                length--;
                nums[i] = nums[last];
                last--;
            }else {
                i++;
            }
        }
        
        return length;
    }


    public int removeElement2(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            if(nums[left] == val){
                nums[left] = nums[right];
                right--;
            }else {
                // ���������rightָ��ָ���ֵ��val��ȵ����
                left++;
            }
        }
        return left;
    }

}
