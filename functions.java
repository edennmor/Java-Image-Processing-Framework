import java.util.Random;

class functions {




    public static int[][][] getRandomSizwOfArr(int row, int col) {
        int[][][] arr = new int[3][row][col];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < row; j++) {
                for (int k = 0; k < col; k++) {
                    arr[i][j][k] = j * k;
                }
            }
        }
        return arr;
    }

    public static int[][][] getRandomSizwOfArr2(int row, int col) {
        int[][][] arr = new int[3][row][col];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < row; j++) {
                for (int k = 0; k < col; k++) {
                    arr[i][j][k] = (j * k < 255) ? j * k + 1 : 255;
                }
            }
        }
        return arr;
    }



}