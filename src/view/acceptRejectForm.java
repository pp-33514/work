package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;

public class acceptRejectForm extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName, txtNRC, txtFatherName, txtPhone, txtEducation, txtMail, txtMark;
	private JLabel lblNameErr, lblNrcErr, lblFatherErr, lblDobErr, lblGenderErr, lblMaritalErr, lblPhoneErr, lblEduErr, lblMajorErr, lblEmailErr, lblMarkErr, lblDegreeErr;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				acceptRejectForm frame = new acceptRejectForm();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public acceptRejectForm() {
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1365, 678);
		contentPane = new JPanel();
		contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel bar = new JPanel();
		bar.setBackground(Color.black);
		bar.setBounds(0, 0, 1365, 44);
		bar.setLayout(null);
		contentPane.add(bar);

		ImageIcon logo = new ImageIcon("logo.png");

		JLabel textLabel = new JLabel("Myanmar DCR Recruitment System");
		textLabel.setForeground(Color.white);
		textLabel.setBounds(354, 10, 300, 30);
		textLabel.setFont(new Font("Arial", Font.BOLD, 14));
		bar.add(textLabel);

		JLabel logolabel = new JLabel(logo);
		logolabel.setBounds(211, 0, 131, 40);
		bar.add(logolabel);

		JPanel panel = new JPanel();
		panel.setBounds(-12, 0, 1361, 639);
		contentPane.add(panel);
		panel.setLayout(null);

		Color placeholderColor = Color.GRAY;

		JLabel lblName = new JLabel("<html>Name <font color='red'>*</font></html>");
		lblName.setBounds(358, 60, 100, 20);
		panel.add(lblName);

		txtName = new JTextField("E.g. Su Su");
		txtName.setForeground(placeholderColor);
		txtName.setBounds(522, 60, 233, 20);
		addPlaceholderBehavior(txtName, "E.g. Su Su");
		panel.add(txtName);

		lblNameErr = new JLabel(" error");
		lblNameErr.setForeground(Color.RED);
		lblNameErr.setBounds(522, 80, 233, 20);
		panel.add(lblNameErr);

		JLabel lblNRC = new JLabel("<html>NRC <font color='red'>*</font></html>");
		lblNRC.setBounds(358, 100, 100, 20);
		panel.add(lblNRC);

		txtNRC = new JTextField("1/KAPATA(NAING)343545");
		txtNRC.setForeground(placeholderColor);
		txtNRC.setBounds(522, 100, 233, 20);
		addPlaceholderBehavior(txtNRC, "1/KAPATA(NAING)343545");
		panel.add(txtNRC);

		lblNrcErr = new JLabel(" ");
		lblNrcErr.setForeground(Color.RED);
		lblNrcErr.setBounds(522, 120, 233, 20);
		panel.add(lblNrcErr);

		JLabel lblFatherName = new JLabel("<html>Father Name <font color='red'>*</font></html>");
		lblFatherName.setBounds(358, 140, 100, 20);
		panel.add(lblFatherName);

		txtFatherName = new JTextField("E.g. U Aung Aung");
		txtFatherName.setForeground(placeholderColor);
		txtFatherName.setBounds(522, 141, 233, 20);
		addPlaceholderBehavior(txtFatherName, "E.g. U Aung Aung");
		panel.add(txtFatherName);

		lblFatherErr = new JLabel(" ");
		lblFatherErr.setForeground(Color.RED);
		lblFatherErr.setBounds(522, 161, 233, 20);
		panel.add(lblFatherErr);

		JLabel lblDoB = new JLabel("<html>DOB of NRC Card <font color='red'>*</font></html>");
		lblDoB.setBounds(358, 180, 233, 20);
		panel.add(lblDoB);

		JDateChooser dateDOB = new JDateChooser();
		dateDOB.setBounds(522, 180, 233, 20);
		dateDOB.setDateFormatString("yyyy/MM/dd");
		panel.add(dateDOB);

		lblDobErr = new JLabel(" ");
		lblDobErr.setForeground(Color.RED);
		lblDobErr.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblDobErr.setBounds(522, 180, 223, 20);
		panel.add(lblDobErr);

		JLabel lblGender = new JLabel("<html>Gender <font color='red'>*</font></html>");
		lblGender.setBounds(358, 220, 100, 20);
		panel.add(lblGender);

		JRadioButton rdoMale = new JRadioButton("Male");
		rdoMale.setBounds(522, 220, 70, 20);
		panel.add(rdoMale);

		JRadioButton rdoFemale = new JRadioButton("Female");
		rdoFemale.setBounds(620, 220, 80, 20);
		panel.add(rdoFemale);

		ButtonGroup genderGroup = new ButtonGroup();
		genderGroup.add(rdoMale);
		genderGroup.add(rdoFemale);

		lblGenderErr = new JLabel("error ");
		lblGenderErr.setForeground(Color.RED);
		lblGenderErr.setBounds(522, 240, 250, 15);
		panel.add(lblGenderErr);

		JLabel lblMarital = new JLabel("<html>Marital Status <font color='red'>*</font></html>");
		lblMarital.setBounds(358, 260, 100, 20);
		panel.add(lblMarital);

		JRadioButton rdoSingle = new JRadioButton("Single");
		rdoSingle.setBounds(522, 260, 70, 20);
		panel.add(rdoSingle);

		JRadioButton rdoMarried = new JRadioButton("Married");
		rdoMarried.setBounds(620, 260, 80, 20);
		panel.add(rdoMarried);

		ButtonGroup maritalGroup = new ButtonGroup();
		maritalGroup.add(rdoSingle);
		maritalGroup.add(rdoMarried);

		lblMaritalErr = new JLabel(" ");
		lblMaritalErr.setForeground(Color.RED);
		lblMaritalErr.setBounds(522, 280, 250, 15);
		panel.add(lblMaritalErr);

		JLabel lblAddress = new JLabel("<html>Address <font color='red'>*</font></html>");
		lblAddress.setBounds(358, 300, 100, 20);
		panel.add(lblAddress);

		JTextArea textAreaAddress = new JTextArea();
		textAreaAddress.setBounds(522, 300, 233, 74);
		panel.add(textAreaAddress);

		JLabel lblPhone = new JLabel("<html>Phone No <font color='red'>*</font></html>");
		lblPhone.setBounds(358, 380, 100, 20);
		panel.add(lblPhone);

		txtPhone = new JTextField("E.g.09961234567,01214231");
		txtPhone.setForeground(placeholderColor);
		txtPhone.setBounds(522, 380, 233, 20);
		addPlaceholderBehavior(txtPhone, "E.g.09961234567,01214231");
		panel.add(txtPhone);

		lblPhoneErr = new JLabel(" ");
		lblPhoneErr.setForeground(Color.RED);
		lblPhoneErr.setBounds(522, 400, 223, 15);
		panel.add(lblPhoneErr);

		JLabel lblEducation = new JLabel("<html>Education <font color='red'>*</font></html>");
		lblEducation.setBounds(358, 420, 100, 20);
		panel.add(lblEducation);

		txtEducation = new JTextField("E.g. B.C.Sc/ B.C.Tech/ B.E/ B.Sc");
		txtEducation.setForeground(placeholderColor);
		txtEducation.setBounds(522, 420, 233, 20);
		addPlaceholderBehavior(txtEducation, "E.g. B.C.Sc/ B.C.Tech/ B.E/ B.Sc");
		panel.add(txtEducation);

		JComboBox<String> ddlMajor = new JComboBox<>(new String[] {
			"Computer Science", "Computer Technology", "Computer Engineering and IT",
			"Software Engineering", "Information Science", "IT", "Other"
		});
		ddlMajor.setBounds(790, 420, 233, 20);
		panel.add(ddlMajor);

		lblEduErr = new JLabel(" ");
		lblEduErr.setForeground(Color.RED);
		lblEduErr.setBounds(522, 442, 250, 13);
		panel.add(lblEduErr);

		JRadioButton rdoBachelor = new JRadioButton("Bachelor");
		rdoBachelor.setBounds(522, 460, 80, 20);
		panel.add(rdoBachelor);

		JRadioButton rdoMaster = new JRadioButton("Master");
		rdoMaster.setBounds(620, 460, 80, 20);
		panel.add(rdoMaster);

		ButtonGroup degreeGroup = new ButtonGroup();
		degreeGroup.add(rdoBachelor);
		degreeGroup.add(rdoMaster);

		lblDegreeErr = new JLabel(" ");
		lblDegreeErr.setForeground(Color.RED);
		lblDegreeErr.setBounds(522, 482, 250, 13);
		panel.add(lblDegreeErr);

		JLabel lblMail = new JLabel("<html>Mail <font color='red'>*</font></html>");
		lblMail.setBounds(358, 500, 100, 20);
		panel.add(lblMail);

		txtMail = new JTextField("E.g. soethandaroo@myanmardcr.com");
		txtMail.setForeground(placeholderColor);
		txtMail.setBounds(522, 500, 233, 20);
		addPlaceholderBehavior(txtMail, "E.g. soethandaroo@myanmardcr.com");
		panel.add(txtMail);

		lblEmailErr = new JLabel(" ");
		lblEmailErr.setForeground(Color.RED);
		lblEmailErr.setBounds(522, 520, 250, 15);
		panel.add(lblEmailErr);

		JLabel lblMark = new JLabel("Matriculation Mark");
		lblMark.setBounds(358, 540, 130, 20);
		panel.add(lblMark);

		txtMark = new JTextField("E.g. 455");
		txtMark.setForeground(placeholderColor);
		txtMark.setBounds(522, 540, 233, 20);
		addPlaceholderBehavior(txtMark, "E.g. 455");
		panel.add(txtMark);

		lblMarkErr = new JLabel(" ");
		lblMarkErr.setForeground(Color.RED);
		lblMarkErr.setBounds(522, 562, 250, 15);
		panel.add(lblMarkErr);

		JButton btnAccept = new JButton("Accept");
		btnAccept.setBackground(new Color(30, 144, 255));
		btnAccept.setForeground(Color.WHITE);
		btnAccept.setBounds(393, 604, 120, 25);
		panel.add(btnAccept);

		JButton btnReject = new JButton("Reject");
		btnReject.setBackground(new Color(30, 144, 255));
		btnReject.setForeground(Color.WHITE);
		btnReject.setBounds(561, 604, 120, 25);
		panel.add(btnReject);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBackground(new Color(30, 144, 255));
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setBounds(728, 604, 115, 25);
		panel.add(btnCancel);

		SwingUtilities.invokeLater(() -> contentPane.requestFocusInWindow());
	}

	private void addPlaceholderBehavior(JTextField textField, String placeholder) {
		textField.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				if (textField.getText().equals(placeholder)) {
					textField.setText("");
					textField.setForeground(Color.BLACK);
				}
			}
			public void focusLost(FocusEvent e) {
				if (textField.getText().trim().isEmpty()) {
					textField.setForeground(Color.GRAY);
					textField.setText(placeholder);
				}
			}
		});
	}
}
