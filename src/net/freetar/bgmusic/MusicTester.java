/*
 * Copyright (C) 2006  Antonie Struyk
 *
 * This file is part of Freetar Hero.
 *
 *    Freetar Hero is free software; you can redistribute it and/or modify
 *    it under the terms of the GNU General Public License as published by
 *    the Free Software Foundation; either version 2 of the License, or
 *    (at your option) any later version.
 *
 *    Freetar Hero is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU General Public License for more details.
 *
 *    You should have received a copy of the GNU General Public License
 *    along with Freetar Hero; if not, write to the Free Software
 *    Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */

package net.freetar.bgmusic;

import net.freetar.util.FileUtils;
import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author  Anton
 */
public class MusicTester extends javax.swing.JFrame {
    private BackgroundMusic music;
    
    /** Creates new form MusicTester */
    public MusicTester() {
        initComponents();
        
        music = null;
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        playButton = new javax.swing.JButton();
        pauseButton = new javax.swing.JButton();
        stopButton = new javax.swing.JButton();
        startErrorButton = new javax.swing.JButton();
        stopErrorButton = new javax.swing.JButton();
        loadMusicButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        playButton.setText("Play");
        playButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playButtonActionPerformed(evt);
            }
        });

        pauseButton.setText("Pause");
        pauseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pauseButtonActionPerformed(evt);
            }
        });

        stopButton.setText("Stop");
        stopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopButtonActionPerformed(evt);
            }
        });

        startErrorButton.setText("Start Error Silence");
        startErrorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startErrorButtonActionPerformed(evt);
            }
        });

        stopErrorButton.setText("Stop Error Silence");
        stopErrorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopErrorButtonActionPerformed(evt);
            }
        });

        loadMusicButton.setText("LoadMusic");
        loadMusicButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadMusicButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(playButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(pauseButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(stopButton)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(stopErrorButton)
                    .add(startErrorButton))
                .add(39, 39, 39))
            .add(layout.createSequentialGroup()
                .add(60, 60, 60)
                .add(loadMusicButton)
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(playButton)
                    .add(pauseButton)
                    .add(stopButton))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(startErrorButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(stopErrorButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 59, Short.MAX_VALUE)
                .add(loadMusicButton)
                .addContainerGap())
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void stopErrorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopErrorButtonActionPerformed
        if(music != null){
            music.endErrorSilence();
        }
    }//GEN-LAST:event_stopErrorButtonActionPerformed

    private void startErrorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startErrorButtonActionPerformed
        if(music != null){
            music.beginErrorSilence();
        }
    }//GEN-LAST:event_startErrorButtonActionPerformed
    
    private void stopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopButtonActionPerformed
        if(music != null){
            music.stop();
        }
    }//GEN-LAST:event_stopButtonActionPerformed
    
    private void pauseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pauseButtonActionPerformed
        if(music != null){
            try {
                music.pause();
            } catch (BackgroundMusic.MusicException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_pauseButtonActionPerformed
    
    private void loadMusicButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadMusicButtonActionPerformed
        JFileChooser chooser = new JFileChooser(new File("."));
        chooser.addChoosableFileFilter(FileUtils.createFileFilter("mid, mp3, wav", "Music"));
        chooser.setDialogTitle("Choose A Peice Of Music");
        
        File selectedFile = null;
        if(chooser.showDialog(this, "Load") == JFileChooser.APPROVE_OPTION){
            selectedFile = chooser.getSelectedFile();
            if(selectedFile.exists()){
                try {
                    music = BackgroundMusic.loadMusicFrom(selectedFile);
                } catch (BackgroundMusic.MusicException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_loadMusicButtonActionPerformed
    
    private void playButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playButtonActionPerformed
        if(music != null){
            try {
                music.play();
            } catch (BackgroundMusic.MusicException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_playButtonActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MusicTester().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton loadMusicButton;
    private javax.swing.JButton pauseButton;
    private javax.swing.JButton playButton;
    private javax.swing.JButton startErrorButton;
    private javax.swing.JButton stopButton;
    private javax.swing.JButton stopErrorButton;
    // End of variables declaration//GEN-END:variables
    
}
