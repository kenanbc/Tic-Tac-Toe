package view;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Style {

    private static final Font defaultTitleFont = new Font("Inter", Font.PLAIN, 22);
    private static final Font defaultLabelFont = new Font("Inter", Font.BOLD, 16);
    private static final Font italicFont = new Font("Inter", Font.ITALIC, 12);
    private static final Font boldFont = new Font("Inter", Font.BOLD, 12);
    private static final Font iconFont = new Font("Inter", Font.PLAIN, 96);


    public static void setDefaultTheme(){
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
           // UIManager.put( "Button.arc", 999 );
            UIManager.put( "TextComponent.arc", 999 );
//            UIManager.put( "Component.arc", 999 );
            UIManager.put("Button.borderWidth", 0);
            UIManager.put("Button.margin", new Insets(5, 7, 5, 7));
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

    public static void switchTheme(ActionEvent e, Component frame) {
        try {
            if (UIManager.getLookAndFeel() instanceof FlatLightLaf) {
                FlatDarkLaf.setup();
                setDefaultDarkStyle();

            } else {
                FlatLightLaf.setup();
                setDefaultLightStyle();
            }

            SwingUtilities.updateComponentTreeUI(frame);
            resetColors(frame);
            frame.repaint();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void setIconFont(JLabel label){
        label.setFont(iconFont);
    }

    public static void resetColors(Component component) {
        if (component instanceof JLabel) {
            component.setForeground(UIManager.getColor("Label.foreground"));
        } else if (component instanceof JButton) {
            component.setForeground(UIManager.getColor("Button.foreground"));
        } else if (component instanceof JTextField) {
            component.setForeground(UIManager.getColor("TextField.foreground"));
        } else if (component instanceof JTextField) {
            component.setForeground(UIManager.getColor("Table.foreground"));
        } else if (component instanceof JTextField) {
            component.setForeground(UIManager.getColor("JComboBox.foreground"));
        } else if (component instanceof JTextField) {
            component.setForeground(UIManager.getColor("TableHeader.foreground"));
        }

        if (component instanceof Container) {
            for (Component child : ((Container) component).getComponents()) {
                resetColors(child);
            }
        }
    }

    public static void developedByWaterMark(JLabel label){
        setItalicFont(label);
        setTextColor(label, Color.GRAY);
    }

    public static void sessionLabelStyle(JLabel label){
        setTextColor(label, Color.GRAY);
    }

    public static void setDefaultTitleFont(JComponent component){
        component.setFont(defaultTitleFont);
    }

    public static void setDefaultLabelFont(JComponent component){
        component.setFont(defaultLabelFont);
    }

    public static void setItalicFont(JComponent component){
        component.setFont(italicFont);
    }

    public static void setBoldFont(JComponent component){
        component.setFont(boldFont);
    }

    public static void setTextColor(JComponent component, Color color) {
        component.setForeground(color);
    }

    private static void  setDefaultLightStyle(){
        UIManager.put("Label.foreground", Color.BLACK);
        UIManager.put("Button.foreground", Color.BLACK);
        UIManager.put("TextField.foreground", Color.BLACK);
        UIManager.put("Table.foreground", Color.BLACK);
        UIManager.put("JComboBox.foreground", Color.BLACK);
        UIManager.put("TableHeader.foreground", Color.BLACK);
        UIManager.put("Table.alternateRowColor", Color.decode("#dadada"));
        UIManager.put("Table.rowHeight", 30);
        UIManager.put("Table.showVerticalLines", true);
    }

    private static void setDefaultDarkStyle(){
        UIManager.put("Label.foreground", Color.WHITE);
        UIManager.put("Button.foreground", Color.WHITE);
        UIManager.put("TextField.foreground", Color.WHITE);
        UIManager.put("Table.foreground", Color.WHITE);
        UIManager.put("JComboBox.foreground", Color.WHITE);
        UIManager.put("TableHeader.foreground", Color.WHITE);
        UIManager.put("Table.alternateRowColor", Color.decode("#777777"));
        UIManager.put("Table.rowHeight", 30);
        UIManager.put("Table.showVerticalLines", true);
    }

    public static void setButtonStyle(JPanel panel){
        for (Component component : panel.getComponents()) {
            if (component instanceof JButton) {
                JButton button = (JButton) component;
                button.putClientProperty("JButton.arc", 0);
            }
        }
    }
}
