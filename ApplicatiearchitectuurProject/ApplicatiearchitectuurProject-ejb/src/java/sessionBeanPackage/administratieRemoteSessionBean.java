/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeanPackage;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author r0656495
 */
@Stateless
public class administratieRemoteSessionBean implements administratieRemoteSessionBeanRemote {
    @PersistenceContext
    EntityManager em;








}
