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

        if(isEmpty()){  //  Lista vazia?
            primeiro = novo;
            ultimo = novo;
        } else{
            ultimo.proximo = novo;        //  Referenciando o novo nó no anterior
            ultimo = novo;
        }
        contador++;
    }

    public void pop() throws Exception { //  remove
        if (isEmpty()) {
            throw new Exception("Vetor vazio ou posição inválida");
        }else {
            if(primeiro == ultimo){
                clear();
            } else {
                No aux=primeiro;

                while (aux.proximo != ultimo) {
                    aux=aux.proximo;
                }

                aux.proximo=null;
                ultimo=aux;

                contador--;
            }
        }
    }

    public boolean contains(Object valor){
        No aux = primeiro;

        while(aux != null){
            if(aux.dado.equals(valor))
                return true;

            aux = aux.proximo;
        }

        return false;
    }

    public Object peek() {
        if(isEmpty()){
            return null;
        }
        return ultimo.dado;
    }

    public int size(){
        return contador;
    }

    public void clear() {
        primeiro = null;
        ultimo = null;
        contador = 0;
    }

    public boolean isEmpty() {
        return primeiro == null;
    }

    public void exibir() {

        if (isEmpty()) {
            System.out.println("Pilha vazia");
        } else {

            No aux=primeiro;

            while (aux != null) {
                System.out.print(aux.dado + " ");
                aux=aux.proximo;                       //  Atualizando referencia para o proximo nó
            }

            System.out.println();
        }
    }
}

/*
public class PilhaEncadeada { //Simplesmente encadeada e trabalhando com a extremidade do ínicio

    private No primeiro;
    private int contador;


    public PilhaEncadeada() {
        primeiro = null;
        contador= 0;
    }

    public void push(Object valor){ //  add
        No novo = new No(valor);

        if(isEmpty()){  //  Lista vazia?
            primeiro = novo;
        } else {
            novo.proximo = primeiro;
            primeiro = novo;
        }
        contador++;
    }

    public void pop() throws Exception { //  remove
        if (isEmpty()) {
            throw new Exception("Vetor vazio ou posição inválida");
        }else{
            primeiro = primeiro.proximo;
            contador--;
        }
    }

    public boolean contains(Object valor){ 
        No aux = primeiro;

        while(aux != null){
            if(aux.dado.equals(valor))
                return true;

            aux = aux.proximo;
        }

        return false;
    }

    public Object peek() {
        if(isEmpty()){
            return null;
        }
        return primeiro.dado;
    }

    public int size(){   
        return contador;
    }

    public void clear() {
        primeiro = null;
        contador = 0;
    }

    public boolean isEmpty() {
        return primeiro == null;
    }

    public void exibir() {

        if (isEmpty()) {
            System.out.println("Pilha vazia");
        } else {

            No aux=primeiro;

            while (aux != null) {
                System.out.print(aux.dado + " ");
                aux=aux.proximo;                       //  Atualizando referencia para o proximo nó
            }

            System.out.println();
        }
    }
}

 */
