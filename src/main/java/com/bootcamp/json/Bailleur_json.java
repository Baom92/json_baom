/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.json;

import com.bootcamp.Entites.Bailleur;
import com.bootcamp.Entites.Programme;
import com.bootcamp.Entites.Projet;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Bello
 */
public class Bailleur_json implements Serializable {

    private String chaine = "{\n";

    public Bailleur_json(Bailleur ben, List<Projet> projets, List<Programme> programmes) {
        this.chaine += "\t\"id\": " + ben.getId() + ",\n";
        this.chaine += "\t\"nom\": \"" + ben.getNom() + "\",\n";
        this.chaine += "\t\"typeDeBailleur\": \"" + ben.getTypeBailleur()+ "\",\n";
        this.setProjets(projets);
        this.chaine += ",\n";
        this.setProgrammes(programmes);
        this.chaine += "\n}";
    }

    public void setProjets(List<Projet> projets) {
        this.chaine += "\t\"projets\": [\n";
        for (int i = 0; i < projets.size(); i++) {
            Projet p = projets.get(i);
            this.chaine += "\t\t{\n";
            this.chaine += "\t\t\t\"id\": " + p.getId() + ",\n";
            this.chaine += "\t\t\t\"nom\": \"" + p.getNom() + "\",\n";
            this.chaine += "\t\t\t\"objectif\": \"" + p.getObjectif() + "\"\n";
            this.chaine += "\t\t}";

            if (i == (projets.size() - 1)) {
                this.chaine += "\n";
            } else {
                this.chaine += ",\n";
            }
        }
        this.chaine += "\t]";
    }

    public void setProgrammes(List<Programme> programmes) {
        this.chaine += "\t\"programmes\": [\n";
        for (int i = 0; i < programmes.size(); i++) {
            Programme p = programmes.get(i);
            this.chaine += "\t\t{\n";
            this.chaine += "\t\t\t\"id\": " + p.getId() + ",\n";
            this.chaine += "\t\t\t\"nom\": \"" + p.getNom() + "\",\n";
            this.chaine += "\t\t\t\"objectif\": \"" + p.getObjectif() + "\"\n";
            this.chaine += "\t\t}";

            if (i == (programmes.size() - 1)) {
                this.chaine += ",\n";
            } else {
                this.chaine += "\n";
            }
        }
        this.chaine += "\t]";
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
