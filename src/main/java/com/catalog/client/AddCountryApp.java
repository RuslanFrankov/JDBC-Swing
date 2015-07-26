package com.catalog.client;

import com.catalog.model.Country;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Dmitry on 12.07.2015.
 */
public class AddCountryApp  {
    JMenuBar jmb;
    JMenu jmCountry;
    JLabel chooseLabel;
    JFrame frame;
    Container rootPane;
    JPanel addCountryPanel;
    JPanel showCountryPanel;
    JTextField countryNameTextField;
    JTextField countryCodeTextField;
    JButton button;
    JLabel label1;
    JLabel label2;
    JTable jTable;

    AddCountryAppHelper helper = new AddCountryAppHelper();

    public AddCountryApp() {

        jmb = new JMenuBar();
        jmCountry = new JMenu("Country");
        JMenuItem jMenuItemAddCountry = new JMenuItem("Add Country");
        JMenuItem jMenuItemShowCountry = new JMenuItem("Show Country");
        jmCountry.add(jMenuItemAddCountry);
        jmCountry.add(jMenuItemShowCountry);
        jmb.add(jmCountry);

        jTable = new JTable();
        jTable.setModel();

        frame = new JFrame("Equipment");
        frame.setSize(300,300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        rootPane = frame.getContentPane();
        addCountryPanel = new JPanel(new FlowLayout());
        showCountryPanel = new JPanel(new FlowLayout());

        label1 = new JLabel("Add Country");
        label2 = new JLabel("Add code of Counrty");
        chooseLabel = new JLabel();


        countryNameTextField = new JTextField(10);
        countryCodeTextField = new JTextField(2);

        button = new JButton("Add Country");

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Country country = helper.createCountry(countryNameTextField.getText(), countryCodeTextField.getText());
                helper.persist(country);

                }
        });



        addCountryPanel.add(label1);
        addCountryPanel.add(countryNameTextField);
        addCountryPanel.add(label2);
        addCountryPanel.add(countryCodeTextField);
        addCountryPanel.add(button);

        showCountryPanel.add(jTable);

        frame.setJMenuBar(jmb);
        frame.add(chooseLabel, BorderLayout.EAST);
        frame.setVisible(true);

        jMenuItemAddCountry.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                JDialog addCountryDialog = new JDialog(frame, true);
//                Container contentPane = addCountryDialog.getContentPane();
//                contentPane.add(addCountryPanel);
                rootPane.add(addCountryPanel, BorderLayout.CENTER);
                addCountryPanel.setVisible(true);
                frame.setVisible(true);
//                addCountryDialog.setTitle("Add country");
//                addCountryDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//                addCountryDialog.setVisible(true);
//
            }
        });
        jMenuItemShowCountry.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                JDialog showCountryDialog = new JDialog(frame, true);
//                Container contentPane = showCountryDialog.getContentPane();

                rootPane.add(showCountryPanel, BorderLayout.SOUTH);
                showCountryPanel.setVisible(true);
                frame.setVisible(true);


            }
        });
    }




    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AddCountryApp();
            }
        });
    }
}
