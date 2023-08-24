package org.example.view;

import org.example.dao.ContactDAO;
import org.example.model.Contact;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class SelectDialog extends JDialog{
    private JPanel panel;
    private JTable table;
    private ContactDAO contactDAO;
    public SelectDialog() {
        panel = new JPanel();
        setTitle("Select");
        setBounds(100,100, 500,500);
        String[] columns = new String[] {
                "ID", "nom", "numéro"
        };
        DefaultTableModel model = new DefaultTableModel(columns,0);
        table = new JTable(model);

        contactDAO = new ContactDAO();
        for (Contact contact: contactDAO.getAllContacts()) {
            model.addRow(new Object[] {
               contact.getId(),
               contact.getName(),
               contact.getNumber()
            });
        }

        table.setBounds(30, 40, 500, 300);
        JScrollPane sp = new JScrollPane(table);
        panel.add(sp);
        add(panel);
    }
}
