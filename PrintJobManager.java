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
public class PrintJobManager extends JFrame implements ActionListener {
    private Queue<String> jobQueue;
    private JTextField txtJobName;
    private JTextArea taQueueDisplay;
    private JButton addBtn, processBtn, showBtn;

    public PrintJobManager() {
        jobQueue = new LinkedList<>();

        setTitle("Print Job Manager");
        setSize(480, 360);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Job Name Label and Text Field
        JLabel lblJob = new JLabel("JOB NAME:");
        lblJob.setBounds(20, 25, 80, 25);
        add(lblJob);

        txtJobName = new JTextField();
        txtJobName.setBounds(100, 25, 195, 25);
        add(txtJobName);

        // Buttons as seen in the lab mockup
        addBtn = new JButton("Add Job");
        addBtn.setBounds(315, 20, 130, 30);
        add(addBtn);

        processBtn = new JButton("Process Job");
        processBtn.setBounds(315, 60, 130, 30);
        add(processBtn);

        showBtn = new JButton("Show Queue");
        showBtn.setBounds(315, 100, 130, 30);
        add(showBtn);

        // Output Text Area (matching the bottom box in the lab mockup)
        taQueueDisplay = new JTextArea();
        taQueueDisplay.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(taQueueDisplay);
        scrollPane.setBounds(20, 150, 425, 150);
        add(scrollPane);

        // Register Action Listeners
        addBtn.addActionListener(this);
        processBtn.addActionListener(this);
        showBtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // --- ADD JOB ---
        if (e.getSource() == addBtn) {
            String jobName = txtJobName.getText().trim();
            if (!jobName.isEmpty()) {
                jobQueue.offer(jobName); // <-- Ginamit ang offer() para sa queue
                JOptionPane.showMessageDialog(this, "Job added to the queue", "Info", JOptionPane.INFORMATION_MESSAGE);
                txtJobName.setText("");
                updateQueueDisplay();
            } else {
                JOptionPane.showMessageDialog(this, "Please enter a job name", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } 
        // --- PROCESS JOB ---
        else if (e.getSource() == processBtn) {
            if (!jobQueue.isEmpty()) {
                String processedJob = jobQueue.poll();
                JOptionPane.showMessageDialog(this, "Processed job: " + processedJob, "Message", JOptionPane.INFORMATION_MESSAGE);
                updateQueueDisplay();
            } else {
                JOptionPane.showMessageDialog(this, "No items in the queue", "Message", JOptionPane.INFORMATION_MESSAGE);
            }
        } 
        // --- SHOW QUEUE ---
        else if (e.getSource() == showBtn) {
            updateQueueDisplay();
            if (jobQueue.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No items in the queue", "Message", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    // Helper method na gumagamit lang ng String concatenation (+) sa halip na append()
    private void updateQueueDisplay() {
        if (jobQueue.isEmpty()) {
            taQueueDisplay.setText("");
        } else {
            String displayStr = "";
            int index = 1;
            for (String job : jobQueue) {
                displayStr = displayStr + index + ". " + job + "\n";
                index++;
            }
            taQueueDisplay.setText(displayStr);
        }
    }

}