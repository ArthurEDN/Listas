public class HeapMax {
    private int[] dados;
    private int contador;

    public HeapMax(int n) {
        dados = new int[n];
        contador = 0;
    }

    public void inQueue(int valor) {
        if (contador == dados.length)
            throw new RuntimeException("Heap lotado");

        dados[contador] = valor;
        contador++;
        subir(contador - 1);
    }

    public void deQueue() {
        if (vazio())
            throw new RuntimeException("Heap vazio");

        dados[0] = dados[contador - 1];
        contador--;
        if (contador > 0)
            descer(0);
    }

    private void subir(int indice) { // Compara os valores pais e filhos para trocar as posições caso necessário
        int indicePai, temp;

        if (indice != 0) {
            indicePai = (indice - 1) / 2;

            if (dados[indicePai] < dados[indice]) {
                temp = dados[indicePai];
                dados[indicePai] = dados[indice];
                dados[indice] = temp;
                subir(indicePai);
            }
        }
    }

    private void descer(int indice) { // Compara os valores pais e filhos para trocar as posições caso necessário
        int indiceFilhoEsq, indiceFilhoDir, indiceMax, temp;

        indiceFilhoEsq = 2 * indice + 1;
        indiceFilhoDir = 2 * indice + 2;

        if (indiceFilhoDir >= contador) {
            if (indiceFilhoEsq >= contador)
                return;
            else
                indiceMax = indiceFilhoEsq;
        } else {
            if (dados[indiceFilhoEsq] >= dados[indiceFilhoDir])
                indiceMax = indiceFilhoEsq;
            else
                indiceMax = indiceFilhoDir;
        }

        if (dados[indice] < dados[indiceMax]) {
            temp = dados[indiceMax];
            dados[indiceMax] = dados[indice];
            dados[indice] = temp;
            descer(indiceMax);
        }
    }

    public int front() { // O valor na posição inicial do vetor, sempre será o maior
        if (vazio())
            throw new RuntimeException("Heap vazio");
        else
            return dados[0];
    }

    public boolean vazio() {
        return (contador == 0);
    }

    public void exibir() {
        for (int i = 0; i < contador; i++)
            System.out.print(dados[i] + " ");

        System.out.println();
    }

}