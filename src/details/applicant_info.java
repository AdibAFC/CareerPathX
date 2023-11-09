/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package details;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 *
 * @author Hp
 */
public class applicant_info {

    public int app_id;
    public int rid;
    public String jt;
    public String an;
    public byte[] cv;
    public Timestamp ad;
    public String ap;
    /**
     * @return the app_id
     */
    public int getApp_id() {
        return app_id;
    }

    /**
     * @param app_id the app_id to set
     */
    public void setApp_id(int app_id) {
        this.app_id = app_id;
    }

    /**
     * @return the rid
     */
    public int getRid() {
        return rid;
    }

    /**
     * @param rid the rid to set
     */
    public void setRid(int rid) {
        this.rid = rid;
    }

    /**
     * @return the jt
     */
    public String getJt() {
        return jt;
    }

    /**
     * @param jt the jt to set
     */
    public void setJt(String jt) {
        this.jt = jt;
    }

    /**
     * @return the an
     */
    public String getAn() {
        return an;
    }

    /**
     * @param an the an to set
     */
    public void setAn(String an) {
        this.an = an;
    }

    /**
     * @return the cv
     */
    public byte[] getCv() {
        return cv;
    }

    /**
     * @param cv the cv to set
     */
    public void setCv(byte[] cv) {
        this.cv = cv;
    }

    /**
     * @return the ad
     */
    public Timestamp getAd() {
        return ad;
    }

    /**
     * @param ad the ad to set
     */
    public void setAd(Timestamp ad) {
        this.ad = ad;
    }

    /**
     * @return the ap
     */
    public String getAp() {
        return ap;
    }

    /**
     * @param ap the ap to set
     */
    public void setAp(String ap) {
        this.ap = ap;
    }
    public applicant_info() {
    }

    private void initialize_data(int app_id,int rid, String jt, String an, byte[] cv, Timestamp ad){
        this.app_id=app_id;
        this.rid=rid;
        this.jt=jt;
        this.an=an;
        this.cv=cv;
        this.ad=ad;
    }
    public applicant_info(int app_id,int rid, String jt, String an, byte[] cv, Timestamp ad, String ap) {
        this.app_id=app_id;
        this.rid=rid;
        this.jt=jt;
        this.an=an;
        this.cv=cv;
        this.ad=ad;
        this.ap=ap;
    }
    public applicant_info(int app_id,int rid, String jt, String an, byte[] cv, Timestamp ad) {
        initialize_data(app_id,rid,jt,an,cv, ad);
    }

    public applicant_info(ResultSet rs) throws SQLException {
        try {
            int ap_id = rs.getInt("application_id");
            int r = rs.getInt("rid");
            String jti = rs.getString("job_title");
            String aname = rs.getString("applicant_name");
            byte[] c=rs.getBytes("cv_data");
            Timestamp adate = rs.getTimestamp("application_date");
            
            initialize_data(ap_id,r,jti,aname,c, adate);
        } catch (SQLException e) {
            throw e;
        }

    }
}
