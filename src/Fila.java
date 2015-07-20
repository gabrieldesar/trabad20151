import java.util.LinkedList;

public class Fila {  

    private final LinkedList<Cliente> fila = new LinkedList<Cliente>();  
      
    Fila() {  
    }  

    public boolean add(Cliente e) {  
        return fila.add(e);  
    }  

    public Cliente poll() {  
        return fila.poll();  
    }  

    public int size() {  
        return fila.size();  
    }  

    // TODO acumular e retornar dados estatísticos  
}  