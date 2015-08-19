package experimento;

public class TrabalhoAD {
	public TrabalhoAD(){
		Experimento exp = new Experimento();
		exp.runExperimento();
		Grafico grafico = new Grafico(exp);
		//grafico.print(grafico.cenario1NumClientesPorLambda());
		//grafico.print(grafico.cenario2NumClientesPorLambda());
		//grafico.print(grafico.cenario3NumClientesPorMi());
		//grafico.print(grafico.cenario4NumClientesPorMi());
		//grafico.print(grafico.cenario5NumClientesPorMi());
		grafico.print(grafico.cenario6NumClientesPorMi());
	}
	
	
	public static void main(String[] args) {
		new TrabalhoAD();
		
	}

}
