import static java.lang.Thread.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aluno
 */
public class MainClass {
    public static void main(String[] args) throws InterruptedException {
        PcLeitura i = new PcLeitura();

       // System.out.println(i.getFans());

        while (true) {
            System.out.println(i);
            sleep(1000);
        }
    }
}
