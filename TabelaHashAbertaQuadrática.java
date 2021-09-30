public class TabelaHashAbertaQuadrática {
    private Integer tabela [];

    public TabelaHashAbertaQuadrática(Integer n){
        tabela = new Integer[n];
    }

    public int h(int valor){
        int indice = valor % tabela.length;
        int i = 0;

        //Tentativa de Hash Quadrática
        while(tabela[indice] != null){
            i++;
            indice = (indice + i) % tabela.length;
        }

        return indice;
    }

    public void adicionar(int valor){
        int indice = h(valor);

        tabela[indice] = valor;
    }

    public void remover(int valor){
        int indice = pesquisar(valor);

        if(indice != -1)
            tabela[indice] = null;
         else
            System.out.println("Não existe na tabela!");

    }

    public int pesquisar(int valor) {
        int indice = valor % tabela.length;
        int i = 0;

        while (tabela[indice] != null) {
            if (tabela[indice] == valor)
                return indice;

            i++;
            indice = (indice + i) % tabela.length;
        }

        return -1;
    }

    public boolean contem (int valor) {
        int indice = valor % tabela.length;
        int i = 0;

        while (tabela[indice] != null) {
            if (tabela[indice] == valor)
                return true;

            i++;
            indice = (indice + i) % tabela.length;
        }

        return false;
    }

    public void clear(){
        for (Integer integer : tabela){
            tabela = null;
        }
    }

    public void exibir(){
        for (Integer integer : tabela) System.out.println(integer);

        System.out.println();
    }

}
