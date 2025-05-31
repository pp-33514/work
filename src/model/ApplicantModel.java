package model;

public class ApplicantModel {
	private int id;
    private String name;
    private String gender;
    private String email;
    private String phone;
    private String education;
    private String major;
    private String status;

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getEducation() { return education; }
    public void setEducation(String education) { this.education = education; }

    public String getMajor() { return major; }
    public void setMajor(String major) { this.major = major; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
