package org.example;

public class Solution {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int numInNums1 = m - 1;
    int numInNums2 = n - 1;
    int currIndex = m + n - 1;

    while (numInNums1 >= 0 && numInNums2 >= 0) {
      if (nums1[numInNums1] > nums2[numInNums2]) {
        nums1[currIndex] = nums1[numInNums1];
        numInNums1--;
      } else {
        nums1[currIndex] = nums2[numInNums2];
        numInNums2--;
      }
      currIndex--;
    }

    while (numInNums2 >= 0) {
      nums1[currIndex] = nums2[numInNums2];
      numInNums2--;
      currIndex--;
    }
  }
}
