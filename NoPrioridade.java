public class NoPrioridade {

    public Object dado;
    public int prioridade;
    public No anterior;
    public No proximo;

    //Estruturas de prioridade
    public NoPrioridade(Object dado, int prioridade){
        this.dado = dado;
        this.prioridade = prioridade;
        this.anterior = null;
        this.proximo = null;
    }
}
