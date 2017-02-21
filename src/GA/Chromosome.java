package GA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;

import com.sun.javafx.collections.MappingChange.Map;

public class Chromosome {
	
	private ArrayList<Gene> Ch_Value = new ArrayList<Gene>(5);
	private int fitness = 0;
	 
	public void Generate_Chromosome()
	{
		
		for ( int i = 0; i < 5; i++)
		{
			Gene tmp = new Gene();
			tmp.Generate_Gene();
			this.Ch_Value.add(tmp);
		}
		
		this.Calcule_Fitness();
		
	}
	
	
	public void Mutate_Chromosome()
	{
		Random r = new Random();
		int i = Math.abs(r.nextInt()%5);
		Gene tmp = new Gene();
		this.Ch_Value.get(i).MutationGene(tmp);
		this.Calcule_Fitness();
		
	}
	
	public String toString()
	{
		String Ch_string = " ";
		for (int i = 0; i < 5; i++)
		{
			Ch_string += this.Ch_Value.get(i);
		}
		return Ch_string;
		
	}
	
	
	public void setChromosome(Chromosome c)
	{
		this.Ch_Value = c.Ch_Value;
		this.fitness = c.fitness;
	}
	
	
	public void Calcule_Fitness()
	{
		 HashMap<Character, Integer> rep =  new HashMap<Character, Integer>();
		 
		 // we get num of repetition of each gene
		 for ( int i = 0; i < this.Ch_Value.size(); i++)
		 {
			 
			 char c = Ch_Value.get(i).getGeneValue();
			 Integer count = rep.get(c);
			 
			 if ( count == null )
				 count = 0;
			 
			 rep.put(c, count + 1);
			 
		 }
		 
		 // Now, we get the max 
		HashMap.Entry<Character, Integer> max= null;
		
		for ( HashMap.Entry<Character, Integer> en : rep.entrySet())
		{
			if ( max == null || en.getValue().compareTo(max.getValue()) > 0)
			{
				max = en;
			}
		}
		 
		this.fitness = max.getValue();
		 
		 
	}
	
	public int Get_Fitness()
	{
		return this.fitness;
	}
	
	
	public void SetChroValue(int s, Gene g)
	{
		int i =0;
		for ( Gene gg : this.Ch_Value )
		{
			if ( i == s )
			{
				gg.SetGene(g);;
			}
			i++;
		}
	}
	
	
	public Gene getChroValue(int i)
	{
		return this.Ch_Value.get(i);
	}
	
	
	
	public Gene GetGeneID(int i )
	{
		return this.Ch_Value.get(i);
	}
	
	
	
	public void print_chromosome()
	{
		for ( Gene i : Ch_Value)
		{
			System.out.print(" " + i.getGeneValue());
		}
		System.out.println(" ");
		System.out.println(" Fitness  " + this.fitness);
	}
	
	
	

}
