import java.util.Random;

public class BobbleSortAula {
    static int trocas = 0;
    static int comparacoes = 0;
    static void troca (Integer[] v, int i, int j){
        int temp = v[i];
        v[i] = v[j];
        v[j] = temp;
    }

    static void flaggedBubbleSort(Integer v[]){
        boolean houveTroca = false;
        int n = v.length;
        for(int fase=1;fase<n;fase++){
            mostrarVetor(v);
            for(int j=0;j<n-fase;j++){
                System.out.printf("{%d}>{%d}\n", v[j], v[j+1]);
                comparacoes++;
                if(v[j]>v[j+1]){
                    trocas++;
                    troca(v, j,j+1);
                    mostrarVetor(v);
                    houveTroca = true;
                }
            }
            if(!houveTroca){
                break;
            }
        }
    }

    static Integer[] gerarVetor(int tamanho, int max){
            Random rand = new Random();
            Integer[] vetor = new Integer[tamanho];
            for(int i=0;i<tamanho;i++){
                vetor[i] = rand.nextInt(max)+1;
            }
            return vetor;
    }

    static void mostrarVetor(Integer[] v){
        int tamanho = v.length;
        for(int i=0;i<tamanho;i++){
            System.out.println(v[i]+"|");
        }
        System.out.println("");
    }

    public static void main(String[] args){
        Integer[] meuVetor = gerarVetor(10, 100);
        System.out.println("Vetor Gerado!");
        mostrarVetor(meuVetor);
        flaggedBubbleSort(meuVetor);

        // A ordenação vai aparentar visualmente, porque o bSort vai mexer no vetor original
        // A passagem sempre é por referência quando se trata de vetores
        System.out.println("Vetor Ordenado!");
        mostrarVetor(meuVetor);
        System.out.println("Trocas:" + trocas);
        System.out.println("Comparacoes:" + comparacoes);

    }
}
