/*
 * To change this license header, chbose License Headers in Project Properties.
 * To change this template file, chbose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp;

import com.bootcamp.Entites.Beneficiaire;
import com.bootcamp.Entites.Programme;
import com.bootcamp.Entites.Projet;
import com.bootcamp.json.Beneficiaire_json;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Bello
 */
public class Main {

    public static void main(String[] args) {
        Beneficiaire beneficiaire = new Beneficiaire(1, "Dupont");
        List<Projet> projets = new LinkedList<>();
        projets.add(new Projet(1, "Routes", "Constructions de routes"));
        projets.add(new Projet(2, "Ecoles", "Constructions de modules de classe"));
        List<Programme> programmes = new LinkedList<>();
        programmes.add(new Programme(1, "ABOK", "Routes Abomey-Bohicon-Kétou"));
        programmes.add(new Programme(2, "KI", "Routes Kétou-Ilara"));
        Beneficiaire_json ben = new Beneficiaire_json(beneficiaire, projets, programmes);
        //ben.affiche();
        BufferedOutputStream bos;
        try {
            bos = new BufferedOutputStream(new FileOutputStream(new File("./src/main/java/com/bootcamp/json/Beneficiaire.json")));
            bos.write(ben.getChaine().getBytes());
            bos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        String js = "{\n";
//        js+="\t\"id\": 1,\n";
//        js+="\t\"nom\": \"Dupont\"\n";
//        js+="}";
//        System.out.println(js);
//        //--- persistons ce client dans la base
//        System.out.println("Ajout du Beneficiare dans la base en cours...");
//        BaseControlleur<Beneficiaire> controlleur = new BaseControlleur<>("TP_JPA_PU", Beneficiaire.class);
//        controlleur.create(beneficiaire);
//        System.out.println("Transaction validée");
//        
//        //--- Récupération de ce client dans la base
//        System.out.println("Lecture du Beneficiare dans la base en cours...");
//        Beneficiaire ben = controlleur.getAllEntities().get(0);
//        System.out.println(ben.getNom());
    }
}
