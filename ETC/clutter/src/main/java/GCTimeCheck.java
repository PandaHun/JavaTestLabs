public class GCTimeCheck {

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        long endTime = System.nanoTime();
        System.out.println("Before Using gc");
        System.out.println(endTime - startTime +"ns");
        System.out.println("==================");
        startTime = System.nanoTime();
        System.gc();
        endTime = System.nanoTime();
        System.out.println("After Using gc");
        System.out.println(endTime - startTime +"ns");
    }
}
