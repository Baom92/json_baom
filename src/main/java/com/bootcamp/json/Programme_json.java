/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.json;

import com.bootcamp.Entites.Bailleur;
import com.bootcamp.Entites.Beneficiaire;
import com.bootcamp.Entites.Fournisseur;
import com.bootcamp.Entites.IndicateurPerformance;
import com.bootcamp.Entites.Programme;
import com.bootcamp.Entites.Projet;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Bello
 */
public class Programme_json implements Serializable {

    private String chaine = "{\n";

    public Programme_json(Programme programme, List<Projet> projets, IndicateurPerformance indic, List<Beneficiaire> bens, List<Bailleur> bas, List<Fournisseur> fos) {
        this.chaine += "\t\"id\": " + programme.getId() + ",\n";
        this.chaine += "\t\"nom\": \"" + programme.getNom() + "\",\n";
        this.chaine += "\t\"oblectif\": \"" + programme.getObjectif()+ "\",\n";
        this.setProjets(projets);
        this.chaine += ",\n";
        this.setIndicateur(indic);
        this.chaine += ",\n";
        this.setBeneficiaires(bens);
        this.chaine += ",\n";
        this.setBailleurs(bas);
        this.chaine += ",\n";
        this.setFournisseurs(fos);
        this.chaine += "\n}";
    }

    public void setIndicateur(IndicateurPerformance indic) {
        this.chaine += "\t\"indicateurPerformance\": {\n";
        this.chaine += "\t\t\"id\": " + indic.getId() + ",\n";
        this.chaine += "\t\t\"nom\": \"" + indic.getNom() + "\",\n";
        this.chaine += "\t}";
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

    public void setBeneficiaires(List<Beneficiaire> bens) {
        this.chaine += "\t\"beneficiaires\": [\n";
        for (int i = 0; i < bens.size(); i++) {
            Beneficiaire p = bens.get(i);
            this.chaine += "\t\t{\n";
            this.chaine += "\t\t\t\"id\": " + p.getId() + ",\n";
            this.chaine += "\t\t\t\"nom\": \"" + p.getNom() + "\",\n";
            this.chaine += "\t\t}";

            if (i == (bens.size() - 1)) {
                this.chaine += ",\n";
            } else {
                this.chaine += "\n";
            }
        }
        this.chaine += "\t]";
    }

    public void setBailleurs(List<Bailleur> bas) {
        this.chaine += "\t\"bailleurs\": [\n";
        for (int i = 0; i < bas.size(); i++) {
            Bailleur p = bas.get(i);
            this.chaine += "\t\t{\n";
            this.chaine += "\t\t\t\"id\": " + p.getId() + ",\n";
            this.chaine += "\t\t\t\"nom\": \"" + p.getNom() + "\",\n";
            this.chaine += "\t\t\t\"typeDeBailleur\": \"" + p.getTypeBailleur() + "\",\n";
            this.chaine += "\t\t}";

            if (i == (bas.size() - 1)) {
                this.chaine += ",\n";
            } else {
                this.chaine += "\n";
            }
        }
        this.chaine += "\t]";
    }
    
    public void setFournisseurs(List<Fournisseur> fos) {
        this.chaine += "\t\"fournisseurs\": [\n";
        for (int i = 0; i < fos.size(); i++) {
            Fournisseur p = fos.get(i);
            this.chaine += "\t\t{\n";
            this.chaine += "\t\t\t\"id\": " + p.getId() + ",\n";
            this.chaine += "\t\t\t\"nom\": \"" + p.getNom() + "\",\n";
            this.chaine += "\t\t}";

            if (i == (fos.size() - 1)) {
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
