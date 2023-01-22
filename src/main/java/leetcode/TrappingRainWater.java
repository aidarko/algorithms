package leetcode;

import java.util.ArrayList;
import java.util.List;

public class TrappingRainWater {
    public static void main(String[] args) {
        // [5,5,1,7,1,1,5,2,7,6]
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        List<Integer> a = new ArrayList<>();
        a.add(5);
        a.add(5);
        a.add(1);
        a.add(7);
        a.add(1);
        a.add(1);
        a.add(5);
        a.add(2);
        a.add(7);
        a.add(6);

        Integer[] arr = new Integer[a.size()];
        arr = a.toArray(arr);
        trappingRainWater.trap(arr);
    }

    public int trap(Integer[] height) {
        int highestLeft = height[0];
        int highestRight  = height[height.length-1];
        int result = 0;

        int pointerLeft = 0;
        int pointerRight = height.length-1;

        while (height[pointerLeft] == 0 && pointerLeft < pointerRight) {
            pointerLeft++;
        }
        while (height[pointerRight] == 0 && pointerLeft < pointerRight) {
            pointerRight--;
        }
        //highestLeft = Math.max(highestLeft, height[pointerLeft]);
        //highestRight = Math.max(highestRight, height[pointerRight]);

        while (pointerLeft < pointerRight) {
            if (height[pointerLeft] < height[pointerRight]) {
                if (highestLeft > height[pointerLeft]) {
                    result = result + (highestLeft - height[pointerLeft]);
                } else {
                    highestLeft = height[pointerLeft];
                }
                pointerLeft++;
            } else {
                if (highestRight > height[pointerRight]) {
                    result = result + (highestRight - height[pointerRight]);
                } else {
                    highestRight = height[pointerRight];
                }
                pointerRight--;
            }
        }


        return result;
    }
}
