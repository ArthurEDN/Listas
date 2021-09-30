public class PilhaEstatica {
    private Object v[];
    private int contador;

    public PilhaEstatica(){
        v  = new Object [10];
        contador = 0;
    }

    public PilhaEstatica(int n){
        v = new Object[n];
        contador = 0;
    }

    public void push(Object valor) throws Exception { //add
        if(contador != v.length ){
            v[contador] = valor;
            contador++;

        } else{
            throw new Exception("Vetor cheio");
        }
    }

    public void pop() throws Exception { //remove
        if(contador > 0) {
            contador--;
        } else{
            throw new Exception("Não há valor nessa posição");
        }
    }

    public boolean search(Object valor){ //Contains
        for(int i = 0; i < contador; i++){
            if(v[i].equals(valor)) {
                return true;
            }
        }

        return false;
    }

    public Object peek() {
        return v[contador - 1];
    }

    public int size(){   //Size
        return contador;
    }

    public void clear() {
        contador = 0;
    }

    public boolean isEmpty() {
        return contador == 0;
    }
    
    public void exibir(){
        for(int i = 0; i < contador; i++){
            System.out.println(v[i] + " ");
        }
        System.out.println();
    }

}
