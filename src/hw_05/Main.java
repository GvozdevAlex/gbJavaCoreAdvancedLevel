package hw_05;

public class Main {
    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;

    static class CalcRunnable implements Runnable{
        private float[] arr;
        private int numberStart;

        public CalcRunnable(float[] arr, int numberStart) {
            this.arr = arr;
            this.numberStart = numberStart;
        }

        @Override
        public void run() {
            for (int i = 0; i < this.arr.length; i++) {
                this.arr[i] = (float) (this.arr[i] * Math.sin(0.2f + (this.numberStart + i) / 5) *
                        Math.cos(0.2f + (this.numberStart + i) / 5) * Math.cos(0.4f + (this.numberStart + i) / 2));
            }
        }
    }

    public static void Calc(float[] arr){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) *
                    Math.cos(0.4f + i / 2));
        }
    }

    public static void main(String[] args) throws InterruptedException {
        float[] arr = new float[SIZE];
        fullArr(arr);
        printHeadArr(arr);
        printTailArr(arr);

        long a = System.currentTimeMillis();
        Calc(arr);
        System.out.println("Время работы: " + (System.currentTimeMillis() - a));

        printHeadArr(arr);
        printTailArr(arr);

        fullArr(arr);
        float[] a1 = new float[HALF];
        float[] a2 = new float[HALF];

        System.arraycopy(arr,0, a1, 0, HALF);
        System.arraycopy(arr,HALF, a2, 0, HALF);

        a = System.currentTimeMillis();
        Thread t1 = new Thread(new CalcRunnable(a1, 0));
        Thread t2 = new Thread(new CalcRunnable(a2, HALF));
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.arraycopy(a1,0, arr, 0, HALF);
        System.arraycopy(a2,0, arr, HALF, HALF);
        System.out.println("Время работы: " + (System.currentTimeMillis() - a));

        printHeadArr(arr);
        printTailArr(arr);
    }

    public static  void fullArr(float[] arr){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
    }

    public static void printHeadArr(float[] arr){
        int count = Math.min(10, arr.length);
        for (int i = 0; i < count; i++) {
            System.out.print(arr[i]);
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void printTailArr(float[] arr){
        int beginElement = Math.max(0, arr.length - 10);
        for (int i = beginElement; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(" ");
        }
        System.out.println();
    }
}
