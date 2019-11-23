/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeanPackage;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author r0656495
 */
@Remote
public interface administratieRemoteSessionBeanRemote {
    public List<Object> getMachinesLokalen(); 
    public List<Object> getMachinesOmschrijving(); 
    public List<Object> getMachinesMnaam();
    public List<Object> getMachinesSerieNr();
    public List<Object> getMachineshuurprijs();
    public List<Object> getMachinesaankoopprijs();
       
    public int newMachine(String klantNaam,String klantAdres,String klantPostcode,String klantGemeente);


    public List<Object> getReservatiesRid(); 
    public List<Object> getReservatiesDatum();

    public int newReservaties();
    

    public List<Object> getReserveerbareDagenDatum(); 
    
    public int nweReserveerbareDagenDatum();

       




}
