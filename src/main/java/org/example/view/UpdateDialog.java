package org.example.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class UpdateDialog extends JDialog {
    private JPanel contentPanel, buttonPanel;
    private JLabel idLabel, nameLabel, numberLabel;
    private JTextField idText, nameText, numberText;
    private JButton searchButton, okButton, cancelButton;

    public UpdateDialog() {
        contentPanel = new JPanel();
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[6];
        gridBagLayout.rowHeights = new int[6];
        contentPanel.setLayout(gridBagLayout);
        GridBagConstraints c = new GridBagConstraints();
        //c.weightx = 1;
        //c.weighty = 1;
        c.fill = GridBagConstraints.BOTH;
        setTitle("Update Contact");
        setBounds(100,100, 500,200);
        contentPanel.setBorder(new EmptyBorder(5,5,5,5));


        idLabel = new JLabel("ID");
        c.gridx = 0;
        c.gridy = 0;
        contentPanel.add(idLabel, c);

        nameLabel = new JLabel("Name");
        c.gridx = 0;
        c.gridy = 1;
        contentPanel.add(nameLabel, c);

        numberLabel = new JLabel("Number");
        c.gridx = 0;
        c.gridy = 2;
        contentPanel.add(numberLabel, c);

        idText = new JTextField(20);
        c.gridx = 1;
        c.gridy = 0;
        contentPanel.add(idText, c);

        nameText = new JTextField(20);
        c.gridx = 1;
        c.gridy = 1;
        contentPanel.add(nameText, c);

        numberText = new JTextField(20);
        c.gridx = 1;
        c.gridy = 2;
        contentPanel.add(numberText, c);

        searchButton = new JButton("Search");
        c.gridx = 2;
        c.gridy = 0;
        contentPanel.add(searchButton, c);

        okButton = new JButton("OK");
        cancelButton = new JButton("Cancel");
        buttonPanel = new JPanel();
        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);
        c.gridx = 2;
        c.gridy = 3;
        contentPanel.add(buttonPanel, c);

        getContentPane().add(contentPanel);

    }
}
