/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QueueAndStack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.*;

/**
 *
 * @author rownavanana
 */
public class CustomerServiceQueueManager extends JFrame implements ActionListener {
    private Queue<String> customerQueue;
    private JTextField txtCustomerName;
    private JTextArea taQueueDisplay;
    private JButton addBtn, processBtn, showBtn;

    public CustomerServiceQueueManager() {
        customerQueue = new LinkedList<>();

        setTitle("Customer Service Queue Manager");
        setSize(520, 270); // Pinalaki ang window width at height para hindi maipit
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // --- TOP SECTION: Customer Name Label & Text Field ---
        JLabel lblCustomer = new JLabel("Customer Name:");
        lblCustomer.setBounds(20, 20, 110, 25);
        add(lblCustomer);

        txtCustomerName = new JTextField();
        txtCustomerName.setBounds(140, 20, 335, 25);
        add(txtCustomerName);

        // --- LEFT SECTION: Stacked Buttons ---
        addBtn = new JButton("Add Customer");
        addBtn.setBounds(20, 60, 150, 30);
        add(addBtn);

        processBtn = new JButton("Process Customer");
        processBtn.setBounds(20, 100, 150, 30);
        add(processBtn);

        showBtn = new JButton("Show Queue");
        showBtn.setBounds(20, 140, 150, 30);
        add(showBtn);

        // --- RIGHT SECTION: Text Area Display Box ---
        taQueueDisplay = new JTextArea();
        taQueueDisplay.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(taQueueDisplay);
        scrollPane.setBounds(185, 60, 290, 110);
        add(scrollPane);

        // Register Action Listeners
        addBtn.addActionListener(this);
        processBtn.addActionListener(this);
        showBtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // --- ADD CUSTOMER ---
        if (e.getSource() == addBtn) {
            String customerName = txtCustomerName.getText().trim();
            if (!customerName.isEmpty()) {
                customerQueue.offer(customerName); // Gumagamit ng offer() para sa queue
                JOptionPane.showMessageDialog(this, "Customer added to the queue", "Info", JOptionPane.INFORMATION_MESSAGE);
                txtCustomerName.setText("");
                updateQueueDisplay();
            } else {
                JOptionPane.showMessageDialog(this, "Please enter a customer name", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } 
        // --- PROCESS CUSTOMER ---
        else if (e.getSource() == processBtn) {
            if (!customerQueue.isEmpty()) {
                String processedCustomer = customerQueue.poll();
                JOptionPane.showMessageDialog(this, "Serving customer: " + processedCustomer, "Message", JOptionPane.INFORMATION_MESSAGE);
                updateQueueDisplay();
            } else {
                JOptionPane.showMessageDialog(this, "No customers in the queue", "Message", JOptionPane.INFORMATION_MESSAGE);
            }
        } 
        // --- SHOW QUEUE ---
        else if (e.getSource() == showBtn) {
            updateQueueDisplay();
            if (customerQueue.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No customers in the queue", "Message", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    // Helper method na gumagamit lang ng String concatenation (+) sa halip na append()
    private void updateQueueDisplay() {
        if (customerQueue.isEmpty()) {
            taQueueDisplay.setText("");
        } else {
            String displayStr = "";
            int index = 1;
            for (String customer : customerQueue) {
                displayStr = displayStr + index + ". " + customer + "\n";
                index++;
            }
            taQueueDisplay.setText(displayStr);
        }
    }

}