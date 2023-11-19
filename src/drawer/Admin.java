package drawer;

import Connection.Myconnection;
import com.mysql.cj.jdbc.Blob;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import opening.Homapage;
import careerpathx.ScrollBarCustom;
import dao.ImageIconCellRenderer;
import javaswingdev.drawer.Drawer;
import javaswingdev.drawer.DrawerController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javaswingdev.drawer.DrawerItem;
import dao.admindao;
import dao.applicantdao;
import dao.jseekerdao;
import dao.recruiterdao;
import dao.userdao;
import details.jseeker_info;
import details.recruiter_info;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import static javax.swing.SwingConstants.HORIZONTAL;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import try__.MessageDialog;

public class Admin extends javax.swing.JFrame {

    /**
     * Creates new form Admin
     */
    private DrawerController drawer;
    admindao ad = new admindao();
    Color notEdit = new Color(204, 204, 204);
    Color Edit = new Color(255, 255, 255);
    Color click = new Color(51, 102, 255);
    Color lay = new Color(0, 12, 102);
    Date date = new Date("Jan 1,2001");
    jseekerdao js = new jseekerdao();
    recruiterdao rc = new recruiterdao();
    userdao us = new userdao();
    applicantdao ap = new applicantdao();
    DefaultTableModel model = new DefaultTableModel();
    DefaultTableModel model1 = new DefaultTableModel();

