package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.ApplicantModel;
import config.DBConfig;

public class ApplicantController {

    public Applicant getApplicantById(String id) {
        Applicant applicant = null;

        try {
            Connection con = DBConfig.getConnection();
            String sql = "SELECT * FROM applicant WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                applicant = new Applicant();
                applicant.setId(rs.getInt("id"));
                applicant.setName(rs.getString("name"));
                applicant.setGender(rs.getString("gender"));
                applicant.setEmail(rs.getString("email"));
                applicant.setPhone(rs.getString("phone"));
                applicant.setEducation(rs.getString("education"));
                applicant.setMajor(rs.getString("major"));
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
}
