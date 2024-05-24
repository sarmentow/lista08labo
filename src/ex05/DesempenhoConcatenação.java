package ex05;

/*
 * A razão pela qual a concatenação com StringBuffer é mais rápida do que com String é que String é imutável, 
 * ou seja, cada vez que você concatena uma string com outro valor, um novo objeto String precisa ser criado,
 * o que implica alocação de memória, um processo lento. Não só isso, o acúmulo de antigas strings causa uma
 * maior atividade do coletor de lixo, que também piora o desempenho.
 * 
 */

public class DesempenhoConcatenação {
    public static void main(String[] args) {
        int iterations = 100000;

        // Concatenação com String
        long startTime = System.currentTimeMillis();
        String str = "";
        for (int i = 0; i < iterations; i++) {
            str += "abc";
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Tempo de concatenação com String: " + (endTime - startTime) + " ms");

        // Concatenação com StringBuffer
        startTime = System.currentTimeMillis();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sb.append("abc");
        }
        endTime = System.currentTimeMillis();
        System.out.println("Tempo de concatenação com StringBuffer: " + (endTime - startTime) + " ms");
    }
}