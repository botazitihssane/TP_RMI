/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientmachine;

import dao.IDao;
import entities.Machine;
import entities.Salle;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lachgar
 */
public class ClientMachine {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            IDao<Machine> machine = (IDao<Machine>) Naming.lookup("rmi://localhost:1098/machine");
            IDao<Salle> salle = (IDao<Salle>) Naming.lookup("rmi://localhost:1098/salle");
            List<Machine> machines = machine.findMachinesBySalle("code1");

            for (Machine m : machines) {
                System.out.println("ID: " + m.getId());
                System.out.println("Référence: " + m.getRef());
                System.out.println("Marque: " + m.getMarque());
                System.out.println("Prix: " + m.getPrix());
                System.out.println("Salle ID: " + m.getSalle().getId()); 
                System.out.println();
            }
        } catch (NotBoundException ex) {
            Logger.getLogger(ClientMachine.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ClientMachine.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ClientMachine.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
