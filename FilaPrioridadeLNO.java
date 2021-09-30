public class FilaPrioridadeLNO { //Fila não ordenada

    private No primeiro;
    private No ultimo;
    private int contador;


    public FilaPrioridadeLNO() {
        primeiro = null;
        ultimo = null;
        contador = 0;
    }

    public void enQueue(Object valor, int prioridade){ //  add
        No novo = new No(valor, prioridade);

        if(primeiro == null){  //  Lista vazia?
            primeiro = novo;
            ultimo = novo;
        } else{
            ultimo.proximo = novo;  //  Referenciando o novo nó no anterior
            novo.anterior = ultimo;
            ultimo = novo;
        }

        contador++;
    }

    public void deQueue() throws Exception { //  remove
        if (primeiro == null) {
            throw new Exception("Vetor vazio ou posição inválida");
        } else {
            No aux=front();

            if (aux.anterior != null)
                aux.anterior.proximo=aux.proximo;
            else
                primeiro=primeiro.proximo;

            if (aux.proximo != null)
                aux.proximo.anterior=aux.anterior;
            else
                ultimo=ultimo.anterior;

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

    public No front(){ //  Pesquisar quem é o proximo da fila baseado na prioriedade
        if(primeiro != null) {
            for (int i=0; i <= 2; i++) {
                No aux=primeiro;

                while (aux != null) {
                    if (aux.prioridade == i)
                        return aux;
    
                    aux=aux.proximo;
                }
            }
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
            aux = aux.proximo;                       //  Atualizando referencia para o proximo nó
        }

        System.out.println();
    }
}
