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
public class com_info {

    public String cname;
    public String ctype;
    public String loc;
    public String indus;
    public String web;
    public byte[] logo;
    public com_info() {
    }

    private void initialize_data(String cname,String ctype,String loc,String indus,String web,byte[] logo){
        this.cname = cname;
        this.ctype = ctype;
        this.loc = loc;
        this.indus = indus;
        this.web = web;
        this.logo = logo;
    }
    public com_info(String cname,String ctype,String loc,String indus,String web,byte[] logo) {
        initialize_data(cname,ctype,loc,indus,web,logo);
    }
    public com_info(ResultSet rs) throws SQLException {
        try {
            String comp = rs.getString("company");
            String type = rs.getString("company_type");
            String loca = rs.getString("location");
            String ind = rs.getString("industry");
            String link = rs.getString("website");
            byte[] pp=rs.getBytes("company_logo");
            initialize_data(comp,type,loca,ind,link,pp);
        } catch (SQLException e) {
            throw e;
        }

    }
    /**
     * @return the cname
     */
    public String getCname() {
        return cname;
    }

    /**
     * @param cname the cname to set
     */
    public void setCname(String cname) {
        this.cname = cname;
    }

    /**
     * @return the ctype
     */
    public String getCtype() {
        return ctype;
    }

    /**
     * @param ctype the ctype to set
     */
    public void setCtype(String ctype) {
        this.ctype = ctype;
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
     * @return the indus
     */
    public String getIndus() {
        return indus;
    }

    /**
     * @param indus the indus to set
     */
    public void setIndus(String indus) {
        this.indus = indus;
    }

    /**
     * @return the web
     */
    public String getWeb() {
        return web;
    }

    /**
     * @param web the web to set
     */
    public void setWeb(String web) {
        this.web = web;
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
    
    
}
