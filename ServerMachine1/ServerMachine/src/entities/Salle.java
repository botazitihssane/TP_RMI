/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Ihssane
 */
@Entity
@NamedQuery(name = "findAllSalle", query = "from Salle")
@NamedNativeQuery(name = "findMachinesBySalle", query = "SELECT m.* FROM Machine m JOIN Salle s ON m.salle_id = s.id WHERE s.code = :code", resultClass = Machine.class)

public class Salle implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String code;
    public Salle(){
    }
    
    public Salle(String code){
        this.code=code;
    }

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Salle(int id, String code) {
        this.id = id;
        this.code = code;
    }
    @Override
    public String toString() {
        return super.toString();
    }
}
    