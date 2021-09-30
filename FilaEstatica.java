public class FilaEstatica {
    private Object v[];
    private int inicio;
    private int fim;

    public FilaEstatica(){
        v  = new Object [10];
        inicio = 0;
        fim = -1;
    }

    public FilaEstatica(int n){
        v = new Object[n];
        inicio = 0;
        fim= 0;
    }

    public void enQueue(Object valor) throws Exception { //add
        if(size() < v.length ){
            fim++;

            if(fim == v.length){
                fim = 0;
            }

            v[fim] = valor;
        } else{
            throw new Exception("Vetor cheio");
        }
    }

    public void deQueue() throws Exception { //remove
        if(size() > 0) {
            inicio++;
        } else{
            throw new Exception("Não há valor nessa posição");
        }
    }

    public boolean search (Object valor){ //Contains
        for(int i = inicio; i <= fim; i++){
            if(v[i].equals(valor)) {
                return true;
            }
        }
        return false;
    }

    public Object front(){
        return v[inicio];
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public int size(){ //Size
        if(fim >= inicio) {
            return fim - inicio + 1;
        } else {
            if(fim != -1){
                return v.length + (fim - inicio + 1);
            } else {
                return 0;
            }
        }
    }

    public  void clear(){
        inicio = 0;
        fim = -1;
    }

    public void exibir(){
        if(fim >= inicio) {
            for (int i=inicio; i <= fim; i++) {
                System.out.println(v[i] + " ");
            }
        }else{
            for (int i = inicio; i < v.length - 1; i++) {
                System.out.println(v[i] + " ");
            }

            for(int i = 0; i <= fim; i++){
                System.out.println(v[i] + " ");
            }
        }
        System.out.println();
    }
}
