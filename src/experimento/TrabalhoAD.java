package experimento;

public class TrabalhoAD {
	public TrabalhoAD(){
		//cenario1();
		//cenario2();
		//cenario3();
		//cenario4();
		//cenario5();
		//cenario6();
		academia();
		
	}
	
	public void cenario1(){
		Experimento exp = new Experimento(CenariosType.CENARIO1);
		exp.runExperimento();
		Grafico grafico = new Grafico(exp);
		grafico.print(grafico.cenario1NumClientesPorLambda());
	}
	
	public void cenario2(){
		Experimento exp = new Experimento(CenariosType.CENARIO2);
		exp.runExperimento();
		Grafico grafico = new Grafico(exp);
		grafico.print(grafico.cenario2NumClientesPorLambda());
	}
	
	public void cenario3(){
		Experimento exp = new Experimento(CenariosType.CENARIO3);
		exp.runExperimento();
		Grafico grafico = new Grafico(exp);
		grafico.print(grafico.cenario3NumClientesPorMi());
	}
	
	public void cenario4(){
		Experimento exp = new Experimento(CenariosType.CENARIO4);
		exp.runExperimento();
		Grafico grafico = new Grafico(exp);
		grafico.print(grafico.cenario4NumClientesPorMi());
	}
	
	public void cenario5(){
		Experimento exp = new Experimento(CenariosType.CENARIO5);
		exp.runExperimento();
		Grafico grafico = new Grafico(exp);
		grafico.print(grafico.cenario5NumClientesPorMi());
	}
	
	public void cenario6(){
		Experimento exp = new Experimento(CenariosType.CENARIO5);
		exp.runExperimento();
		Grafico grafico = new Grafico(exp);
		grafico.print(grafico.cenario6NumClientesPorMi());
	}
	
	public void academia(){
		Experimento exp = new Experimento(CenariosType.ACADEMIA);
		exp.runExperimento();
		Grafico grafico = new Grafico(exp);
		grafico.print(grafico.academiaTempoMedioSistemaPorCenario());
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		new TrabalhoAD();
		
	}

}
