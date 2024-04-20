/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.unipar.trabalho_estrutura_de_dados;


import javax.swing.JOptionPane;
import java.util.Arrays;

public class Trabalho_ESTRUTURA_DE_DADOS {

    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog("Informe o tamanho do vetor N:");
        int tamanhoVetor = Integer.parseInt(input);
        int[] vetor = new int[tamanhoVetor];

        for (int i = 0; i < tamanhoVetor; i++) {
            vetor[i] = Integer.parseInt(JOptionPane.showInputDialog("Insira o elemento " + (i + 1) + " do vetor:"));
        }

        JOptionPane.showMessageDialog(null, "Vetor original: " + Arrays.toString(vetor));

        Object[] opcoes = {"Ordenação por Inserção", "Ordenação por Seleção", "Ordenação Bolha"};
        int metodos = JOptionPane.showOptionDialog(null, "Escolha o método de ordenação:",
                "Método de Ordenação", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);

        long startTime = System.nanoTime();
        if (metodos == 0) {
            ordenacaoPorInsercao(vetor);
        } else if (metodos == 1) {
            ordenacaoPorSelecao(vetor);
        } else if (metodos == 2) {
            ordenacaoBolha(vetor);
        } else {
            JOptionPane.showMessageDialog(null, "Opção inválida!");
            return;
        }
        long endTime = System.nanoTime();

        JOptionPane.showMessageDialog(null, "Vetor ordenado: " + Arrays.toString(vetor));
        JOptionPane.showMessageDialog(null, "Tempo de execução: " + (endTime - startTime) + " nanosegundos");
    }

    public static void ordenacaoPorInsercao(int[] vetor) {
        for (int i = 1; i < vetor.length; i++) {
            int atual = vetor[i];
            int j = i - 1;
            while (j >= 0 && vetor[j] > atual) {
                vetor[j + 1] = vetor[j];
                j--;
            }
            vetor[j + 1] = atual;
        }
    }

    public static void ordenacaoPorSelecao(int[] vetor) {
        for (int i = 0; i < vetor.length - 1; i++) {
            int chave = i;
            for (int j = i + 1; j < vetor.length; j++) {
                if (vetor[j] < vetor[chave]) {
                    chave = j;
                }
            }
            int temp = vetor[chave];
            vetor[chave] = vetor[i];
            vetor[i] = temp;
        }
    }

    public static void ordenacaoBolha(int[] vetor) {
        boolean trocou;
        do {
            trocou = false;
            for (int i = 0; i < vetor.length - 1; i++) {
                if (vetor[i] > vetor[i + 1]) {
                    int temp = vetor[i];
                    vetor[i] = vetor[i + 1];
                    vetor[i + 1] = temp;
                    trocou = true;
                }
            }
        } while (trocou);
    }
}

