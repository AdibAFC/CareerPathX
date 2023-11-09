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
public class service_info {

    

    private int no;
    public String title;
    public String des;
    public int pri;
    public String dur;
    public String tag;
    public byte[] logo;
    /**
     * @return the no
     */
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
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the des
     */
    public String getDes() {
        return des;
    }

    /**
     * @param des the des to set
     */
    public void setDes(String des) {
        this.des = des;
    }

    /**
     * @return the pri
     */
    public int getPri() {
        return pri;
    }

    /**
     * @param pri the pri to set
     */
    public void setPri(int pri) {
        this.pri = pri;
    }

    /**
     * @return the dur
     */
    public String getDur() {
        return dur;
    }

    /**
     * @param dur the dur to set
     */
    public void setDur(String dur) {
        this.dur = dur;
    }

    /**
     * @return the tag
     */
    public String getTag() {
        return tag;
    }

    /**
     * @param tag the tag to set
     */
    public void setTag(String tag) {
        this.tag = tag;
    }
    /**
     * @return the logo
     */
    public byte[] getLogo() {
        return logo;
    }

    /**
     * @param logo the logo to set
     */
    public void setLogo(byte[] logo) {
        this.logo = logo;
    }
    public service_info() {
    }

    private void initialize_data(int no,String title,String des,int pri,String dur,String tag,byte[] logo){
        this.no=no;
        this.title=title;
        this.des = des;
        this.pri = pri;
        this.dur = dur;
        this.tag=tag;
        this.logo = logo;
    }
    public service_info(int no,String title,String des,int pri,String dur,String tag,byte[] logo) {
        initialize_data(no,title,des,pri,dur,tag,logo);
    }
    public service_info(ResultSet rs) throws SQLException {
        try {
            int n=rs.getInt("no");
            String ti = rs.getString("title");
            String d = rs.getString("description");
            int p = rs.getInt("price");
            String du = rs.getString("duration");
            String tg = rs.getString("tag");
            byte[] pp=rs.getBytes("logo");
            initialize_data(n,ti,d,p,du,tg,pp);
        } catch (SQLException e) {
            throw e;
        }

    }
    
}
