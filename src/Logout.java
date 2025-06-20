import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Logout extends JFrame {

    public Logout() {
        initComponents();
    }

    private void initComponents() {
        JLabel messageLabel = new JLabel("Are you sure you want to log out?");
        JButton yesButton = new JButton("Yes");
        JButton noButton = new JButton("No");

        yesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                yesButtonActionPerformed(evt);
            }
        });

        noButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                noButtonActionPerformed(evt);
            }
        });

        // Layout setup
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(messageLabel)
                .addGroup(layout.createSequentialGroup()
                    .addGap(50, 50, 50)
                    .addComponent(yesButton)
                    .addGap(30, 30, 30)
                    .addComponent(noButton)
                )
        );
        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(messageLabel)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(yesButton)
                    .addComponent(noButton)
                )
                .addGap(20, 20, 20)
        );

        pack();
    }

    // Action performed when 'Yes' is clicked
    private void yesButtonActionPerformed(ActionEvent evt) {
        // Close the current session and go back to login page
        this.dispose();  // Close the logout window
        login loginPage = new login();  // Replace 'login' with your actual login page class
        loginPage.setVisible(true);  // Show the login page
    }

    // Action performed when 'No' is clicked
    private void noButtonActionPerformed(ActionEvent evt) {
        this.dispose();  // Simply close the logout window
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Logout().setVisible(true);
            }
        });
    }
}

