package GA;

public class RUN {
	
	
		/* 
		
			This project was created by Youssef Sbai Idrissi
			Elaborated the 21th Feb. 2017
	
	
		*/
	
	
		public static void main(String[] args) throws ExtinctionException {
		
			// When we run the program, we'll have to stop the program after a n iteration if we don't get our condition
			
			
			
			Population p = new Population();
			p.Generate_Population(true);
			System.out.println(" ");
			System.out.println(" Num of Population " + p.getSize());
			System.out.println(" Generation               : 0 ");
			System.out.println(" Fitest rate              : " +  p.Get_Fittest().Get_Fitness());
			  System.out.print(" The Elite                : " );
			p.Get_Fittest().print_chromosome();
			System.out.println(" ________________________________"); 
			System.out.println(" ");
			
			int i = 1;
			
			while ( p.Get_Fittest().Get_Fitness() != 5 || i == 40 || p.getExtinction())
			{
				System.out.println(" Generation               : " + i );
				System.out.println(" ");

				p.Parent_Selection();
				System.out.println(" After parent selection   : " + p.getSize() + " Ind.");
				//p.Print_Population();
				
				p.CrossOVER(); // mutation included
				System.out.println(" After crossover          : " + p.getSize() + " Ind.");
				//p.Print_Population();
				
				p.Survivor_Selection();
				System.out.println(" After survivor Selection : " + p.getSize() + " Ind.");

				System.out.println(" ");
				System.out.println(" Fitest rate              : " +  p.Get_Fittest().Get_Fitness());
				
				System.out.print(" The Elite                : " );
				p.Get_Fittest().print_chromosome();
				
				System.out.println(" ________________________________");
				System.out.println(" ");
				i++;
			}
			
			//p.Print_Population();
		
			
		}

}
