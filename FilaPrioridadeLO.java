public class FilaPrioridadeLO { //Fila Ordenada

    private No primeiro;
    private No ultimo;
    private int contador;


    public FilaPrioridadeLO() {
        primeiro = null;
        ultimo = null;
        contador= 0;
    }

    public void enQueue(Object valor, int prioridade){ //  add
        No novo = new No(valor, prioridade);

        if(primeiro == null){  //  Lista vazia?
            primeiro = novo;
            ultimo = novo;
        } else if (novo.prioridade < primeiro.prioridade){
            novo.proximo = primeiro;
            primeiro.anterior = novo;
            primeiro = novo;
        } else if (novo.prioridade >= ultimo.prioridade){
            ultimo.proximo = novo;
            novo.anterior = ultimo;
            ultimo = novo;
        } else{
            No aux = primeiro;

            while(aux != null && novo.prioridade >= aux.prioridade){
                aux = aux.proximo;
            }

            novo.proximo = aux;
            novo.anterior = aux.anterior;
            aux.anterior = novo;
            novo.anterior.proximo = novo;
        }

        contador++;
    }

    public void deQueue() throws Exception { //  remove
        if (primeiro == null) {
            throw new Exception("Vetor vazio ou posição inválida");
        } else {

            primeiro=primeiro.proximo;

            contador--;
        }
    }

    public boolean search(Object valor){ //  Contains
        No aux = primeiro;

        while (aux != null){
            if(aux.dado.equals(valor)){
                return true;
            }

            aux = aux.proximo;
        }

        return false;
    }

    public No front(){ // Pesquisa quem é o proximo da fila baseado na prioriedade
        if(primeiro != null) {
            return primeiro;
        }
        return null;
    }

    public int size(){   //Size
        return contador;
    }

    public void clear() {
        primeiro = null;
        ultimo = null;
        contador = 0;
    }

    public boolean isEmpty(){
        return contador == 0;
    }

    public void exibir(){
        No aux = primeiro;

        while(aux != null) {
            System.out.println(aux.dado + "(" + aux.prioridade + ") ");
            aux = aux.proximo;  //  Atualizando referencia para o proximo nó
        }

        System.out.println();
    }

}
