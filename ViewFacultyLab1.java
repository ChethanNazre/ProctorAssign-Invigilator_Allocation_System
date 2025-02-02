/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Ideathor
 */
import java.awt.BorderLayout;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class ViewFacultyLab1 extends JFrame {
        private JButton executeButton;
    private JButton refreshButton; // New Refresh Button
    private JTextArea resultTextArea;

    private final JTable table;

      public ViewFacultyLab1() {
        setTitle("Faculty Allotment");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        
             executeButton = new JButton("Refresh");
        executeButton.addActionListener(e -> {
            try {
                executeQuery();
            } catch (PrinterException ex) {
                Logger.getLogger(ViewFacultyAllot.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        refreshButton = new JButton("Print");
        refreshButton.addActionListener(e -> {
            try {
                refreshContent();
            } catch (PrinterException ex) {
                Logger.getLogger(ViewFacultyAllot.class.getName()).log(Level.SEVERE, null, ex);
            }
        }); // Action listener for Refresh button
        
        resultTextArea = new JTextArea();
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(executeButton);
        buttonPanel.add(refreshButton); // Add Refresh button to the panel
        
        add(buttonPanel, BorderLayout.NORTH); // Add button panel to the frame's north
        add(resultTextArea, BorderLayout.CENTER);
    

        // Create columns
        String[] columns = {"LabName", "FacultyID", "FacultyName"}; // Replace with your column names

        // Create table model
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        // Populate table model with data from database
        try {
            // Connect to the database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineexam", "root", "2003");
            
            // Create statement
            Statement statement = connection.createStatement();
            
ResultSet resultSet = statement.executeQuery("SELECT\n" +
"    LabName,\n" +
"    facultyId,\n" +
"    facultyName\n" +
"FROM (\n" +
"    SELECT\n" +
"        c.LabName,\n" +
"        f.facultyId,\n" +
"        f.facultyName,\n" +
"        ROW_NUMBER() OVER (PARTITION BY c.LabName ORDER BY RAND()) AS row_num\n" +
"    FROM (\n" +
"        SELECT DISTINCT\n" +
"            LabName\n" +
"        FROM\n" +
"            lab\n" +
"    ) c\n" +
"    JOIN\n" +
"        faculty f ON c.LabName = c.LabName\n" +
") AS ranked_faculty\n" +
"WHERE\n" +
"    row_num = 1;");



            // Populate table model with query results
            while (resultSet.next()) {
                Object[] row = {
                    resultSet.getString("LabName"),
                    resultSet.getString("FacultyID"),
                    resultSet.getString("FacultyName")
                }; // Replace with your column names
                model.addRow(row);
            }

            // Close resources
            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        // Create JTable with table model
        table = new JTable(model);

        // Add table to scroll pane
        JScrollPane scrollPane = new JScrollPane(table);

        // Add scroll pane to frame
        add(scrollPane);
    
     
    }

    public static void main(String[] args) {

             try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewExamDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewExamDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewExamDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewExamDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        SwingUtilities.invokeLater(() -> {
            ViewFacultyAllot frame = new ViewFacultyAllot();
            frame.setVisible(true);
        });
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1266, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 637, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void refreshContent() throws PrinterException {
    executeQuery();
        try {
        printTable(table);
    } catch (PrinterException ex) {
        ex.printStackTrace();
    }
    }
private void printTable(JTable table) throws PrinterException {
    boolean complete = table.print();
    if (complete) {
        System.out.println("Print job completed successfully");
    } else {
        System.out.println("Print job cancelled");
    }
}
    

    private void executeQuery() throws PrinterException {
                DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        
    try( Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineexam", "root", "2003")) {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT\n" +
"    LabName,\n" +
"    facultyId,\n" +
"    facultyName\n" +
"FROM (\n" +
"    SELECT\n" +
"        c.LabName,\n" +
"        f.facultyId,\n" +
"        f.facultyName,\n" +
"        ROW_NUMBER() OVER (PARTITION BY c.LabName ORDER BY RAND()) AS row_num\n" +
"    FROM (\n" +
"        SELECT DISTINCT\n" +
"            LabName\n" +
"        FROM\n" +
"            lab\n" +
"    ) c\n" +
"    JOIN\n" +
"        faculty f ON c.LabName = c.LabName\n" +
") AS ranked_faculty\n" +
"WHERE\n" +
"    row_num = 1;");
        
        
while (rs.next()) {
                Object[] row = {
                    rs.getString("LabName"),
                    rs.getString("FacultyID"),
                    rs.getString("FacultyName")
                }; // Replace with your column names
                model.addRow(row);
            }
                     rs.close();
            stmt.close();


    } 
    catch (SQLException ex) //| PrinterException ex) {
           { ex.printStackTrace();
    }
}


}







    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

