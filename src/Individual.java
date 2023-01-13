import java.util.*;
import java.text.*;

public class Individual {

    Random generator = new Random(0);
    private String chromosome;
    private double fitness;

    public Individual(){
        
    }

    public Individual(String chromosome, double fitness){
        this.chromosome = chromosome;
        this.fitness = fitness;
    }

    public Individual(String chromosome){
        this.chromosome = chromosome;
    }

    public double getFitness() {
        return fitness;
    }

    /*public int getFitness(){
        int result = 0;
        for(int i = 0; i < chromosome.length(); i++){
            if(chromosome.charAt(i) == '1')
                result++;
        }
        return result;
    }*/

    public String getChromosome() {
        return chromosome;
    }
    
    public Individual bitFlipMutation(double mProb, String pai){

        char[] characterArraypai = pai.toCharArray();
        
        for(int i = 0; i < pai.length(); i++){
            double r = generator.nextDouble();
            if(r < mProb){
                if(characterArraypai[i] == '1') 
                    characterArraypai[i] = '0';
                else characterArraypai[i] = '1';
            }
        }
        Individual result  = new Individual(String.valueOf(characterArraypai));
        return result;
    }


}
