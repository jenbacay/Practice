/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practice;

/**
 *
 * @author JenJen
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.*;

/**
 *
 * @author JenJen
 */
public class NewClass extends JFrame{
    private LinkedList <String> linkedlist;
    private DefaultListModel <String> listModel;
    private JList <String> list;
    private JLabel total;
    private JScrollPane scrollPane;
    private JTextField txtField;
    private JButton addBtn, removeBtn, clearBtn;
    
    NewClass(){
        linkedlist = new LinkedList();
        listModel = new DefaultListModel();
        
        setTitle("Tracker App");
        setSize(400, 500);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

 }
