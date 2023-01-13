public class OneMax implements IProblem {
    @Override
    public double fitness(Individual a){
        double result = 0;
        for(int i = 0; i < a.getChromosome().length(); i++){
            if(a.getChromosome().charAt(i) == '1')
                result++;
        }
        return result;
    }
}
