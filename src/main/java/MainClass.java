import static java.lang.Thread.*;

/*
 * Classe Main para mostrar as irformações do oshi provisoriamente.
 *
 * Quando o projeto com o front Swing for contruido, referencie esse projeto
 * com o Maven para usar as classes:
 * -> PcInfo(Informações para cadastro de computador no sistema)
 * -> PcLeitura(Informações para leitura de dados do sistema operacional e componentes)
 *
 * Projeto ainda em Alfa, visando necessidades básicas sem se importar com processos individuais
 * do SO, dados de internet, GPU, entre outros.
 */

/**
 * @author Vinicius da Silva Ruiz
 * @date   14/04/2019
 */
public class MainClass {
    public static void main(String[] args) throws InterruptedException {
        PcInfo info = new PcInfo();
        PcLeitura data = new PcLeitura();

        System.out.println(info);

        System.out.println();

        while (true) {
            System.out.println(data);
            sleep(3000);
        }
    }
}
