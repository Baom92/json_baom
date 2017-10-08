/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.json;

import com.bootcamp.Entites.IndicateurPerformance;
import com.bootcamp.Entites.IndicateurQualitatif;
import com.bootcamp.Entites.IndicateurQuantitatif;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Bello
 */
public class IndicateurPerformance_json implements Serializable {

    private String chaine = "{\n";

    public IndicateurPerformance_json(IndicateurPerformance ben, List<IndicateurQuantitatif> indic1, List<IndicateurQualitatif> indic2) {
        this.chaine += "\t\"id\": " + ben.getId() + ",\n";
        this.chaine += "\t\"nom\": \"" + ben.getNom() + "\",\n";
        this.setIndicateurQuantitatifs(indic1);
        this.chaine += ",\n";
        this.setIndicateurQualitatifs(indic2);
        this.chaine += "\n}";
    }

    public void setIndicateurQuantitatifs(List<IndicateurQuantitatif> indic) {
        this.chaine += "\t\"indic_quantitatifs\": [\n";
        for (int i = 0; i < indic.size(); i++) {
            IndicateurQuantitatif_json p = new IndicateurQuantitatif_json(indic.get(i));
            this.chaine += "\t"+p.getChaine();

            if (i == (indic.size() - 1)) {
                this.chaine += "\n";
            } else {
                this.chaine += ",\n";
            }
        }
        this.chaine += "\t]";
    }

    public void setIndicateurQualitatifs(List<IndicateurQualitatif> indic) {
        this.chaine += "\t\"indic_quantitatifs\": [\n";
        for (int i = 0; i < indic.size(); i++) {
            IndicateurQualitatif_json p = new IndicateurQualitatif_json(indic.get(i));
            this.chaine += "\t"+p.getChaine();

            if (i == (indic.size() - 1)) {
                this.chaine += "\n";
            } else {
                this.chaine += ",\n";
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
