/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package details;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Hp
 */
public class job_info {

    private int no;
    private int id;
    public String com;
    public String jobt;
    public String loc;
    public String jobd;
    public String qual;
    public String Dl;
    public String stat;
    public byte[] pp;

    public job_info() {
    }

    private void initialize_data(String com, String jobt, String loc, String jobd, String qual, String Dl, byte[] pp){
        this.com = com;
        this.jobt = jobt;
        this.loc = loc;
        this.jobd = jobd;
        this.qual = qual;
        this.Dl = Dl;
        this.pp = pp;
    }
    public job_info(String com, String jobt, String loc, String jobd, String qual, String Dl, byte[] pp) {
        initialize_data(com,jobt,loc,jobd,qual,Dl,pp);
    }

    public job_info(int no, int id, String com, String jobt, String loc, String jobd, String qual, String Dl, String stat, byte[] pp) {
        this.no = no;
        this.id = id;
        this.com = com;
        this.jobt = jobt;
        this.loc = loc;
        this.jobd = jobd;
        this.qual = qual;
        this.Dl = Dl;
        this.stat=stat;
        this.pp = pp;
    }
    public job_info(ResultSet rs) throws SQLException {
        try {
            String comp = rs.getString("company");
            String jobti = rs.getString("job_title");
            String loca = rs.getString("location");
            String jobde = rs.getString("job_description");
            String quali = rs.getString("qualification");
            String dln = rs.getString("deadline");
            byte[] ppi=rs.getBytes("picture");
            initialize_data(comp, jobti, loca, jobde, quali, dln, ppi);
        } catch (SQLException e) {
            throw e;
        }

    }
    public int getNo() {
        return no;
    }

    /**
     * @param no the no to set
     */
    public void setNo(int no) {
        this.no = no;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the com
     */
    public String getCom() {
        return com;
    }

    /**
     * @param com the com to set
     */
    public void setCom(String com) {
        this.com = com;
    }

    /**
     * @return the jobt
     */
    public String getJobt() {
        return jobt;
    }

    /**
     * @param jobt the jobt to set
     */
    public void setJobt(String jobt) {
        this.jobt = jobt;
    }

    /**
     * @return the loc
     */
    public String getLoc() {
        return loc;
    }

    /**
     * @param loc the loc to set
     */
    public void setLoc(String loc) {
        this.loc = loc;
    }

    /**
     * @return the jobd
     */
    public String getJobd() {
        return jobd;
    }

    /**
     * @param jobd the jobd to set
     */
    public void setJobd(String jobd) {
        this.jobd = jobd;
    }

    /**
     * @return the qual
     */
    public String getQual() {
        return qual;
    }

    /**
     * @param qual the qual to set
     */
    public void setQual(String qual) {
        this.qual = qual;
    }

    /**
     * @return the Dl
     */
    public String getDl() {
        return Dl;
    }

    /**
     * @param Dl the Dl to set
     */
    public void setDl(String Dl) {
        this.Dl = Dl;
    }

    /**
     * @return the stat
     */
    public String getStat() {
        return stat;
    }

    /**
     * @param stat the stat to set
     */
    public void setStat(String stat) {
        this.stat = stat;
    }

    /**
     * @return the no
     */
    /**
     * @return the pp
     */
    public byte[] getPp() {
        return pp;
    }

    /**
     * @param pp the pp to set
     */
    public void setPp(byte[] pp) {
        this.pp = pp;
    }


}
