import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //F
        //String n = sc.nextLine(); // size population
        //String m = sc.nextLine(); // size chromosome
        // Population pop = new Population(n, m);
        // System.out.print(pop.toString());

        //G
        // Population pop = new Population();
        //String a = sc.nextLine();
        // System.out.println(pop.oneMax(a));

        //H
        //Population pop = new Population();
        //String a = sc.nextLine();
        //System.out.println(pop.square(a));

        //Problem I
       /* Random generator = new Random(0);
        int n = sc.nextInt();
        Population pop = new Population(n, sc.nextInt(), generator);

        for (int i = 0; i < n; i++) {
            pop.genIndividual(sc.nextDouble());
        }
        ArrayList<Individual> solution = pop.tournament();

        for (Individual i : solution) {
            System.out.println(i.getChromosome());
        }*/

        //J
        /*ArrayList<Individual> individuals = new ArrayList<>();
        while (sc.hasNext()) {
            individuals.add(new Individual(sc.next(), Double.parseDouble(sc.next())));
        }
        Population pop = new Population(individuals);
        ArrayList<Individual> novo = pop.roulette();
        for (Individual n1: novo) {
            System.out.println(n1.getChromosome());
        }*/

        //L
        /*
        Population pop = new Population();
        String filho1 = sc.nextLine();
        String filho2 = sc.nextLine();
        String[] filhos = pop.onePointCrossover(filho1,filho2);

        for(int i = 0; i < filhos.length; i++){
            System.out.println(filhos[i]);
        }*/
        //System.out.println(Arrays.toString(pop.onePointCrossover(sc.nextLine(),sc.nextLine())));

        //M
        /*Population pop = new Population();
        String filho1 = sc.nextLine();
        String filho2 = sc.nextLine();
        String[] filhos = pop.uniformCrossover(filho1,filho2);

        for(int i = 0; i < filhos.length; i++){
            System.out.println(filhos[i]);
        }*/

        //N
        /*Individual ind = new Individual();
        double mProb = Double.parseDouble(sc.next());
        String filho = sc.next();
        System.out.println(ind.bitFlipMutation(mProb,filho));
        */

        //O
        Population pop = new Population();

        int n = sc.nextInt();
        int[] result = pop.randomPermutation(n);

        for(int i = 0; i < result.length; i++){
            System.out.println(result[i]);
        }

        sc.close();
    } 
}