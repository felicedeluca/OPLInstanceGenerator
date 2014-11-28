import problems.*;

public class Main {

	public static void main(String[] args) {
		
		int dim = 0;
		int time = 0;
		String problem = "";
		String outputFile = "";
		InstanceGenerator instGen = null;
		
		/*
		 * --DIMENSION
		 * --MAXTIME
		 * --PROBLEM
		 * --OUTPUT
		 *
		 * */
		
		if(args.length==0 || args[0].equals("--help"))
		{
			System.out.println("Generatore di file .dat per CPlex OPL");
			System.out.println("Parametri:");
			System.out.println("--DIM  (integer) definisce la dimensione del problema;");
			System.out.println("--MAXTIME  (integer) definisce il vincolo di tempo massimo (ove previsto);");
			System.out.println("--OUTPUT  (String) definisce il percorso in cui salvare il file generato;");
			System.out.println("--PROBLEM definisce il tipo di problema tra:");
			System.out.println("\tOP Orienteering Problem");
			System.exit(0);

		}
		
		try{
		
			for(int i=0; i<args.length; i++){
			
				if(args[i].equals("--DIM")){
					dim = Integer.parseInt(args[++i]);
					continue;
				}
				if(args[i].equals("--MAXTIME")){
					time = Integer.parseInt(args[++i]);
					continue;
				}
				if(args[i].equals("--PROBLEM")){
					problem = args[++i];
					continue;
				}
				if(args[i].equals("--OUTPUT")){
					outputFile = args[++i];
					continue;
				}
			}
	
		}catch(Exception e){
			System.out.println("Errore nella definizione dei parametri");
			System.out.println("Parametri:");
			System.out.println("--DIM (integer) definisce la dimensione del problema;");
			System.out.println("--MAXTIME  (integer) definisce il vincolo di tempo massimo (ove previsto);");
			System.out.println("--OUTPUT  (String) definisce il percorso in cui salvare il file generato;");
			System.out.println("--PROBLEM definisce il tipo di problema tra:");
			System.out.println("\tOP Orienteering Problem");
			System.exit(1);

		}
		
		if(problem.equals("OP")){
			instGen = new OPInstanceGenerator(dim, time);
		}
		
		if(instGen == null){
			System.out.println("Definire il problema come parametro:");
			System.out.println("--PROBLEM definisce il tipo di problema tra:");
			System.out.println("\tOP Orienteering Problem");
		}
		
		if(instGen != null)
			instGen.printOnFile(outputFile);
		
		
	}

}