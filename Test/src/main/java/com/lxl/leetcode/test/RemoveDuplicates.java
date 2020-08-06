package com.lxl.leetcode.test;//给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
//
// 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。 
//
// 
//
// 示例 1: 
//
// 给定数组 nums = [1,1,2], 
//
//函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。 
//
//你不需要考虑数组中超出新长度后面的元素。 
//
// 示例 2: 
//
// 给定 nums = [0,0,1,1,1,2,2,3,3,4],
//
//函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
//
//你不需要考虑数组中超出新长度后面的元素。
// 
//
// 
//
// 说明: 
//
// 为什么返回数值是整数，但输出的答案是数组呢? 
//
// 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。 
//
// 你可以想象内部操作如下: 
//
// // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
//int len = removeDuplicates(nums);
//
//// 在函数里修改输入数组对于调用者是可见的。
//// 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
//for (int i = 0; i < len; i++) {
//    print(nums[i]);
//}
// 
// Related Topics 数组 双指针 
// 👍 1562 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class RemoveDuplicates {
    public static void main(String[] args) {
        int[] a = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.err.println(removeDuplicates(a));
        for (int i : a) {
            System.out.print(i);
        }
    }


    public static int removeDuplicates(int[] nums) {

        if (nums == null) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        /**
         * 方法一：一次比较前后两数是否相同，相同将后一个移动到数组末尾
         * @param nums
         * @return int i = 0;
        int j = 1;
        int k = nums.length;
        while (j < k) {
        if (nums[i] == nums[j]) {
        move(nums, j);
        k--;
        } else {
        i++;
        j++;
        }
        }
        return k;
         */
        /**
         * 方法二: 一次遍历前后两个数字，相同，将后一个数字设置成-1。在移动数组
         */
        int i = 0;
        int j = 1;
        int length = nums.length;
        while (j < nums.length) {
            if (nums[i] != nums[j]) {
                i = j;
            } else {
                nums[j] = -1;
                length--;
            }
            j++;
        }
        int temp = 0;
        for (int k = 0; k < length; k++) {
            if (nums[k] == -1) {
                temp = nextNum(nums, k);
                nums[k] = nums[temp];
                nums[temp] = -1;
            }
        }
        return length;
    }

    private static int nextNum(int[] nums, int k) {
        for (; k < nums.length; k++) {
            if (nums[k] != -1) {
                return k;
            }
        }
        return 0;
    }

    private static void move(int[] nums, int j) {
        int last = nums[j];
        int i = j;
        for (; i < nums.length - 1; i++) {
            nums[i] = nums[i + 1];
        }
        nums[i] = last;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
