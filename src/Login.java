
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Login.java
 *
 * Created on May 3, 2017, 11:54:42 AM
 */

/**
 *
 * @author PC-12
 */
public class Login extends javax.swing.JFrame {

    /** Creates new form Login */
    public Login() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        txt_pwd = new javax.swing.JPasswordField();
        txt_usrnm = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        jButton3.setIcon(new javax.swing.ImageIcon("C:\\Users\\PC-11\\Documents\\CBS\\LogInButton.png")); // NOI18N
        jButton3.setText("LogIn");
        jButton3.setBorder(null);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(540, 310, 250, 50);

        txt_pwd.setText("********");
        txt_pwd.setBorder(null);
        txt_pwd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_pwdActionPerformed(evt);
            }
        });
        getContentPane().add(txt_pwd);
        txt_pwd.setBounds(570, 250, 230, 30);

        txt_usrnm.setText("Username");
        txt_usrnm.setBorder(null);
        getContentPane().add(txt_usrnm);
        txt_usrnm.setBounds(570, 190, 230, 30);

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\PC-11\\Documents\\CBS\\LogIn.png")); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 930, 540);

        pack();
    }// </editor-fold>//GEN-END:initComponents
java.sql.Connection con=null;
java.sql.Statement stmt=null;
String dr="java.sql.Driver";
String url="jdbc:mysql://localhost:3306/CBS";
String pwd="a";
String usr="root";
String qry="";
ResultSet rs=null;
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
 try {
            Class.forName(dr);
            con=DriverManager.getConnection(url, usr, pwd);
            stmt=con.createStatement();
            String pass=new String(txt_pwd.getPassword());
            qry="select* from login where usr_nm='"+txt_usrnm.getText()+"'and pwd='"+pass+"'";
            rs=stmt.executeQuery(qry);
            int  rs_cnt=0;
            while(rs.next())
                rs_cnt++;


            if(rs_cnt==0) {
               JOptionPane.showMessageDialog(rootPane, "Invalid username or password..!!!");

            }
            else if(rs_cnt==1)
            {
            frmMDI Opn = new frmMDI();
            Opn.setVisible(true);

            }
            else
                JOptionPane.showMessageDialog(rootPane, "Invalid username or password..!!!");

//            if(rs_cnt>0) {
//               fORM_NAME OBJECT = new FORM-NAME();
//                OBJECT.setVisible(true);
//            }


        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);

        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txt_pwdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_pwdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_pwdActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
this.setBounds(150, 50, 928, 580);        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField txt_pwd;
    private javax.swing.JTextField txt_usrnm;
    // End of variables declaration//GEN-END:variables

}
