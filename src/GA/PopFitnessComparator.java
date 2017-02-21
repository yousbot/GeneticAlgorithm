package GA;

import java.util.Comparator;

public class PopFitnessComparator implements Comparator<Chromosome>{

	@Override
	public int compare(Chromosome c1, Chromosome c2) {
		// TODO Auto-generated method stub
		
		return ( c2.Get_Fitness() - c1.Get_Fitness() );
		
	}
	
	
	

}
