package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Color;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JDateChooser;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class UpdateForm extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtName;
    private JTextField txtNRCView;
    private JTextField txtFatherName;
    private JTextField txtAddress;
    private JTextField txtPhone;
    private JTextField txtEducation;
    private JTextField txtMail;
    private JTextField txtMark;
    private JDateChooser dateChooser;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                UpdateForm frame = new UpdateForm();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public UpdateForm() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 700, 750);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(12, 0, 660, 701);
        contentPane.add(panel);
        panel.setLayout(null);

        Font placeholderFont = new Font("Tahoma", Font.ITALIC, 11);
        Color placeholderColor = Color.GRAY;

        JLabel lblName = new JLabel("<html>Name<font color='red'>*</font></html>");
        lblName.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblName.setBounds(12, 13, 64, 22);
        panel.add(lblName);

        txtName = new JTextField("E.g.Su Su");
        txtName.setForeground(placeholderColor);
        txtName.setBounds(215, 15, 233, 19);
        panel.add(txtName);
        addPlaceholderBehavior(txtName, "E.g.Su Su");

        JLabel lblNRCView = new JLabel("NRC");
        lblNRCView.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblNRCView.setBounds(12, 74, 64, 22);
        panel.add(lblNRCView);

        txtNRCView = new JTextField("1/KAPATA(NAING)343545");
        txtNRCView.setForeground(placeholderColor);
        txtNRCView.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        txtNRCView.setBounds(215, 76, 233, 19);
        panel.add(txtNRCView);
        addPlaceholderBehavior(txtNRCView, "1/KAPATA(NAING)343545");

        JLabel lblFatherName = new JLabel("<html>Father Name<font color='red'>*</font></html>");
        lblFatherName.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblFatherName.setBounds(12, 133, 91, 13);
        panel.add(lblFatherName);

        txtFatherName = new JTextField("E.g. U Aung Aung");
        txtFatherName.setForeground(placeholderColor);
        txtFatherName.setBounds(215, 130, 233, 19);
        panel.add(txtFatherName);
        addPlaceholderBehavior(txtFatherName, "E.g. U Aung Aung");

        JLabel lblDOB = new JLabel("<html>DOB of NRC Card<font color='red'>*</font></html>");
        lblDOB.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblDOB.setBounds(12, 176, 155, 13);
        panel.add(lblDOB);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(215, 173, 233, 19);
        dateChooser.setDateFormatString("yyyy/MM/dd"); // Corrected format
        panel.add(dateChooser);
        addPlaceholderBehavior(dateChooser, "yyyy/MM/dd");

        JLabel lblGender = new JLabel("<html>Gender<font color='red'>*</font></html>");
        lblGender.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblGender.setBounds(12, 215, 77, 22);
        panel.add(lblGender);

        JRadioButton rdoMale = new JRadioButton("Male");
        rdoMale.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        rdoMale.setBounds(215, 216, 77, 21);
        panel.add(rdoMale);

        JRadioButton rdoFemale = new JRadioButton("Female");
        rdoFemale.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        rdoFemale.setBounds(327, 216, 91, 21);
        panel.add(rdoFemale);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(rdoMale);
        genderGroup.add(rdoFemale);

        JLabel lblMartialStatus = new JLabel("<html>Martial Status<font color='red'>*</font></html>");
        lblMartialStatus.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblMartialStatus.setBounds(12, 259, 118, 22);
        panel.add(lblMartialStatus);

        JRadioButton rdoSingle = new JRadioButton("Single");
        rdoSingle.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        rdoSingle.setBounds(215, 260, 113, 21);
        panel.add(rdoSingle);

        JRadioButton rdoMarried = new JRadioButton("Married");
        rdoMarried.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        rdoMarried.setBounds(327, 260, 113, 21);
        panel.add(rdoMarried);

        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(rdoSingle);
        maritalGroup.add(rdoMarried);

        JLabel lblAddress = new JLabel("Address");
        lblAddress.setBounds(12, 317, 77, 22);
        panel.add(lblAddress);

        txtAddress = new JTextField();
        txtAddress.setBounds(215, 317, 233, 61);
        panel.add(txtAddress);

        JLabel lblPhone = new JLabel("<html>Phone No<font color='red'>*</font></html>");
        lblPhone.setBounds(12, 409, 64, 13);
        panel.add(lblPhone);

        txtPhone = new JTextField("09987654321");
        txtPhone.setForeground(placeholderColor);
        txtPhone.setBounds(215, 409, 233, 19);
        panel.add(txtPhone);
        addPlaceholderBehavior(txtPhone, "09987654321");

        JLabel lblEducation = new JLabel("<html>Education<font color='red'>*</font></html>");
        lblEducation.setBounds(12, 457, 64, 13);
        panel.add(lblEducation);

        txtEducation = new JTextField("B.C.Sc,B.C.Tech,B.E");
        txtEducation.setForeground(placeholderColor);
        txtEducation.setBounds(215, 454, 233, 19);
        panel.add(txtEducation);
        addPlaceholderBehavior(txtEducation, "B.C.Sc,B.C.Tech,B.E");

        String[] educationFields = {
            "Computer Science",
            "Computer Technology",
            "Computer Engineering and Information Technology",
            "Software Engineering",
            "Information Science and Technology",
            "Information Technology",
            "Other"
        };
        JComboBox<String> cboMajor = new JComboBox<>(educationFields);
        cboMajor.setBounds(460, 453, 188, 21);
        panel.add(cboMajor);

        JRadioButton rdoBachelor = new JRadioButton("Bachelor");
        rdoBachelor.setBounds(215, 487, 113, 21);
        panel.add(rdoBachelor);

        JRadioButton rdoMaster = new JRadioButton("Master");
        rdoMaster.setBounds(335, 487, 113, 21);
        panel.add(rdoMaster);

        ButtonGroup educationGroup = new ButtonGroup();
        educationGroup.add(rdoBachelor);
        educationGroup.add(rdoMaster);

        JLabel lblMail = new JLabel("Mail");
        lblMail.setBounds(12, 540, 50, 13);
        panel.add(lblMail);

        txtMail = new JTextField("soethandaroo@myanmardcr.com");
        txtMail.setForeground(placeholderColor);
        txtMail.setBounds(215, 537, 233, 19);
        panel.add(txtMail);
        addPlaceholderBehavior(txtMail, "soethandaroo@myanmardcr.com");

        JLabel lblMark = new JLabel("Matriculation Mark");
        lblMark.setBounds(12, 596, 118, 13);
        panel.add(lblMark);

        txtMark = new JTextField("E.g.455");
        txtMark.setForeground(placeholderColor);
        txtMark.setBounds(215, 593, 233, 19);
        panel.add(txtMark);
        addPlaceholderBehavior(txtMark, "E.g.455");

        JButton btnUpdate = new JButton("Update");
        btnUpdate.setForeground(Color.WHITE);
        btnUpdate.setFont(new Font("MS UI Gothic", Font.PLAIN, 12));
        btnUpdate.setBackground(Color.BLUE);
        btnUpdate.setBounds(116, 651, 91, 21);
        panel.add(btnUpdate);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setBackground(Color.BLUE);
        btnCancel.setForeground(Color.WHITE);
        btnCancel.setBounds(237, 651, 91, 21);
        panel.add(btnCancel);
    }

    // Utility: Get formatted DOB
    public String getDOB() {
        Date selectedDate = dateChooser.getDate();
        if (selectedDate != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.format(selectedDate);
        }
        return null;
    }

    // Placeholder behavior for JTextField
    private void addPlaceholderBehavior(JTextField textField, String placeholder) {
        textField.setText(placeholder);
        textField.setForeground(Color.GRAY);
        textField.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(placeholder)) {
                    textField.setText("");
                    textField.setForeground(Color.BLACK);
                }
            }

            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setForeground(Color.GRAY);
                    textField.setText(placeholder);
                }
            }
        });
    }

    // Placeholder for JDateChooser
    private void addPlaceholderBehavior(JDateChooser dateChooser, String placeholder) {
        JTextField dateField = ((JTextField) dateChooser.getDateEditor().getUiComponent());
        dateField.setText(placeholder);
        dateField.setForeground(Color.GRAY);

        dateField.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (dateField.getText().equals(placeholder)) {
                    dateField.setText("");
                    dateField.setForeground(Color.BLACK);
                }
            }

            public void focusLost(FocusEvent e) {
                if (dateField.getText().isEmpty()) {
                    dateField.setForeground(Color.GRAY);
                    dateField.setText(placeholder);
                }
            }
        });
    }
}
