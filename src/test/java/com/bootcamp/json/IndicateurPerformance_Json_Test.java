/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.json;

import com.bootcamp.Entites.IndicateurPerformance;
import com.bootcamp.Entites.IndicateurQuantitatif;
import com.bootcamp.Entites.IndicateurQualitatif;
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
public class IndicateurPerformance_Json_Test {

    @Test
    public void testCréationJson() {
        IndicateurPerformance beneficiaire = new IndicateurPerformance(1, "Indicateur");
        List<IndicateurQualitatif> indic2 = new LinkedList<>();
        indic2.add(new IndicateurQualitatif(1, "Résistance", "résistance à la chaleur", 2));
        indic2.add(new IndicateurQualitatif(2, "Ductulité", "résistance au choc", 3));
        List<IndicateurQuantitatif> indic1 = new LinkedList<>();
        indic1.add(new IndicateurQuantitatif(1, "Quantité", "quantité du matériel", 15));
        indic1.add(new IndicateurQuantitatif(1, "Poids", "poids en tonne", 34));
        IndicateurPerformance_json ben = new IndicateurPerformance_json(beneficiaire, indic1, indic2);
        
        BufferedOutputStream bos;
        try {
            bos = new BufferedOutputStream(new FileOutputStream(new File("./src/main/java/com/bootcamp/json/Test_Results/IndicateurPerformance.json")));
            bos.write(ben.getChaine().getBytes());
            bos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
