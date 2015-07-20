import java.util.ArrayList;
import java.util.List;

public class Cliente {  

    private static int total = 0;  
    private static final List<Cliente> clientes = new ArrayList<Cliente>();  
      
    public static List<Cliente> getClientes() {  
        return clientes;  
    }  
      
      
    private final int id;  
      
    private int duracao;  
      
    private int chegada;  
    private int atendimento;  
    private int fim;  
      
    Cliente() {  
        id = ++total;  
        clientes.add(this);  
    }  

    public void setDuracao(int duracao) {  
        this.duracao = duracao;  
    }  

    public int getDuracaoo() {  
        return duracao;  
    }  

    // TODO demais métodos set e get  

    @Override  
    public String toString() {  
        return String.format("C%04d[d=%d]", id, duracao);  
    }  
}  