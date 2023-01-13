import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Population {

    ArrayList<Individual> individuos;
    private int n; // size population
    private int m; // size chromosome
    static private Random generator = new Random(0);
    
    public Population(){

    }
    // Construtor do F
    /* public Population(int n, int m, Random generator) {
        this.generator = generator;
        this.n = n;
        this.m = m;
        individuos = new ArrayList<>();

        for(int i = 0; i < n; i++) { // print string
            StringBuilder result = new StringBuilder();
            for (int j = 0; j < m; j++) { // construct string
                if(generator.nextDouble() < 0.5)
                    result.append("0");
                else result.append("1");
            }
            //individuos.add(new Individual(result.toString()));
            result.setLength(0);
        }
    }*/

    // Construtor do I
    /*public Population(int n, int m, Random generator) {
        this.generator = generator;
        this.n = n;
        this.m = m;
        individuos = new ArrayList<>();
    }*/

    //Construtor do J
    public Population(ArrayList<Individual> individuos){
        this.individuos = individuos;
    }


    public String toString() {
        tournament();
        StringBuilder str = new StringBuilder();
        for (Individual i : individuos) {
            str.append(i.getChromosome());
            str.append("\n");
        }
        return str.toString();
    }

    void genIndividual(double fitness) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < m; i++) {
            if(generator.nextDouble() < 0.5)
                str.append("0");
            else str.append("1");
        }
        individuos.add(new Individual(str.toString(), fitness));
    }

    Individual match() {
        ArrayList<Individual> sol = new ArrayList<>();
        double u = generator.nextDouble();
        int firstidx = (int) Math.round(u*(n-1));
        double u2 = generator.nextDouble();
        int otheridx = (int) Math.round(u2*(n-1));

        if (individuos.get(firstidx).getFitness() >= individuos.get(otheridx).getFitness())  {
            return (individuos.get(firstidx));
        }
        else return (individuos.get(otheridx));
    }

    ArrayList<Individual> tournament() {
        ArrayList<Individual> sol = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            sol.add(match());
        }
        return sol;
    }

    public ArrayList<Individual> roulette() {
        ArrayList<Individual> result = new ArrayList<Individual>();
        Collections.sort(this.individuos, (s1,s2) -> (int)(s2.getFitness() - s1.getFitness()));

        int n = individuos.size();
        double[] sum = new double[n];

        sum[0] = individuos.get(0).getFitness();
        for(int i = 1; i < n; i++){
            sum[i] = sum[i -1] + individuos.get(i).getFitness();
        }
        for(int i = 0; i < n; i++){
            sum[i] /= sum[n-1];
        }
        for(int i = 0; i < n; i++){
            double random = generator.nextDouble();
            for(int j = 0; j < n; j++){
                if(sum[j] > random){
                    result.add(individuos.get(j));
                    break;
                }
            }
        }
        Collections.sort(result, (s1,s2) -> (s1.getChromosome().compareTo(s2.getChromosome())));
        return result;
    }

    public Individual[] onePointCrossover(Individual pai1, Individual pai2){
        int crossoverPoint = (int) Math.round(generator.nextDouble() * pai1.getChromosome().length() - 1);
        String filho1 = pai1.getChromosome().substring(0,crossoverPoint) + pai2.getChromosome().substring(crossoverPoint);
        String filho2 = pai2.getChromosome().substring(0,crossoverPoint) + pai1.getChromosome().substring(crossoverPoint);
        Individual[] filhos = new Individual[]{new Individual(filho1), new Individual(filho2)};
        return filhos;
    }

    public Individual[] uniformCrossover(Individual pai1, Individual pai2){

        char[] characterArraypai1 = pai1.getChromosome().toCharArray();
        char[] characterArraypai2 = pai2.getChromosome().toCharArray();

        for(int i = 0; i < pai1.getChromosome().length(); i++){
            double r = generator.nextDouble();
            if(r < 0.5){
                char temp = characterArraypai1[i];
                characterArraypai1[i] = characterArraypai2[i];
                characterArraypai2[i] = temp;
            }
        }
        String result1 = String.valueOf(characterArraypai1);
        String result2 = String.valueOf(characterArraypai2);
        Individual[] results = new Individual[]{new Individual(result1), new Individual(result2)};
        return results;
    }

    public int[] randomPermutation(int n){

        int[] v =  new int[n];

        for(int i = 0; i < n; i++){
            v[i] = i;
        }
        for(int i = 0; i < n - 1; i++){
            int r = i + (int) Math.round(generator.nextDouble() * (n - 1 - i));
            int temp = v[i];
            v[i] = v[r];
            v[r] = temp;
        }
        return v;
    }


}