    public Admin() {
        //GlassPanePopup.install(this);
        //xyz.setVisible(false);
        initComponents();
        showbarchart();
        showPieChart();
        showLineChart();
        populatetable();
        populatetable1();
        if (ap.countRows() == 0) {
            noti.setBadgeColor(notEdit);
        }
        noti.setText(String.valueOf(ap.countRows()));
        init();
        setTime();
        setNumbers();
        setProgressBar();
        setIcons();
        overview.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane4.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane4.setVerticalScrollBar(new ScrollBarCustom());
        jScrollPane3.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setVerticalScrollBar(new ScrollBarCustom());
        jScrollPane1.setVerticalScrollBar(new ScrollBarCustom());
        jScrollPane1.setVerticalScrollBar(new ScrollBarCustom());
        ScrollBarCustom sp = new ScrollBarCustom();
        sp.setOrientation(HORIZONTAL);
        jScrollPane1.setHorizontalScrollBar(sp);
        jScrollPane2.setVerticalScrollBar(new ScrollBarCustom());
        jScrollPane2.setVerticalScrollBar(new ScrollBarCustom());
        sp.setOrientation(HORIZONTAL);
        jScrollPane1.setHorizontalScrollBar(sp);
        jButton3.setEnabled(false);
        name.setEditable(false);
        email.setEditable(false);
        jButton2.setEnabled(false);
        jButton4.setEnabled(false);
        name1.setEditable(false);
        email1.setEditable(false);
        jButton5.setEnabled(false);
        ID.setEditable(false);
        ID1.setEditable(false);
        ID.setBackground(notEdit);
        ID1.setBackground(notEdit);
        name.setText(ad.getname(ID.getText()));
        email.setText(ad.getemail(ID.getText()));
        name1.setText(ad.getname(ID1.getText()));
        email1.setText(ad.getemail(ID1.getText()));
        jButton2.setBackground(notEdit);
        jButton4.setBackground(notEdit);
        jRadioButton1.setSelected(true);
        ImageIcon img = new ImageIcon(new ImageIcon(ad.getIcon(Integer.parseInt(ID.getText()))).getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));
        dp1.setIcon(img);
        ImageIcon img1 = new ImageIcon(new ImageIcon(ad.getIcon(Integer.parseInt(ID1.getText()))).getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));
        dp2.setIcon(img1);
        DrawerItem childItem1 = new DrawerItem("Home");
        DrawerItem childItem2 = new DrawerItem("Profile");
        DrawerItem childItem3 = new DrawerItem("JobSeeker Info");
        DrawerItem childItem4 = new DrawerItem("Recruiter Info");
        DrawerItem logout = new DrawerItem("Logout");
        Font itemFont = new Font("Roboto Medium", Font.PLAIN, 18);
        childItem1.setFont(itemFont);
        childItem2.setFont(itemFont);
        childItem3.setFont(itemFont);
        childItem4.setFont(itemFont);
        logout.setFont(itemFont);
        childItem1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTabbedPane1.setSelectedIndex(0);
            }
        });
        childItem2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTabbedPane1.setSelectedIndex(1);
            }
        });
        childItem3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTabbedPane1.setSelectedIndex(2);
            }
        });
        childItem4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTabbedPane1.setSelectedIndex(3);
            }
        });
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Homapage h = new Homapage();
                h.setVisible(true);
                dispose();
            }
        });

        drawer = Drawer.newDrawer(this)
                .drawerWidth(300)
                .headerHeight(200)
                .header(new DrawerItem("").icon(new ImageIcon(getClass().getResource("/Asset/java_dev.png"))).build())
                .space(5)
                .itemHeight(50)
                .separator(2, new Color(0, 0, 102))
                .background(new Color(0, 0, 0))
                .addChild(childItem1.icon(new ImageIcon(getClass().getResource("/Asset/icons8-home-48.png"))).build())
                .separator(2, new Color(0, 0, 102))
                .background(new Color(0, 0, 0))
                .addChild(childItem2.icon(new ImageIcon(getClass().getResource("/Asset/icons8-test-account-48.png"))).build())
                .separator(2, new Color(0, 0, 102))
                .background(new Color(0, 0, 0))
                .addChild(childItem3.icon(new ImageIcon(getClass().getResource("/Asset/icons8-information-48.png"))).build())
                .separator(2, new Color(0, 0, 102))
                .background(new Color(0, 0, 0))
                .addChild(childItem4.icon(new ImageIcon(getClass().getResource("/Asset/icons8-information-48 (1).png"))).build())
                .separator(2, new Color(0, 0, 102))
                .addFooter(logout.icon(new ImageIcon(getClass().getResource("/Asset/icons8-logout.gif"))).build())
                .addFooter(new DrawerItem("").build())
                .build();
        close.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent me) {
                //close.setBackground(Color.RED);
                close.setCursor(new Cursor(Cursor.HAND_CURSOR));

            }
        });
        close.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
            }
        });
    }

    public void setNumbers() {
        try {
            Connection con = Myconnection.getConnection();
            String sql = "select count(id) from jseeker";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                int rowCount = rs.getInt(1);
                jLabel16.setText(Integer.toString(rowCount));
            }

            sql = "select count(rid) from recruiter";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            if (rs.next()) {
                int rowCount = rs.getInt(1);
                jLabel30.setText(Integer.toString(rowCount));
            }
            sql = "select count(no) from jobs";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            if (rs.next()) {
                int rowCount = rs.getInt(1);
                jLabel21.setText(Integer.toString(rowCount));
            }
            sql = "select count(no) from companies";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            if (rs.next()) {
                int rowCount = rs.getInt(1);
                jLabel23.setText(Integer.toString(rowCount));
            }
            sql = "SELECT SUM(profit) FROM admin_profit";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            if (rs.next()) {
                double totalPrice = rs.getDouble(1); // Use getDouble for numeric values
                jLabel25.setText("" + totalPrice);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void setProgressBar() {
        try {
            Connection con = Myconnection.getConnection();
            String sql;
            PreparedStatement pst;
            java.sql.ResultSet rs;
            String s = "select count(*) from review";
            PreparedStatement pst2 = con.prepareStatement(s);
            java.sql.ResultSet rs1 = pst2.executeQuery();

            if (rs1.next()) {
                int r = rs1.getInt(1);
                sql = "select count(*) from review where rev = 5";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                if (rs.next()) {
                    int rowCount = rs.getInt(1);
                    rowCount = (rowCount * 100) / r;
                    jProgressBar1.setValue(rowCount);
                }

                sql = "select count(*) from review where rev = 4";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();

                if (rs.next()) {
                    int rowCount = rs.getInt(1);
                    rowCount = (rowCount * 100) / r;
                    jProgressBar2.setValue(rowCount);
                }
                sql = "select count(*) from review where rev = 3";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                if (rs.next()) {
                    int rowCount = rs.getInt(1);
                    rowCount = (rowCount * 100) / r;
                    jProgressBar3.setValue(rowCount);
                }

                sql = "select count(*) from review where rev = 2";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();

                if (rs.next()) {
                    int rowCount = rs.getInt(1);
                    rowCount = (rowCount * 100) / r;
                    jProgressBar4.setValue(rowCount);
                }
                sql = "select count(*) from review where rev = 1";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();

                if (rs.next()) {
                    int rowCount = rs.getInt(1);
                    rowCount = (rowCount * 100) / r;
                    jProgressBar5.setValue(rowCount);
                }

            }
            String countSql = "select count(*) from review where rev != 0";
            PreparedStatement countPst = con.prepareStatement(countSql);
            ResultSet countRs = countPst.executeQuery();

            if (countRs.next()) {
                int rowCountRevNotZero = countRs.getInt(1);
                jLabel44.setText(""+rowCountRevNotZero);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    ImageIcon page1 = new ImageIcon(getClass().getResource("/Asset/icons8-starC-48.png"));

    public void setIcons() {
        try {
            Connection con = Myconnection.getConnection();
            String countSql = "select count(*) from review";
            PreparedStatement countPst = con.prepareStatement(countSql);
            ResultSet countRs = countPst.executeQuery();

            if (countRs.next()) {
                int totalReviews = countRs.getInt(1);

                // Calculate the average
                String avgSql = "select avg(rev) as average_review from review where rev!=0";
                PreparedStatement avgPst = con.prepareStatement(avgSql);
                ResultSet avgRs = avgPst.executeQuery();

                if (avgRs.next()) {
                    double averageReview = avgRs.getDouble("average_review");
                    String r = String.format("%.1f", averageReview);
                    jLabel38.setText(r);
                    if (averageReview >= 1.0) {
                        one.setIcon(page1);
                    }
                    if (averageReview >= 2.0) {
                        two.setIcon(page1);
                    }
                    if (averageReview >= 3.0) {
                        three.setIcon(page1);
                    }
                    if (averageReview >= 4.0) {
                        four.setIcon(page1);
                    }
                    if (averageReview == 5.0) {
                        five.setIcon(page1);
                    }
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void setTime() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Date date = new Date();
                    SimpleDateFormat tf = new SimpleDateFormat("hh:mm:ss aa");
                    SimpleDateFormat df = new SimpleDateFormat("EEEE,dd-MM-YYYY");
                    String time = tf.format(date);
                    jtime.setText(time.split(" ")[0] + " " + time.split(" ")[1]);
                    jdate.setText(df.format(date));
                }
            }
        }).start();
    }

    private void showbarchart() {
        DefaultCategoryDataset dcd = new DefaultCategoryDataset();

        try {
            Connection con = Myconnection.getConnection();
            String sql = "SELECT company, COUNT(no) AS cnt FROM companies GROUP BY company";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String company = rs.getString("company");
                double cnt = rs.getDouble("cnt");
                dcd.addValue(cnt, "job offer", company);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JFreeChart jchart = ChartFactory.createBarChart3D(
                "Company Record",
                "Company Name",
                "Job Number",
                dcd,
                PlotOrientation.VERTICAL,
                false,
                true,
                false
        );

        CategoryPlot plot = jchart.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.BLACK);

        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, Color.BLUE); // Customize the color for series 0 (job offer)

        jchart.setBackgroundPaint(Color.white); // Set the chart's background color

        ChartPanel chartpanel = new ChartPanel(jchart);
        barchart.removeAll();
        barchart.add(chartpanel);
        barchart.updateUI();
    }

    public void showPieChart() {

        //create dataset
        DefaultPieDataset barDataset = new DefaultPieDataset();

        try {
            Connection con = Myconnection.getConnection();
            String sql = "SELECT job_title, COUNT(no) AS cnt FROM jobs GROUP BY job_title";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                barDataset.setValue(rs.getString("job_title"), Double.valueOf(rs.getDouble("cnt")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JFreeChart piechart = ChartFactory.createPieChart("JOB Type", barDataset, false, true, false);//explain

        PiePlot piePlot = (PiePlot) piechart.getPlot();
        piePlot.setSectionPaint("Accounting", new Color(3, 48, 252));
        piePlot.setSectionPaint("IT", new Color(0, 255, 102));
        piePlot.setSectionPaint("Design", new Color(222, 200, 55));
        piePlot.setSectionPaint("Marketing", new Color(222, 55, 72));

        piePlot.setBackgroundPaint(new Color(222, 220, 220));
        piechart.setBackgroundPaint(Color.white);

        //create chartPanel to display chart(graph)
        ChartPanel barChartPanel = new ChartPanel(piechart);
        pie.removeAll();
        pie.add(barChartPanel, BorderLayout.CENTER);
        pie.validate();
    }

    public void showLineChart() {
        // Create dataset for the graph
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        try {
            Connection con = Myconnection.getConnection();
            String sql = "SELECT MONTH(dateadd) AS month, SUM(profit) AS total_profit FROM admin_profit GROUP BY MONTH(dateadd)";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                // Extract month and total profit from the result set
                int month = rs.getInt("month");
                int totalProfit = rs.getInt("total_profit");

                // Add data to the dataset
                dataset.addValue(totalProfit, "Monthly Profit", getMonthName(month));
            }

            JFreeChart linechart = ChartFactory.createLineChart("contribution", "monthly", "amount",
                    dataset, PlotOrientation.VERTICAL, false, true, false);

            CategoryPlot lineCategoryPlot = linechart.getCategoryPlot();
            lineCategoryPlot.setBackgroundPaint(Color.lightGray); // Set the background color

            LineAndShapeRenderer lineRenderer = (LineAndShapeRenderer) lineCategoryPlot.getRenderer();
            Color lineChartColor = new Color(204, 0, 51);
            lineRenderer.setSeriesPaint(0, Color.black);
            linechart.setBackgroundPaint(Color.white);
            // Create a thicker line stroke
            BasicStroke lineStroke = new BasicStroke(2.0f); // Adjust line thickness as needed

            // Apply the thicker line stroke to the first series (series index 0)
            lineRenderer.setSeriesStroke(0, lineStroke);

            ChartPanel lineChartPanel = new ChartPanel(linechart);
            grph.removeAll();
            grph.add(lineChartPanel, BorderLayout.CENTER);
            grph.validate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getMonthName(int month) {
        // Convert month number to month name (assuming 1-based index)
        return new DateFormatSymbols().getMonths()[month - 1];
    }

    private void init() {
        jButton8.setEnabled(false);
        uid.setEditable(false);
        dob.setDate(date);
        jButton11.setEnabled(false);
        jButton16.setEnabled(false);
        uid1.setEditable(false);
        dob1.setDate(date);
        jButton18.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        adname = new javax.swing.JLabel();
        jtime = new javax.swing.JLabel();
        jdate = new javax.swing.JLabel();
        close = new javax.swing.JLabel();
        noti = new try__.BadgeButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        overview = new javax.swing.JScrollPane();
        overviewtab = new javax.swing.JPanel();
        barchart = new javax.swing.JPanel();
        grph = new javax.swing.JPanel();
        pie = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jProgressBar2 = new javax.swing.JProgressBar();
        jProgressBar3 = new javax.swing.JProgressBar();
        jProgressBar4 = new javax.swing.JProgressBar();
        jProgressBar5 = new javax.swing.JProgressBar();
        jLabel2 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        one = new javax.swing.JLabel();
        two = new javax.swing.JLabel();
        three = new javax.swing.JLabel();
        four = new javax.swing.JLabel();
        five = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        profiletab = new javax.swing.JPanel();
        dp1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        email = new javax.swing.JTextField();
        name = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        ID = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        dp2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        email1 = new javax.swing.JTextField();
        name1 = new javax.swing.JTextField();
        ID1 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jobseeker_infotab = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtable = new rojeru_san.complementos.RSTableMetro();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        dp = new javax.swing.JLabel();
        jRadioButton2 = new javax.swing.JRadioButton();
        jButton12 = new javax.swing.JButton();
        uid = new try__.TextField();
        email2 = new try__.TextField();
        name2 = new try__.TextField();
        contact = new try__.TextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        pass = new careerpathx.PasswordField();
        jLabel27 = new javax.swing.JLabel();
        dob = new com.toedter.calendar.JDateChooser();
        textAreaScroll1 = new try__.TextAreaScroll();
        add = new try__.TextArea();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        rec_infotab = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        dp3 = new javax.swing.JLabel();
        uid1 = new try__.TextField();
        jButton18 = new javax.swing.JButton();
        email3 = new try__.TextField();
        name3 = new try__.TextField();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jButton16 = new javax.swing.JButton();
        contact1 = new try__.TextField();
        dob1 = new com.toedter.calendar.JDateChooser();
        jButton14 = new javax.swing.JButton();
        pass1 = new careerpathx.PasswordField();
        jLabel28 = new javax.swing.JLabel();
        textAreaScroll2 = new try__.TextAreaScroll();
        add1 = new try__.TextArea();
        jButton15 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton17 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtable1 = new rojeru_san.complementos.RSTableMetro();
        jLabel26 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(39, 24, 126));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Asset/icons8-dashboard-40.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        adname.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        adname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jtime.setFont(new java.awt.Font("Segoe UI", 2, 16)); // NOI18N
        jtime.setForeground(new java.awt.Color(255, 255, 255));

        jdate.setFont(new java.awt.Font("Segoe UI", 2, 16)); // NOI18N
        jdate.setForeground(new java.awt.Color(255, 255, 255));

        close.setBackground(new java.awt.Color(255, 255, 255));
        close.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        close.setForeground(new java.awt.Color(255, 255, 255));
        close.setText("X");

        noti.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        noti.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Asset/icons8-notification-30.png"))); // NOI18N
        noti.setLabel("9");
        noti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(jtime, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(109, 109, 109)
                        .addComponent(jdate, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 557, Short.MAX_VALUE)
                        .addComponent(adname, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(239, 239, 239)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(noti, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(103, 103, 103))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(close)
                        .addGap(14, 14, 14))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(close, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jdate, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtime, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(noti, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(adname, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1500, 100));

        overviewtab.setBackground(new java.awt.Color(255, 255, 255));
        overviewtab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        barchart.setBackground(new java.awt.Color(255, 255, 255));
        barchart.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        barchart.setLayout(new java.awt.BorderLayout());
        overviewtab.add(barchart, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 960, 500, 320));

        grph.setBackground(new java.awt.Color(255, 255, 255));
        grph.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        grph.setLayout(new java.awt.BorderLayout());
        overviewtab.add(grph, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 960, 500, 320));

        pie.setBackground(new java.awt.Color(255, 255, 255));
        pie.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        pie.setLayout(new java.awt.BorderLayout());
        overviewtab.add(pie, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 1330, 520, 320));

        jSeparator1.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        overviewtab.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 110, 80, 210));

        jSeparator2.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        overviewtab.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, 80, 220));

        jSeparator3.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        overviewtab.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 100, 80, 220));

        jSeparator4.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        overviewtab.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 100, 80, 220));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("jLabel16");
        overviewtab.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 226, -1));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("jLabel16");
        overviewtab.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 210, 226, -1));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("jLabel16");
        overviewtab.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 210, 226, -1));

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("jLabel16");
        overviewtab.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 210, 226, -1));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("jLabel16");
        overviewtab.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 210, 214, 50));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Asset/icons8-group-of-companies-100.png"))); // NOI18N
        overviewtab.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 120, 100, 90));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Asset/icons8-jobs-100.png"))); // NOI18N
        overviewtab.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, 100, 100));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Asset/icons8-profit-100.png"))); // NOI18N
        overviewtab.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 120, 100, 90));

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Asset/icons8-recruiter-100.png"))); // NOI18N
        overviewtab.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 120, 100, 90));

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Asset/icons8-opportunity-100.png"))); // NOI18N
        overviewtab.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 100, 90));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("No of Recruiters");
        overviewtab.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 270, 150, 30));

        jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("No of Jobseekers");
        overviewtab.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, 150, 30));

        jLabel32.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("Total Profits");
        overviewtab.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 270, 150, 30));

        jLabel33.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("Companies");
        overviewtab.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 270, 150, 30));

        jLabel34.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("No of Jobs");
        overviewtab.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 280, 150, 30));

        jPanel8.setBackground(new java.awt.Color(51, 51, 51));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("© Copyright 2030 CareerPathX - All Rights Reserved");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(549, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(542, 542, 542))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel13)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        overviewtab.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1690, 1510, -1));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Asset/overview.png"))); // NOI18N
        overviewtab.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Reviews", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 3, 24), new java.awt.Color(0, 102, 102))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("5");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setText("4");

        jLabel35.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel35.setText("2");

        jLabel36.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel36.setText("3");

        jLabel37.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel37.setText("1");

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 60)); // NOI18N
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("4");

        one.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Asset/icons8-star-48.png"))); // NOI18N
        one.setText("jLabel39");

        two.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Asset/icons8-star-48.png"))); // NOI18N
        two.setText("jLabel39");

        three.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Asset/icons8-star-48.png"))); // NOI18N
        three.setText("jLabel39");

        four.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Asset/icons8-star-48.png"))); // NOI18N
        four.setText("jLabel39");

        five.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Asset/icons8-star-48.png"))); // NOI18N
        five.setText("jLabel39");

        jLabel44.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(102, 102, 102));
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setText("jLabel44");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(one, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(two, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(three, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(four, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(five, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jProgressBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jProgressBar3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jProgressBar4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jProgressBar5, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(115, 115, 115))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jProgressBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jProgressBar3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jProgressBar4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jProgressBar5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(110, 110, 110))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(one)
                            .addComponent(two)
                            .addComponent(three)
                            .addComponent(four)
                            .addComponent(five))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        overviewtab.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 460, 870, 430));

        overview.setViewportView(overviewtab);

        jTabbedPane1.addTab("tab6", overview);

        profiletab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dp1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        dp1.setPreferredSize(new java.awt.Dimension(200, 200));
        profiletab.add(dp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, -1, -1));

        jLabel3.setFont(new java.awt.Font("Perpetua", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Name : ");
        profiletab.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 140, 109, 37));

        jLabel4.setFont(new java.awt.Font("Perpetua", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Email : ");
        profiletab.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 220, 109, 40));

        jButton2.setBackground(new java.awt.Color(51, 102, 255));
        jButton2.setFont(new java.awt.Font("Perpetua", 1, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Upload");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        profiletab.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 290, 200, 36));

        email.setFont(new java.awt.Font("Perpetua", 1, 20)); // NOI18N
        profiletab.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 210, 351, 51));

        name.setFont(new java.awt.Font("Perpetua", 1, 20)); // NOI18N
        profiletab.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 150, 351, 51));

        jLabel5.setFont(new java.awt.Font("Perpetua", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("ID :");
        profiletab.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, 109, 37));

        ID.setFont(new java.awt.Font("Perpetua", 1, 20)); // NOI18N
        ID.setText("1");
        profiletab.add(ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 80, 351, 51));

        jButton3.setFont(new java.awt.Font("Perpetua", 1, 24)); // NOI18N
        jButton3.setText("Update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        profiletab.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 200, 200, 51));

        dp2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        dp2.setPreferredSize(new java.awt.Dimension(200, 200));
        profiletab.add(dp2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 390, -1, -1));

        jButton4.setBackground(new java.awt.Color(51, 102, 255));
        jButton4.setFont(new java.awt.Font("Perpetua", 1, 24)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Upload");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        profiletab.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 600, 200, 36));

        jLabel6.setFont(new java.awt.Font("Perpetua", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("ID :");
        profiletab.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 390, 109, 37));

        jLabel7.setFont(new java.awt.Font("Perpetua", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Name : ");
        profiletab.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 460, 109, 37));

        jLabel8.setFont(new java.awt.Font("Perpetua", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Email : ");
        profiletab.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 540, 109, 27));

        email1.setFont(new java.awt.Font("Perpetua", 1, 20)); // NOI18N
        profiletab.add(email1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 530, 351, 51));

        name1.setFont(new java.awt.Font("Perpetua", 1, 20)); // NOI18N
        profiletab.add(name1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 460, 351, 51));

        ID1.setFont(new java.awt.Font("Perpetua", 1, 20)); // NOI18N
        ID1.setText("2");
        profiletab.add(ID1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 390, 351, 51));

        jButton5.setFont(new java.awt.Font("Perpetua", 1, 24)); // NOI18N
        jButton5.setText("Update");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        profiletab.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 530, 200, 51));

        jButton6.setFont(new java.awt.Font("Perpetua", 1, 24)); // NOI18N
        jButton6.setText("Edit");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        profiletab.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 390, 200, 51));

        jButton7.setFont(new java.awt.Font("Perpetua", 1, 24)); // NOI18N
        jButton7.setText("Edit");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        profiletab.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 70, 200, 51));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Asset/admin_bg.png"))); // NOI18N
        profiletab.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, -5, 1506, 780));

        jTabbedPane1.addTab("tab2", profiletab);

        jobseeker_infotab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jtable.setColorBackgoundHead(new java.awt.Color(0, 153, 153));
        jtable.setColorFilasBackgound2(new java.awt.Color(186, 224, 224));
        jtable.setColorFilasForeground1(new java.awt.Color(0, 51, 51));
        jtable.setColorFilasForeground2(new java.awt.Color(0, 51, 51));
        jtable.setColorSelBackgound(new java.awt.Color(90, 174, 174));
        jtable.setFuenteFilas(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtable.setFuenteFilasSelect(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtable.setFuenteHead(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jtable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtable);

        jobseeker_infotab.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 1130, 710));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton8.setBackground(new java.awt.Color(0, 102, 102));
        jButton8.setFont(new java.awt.Font("Perpetua", 1, 24)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Save");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 771, -1, -1));

        jButton9.setBackground(new java.awt.Color(0, 102, 102));
        jButton9.setFont(new java.awt.Font("Perpetua", 1, 24)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("New");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 771, -1, -1));

        jButton10.setBackground(new java.awt.Color(0, 102, 102));
        jButton10.setFont(new java.awt.Font("Perpetua", 1, 24)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("Update");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(234, 771, -1, -1));

        jButton11.setBackground(new java.awt.Color(0, 102, 102));
        jButton11.setFont(new java.awt.Font("Perpetua", 1, 24)); // NOI18N
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setText("Delete");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 812, -1, -1));

        jButton13.setBackground(new java.awt.Color(0, 102, 102));
        jButton13.setFont(new java.awt.Font("Perpetua", 1, 24)); // NOI18N
        jButton13.setForeground(new java.awt.Color(255, 255, 255));
        jButton13.setText("View Selected Profile");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 859, -1, -1));

        dp.setBackground(new java.awt.Color(204, 255, 255));
        dp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        dp.setForeground(new java.awt.Color(255, 255, 255));
        dp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.add(dp, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 158, 164));

        jRadioButton2.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButton2.setText("Male");
        jRadioButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 700, 120, 30));

        jButton12.setBackground(new java.awt.Color(0, 102, 102));
        jButton12.setFont(new java.awt.Font("Perpetua", 1, 24)); // NOI18N
        jButton12.setForeground(new java.awt.Color(255, 255, 255));
        jButton12.setText("upload");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 204, 160, 40));

        uid.setLabelText("UserID");
        jPanel1.add(uid, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 256, 297, -1));

        email2.setLabelText("Email");
        jPanel1.add(email2, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 308, 297, -1));

        name2.setLabelText("Name");
        jPanel1.add(name2, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 360, 297, -1));

        contact.setLabelText("Contact no");
        contact.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                contactKeyPressed(evt);
            }
        });
        jPanel1.add(contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 464, 297, -1));

        jRadioButton1.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButton1.setText("Female");
        jRadioButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 700, 120, 30));

        pass.setLabelText("Password");
        jPanel1.add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 412, 297, -1));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(102, 102, 102));
        jLabel27.setText("Date Of Birth :");
        jPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 516, 98, -1));

        dob.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(dob, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 542, 297, 35));

        textAreaScroll1.setLabelText("Address");

        add.setColumns(20);
        add.setRows(5);
        textAreaScroll1.setViewportView(add);

        jPanel1.add(textAreaScroll1, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 583, 297, 84));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Gender");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 670, -1, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Asset/jseeker_bg.png"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 750));

        jScrollPane3.setViewportView(jPanel1);

        jobseeker_infotab.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 370, 720));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Asset/jseeker_bg.png"))); // NOI18N
        jLabel17.setText("jLabel9");
        jLabel17.setPreferredSize(new java.awt.Dimension(1500, 770));
        jobseeker_infotab.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(-5, 0, 1500, 710));

        jTabbedPane1.addTab("tab3", jobseeker_infotab);

        rec_infotab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dp3.setBackground(new java.awt.Color(204, 255, 255));
        dp3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        dp3.setForeground(new java.awt.Color(255, 255, 255));
        dp3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel3.add(dp3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 158, 164));

        uid1.setLabelText("UserID");
        jPanel3.add(uid1, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 256, 297, -1));

        jButton18.setBackground(new java.awt.Color(67, 67, 158));
        jButton18.setFont(new java.awt.Font("Perpetua", 1, 24)); // NOI18N
        jButton18.setForeground(new java.awt.Color(255, 255, 255));
        jButton18.setText("Delete");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton18, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 800, 120, 40));

        email3.setLabelText("Email");
        jPanel3.add(email3, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 308, 297, -1));

        name3.setLabelText("Name");
        jPanel3.add(name3, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 360, 297, -1));

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButton3.setText("Female");
        jPanel3.add(jRadioButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 690, 98, -1));

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButton4.setText("Male");
        jPanel3.add(jRadioButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 680, 98, -1));

        jButton16.setBackground(new java.awt.Color(67, 67, 158));
        jButton16.setFont(new java.awt.Font("Perpetua", 1, 24)); // NOI18N
        jButton16.setForeground(new java.awt.Color(255, 255, 255));
        jButton16.setText("Save");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 750, 120, 40));

        contact1.setLabelText("Contact no");
        contact1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                contact1KeyPressed(evt);
            }
        });
        jPanel3.add(contact1, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 464, 297, -1));

        dob1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel3.add(dob1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 540, 300, 40));

        jButton14.setBackground(new java.awt.Color(67, 67, 158));
        jButton14.setFont(new java.awt.Font("Perpetua", 1, 24)); // NOI18N
        jButton14.setForeground(new java.awt.Color(255, 255, 255));
        jButton14.setText("upload");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 160, 40));

        pass1.setLabelText("Password");
        jPanel3.add(pass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 412, 297, -1));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(102, 102, 102));
        jLabel28.setText("Date Of Birth :");
        jPanel3.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 516, 98, -1));

        textAreaScroll2.setLabelText("Address");

        add1.setColumns(20);
        add1.setRows(5);
        textAreaScroll2.setViewportView(add1);

        jPanel3.add(textAreaScroll2, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 583, 297, 84));

        jButton15.setBackground(new java.awt.Color(67, 67, 158));
        jButton15.setFont(new java.awt.Font("Perpetua", 1, 24)); // NOI18N
        jButton15.setForeground(new java.awt.Color(255, 255, 255));
        jButton15.setText("New");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 750, 100, 40));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("Gender");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 670, -1, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Asset/recruiter_bg.png"))); // NOI18N
        jLabel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 740));

        jButton17.setBackground(new java.awt.Color(67, 67, 158));
        jButton17.setFont(new java.awt.Font("Perpetua", 1, 24)); // NOI18N
        jButton17.setForeground(new java.awt.Color(255, 255, 255));
        jButton17.setText("Update");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton17, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 750, -1, 40));

        jButton19.setBackground(new java.awt.Color(67, 67, 158));
        jButton19.setFont(new java.awt.Font("Perpetua", 1, 24)); // NOI18N
        jButton19.setForeground(new java.awt.Color(255, 255, 255));
        jButton19.setText("View Selected Profile");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 850, 310, 40));

        jScrollPane4.setViewportView(jPanel3);

        rec_infotab.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 370, 730));

        jtable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jtable1.setColorBackgoundHead(new java.awt.Color(91, 114, 170));
        jtable1.setColorFilasBackgound2(new java.awt.Color(186, 224, 224));
        jtable1.setColorFilasForeground1(new java.awt.Color(0, 51, 51));
        jtable1.setColorFilasForeground2(new java.awt.Color(0, 51, 51));
        jtable1.setColorSelBackgound(new java.awt.Color(90, 174, 174));
        jtable1.setFuenteFilas(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtable1.setFuenteFilasSelect(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtable1.setFuenteHead(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jtable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtable1);

        rec_infotab.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 1120, 720));

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Asset/recruiter_bg.png"))); // NOI18N
        rec_infotab.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1490, 720));

        jTabbedPane1.addTab("tab3", rec_infotab);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1500, 740));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
