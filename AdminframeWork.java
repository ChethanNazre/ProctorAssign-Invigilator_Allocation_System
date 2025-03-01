


import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UnsupportedLookAndFeelException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */


/**
 *
 * @author Ideathor
 */
public class AdminframeWork extends javax.swing.JFrame {

    /**
     * Creates new form AdminframeWork
     */
    public AdminframeWork() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        addAdmin = new javax.swing.JMenuItem();
        addFaculty = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        ManageUsers = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jDesktopPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/onlineexam/download.jpg"))); // NOI18N

        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(881, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(89, 89, 89))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(191, 191, 191)
                .addComponent(jLabel1)
                .addContainerGap(227, Short.MAX_VALUE))
        );

        jMenuBar1.setBackground(new java.awt.Color(255, 239, 238));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(233, 40));

        jMenu1.setText("   Administration");
        jMenu1.setFocusable(false);
        jMenu1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenu1.setMinimumSize(new java.awt.Dimension(1000, 60));
        jMenu1.setPreferredSize(new java.awt.Dimension(150, 60));
        jMenu1.setRolloverEnabled(false);
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Add");
        jMenu2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenu2.setPreferredSize(new java.awt.Dimension(60, 60));

        addAdmin.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        addAdmin.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        addAdmin.setText("Admin");
        addAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAdminActionPerformed(evt);
            }
        });
        jMenu2.add(addAdmin);

        addFaculty.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        addFaculty.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        addFaculty.setText("Manager");
        addFaculty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFacultyActionPerformed(evt);
            }
        });
        jMenu2.add(addFaculty);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Manage");
        jMenu3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenu3.setPreferredSize(new java.awt.Dimension(70, 60));

        ManageUsers.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        ManageUsers.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ManageUsers.setText("User");
        ManageUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManageUsersActionPerformed(evt);
            }
        });
        jMenu3.add(ManageUsers);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAdminActionPerformed
        // TODO add your handling code here:
                   addAdmin lf = new addAdmin();
            lf.setLocationRelativeTo(null);
            lf.setVisible(true);
            //dispose();
    }//GEN-LAST:event_addAdminActionPerformed

    private void ManageUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManageUsersActionPerformed
        // TODO add your handling code here:
                   ManageUsers lf = new ManageUsers();
            lf.setLocationRelativeTo(null);
            lf.setVisible(true);
             //dispose();
    }//GEN-LAST:event_ManageUsersActionPerformed

    private void addFacultyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFacultyActionPerformed
        // TODO add your handling code here:
           addManager lf = new addManager();
            lf.setLocationRelativeTo(null);
            lf.setVisible(true);
             //dispose();
    }//GEN-LAST:event_addFacultyActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jMenu1ActionPerformed

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
                    try {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    } catch (InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                        Logger.getLogger(AdminframeWork.class.getName()).log(Level.SEVERE, null, ex);
                    } 
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminframeWork.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new AdminframeWork().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem ManageUsers;
    private javax.swing.JMenuItem addAdmin;
    private javax.swing.JMenuItem addFaculty;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
