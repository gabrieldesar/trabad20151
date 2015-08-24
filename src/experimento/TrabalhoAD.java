package experimento;

public class TrabalhoAD {
	public TrabalhoAD(){
		//cenario1();
		//cenario1CDFSaidas();
		//cenario1PastaChegadas();
		//cenario2();
		//cenario2PastaChegadas();
		//cenario3();
		//cenario3PastaChegadas();
		//cenario4();
		//cenario4CDFSaidasExogenas();
		//cenario4CDFSaidas();
		//cenario4CDFEntradas();
		//cenario4PastaChegadas();
		//cenario4PastaSaidas();
		//cenario5();
		//cenario5PastaChegadas();
		//cenario6();
		//cenario6PastaChegadas();
		academia();
		
	}
	
	public void cenario1(){
		Experimento exp = new Experimento(CenariosType.CENARIO1);
		exp.runExperimento();
		Grafico grafico = new Grafico(exp);
		grafico.print(grafico.cenario1NumClientesPorLambda());
	}
	public void cenario1PastaChegadas(){
		Experimento exp = new Experimento(CenariosType.CENARIO1);
		exp.runExperimento();
		System.out.println("Fracao Sistema Vazio: " + exp.cenarios.get(0).rodadas.get(0).simuladores.get(0).fracaoSistemaVazio);
		System.out.println("Fracao Chegada Sistema Vazio: " + exp.cenarios.get(0).rodadas.get(0).simuladores.get(0).fracaoChegadasSistemaVazio);
	}
	
	public void cenario1CDFSaidas(){
		Experimento exp = new Experimento(CenariosType.CENARIO1);
		exp.runExperimento();
		Grafico grafico = new Grafico(exp);
		//SimulationLogger sl = new SimulationLogger("cdf");
		//sl.printCFD(exp.cenarios.get(0).rodadas.get(0).simuladores.get(10).temposEntreChegadas);
		grafico.print(grafico.cenario1CDF(exp.cenarios.get(0).rodadas.get(0).simuladores.get(10).temposEntreSaidas));
	}
	
	public void cenario2(){
		Experimento exp = new Experimento(CenariosType.CENARIO2);
		exp.runExperimento();
		Grafico grafico = new Grafico(exp);
		grafico.print(grafico.cenario2NumClientesPorLambda());
	}
	public void cenario2PastaChegadas(){
		Experimento exp = new Experimento(CenariosType.CENARIO2);
		exp.runExperimento();
		System.out.println("Fracao Sistema Vazio: " + exp.cenarios.get(0).rodadas.get(0).simuladores.get(0).fracaoSistemaVazio);
		System.out.println("Fracao Chegada Sistema Vazio: " + exp.cenarios.get(0).rodadas.get(0).simuladores.get(0).fracaoChegadasSistemaVazio);
	}
	
	public void cenario3(){
		Experimento exp = new Experimento(CenariosType.CENARIO3);
		exp.runExperimento();
		Grafico grafico = new Grafico(exp);
		grafico.print(grafico.cenario3NumClientesPorMi());
	}
	public void cenario3PastaChegadas(){
		Experimento exp = new Experimento(CenariosType.CENARIO3);
		exp.runExperimento();
		System.out.println("Fracao Sistema Vazio: " + exp.cenarios.get(0).rodadas.get(0).simuladores.get(0).fracaoSistemaVazio);
		System.out.println("Fracao Chegada Sistema Vazio: " + exp.cenarios.get(0).rodadas.get(0).simuladores.get(0).fracaoChegadasSistemaVazio);
	}
	
	public void cenario4(){
		Experimento exp = new Experimento(CenariosType.CENARIO4);
		exp.runExperimento();
		Grafico grafico = new Grafico(exp);
		grafico.print(grafico.cenario4NumClientesPorMi());
	}
	public void cenario4CDFSaidasExogenas(){
		Experimento exp = new Experimento(CenariosType.CENARIO4);
		exp.runExperimento();
		Grafico grafico = new Grafico(exp);
		grafico.print(grafico.cenario4SaidasExogenasCDF(exp.cenarios.get(0).rodadas.get(0).simuladores.get(18).temposEntreSaidasExogenas));
	}
	public void cenario4CDFSaidas(){
		Experimento exp = new Experimento(CenariosType.CENARIO4);
		exp.runExperimento();
		Grafico grafico = new Grafico(exp);
		grafico.print(grafico.cenario1CDF(exp.cenarios.get(0).rodadas.get(0).simuladores.get(10).temposEntreSaidas));
	}
	public void cenario4CDFEntradas(){
		Experimento exp = new Experimento(CenariosType.CENARIO4);
		exp.runExperimento();
		Grafico grafico = new Grafico(exp);
		grafico.print(grafico.cenario4ChegadasCDF(exp.cenarios.get(0).rodadas.get(0).simuladores.get(10).temposEntreChegadas));
	}
	
	public void cenario4PastaChegadas(){
		Experimento exp = new Experimento(CenariosType.CENARIO4);
		exp.runExperimento();
		System.out.println("Fracao Sistema Vazio: " + exp.cenarios.get(0).rodadas.get(0).simuladores.get(0).fracaoSistemaVazio);
		System.out.println("Fracao Chegada Sistema Vazio: " + exp.cenarios.get(0).rodadas.get(0).simuladores.get(0).fracaoChegadasSistemaVazio);
	}
	public void cenario4PastaSaidas(){
		Experimento exp = new Experimento(CenariosType.CENARIO4);
		exp.runExperimento();
		System.out.println("Fracao Sistema Vazio: " + exp.cenarios.get(0).rodadas.get(0).simuladores.get(0).fracaoSistemaVazio);
		System.out.println("Fracao Saidas Sistema Vazio: " + exp.cenarios.get(0).rodadas.get(0).simuladores.get(0).fracaoSaidasSistemaVazio);
	}
	public void cenario5(){
		Experimento exp = new Experimento(CenariosType.CENARIO5);
		exp.runExperimento();
		Grafico grafico = new Grafico(exp);
		grafico.print(grafico.cenario5NumClientesPorMi());
	}
	public void cenario5PastaChegadas(){
		Experimento exp = new Experimento(CenariosType.CENARIO5);
		exp.runExperimento();
		System.out.println("Fracao Sistema Vazio: " + exp.cenarios.get(0).rodadas.get(0).simuladores.get(0).fracaoSistemaVazio);
		System.out.println("Fracao Chegada Sistema Vazio: " + exp.cenarios.get(0).rodadas.get(0).simuladores.get(0).fracaoChegadasSistemaVazio);
	}
	
	public void cenario6(){
		Experimento exp = new Experimento(CenariosType.CENARIO5);
		exp.runExperimento();
		Grafico grafico = new Grafico(exp);
		grafico.print(grafico.cenario6NumClientesPorMi());
	}
	public void cenario6PastaChegadas(){
		Experimento exp = new Experimento(CenariosType.CENARIO6);
		exp.runExperimento();
		System.out.println("Fracao Sistema Vazio: " + exp.cenarios.get(0).rodadas.get(0).simuladores.get(0).fracaoSistemaVazio);
		System.out.println("Fracao Chegada Sistema Vazio: " + exp.cenarios.get(0).rodadas.get(0).simuladores.get(0).fracaoChegadasSistemaVazio);
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
