public class XSquared implements IProblem{
    @Override
    public double fitness(Individual a){
        return (int) Math.pow(Integer.parseInt(a.getChromosome(), 2), 2);
    }

}
