import java.util.*; // Importa estruturas de dados 

public class Main {
    public static void main(String[] args) {
        // Os processos entram em uma fila ordenada FIFO (First-In, First-Out) 
        Queue<Processo> fila = new LinkedList<>();

        // Adiciona processos na fila com seus respectivos tempos 
        fila.add(new Processo("P1", 10)); // Processo com 10 unidades 
        fila.add(new Processo("P2", 5));  // Processo com 5 unidades 
        fila.add(new Processo("P3", 8));  // Processo com 8 unidades 

        /* Criacao da variavel quantum. O Sistema Operacional define um tempo de CPU rigorosamente fixo e igual para todos para evitar que um processo longo monopolize a maquina (starvation) e garantir que tarefas interativas (como o clique do mouse) continuem responsivas.
        */

        int quantum = 3;    
        int tempoAtual = 0; // Tempo total decorrido 

        System.out.println("Execucao Round Robin: \n");

        /*Durante o escalonamento, o processo utiliza o processador por um tempo limitado.Tempo definido em:
        
        int quantum = 3;
        
         Se ele nao terminar antes do fim do Quantum, o sistema operacional o retira da CPU e o coloca novamente no final da fila, garantindo que outros processos tambem tenham a chance de rodar.
         */

        // Enquanto houver processos na fila
        while (!fila.isEmpty()) {
            Processo p = fila.poll(); // Remove o primeiro da fila
            System.out.println("Executando " + p.nome); 

            // Caso o processo ainda precise de mais tempo que o quantum 
            if (p.tempoRestante > quantum) {

                // O processo executa apenas pelo tempo do quantum
                tempoAtual += quantum;          // Soma o tempo executado 

                // Atualiza o tempo restante de CPU do processo
                p.tempoRestante -= quantum;      
                
                System.out.println(p.nome + " executou por " + quantum + " unidades"); 
                System.out.println("Tempo restante: " + p.tempoRestante + "\n"); 
                
                fila.add(p); // Volta para o final da fila 
            } else {

                // O processo termina sua execucao antes ou exatamente no fim do quantum 
                tempoAtual += p.tempoRestante; 

                // Nao ha mais trabalho restante
                p.tempoRestante = 0;
                
                System.out.println(p.nome + " finalizado!"); 
                System.out.println("Tempo total até agora: " + tempoAtual + "\n"); 
            }
        }
    }
}