/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.json;

import com.bootcamp.Entites.IndicateurQuantitatif;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.testng.annotations.Test;

/**
 *
 * @author Bello
 */
public class IndicateurQuantitatif_Json_Test {

    @Test
    public void testCréationJson() {
        IndicateurQuantitatif indic = new IndicateurQuantitatif(1, "Quantité", "quantité du matériel", 15);
        IndicateurQuantitatif_json ben = new IndicateurQuantitatif_json(indic);
        
        BufferedOutputStream bos;
        try {
            bos = new BufferedOutputStream(new FileOutputStream(new File("./src/main/java/com/bootcamp/json/Test_Results/IndicateurQuantitatif.json")));
            bos.write(ben.getChaine().getBytes());
            bos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
