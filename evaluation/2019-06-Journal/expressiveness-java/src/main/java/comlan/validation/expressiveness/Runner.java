package comlan.validation.expressiveness;

public class Runner {
    public static void main(String[] args) {
        Gaussian g1 = new Gaussian(5, 5, 0.5);
        Gaussian g2 = new Gaussian(10, 10, 0.9);
        Gaussian g3 = new Gaussian(8, 8, 1.2);

        int NB_LOOP = 1_000_000;

        double d1 = 5;
        double d2 = 10;
        double[] doubles = new double[NB_LOOP];

        long start = System.currentTimeMillis();
        for (int i = 0; i < NB_LOOP; i++) {
            doubles[i] = d1 + d2;
        }
        long end = System.currentTimeMillis();

        System.out.println(doubles.length);
        System.out.println("Normal finished in " + (end - start) + " ms");

        Gaussian[] gauss = new Gaussian[NB_LOOP];
        start = System.currentTimeMillis();
        for (int i = 0; i < NB_LOOP; i++) {
            gauss[i] = g1.add(g2);
        }
        end = System.currentTimeMillis();

        System.out.println(gauss.length);
        System.out.println("Uncertain finished in " + (end - start) + " ms");


    }
}
