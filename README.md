# Java-Process-Scheduling 

Simulação do algoritmo de escalonamento **Round Robin** desenvolvida para a disciplina de **Sistemas Operacionais**. 

### Sobre o Projeto
O código simula como um Sistema Operacional gerencia a execução de múltiplos processos utilizando o conceito de **Quantum** (fatia de tempo). O objetivo é demonstrar a alternância de tarefas e o controle do tempo restante de cada processo em uma fila.

> Este código foi fornecido pelo professor da disciplina como base para o estudo de escalonamento Round Robin (chaveamento circular) e alternância de contexto. Realizei apenas algumas adições de comentários no arquivo `Main.java`.

### Estrutura do Código

O projeto é composto por duas classes principais:

* ⚙️ `Processo.java` define os atributos do processo, como nome e tempo restante de execução.

* ☕ `Main.java` contém a lógica do escalonador, a criação da fila e o loop de execução.
  
### Rodando o código
Pelo terminal, dentro da pasta do projeto:

   ```bash
   javac Processo.java Main.java
   java Main
   ```
>Experimente alterar o valor da variável `quantum` no arquivo `Main.java` para observar como diferentes fatias de tempo afetam a eficiência do escalonamento.