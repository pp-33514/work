package view;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import config.DBConfig;
import java.util.List;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class AdminForm extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtName;
    private JLabel lblMessage;
    private JTable gvApplicantInfoSearchList;
    private JScrollPane scrollPane;
    private DBConfig dbConfig = new DBConfig();
    private boolean tableInitialized = false;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                AdminForm frame = new AdminForm();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public AdminForm() {
        setFont(new Font("SansSerif", Font.PLAIN, 15));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(Color.WHITE);
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout());

        JPanel navBar = new JPanel(new BorderLayout());
        navBar.setBackground(Color.BLACK);
        contentPane.add(navBar, BorderLayout.NORTH);

        JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        leftPanel.setOpaque(false);
        leftPanel.add(Box.createHorizontalStrut(180)); 

        ImageIcon logoIcon = new ImageIcon("src/images/logo.png");
        Image logoImage = logoIcon.getImage().getScaledInstance(120, 50, Image.SCALE_SMOOTH);
        JLabel logoLabel = new JLabel(new ImageIcon(logoImage));
        leftPanel.add(logoLabel);

        JLabel lblTitle = new JLabel("Myanmar DCR Recruitment System");
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setFont(new Font("SansSerif", Font.BOLD, 20));
        lblTitle.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        leftPanel.add(lblTitle);
        navBar.add(leftPanel, BorderLayout.WEST);

        // Right side (login button)
        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        rightPanel.setOpaque(false); 

        JLabel lblLogin = new JLabel("Add New Admin");
        lblLogin.setForeground(Color.WHITE);
        lblLogin.setFont(new Font("SansSerif", Font.BOLD, 15));
        lblLogin.setCursor(new Cursor(Cursor.HAND_CURSOR)); 

        // Optional: Add padding or margin
        lblLogin.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Add click behavior
        lblLogin.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                // Handle login action
                JOptionPane.showMessageDialog(null, "Login clicked!");
            }

            public void mouseEntered(MouseEvent e) {
                lblLogin.setForeground(Color.LIGHT_GRAY); 
            }

            public void mouseExited(MouseEvent e) {
                lblLogin.setForeground(Color.WHITE);
            }
        });
        rightPanel.add(lblLogin);
        navBar.add(rightPanel, BorderLayout.EAST);

        JPanel containerPanel = new JPanel(new GridBagLayout());
        containerPanel.setBackground(Color.WHITE);
        contentPane.add(containerPanel, BorderLayout.CENTER);

        JPanel mainPanel = new JPanel(null);
        mainPanel.setSize(900, 350);
        mainPanel.setBounds(0, 0, 900, 350);
        mainPanel.setPreferredSize(new Dimension(700, 500));
        mainPanel.setBackground(Color.WHITE);
        containerPanel.add(mainPanel);

        JLabel lblGender = new JLabel("Gender");
        lblGender.setFont(new Font("SansSerif", Font.PLAIN, 15));
        lblGender.setBounds(71, 55, 50, 13);
        mainPanel.add(lblGender);

        JComboBox<String> cboGender = new JComboBox<>(new String[] {"", "Male", "Female"});
        cboGender.setBounds(164, 51, 160, 30);
        cboGender.setFont(new Font("Arial", Font.PLAIN, 13));
        cboGender.setBackground(Color.WHITE);
        cboGender.setForeground(Color.BLACK);
        cboGender.setFocusable(false);
        cboGender.setOpaque(false);
        cboGender.setBorder(BorderFactory.createCompoundBorder(
                new javax.swing.border.LineBorder(new Color(210, 210, 210), 1, true),
                BorderFactory.createEmptyBorder(4, 10, 4, 10)));
        cboGender.setUI(new javax.swing.plaf.basic.BasicComboBoxUI() {
            @Override
            protected JButton createArrowButton() {
                JButton button = new JButton("▼");
                button.setBorder(null);
                button.setContentAreaFilled(false);
                button.setFocusPainted(false);
                button.setOpaque(false);
                button.setForeground(new Color(120, 120, 120));
                button.setFont(new Font("Arial", Font.PLAIN, 12));
                return button;
            }
        });
        mainPanel.add(cboGender);

        JLabel lblName = new JLabel("Name");
        lblName.setBounds(381, 55, 50, 13);
        lblName.setFont(new Font("SansSerif", Font.PLAIN, 15));
        mainPanel.add(lblName);

        txtName = new JTextField() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getBackground());
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 6, 6);
                super.paintComponent(g);
                g2.dispose();
            }

            @Override
            protected void paintBorder(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(new Color(220, 220, 220));
                g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 6, 6);
                g2.dispose();
            }
        };
        txtName.setBounds(467, 52, 150, 26);
        txtName.setBackground(Color.WHITE);
        mainPanel.add(txtName);

        JButton btnSearch = new JButton("Search") {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getBackground());
                int arc = 7;
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), arc, arc);
                super.paintComponent(g2);
                g2.dispose();
            }
        };
        btnSearch.addActionListener(e -> {
            String gender = (String) cboGender.getSelectedItem();
            if (gender == null) gender = "";
            String name = txtName.getText();

            if (gender.isBlank() && name.isBlank()) {
                loadAllApplicantData();
            } else {
                loadApplicantData(gender, name);
            }
        });

        btnSearch.setBounds(211, 120, 100, 26);
        btnSearch.setBackground(new Color(33, 150, 243));
        btnSearch.setFont(new Font("SansSerif", Font.PLAIN, 15));
        btnSearch.setForeground(Color.WHITE);
        btnSearch.setFocusPainted(false);
        btnSearch.setBorder(BorderFactory.createEmptyBorder());
        btnSearch.setContentAreaFilled(false);
        mainPanel.add(btnSearch);

        JButton btnCancel = new JButton("Cancel") {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getBackground());
                int arc = 7;
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), arc, arc);
                super.paintComponent(g2);
                g2.dispose();
            }
        };
        btnCancel.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		txtName.setText("");
        		cboGender.setSelectedIndex(0);
        		loadAllApplicantData();
        		scrollPane.setVisible(true);      		
        	}
        });
        btnCancel.setBounds(340, 120, 100, 26);
        btnCancel.setBackground(new Color(33, 150, 243));
        btnCancel.setForeground(Color.WHITE);
        btnCancel.setFont(new Font("SansSerif", Font.PLAIN, 15));
        btnCancel.setBorder(BorderFactory.createEmptyBorder());
        btnCancel.setContentAreaFilled(false);
        btnCancel.setFocusPainted(false);
        mainPanel.add(btnCancel);

        lblMessage = new JLabel("No records found.");
        lblMessage.setBounds(266, 158, 500, 13);
        lblMessage.setForeground(Color.RED);
        lblMessage.setFont(new Font("SansSerif", Font.PLAIN, 15));
        mainPanel.add(lblMessage);

        gvApplicantInfoSearchList = new JTable() {
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component comp = super.prepareRenderer(renderer, row, column);
                if (!(comp instanceof JButton)) {
                    comp.setBackground(isRowSelected(row) ? new Color(184, 207, 229) : (row % 2 == 0 ? Color.WHITE : new Color(240, 240, 240)));
                }
                return comp;
            }
        };

        scrollPane = new JScrollPane(gvApplicantInfoSearchList);
        scrollPane.setBounds(70, 200, 800, 200);
        scrollPane.getViewport().setBackground(Color.WHITE);
        scrollPane.setBorder(BorderFactory.createEmptyBorder()); 
        loadAllApplicantData();
        scrollPane.setVisible(true);
        mainPanel.add(scrollPane);
    }

    public void navigateToUpdatePage(int applicantId) {
    	//new UpdateForm(applicantId);
    }

    public void navigateToAcceptRejectPage(int applicantId) {
    	acceptRejectForm acceptForm = new acceptRejectForm(applicantId);
    	acceptForm.setVisible(true);
    }

    private static class ButtonRenderer extends JButton implements TableCellRenderer {
        private final Color updateColor = new Color(0, 153, 0);  
        private final Color acceptRejectColor = new Color(0, 153, 0);

        public ButtonRenderer(String label) {
            setOpaque(true);
            setForeground(Color.WHITE);
            setFont(new Font("SansSerif", Font.PLAIN, 13));
            setFocusPainted(false);

            // Optional: set background based on button type
            if ("Update".equalsIgnoreCase(label)) {
                setBackground(updateColor);
            } else if ("Accept/Reject".equalsIgnoreCase(label)) {
                setBackground(acceptRejectColor);
            } else {
                setBackground(new Color(100, 100, 100)); 
            }
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                                                       boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value == null) ? "" : value.toString());
            return this;
        }
    }

    public class ButtonEditor extends DefaultCellEditor {
        protected JButton button;
        private String actionType;
        private AdminForm adminForm;
        private int row;

        public ButtonEditor(JCheckBox checkBox, AdminForm adminForm, String actionType) {
            super(checkBox);
            this.adminForm = adminForm;
            this.actionType = actionType;

            button = new JButton(actionType);
            button.setOpaque(true);
            button.setForeground(Color.WHITE);
            button.setFont(new Font("SansSerif", Font.PLAIN, 13));
            button.setFocusPainted(false);

            if ("Update".equalsIgnoreCase(actionType)) {
                button.setBackground(new Color(0, 153, 0));
            } else if ("Accept/Reject".equalsIgnoreCase(actionType)) {
                button.setBackground(new Color(0, 102, 204));
            } else {
                button.setBackground(Color.GRAY);
            }

            button.addActionListener(e -> {
                fireEditingStopped();
                JTable table = adminForm.gvApplicantInfoSearchList;
                int modelRow = table.convertRowIndexToModel(row);

                Object idObj = ((DefaultTableModel) table.getModel()).getValueAt(modelRow, 0);
                int applicantId = Integer.parseInt(idObj.toString());

                if ("Update".equals(actionType)) {
                    adminForm.navigateToUpdatePage(applicantId);
                } else if ("Accept/Reject".equals(actionType)) {
                    adminForm.navigateToAcceptRejectPage(applicantId);
                }
            });
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value,
                                                     boolean isSelected, int row, int column) {
            this.row = row;
            button.setText(value == null ? actionType : value.toString());
            return button;
        }

        @Override
        public Object getCellEditorValue() {
            return actionType;
        }
    }

    private void loadApplicantData(String gender, String name) {
        if (!tableInitialized) {
            setupTable();
        }
        DefaultTableModel model = (DefaultTableModel) gvApplicantInfoSearchList.getModel();
        model.setRowCount(0);

        try (Connection conn = dbConfig.getConnection()) {
            StringBuilder sql = new StringBuilder("SELECT id, name, nrc FROM userapplicant WHERE 1=1");
            List<Object> params = new ArrayList<>();

            if (gender != null && !gender.isBlank()) {
                sql.append(" AND gender = ?");
                params.add(gender);
            }
            if (name != null && !name.isBlank()) {
                sql.append(" AND name LIKE ?");
                params.add("%" + name + "%");
            }

            try (PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
                for (int i = 0; i < params.size(); i++) {
                    pstmt.setObject(i + 1, params.get(i));
                }

                try (ResultSet rs = pstmt.executeQuery()) {
                    int no = 1;
                    while (rs.next()) {
                        model.addRow(new Object[]{
                                rs.getInt("id"),
                                no++,
                                "Update",
                                "Accept/Reject",
                                rs.getString("name"),
                                rs.getString("nrc")
                        });
                    }
                }
            }

            int rowCount = model.getRowCount();
            if (rowCount == 0) {
                lblMessage.setText("No records found.");
                lblMessage.setBounds(266, 158, 500, 13);
                lblMessage.setFont(new Font("SansSerif", Font.PLAIN, 15));
                lblMessage.setForeground(Color.RED);
                scrollPane.setVisible(false);
            } else {
                lblMessage.setText(rowCount + " rows were found");
                lblMessage.setBounds(266, 158, 500, 13);
                lblMessage.setFont(new Font("SansSerif", Font.PLAIN, 15));
                lblMessage.setForeground(Color.BLUE);
                adjustScrollPaneSize();
                scrollPane.setVisible(true);
            }
        } catch (SQLException ex) {
            lblMessage.setText("Database error: " + ex.getMessage());
            lblMessage.setForeground(Color.RED);
            ex.printStackTrace();
        }
        scrollPane.setVisible(model.getRowCount() > 0);
    }
    
    private void loadAllApplicantData() {
        if (!tableInitialized) {
            setupTable();
        }
        DefaultTableModel model = (DefaultTableModel) gvApplicantInfoSearchList.getModel();
        model.setRowCount(0);

        try (Connection conn = dbConfig.getConnection()) {
            StringBuilder sql = new StringBuilder("SELECT id, name, nrc FROM userapplicant");
            List<Object> params = new ArrayList<>();
            
            try (PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
                for (int i = 0; i < params.size(); i++) {
                    pstmt.setObject(i + 1, params.get(i));
                }

                try (ResultSet rs = pstmt.executeQuery()) {
                    int no = 1;
                    while (rs.next()) {
                        model.addRow(new Object[]{
                                rs.getInt("id"),
                                no++,
                                "Update",
                                "Accept/Reject",
                                rs.getString("name"),
                                rs.getString("nrc")
                        });
                    }
                }
            }

            int rowCount = model.getRowCount();
            if (rowCount == 0) {
                lblMessage.setText("No records found.");
                lblMessage.setBounds(266, 158, 500, 13);
                lblMessage.setFont(new Font("SansSerif", Font.PLAIN, 15));
                lblMessage.setForeground(Color.RED);
                scrollPane.setVisible(false);
            } else {
                lblMessage.setText(rowCount + " rows were found");
                lblMessage.setBounds(266, 158, 500, 13);
                lblMessage.setFont(new Font("SansSerif", Font.PLAIN, 15));
                lblMessage.setForeground(Color.BLUE);
                adjustScrollPaneSize();
                scrollPane.setVisible(true);
            }
        } catch (SQLException ex) {
            lblMessage.setText("Database error: " + ex.getMessage());
            lblMessage.setForeground(Color.RED);
            ex.printStackTrace();
        }
        scrollPane.setVisible(model.getRowCount() > 0);
    }

    private void setupTable() {
        String[] columnNames = {"ID", "No", "", "", "Name", "NRC"};
        DefaultTableModel model = new DefaultTableModel(null, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 2 || column == 3;
            }
        };

        gvApplicantInfoSearchList.setModel(model);
        TableColumnModel columnModel = gvApplicantInfoSearchList.getColumnModel();

        // Hide ID column
        columnModel.removeColumn(columnModel.getColumn(0));

        // Update button (column 2 after ID is removed)
        columnModel.getColumn(1).setCellRenderer(new ButtonRenderer("Update"));
        columnModel.getColumn(1).setCellEditor(new ButtonEditor(new JCheckBox(), this, "Update"));

        // Accept/Reject button (column 3 after ID is removed)
        columnModel.getColumn(2).setCellRenderer(new ButtonRenderer("Accept/Reject"));
        columnModel.getColumn(2).setCellEditor(new ButtonEditor(new JCheckBox(), this, "Accept/Reject"));

        gvApplicantInfoSearchList.setRowHeight(28);
        gvApplicantInfoSearchList.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        gvApplicantInfoSearchList.getColumnModel().getColumn(0).setPreferredWidth(40);
        gvApplicantInfoSearchList.getColumnModel().getColumn(1).setPreferredWidth(80);
        gvApplicantInfoSearchList.getColumnModel().getColumn(2).setPreferredWidth(120);
        gvApplicantInfoSearchList.getColumnModel().getColumn(3).setPreferredWidth(188);
        gvApplicantInfoSearchList.getColumnModel().getColumn(4).setPreferredWidth(200);

        JTableHeader header = gvApplicantInfoSearchList.getTableHeader();
        header.setPreferredSize(new Dimension(header.getPreferredSize().width, 32));
        header.setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                                                           boolean isSelected, boolean hasFocus, int row, int column) {
                JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                label.setBackground(new Color(0, 153, 0));
                label.setForeground(Color.WHITE);
                label.setFont(new Font("SansSerif", Font.BOLD, 14));
                label.setOpaque(true);
                label.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, Color.WHITE));
                label.setHorizontalAlignment(SwingConstants.CENTER);
                return label;
            }
        });

        tableInitialized = true;
    }

    private void adjustScrollPaneSize() {
        int rows = gvApplicantInfoSearchList.getRowCount();
        int rowHeight = gvApplicantInfoSearchList.getRowHeight();
        int headerHeight = gvApplicantInfoSearchList.getTableHeader().getHeight();
        int totalHeight = headerHeight + (rows * rowHeight);
        // Keep the width fixed or adjust as needed
        int width = 800;
        scrollPane.setPreferredSize(new Dimension(width, totalHeight));
        scrollPane.revalidate();
        scrollPane.repaint();
    }
}