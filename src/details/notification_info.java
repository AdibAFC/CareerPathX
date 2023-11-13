/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package details;

import java.sql.Timestamp;

/**
 *
 * @author Hp
 */
public class notification_info {

    /**
     * @return the n_id
     */
    public int getN_id() {
        return n_id;
    }

    /**
     * @param n_id the n_id to set
     */
    public void setN_id(int n_id) {
        this.n_id = n_id;
    }

    /**
     * @return the semail
     */
    public String getSemail() {
        return semail;
    }

    /**
     * @param semail the semail to set
     */
    public void setSemail(String semail) {
        this.semail = semail;
    }

    /**
     * @return the remail
     */
    public String getRemail() {
        return remail;
    }

    /**
     * @param remail the remail to set
     */
    public void setRemail(String remail) {
        this.remail = remail;
    }

    /**
     * @return the txt
     */
    public String getTxt() {
        return txt;
    }

    /**
     * @param txt the txt to set
     */
    public void setTxt(String txt) {
        this.txt = txt;
    }

    /**
     * @return the is_rd
     */
    public Boolean getIs_rd() {
        return is_rd;
    }

    /**
     * @param is_rd the is_rd to set
     */
    public void setIs_rd(Boolean is_rd) {
        this.is_rd = is_rd;
    }

    /**
     * @return the nt_t
     */
    public Timestamp getNt_t() {
        return nt_t;
    }

    /**
     * @param nt_t the nt_t to set
     */
    public void setNt_t(Timestamp nt_t) {
        this.nt_t = nt_t;
    }
    private int n_id;
    private String semail;
    private String remail;
    private String txt;
    private Boolean is_rd;
    private Timestamp nt_t;

    public notification_info() {
    }

    public notification_info(int n_id, String semail, String remail, String txt, Boolean is_rd, Timestamp nt_t) {
        this.n_id = n_id;
        this.semail = semail;
        this.remail = remail;
        this.txt = txt;
        this.is_rd = is_rd;
        this.nt_t = nt_t;
    }
}
