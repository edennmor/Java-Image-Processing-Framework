
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FrameContainer implements ContainerFunctions {

    private Frame[] array;
    private int size, index;


    public FrameContainer(String nameFile) {
        this.array = new Frame[0];
        index = 0;
        size = this.array.length;
        try {
            File myObj = new File(nameFile);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                add(MyImageIO.readImageFromFile(data, false));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    @Override
    public void add(Frame f) {
        if (index == size) {
            this.array = Arrays.copyOf(this.array, this.array.length + 1);
            this.array[index++] = f;
            this.size++;
            return;
        }
        this.array[index++] = f;
    }

        public FrameContainer(){
        this.array=new Frame[10];
        size=0;
    }

    @Override
    public Frame get(int i) {

        if ((i < array.length && i >= 0))
            return this.array[i];
        return null;



    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void smoothAll(Frame[] f, int n) {
        for (int i = 0; i < f.length; i++) {
            f[i].smooth(n);
        }
    }

    @Override
    public void rotateAll() {
        for (int i = 0; i < this.array.length; i++) {
            this.array[i].rotate90();
        }
    }

    @Override
    public void sort() {
        Arrays.sort(this.array);
    }

    @Override
    public void remove(Frame f) {

    }


}
