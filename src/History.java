import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.*;
import javax.imageio.ImageIO;

public class History extends JFrame {

    private JTable studentTable;

    public History() {
        initComponents();
        loadStudentDetails();
    }

    private void initComponents() {
        JScrollPane scrollPane = new JScrollPane();
        studentTable = new JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        studentTable.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{"Name", "Father's Name", "Roll No", "Contact", "Course", "Year", "Address", "Blood Group", "DOB", "Photo"}
        ));

        scrollPane.setViewportView(studentTable);
        getContentPane().add(scrollPane, java.awt.BorderLayout.CENTER);

        setTitle("Student History");
        setSize(1000, 500);
    }

    private void loadStudentDetails() {
        String url = "jdbc:mysql://localhost:3306/idcard";
        String username = "root";
        String password = "";  // Use your own database password

        DefaultTableModel model = (DefaultTableModel) studentTable.getModel();
        studentTable.setRowHeight(100); // Set row height for the images

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM students";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String studentName = rs.getString("name");
                String fatherName = rs.getString("fathers_name");
                String rollNumber = rs.getString("roll_no");
                String contactNumber = rs.getString("contact");
                String studentCourse = rs.getString("course");
                String studyYear = rs.getString("year_of_study");
                String studentAddress = rs.getString("address");
                String bloodGroup = rs.getString("blood_group");
                Date dob = rs.getDate("dob");
                byte[] photoData = rs.getBytes("photo");

                // Convert photo data into ImageIcon
                ImageIcon imageIcon = null;
                if (photoData != null && photoData.length > 0) {
                    try {
                        BufferedImage img = ImageIO.read(new ByteArrayInputStream(photoData));
                        Image scaledImg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                        imageIcon = new ImageIcon(scaledImg);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                // Add student details to the table
                model.addRow(new Object[]{
                        studentName, fatherName, rollNumber, contactNumber,
                        studentCourse, studyYear, studentAddress, bloodGroup, dob, imageIcon
                });
            }

            // Close connections
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Set custom renderer to display images in the table
        studentTable.getColumn("Photo").setCellRenderer(new ImageRenderer());
    }

    // Custom renderer for displaying images in the table
    private class ImageRenderer extends JLabel implements TableCellRenderer {

        public ImageRenderer() {
            setOpaque(true);
            setHorizontalAlignment(CENTER);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                       boolean hasFocus, int row, int column) {
            if (value instanceof ImageIcon) {
                setIcon((ImageIcon) value);
            } else {
                setText("No Image");
            }
            return this;
        }
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new History().setVisible(true);
        });
    }
}
