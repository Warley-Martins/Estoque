package Conta;
import java.util.ArrayList;
public class Estoque {
    private ArrayList<Registro> registros;
    public Estoque() {
        this.registros = new ArrayList<Registro>();
    }
    public boolean adicionarRegistro(Registro novoRegistro){
        if(novoRegistro == null) return false;
        registros.add(novoRegistro);
        return true;
    }
    public boolean removerRegistro(int id){
        var registroExcluido = procurarRegistro(id);
        if(registroExcluido == null) return false;
        registros.remove(registroExcluido);
        return true;
    }
    public Registro procurarRegistro(int id){
        return registros
                        .stream()
                        .filter(x -> x.getId() == id)
                        .findFirst()
                        .orElse(null);
    }
    public ArrayList<Registro> getRegistros() {
        return registros;
    }
}





