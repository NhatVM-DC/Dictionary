/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package AppFrame;
import static AppLogic.Translator.speech;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell
 */
public class searchFrame extends javax.swing.JFrame {

    /**
     * Creates new form searchFrame
     */
    public searchFrame() {
        initComponents();
    }
    public static String getDataFromJtext() {
        String res = "";
        res = inputString.getText();
        return res;
//        return inputString.getText();
    }
    public static String getDataFromJlist() {
        String res = listWords.getSelectedValue();
        return res;
    }
 
    public void dictionarySearcher(String keyWord){
        String sqlSearch = "SELECT * FROM av WHERE word LIKE ? ORDER BY word";
        try {
            Connection conn = AppLogic.DatabaseManagement.connectForUser();
            PreparedStatement ps  = conn.prepareStatement(sqlSearch);
            //truyền keyWord và cái % vào dấu ? ở string sqlSearch
            ps.setString(1,keyWord + "%");
            ResultSet rs  = ps.executeQuery();
            Vector<String> data = new Vector<>();
            while (rs.next()) {
                data.add(rs.getString("word"));
            }
            listWords.setListData(data);
            rs.close();
            ps.close();
            conn.close();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void printMeaning(String word) {
        String sqlSearch = "SELECT * FROM av WHERE word LIKE ?";
        try {
            Connection conn = AppLogic.DatabaseManagement.connectForUser();
            PreparedStatement ps  = conn.prepareStatement(sqlSearch);
            //truyền keyWord vào dấu ? ở string sqlSearch

            ps.setString(1,word);
            
            ResultSet rs  = ps.executeQuery();
            if (rs.next()) {
                showMeaning.setText(rs.getString("pro") + "\n" + rs.getString("mean"));
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        inputString = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        listenButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        listWords = new javax.swing.JList<>();
        editButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        showMeaning = new javax.swing.JEditorPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Search Tab");

        jPanel1.setBackground(new java.awt.Color(0, 51, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("UTM Daxline", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_Search_18px.png"))); // NOI18N
        jLabel1.setText(" SEARCH");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 230, -1));

        jPanel2.setBackground(new java.awt.Color(0, 51, 204));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("UTM Daxline", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-menu-17.png"))); // NOI18N
        jLabel2.setText("  Definition");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addContainerGap(176, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2))
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));

        inputString.setFont(new java.awt.Font("UTM Daxline", 1, 14)); // NOI18N
        inputString.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputStringActionPerformed(evt);
            }
        });
        inputString.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                inputStringKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                inputStringKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputStringKeyTyped(evt);
            }
        });

        searchButton.setBackground(new java.awt.Color(51, 51, 255));
        searchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_Search_18px.png"))); // NOI18N
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("UTM Daxline", 1, 12)); // NOI18N
        jLabel3.setText("Input the word:");

        listenButton.setBackground(new java.awt.Color(51, 51, 255));
        listenButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-audio-18.png"))); // NOI18N
        listenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listenButtonActionPerformed(evt);
            }
        });

        listWords.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                listWordsMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(listWords);

        editButton.setText("Edit Word");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(inputString, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchButton, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(listenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(listenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputString, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editButton)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        showMeaning.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jScrollPane1.setViewportView(showMeaning);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        String data = getDataFromJtext();
        dictionarySearcher(data);
    }//GEN-LAST:event_searchButtonActionPerformed

    private void inputStringActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputStringActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputStringActionPerformed

    private void inputStringKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputStringKeyPressed
        //if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String data = getDataFromJtext();
            dictionarySearcher(data);
        //}
    }//GEN-LAST:event_inputStringKeyPressed

    private void listenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listenButtonActionPerformed
        String data = getDataFromJlist();
        try {
            speech(data);
        } catch (IOException ex) {
            Logger.getLogger(searchFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_listenButtonActionPerformed

    private void listWordsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listWordsMousePressed
        String data = getDataFromJlist();
        printMeaning(data);
        inputString.setText(data);
        //dictionarySearcher(data);

    }//GEN-LAST:event_listWordsMousePressed

    private void inputStringKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputStringKeyReleased
        // TODO add your handling code here:
        String data = getDataFromJtext();
//        printMeaning(data);
        dictionarySearcher(data);

    }//GEN-LAST:event_inputStringKeyReleased

    private void inputStringKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputStringKeyTyped
        // TODO add your handling code here:
        String data = getDataFromJtext();
//        printMeaning(data);
        dictionarySearcher(data);
    }//GEN-LAST:event_inputStringKeyTyped

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        new editFrame().setVisible(true);
        String sqlSearch = "SELECT * FROM av WHERE word LIKE ?";
        try {
            Connection conn = AppLogic.DatabaseManagement.connectForUser();
            PreparedStatement ps  = conn.prepareStatement(sqlSearch);

            ps.setString(1,getDataFromJtext());

            ResultSet rs  = ps.executeQuery();
            if (rs.next()) {
                editFrame.proString.setText(rs.getString("pro"));
                editFrame.meanString.setText(rs.getString("mean"));
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_editButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new searchFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton editButton;
    private static javax.swing.JTextField inputString;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private static javax.swing.JList<String> listWords;
    private javax.swing.JButton listenButton;
    private javax.swing.JButton searchButton;
    private static javax.swing.JEditorPane showMeaning;
    // End of variables declaration//GEN-END:variables
}