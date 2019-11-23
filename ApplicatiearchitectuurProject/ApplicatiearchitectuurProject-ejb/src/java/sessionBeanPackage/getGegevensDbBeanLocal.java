/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeanPackage;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author r0656495
 */
@Local
public interface getGegevensDbBeanLocal {
     public List<Object> getMachines(); 
    //public int newMachine(String klantNaam,String klantAdres,String klantPostcode,String klantGemeente);


    //public List<Object> getReservaties(); 
    //public void newReservatie();
    

    //public List<Object> getReserveerbareDagen(); 
    //public void nweReserveerbareDagenDatum();
}
