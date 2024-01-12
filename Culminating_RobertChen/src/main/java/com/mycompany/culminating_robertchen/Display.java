/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.culminating_robertchen;

import java.awt.Color;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.Map;

/**
 *
 * @author 335091559
 */
import javax.swing.ImageIcon;
public class Display extends javax.swing.JFrame {

    /**
     * Creates new form Display
     */
    ImageIcon deletePNG = new ImageIcon("delete.png");
    int count1 = 0, count2 = 0, count3 = 0;
    public Display() {
        initComponents();
        String underline = "<html><u>Task Name</u></html>";
        activityName.setText(underline);
        
        getContentPane().setBackground(Color.orange);
        delete.setIcon(deletePNG);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        createPopUp = new javax.swing.JFrame();
        createTitle = new javax.swing.JLabel();
        startTime = new javax.swing.JLabel();
        timePicker1 = new com.github.lgooddatepicker.components.TimePicker();
        editPopUp = new javax.swing.JFrame();
        day = new javax.swing.JLabel();
        create = new javax.swing.JButton();
        panel1 = new java.awt.Panel();
        timeLabel = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        edit = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        subActivity1 = new javax.swing.JRadioButton();
        subActivity2 = new javax.swing.JRadioButton();
        subActivity3 = new javax.swing.JRadioButton();
        activityName = new javax.swing.JLabel();
        title = new javax.swing.JLabel();

        createTitle.setText("Create Task");
        createTitle.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N

        startTime.setText("Start Time:");

        javax.swing.GroupLayout createPopUpLayout = new javax.swing.GroupLayout(createPopUp.getContentPane());
        createPopUp.getContentPane().setLayout(createPopUpLayout);
        createPopUpLayout.setHorizontalGroup(
            createPopUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(createPopUpLayout.createSequentialGroup()
                .addGroup(createPopUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(createPopUpLayout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(createTitle))
                    .addGroup(createPopUpLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(startTime)))
                .addContainerGap(152, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, createPopUpLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(timePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97))
        );
        createPopUpLayout.setVerticalGroup(
            createPopUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(createPopUpLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(createTitle)
                .addGap(18, 18, 18)
                .addComponent(startTime)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                .addComponent(timePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117))
        );

        javax.swing.GroupLayout editPopUpLayout = new javax.swing.GroupLayout(editPopUp.getContentPane());
        editPopUp.getContentPane().setLayout(editPopUpLayout);
        editPopUpLayout.setHorizontalGroup(
            editPopUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        editPopUpLayout.setVerticalGroup(
            editPopUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        day.setText("Date");
        day.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        day.setForeground(new java.awt.Color(153, 153, 255));

        create.setText("Create Activity");
        create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createActionPerformed(evt);
            }
        });

        panel1.setBackground(new java.awt.Color(255, 178, 0));
        panel1.setForeground(new java.awt.Color(255, 153, 0));

        timeLabel.setText("Time:");
        timeLabel.setForeground(new java.awt.Color(51, 102, 255));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        edit.setText("Edit");

        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        subActivity1.setText("Sub-task 1");
        subActivity1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subActivity1ActionPerformed(evt);
            }
        });

        subActivity2.setText("Sub-task 2");
        subActivity2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subActivity2ActionPerformed(evt);
            }
        });

        subActivity3.setText("Sub-task 3");
        subActivity3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subActivity3ActionPerformed(evt);
            }
        });

        activityName.setText("Task Name");
        activityName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        activityName.setForeground(new java.awt.Color(51, 102, 255));

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(timeLabel)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(activityName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(subActivity1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 81, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(subActivity2, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(subActivity3, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator5)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(timeLabel))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(edit))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addGap(32, 32, 32)
                                        .addComponent(subActivity1)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(subActivity2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(subActivity3)))
                        .addGap(0, 6, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(activityName)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        title.setText("Daily Schedule");
        title.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        title.setForeground(new java.awt.Color(51, 153, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(day)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(title)
                .addGap(86, 86, 86)
                .addComponent(create)
                .addGap(28, 28, 28))
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(day)
                    .addComponent(create)
                    .addComponent(title))
                .addGap(24, 24, 24)
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createActionPerformed
        createPopUp.setSize(400, 675);
        createPopUp.setVisible(true);
    }//GEN-LAST:event_createActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteActionPerformed

    private void subActivity1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subActivity1ActionPerformed
        if (count1 == 0) {
            Font font = new Font("Segoe UI", Font.PLAIN, 12);
            Map attributes = font.getAttributes();
            attributes.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
            Font newFont = new Font(attributes);
            subActivity1.setFont(newFont);
            count1 ++;
        } else {
            Font font = new Font("Segoe UI", Font.PLAIN, 12);
            Map attributes = font.getAttributes();
            attributes.remove(TextAttribute.STRIKETHROUGH);
            Font newFont = new Font(attributes);
            subActivity1.setFont(font);
        }
    }//GEN-LAST:event_subActivity1ActionPerformed

    private void subActivity2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subActivity2ActionPerformed
        Font font = new Font("Segoe UI", Font.PLAIN, 12);
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
        Font newFont = new Font(attributes);
        subActivity2.setFont(newFont);
    }//GEN-LAST:event_subActivity2ActionPerformed

    private void subActivity3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subActivity3ActionPerformed
        Font font = new Font("Segoe UI", Font.PLAIN, 12);
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
        Font newFont = new Font(attributes);
        subActivity3.setFont(newFont);
    }//GEN-LAST:event_subActivity3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Display.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Display.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Display.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Display.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Display().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel activityName;
    private javax.swing.JButton create;
    private javax.swing.JFrame createPopUp;
    private javax.swing.JLabel createTitle;
    private javax.swing.JLabel day;
    private javax.swing.JButton delete;
    private javax.swing.JButton edit;
    private javax.swing.JFrame editPopUp;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private java.awt.Panel panel1;
    private javax.swing.JLabel startTime;
    private javax.swing.JRadioButton subActivity1;
    private javax.swing.JRadioButton subActivity2;
    private javax.swing.JRadioButton subActivity3;
    private javax.swing.JLabel timeLabel;
    private com.github.lgooddatepicker.components.TimePicker timePicker1;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