public boolean infoValid() {
        if (name.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill out the Phone Number", "Invalid", 2);
            return false;
        } else if (email.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill out the Email Address", "Invalid", 2);
            return false;
        } else if (!email.getText().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            JOptionPane.showMessageDialog(null, "Invalid Email Address", "Invalid", 2);
            return false;
        }
        return true;

    }

    public boolean infoValid1() {
        if (name1.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill out the Phone Number", "Invalid", 2);
            return false;
        } else if (email1.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill out the Email Address", "Invalid", 2);
            return false;
        } else if (!email1.getText().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            JOptionPane.showMessageDialog(null, "Invalid Email Address", "Invalid", 2);
            return false;
        }
        return true;

    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (drawer.isShow()) {
            drawer.hide();
        } else {
            drawer.show();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        int returnVal = chooser.showOpenDialog(null);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File f = chooser.getSelectedFile();
            String path = f.getAbsolutePath();
            try {
                BufferedImage bi = ImageIO.read(new File(path));
                Image img = bi.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(img);
                dp1.setIcon(icon);
            } catch (IOException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            // Handle the case where the user canceled the file selection
            // You can provide a message or perform other actions as needed.
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        if (infoValid()) {
            String id = ID.getText();
            String Name = name.getText();
            String Email = email.getText();
            Icon icon = dp1.getIcon();
            BufferedImage bi = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics g = bi.createGraphics();
            icon.paintIcon(null, g, 0, 0);
            g.dispose();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            try {
                ImageIO.write(bi, "png", baos);
            } catch (IOException ex) {

            }
            InputStream imgStream = new ByteArrayInputStream(baos.toByteArray());
            ad.setInfo(id, Email, Name, imgStream);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        int returnVal = chooser.showOpenDialog(null);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File f = chooser.getSelectedFile();
            String path = f.getAbsolutePath();
            try {
                BufferedImage bi = ImageIO.read(new File(path));
                Image img = bi.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(img);
                dp2.setIcon(icon);
            } catch (IOException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            // Handle the case where the user canceled the file selection
            // You can provide a message or perform other actions as needed.
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        if (infoValid1()) {
            String id = ID1.getText();
            String Name = name1.getText();
            String Email = email1.getText();
            Icon icon = dp2.getIcon();
            BufferedImage bi = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics g = bi.createGraphics();
            icon.paintIcon(null, g, 0, 0);
            g.dispose();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            try {
                ImageIO.write(bi, "png", baos);
            } catch (IOException ex) {

            }
            InputStream imgStream = new ByteArrayInputStream(baos.toByteArray());
            ad.setInfo(id, Email, Name, imgStream);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        jButton4.setEnabled(true);
        name1.setEditable(true);
        email1.setEditable(true);
        jButton5.setEnabled(true);
        jButton4.setForeground(Color.white);
        jButton4.setBackground(click);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        jButton3.setEnabled(true);
        name.setEditable(true);
        email.setEditable(true);
        jButton2.setEnabled(true);
        jButton2.setForeground(Color.white);
        jButton2.setBackground(click);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        if (infoValidj()) {
            int id = js.getmaxrowj();
            String Email = email2.getText();
            String Name = name2.getText();
            String password = pass.getText();
            String Contact = contact.getText();
            String address = add.getText();
            String gen = (jRadioButton1.isSelected() ? "Female" : "Male");
            String Dob = "";
            Date selectedDate = dob.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Dob = dateFormat.format(selectedDate);
            Icon icon = dp.getIcon();
            InputStream imgStream = null;
            if (icon != null) {
                BufferedImage bi = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
                Graphics g = bi.createGraphics();
                icon.paintIcon(null, g, 0, 0);
                g.dispose();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                try {
                    ImageIO.write(bi, "png", baos);
                } catch (IOException ex) {

                }
                imgStream = new ByteArrayInputStream(baos.toByteArray());
            }
            js.insert(id, Email, Name, password, Contact, address, Dob, gen, imgStream);
            populatetable();
            jButton8.setEnabled(false);
            jButton10.setEnabled(true);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        jButton10.setEnabled(false);
        uid.setText(String.valueOf(js.getmaxrowj()));
        jButton8.setEnabled(true);
        email2.setText("");
        name2.setText("");
        pass.setText("");
        contact.setText("");
        dob.setDate(date);
        add.setText("");
    }//GEN-LAST:event_jButton9ActionPerformed
    public void populatetable() {
        ArrayList<jseeker_info> list = js.BindTable();
        String[] colname = {"UserID", "Email", "Name", "pass", "phone", "Address", "Date of Birth", "Gender", "Profile Picture"};
        Object[][] rows = new Object[list.size()][9];
        for (int i = 0; i < list.size(); i++) {
            rows[i][0] = list.get(i).getId();
            rows[i][1] = list.get(i).getEmail();
            rows[i][2] = list.get(i).getName();
            rows[i][3] = list.get(i).getPassword();
            rows[i][4] = list.get(i).getPhone();
            rows[i][5] = list.get(i).getAddress();
            rows[i][6] = list.get(i).getDob();
            rows[i][7] = list.get(i).getGender();
            if (list.get(i).getPp() != null) {
                ImageIcon img = new ImageIcon(new ImageIcon(list.get(i).getPp()).getImage().getScaledInstance(150, 120, Image.SCALE_SMOOTH));
                rows[i][8] = img;
            } else {
                rows[i][8] = null;
            }
        }
        model = new DefaultTableModel(rows, colname) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 8) { // Assuming the "Profile Picture" column is at index 8
                    return ImageIcon.class;
                }
                return super.getColumnClass(columnIndex);
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        jtable.setModel(model);
        jtable.setRowHeight(120);
        jtable.getColumnModel().getColumn(8).setCellRenderer(new ImageIconCellRenderer());

    }
    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        if (infoValidj()) {
            int id = Integer.parseInt(uid.getText());
            String Email = email2.getText();
            String Name = name2.getText();
            String password = pass.getText();
            String Contact = contact.getText();
            String address = add.getText();
            String gen = (jRadioButton1.isSelected() ? "Female" : "Male");
            String Dob = "";
            Date selectedDate = dob.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Dob = dateFormat.format(selectedDate);
            Icon icon = dp.getIcon();
            InputStream imgStream = null;
            if (icon != null) {
                BufferedImage bi = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
                Graphics g = bi.createGraphics();
                icon.paintIcon(null, g, 0, 0);
                g.dispose();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                try {
                    ImageIO.write(bi, "png", baos);
                } catch (IOException ex) {

                }
                imgStream = new ByteArrayInputStream(baos.toByteArray());

            }
            js.edit(id, Email, Name, password, Contact, address, Dob, gen, imgStream);
            populatetable();
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        int selrow = jtable.getSelectedRow();
        int id = (int) model.getValueAt(selrow, 0);
        MessageDialog obj = new MessageDialog(this);
        obj.showMessage("Delete account ?", "Are you Sure you want to delete this?\nThis data will lose if you press ok button");
        if (obj.getMessageType() == MessageDialog.MessageType.OK) {
            js.delete_row(id);
            populatetable();
        } else {
            //System.out.println("User click cancel");
        }

    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        int returnVal = chooser.showOpenDialog(null);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File f = chooser.getSelectedFile();
            String path = f.getAbsolutePath();
            try {
                BufferedImage bi = ImageIO.read(new File(path));
                Image img = bi.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(img);
                dp.setIcon(icon);
            } catch (IOException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            // Handle the case where the user canceled the file selection
            // You can provide a message or perform other actions as needed.
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jtableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtableMouseClicked
        // TODO add your handling code here:
        jButton11.setEnabled(true);
        jButton8.setEnabled(false);
        int selrow = jtable.getSelectedRow();
        uid.setText(model.getValueAt(selrow, 0).toString());
        email2.setText(model.getValueAt(selrow, 1).toString());
        name2.setText(model.getValueAt(selrow, 2).toString());
        pass.setText(model.getValueAt(selrow, 3).toString());
        contact.setText(model.getValueAt(selrow, 4).toString());
        add.setText(model.getValueAt(selrow, 5).toString());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        try {
            Date dateOfBirth = dateFormat.parse(model.getValueAt(selrow, 6).toString());
            dob.setDate(dateOfBirth);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        if (model.getValueAt(selrow, 7).toString().equals("Female")) {
            jRadioButton1.setSelected(true);
        } else {
            jRadioButton2.setSelected(true);
        }

        ImageIcon imgicon = (ImageIcon) model.getValueAt(selrow, 8);

        if (imgicon != null) {
            Image imglft = imgicon.getImage().getScaledInstance(dp.getWidth(), dp.getHeight(), Image.SCALE_SMOOTH);
            dp.setIcon(new ImageIcon(imglft));
        } else {
            dp.setIcon(null);
        }
    }//GEN-LAST:event_jtableMouseClicked

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        jseeker_p prf = new jseeker_p();
        prf.setVisible(true);
        prf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        int selrowprof = jtable.getSelectedRow();
        if (selrowprof == -1) {
            prf.jLabellNoselectedRowMessage.setText("No row is selected!");
        } else {
            prf.jLabellNoselectedRowMessage.setText(null);
            prf.jTextField1.setText(model.getValueAt(selrowprof, 0).toString());
            prf.jTextField2.setText(model.getValueAt(selrowprof, 1).toString());
            prf.jTextField3.setText(model.getValueAt(selrowprof, 2).toString());
            prf.jTextField4.setText(model.getValueAt(selrowprof, 3).toString());
            prf.jTextField5.setText(model.getValueAt(selrowprof, 4).toString());
            prf.jTextField6.setText(model.getValueAt(selrowprof, 5).toString());
            prf.jTextField7.setText(model.getValueAt(selrowprof, 6).toString());
            prf.jTextField8.setText(model.getValueAt(selrowprof, 7).toString());
            ImageIcon imgicon = (ImageIcon) model.getValueAt(selrowprof, 8);
            if (imgicon != null) {
                Image imglft = imgicon.getImage().getScaledInstance(dp.getWidth(), dp.getHeight(), Image.SCALE_SMOOTH);
                prf.pp.setIcon(new ImageIcon(imglft));
            } else {
                prf.pp.setIcon(null);
            }
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        int returnVal = chooser.showOpenDialog(null);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File f = chooser.getSelectedFile();
            String path = f.getAbsolutePath();
            try {
                BufferedImage bi = ImageIO.read(new File(path));
                Image img = bi.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(img);
                dp3.setIcon(icon);
            } catch (IOException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            // Handle the case where the user canceled the file selection
            // You can provide a message or perform other actions as needed.
        }
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        jButton17.setEnabled(false);
        uid1.setText(String.valueOf(rc.getmaxrowj()));
        jButton16.setEnabled(true);
        email3.setText("");
        name3.setText("");
        pass1.setText("");
        contact1.setText("");
        dob1.setDate(date);
        add1.setText("");
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
        if (infoValidr()) {
            int id = rc.getmaxrowj();
            String Email = email3.getText();
            String Name = name3.getText();
            String password = pass1.getText();
            String Contact = contact1.getText();
            String address = add1.getText();
            String gen = (jRadioButton3.isSelected() ? "Female" : "Male");
            String Dob = "";
            Date selectedDate = dob1.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Dob = dateFormat.format(selectedDate);
            Icon icon = dp3.getIcon();
            InputStream imgStream = null;
            if (icon != null) {
                BufferedImage bi = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
                Graphics g = bi.createGraphics();
                icon.paintIcon(null, g, 0, 0);
                g.dispose();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                try {
                    ImageIO.write(bi, "png", baos);
                } catch (IOException ex) {

                }
                imgStream = new ByteArrayInputStream(baos.toByteArray());

            }
            rc.insert(id, Email, Name, password, Contact, address, Dob, gen, imgStream);

            populatetable1();
            jButton16.setEnabled(false);
            jButton17.setEnabled(true);
        }
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
        if (infoValidr()) {
            int id = Integer.parseInt(uid1.getText());
            String Email = email3.getText();
            String Name = name3.getText();
            String password = pass1.getText();
            String Contact = contact1.getText();
            String address = add1.getText();
            String gen = (jRadioButton3.isSelected() ? "Female" : "Male");
            String Dob = "";
            Date selectedDate = dob1.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Dob = dateFormat.format(selectedDate);
            Icon icon = dp3.getIcon();
            InputStream imgStream = null;
            if (icon != null) {
                BufferedImage bi = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
                Graphics g = bi.createGraphics();
                icon.paintIcon(null, g, 0, 0);
                g.dispose();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                try {
                    ImageIO.write(bi, "png", baos);
                } catch (IOException ex) {

                }
                imgStream = new ByteArrayInputStream(baos.toByteArray());

            }
            rc.edit(id, Email, Name, password, Contact, address, Dob, gen, imgStream);
            populatetable1();
        }
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // TODO add your handling code here:
        int selrow = jtable1.getSelectedRow();
        int id = (int) model1.getValueAt(selrow, 0);
        MessageDialog obj = new MessageDialog(this);
        obj.showMessage("Delete account ?", "Are you Sure you want to delete this?\nThis data will lose if you press ok button");
        if (obj.getMessageType() == MessageDialog.MessageType.OK) {
            rc.delete_row(id);
            populatetable1();
        } else {
            //System.out.println("User click cancel");
        }
    }//GEN-LAST:event_jButton18ActionPerformed
    public void populatetable1() {
        ArrayList<recruiter_info> list = rc.BindTable();
        String[] colname = {"UserID", "Email", "Name", "pass", "phone", "Address", "Date of Birth", "Gender", "Profile Picture"};
        Object[][] rows = new Object[list.size()][9];
        for (int i = 0; i < list.size(); i++) {
            rows[i][0] = list.get(i).getId();
            rows[i][1] = list.get(i).getEmail();
            rows[i][2] = list.get(i).getName();
            rows[i][3] = list.get(i).getPassword();
            rows[i][4] = list.get(i).getPhone();
            rows[i][5] = list.get(i).getAddress();
            rows[i][6] = list.get(i).getDob();
            rows[i][7] = list.get(i).getGender();
            if (list.get(i).getPp() != null) {
                ImageIcon img = new ImageIcon(new ImageIcon(list.get(i).getPp()).getImage().getScaledInstance(150, 120, Image.SCALE_SMOOTH));
                rows[i][8] = img;
            } else {
                rows[i][8] = null;
            }
        }
        model1 = new DefaultTableModel(rows, colname) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 8) { // Assuming the "Profile Picture" column is at index 8
                    return ImageIcon.class;
                }
                return super.getColumnClass(columnIndex);
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        jtable1.setModel(model1);
        jtable1.setRowHeight(120);
        jtable1.getColumnModel().getColumn(8).setCellRenderer(new ImageIconCellRenderer());

    }
    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        // TODO add your handling code here:
        jseeker_p prf = new jseeker_p();
        prf.setVisible(true);
        prf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        int selrowprof = jtable1.getSelectedRow();
        if (selrowprof == -1) {
            prf.jLabellNoselectedRowMessage.setText("No row is selected!");
        } else {
            prf.jLabellNoselectedRowMessage.setText(null);
            prf.jTextField1.setText(model1.getValueAt(selrowprof, 0).toString());
            prf.jTextField2.setText(model1.getValueAt(selrowprof, 1).toString());
            prf.jTextField3.setText(model1.getValueAt(selrowprof, 2).toString());
            prf.jTextField4.setText(model1.getValueAt(selrowprof, 3).toString());
            prf.jTextField5.setText(model1.getValueAt(selrowprof, 4).toString());
            prf.jTextField6.setText(model1.getValueAt(selrowprof, 5).toString());
            prf.jTextField7.setText(model1.getValueAt(selrowprof, 6).toString());
            prf.jTextField8.setText(model1.getValueAt(selrowprof, 7).toString());
            ImageIcon imgicon = (ImageIcon) model1.getValueAt(selrowprof, 8);
            if (imgicon != null) {
                Image imglft = imgicon.getImage().getScaledInstance(dp3.getWidth(), dp3.getHeight(), Image.SCALE_SMOOTH);
                prf.pp.setIcon(new ImageIcon(imglft));
            } else {
                prf.pp.setIcon(null);
            }
        }
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jtable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtable1MouseClicked
        // TODO add your handling code here:
        jButton18.setEnabled(true);
        jButton16.setEnabled(false);
        int selrow = jtable1.getSelectedRow();
        uid1.setText(model1.getValueAt(selrow, 0).toString());
        email3.setText(model1.getValueAt(selrow, 1).toString());
        name3.setText(model1.getValueAt(selrow, 2).toString());
        pass1.setText(model1.getValueAt(selrow, 3).toString());
        contact1.setText(model1.getValueAt(selrow, 4).toString());
        add1.setText(model1.getValueAt(selrow, 5).toString());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        try {
            Date dateOfBirth = dateFormat.parse(model1.getValueAt(selrow, 6).toString());
            dob1.setDate(dateOfBirth);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        if (model1.getValueAt(selrow, 7).toString().equals("Female")) {
            jRadioButton3.setSelected(true);
        } else {
            jRadioButton4.setSelected(true);
        }

        ImageIcon imgicon = (ImageIcon) model1.getValueAt(selrow, 8);

        if (imgicon != null) {
            Image imglft = imgicon.getImage().getScaledInstance(dp3.getWidth(), dp3.getHeight(), Image.SCALE_SMOOTH);
            dp3.setIcon(new ImageIcon(imglft));
        } else {
            dp3.setIcon(null);
        }
    }//GEN-LAST:event_jtable1MouseClicked

    private void contactKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contactKeyPressed
        // TODO add your handling code here:
        String phn = contact.getText();
        int l = phn.length();
        char c = evt.getKeyChar();
        if (c >= '0' && c <= '9') {
            if (l < 11) {
                contact.setEditable(true);
            } else {
                contact.setEditable(false);
            }
        } else {
            if (evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
                contact.setEditable(true);
            } else {
                contact.setEditable(false);
            }
        }
    }//GEN-LAST:event_contactKeyPressed

    private void contact1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contact1KeyPressed
        // TODO add your handling code here:
        String phn = contact1.getText();
        int l = phn.length();
        char c = evt.getKeyChar();
        if (c >= '0' && c <= '9') {
            if (l < 11) {
                contact1.setEditable(true);
            } else {
                contact1.setEditable(false);
            }
        } else {
            if (evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
                contact1.setEditable(true);
            } else {
                contact1.setEditable(false);
            }
        }
    }//GEN-LAST:event_contact1KeyPressed

    private void notiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_notiActionPerformed
        // TODO add your handling code here:
        new Notification().setVisible(true);
    }//GEN-LAST:event_notiActionPerformed
    public boolean infoValidj() {
        if (name2.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill out the Phone Number", "Invalid", 2);
            return false;
        } else if (email2.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill out the Email Address", "Invalid", 2);
            return false;
        } else if (us.isEmailexist(email2.getText())) {
            JOptionPane.showMessageDialog(null, "Email Address is not available", "Invalid", 2);
            return false;
        } else if (!email2.getText().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            JOptionPane.showMessageDialog(null, "Invalid Email Address", "Invalid", 2);
            return false;
        } else if (pass.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Fill the Password", "Invalid", 2);
            return false;
        } else if (contact.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Fill the Password", "Invalid", 2);
            return false;
        } else if (us.isPhnexist(contact.getText())) {
            JOptionPane.showMessageDialog(null, "Phone number is not available", "Invalid", 2);
            return false;
        } else if (add.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Fill the Address", "Invalid", 2);
            return false;
        }
        return true;

    }

    public boolean infoValidr() {
        if (name3.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill out the Phone Number", "Invalid", 2);
            return false;
        } else if (email3.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill out the Email Address", "Invalid", 2);
            return false;
        } else if (!email3.getText().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            JOptionPane.showMessageDialog(null, "Invalid Email Address", "Invalid", 2);
            return false;
        } else if (us.isEmailexistr(email3.getText())) {
            JOptionPane.showMessageDialog(null, "Email Address is not available", "Invalid", 2);
            return false;
        } else if (pass1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Fill the Password", "Invalid", 2);
            return false;
        } else if (contact1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Fill the Password", "Invalid", 2);
            return false;
        } else if (us.isPhnexistr(contact1.getText())) {
            JOptionPane.showMessageDialog(null, "Phone number is not available", "Invalid", 2);
            return false;
        } else if (add1.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Fill the Address", "Invalid", 2);
            return false;
        }
        return true;

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ID;
    private javax.swing.JTextField ID1;
    private try__.TextArea add;
    private try__.TextArea add1;
    public javax.swing.JLabel adname;
    private javax.swing.JPanel barchart;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel close;
    private try__.TextField contact;
    private try__.TextField contact1;
    private com.toedter.calendar.JDateChooser dob;
    private com.toedter.calendar.JDateChooser dob1;
    private javax.swing.JLabel dp;
    private javax.swing.JLabel dp1;
    private javax.swing.JLabel dp2;
    private javax.swing.JLabel dp3;
    private javax.swing.JTextField email;
    private javax.swing.JTextField email1;
    private try__.TextField email2;
    private try__.TextField email3;
    private javax.swing.JLabel five;
    private javax.swing.JLabel four;
    private javax.swing.JPanel grph;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JProgressBar jProgressBar2;
    private javax.swing.JProgressBar jProgressBar3;
    private javax.swing.JProgressBar jProgressBar4;
    private javax.swing.JProgressBar jProgressBar5;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel jdate;
    private javax.swing.JPanel jobseeker_infotab;
    private rojeru_san.complementos.RSTableMetro jtable;
    private rojeru_san.complementos.RSTableMetro jtable1;
    private javax.swing.JLabel jtime;
    private javax.swing.JTextField name;
    private javax.swing.JTextField name1;
    private try__.TextField name2;
    private try__.TextField name3;
    private try__.BadgeButton noti;
    private javax.swing.JLabel one;
    private javax.swing.JScrollPane overview;
    private javax.swing.JPanel overviewtab;
    private careerpathx.PasswordField pass;
    private careerpathx.PasswordField pass1;
    private javax.swing.JPanel pie;
    private javax.swing.JPanel profiletab;
    private javax.swing.JPanel rec_infotab;
    private try__.TextAreaScroll textAreaScroll1;
    private try__.TextAreaScroll textAreaScroll2;
    private javax.swing.JLabel three;
    private javax.swing.JLabel two;
    private try__.TextField uid;
    private try__.TextField uid1;
    // End of variables declaration//GEN-END:variables
}
