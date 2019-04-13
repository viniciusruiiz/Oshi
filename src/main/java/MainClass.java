
import oshi.util.FormatUtil;

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
    public static void main(String[] args) {
        PcInfo i = new PcInfo();
    
        System.out.println(i.getModeloDoComputador());
    }
}
