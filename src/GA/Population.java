package GA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Population {
	
	private ArrayList<Chromosome> Chros = new ArrayList<Chromosome>();
	private int size;
	private boolean extinction = false;
	
	public boolean getExtinction()
	{
		return this.extinction;
	}
	
	public int getSize()
	{
		return this.Chros.size();
	}
	
	// Using a random initialization
	public void Generate_Population(Boolean t)
	{
	
		if ( t )
		{
			for ( int i=0; i < 20 ; i++ )
			{
				Chromosome tmp = new Chromosome();
				tmp.Generate_Chromosome();
				Chros.add(tmp);
			}
		}
		this.size = Chros.size();
		
	}
	
	// Our fitness criteria is having the more frequent repetitive gene in the chromosome 
	
	public Chromosome Get_Fittest() throws ExtinctionException 
	{
		Chromosome Elite = new Chromosome();
		int ss = 0;
		if ( this.Chros.size() != 0 )
		{
			Elite = Chros.get(0);
			for ( Chromosome i : Chros) 
			{
				if ( Elite.Get_Fitness() < i.Get_Fitness() )
				{
					Elite = i;
					ss++;
				}
				else if ( ss != 0 && Elite.Get_Fitness() == i.Get_Fitness() ){
					ss++;
				}
				
			}	
			
		}
		else 
		{
			throw new ExtinctionException();
		}
		
		
		
		
		return Elite;
		
	}
	
	
	// Parent Selection using Ranking Proportionate Selection. why ? Because the similitude between fitness rates is close
	public void Parent_Selection() throws ExtinctionException
	{
		System.out.println(" Num of Population " +  this.Chros.size());
		ArrayList Parent_List = new ArrayList();
		Parent_List = this.Chros;
		Collections.sort(Parent_List, new PopFitnessComparator());
		
		if( this.Chros.size() == 0 ) throw new ExtinctionException();
		
		this.size = Parent_List.size();
		
		double p = Math.random();
		
		 // in case the random rate is 0 when casted to int. we can't have a population equal to zero. 
	//	System.out.println(" Rate of selection " + p); 

		Chros.subList((int) (this.size * Math.random() ), Chros.size()).clear();		
	}
	
	// Crossover using  Uniform crossOver. 
	
	public void CrossOVER() throws ExtinctionException
	{
		
		int p; // We don't control the number of children, therefore the new number of chromosomes in the next generation
		boolean coin = false;

		for ( int i = 0; i < this.size - 2  ; i++)
		{
					p = (int) Math.random()%10;
					Chromosome Child;
					for ( int x = 0; x < 20 ; x++) // in the worst case, each two parents will generate 20 children. which mean ( Size + 20*(Size/2))
					{
						
						Child = new Chromosome();
						Child.Generate_Chromosome();
					
						for ( int j = 0; j < 5; j++, coin = ( Math.random() < 0.5 ))
						{
							Gene g = new Gene();
							g.Generate_Gene();
							if ( coin )
							{
								g = Chros.get(i).getChroValue(j);
								
							}
							else 
							{
								g = Chros.get(i+1).getChroValue(j);
							}
							Child.SetChroValue(j, g);	
							
						}
						
						if ( Math.random() < 0.4 ) // we have 40 % chance that the chromosom will be mutated.
						{
							Child.Mutate_Chromosome();
							//Child.Calcule_Fitness();
						}
						
						Child.Calcule_Fitness();
						Chros.add(Child);
						
						if ( p == 10 ) break;
						Child = null;
					}			
		}
		
		
		
	}
	
	
	// we'll use the fitness based selection, which means the highest number of a frequent letter 
	
	public void Survivor_Selection() 
	{
		
			ArrayList Selected_List = new ArrayList();
			Selected_List = this.Chros;
			Collections.sort(Selected_List, new PopFitnessComparator());
			this.Chros = Selected_List;
			double p = Math.random();
			Chros.subList((int) ((int) (this.Chros.size())*p), Chros.size()).clear();
			
		
		
	}
	

	public void Print_Population()
	{
		for (  Chromosome i : Chros  )
		{
			i.print_chromosome();

		}
		
		System.out.println(" ------ The Elite : " );
		try {
			this.Get_Fittest().print_chromosome();
		} catch (ExtinctionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("------------------------");
	}
}
