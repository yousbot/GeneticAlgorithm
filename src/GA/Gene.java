package GA;
import java.util.Random;

public class Gene {
 

	private char Value;
	private double Gene_Mutation_Rate = 1; // selection coefficient
	private String Model_Set = "BCDEFGHIJKLMNOPQRSTUVWXYZ"; 
	
	
	public void Generate_Gene()
	{	 
		 Random r = new Random();
		 
		 this.Value = Model_Set.charAt(r.nextInt(Model_Set.length()));
		 this.Gene_Mutation_Rate /= r.nextDouble()%100;
	}
	 
	public void MutationGene(Gene g)
	{
		 Random r = new Random();
		this.Gene_Mutation_Rate = g.Gene_Mutation_Rate;
		this.Value = Model_Set.charAt((int) (Model_Set.length()*Math.random()*this.Gene_Mutation_Rate));
	}
	
	public void SetGene(Gene g)
	{
		this.Value = g.Value;
		this.Gene_Mutation_Rate = g.Gene_Mutation_Rate;
	}
	
	
	
	
	 public void Print_Gene()
	 {
		 System.out.println(" Value " + this.Value);
		 System.out.println(" Rate  " + this.Gene_Mutation_Rate);
	 }
	 
	 public char getGeneValue()
	 {
		 return this.Value;
	 }
	
	 public void setGeneValue(Gene g)
	 {
		 this.Value = g.Value;
		 this.Gene_Mutation_Rate = g.Gene_Mutation_Rate;
		 
	 }
	 
}
