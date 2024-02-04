/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyBean;

import javax.ejb.Stateless;

/**
 *
 * @author USER
 */
@Stateless
public class StatelessFToCBean implements StatelessFToCBeanRemote {

    @Override
    public double fToC(double f) {
        double c = (5.00/9.00) * (f -32.00);
        return c;
    }    
}
