public class Main {
    public double average(int[] salary) {
        double min = salary[0];
        double max = salary[0];
        double sum = 0;
        for (int person: salary)
        {
            min = Math.min(min, person);
            max = Math.max(max, person);
            sum += person;
        }
        return (sum - max - min) / salary.length - 2;
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}