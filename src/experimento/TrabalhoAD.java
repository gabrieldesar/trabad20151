package experimento;

public class TrabalhoAD {
	public TrabalhoAD(){
		Experimento exp = new Experimento();
		exp.runExperimento();
		Grafico grafico = new Grafico(exp);
		//grafico.print(grafico.cenario1NumClientesPorLambda());
		grafico.print(grafico.cenario2NumClientesPorLambda());
	}
	
	
	public static void main(String[] args) {
		new TrabalhoAD();
		
	}

}
