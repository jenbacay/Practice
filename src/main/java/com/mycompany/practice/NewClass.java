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
public class NewClass extends JFrame implements ActionListener{
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
        
        list = new JList<>(listModel);
        scrollPane = new JScrollPane(list);
        scrollPane.setBounds(20, 20, 345, 180);
        add(scrollPane);

        // 3. JTextField
        txtField = new JTextField();
        txtField.setBounds(20, 250, 220, 30);
        add(txtField);

        // 4. Buttons
        addBtn = new JButton("Add");
        addBtn.setBounds(255, 250, 110, 30);
        add(addBtn);

        removeBtn = new JButton("Remove");
        removeBtn.setBounds(255, 290, 110, 30);
        add(removeBtn);

        clearBtn = new JButton("Clear All");
        clearBtn.setBounds(255, 330, 110, 30);
        add(clearBtn);

        // Action Listeners
        addBtn.addActionListener(this);
        removeBtn.addActionListener(this);
        clearBtn.addActionListener(this);
    }

    // Helper method para laging updated ang counter
    private void updateTaskCount() {
        total.setText("Total Tasks: " + linkedlist.size());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addBtn) {
            String task = txtField.getText().trim();
            if (!task.isEmpty()) {
                linkedlist.add(task);
                listModel.addElement(task);
                txtField.setText("");
                updateTaskCount();
            } else {
                JOptionPane.showMessageDialog(this, "Please enter a task first!", "Input Error", 
                JOptionPane.ERROR_MESSAGE);
            }
        } 
        // --- REMOVE BUTTON ---
        else if (e.getSource() == removeBtn) {
            int selectedIndex = list.getSelectedIndex();
            if (selectedIndex != -1) {
                linkedlist.remove(selectedIndex);
                listModel.remove(selectedIndex);
                updateTaskCount();
            } else {
                JOptionPane.showMessageDialog(this, "Please select a task to remove first!", 
                "Selection Warning", JOptionPane.WARNING_MESSAGE);
            }
        } 
        // --- CLEAR ALL BUTTON ---
        else if (e.getSource() == clearBtn) {
            if (!linkedlist.isEmpty()) {
                linkedlist.clear();
                listModel.clear();
                updateTaskCount();
            } else {
                JOptionPane.showMessageDialog(this, "The task list is already empty!", 
                "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    
    }

 }
