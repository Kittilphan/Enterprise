/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertftoc;

import MyBean.StatelessFToCBeanRemote;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Main {

    @javax.ejb.EJB
    private static StatelessFToCBeanRemote statelessFToCBean;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Enter degree in Fahrenheit: ");
        double fa = sc.nextDouble();
        double ce = statelessFToCBean.fToC(fa);
        System.out.printf(fa + " Fahrenheit = " + ce + " Celsius\n");
    }
}
