import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.border.*;
import MarvellousPackerUnpacker.MarvellousUnpacker;

public class Program479 extends JFrame implements ActionListener 
{
    private JTextField txtFileName;
    private JButton btnBrowse, btnUnpack;
    private JTextArea txtOutput;
    private JFileChooser fileChooser;

    public Program479() 
    {
        super("🧩 Marvellous Unpacker");

        // Modern look and feel
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            System.out.println("Default look applied.");
        }

        setLayout(new BorderLayout(15, 15));
        getContentPane().setBackground(new Color(245, 247, 250));

        // ===== Top Panel =====
        JPanel topPanel = new JPanel();
        topPanel.setBackground(Color.WHITE);
        topPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
        topPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel lblTitle = new JLabel("Marvellous File Unpacker", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblTitle.setForeground(new Color(45, 45, 45));

        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 3;
        topPanel.add(lblTitle, gbc);

        JLabel lblFile = new JLabel("Select Packed File:");
        lblFile.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblFile.setForeground(new Color(70, 70, 70));

        txtFileName = new JTextField(25);
        txtFileName.setFont(new Font("Consolas", Font.PLAIN, 14));
        txtFileName.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(new Color(180, 180, 180), 1, true),
            new EmptyBorder(5, 8, 5, 8)
        ));

        btnBrowse = createModernButton("Browse");
        btnUnpack = createModernButton("Unpack");

        gbc.gridwidth = 1;
        gbc.gridy = 1; gbc.gridx = 0; topPanel.add(lblFile, gbc);
        gbc.gridx = 1; topPanel.add(txtFileName, gbc);
        gbc.gridx = 2; topPanel.add(btnBrowse, gbc);
        gbc.gridy = 2; gbc.gridx = 2; topPanel.add(btnUnpack, gbc);

        // ===== Output Area =====
        txtOutput = new JTextArea(10, 50);
        txtOutput.setEditable(false);
        txtOutput.setFont(new Font("Consolas", Font.PLAIN, 14));
        txtOutput.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(new Color(200, 200, 200), 1, true),
            new EmptyBorder(10, 10, 10, 10)
        ));
        txtOutput.setBackground(new Color(250, 250, 250));
        txtOutput.setForeground(new Color(50, 50, 50));

        JScrollPane scrollPane = new JScrollPane(txtOutput);
        scrollPane.setBorder(BorderFactory.createTitledBorder(
            new LineBorder(new Color(200, 200, 200), 1, true),
            "Output Console",
            TitledBorder.LEFT,
            TitledBorder.TOP,
            new Font("Segoe UI", Font.BOLD, 14),
            new Color(80, 80, 80)
        ));

        // Add panels to frame
        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // File chooser
        fileChooser = new JFileChooser();

        // Button listeners
        btnBrowse.addActionListener(this);
        btnUnpack.addActionListener(this);

        // Frame setup
        setSize(650, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private JButton createModernButton(String text) 
    {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btn.setForeground(Color.WHITE);
        btn.setBackground(new Color(70, 130, 180));
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(new Color(70, 130, 180), 1, true),
            new EmptyBorder(5, 15, 5, 15)
        ));

        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn.setBackground(new Color(60, 120, 170));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn.setBackground(new Color(70, 130, 180));
            }
        });
        return btn;
    }

    public void actionPerformed(ActionEvent ae) 
    {
        if (ae.getSource() == btnBrowse) 
        {
            int returnVal = fileChooser.showOpenDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) 
            {
                File selectedFile = fileChooser.getSelectedFile();
                txtFileName.setText(selectedFile.getAbsolutePath());
            }
        } 
        else if (ae.getSource() == btnUnpack) 
        {
            String packName = txtFileName.getText().trim();

            if (packName.isEmpty()) 
            {
                JOptionPane.showMessageDialog(this, "Please select a packed file!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try 
            {
                txtOutput.append("🔹 Unpacking file: " + packName + "\n");
                MarvellousUnpacker mobj = new MarvellousUnpacker(packName);
                mobj.UnpackingActivity();
                txtOutput.append("✅ Unpacking completed successfully!\n");
            } 
            catch (Exception eobj) 
            {
                txtOutput.append("❌ Error: " + eobj.getMessage() + "\n");
            }
        }
    }

    public static void main(String args[]) 
    {
        SwingUtilities.invokeLater(() -> new Program479());
    }
}
