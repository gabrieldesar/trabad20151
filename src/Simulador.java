import java.util.Random;

public class Simulador {  

    public static void main(String[] args) {  
        Simulador sim = new Simulador(4, 4, new Random());  
        sim.simular();  
        System.out.printf("criados:   %d%n", Cliente.getClientes().size());  
        System.out.printf("esperando: %d%n", sim.fila.size());  
        // TODO outros dados estatísticos  
    }  
      
    private final int taxaChegada;  
    private final int taxaDuracao;  
      
    private final Fila fila = new Fila();  
    private final Random random;  
      
    private int proximaChegada;  
    private Cliente emAtendimento;  
    private int fimAtendimento;  
      
    Simulador(int taxaChegada, int taxaDuracao, Random random) {  
        this.taxaChegada = taxaChegada;  
        this.taxaDuracao = taxaDuracao;  
        this.random = random;  
    }  
      
    private void simular() {  
        proximaChegada = 1 + random.nextInt(taxaChegada);  
        fimAtendimento = 0;  
        emAtendimento = null;  
          
        for (int tempo = 1; tempo <= 720; tempo++) {  
            if (proximaChegada <= tempo) {  
                novoCliente(tempo);  
            }  
            if (emAtendimento != null && fimAtendimento <= tempo) {  
                fimCliente(tempo);  
            }   
            if (emAtendimento == null) {  
                proximoCliente(tempo);  
            }  
        }  
    }  

    // TODO métodos usados em simular()  
}  