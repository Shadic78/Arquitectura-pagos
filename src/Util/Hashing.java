/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

/**
 *
 * @author Equipo1
 */
public class Hashing {
    
        public static int toHashSuma(String key) {
        int keyInt = 0;
        key = key.toLowerCase();
        for (int i = 0; i < key.length(); i++) {
            if (key.charAt(i) != ' ') {
                keyInt += key.charAt(i) + 15;
            }
        }
        return keyInt;
    }
        
}
