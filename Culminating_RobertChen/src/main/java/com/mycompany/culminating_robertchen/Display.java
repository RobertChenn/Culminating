/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.culminating_robertchen;

import java.awt.Color;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.Map;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import java.text.DateFormat;
import java.text.SimpleDateFormat; 
import java.util.*;  
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
    String eventName, beginTime, subtaskOne, subtaskTwo, subtaskThree, n, st, 
            et, sb1, sb2, sb3, selectedTask;
    boolean daily = false;
    int count1 = 0, count2 = 0, count3 = 0, scheduledHourToMili, scheduledMinuteToMili, 
            totalScheduledMili, currentHourToMili, currentMinuteToMili, totalCurrentMili, totalMili, currentSecondToMili, 
            currentRHourToMili, currentRMinuteToMili, currentRSecondToMili, totalRCurrentMili, 
            miliToReset = 24 * 3600000, totalResetMili;
    double length;
    char st1, st2, st3, st4, st5, st6, ct1, ct2, ct3, ct4, ct5, ct6, ct7, ct8;
    ArrayList<Task> tasks = new ArrayList<>();
    ArrayList<Task> addedTask = new ArrayList<>();
    ButtonGroup group = new ButtonGroup();
    
    public Display() {
        initComponents();
        String underline = "<html><u>Task Name</u></html>";
        activityName.setText(underline);
        group.add(yesCreate);
        group.add(noCreate);
        
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.orange);
        delete.setIcon(deletePNG);
    }
    
    // Checks if the text areas in the create popup are empty
    public boolean checkEmpty() {
        if (createPopUp.isVisible() == true)  {
            if (createTaskName.getText().isEmpty() || createStartTime.getText().isEmpty()
                    || createDuration.getText().isEmpty()) {
                return true;
            } else {
                return false;
            }
        } else {
            if (editTaskName.getText().isEmpty() || editStartTime.getText().isEmpty()
                    || editDuration.getText().isEmpty()) {
                return true;
            } else {
                return false;
            }
        }
    }
    
    // Clears everything on the create popup
    public void clear() {
        createTaskName.setText("");
        createStartTime.setText("");
        createDuration.setText("");
        createSubtask1.setText("");
        createSubtask2.setText("");
        createSubtask3.setText("");
        createOutput.setText("");
    }
    
    // Sets the task on the home page to have the information inputted in the create popup
    public void addTask(String task) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getName().equals(task)) {
                n = tasks.get(i).getName();
                activityName.setText(n);
                st = tasks.get(i).getStartTime();
                startTaskTime.setText(st);
                et = Double.toString(tasks.get(i).getDuration());
                durationTime.setText(et + " hours");
                sb1 = tasks.get(i).getSubtask1();
                subActivity1.setText(sb1);
                sb2 = tasks.get(i).getSubtask2();
                subActivity2.setText(sb2);
                sb3 = tasks.get(i).getSubtask3();
                subActivity3.setText(sb3);
                break;
            }
        }
    }
    
    // Gets the information of a task
    public void getTask(String task) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getName().equals(task)) {
                n = tasks.get(i).getName();
                editTaskName.setText(n);
                st = tasks.get(i).getStartTime();
                editStartTime.setText(st);
                et = Double.toString(tasks.get(i).getDuration());
                editDuration.setText(et);
                sb1 = tasks.get(i).getSubtask1();
                editSubtask1.setText(sb1);
                sb2 = tasks.get(i).getSubtask2();
                editSubtask2.setText(sb2);
                sb3 = tasks.get(i).getSubtask3();
                editSubtask3.setText(sb3);
                break;
            }
        }
    }
    
    // Gets the information
    public void getInfo(int selectedId) {
        n = addedTask.get(selectedId).getName();
        st = addedTask.get(selectedId).getStartTime();
        et = Double.toString(tasks.get(selectedId).getDuration());
        sb1 = addedTask.get(selectedId).getSubtask1();
        sb2 = addedTask.get(selectedId).getSubtask2();
        sb3 = addedTask.get(selectedId).getSubtask3();
    }
    
    // Edits the selected task
    public void editTask(String task, String na, String stt, double d, String sub1, 
            String sub2, String sub3) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getName().equals(task)) {
                tasks.get(i).setName(na);
                tasks.get(i).setStartTime(stt);
                tasks.get(i).setDuration(d);
                tasks.get(i).setSubtask1(sub1);
                tasks.get(i).setSubtask2(sub2);
                tasks.get(i).setSubtask3(sub3);
                activityName.setText(na);
                startTaskTime.setText(stt);
                durationTime.setText(d + " hours");
                subActivity1.setText(sub1);
                subActivity2.setText(sub2);
                subActivity3.setText(sub3);
                break;
            }
        }
    }
    
    // Deletes the selected task
    public void deleteTask(String task) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getName().equals(task)) {
                taskSelector.removeItem(tasks.get(i).getName());
                tasks.remove(i);
                break;
            }
        }
    }
    
    // Gets the difference in current time and time of event
    public int test() {
        StringBuilder builder = new StringBuilder();
        builder.append(st1);
        if (st2 != ':') {
            builder.append(st2);
        }
        String str = builder.toString();
        int hour = Integer.parseInt(str);

        if (st2 != ':') {
            if (st6 == 'p') {
                hour += 12;
            }
        } else {
            if (st5 == 'p') {
                hour += 12;
            }
        }

        scheduledHourToMili = hour * 3600000;

        StringBuilder timeBuilder = new StringBuilder();
        if (st2 != ':') {
            timeBuilder.append(st4);
            timeBuilder.append(st5);
        } else {
            timeBuilder.append(st3);
            timeBuilder.append(st4);
        }
        String min = timeBuilder.toString();
        int minute = Integer.parseInt(min);
        scheduledMinuteToMili = minute * 60000;

        totalScheduledMili = scheduledHourToMili + scheduledMinuteToMili;
        
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("HH:mm:ss");
        df.setTimeZone(TimeZone.getTimeZone("EST"));

        ct1 = df.format(date).charAt(0);
        ct2 = df.format(date).charAt(1);
        ct3 = df.format(date).charAt(2);
        ct4 = df.format(date).charAt(3);
        ct5 = df.format(date).charAt(4);
        ct6 = df.format(date).charAt(5);
        ct7 = df.format(date).charAt(6);
        ct8 = df.format(date).charAt(7);

        StringBuilder currentTimeHBuilder = new StringBuilder();
        currentTimeHBuilder.append(ct1);
        if (ct2 != ':') {
            currentTimeHBuilder.append(ct2);
        }
        String stri = currentTimeHBuilder.toString();
        int currentHour = Integer.parseInt(stri);

        currentHourToMili = currentHour * 3600000;

        StringBuilder currentTimeMBuilder = new StringBuilder();
        if (ct2 != ':') {
            currentTimeMBuilder.append(ct4);
            currentTimeMBuilder.append(ct5);
        } else {
            currentTimeMBuilder.append(ct3);
            currentTimeMBuilder.append(ct4);
        }
        String mini = currentTimeMBuilder.toString();
        int minutet = Integer.parseInt(mini);
        currentMinuteToMili = minutet * 60000;
        
        System.out.println("te");
        StringBuilder currentTimeSBuilder = new StringBuilder();
        if (ct2 != ':') {
            System.out.println("fa");
            currentTimeSBuilder.append(ct7);
            currentTimeSBuilder.append(ct8);
            System.out.println("fe");
        } else {
            System.out.println("ee");
            currentTimeSBuilder.append(ct6);
            currentTimeSBuilder.append(ct7);
            System.out.println("ef");
        }
        System.out.println("teee");
        String second = currentTimeSBuilder.toString();
        System.out.println(second);
        int sec = Integer.parseInt(second);
        System.out.println("st");
        currentSecondToMili = sec * 1000;
        System.out.println("t");
        totalCurrentMili = currentHourToMili + currentMinuteToMili + currentSecondToMili;
        System.out.println("ta");
        System.out.println(totalScheduledMili);
        System.out.println(totalCurrentMili);
        System.out.println(totalMili = totalScheduledMili - totalCurrentMili);
        return totalMili = totalScheduledMili - totalCurrentMili;
    }
    
    // Resets the tasks at the end of the day
    public int reset() {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("HH:mm:ss");
        df.setTimeZone(TimeZone.getTimeZone("EST"));

        ct1 = df.format(date).charAt(0);
        ct2 = df.format(date).charAt(1);
        ct3 = df.format(date).charAt(2);
        ct4 = df.format(date).charAt(3);
        ct5 = df.format(date).charAt(4);
        ct6 = df.format(date).charAt(5);
        ct7 = df.format(date).charAt(6);
        ct8 = df.format(date).charAt(7);

        StringBuilder currentTimeHBuilder = new StringBuilder();
        currentTimeHBuilder.append(ct1);
        if (ct2 != ':') {
            currentTimeHBuilder.append(ct2);
        }
        String stri = currentTimeHBuilder.toString();
        int currentHour = Integer.parseInt(stri);

        currentRHourToMili = currentHour * 3600000;

        StringBuilder currentTimeMBuilder = new StringBuilder();
        if (ct2 != ':') {
            currentTimeMBuilder.append(ct4);
            currentTimeMBuilder.append(ct5);
        } else {
            currentTimeMBuilder.append(ct3);
            currentTimeMBuilder.append(ct4);
        }
        String mini = currentTimeMBuilder.toString();
        int minutet = Integer.parseInt(mini);
        currentRMinuteToMili = minutet * 60000;

        System.out.println("te");
        StringBuilder currentTimeSBuilder = new StringBuilder();
        if (ct2 != ':') {
            System.out.println("fa");
            currentTimeSBuilder.append(ct7);
            currentTimeSBuilder.append(ct8);
            System.out.println("fe");
        } else {
            System.out.println("ee");
            currentTimeSBuilder.append(ct6);
            currentTimeSBuilder.append(ct7);
            System.out.println("ef");
        }
        System.out.println("teee");
        String second = currentTimeSBuilder.toString();
        System.out.println(second);
        int sec = Integer.parseInt(second);
        System.out.println("st");
        currentRSecondToMili = sec * 1000;
        System.out.println("t");
        totalRCurrentMili = currentRHourToMili + currentRMinuteToMili + currentRSecondToMili;
        
        return totalResetMili = miliToReset - totalRCurrentMili;
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
        createStartTimePrompt = new javax.swing.JLabel();
        createStartTime = new com.github.lgooddatepicker.components.TimePicker();
        createTaskNamePrompt = new javax.swing.JLabel();
        createSubtask1Prompt = new javax.swing.JLabel();
        createSubtask2Prompt = new javax.swing.JLabel();
        createSubtask3Prompt = new javax.swing.JLabel();
        createTaskName = new javax.swing.JTextField();
        createSubtask1 = new javax.swing.JTextField();
        createSubtask2 = new javax.swing.JTextField();
        createSubtask3 = new javax.swing.JTextField();
        createRepeatingTaskPrompt = new javax.swing.JLabel();
        yesCreate = new javax.swing.JToggleButton();
        noCreate = new javax.swing.JToggleButton();
        createTask = new javax.swing.JButton();
        createOutput = new javax.swing.JTextField();
        createDuration = new javax.swing.JTextField();
        createDurationPrompt = new javax.swing.JLabel();
        editPopUp = new javax.swing.JFrame();
        editTaskNamePrompt = new javax.swing.JLabel();
        editTask = new javax.swing.JButton();
        editSubtask1Prompt = new javax.swing.JLabel();
        editOutput = new javax.swing.JTextField();
        editSubtask2Prompt = new javax.swing.JLabel();
        editSubtask3Prompt = new javax.swing.JLabel();
        editTaskName = new javax.swing.JTextField();
        editSubtask1 = new javax.swing.JTextField();
        editCreateTitle = new javax.swing.JLabel();
        editSubtask2 = new javax.swing.JTextField();
        editStartTimePrompt = new javax.swing.JLabel();
        editSubtask3 = new javax.swing.JTextField();
        editStartTime = new com.github.lgooddatepicker.components.TimePicker();
        editRepeatingTaskPrompt = new javax.swing.JLabel();
        editDurationPrompt = new javax.swing.JLabel();
        yesEdit = new javax.swing.JToggleButton();
        noEdit = new javax.swing.JToggleButton();
        editDuration = new javax.swing.JTextField();
        buttonGroup = new javax.swing.ButtonGroup();
        notification = new javax.swing.JFrame();
        notificationTitle = new javax.swing.JLabel();
        panel2 = new java.awt.Panel();
        notificationMessage = new javax.swing.JLabel();
        day = new javax.swing.JLabel();
        create = new javax.swing.JButton();
        panel1 = new java.awt.Panel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        edit = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        subActivity1 = new javax.swing.JRadioButton();
        subActivity2 = new javax.swing.JRadioButton();
        subActivity3 = new javax.swing.JRadioButton();
        activityName = new javax.swing.JLabel();
        startTaskTime = new javax.swing.JLabel();
        startTimeLabel = new javax.swing.JLabel();
        durationLabel = new javax.swing.JLabel();
        durationTime = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        taskSelector = new javax.swing.JComboBox<>();
        homeOutput = new javax.swing.JTextField();

        createTitle.setText("Create Task");
        createTitle.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        createTitle.setForeground(new java.awt.Color(51, 153, 255));

        createStartTimePrompt.setText("Start Time:");

        createTaskNamePrompt.setText("Task Name:");

        createSubtask1Prompt.setText("Subtask 1:");

        createSubtask2Prompt.setText("Subtask 2:");

        createSubtask3Prompt.setText("Subtask 3:");

        createRepeatingTaskPrompt.setText("Repeating Task:");

        yesCreate.setText("Yes");
        yesCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yesCreateActionPerformed(evt);
            }
        });

        noCreate.setText("No");
        noCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noCreateActionPerformed(evt);
            }
        });

        createTask.setText("Create");
        createTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createTaskActionPerformed(evt);
            }
        });

        createOutput.setEditable(false);

        createDurationPrompt.setText("Duration (Hours):");

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
                        .addGroup(createPopUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(createPopUpLayout.createSequentialGroup()
                                .addComponent(createTaskNamePrompt)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(createTaskName, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(createPopUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, createPopUpLayout.createSequentialGroup()
                                    .addGap(156, 156, 156)
                                    .addComponent(createTask, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(106, 106, 106))
                                .addGroup(createPopUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, createPopUpLayout.createSequentialGroup()
                                        .addComponent(createSubtask3Prompt)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(createSubtask3))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, createPopUpLayout.createSequentialGroup()
                                        .addComponent(createSubtask2Prompt)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(createSubtask2))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, createPopUpLayout.createSequentialGroup()
                                        .addComponent(createSubtask1Prompt)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(createSubtask1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(createOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(createPopUpLayout.createSequentialGroup()
                                    .addGap(39, 39, 39)
                                    .addComponent(createRepeatingTaskPrompt)
                                    .addGap(18, 18, 18)
                                    .addComponent(yesCreate)
                                    .addGap(30, 30, 30)
                                    .addComponent(noCreate))
                                .addGroup(createPopUpLayout.createSequentialGroup()
                                    .addComponent(createDurationPrompt)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(createDuration, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(createPopUpLayout.createSequentialGroup()
                                    .addComponent(createStartTimePrompt)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(createStartTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        createPopUpLayout.setVerticalGroup(
            createPopUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(createPopUpLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(createTitle)
                .addGap(36, 36, 36)
                .addGroup(createPopUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createTaskNamePrompt, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(createTaskName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(createPopUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createStartTimePrompt)
                    .addComponent(createStartTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(createPopUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createDurationPrompt)
                    .addComponent(createDuration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(createPopUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createSubtask1Prompt)
                    .addComponent(createSubtask1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(createPopUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createSubtask2Prompt)
                    .addComponent(createSubtask2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(createPopUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createSubtask3Prompt)
                    .addComponent(createSubtask3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(createPopUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createRepeatingTaskPrompt)
                    .addComponent(yesCreate)
                    .addComponent(noCreate))
                .addGap(18, 18, 18)
                .addComponent(createTask)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(createOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        editTaskNamePrompt.setText("Task Name:");

        editTask.setText("Edit");
        editTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editTaskActionPerformed(evt);
            }
        });

        editSubtask1Prompt.setText("Subtask 1:");

        editOutput.setEditable(false);

        editSubtask2Prompt.setText("Subtask 2:");

        editSubtask3Prompt.setText("Subtask 3:");

        editCreateTitle.setText("Edit Task");
        editCreateTitle.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        editCreateTitle.setForeground(new java.awt.Color(51, 153, 255));

        editStartTimePrompt.setText("Start Time:");

        editRepeatingTaskPrompt.setText("Repeating Task:");

        editDurationPrompt.setText("Duration (Hours):");

        yesEdit.setText("Yes");
        yesEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yesEditActionPerformed(evt);
            }
        });

        noEdit.setText("No");
        noEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noEditActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout editPopUpLayout = new javax.swing.GroupLayout(editPopUp.getContentPane());
        editPopUp.getContentPane().setLayout(editPopUpLayout);
        editPopUpLayout.setHorizontalGroup(
            editPopUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editPopUpLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(editPopUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editPopUpLayout.createSequentialGroup()
                        .addComponent(editStartTimePrompt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editStartTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(editPopUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(editPopUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, editPopUpLayout.createSequentialGroup()
                                .addComponent(editSubtask3Prompt)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editSubtask3))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, editPopUpLayout.createSequentialGroup()
                                .addComponent(editSubtask2Prompt)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editSubtask2))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, editPopUpLayout.createSequentialGroup()
                                .addComponent(editSubtask1Prompt)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editSubtask1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(editPopUpLayout.createSequentialGroup()
                            .addGap(39, 39, 39)
                            .addComponent(editRepeatingTaskPrompt)
                            .addGap(18, 18, 18)
                            .addComponent(yesEdit)
                            .addGap(30, 30, 30)
                            .addComponent(noEdit))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editPopUpLayout.createSequentialGroup()
                            .addGap(124, 124, 124)
                            .addGroup(editPopUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(editCreateTitle)
                                .addComponent(editTask, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(53, 53, 53)))
                    .addGroup(editPopUpLayout.createSequentialGroup()
                        .addComponent(editTaskNamePrompt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editTaskName, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(editPopUpLayout.createSequentialGroup()
                        .addComponent(editDurationPrompt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(editDuration, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(editOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        editPopUpLayout.setVerticalGroup(
            editPopUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editPopUpLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(editCreateTitle)
                .addGap(28, 28, 28)
                .addGroup(editPopUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editTaskNamePrompt, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editTaskName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(editPopUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editStartTimePrompt)
                    .addComponent(editStartTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(editPopUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editDurationPrompt)
                    .addComponent(editDuration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(editPopUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editSubtask1Prompt)
                    .addComponent(editSubtask1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(editPopUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editSubtask2Prompt)
                    .addComponent(editSubtask2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(editPopUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editSubtask3Prompt)
                    .addComponent(editSubtask3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(editPopUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editRepeatingTaskPrompt)
                    .addComponent(yesEdit)
                    .addComponent(noEdit))
                .addGap(18, 18, 18)
                .addComponent(editTask)
                .addGap(18, 18, 18)
                .addComponent(editOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        notificationTitle.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        notificationTitle.setForeground(new java.awt.Color(51, 153, 255));
        notificationTitle.setText("Time to work!");

        panel2.setBackground(new java.awt.Color(255, 153, 0));

        notificationMessage.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        notificationMessage.setText("Your task is taking place now!");

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                .addContainerGap(82, Short.MAX_VALUE)
                .addComponent(notificationMessage)
                .addGap(76, 76, 76))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(notificationMessage)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout notificationLayout = new javax.swing.GroupLayout(notification.getContentPane());
        notification.getContentPane().setLayout(notificationLayout);
        notificationLayout.setHorizontalGroup(
            notificationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(notificationLayout.createSequentialGroup()
                .addGroup(notificationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(notificationLayout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(notificationTitle))
                    .addGroup(notificationLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        notificationLayout.setVerticalGroup(
            notificationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(notificationLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(notificationTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
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

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        edit.setText("Edit");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

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

        startTaskTime.setText("12:00am");

        startTimeLabel.setText("Start Time:");
        startTimeLabel.setForeground(new java.awt.Color(51, 102, 255));

        durationLabel.setText("Duration:");
        durationLabel.setForeground(new java.awt.Color(51, 102, 255));

        durationTime.setText("2 hours");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(startTaskTime))
                            .addComponent(startTimeLabel))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(durationLabel)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(durationTime)))
                        .addGap(22, 22, 22)))
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
                                .addGap(0, 58, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(subActivity2, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(subActivity3, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(139, Short.MAX_VALUE))))
            .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator5)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(startTimeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(startTaskTime)
                        .addGap(18, 18, 18)
                        .addComponent(durationLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(durationTime))
                    .addComponent(edit)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(subActivity1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(subActivity2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(subActivity3))
                    .addComponent(activityName)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        title.setText("Daily Schedule");
        title.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        title.setForeground(new java.awt.Color(51, 153, 255));

        taskSelector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                taskSelectorActionPerformed(evt);
            }
        });

        homeOutput.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(day)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(taskSelector, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(39, 39, 39)
                .addComponent(title)
                .addGap(59, 59, 59)
                .addComponent(create)
                .addGap(28, 28, 28))
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(homeOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(day)
                    .addComponent(create)
                    .addComponent(title)
                    .addComponent(taskSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(homeOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createActionPerformed
        clear();
        createPopUp.setSize(400, 533);
        createPopUp.getContentPane().setBackground(Color.orange);
        createPopUp.setLocationRelativeTo(null);
        createPopUp.setVisible(true);
    }//GEN-LAST:event_createActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        if (taskSelector.getItemCount() > 0) {
            deleteTask(selectedTask);
            if (taskSelector.getItemCount() == 0) {
                activityName.setText("Task Name");
                startTaskTime.setText("12:00am");
                durationTime.setText("2 hours");
                subActivity1.setText("Sub-task 1");
                subActivity2.setText("Sub-task 2");
                subActivity3.setText("Sub-task 3");
            } else {
                addTask(selectedTask);
            }
        } else {
            homeOutput.setText("You cannot delete the example task");
        }
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
            count1 = 0;
        }
    }//GEN-LAST:event_subActivity1ActionPerformed

    private void subActivity2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subActivity2ActionPerformed
        if (count2 == 0) {
            Font font = new Font("Segoe UI", Font.PLAIN, 12);
            Map attributes = font.getAttributes();
            attributes.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
            Font newFont = new Font(attributes);
            subActivity2.setFont(newFont);
            count2++;
        } else {
            Font font = new Font("Segoe UI", Font.PLAIN, 12);
            Map attributes = font.getAttributes();
            attributes.remove(TextAttribute.STRIKETHROUGH);
            Font newFont = new Font(attributes);
            subActivity2.setFont(font);
            count2 = 0;
        }
    }//GEN-LAST:event_subActivity2ActionPerformed

    private void subActivity3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subActivity3ActionPerformed
        if (count3 == 0) {
            Font font = new Font("Segoe UI", Font.PLAIN, 12);
            Map attributes = font.getAttributes();
            attributes.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
            Font newFont = new Font(attributes);
            subActivity3.setFont(newFont);
            count3++;
        } else {
            Font font = new Font("Segoe UI", Font.PLAIN, 12);
            Map attributes = font.getAttributes();
            attributes.remove(TextAttribute.STRIKETHROUGH);
            Font newFont = new Font(attributes);
            subActivity3.setFont(font);
            count3 = 0;
        }
    }//GEN-LAST:event_subActivity3ActionPerformed

    private void yesCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yesCreateActionPerformed
        daily = true;
    }//GEN-LAST:event_yesCreateActionPerformed

    private void noCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noCreateActionPerformed
        daily = false;
    }//GEN-LAST:event_noCreateActionPerformed

    private void createTaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createTaskActionPerformed
        subtaskOne = createSubtask1.getText();
        subtaskTwo = createSubtask2.getText(); 
        subtaskThree = createSubtask3.getText();
        addedTask.clear();
        
        try {
            eventName = createTaskName.getText();
            beginTime = createStartTime.getText();
            length = Double.parseDouble(createDuration.getText());
            
            if (checkEmpty() == false) {
                if (length <= 24) {
                    st1 = createStartTime.getText().charAt(0);
                    st2 = createStartTime.getText().charAt(1);
                    st3 = createStartTime.getText().charAt(2);
                    st4 = createStartTime.getText().charAt(3);
                    st5 = createStartTime.getText().charAt(4);
                    st6 = createStartTime.getText().charAt(5);
                    
                    if (createSubtask1.getText().isEmpty()) {
                        subtaskOne = "N/A";
                    }
                    if (createSubtask2.getText().isEmpty()) {
                        subtaskTwo = "N/A";
                    }
                    if (createSubtask3.getText().isEmpty()) {
                        subtaskThree = "N/A";
                    }

                    Task newTask = new Task(eventName, beginTime, length, subtaskOne, subtaskTwo,
                            subtaskThree, daily);
                    System.out.println("a");
                    tasks.add(newTask);
                    addedTask.add(newTask);
                    taskSelector.addItem(newTask.getName());
                    clear();
                    group.clearSelection();
                    System.out.println("3");
                    test();
                    System.out.println("e");
                    if (totalMili > 0) {
                        new java.util.Timer().schedule(
                                new java.util.TimerTask() {
                            @Override
                            public void run() {
                                notification.setSize(400, 188);
                                notification.setLocationRelativeTo(null);
                                notification.getContentPane().setBackground(Color.orange);
                                notification.setVisible(true);
                            }
                        }, totalMili
                        );
                    }
                    reset();
                    if (totalResetMili > 0) {
                        new java.util.Timer().schedule(
                                new java.util.TimerTask() {
                            @Override
                            public void run() {
                                for (int i = 0; i < tasks.size(); i++) {
                                    if (tasks.get(i).getRepeating() == false) {
                                        taskSelector.removeItem(tasks.get(i).getName());
                                        tasks.remove(i);
                                        if (taskSelector.getItemCount() == 0) {
                                            activityName.setText("Task Name");
                                            startTaskTime.setText("12:00am");
                                            durationTime.setText("2 hours");
                                            subActivity1.setText("Sub-task 1");
                                            subActivity2.setText("Sub-task 2");
                                            subActivity3.setText("Sub-task 3");
                                        } else {
                                            addTask(selectedTask);
                                        }
                                        break;
                                    }
                                }
                            }
                        }, totalResetMili
                        );
                    }
                    System.out.println("1");
                    createPopUp.setVisible(false);
                } else {
                    createOutput.setText("Duration of the task can not be longer than 24 hours");
                }
            } else {
                createOutput.setText("Please make sure you filled out every field");
            }
        } catch (Exception e) {
            createOutput.setText("Please make sure you filled out every field, the duration is a number, and the time is valid");
        }
    }//GEN-LAST:event_createTaskActionPerformed

    private void editTaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editTaskActionPerformed
        subtaskOne = editSubtask1.getText();
        subtaskTwo = editSubtask2.getText();
        subtaskThree = editSubtask3.getText();

        try {
            eventName = editTaskName.getText();
            beginTime = editStartTime.getText();
            length = Double.parseDouble(editDuration.getText());

            if (checkEmpty() == false) {
                System.out.println("a");
                if (length <= 24) {
                    System.out.println("1");
                    st1 = editStartTime.getText().charAt(0);
                    st2 = editStartTime.getText().charAt(1);
                    st3 = editStartTime.getText().charAt(2);
                    st4 = editStartTime.getText().charAt(3);
                    st5 = editStartTime.getText().charAt(4);
                    st6 = editStartTime.getText().charAt(5);
                    
                    System.out.println("f");
                    if (editSubtask1.getText().isEmpty()) {
                        subtaskOne = "N/A";
                    }
                    if (editSubtask2.getText().isEmpty()) {
                        subtaskTwo = "N/A";
                    }
                    if (editSubtask3.getText().isEmpty()) {
                        subtaskThree = "N/A";
                    }
                    System.out.println(selectedTask);
                    editTask(selectedTask, eventName, beginTime, length, subtaskOne,
                            subtaskTwo, subtaskThree);
                    System.out.println(subtaskTwo);
                    test();
                    if (totalMili > 0) {
                        new java.util.Timer().schedule(
                                new java.util.TimerTask() {
                            @Override
                            public void run() {
                                notification.setSize(400, 188);
                                notification.setLocationRelativeTo(null);
                                notification.getContentPane().setBackground(Color.orange);
                                notification.setVisible(true);
                            }
                        }, totalMili
                        );
                    }
                    editPopUp.setVisible(false);  
                } else {
                    editOutput.setText("Duration of the task can not be longer than 24 hours");
                }
            } else {
                editOutput.setText("Please make sure you filled out every field");
            }
        } catch (Exception e) {
            editOutput.setText("Please make sure you filled out every field, the duration is a number, and the time is valid");
        }
    }//GEN-LAST:event_editTaskActionPerformed

    private void yesEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yesEditActionPerformed
        daily = true;
    }//GEN-LAST:event_yesEditActionPerformed

    private void noEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noEditActionPerformed
        daily = false;
    }//GEN-LAST:event_noEditActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        if (tasks.isEmpty()) {
            homeOutput.setText("You cannot edit the example task");
        } else {
            editPopUp.setSize(400, 513);
            editPopUp.getContentPane().setBackground(Color.orange);
            editPopUp.setLocationRelativeTo(null);
            editPopUp.setVisible(true);
            getTask(selectedTask);
        }
    }//GEN-LAST:event_editActionPerformed

    private void taskSelectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_taskSelectorActionPerformed
        selectedTask = String.valueOf(taskSelector.getSelectedItem());
        addTask(selectedTask);
    }//GEN-LAST:event_taskSelectorActionPerformed

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
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JButton create;
    private javax.swing.JTextField createDuration;
    private javax.swing.JLabel createDurationPrompt;
    private javax.swing.JTextField createOutput;
    private javax.swing.JFrame createPopUp;
    private javax.swing.JLabel createRepeatingTaskPrompt;
    private com.github.lgooddatepicker.components.TimePicker createStartTime;
    private javax.swing.JLabel createStartTimePrompt;
    private javax.swing.JTextField createSubtask1;
    private javax.swing.JLabel createSubtask1Prompt;
    private javax.swing.JTextField createSubtask2;
    private javax.swing.JLabel createSubtask2Prompt;
    private javax.swing.JTextField createSubtask3;
    private javax.swing.JLabel createSubtask3Prompt;
    private javax.swing.JButton createTask;
    private javax.swing.JTextField createTaskName;
    private javax.swing.JLabel createTaskNamePrompt;
    private javax.swing.JLabel createTitle;
    private javax.swing.JLabel day;
    private javax.swing.JButton delete;
    private javax.swing.JLabel durationLabel;
    private javax.swing.JLabel durationTime;
    private javax.swing.JButton edit;
    private javax.swing.JLabel editCreateTitle;
    private javax.swing.JTextField editDuration;
    private javax.swing.JLabel editDurationPrompt;
    private javax.swing.JTextField editOutput;
    private javax.swing.JFrame editPopUp;
    private javax.swing.JLabel editRepeatingTaskPrompt;
    private com.github.lgooddatepicker.components.TimePicker editStartTime;
    private javax.swing.JLabel editStartTimePrompt;
    private javax.swing.JTextField editSubtask1;
    private javax.swing.JLabel editSubtask1Prompt;
    private javax.swing.JTextField editSubtask2;
    private javax.swing.JLabel editSubtask2Prompt;
    private javax.swing.JTextField editSubtask3;
    private javax.swing.JLabel editSubtask3Prompt;
    private javax.swing.JButton editTask;
    private javax.swing.JTextField editTaskName;
    private javax.swing.JLabel editTaskNamePrompt;
    private javax.swing.JTextField homeOutput;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JToggleButton noCreate;
    private javax.swing.JToggleButton noEdit;
    private javax.swing.JFrame notification;
    private javax.swing.JLabel notificationMessage;
    private javax.swing.JLabel notificationTitle;
    private java.awt.Panel panel1;
    private java.awt.Panel panel2;
    private javax.swing.JLabel startTaskTime;
    private javax.swing.JLabel startTimeLabel;
    private javax.swing.JRadioButton subActivity1;
    private javax.swing.JRadioButton subActivity2;
    private javax.swing.JRadioButton subActivity3;
    private javax.swing.JComboBox<String> taskSelector;
    private javax.swing.JLabel title;
    private javax.swing.JToggleButton yesCreate;
    private javax.swing.JToggleButton yesEdit;
    // End of variables declaration//GEN-END:variables
}
