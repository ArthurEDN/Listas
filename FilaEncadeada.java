public class FilaEncadeada { //Simplesmente encadeada

    private No primeiro;
    private No ultimo;
    private int contador;


    public FilaEncadeada() {
        primeiro = null;
        ultimo = null;
        contador = 0;
    }

    public void enQueue(Object valor){ //  add
        No novo = new No(valor);

        if(primeiro == null){  //  Lista vazia?
            primeiro = novo;
            ultimo = novo;
        } else{
            ultimo.proximo = novo;        //  Referenciando o novo nó no anterior
            ultimo = novo;
        }

        contador++;
    }


    public void deQueue() throws Exception { //  remove
        if (primeiro == null) {
            throw new Exception("Vetor vazio ou posição inválida");
        }
            primeiro = primeiro.proximo; //Referenciando o segundo nó
            contador--;
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

    public boolean isEmpty(){
        return contador == 0;
    }

    public Object front(){ //ou peek
        return primeiro.dado;
    }

    public int size(){   //Size
        return contador;
    }

    public void clear() {
        primeiro = null;
        ultimo = null;
        contador = 0;
    }

    public void exibir(){
        No aux = primeiro;

        while(aux != null) {
            System.out.println(aux.dado + " ");
            aux = aux.proximo;                       //  Atualizando referencia para o proximo nó
        }

        System.out.println();
    }
}
