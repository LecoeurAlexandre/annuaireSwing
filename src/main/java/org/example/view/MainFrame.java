package org.example.view;

import lombok.Data;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Data
public class MainFrame {
    private JPanel mainPanel, line1Panel, line2Panel;
    private JButton addButton, updateButton, deleteButton, selectButton;

    public MainFrame() {
        mainPanel = new JPanel(new BorderLayout());

        //Partie haute trois boutons
        line1Panel = new JPanel();
        addButton = new JButton("Insert");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InsertDialog insertDialog = new InsertDialog();
                insertDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                insertDialog.setVisible(true);
            }
        });
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteDialog deleteDialog = new DeleteDialog();
                deleteDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                deleteDialog.setVisible(true);
            }
        });
        line1Panel.add(addButton);
        line1Panel.add(updateButton);
        line1Panel.add(deleteButton);
        mainPanel.add(line1Panel, BorderLayout.NORTH);

        //Partie centrale un bouton
        line2Panel = new JPanel();
        selectButton = new JButton("Select");
        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SelectDialog selectDialog = new SelectDialog();
                selectDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                selectDialog.setVisible(true);
            }
        });
        line2Panel.add(selectButton);
        mainPanel.add(line2Panel, BorderLayout.CENTER);
    }
}
