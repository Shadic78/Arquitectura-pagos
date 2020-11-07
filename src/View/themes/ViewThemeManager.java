/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.themes;

import javax.swing.JFrame;

/**
 *
 * @author Equipo1
 */
public class ViewThemeManager {

    public static void changeViewTheme(JFrame frame, ViewThemes theme) {
        ViewThemeLoader themeLoader = new ViewThemeLoader();

        switch (theme) {
            case DEFAULT_THEME:
                themeLoader.loadTheme(frame, ViewThemesList.DEFAULT_THEME);
                break;
            case DARK_THEME:
                themeLoader.loadTheme(frame, ViewThemesList.DARK_THEME);
                break;
            default:
                System.out.println("That theme doesn´t exist");
        }
    }

}
