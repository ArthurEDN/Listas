public class ArvoreBinariaDeBusca { //Arvore Binária de busca(um tipo de implementação de arvore)
    private NoArvore raiz;

    public ArvoreBinariaDeBusca(){
        raiz = null;
    }

    //Os filhos esquerdos serão menores que o pais e os filhos direitos serão maiores que os pais
    public void adicionar(int elemento){
        if(vazia()){
           raiz = new NoArvore(elemento);
        } else {
            adicionar(elemento,raiz);
        }
    }

    private void adicionar(int elemento, NoArvore raiz){
        if(elemento < raiz.dado){
            if(raiz.esquerdo == null) {
                raiz.esquerdo = new NoArvore(elemento);
            } else {
                adicionar(elemento, raiz.esquerdo);
            }
        } else if(elemento > raiz.dado) {
            if(raiz.direito == null) {
                raiz.direito = new NoArvore(elemento);
            } else {
                adicionar(elemento, raiz.direito);
            }
        }
    }

    public void remover(int elemento){
        if(!vazia()){
            remover(elemento, raiz, null);
        } else {
            System.out.println("Árvore vazia");
        }
    }

    private void remover(int elemento, NoArvore raiz, NoArvore pai) {
        if(raiz.direito == null && raiz.esquerdo == null && pai == null){
            raiz = null;
        } else {
            if (elemento == raiz.dado) {
                if (raiz.esquerdo == null && raiz.direito == null) {// Não tem filhos(folha)
                    if (raiz == pai.esquerdo) { //Filho esquerdo
                        pai.esquerdo=null;
                    } else {                 //Filho direito
                        pai.direito=null;
                    }
                } else if (raiz.esquerdo != null && raiz.direito == null) {// tem apenas um filho(esquerdo)
                    if (raiz == pai.esquerdo) { //Filho esquerdo
                        pai.esquerdo=raiz.esquerdo;
                    } else {                 //Filho direito
                        pai.direito=raiz.esquerdo;
                    }
                } else if (raiz.esquerdo == null && raiz.direito != null) {// tem apenas um filho(direito)
                    if (raiz == pai.esquerdo) { //Filho esquerdo
                        pai.esquerdo=raiz.direito;
                    } else {                     //Filho direito
                        pai.direito=raiz.direito;
                    }
                } else if (raiz.esquerdo != null && raiz.direito != null) {// tem dois filhos
                    raiz.dado=ElementoMin(raiz.direito); // encontrando o menor valor da sub-arvore direita e setando no pai removido
                    remover(raiz.dado, raiz.direito, raiz); // eliminando a duplicata

                    //raiz.dado = ElementoMax(raiz.esquerdo); // encontrando o maior valor da sub-arvore esquerda e setando no pai removido
                }
            } else if (elemento < raiz.dado) {
                if (raiz.esquerdo != null) {
                    remover(elemento, raiz.esquerdo, raiz);
                }
            } else if (elemento > raiz.dado) {
                if (raiz.direito != null) {
                    remover(elemento, raiz.direito, raiz);
                }
            }
        }
    }

    public boolean contem(int elemento){
        if(vazia()){
            return false;

        } else {
           return contem(elemento, raiz);
        }
    }

    private boolean contem(int elemento, NoArvore raiz) {
        if (elemento == raiz.dado) {
            return true;
        } else if (elemento < raiz.dado) {
            if (raiz.esquerdo == null) {
                return false;
            } else {
                return contem(elemento, raiz.esquerdo);
            }
        } else if (elemento > raiz.dado) {
            if (raiz.direito == null) {
                return false;
            } else {
                return contem(elemento, raiz.direito);
            }
        }

        return false;
    }

    public int pesquisar(int elemento){
        if(vazia()){
           return -1;
        } else {
            return pesquisar(elemento, raiz);
        }
    }

    private int pesquisar (int elemento, NoArvore raiz) {
        if (elemento == raiz.dado) {
            return raiz.dado;
        } else if (elemento < raiz.dado) {
            if (raiz.esquerdo == null) {
                return -1;
            } else {
                return pesquisar(elemento, raiz.esquerdo);
            }
        } else if (elemento > raiz.dado) {
            if (raiz.direito == null) {
                return -1;
            } else {
                return pesquisar(elemento, raiz.direito);
            }
        }

        return -1;
    }

    public int ElementoMin(NoArvore raiz){ //Trazendo o menor valor na sub-arvore da raiz passada no parâmetro
        if(raiz.esquerdo == null) {
            return raiz.dado;
        } else {
            return ElementoMin(raiz.esquerdo);
        }
    }

    public int ElementoMax(NoArvore raiz){ //Trazendo o maior valor na sub-arvore da raiz passada no parâmetro
        if(raiz.direito == null) {
            return raiz.dado;
        } else {
            return ElementoMax(raiz.direito);
        }
    }

    public boolean vazia(){
        return raiz == null;
    }

    public void clear(){
        raiz = null;
    }

    public int altura(){
        return altura(raiz);
    }

    public int altura(NoArvore raiz){
        if(raiz != null){
            int esquerdo = altura(raiz.esquerdo);
            int direito = altura(raiz.direito);

            if(esquerdo > direito){
                return esquerdo + 1;
            } else {
                return direito + 1;
            }
        } else {
            return 0;
        }
    }

    //O exibir ser Implementado como Pré-ordem, Em ordem e Pós-ordem, Em nível
    public void exibirPre(){ // Pré-ordem
        exibirPre(raiz);
        System.out.println();
    }

    private void exibirPre(NoArvore raiz) { //Pré-ordem

        System.out.print(raiz.dado + " "); //Imprimi o nó visitado

        if(raiz.esquerdo != null){ //Visita nós a esquerda
            exibirPre(raiz.esquerdo);
        }

        if(raiz.direito != null){ //Visita nós a direita
            exibirPre(raiz.direito);
        }

    }

    public void exibirOrdem(){ //Em ordem
        exibirOrdem(raiz);
        System.out.println();
    }

    private void exibirOrdem(NoArvore raiz){

        if(raiz.esquerdo != null){ //Visita nós a esquerda
            exibirOrdem(raiz.esquerdo);
        }

        System.out.print(raiz.dado + " "); //Imprimi o nó visitado

        if(raiz.direito != null){ //Visita nós a direita
            exibirOrdem(raiz.direito);
        }

    }

    public void exibirPos(){
        exibirPos(raiz);
        System.out.println();
    }

    private void exibirPos(NoArvore raiz){
        if(raiz.esquerdo != null){ //Visita nós a esquerda
            exibirPos(raiz.esquerdo);
        }

        if(raiz.direito != null){ //Visita nós a direita
            exibirPos(raiz.direito);
        }

        System.out.print(raiz.dado + " "); //Imprimi o nó visitado
    }

}
