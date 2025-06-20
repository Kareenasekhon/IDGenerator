import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class HistoryPage extends JFrame {
    private static final String URL = "jdbc:mysql://localhost:3306/idcard";
    private static final String USER = "root"; // Your MySQL username
    private static final String PASS = "";    // Your MySQL password

    private JTable table;
    private DefaultTableModel tableModel;

    public HistoryPage() {
        setTitle("Faculty Card History");
        setSize(1000, 600); // Increased size for better layout
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Table columns: Name, Faculty ID, Position, Contact, Department, Gender, Photo
        tableModel = new DefaultTableModel(new Object[]{"Name", "Faculty ID", "Position", "Contact", "Department", "Gender", "Photo"}, 0);
        table = new JTable(tableModel) {
            // Override method to display images in the table
            @Override
            public Class<?> getColumnClass(int column) {
                return (column == 6) ? ImageIcon.class : Object.class;
            }
        };

        // Set column widths for better visibility
        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(150); // Name
        columnModel.getColumn(1).setPreferredWidth(100); // Faculty ID
        columnModel.getColumn(2).setPreferredWidth(120); // Position
        columnModel.getColumn(3).setPreferredWidth(120); // Contact
        columnModel.getColumn(4).setPreferredWidth(120); // Department
        columnModel.getColumn(5).setPreferredWidth(100); // Gender
        columnModel.getColumn(6).setPreferredWidth(150); // Photo (wider for images)

        table.setRowHeight(100); // Increase row height for better image visibility

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);

        // Load and display history
        loadHistory();
    }

    // Method to load the history from the database
    private void loadHistory() {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            String sql = "SELECT name, facultyid, position, contact, department, gender, photo FROM faculty_details";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String facultyID = resultSet.getString("facultyid");
                String position = resultSet.getString("position");
                String contact = resultSet.getString("contact");
                String department = resultSet.getString("department");
                String gender = resultSet.getString("gender");
                byte[] photoBytes = resultSet.getBytes("photo");

                // Convert photoBytes to ImageIcon
                ImageIcon photoIcon = null;
                if (photoBytes != null) {
                    try {
                        ByteArrayInputStream bis = new ByteArrayInputStream(photoBytes);
                        BufferedImage bufferedImage = ImageIO.read(bis);
                        Image scaledImage = bufferedImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH); // Scale the image
                        photoIcon = new ImageIcon(scaledImage);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                // Add the record to the table
                tableModel.addRow(new Object[]{name, facultyID, position, contact, department, gender, photoIcon});
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading history: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new HistoryPage().setVisible(true);
        });
    }
}
