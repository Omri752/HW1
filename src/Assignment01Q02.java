public class Assignment01Q02 {
    public static void main(String[] args) {
        double actualPi = Math.PI;
        double approxPi = 0;

        int n = Integer.parseInt(args[0]);

        for (int k = 0; k < n; k++) {
            approxPi += Math.pow(-1, k) / (2 * k + 1);
        }
        approxPi *= 4;
        System.out.println(approxPi + " " + actualPi);
    }
}
