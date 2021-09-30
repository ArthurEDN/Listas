public class TabelaHashComLista {
    private ListaEncadeada tabela []; //Pode ser usar outras estruturas aqui(Heap, árvore e etc.)

    public TabelaHashComLista(Integer n) {
       tabela = new ListaEncadeada[n];

       for(int i = 0; i < n;i++)
           tabela[i] = new ListaEncadeada();

    }

    public int h(int valor) {
        return valor % tabela.length;
    }

    public void adicionar(int valor) throws Exception {
        int indice = h(valor);
        tabela[indice].adicionar(0,valor);
    }

    public void remover(int valor) throws Exception {
        int indice = h(valor);
        tabela[indice].remover(indice);
    }

    public int pesquisarIndice(int valor) {
        int indice = h(valor);
        return tabela[indice].pesquisarIndice(valor);
    }

    public boolean pesquisar(int valor) {
        int indice = h(valor);
        return tabela[indice].pesquisar(valor);
    }

    public void exibir() {
        for (int i=0; i < tabela.length; i++) {
            if(tabela[i].vazio())
                System.out.println("Vazia");
            else
                tabela[i].exibir();
        }
    }

}
