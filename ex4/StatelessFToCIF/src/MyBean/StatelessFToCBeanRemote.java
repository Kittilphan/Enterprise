/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyBean;

import javax.ejb.Remote;

/**
 *
 * @author USER
 */
@Remote
public interface StatelessFToCBeanRemote {
    double fToC(double f);
    
}
