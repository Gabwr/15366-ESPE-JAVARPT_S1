/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package repositorio.interfaz;

import java.awt.Color;

/**
 *
 * @author MATEO
 */
public class InterfazInicioPersonal extends javax.swing.JFrame {
    
    public InterfazInicioPersonal() {
        initComponents();
        PanelBiosigmaLogo.setBackground(new Color(0,0,0,160));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        PanelBiosigmaLogo = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        BotonProyectos = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        BotonAgregarMiembros = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        BotonAgregarClientes = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        BotonOpciones = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 204, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(101, 206, 97));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setBackground(new java.awt.Color(102, 255, 51));
        jLabel2.setFont(new java.awt.Font("Sitka Text", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("BIENVENIDO");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 190, 40));

        PanelBiosigmaLogo.setBackground(new java.awt.Color(0, 0, 0));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/LogoBiosigmaTransparente.png"))); // NOI18N

        javax.swing.GroupLayout PanelBiosigmaLogoLayout = new javax.swing.GroupLayout(PanelBiosigmaLogo);
        PanelBiosigmaLogo.setLayout(PanelBiosigmaLogoLayout);
        PanelBiosigmaLogoLayout.setHorizontalGroup(
            PanelBiosigmaLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelBiosigmaLogoLayout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(55, 55, 55))
        );
        PanelBiosigmaLogoLayout.setVerticalGroup(
            PanelBiosigmaLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBiosigmaLogoLayout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 54, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(PanelBiosigmaLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 230, 60));

        BotonProyectos.setBackground(new java.awt.Color(0, 204, 153));
        BotonProyectos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotonProyectosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotonProyectosMouseExited(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(51, 0, 51));
        jLabel5.setFont(new java.awt.Font("Segoe UI Light", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Proyectos");

        jLabel11.setBackground(new java.awt.Color(0, 0, 0));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/BotonProyectos.png"))); // NOI18N

        javax.swing.GroupLayout BotonProyectosLayout = new javax.swing.GroupLayout(BotonProyectos);
        BotonProyectos.setLayout(BotonProyectosLayout);
        BotonProyectosLayout.setHorizontalGroup(
            BotonProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BotonProyectosLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(15, 15, 15))
        );
        BotonProyectosLayout.setVerticalGroup(
            BotonProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BotonProyectosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BotonProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(BotonProyectos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 230, 60));

        BotonAgregarMiembros.setBackground(new java.awt.Color(0, 204, 153));
        BotonAgregarMiembros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotonAgregarMiembrosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotonAgregarMiembrosMouseExited(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(51, 0, 51));
        jLabel7.setFont(new java.awt.Font("Segoe UI Light", 1, 22)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Miembros");

        jLabel6.setBackground(new java.awt.Color(51, 0, 51));
        jLabel6.setFont(new java.awt.Font("Segoe UI Light", 1, 22)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Agregar");

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/BotonAgregarMiembro.png"))); // NOI18N

        javax.swing.GroupLayout BotonAgregarMiembrosLayout = new javax.swing.GroupLayout(BotonAgregarMiembros);
        BotonAgregarMiembros.setLayout(BotonAgregarMiembrosLayout);
        BotonAgregarMiembrosLayout.setHorizontalGroup(
            BotonAgregarMiembrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BotonAgregarMiembrosLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(BotonAgregarMiembrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6))
                .addGap(25, 25, 25))
        );
        BotonAgregarMiembrosLayout.setVerticalGroup(
            BotonAgregarMiembrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BotonAgregarMiembrosLayout.createSequentialGroup()
                .addGroup(BotonAgregarMiembrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BotonAgregarMiembrosLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(BotonAgregarMiembrosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel13)))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jPanel1.add(BotonAgregarMiembros, new org.netbeans.lib.awtextra.AbsoluteConstraints(-6, 290, 240, 70));

        BotonAgregarClientes.setBackground(new java.awt.Color(0, 204, 153));
        BotonAgregarClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotonAgregarClientesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotonAgregarClientesMouseExited(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(51, 0, 51));
        jLabel8.setFont(new java.awt.Font("Segoe UI Light", 1, 22)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Clientes");

        jLabel9.setBackground(new java.awt.Color(51, 0, 51));
        jLabel9.setFont(new java.awt.Font("Segoe UI Light", 1, 22)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Agregar");

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/BotonAgregarCliente.png"))); // NOI18N

        javax.swing.GroupLayout BotonAgregarClientesLayout = new javax.swing.GroupLayout(BotonAgregarClientes);
        BotonAgregarClientes.setLayout(BotonAgregarClientesLayout);
        BotonAgregarClientesLayout.setHorizontalGroup(
            BotonAgregarClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BotonAgregarClientesLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(BotonAgregarClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8))
                .addGap(39, 39, 39))
        );
        BotonAgregarClientesLayout.setVerticalGroup(
            BotonAgregarClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BotonAgregarClientesLayout.createSequentialGroup()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addContainerGap())
            .addGroup(BotonAgregarClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(BotonAgregarClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 230, 70));

        jLabel3.setBackground(new java.awt.Color(255, 51, 51));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/ImagenFondoBotonesPersonal.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 140));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 570));

        jPanel4.setBackground(new java.awt.Color(0, 153, 102));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setForeground(new java.awt.Color(0, 0, 0));
        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);

        jPanel5.setBackground(new java.awt.Color(153, 255, 204));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 734, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 457, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab2", jPanel5);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 734, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 457, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab4", jPanel7);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 734, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 457, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab3", jPanel6);

        jPanel3.setBackground(new java.awt.Color(0, 102, 51));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/ImagenHidroabanico.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(143, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(109, 109, 109))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(108, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(78, 78, 78))
        );

        jTabbedPane1.addTab("tab1", jPanel3);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("");

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 740, 460));

        jPanel8.setBackground(new java.awt.Color(0, 153, 102));

        BotonOpciones.setBackground(new java.awt.Color(0, 153, 102));
        BotonOpciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotonOpcionesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotonOpcionesMouseExited(evt);
            }
        });

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/BotonOpciones.png"))); // NOI18N

        javax.swing.GroupLayout BotonOpcionesLayout = new javax.swing.GroupLayout(BotonOpciones);
        BotonOpciones.setLayout(BotonOpcionesLayout);
        BotonOpcionesLayout.setHorizontalGroup(
            BotonOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BotonOpcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        BotonOpcionesLayout.setVerticalGroup(
            BotonOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BotonOpcionesLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(674, Short.MAX_VALUE)
                .addComponent(BotonOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(BotonOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, 740, 110));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonProyectosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonProyectosMouseEntered
        BotonProyectos.setBackground(new Color(204,255,204));
    }//GEN-LAST:event_BotonProyectosMouseEntered

    private void BotonProyectosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonProyectosMouseExited
        BotonProyectos.setBackground(new Color(0,204,153));
    }//GEN-LAST:event_BotonProyectosMouseExited

    private void BotonAgregarMiembrosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonAgregarMiembrosMouseEntered
        BotonAgregarMiembros.setBackground(new Color(204,255,204));
    }//GEN-LAST:event_BotonAgregarMiembrosMouseEntered

    private void BotonAgregarClientesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonAgregarClientesMouseEntered
        BotonAgregarClientes.setBackground(new Color(204,255,204));
    }//GEN-LAST:event_BotonAgregarClientesMouseEntered

    private void BotonAgregarMiembrosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonAgregarMiembrosMouseExited
        BotonAgregarMiembros.setBackground(new Color(0,204,153));
    }//GEN-LAST:event_BotonAgregarMiembrosMouseExited

    private void BotonAgregarClientesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonAgregarClientesMouseExited
        BotonAgregarClientes.setBackground(new Color(0,204,153));
    }//GEN-LAST:event_BotonAgregarClientesMouseExited

    private void BotonOpcionesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonOpcionesMouseExited
        BotonOpciones.setBackground(new Color(0,153,102));
    }//GEN-LAST:event_BotonOpcionesMouseExited

    private void BotonOpcionesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonOpcionesMouseEntered
        BotonOpciones.setBackground(new Color(204,255,204));
    }//GEN-LAST:event_BotonOpcionesMouseEntered

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfazInicioPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazInicioPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazInicioPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazInicioPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazInicioPersonal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BotonAgregarClientes;
    private javax.swing.JPanel BotonAgregarMiembros;
    private javax.swing.JPanel BotonOpciones;
    private javax.swing.JPanel BotonProyectos;
    private javax.swing.JPanel PanelBiosigmaLogo;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
