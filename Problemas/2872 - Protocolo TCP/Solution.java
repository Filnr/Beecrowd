import java.util.*;

public class Solution {

    public static void ordena(int[] pacotes, int n) {
        quickSort(0, n - 1, pacotes);
    }

    public static void quickSort(int esq, int dir, int[] pacotes) {
        if (esq < dir) {
            int indexPivo = particionar(pacotes, esq, dir);
            quickSort(esq, (indexPivo - 1), pacotes);
            quickSort((indexPivo + 1), dir, pacotes);
        }
    }

    public static void swap(int[] pacotes, int x, int y) {
        int tmp = pacotes[x];
        pacotes[x] = pacotes[y];
        pacotes[y] = tmp;
    }

    public static int particionar(int[] pacotes, int esq, int dir) {
        int index = (esq + dir) / 2;
        int pivo = pacotes[index];
        int i = (esq - 1);
        swap(pacotes, index, dir);
        for (int j = esq; j < dir; j++) {
            if (pacotes[j] <= pivo) {
                i++;
                swap(pacotes, i, j);
            }
        }
        swap(pacotes, i + 1, dir);
        return i + 1;
    }

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int iniciar = Integer.parseInt(ler.nextLine());
        String linha;
        while (iniciar == 1 && ler.hasNext()) {
            int[] pacotes = new int[500];
            int n = 0;
            while (!(linha = ler.nextLine()).equals("0")) {
                String[] partes = linha.split(" ");
                pacotes[n++] = Integer.parseInt(partes[1]);
            }
            ordena(pacotes, n);
            for (int i = 0; i < n; i++) {
                if (pacotes[i] < 10) {
                    System.out.printf("Package 00%d\n", pacotes[i]);
                } else if (pacotes[i] < 100) {
                    System.out.printf("Package 0%d\n", pacotes[i]);
                } else {
                    System.out.printf("Package %d\n", pacotes[i]);
                }
            }
            System.out.println("");
            if (ler.hasNext()) {
                iniciar = Integer.parseInt(ler.nextLine());
            }
        }
        ler.close();
    }
}