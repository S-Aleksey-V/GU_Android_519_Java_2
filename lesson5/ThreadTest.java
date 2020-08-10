package java2.lesson5;


import java.util.Arrays;

public class ThreadTest {
    static final int size = 10000000;
    static final int h = size / 2;


    public float[] calculate(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        return arr;
    }

    public void runOneThread() {
        float[] arr = new float[size];
        Arrays.fill(arr, 1.0f);
        long a = System.currentTimeMillis();
        calculate(arr);
        System.out.println("One thread finish  : " + (System.currentTimeMillis() - a));
    }

    public void runTwoThreads() {
        float[] arr = new float[size];
        float[] arr1 = new float[h];
        float[] arr2 = new float[h];
        Arrays.fill(arr, 1.0f);

        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, arr1, 0, h);
        System.arraycopy(arr, h, arr2, 0, h);

        new Thread(() -> {
            float[] a1 = calculate(arr1);
            System.arraycopy(arr1, 0, arr, 0, a1.length);
        }).start();

        new Thread(() -> {
            float[] a2 = calculate(arr2);
            System.arraycopy(arr1, 0, arr, 0, a2.length);
        }).start();

        System.arraycopy(arr1, 0, arr, 0, h);
        System.arraycopy(arr2, 0, arr, h, h);
        System.out.println("Two threads finished " + (System.currentTimeMillis() - a));

    }

    public static void main(String[] args) {

        ThreadTest o = new ThreadTest();
        o.runOneThread();
        o.runTwoThreads();

    }
}
