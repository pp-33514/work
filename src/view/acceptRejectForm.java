package view;
 
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
 
import controller.ApplicantController;
import model.ApplicantModel;
 
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
 
public class acceptRejectForm extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JRadioButton rdoMale,rdoFemale,rdoBachelor,rdoMaster,rdoSingle,rdoMarried;
	private JDateChooser dateDOB;
	private JComboBox<String> ddlMajor;
	private JTextArea textAreaAddress;
	private int applicantId;
	private JTextField txtName, txtNRC, txtFatherName, txtPhone, txtEducation, txtMail, txtMark;
	private JLabel lblNameErr, lblNrcErr, lblFatherErr, lblDobErr, lblGenderErr, lblMaritalErr, lblPhoneErr, lblEduErr, lblMajorErr, lblEmailErr, lblMarkErr, lblDegreeErr;
 
	public static void main(String[] args) {
	    EventQueue.invokeLater(new Runnable() {
	        public void run() {
	            try {
	            	acceptRejectForm view = new acceptRejectForm(1);
	                view.setVisible(true);
	                
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    });
	}
	public acceptRejectForm(int applicantId) {
		this.applicantId = applicantId;
		setTitle("Accept/Reject Form - Applicant ID: " + applicantId);
        setSize(300, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
 
		JLabel lblNRC = new JLabel("<html>NRC <font color='red'>*</font></html>");
		lblNRC.setBounds(358, 100, 100, 20);
		panel.add(lblNRC);
 
		txtNRC = new JTextField("1/KAPATA(NAING)343545");
		txtNRC.setForeground(placeholderColor);
		txtNRC.setBounds(522, 100, 233, 20);
		addPlaceholderBehavior(txtNRC, "1/KAPATA(NAING)343545");
		panel.add(txtNRC);
 
		JLabel lblFatherName = new JLabel("<html>Father Name <font color='red'>*</font></html>");
		lblFatherName.setBounds(358, 140, 100, 20);
		panel.add(lblFatherName);
 
		txtFatherName = new JTextField("E.g. U Aung Aung");
		txtFatherName.setForeground(placeholderColor);
		txtFatherName.setBounds(522, 141, 233, 20);
		addPlaceholderBehavior(txtFatherName, "E.g. U Aung Aung");
		panel.add(txtFatherName);
 
		JLabel lblDoB = new JLabel("<html>DOB of NRC Card <font color='red'>*</font></html>");
		lblDoB.setBounds(358, 180, 233, 20);
		panel.add(lblDoB);
 
		dateDOB = new JDateChooser();
		dateDOB.setBounds(522, 180, 233, 20);
		dateDOB.setDateFormatString("YYYY-MM-dd");
		panel.add(dateDOB);

		JLabel lblGender = new JLabel("<html>Gender <font color='red'>*</font></html>");
		lblGender.setBounds(358, 220, 100, 20);
		panel.add(lblGender);
 
		rdoMale = new JRadioButton("Male");
		rdoMale.setBounds(522, 220, 70, 20);
		panel.add(rdoMale);
 
		rdoFemale = new JRadioButton("Female");
		rdoFemale.setBounds(620, 220, 80, 20);
		panel.add(rdoFemale);
 
		ButtonGroup genderGroup = new ButtonGroup();
		genderGroup.add(rdoMale);
		genderGroup.add(rdoFemale);
		
		JLabel lblMarital = new JLabel("<html>Marital Status <font color='red'>*</font></html>");
		lblMarital.setBounds(358, 260, 100, 20);
		panel.add(lblMarital);
 
		rdoSingle = new JRadioButton("Single");
		rdoSingle.setBounds(522, 260, 70, 20);
		panel.add(rdoSingle);
 
		rdoMarried = new JRadioButton("Married");
		rdoMarried.setBounds(620, 260, 80, 20);
		panel.add(rdoMarried);
 
		ButtonGroup maritalGroup = new ButtonGroup();
		maritalGroup.add(rdoSingle);
		maritalGroup.add(rdoMarried);
 
		JLabel lblAddress = new JLabel("<html>Address <font color='red'>*</font></html>");
		lblAddress.setBounds(358, 300, 100, 20);
		panel.add(lblAddress);
 
		textAreaAddress = new JTextArea();
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
 
		JLabel lblEducation = new JLabel("<html>Education <font color='red'>*</font></html>");
		lblEducation.setBounds(358, 420, 100, 20);
		panel.add(lblEducation);
 
		txtEducation = new JTextField("E.g. B.C.Sc/ B.C.Tech/ B.E/ B.Sc");
		txtEducation.setForeground(placeholderColor);
		txtEducation.setBounds(522, 420, 233, 20);
		addPlaceholderBehavior(txtEducation, "E.g. B.C.Sc/ B.C.Tech/ B.E/ B.Sc");
		panel.add(txtEducation);
 
		ddlMajor = new JComboBox<>(new String[] {
			"Computer Science", "Computer Technology", "Computer Engineering and IT",
			"Software Engineering", "Information Science", "IT", "Other"
		});
		ddlMajor.setBounds(790, 420, 233, 20);
		panel.add(ddlMajor);
 
		rdoBachelor = new JRadioButton("Bachelor");
		rdoBachelor.setBounds(522, 460, 80, 20);
		panel.add(rdoBachelor);
 
		rdoMaster = new JRadioButton("Master");
		rdoMaster.setBounds(620, 460, 80, 20);
		panel.add(rdoMaster);
 
		ButtonGroup degreeGroup = new ButtonGroup();
		degreeGroup.add(rdoBachelor);
		degreeGroup.add(rdoMaster);
 
		JLabel lblMail = new JLabel("<html>Mail <font color='red'>*</font></html>");
		lblMail.setBounds(358, 500, 100, 20);
		panel.add(lblMail);
 
		txtMail = new JTextField("E.g. soethandaroo@myanmardcr.com");
		txtMail.setForeground(placeholderColor);
		txtMail.setBounds(522, 500, 233, 20);
		addPlaceholderBehavior(txtMail, "E.g. soethandaroo@myanmardcr.com");
		panel.add(txtMail);
		
		JLabel lblMark = new JLabel("Matriculation Mark");
		lblMark.setBounds(358, 540, 130, 20);
		panel.add(lblMark);
 
		txtMark = new JTextField("E.g. 455");
		txtMark.setForeground(placeholderColor);
		txtMark.setBounds(522, 540, 233, 20);
		addPlaceholderBehavior(txtMark, "E.g. 455");
		panel.add(txtMark);
 
		JButton btnAccept = new JButton("Accept");
		btnAccept.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
		            String name = txtName.getText().trim();
		            String nrc = txtNRC.getText().trim();
		            String fname = txtFatherName.getText().trim();
		            Date dob = dateDOB.getDate();
		            String gender = rdoMale.isSelected() ? "Male" : rdoFemale.isSelected() ? "Female" : null;
		            String marital = rdoSingle.isSelected() ? "Single" : rdoMarried.isSelected() ? "Married" : null;
		            String address = textAreaAddress.getText().trim();
		            String phone = txtPhone.getText().trim();
		            String education = txtEducation.getText().trim();
		            String major = ddlMajor.getSelectedItem().toString();
		            String degree = rdoBachelor.isSelected() ? "Bachelor" : rdoMaster.isSelected() ? "Master" : null;
		            String email = txtMail.getText().trim();
		            String mark = txtMark.getText().trim();
 
		            if (dob == null) {
		                JOptionPane.showMessageDialog(null, "Please select date of birth.");
		                return;
		            }
 
		            // Populate ApplicantModel
		            ApplicantModel model = new ApplicantModel();
		            model.setName(name);
		            model.setNrc(nrc);
		            model.setFname(fname);
		            model.setDob(new SimpleDateFormat("yyyy-MM-dd").format(dob));
		            model.setGender(gender);
		            model.setMstatus(marital);
		            model.setAddress(address);
		            model.setPhone(Integer.parseInt(phone));
		            model.setEducation(education);
		            model.setMajor(major);
		            model.setDegree(degree);
		            model.setMail(email);
		            model.setMark(Integer.parseInt(mark));
		            model.setStatus("Accepted");
		            model.setId(applicantId);
 
		            ApplicantController controller = new ApplicantController();
		            boolean result = controller.updateApplicant(model);
 
		            if (result) {
		                JOptionPane.showMessageDialog(null, "Applicant has been accepted successfully.");
		                clearFields(acceptRejectForm.this);
		            } else {
		                JOptionPane.showMessageDialog(null, "Error occurred while accepting applicant. Possibly invalid ID.");
		            }
		        } catch (Exception ex) {
		            ex.printStackTrace();
		            JOptionPane.showMessageDialog(null, "Exception occurred: " + ex.getMessage());
		        }
		    }
		});
		btnAccept.setBackground(new Color(30, 144, 255));
		btnAccept.setForeground(Color.WHITE);
		btnAccept.setBounds(393, 604, 120, 25);
		panel.add(btnAccept);
 
		JButton btnReject = new JButton("Reject");
		btnReject.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
		            String name = txtName.getText().trim();
		            String nrc = txtNRC.getText().trim();
		            String fname = txtFatherName.getText().trim();
		            Date dob = dateDOB.getDate();
		            String gender = rdoMale.isSelected() ? "Male" : rdoFemale.isSelected() ? "Female" : null;
		            String marital = rdoSingle.isSelected() ? "Single" : rdoMarried.isSelected() ? "Married" : null;
		            String address = textAreaAddress.getText().trim();
		            String phone = txtPhone.getText().trim();
		            String education = txtEducation.getText().trim();
		            String major = ddlMajor.getSelectedItem().toString();
		            String degree = rdoBachelor.isSelected() ? "Bachelor" : rdoMaster.isSelected() ? "Master" : null;
		            String email = txtMail.getText().trim();
		            String mark = txtMark.getText().trim();

		            ApplicantModel model = new ApplicantModel();
		            model.setName(name);
		            model.setNrc(nrc);
		            model.setFname(fname);
		            model.setDob(new SimpleDateFormat("yyyy-MM-dd").format(dob));
		            model.setGender(gender);
		            model.setMstatus(marital);
		            model.setAddress(address);
		            model.setPhone(Integer.parseInt(phone));
		            model.setEducation(education);
		            model.setMajor(major);
		            model.setDegree(degree);
		            model.setMail(email);
		            model.setMark(Integer.parseInt(mark));
		            model.setStatus("Rejected");
		            model.setId(applicantId);

		            ApplicantController controller = new ApplicantController();
		            boolean result = controller.updateApplicant(model);

		            if (result) {
		                JOptionPane.showMessageDialog(null, "Applicant has been rejected.");
		                clearFields(acceptRejectForm.this);
		            } else {
		                JOptionPane.showMessageDialog(null, "Error occurred while rejecting applicant.");
		            }
		        } catch (Exception ex) {
		            ex.printStackTrace();
		            JOptionPane.showMessageDialog(null, "Exception occurred: " + ex.getMessage());
		        }
		    }
		});

		
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
		LoadForm();
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
	private void LoadForm() {
		disableInputs(this);
		ApplicantController controller = new ApplicantController();
		ApplicantModel applicant = controller.getApplicantById(applicantId);
 
	    if (applicant != null) {
	        txtName.setText(applicant.getName());
	        txtNRC.setText(applicant.getNrc());
	        txtFatherName.setText(applicant.getFname());
	        
	        if (applicant.getGender() != null) {
	            if (applicant.getGender().equalsIgnoreCase("Male")) {
	                rdoMale.setSelected(true);
	            } else if (applicant.getGender().equalsIgnoreCase("Female")) {
	                rdoFemale.setSelected(true);
	            }
	        }
	        if (applicant.getDob() != null && !applicant.getDob().isEmpty()) {
	        	try {
	        	    String dobString = applicant.getDob();
	        	    System.out.println("in acceptRejectForm : " + dobString);
	        	    SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
	        	    Date dob = dateFormat.parse(dobString);
	        	    dateDOB.setDate(dob);
					
					
	        	} catch (Exception ex) {
	        	    ex.printStackTrace();
	        	}
	        }
	        if (applicant.getMstatus() != null) {
	            if (applicant.getMstatus().equalsIgnoreCase("Single")) {
	                rdoSingle.setSelected(true);
	            } else if (applicant.getMstatus().equalsIgnoreCase("Married")) {
	                rdoMarried.setSelected(true);
	            }
	        }
			textAreaAddress.setText(applicant.getAddress());
	        txtPhone.setText(String.valueOf(applicant.getPhone()));
	        txtEducation.setText(applicant.getEducation());
	        
	        if (applicant.getDegree() != null) {
	            if (applicant.getDegree().equalsIgnoreCase("Bachelor")) {
	                rdoBachelor.setSelected(true);
	            } else if (applicant.getDegree().equalsIgnoreCase("Master")) {
	                rdoMaster.setSelected(true);
	                
	            }
	        }
	        System.out.print("Rdo"+applicant.getDegree());
	        
			ddlMajor.setSelectedItem(applicant.getMajor());
	        txtMail.setText(applicant.getMail());
	        txtMark.setText(String.valueOf(applicant.getMark()));
	    }
	
	}
	private void disableInputs(Container container) {
	    for (Component c : container.getComponents()) {
	        if (c instanceof JTextField || c instanceof JTextArea || c instanceof JComboBox || c instanceof JRadioButton) {
	            c.setEnabled(false);
	        } else if (c instanceof Container) {
	            disableInputs((Container) c); // Recursively check inside nested containers
	        }
	    }
	}
	private void clearFields(Component c) {
	    for (Component comp : ((Container) c).getComponents()) {
	        if (comp instanceof JTextField) {
	            ((JTextField) comp).setText("");
	        } else if (comp instanceof JTextArea) {
	            ((JTextArea) comp).setText("");
	        } else if (comp instanceof JRadioButton) {
	            ((JRadioButton) comp).setSelected(false);  // Clear selection here
	        } else if (comp instanceof JComboBox) {
	            ((JComboBox<?>) comp).setSelectedIndex(0);
	        } else if (comp instanceof Container) {
	            clearFields(comp);
	        }
	    }
	}
 
}
 
 