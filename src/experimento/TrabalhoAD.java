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
		//utilização é tempoOcupado/periodoObs
		//utilização esteira
		//utilização bicicleta
		
		System.out.println("Cenario1");
		Double utilizacaoEsteira = exp.academiaSims.get(0).tempoOcupadoEsteira / Experimento.TEMPO_SIMULACAO;
		System.out.println("Utilização Esteira: "+utilizacaoEsteira);
		Double livreEsteira = exp.academiaSims.get(0).tempoLivreEsteira / Experimento.TEMPO_SIMULACAO;
		System.out.println("TempoLivre Esteira: "+livreEsteira);
		Double utilizacaoBicicleta = exp.academiaSims.get(0).tempoOcupadoBicicleta / Experimento.TEMPO_SIMULACAO;
		System.out.println("Utilização Bicicleta: "+utilizacaoBicicleta);
		Double livreBicicleta = exp.academiaSims.get(0).tempoLivreBicicleta / Experimento.TEMPO_SIMULACAO;
		System.out.println("TempoLivre Bicicleta: "+livreBicicleta);
		
		System.out.println("Tempo Médio no Sistema: "+ exp.academiaSims.get(0).tempoMedioSistema());
		//tempo médio clientes no sistema
		//Comparar soluções com analítica (formula fechada) e sol. numerica da cadeira de markov finita
		
		//fluxos
		//entradaExogena
		//entradaAgregada
		//esteira para bike
		//esteira para fora
		//bike para fora
		//bike para esteira
		//saida agregada (bike para fora + esteira para fora). Quais sao poisson e quais não
		System.out.println("Cenario2");
		Double utilizacaoEsteira2 = exp.academiaSims.get(1).tempoOcupadoEsteira / Experimento.TEMPO_SIMULACAO;
		System.out.println("Utilização Esteira: "+utilizacaoEsteira2);
		Double livreEsteira2 = exp.academiaSims.get(1).tempoLivreEsteira / Experimento.TEMPO_SIMULACAO;
		System.out.println("TempoLivre Esteira: "+livreEsteira2);
		Double utilizacaoBicicleta2 = exp.academiaSims.get(1).tempoOcupadoBicicleta / Experimento.TEMPO_SIMULACAO;
		System.out.println("Utilização Bicicleta: "+utilizacaoBicicleta2);
		Double livreBicicleta2 = exp.academiaSims.get(1).tempoLivreBicicleta / Experimento.TEMPO_SIMULACAO;
		System.out.println("TempoLivre Bicicleta: "+livreBicicleta2);
		System.out.println("Tempo Médio no Sistema: "+ exp.academiaSims.get(1).tempoMedioSistema());
		
		
		System.out.println("Cenario3");
		Double utilizacaoEsteira3 = exp.academiaSims.get(2).tempoOcupadoEsteira / Experimento.TEMPO_SIMULACAO;
		System.out.println("Utilização Esteira: "+utilizacaoEsteira3);
		Double livreEsteira3 = exp.academiaSims.get(2).tempoLivreEsteira / Experimento.TEMPO_SIMULACAO;
		System.out.println("TempoLivre Esteira: "+livreEsteira3);
		Double utilizacaoBicicleta3 = exp.academiaSims.get(2).tempoOcupadoBicicleta / Experimento.TEMPO_SIMULACAO;
		System.out.println("Utilização Bicicleta: "+utilizacaoBicicleta3);
		Double livreBicicleta3 = exp.academiaSims.get(2).tempoLivreBicicleta / Experimento.TEMPO_SIMULACAO;
		System.out.println("TempoLivre Bicicleta: "+livreBicicleta3);
		System.out.println("Tempo Médio no Sistema: "+ exp.academiaSims.get(2).tempoMedioSistema());
	}
	
	
	public static void main(String[] args) {
		new TrabalhoAD();
		
	}

}
