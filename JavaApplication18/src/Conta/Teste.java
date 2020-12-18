package Conta;

import java.util.Scanner;

public class Teste {
    static Scanner input = new Scanner(System.in);
    static int quantidadeFuncionalidadePrograma = 4;
    static int opcaoEncerraPrograma = 0;
    public static void main(String[] args) {
        Estoque estoque = new Estoque();
        menuApresentacaoPrograma();
        int opcaoFuncionalidade;
        do{
            do{
                
                opcaoFuncionalidade = atribuirInt(menuFuncionalidadesPrograma());
            }while(opcaoFuncionalidade < opcaoEncerraPrograma 
                || opcaoFuncionalidade > quantidadeFuncionalidadePrograma);
            switch(opcaoFuncionalidade){
                case 1 -> adicionarNovoRegistro(estoque);
                case 2 -> removerRegistro(estoque);
                case 3 -> printarTodosRegistros(estoque);
                case 4 -> {
                    var registro = procurarRegistro(estoque);
                    printarRegistro(registro);
                }
                case 0 -> encerraPrograma();
            }
        }while(opcaoFuncionalidade != opcaoEncerraPrograma);
    }
    private static void menuApresentacaoPrograma() {
        System.out.println("\tPrograma Estoque"
                         + "\n\tWarley Júnio Martins Vieira"
                         + "\n\tProgramação de Computadores 2");
    }
    private static String menuFuncionalidadesPrograma(){
        return "\nDigite a opção desejada:"
             + "\n(1). Adicionar uma nova ferramenta no estoque                (2). Remover uma ferramenta no estoque"
             + "\n(3). Printar todas as ferramentas no estoque                 (4). Procurar uma ferramenta no estoque"
             + "\n(0). Encerrar"
             + "\nOpção desejada: ";
    }
    public static int atribuirInt(String mensagem){
        int valorAtribuido;
        do{
            try{
                System.out.print(mensagem);
                valorAtribuido = Integer.parseInt(input.nextLine());
                return valorAtribuido;
            }
            catch(Exception e){
                System.out.println("Exce lançada: "+e.getMessage());
            }
        }while(true);
    }
    public static double atribuirDouble(String mensagem){
        double valorAtribuido;
        do{
            try{
                System.out.print(mensagem);
                valorAtribuido = Double.parseDouble(input.nextLine());
                return valorAtribuido;
            }
            catch(Exception e){
                System.out.println("Exce lançada: "+e.getMessage());
            }
        }while(true);
    }
    public static String atribuirString(String mensagem){
        String valorAtribuido;
        do{
            System.out.print(mensagem);
            valorAtribuido = input.nextLine();
            if(!valorAtribuido.isEmpty()) return valorAtribuido;          
        }while(true);
    }
    private static boolean adicionarNovoRegistro(Estoque estoque) {
        Registro novoRegistro;
        do{
            var mensagemDescricao = "\nDigite a descrição da ferramenta: ";
            var descricaoFerramenta = atribuirString(mensagemDescricao);
            var mensagemPreco = "\nDigite o preco da ferramenta: ";
            var precoFerramenta = atribuirDouble(mensagemPreco);
            var mensagemQuantidadeFerramenta = "\nDigite a quantidade de ferramentas a ser colocada no estoque: ";
            var quantidadeFerramentas = atribuirInt(mensagemQuantidadeFerramenta);
            novoRegistro = new Registro(new Ferramenta(descricaoFerramenta, precoFerramenta), quantidadeFerramentas);
        }while(!estoque.adicionarRegistro(novoRegistro));
        return true;
    }
    private static void removerRegistro(Estoque estoque) {
        Registro registro;
        do{
            registro = procurarRegistro(estoque);
        }while(!estoque.removerRegistro(registro.getId()));
        }
    private static void printarRegistro(Registro registroAuxiliar) {
        System.out.println("\nRegistro: " + registroAuxiliar.getId()
                         + "\nFerramenta: " + registroAuxiliar.getFerramenta().getDescricao()
                         + "\nPreço: " + registroAuxiliar.getFerramenta().getPreco()
                         + "\nQuantidade em estoque: " + registroAuxiliar.getQuantidadeFerramentas());
    }
    private static void printarTodosRegistros(Estoque estoque) {
        estoque.getRegistros().forEach(registroAuxiliar ->
        {
            printarRegistro(registroAuxiliar);
        });
    }
    private static Registro procurarRegistro(Estoque estoque){
        Registro registroProcurada;
        var mensagemPrintarTudo = "\nDeseja visualizar todos os registros: "
                                + "\n(1). Sim"
                                + "\n(0). Não"
                                + "\nOpção desejada: ";
        var opcaoVisualisarTudo = atribuirInt(mensagemPrintarTudo);
        if(opcaoVisualisarTudo == 1) printarTodosRegistros(estoque);
        do{
            var mensagemIdRegistro = "\nDigite o id do registro: ";
            var idRegistro = atribuirInt(mensagemIdRegistro);
            registroProcurada = estoque.procurarRegistro(idRegistro);
        }while(registroProcurada == null);
        return registroProcurada;
    }
    private static void encerraPrograma() {
        System.out.println("\nPrograma Encerrado!\n");
    }
}




















