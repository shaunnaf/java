package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {
  @Test
  void testStandartCase() {
    System.out.println("======TEST 1 EXECUTED=======");
    Solution solution = new Solution();
    int[] nums1 = {1, 2, 3, 0, 0, 0};
    int[] nums2 = {2, 5, 6};
    solution.merge(nums1, 3, nums2, 3);
    assertArrayEquals(new int[]{1, 2, 2, 3, 5, 6}, nums1);
  }

  @Test
  void testNullSecondArrayCase() {
    System.out.println("======TEST 2 EXECUTED=======");
    Solution solution = new Solution();
    int[] nums1 = {1, 2, 3};
    int[] nums2 = new int[0];
    solution.merge(nums1, 3, nums2, 0);
    assertArrayEquals(new int[]{1, 2, 3}, nums1);
  }

  @Test
  void testNullFirstArrayCase() {
    System.out.println("======TEST 3 EXECUTED=======");
    Solution solution = new Solution();
    int[] nums2 = {1, 2, 3};
    int[] nums1 = {0,0,0};
    solution.merge(nums1, 0, nums2, 3);
    assertArrayEquals(new int[]{1, 2, 3}, nums1);
  }

  @Test
  void testNullFirst2ArrayCase() {
    System.out.println("======TEST 4 EXECUTED=======");
    Solution solution = new Solution();
    int[] nums2 = {1};
    int[] nums1 = new int[1];
    solution.merge(nums1, 0, nums2, 1);
    assertArrayEquals(new int[]{1}, nums1);
  }
}
