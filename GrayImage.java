

public class GrayImage implements Frame, Comparable<Frame> {
    private int[][] frame;

    public GrayImage(int[][] im_g) {
        this.frame = im_g;
    }



    public int getSize() {
        return this.frame[0].length * this.frame.length;
    }

    public GrayImage(GrayImage frame) {
        int size1 = frame.getFrame().length;
        int size2 = frame.getFrame()[0].length;
        this.frame = new int[size1][size2];
        for (int i = 0; i < size1; i++) {
            for (int j = 0; j < size2; j++) {
                this.frame[i][j] = frame.getFrame()[i][j];
            }
        }
    }

    @Override
    public void rotate90() {
        int lengthI, lengthJ;
        lengthI = this.frame.length;
        lengthJ = this.frame[0].length;
        int arr[][] = new int[lengthJ][lengthI];

        for (int i = 0; i < lengthI; i++) {
            for (int j = 0; j < lengthJ; j++) {

                arr[i][j] = this.frame[i][j];
            }

        }
        this.frame = arr;
    }

    @Override
    public void smooth(int n) {
        int lengthH, lengthW, sum = 0, num = 0, length;
        length = this.frame.length;
        lengthH = this.frame.length;
        lengthW = this.frame[0].length;
        int arr[][] = new int[lengthH][lengthW];


        for (int j = 0; j < lengthH; j++) {
            for (int i = 0; i < lengthW; i++) {

                for (int h = j - n; h <= n + j; h++) {
                    for (int w = i - n; w <= i + n; w++) {
                        if ((w >= 0 && w < lengthW) && (h >= 0 && h < lengthH)) {
                            sum += this.frame[h][w];
                            num++;

                        }
                    }

                    if (num > 0) {
                        arr[j][i] = (sum / num);
                        sum = num = 0;
                    }
                }
            }
        }
        this.frame = arr;
    }

    @Override
    public int[] getPixel(int x, int y) {
        int[] arr = new int[3];
        arr[0] = this.frame[x][y];
        arr[1] = this.frame[x][y];
        arr[2] = this.frame[x][y];
        return arr;
    }

    @Override
    public void crop(int x, int y) {
        int[][] arr = new int[x + 1][y + 1];

        for (int j = 0; j < x + 1; j++) {
            for (int k = 0; k < y + 1; k++) {
                arr[j][k] = this.frame[j][k];
            }
        }

        this.frame = arr;
    }

    @Override
    public void addFrom(Frame f) {

        int row = (this.frame.length > ((GrayImage) f).getFrame().length) ? ((GrayImage) f).getFrame().length : this.frame.length;
        int col = (this.frame[0].length > ((GrayImage) f).getFrame()[0].length) ? ((GrayImage) f).getFrame()[0].length : this.frame[0].length;
        for (int j = 0; j < row; j++) {
            for (int k = 0; k < col; k++) {
                this.frame[j][k] = ((GrayImage) f).getFrame()[j][k];
            }
        }
    }

    public int[][] getFrame() {
        return this.frame;
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
