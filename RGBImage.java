import java.util.Arrays;

public class RGBImage implements Frame, Comparable<Frame> {

    public int frame[][][];

    public RGBImage(int[][][] frame) {
        this.frame = frame;
    }


    public RGBImage(RGBImage frame) {
        int size1 = frame.getFrame().length;
        int size2 = frame.getFrame()[0].length;
        int size3 = frame.getFrame()[0][0].length;
        this.frame = new int[size1][size2][size3];
        for (int i = 0; i < size1; i++) {
            for (int j = 0; j < size2; j++) {
                for (int k = 0; k < size3; k++) {
                    this.frame[i][j][k] = frame.getFrame()[i][j][k];
                }
            }
        }
    }

    @Override
    public void rotate90() {
        int lingthI, lengthJ;
        lingthI = this.frame[0].length;
        lengthJ = this.frame[0][0].length;
        int arr[][][] = new int[3][lengthJ][lingthI];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < lengthJ; j++) {
                for (int k = 0; k < lingthI; k++) {
                    arr[i][j][lingthI - 1 - k] = this.frame[i][k][j];
                }
            }
        }
        this.frame = arr;
    }

    @Override
    public void smooth(int n) {
        int lengthH, lengthW, sum = 0, num = 0, length;
        length = this.frame.length;
        lengthH = this.frame[0].length;
        lengthW = this.frame[0][0].length;
        int arr[][][] = new int[length][lengthH][lengthW];

        for (int k = 0; k < length; k++) {
            for (int j = 0; j < lengthH; j++) {
                for (int i = 0; i < lengthW; i++) {

                    for (int h = j - n; h <= n + j; h++) {
                        for (int w = i - n; w <= i + n; w++) {
                            if ((w >= 0 && w < lengthW) && (h >= 0 && h < lengthH)) {
                                sum += this.frame[k][h][w];
                                num++;
                            }
                        }
                    }

                    if (num > 0) {
                        arr[k][j][i] = (sum / num);
                        sum = num = 0;
                    }
                }
            }
        }
        this.frame = arr;
    }


    @Override
    public int[] getPixel(int x, int y) {

        if (x < this.frame[0].length && y < this.frame[0][0].length) {
            int[] arr = new int[3];
            arr[0] = this.frame[0][x][y];//R
            arr[1] = this.frame[1][x][y];//G
            arr[2] = this.frame[2][x][y];//B
            return arr;
        }
        return null;
    }

    @Override
    public void crop(int x, int y) {
        if (x < this.frame[0].length && y < this.frame[0][0].length) {
            int[][][] arr = new int[frame.length][x + 1][y + 1];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < x + 1; j++) {
                    for (int k = 0; k < y + 1; k++) {
                        arr[i][j][k] = this.frame[i][j][k];
                    }
                }
            }
            this.frame = arr;
        }
    }


    public int[][][] getFrame() {
        return frame;
    }

    @Override
    public void addFrom(Frame f) {
        int row = (this.frame[0].length > ((RGBImage) f).getFrame()[0].length) ? ((RGBImage) f).getFrame()[0].length : this.frame[0].length;
        int col = (this.frame[0][0].length > ((RGBImage) f).getFrame()[0][0].length) ? ((RGBImage) f).getFrame()[0][0].length : this.frame[0][0].length;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < row; j++) {
                for (int k = 0; k < col; k++) {
                    this.frame[i][j][k] += (int) ((RGBImage) f).getFrame()[i][j][k];
                }
            }
        }
    }


    @Override
    public String toString() {
        String str = "mat{\n";

        int runRGB = 0;
        for (int i = 0; i < frame.length; i++) {
            str += getColor(runRGB++);
            for (int j = 0; j < frame[i].length; j++) {
                str += "\t\t" + Arrays.toString(frame[i][j]);
                str += "\n";
            }
        }
        str += "}";
        return str;
    }


    public String getColor(int run) {
        if (run == 0) {
            return "\tR\n";
        } else if (run == 1) {
            return "\tG\n";
        } else {
            return "\tB\n";
        }
    }

    public int getSize() {

        return this.frame[0][0].length * this.frame[0].length * this.frame.length;

    }

    @Override
    public int compareTo(Frame f) {
        if (f.getSize() > this.getSize())
            return -1;
        else if (f.getSize() < this.getSize())
            return 1;
        return 0;
    }

}
