
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
//        //Objeto para leitura dos dados
//        Scanner leitor = new Scanner(System.in);
//
//        // Entrada do intervalo
//        System.out.print("Digite o valor inicial: ");
//        int inicio = leitor.nextInt();
//
//        System.out.print("Digite o valor final: ");
//        int fim = leitor.nextInt();
//
//        System.out.print("Digite o número de intervalos: ");
//        int n = leitor.nextInt();
                
        long inicio = 1;  // Valor inicial do intervalo
        long fim = 500000000;     // 500 milhões. Valor final do intervalo
        long n = 4;        // Número de sub-intervalos
        
        System.out.println("Números primos do intervalo " + inicio + " e " + fim + ":");
        //Dividindo o intervalo em dois segmentos.
        
        long tamanho = (fim - inicio + 1);      // Quantidade de números no intervalo
        long passo = tamanho / n;               // Tamanho base de cada sub-intervalo
        long resto = tamanho % n;               // Ajuste se não dividir exato
        long atual = inicio;                    // Início do primeiro sub-inervalo
        for (long i = 1; i <= n; i++) {
            long extra = (i <= resto) ? 1 : 0;  // Distribui o "resto" entre os primeiros intervalos
            long fimIntervalo = atual + passo + extra - 1;

            System.out.println("Sub-intervalo " + i + ": [" + atual + ", " + fimIntervalo + "]");

            //Inicializando o objeto que calcula os primos
            CalculaPrimo cp = new CalculaPrimo(atual, fimIntervalo);
            
            //Executando as threads
            Thread t = new Thread(cp);        
            t.start();
            
            //Avança para o próximo intervalo
            atual = fimIntervalo + 1;
        }
    }
}
