package game;

import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import java.awt.*;

public class Style {

    private static final Font defaultLabelFont = new Font("Inter", Font.BOLD, 16);
    private static final Font boldFont = new Font("Inter", Font.BOLD, 12);

    public static void setDefaultTheme(){
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
            UIManager.put( "TextComponent.arc", 999 );
            UIManager.put("Button.borderWidth", 0);
            UIManager.put("Button.font", new Font("Inter", Font.PLAIN, 14));
            UIManager.put("Button.focusedBorderColor", Color.TRANSLUCENT);
            UIManager.put("Label.foreground", Color.WHITE);
            UIManager.put("Button.foreground", Color.WHITE);
            UIManager.put("TextField.foreground", Color.WHITE);

        } catch (Exception e) {
            System.err.println("Failed to initialize FlatLaf");
            e.printStackTrace();
        }
    }

    public static void setDefaultLabelFont(JComponent component){
        component.setFont(defaultLabelFont);
    }

    public static void setBoldFont(JComponent component){
        component.setFont(boldFont);
    }

    public static void setTextColor(JComponent component, Color color) {
        component.setForeground(color);
    }

}
