public class PilhaEncadeada { //Simplesmente encadeada

    private No primeiro;
    private No ultimo;
    private int contador;


    public PilhaEncadeada() {
        primeiro = null;
        ultimo = null;
        contador= 0;
    }

    public void push(Object valor){ //  add
        No novo = new No(valor);

        if(primeiro == null){  //  Lista vazia?
            primeiro = novo;
            ultimo = novo;
        } else{
            ultimo.proximo = novo;        //  Referenciando o novo nó no anterior
            novo.anterior = ultimo;
            ultimo = novo;
        }
        contador++;
    }

    public void remover() throws Exception { //  remove
        if (primeiro == null) {
            throw new Exception("Vetor vazio ou posição inválida");
        } else {
            No aux=primeiro;

            while (aux.proximo.proximo != null) {
                aux=aux.proximo;
            }

            aux.proximo=null;
            ultimo = aux;
        }
    }

    public boolean search(Object valor){ //  Contains
        No aux = primeiro;

        while(aux != null){
            if(aux.dado.equals(valor))
                return true;

            aux = aux.proximo;
        }

        return false;
    }

    public Object peek() {
        return ultimo.dado;
    }

    public int size(){   //Size
        return contador;
    }

    public void clear() {
        primeiro = null;
        ultimo = null;
        contador = 0;
    }

    public boolean isEmpty() {
        return contador == 0;
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
