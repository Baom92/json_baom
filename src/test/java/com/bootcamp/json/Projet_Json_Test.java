/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.json;

import com.bootcamp.Entites.Projet;
import com.bootcamp.Entites.Bailleur;
import com.bootcamp.Entites.Beneficiaire;
import com.bootcamp.Entites.Fournisseur;
import com.bootcamp.Entites.IndicateurPerformance;
import com.bootcamp.Entites.Livrable;
import com.bootcamp.Entites.Programme;
import com.bootcamp.Enum.TypeBailleur;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import org.testng.annotations.Test;

/**
 *
 * @author Bello
 */
public class Projet_Json_Test {

    @Test
    public void testCréationJson() {
        Projet projet = new Projet(1, "ABOK", "Routes Abomey-Bohicon-Kétou");
        IndicateurPerformance indic = new IndicateurPerformance(1, "IndicateurPerformance");
        Programme programme = new Programme(1, "ABOK", "Routes Abomey-Bohicon-Kétou");
        List<Livrable> livrables = new LinkedList<>();
        List<Beneficiaire> bens = new LinkedList<>();
        List<Bailleur> bas = new LinkedList<>();
        List<Fournisseur> fos = new LinkedList<>();
        livrables.add(new Livrable(1, "Tuiles"));
        livrables.add(new Livrable(2, "Pavés"));
        bens.add(new Beneficiaire(1, "Bello"));
        bens.add(new Beneficiaire(2, "Adam"));
        bas.add(new Bailleur(1, "Fatouma", TypeBailleur.NON_GOUVERNEMENTALE));
        bas.add(new Bailleur(2, "Chido", TypeBailleur.PRIVE));
        fos.add(new Fournisseur(1, "Toundé"));
        fos.add(new Fournisseur(2, "Chakirou"));
        
        Projet_json ben = new Projet_json(projet, programme, indic, livrables, bens, bas, fos);
        
        BufferedOutputStream bos;
        try {
            bos = new BufferedOutputStream(new FileOutputStream(new File("./src/main/java/com/bootcamp/json/Test_Results/Projet.json")));
            bos.write(ben.getChaine().getBytes());
            bos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
