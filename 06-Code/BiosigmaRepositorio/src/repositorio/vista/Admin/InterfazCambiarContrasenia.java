/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package repositorio.vista.admin;

import javax.swing.JOptionPane;
import repositorio.controlador.ServicioPersonas;
import repositorio.modelo.Personas;
import repositorio.vista.admin.InterfazAdminActualizarUsuario;

/**
 *
 * @author Kathy
 */
public class InterfazCambiarContrasenia extends javax.swing.JInternalFrame {

    String cedulapersona = null;
    Personas persona = null;

    public InterfazCambiarContrasenia() {
        initComponents();
        InterfazAdminActualizarUsuario cedulaconseguir = new InterfazAdminActualizarUsuario();
        cedulapersona = cedulaconseguir.cedulaContrasenia;
        cargarPersona();
    }

    public void cargarPersona() {
        persona = ServicioPersonas.BuscarPorCodigoClienteyAdmin(cedulapersona);
        txtCedulA.setText(persona.getCedula());
        txtUsuario.setText(persona.getUsuario());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        txtCedulA = new javax.swing.JTextField();
        btnRegresarUsuarios = new javax.swing.JButton();
        txtUsuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        psfnuevoContra = new javax.swing.JPasswordField();
        psfcontraConfirmar = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("N° Cédula");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        txtCedulA.setEditable(false);
        txtCedulA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCedulAKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedulAKeyTyped(evt);
            }
        });
        jPanel1.add(txtCedulA, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 165, -1));

        btnRegresarUsuarios.setText("Regresar");
        btnRegresarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarUsuariosActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegresarUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 330, -1, -1));

        txtUsuario.setEditable(false);
        jPanel1.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 88, 165, -1));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Usuario");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 91, -1, -1));

        psfnuevoContra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                psfnuevoContraActionPerformed(evt);
            }
        });
        jPanel1.add(psfnuevoContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 149, -1));
        jPanel1.add(psfcontraConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 250, 149, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nueva Contrasenia");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, -1, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Confirmar Contraseña ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, -1, -1));

        jLabel21.setBackground(new java.awt.Color(51, 51, 0));
        jLabel21.setFont(new java.awt.Font("Sitka Banner", 1, 36)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 204, 204));
        jLabel21.setText("Cambiar Contrasenia");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 40));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/FondoProyectos.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 50));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/restablecer-la-contrasena.png"))); // NOI18N
        jButton1.setText("Actualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCedulAKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulAKeyReleased

    }//GEN-LAST:event_txtCedulAKeyReleased

    private void txtCedulAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulAKeyTyped

    }//GEN-LAST:event_txtCedulAKeyTyped

    private void btnRegresarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarUsuariosActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnRegresarUsuariosActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (!psfcontraConfirmar.getText().equals(psfnuevoContra.getText())&&!psfnuevoContra.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Las contraseñas no son iguales");
        } else {
            int resultado = JOptionPane.showConfirmDialog(null, "¿Esta segúro de actualizar la clave?", "Actualizar", JOptionPane.YES_NO_OPTION);
            if (resultado == JOptionPane.YES_OPTION) {
                String contraseniaEncritada = ServicioPersonas.encriptar(psfnuevoContra.getText());
                Personas nuevacontra = ServicioPersonas.BuscarPorCodigoClienteyAdmin(txtCedulA.getText());
                ServicioPersonas.ActualizarContrasenia(contraseniaEncritada, nuevacontra);
                JOptionPane.showMessageDialog(null, "Contrasena Actualizada");
            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void psfnuevoContraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_psfnuevoContraActionPerformed
        if (psfcontraConfirmar.getText().equals(psfnuevoContra.getText())) {

        }
    }//GEN-LAST:event_psfnuevoContraActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegresarUsuarios;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField psfcontraConfirmar;
    private javax.swing.JPasswordField psfnuevoContra;
    private javax.swing.JTextField txtCedulA;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
