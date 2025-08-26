
public class CalculaPrimo implements Runnable{

    private long i;
    private long f;
    
    /**
     * Construtor com  parâmetros.
     * Inicializa os valores iniciais e finais do intervalo.
     * @param i Valor de início do intervalo.
     * @param f Valor de fim do intervalo.
     */
    public CalculaPrimo(long i, long f){
        this.i = i;
        this.f = f;
    }
    
    /**
     * Verifica se um número é primo.
     * @param n Número a ser verificado.
     * @return true se o número é primo caso contrário false.
     */
    public boolean ehPrimo(long n) {

        // Números menores que 2 não são primos.
        // 0 e 1 não são primos.
        if (n < 2) {
            return false;
        }
        // O número 2 é primo (e é o único primo par).
        // Todo número par maior que 2 não é primo.
        if (n == 2) {
            return true;
        }
        // Pares maiores que 2 não são primos
        if (n % 2 == 0) {
            return false;
        }
        // Verifica divisores de 3 até sqrt(n), apenas ímpares                                               
        // Se for divisível por qualquer um deles, não é primo.
        // Se não for divisível, então é primo.
        // Se um número n não é primo, então ele pode ser escrito como um produto:
        //                    𝑛 = 𝑎 × 𝑏
        // Se ambos 𝑎 e 𝑏 fossem maiores que sqrt(𝑛), o produto seria maior que 𝑛.
        // Se ambos fossem menores que 𝑛, o produto seria menor que 𝑛.
        // Portanto, sempre existe pelo menos um divisor ≤ srqt(𝑛).
        long limite = (long) Math.sqrt(n);
        for (int i = 3; i <= limite; i += 2) {
            if (n % i == 0) {
                return false; // encontrou divisor → não é primo
            }
        }
        return true; // não encontrou divisor → é primo
    }

    /**
     * Método que verifica e imprime os números primos entre inicio e fim
     * @param inicio Valor de início do intervalo.
     * @param fim Valor de fim do intervalo.
     */
    public void exibirPrimos(long inicio, long fim) {
        for (long i = inicio; i <= fim; i++) {
            //Verifica se o número é primo
            if (ehPrimo(i)) {
                //System.out.println(i);
            }
        }
    }
    
    @Override
    public void run(){
        exibirPrimos(i, f);
        System.out.println("Terminei de calcular e mostrar os primos do sub-intervalo de " + i + " até " + f);
    }
}
