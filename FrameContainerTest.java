import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FrameContainerTest {
    FrameContainer container;
    ArrayList<int[][]> listArr = new ArrayList<>();
    ArrayList<Frame> frames = new ArrayList<>();

    @BeforeEach
    void setUp() {
        container = new FrameContainer("filetmonotNames.txt");
        for (int i = 0; i < 8; i++) {
            int[][][] img = MyImageIO.readImageFromFile("imagesForTest/" + i + ".jpg");
            int[][] imgGray = MyImageIO.RGB_TO_Gray(img);
            GrayImage rgbi = new GrayImage(imgGray);
            listArr.add(i, imgGray);
            frames.add(i, rgbi);
        }
    }

    @Test
    void get() {
        for (int i = 0; i < container.size(); i++) {
            assertEquals(frames.get(i), container.get(i));
            if (i > 0) {
                assertFalse(frames.get(i) == container.get(i - 1));
            }
        }
    }

    @Test
    void size() {
        assertEquals(frames.size(), container.size());
    }

    @Test
    void smoothAll() {

    }

    @Test
    void rotateAll() {
    }

    @Test
    void sort() {
    }

    @Test
    void remove() {
        Frame del = container.get(1);
        container.remove(del);
        int[] arr = new int[0];
        int index = 0;
        arr = addToArr(index, 1, arr);
        assertEquals(frames.size() - 1, container.size());
        for (int i = 0; i < container.size(); i++) {
            assertNotEquals(del, container.get(i));
        }
    }

    private int[] addToArr(int index, int value, int[] arr) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[index++] = value;
        return arr;
    }

    @Test
    void add() {
    }
}