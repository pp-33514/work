package model;

public class ApplicantModel {
	private int id;
    private String name;
    private String nrc,fname,dob;
    private String gender,mstatus,address;
    private int phone;
    private String education,degree;
    private String major;
    private String mail;
    private int mark;
    private String status;

    public String getNrc() {
		return nrc;
	}
	public void setNrc(String nrc) {
		this.nrc = nrc;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getMstatus() {
		return mstatus;
	}
	public void setMstatus(String mstatus) {
		this.mstatus = mstatus;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getMail() { return mail; }
    public void setMail(String mail) { this.mail = mail; }

    public int getPhone() { return phone; }
    public void setPhone(int phone2) { this.phone = phone2; }

    public String getEducation() { return education; }
    public void setEducation(String education) { this.education = education; }
    public String getDegree() { return degree; }
    public void setDegree(String degree) { this.degree = degree; }
    public String getMajor() { return major; }
    public void setMajor(String major) { this.major = major; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
