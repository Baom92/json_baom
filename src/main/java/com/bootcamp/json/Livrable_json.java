/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.json;

import com.bootcamp.Entites.Livrable;
import java.io.Serializable;

/**
 *
 * @author Bello
 */
public class Livrable_json implements Serializable {

    private String chaine = "{\n";

    public Livrable_json(Livrable ben) {
        this.chaine += "\t\"id\": " + ben.getId() + ",\n";
        this.chaine += "\t\"nom\": \"" + ben.getNom() + "\",\n";
        this.chaine += ",\n";
        this.chaine += "\n}";
    }

    public String getChaine() {
        return this.chaine;
    }

    public void setChaine(String chaine) {
        this.chaine = chaine;
    }

    public void affiche() {
        System.out.println(this.chaine);
    }
    
    @Override
    public String toString() {
        return this.chaine;
    }
}
