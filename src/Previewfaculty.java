
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author user
 */
public class Previewfaculty extends javax.swing.JFrame {

   public Previewfaculty (String facultyName, String facultyID, String facultyPosition, String facultyDepartment, String gender, String facultyContact, byte[] photo) {
        initComponents();
         Name.setText( facultyName);
        facultyid.setText(facultyID);
        position.setText(facultyPosition);
        Department.setText(facultyDepartment);
        Gender.setText(gender);
        Contact.setText(facultyContact);
        // Handle photo (optional)
       if (photo != null) {
            try {
                // Convert the byte array back to a BufferedImage
                ByteArrayInputStream bis = new ByteArrayInputStream(photo);
                BufferedImage bufferedImage = ImageIO.read(bis);

                // Scale the image if necessary
                Image scaledImage = bufferedImage.getScaledInstance(image.getWidth(), image.getHeight(), Image.SCALE_SMOOTH);

                // Set the scaled image as an icon on the JLabel
                image.setIcon(new ImageIcon(scaledImage));

            } catch (IOException e) {
                e.printStackTrace();
                image.setText("Error loading image");
            }
        } else {
          image.setText("No photo uploaded");
        }


   }

    private Image resizeImage(Image originalImage, int targetWidth, int targetHeight) {
        BufferedImage bufferedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = bufferedImage.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);  // Use bicubic interpolation for better quality
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);  // Set rendering quality to high
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);  // Enable antialiasing for smoother edges
        g2d.drawImage(originalImage, 0, 0, targetWidth, targetHeight, null);
        g2d.dispose();
        return bufferedImage;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Back = new javax.swing.JButton();
        Download = new javax.swing.JButton();
        Name = new javax.swing.JTextField();
        facultyid = new javax.swing.JTextField();
        position = new javax.swing.JTextField();
        Contact = new javax.swing.JTextField();
        Department = new javax.swing.JTextField();
        Gender = new javax.swing.JTextField();
        image = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("Name:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("Faculty id:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, -1, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setText("Position:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, -1, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setText("Contact:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 240, -1, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setText("Department:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, -1, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setText("Gender:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 280, -1, -1));

        Back.setBackground(new java.awt.Color(51, 204, 0));
        Back.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Back.setForeground(new java.awt.Color(255, 255, 255));
        Back.setText("BACK");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });
        getContentPane().add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 480, -1, 30));

        Download.setBackground(new java.awt.Color(255, 0, 51));
        Download.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Download.setForeground(new java.awt.Color(255, 255, 255));
        Download.setText("DOWNLOAD");
        Download.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DownloadActionPerformed(evt);
            }
        });
        getContentPane().add(Download, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 480, -1, -1));

        Name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameActionPerformed(evt);
            }
        });
        getContentPane().add(Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 124, -1));

        facultyid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facultyidActionPerformed(evt);
            }
        });
        getContentPane().add(facultyid, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 200, 124, -1));
        getContentPane().add(position, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, 124, -1));

        Contact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContactActionPerformed(evt);
            }
        });
        getContentPane().add(Contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 240, 124, -1));
        getContentPane().add(Department, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, 124, -1));
        getContentPane().add(Gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 280, 124, -1));

        image.setText("jLabel8");
        getContentPane().add(image, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 111, 96));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pcte_ludhiana_cover.jpeg"))); // NOI18N
        jLabel8.setText("jLabel8");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 680, 130));

        jTextField1.setBackground(new java.awt.Color(255, 0, 0));
        jTextField1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setText("PCTE GROUP OF INSTITUTES");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 2, 580, 80));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pctelogo1.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 100, 90));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pantherfinal.png"))); // NOI18N
        jLabel9.setText("jLabel9");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 90, 200, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DownloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DownloadActionPerformed
   JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save Faculty Card");
        fileChooser.setSelectedFile(new File("faculty_card.png"));

        int userSelection = fileChooser.showSaveDialog(this);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            saveAsImage(fileToSave);
        }
    }

    // Method to capture the JFrame and save it as an image file
    private void saveAsImage(File file) {
        BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics();
        this.paint(g2d);  // Paints the content of the JFrame to the image
        g2d.dispose();

        try {
            ImageIO.write(image, "png", file);  // Save the image as PNG
            JOptionPane.showMessageDialog(this, "Faculty Card saved successfully.");
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error saving faculty card: " + ex.getMessage());
        }        // TODO add your handling code here:
    }//GEN-LAST:event_DownloadActionPerformed

    private void facultyidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facultyidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_facultyidActionPerformed

    private void NameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NameActionPerformed

    private void ContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ContactActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BackActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    /**
     * @param args the command line arguments
     */
  public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                  // Empty fields for test
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JTextField Contact;
    private javax.swing.JTextField Department;
    private javax.swing.JButton Download;
    private javax.swing.JTextField Gender;
    private javax.swing.JTextField Name;
    private javax.swing.JTextField facultyid;
    private javax.swing.JLabel image;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField position;
    // End of variables declaration//GEN-END:variables
}
