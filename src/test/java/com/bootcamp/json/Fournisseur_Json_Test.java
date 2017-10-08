/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.json;

import com.bootcamp.Entites.Fournisseur;
import com.bootcamp.Entites.Programme;
import com.bootcamp.Entites.Projet;
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
public class Fournisseur_Json_Test {

    @Test
    public void testCréationJson() {
        Fournisseur beneficiaire = new Fournisseur(1, "Dupont");
        List<Projet> projets = new LinkedList<>();
        projets.add(new Projet(1, "Routes", "Constructions de routes"));
        projets.add(new Projet(2, "Ecoles", "Constructions de modules de classe"));
        List<Programme> programmes = new LinkedList<>();
        programmes.add(new Programme(1, "ABOK", "Routes Abomey-Bohicon-Kétou"));
        programmes.add(new Programme(2, "KI", "Routes Kétou-Ilara"));
        Fournisseur_json ben = new Fournisseur_json(beneficiaire, projets, programmes);
        
        BufferedOutputStream bos;
        try {
            bos = new BufferedOutputStream(new FileOutputStream(new File("./src/main/java/com/bootcamp/json/Test_Results/Fournisseur.json")));
            bos.write(ben.getChaine().getBytes());
            bos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
