package com.deepinblog;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by louisyuu on 2021/7/9 10:19 上午
 */
public class Matrix {

    /**
     * spiral  美  [ˈspaɪrəl] adj. 螺旋形的；盘旋的
     * Matrix in spiral order.
     * [[1,2,3],[4,5,6],[7,8,9]]
     * <p>
     * [1,2,3]
     * [4,5,6]
     * [7,8,9]
     */
    final static int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

    public static List<Integer> spiralOrder(int[][] matrix) {
        LinkedList<Integer> result = new LinkedList<>();
        if (matrix == null || matrix.length == 0) return result;
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        int elements = matrix.length * matrix[0].length;
        while (elements >= 1) {
            for (int i = left; i <= right && elements >= 1; i++) {
                result.add(matrix[top][i]);
                elements--;
            }
            top++;
            for (int i = top; i <= bottom && elements >= 1; i++) {
                result.add(matrix[i][right]);
                elements--;
            }
            right--;
            for (int i = right; i >= left && elements >= 1; i--) {
                result.add(matrix[bottom][i]);
                elements--;
            }
            bottom--;
            for (int i = bottom; i >= top && elements >= 1; i--) {
                result.add(matrix[i][left]);
                elements--;
            }
            left++;
        }
        return result;
    }


    public static void main(String[] args) {

        spiralOrder(matrix);

    }

}
