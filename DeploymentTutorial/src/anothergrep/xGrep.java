/*
 * xGrep.java
 *
 * Created on March 3, 2006, 10:58 AM
 */

package anothergrep;

import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;

/**
 *
 * @author  Max Sauer
 */
public class xGrep extends javax.swing.JFrame {
    
    /** Creates new form xGrep */
    public xGrep() {
        initComponents();

    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        patternLabel = new javax.swing.JLabel();
        filenameLabel = new javax.swing.JLabel();
        patternTextField = new javax.swing.JTextField();
        filenameTextField = new javax.swing.JTextField();
        browseButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        outputTextArea = new javax.swing.JTextArea();
        outputLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        searchButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("xGrep");

        patternLabel.setDisplayedMnemonic('p');
        patternLabel.setLabelFor(patternTextField);
        patternLabel.setText("Search Pattern:");

        filenameLabel.setDisplayedMnemonic('f');
        filenameLabel.setLabelFor(filenameTextField);
        filenameLabel.setText("FileName:");

        patternTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patternTextFieldActionPerformed(evt);
            }
        });

        filenameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filenameTextFieldActionPerformed(evt);
            }
        });

        browseButton.setMnemonic('b');
        browseButton.setText("Browse...");
        browseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseButtonActionPerformed(evt);
            }
        });

        outputTextArea.setColumns(20);
        outputTextArea.setEditable(false);
        outputTextArea.setRows(5);
        jScrollPane1.setViewportView(outputTextArea);

        outputLabel.setLabelFor(outputTextArea);
        outputLabel.setText("Output:");

        searchButton.setMnemonic('s');
        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(filenameLabel)
                            .addComponent(patternLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(filenameTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                            .addComponent(patternTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(browseButton)
                            .addComponent(searchButton)))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
                    .addComponent(outputLabel))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {browseButton, searchButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(browseButton)
                    .addComponent(filenameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filenameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(patternLabel)
                    .addComponent(patternTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(outputLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        String pat = patternTextField.getText();
        String fileName = filenameTextField.getText();
        outputTextArea.setText("");
        if(pat.equals("")) {
            outputTextArea.setText("Cannot search for empty string...");
        } else if(fileName.equals("")) {
            outputTextArea.setText("No file has been specified...");
        } else {
            Grep.compile(pat);
            File f = new File(fileName);
            try {
                Grep.grep(f, outputTextArea);
                if(outputTextArea.getText().equals("")) {
                    outputTextArea.setText("No such pattern inside \"" + fileName + "\"");
                }
            } catch (IOException x) {
                outputTextArea.setText(f + ": " + x);
            }
        }
    }//GEN-LAST:event_searchButtonActionPerformed
    
    private void patternTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patternTextFieldActionPerformed
        searchButtonActionPerformed(evt);
    }//GEN-LAST:event_patternTextFieldActionPerformed
    
    private void filenameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filenameTextFieldActionPerformed
        browseButtonActionPerformed(evt);
    }//GEN-LAST:event_filenameTextFieldActionPerformed
    
    private void browseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseButtonActionPerformed
        fc = new JFileChooser();
        int returnVal = fc.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            filenameTextField.setText(fc.getSelectedFile().toString());
        }
    }//GEN-LAST:event_browseButtonActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new xGrep().setVisible(true);
            }
        });
    }
    
    private JFileChooser fc;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton browseButton;
    private javax.swing.JLabel filenameLabel;
    private javax.swing.JTextField filenameTextField;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel outputLabel;
    private javax.swing.JTextArea outputTextArea;
    private javax.swing.JLabel patternLabel;
    private javax.swing.JTextField patternTextField;
    private javax.swing.JButton searchButton;
    // End of variables declaration//GEN-END:variables
    
}
