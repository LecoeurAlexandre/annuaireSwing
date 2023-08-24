package org.example.dao;

import org.example.connexion.ConnectionUtil;
import org.example.model.Contact;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContactDAO {
    private Connection con;
    private PreparedStatement ps;
    private String request;
    private ResultSet resultSet;



    public int addContact(Contact contact) {
        con = ConnectionUtil.getConnexion();
        try {
            ps = con.prepareStatement("INSERT INTO `contact`(`name`,`number`) VALUES(?,?) ");
            ps.setString(1, contact.getName());
            ps.setString(2, contact.getNumber());
            int n = ps.executeUpdate();
            return n;

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }

    }

    public List<Contact> getAllContacts() {
        con = ConnectionUtil.getConnexion();
        List<Contact> contacts = new ArrayList<>();
        try {
            ps = con.prepareStatement("SELECT * FROM contact");
            resultSet = ps.executeQuery();
            while(resultSet.next()) {
                Contact contact = new Contact(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("number"));
                contacts.add(contact);
            }
            return contacts;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public int deleteContact(int id) {
        con = ConnectionUtil.getConnexion();
        try {
            ps = con.prepareStatement("DELETE FROM contact where id = ?");
            ps.setInt(1, id);
            int n = ps.executeUpdate();
            return n;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
    public int update(Contact contact) {
        con = ConnectionUtil.getConnexion();
        try {
            ps = con.prepareStatement("UPDATE contact set name = ?, number = ?");
            ps.setString(1, contact.getName());
            ps.setString(2, contact.getNumber());
            int n = ps.executeUpdate();
            return n;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }

    }
}
