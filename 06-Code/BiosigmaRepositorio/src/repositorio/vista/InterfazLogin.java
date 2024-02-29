package repositorio.vista;

import repositorio.vista.trabajador.InterfazTrabajadorJFrame;
import repositorio.vista.Cliente.InterfazCliente1JFrame;
import repositorio.vista.Admin.InterfazAdminJFrame;
import repositorio.vista.Admin.InterfazInicioAdministrador;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

public class InterfazLogin extends javax.swing.JFrame {

    public InterfazLogin() {
        initComponents();
        setIconImage(getIconImage());
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("resource/colibri_png.png"));
        lbAvisoLogin.setVisible(false);
        return retValue;
    }

    private void limpiar() {
        txtUsuario.setText("");
        txtContra.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        escritorio = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        panelLogin = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        btnSesion = new javax.swing.JButton();
        txtContra = new javax.swing.JPasswordField();
        lbAvisoLogin = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelLogin.setBackground(new java.awt.Color(153, 153, 255));
        panelLogin.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Franklin Gothic Book", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 0));
        jLabel1.setText("Iniciar Sesión");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Usuario:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Contraseña:");

        btnSesion.setBackground(new java.awt.Color(255, 153, 153));
        btnSesion.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 24)); // NOI18N
        btnSesion.setForeground(new java.awt.Color(51, 0, 0));
        btnSesion.setText("INICIAR SESIÓN");
        btnSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSesionMouseEntered(evt);
            }
        });
        btnSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSesionActionPerformed(evt);
            }
        });

        lbAvisoLogin.setForeground(new java.awt.Color(255, 0, 0));
        lbAvisoLogin.setText("Usuario o Contraseña Incorrectos*");

        javax.swing.GroupLayout panelLoginLayout = new javax.swing.GroupLayout(panelLogin);
        panelLogin.setLayout(panelLoginLayout);
        panelLoginLayout.setHorizontalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLoginLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(37, 37, 37)
                        .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelLoginLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtContra, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLoginLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbAvisoLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );
        panelLoginLayout.setVerticalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLoginLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel3))
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtContra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(lbAvisoLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        jPanel1.add(panelLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 260, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/BiosigmaLoginLogo.png"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 150, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/paisaje.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 160, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/ImagenFondo.jpg"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 740));

        escritorio.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 744, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(escritorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 750));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSesionActionPerformed
        InterfazInicioAdministrador interfaz = null;
        //Administrador
        if ((txtContra.getText().equals("0650160203")) && (txtUsuario.getText().equals("A10001")) && interfaz == null) {
            InterfazAdminJFrame modificar = new InterfazAdminJFrame();

            modificar.setVisible(true);
            setVisible(false);
            limpiar();
            //Cliente
        } else if ((txtContra.getText().equals("12345")) && (txtUsuario.getText().equals("T10001")) && interfaz == null) {
            InterfazCliente1JFrame modificar = new InterfazCliente1JFrame();

            modificar.setVisible(true);
            setVisible(false);
            limpiar();
          
        } else if ((txtContra.getText().equals("54321")) && (txtUsuario.getText().equals("C10001")) && interfaz == null) {
            InterfazTrabajadorJFrame modificar = new InterfazTrabajadorJFrame ();

            modificar.setVisible(true);
            setVisible(false); 
            limpiar();

        } else if ((txtContra.getText().equals("")) && (txtUsuario.getText().equals("")) && interfaz == null) {
            JOptionPane.showMessageDialog(null, "Escriba un usuario y contraseña");
            limpiar();

        } else {
            getToolkit().beep();
            lbAvisoLogin.setVisible(true);
        }

    }//GEN-LAST:event_btnSesionActionPerformed

    private void btnSesionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSesionMouseEntered

    }//GEN-LAST:event_btnSesionMouseEntered

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSesion;
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbAvisoLogin;
    private javax.swing.JPanel panelLogin;
    private javax.swing.JPasswordField txtContra;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
