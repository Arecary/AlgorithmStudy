public class Test {

  public static void main(String[] args) {

/*    int a = -88;
    String s = Integer.toBinaryString(a);
    System.out.println(s);

    String s1 = "10101000";
    byte i = (byte)Integer.parseInt(s1, 2);
    System.out.println(i);*/
//    byte [] b = {-88,28};
//    for (int i = 0; i < b.length; i++) {
//      System.out.println(b[i]);
//    }

    int[] nums = {5, 8, 6, 9};
    int result = MaxProductSubarray.maxProduct(nums);
    System.out.println(result);

  }





  public class MaxProductSubarray {

    public static int maxProduct(int[] nums) {
      // edge case
      if (nums == null || nums.length == 0) {
        return 0;
      }

      // Initialize the variables to keep track of maximum and minimum product
      // at the current position and the maximum product seen so far
      int maxProduct = nums[0];
      int minProduct = nums[0];
      int result = nums[0];

      // Iterate through the array starting from the second element
      for (int i = 1; i < nums.length; i++) {
        int tempMaxProduct = maxProduct;
        // Update maxProduct and minProduct for the current position
        maxProduct = Math.max(Math.max(maxProduct * nums[i], minProduct * nums[i]), nums[i]);
        minProduct = Math.min(Math.min(tempMaxProduct * nums[i], minProduct * nums[i]), nums[i]);
        // Update result if we find a larger product
        result = Math.max(result, maxProduct);
      }

      return result;
    }

  }
}
