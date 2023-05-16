public class Main {
    public static int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        return (arrivalTime + delayedTime) % 24;
    }

    public static void main(String[] args) {
        System.out.println("20: " + findDelayedArrivalTime(15,5));
        System.out.println("0: " + findDelayedArrivalTime(13,12));
    }
}