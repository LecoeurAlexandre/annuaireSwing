package org.example.view;

import org.example.dao.ContactDAO;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteDialog extends JDialog {
    private JPanel contentPanel;
    private JTextField idText;
    private JLabel idLabel;
    private JButton okButton, cancelButton;

    public DeleteDialog() {
        contentPanel = new JPanel();
        setTitle("Delete Contact");
        setBounds(100,100, 350,200);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5,5,5,5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        idText = new JTextField();
        idText.setBounds(80, 50,80, 20);
        contentPanel.add(idText);
        idText.setColumns(10);

        idLabel = new JLabel("Id");
        idLabel.setBounds(10,20,50,15);
        contentPanel.add(idLabel);

        JPanel jPanelButton = new JPanel();
        jPanelButton.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(jPanelButton, BorderLayout.SOUTH);
        JButton jButtonOK = new JButton("OK");
        jPanelButton.add(jButtonOK);
        jButtonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(idText.getText());
                ContactDAO contactDao = new ContactDAO();
                int isCompleted = contactDao.deleteContact(id);
                if (isCompleted>0) {
                    JOptionPane.showConfirmDialog(null, "Add operation success");
                }else{
                    JOptionPane.showConfirmDialog(null, "Error Record");
                }
                dispose();
            }
        });

        JButton jButtonCancel = new JButton("Cancel");
        // contentPanel.add(jButtonCancel);
        jPanelButton.add(jButtonCancel);
        jButtonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
