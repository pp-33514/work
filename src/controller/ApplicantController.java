package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.text.SimpleDateFormat;

import model.ApplicantModel;
import config.DBConfig;

public class ApplicantController {

	public ApplicantModel getApplicantById(String id) {
	    ApplicantModel applicant = null;

	    try {
	        DBConfig db = new DBConfig();
	        Connection con = db.getConnection();

	        String sql = "SELECT * FROM userapplicant WHERE id = ?";
	        PreparedStatement ps = con.prepareStatement(sql);
	        System.out.println("testing");
	        ps.setString(1, id);
	        ResultSet rs = ps.executeQuery();
	        System.out.println("testing1"+rs);
	        if (rs.next()) {
	            applicant = new ApplicantModel();
	            applicant.setId(rs.getInt("id"));  
	            applicant.setName(rs.getString("name"));
	            System.out.println("testing2"+applicant.getName());
	            applicant.setNrc(rs.getString("nrc"));
	            applicant.setFname(rs.getString("fname"));
	            System.out.println("testing3"+applicant.getFname());
	            String dobString = rs.getString("dob");
	            SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
	            System.out.println("testing6"+dateFormat);
	            try {
	                java.util.Date utilDate = dateFormat.parse(dobString);
	                System.out.println("testing7"+utilDate);
	                java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
	                System.out.println("testing8"+sqlDate);
	                applicant.setDob(sqlDate.toString());
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	            System.out.println("testing4"+applicant.getDob());
	            applicant.setGender(rs.getString("gender"));
	            applicant.setMstatus(rs.getString("mstatus"));
	            applicant.setAddress(rs.getString("address"));
	            applicant.setPhone(rs.getInt("phone"));
	            applicant.setEducation(rs.getString("education"));
	            applicant.setDegree(rs.getString("degree"));
	            System.out.println("testingggg"+applicant.getDegree());
	            applicant.setMajor(rs.getString("major"));
	            applicant.setMail(rs.getString("mail"));
	            System.out.println("testing5"+applicant.getMail());
	            applicant.setMark(rs.getInt("mark"));
	            applicant.setStatus(rs.getString("status"));
	        }

	        rs.close();
	        ps.close();
	        con.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return applicant;
	}
	
	public boolean updateApplicant(ApplicantModel model) {
	    boolean result = false;

	    try {
	        DBConfig db = new DBConfig();
	        Connection con = db.getConnection();

	        String sql = "UPDATE userapplicant SET name=?, nrc=?, fname=?, dob=?, gender=?, mstatus=?, address=?, phone=?, education=?, degree=?, major=?, mail=?, mark=?, status=? WHERE id=?";
	        PreparedStatement ps = con.prepareStatement(sql);

	        ps.setString(1, model.getName());
	        ps.setString(2, model.getNrc());
	        ps.setString(3, model.getFname());
	        ps.setString(4, model.getDob());
	        ps.setString(5, model.getGender());
	        ps.setString(6, model.getMstatus());
	        ps.setString(7, model.getAddress());
	        ps.setInt(8, model.getPhone());
	        ps.setString(9, model.getEducation());
	        ps.setString(10, model.getDegree());
	        ps.setString(11, model.getMajor());
	        ps.setString(12, model.getMail());
	        ps.setInt(13, model.getMark());
	        ps.setString(14, model.getStatus());
	        ps.setInt(15, model.getId());

	        int rows = ps.executeUpdate();
	        if (rows > 0) {
	            result = true;
	        }

	        ps.close();
	        con.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return result;
	}

}
