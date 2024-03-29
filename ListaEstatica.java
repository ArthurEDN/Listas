public class ListaEstatica {
    private Object v[];
    private int contador;

    public ListaEstatica(){
        v  = new Object [10];
        contador = 0;
    }

    public ListaEstatica(int n){
        v = new Object[n];
        contador = 0;
    }

    public void adicionar(Object valor) throws Exception { //add
        if(contador != v.length ){
            v[contador] = valor;
            contador++;

        } else{
           throw new Exception("Vetor cheio");
        }
    }

    public void adicionar(int posicao, Object valor) throws Exception { //add
        if(contador != v.length){
            if(posicao <= contador){
                for(int i = contador; i > posicao; i--){
                    v[i] = v[i-1];
                }

                v[posicao] = valor;
                contador++;

            } else{
                throw new Exception("Posição inválida");
            }
        }else {
            throw new Exception("Vetor cheio");
        }
    }

    public void remover(int posicao) throws Exception { //remove
        if(posicao < contador) {
            for (int i = posicao; i < contador - 1; i++) {
                v[i] = v[i + 1];
            }
            contador--;

        } else{
            throw new Exception("Não há valor nessa posição");
        }
    }

    public boolean pesquisar(Object valor){ //Contains
       for(int i = 0; i < contador; i++){
           if(v[i].equals(valor)) {
               return true;
           }
        }
           return false;
    }

    public int pesquisarIndice(Object valor) throws Exception { // indexOf
        for(int i = 0; i < contador; i++){
            if(v[i].equals(valor)){
                return i;
            }
        }
        return -1;
    }

    public Object pesquisarElemento(int posicao) {  ///Get
        if(posicao < contador) {
            return v[posicao];
        } else{
            return null;
        }
    }

    public int tamanho(){ //Size
        return contador;
    }

    public void clear() {
        contador = 0;
    }

    public boolean vazio(){
        return contador == 0;
    }

    public void exibir(){
        for(int i = 0; i < contador; i++){
            System.out.println(v[i] + " ");
        }
        System.out.println();
    }
}
