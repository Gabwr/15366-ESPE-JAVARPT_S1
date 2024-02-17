package repositorio.vista;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import repositorio.controlador.ProyectoServicio;
import repositorio.modelo.Proyecto;

public class AgregarProyecto extends javax.swing.JInternalFrame {

    private Proyecto proyecto = new Proyecto();

    public AgregarProyecto() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelAgregarProyecto = new javax.swing.JPanel();
        btAuditorias = new javax.swing.JButton();
        btPermisoAmbiental = new javax.swing.JButton();
        rdEnProgreso = new javax.swing.JRadioButton();
        dcFechaFinalProyecto = new com.toedter.calendar.JDateChooser();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        dcFechaInicioProyecto = new com.toedter.calendar.JDateChooser();
        txtNombreProyecto = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        txtDescripcionProyecto = new javax.swing.JTextArea();
        jLabel46 = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        txtActividad = new javax.swing.JTextField();
        btActividad = new javax.swing.JButton();
        btAgregarProyecto = new javax.swing.JButton();
        btnRegresarPanelTabla1 = new javax.swing.JButton();
        jLabel45 = new javax.swing.JLabel();
        txtCodigoProyecto = new javax.swing.JTextField();
        lbAvisoAuditoria = new javax.swing.JLabel();
        lbAvisoCodigo = new javax.swing.JLabel();
        lbAvisoNombre = new javax.swing.JLabel();
        lbAvisoFechaInicio = new javax.swing.JLabel();
        lbAvisoFechaFinal = new javax.swing.JLabel();
        lbAvisoDescripcion = new javax.swing.JLabel();
        lbAvisoPermisoAmbiental = new javax.swing.JLabel();
        btPermisoAgua = new javax.swing.JButton();
        lbAvisoPermisoAgua = new javax.swing.JLabel();
        btMonitoreo = new javax.swing.JButton();
        lbAvisoMonitoreo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jRadioButton1 = new javax.swing.JRadioButton();
        lbAvisoMonitoreo1 = new javax.swing.JLabel();

        panelAgregarProyecto.setBackground(new java.awt.Color(204, 204, 255));
        panelAgregarProyecto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btAuditorias.setText("Agregar Auditoria");
        btAuditorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAuditoriasActionPerformed(evt);
            }
        });
        panelAgregarProyecto.add(btAuditorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 230, 176, -1));

        btPermisoAmbiental.setText("Agregar Permiso Ambiental");
        btPermisoAmbiental.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPermisoAmbientalActionPerformed(evt);
            }
        });
        panelAgregarProyecto.add(btPermisoAmbiental, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 150, -1, -1));

        rdEnProgreso.setForeground(new java.awt.Color(51, 0, 51));
        rdEnProgreso.setText("En progreso");
        rdEnProgreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdEnProgresoActionPerformed(evt);
            }
        });
        panelAgregarProyecto.add(rdEnProgreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 80, -1, -1));
        panelAgregarProyecto.add(dcFechaFinalProyecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(695, 49, 136, -1));

        jLabel41.setFont(new java.awt.Font("Sitka Banner", 1, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(51, 0, 51));
        jLabel41.setText("Fecha de Finalización:");
        panelAgregarProyecto.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(695, 23, 136, -1));

        jLabel42.setFont(new java.awt.Font("Sitka Banner", 1, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(51, 0, 51));
        jLabel42.setText("Fecha de Inicio:");
        panelAgregarProyecto.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(467, 23, 136, -1));
        panelAgregarProyecto.add(dcFechaInicioProyecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(467, 49, 136, -1));

        txtNombreProyecto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreProyectoKeyTyped(evt);
            }
        });
        panelAgregarProyecto.add(txtNombreProyecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(248, 53, 136, -1));

        jLabel43.setFont(new java.awt.Font("Sitka Banner", 1, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(51, 0, 51));
        jLabel43.setText("Nombre Del Proyecto:");
        panelAgregarProyecto.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(248, 23, 136, -1));

        jLabel44.setFont(new java.awt.Font("Sitka Banner", 1, 14)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(51, 0, 51));
        jLabel44.setText("Descripción del proyecto:");
        panelAgregarProyecto.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 156, -1));

        txtDescripcionProyecto.setColumns(20);
        txtDescripcionProyecto.setRows(5);
        jScrollPane12.setViewportView(txtDescripcionProyecto);

        panelAgregarProyecto.add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 310, -1));

        jLabel46.setFont(new java.awt.Font("Sitka Banner", 1, 18)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(51, 0, 51));
        jLabel46.setText("Plan de Manejo Ambiental");
        panelAgregarProyecto.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, -1, -1));

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Actividades", "Completado", "Fecha realizada", "Evidencia"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane14.setViewportView(jTable4);

        panelAgregarProyecto.add(jScrollPane14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 480, 241));

        jPanel4.setBackground(new java.awt.Color(204, 255, 204));

        jLabel47.setFont(new java.awt.Font("Sitka Banner", 1, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(51, 0, 51));
        jLabel47.setText("Actividad");

        txtActividad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtActividadKeyTyped(evt);
            }
        });

        btActividad.setText("Agregar Actividad");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txtActividad, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(btActividad)
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel47)
                .addGap(18, 18, 18)
                .addComponent(txtActividad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btActividad)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        panelAgregarProyecto.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 360, 210, 160));

        btAgregarProyecto.setText("Agregar Proyecto");
        btAgregarProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgregarProyectoActionPerformed(evt);
            }
        });
        panelAgregarProyecto.add(btAgregarProyecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 510, -1, 49));

        btnRegresarPanelTabla1.setText("Regresar");
        btnRegresarPanelTabla1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarPanelTabla1ActionPerformed(evt);
            }
        });
        panelAgregarProyecto.add(btnRegresarPanelTabla1, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 20, -1, -1));

        jLabel45.setFont(new java.awt.Font("Sitka Banner", 1, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(51, 0, 51));
        jLabel45.setText("Código de Proyecto:");
        panelAgregarProyecto.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 23, -1, -1));

        txtCodigoProyecto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoProyectoKeyTyped(evt);
            }
        });
        panelAgregarProyecto.add(txtCodigoProyecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 53, 136, -1));

        lbAvisoAuditoria.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbAvisoAuditoria.setForeground(new java.awt.Color(255, 0, 0));
        lbAvisoAuditoria.setText("*");
        panelAgregarProyecto.add(lbAvisoAuditoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 230, -1, 20));

        lbAvisoCodigo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbAvisoCodigo.setForeground(new java.awt.Color(255, 0, 0));
        lbAvisoCodigo.setText("*");
        panelAgregarProyecto.add(lbAvisoCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, -1, 20));

        lbAvisoNombre.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbAvisoNombre.setForeground(new java.awt.Color(255, 0, 0));
        lbAvisoNombre.setText("*");
        panelAgregarProyecto.add(lbAvisoNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, -1, 20));

        lbAvisoFechaInicio.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbAvisoFechaInicio.setForeground(new java.awt.Color(255, 0, 0));
        lbAvisoFechaInicio.setText("*");
        panelAgregarProyecto.add(lbAvisoFechaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 50, -1, 20));

        lbAvisoFechaFinal.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbAvisoFechaFinal.setForeground(new java.awt.Color(255, 0, 0));
        lbAvisoFechaFinal.setText("*");
        panelAgregarProyecto.add(lbAvisoFechaFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 50, -1, 20));

        lbAvisoDescripcion.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbAvisoDescripcion.setForeground(new java.awt.Color(255, 0, 0));
        lbAvisoDescripcion.setText("*");
        panelAgregarProyecto.add(lbAvisoDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 170, -1, 20));

        lbAvisoPermisoAmbiental.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbAvisoPermisoAmbiental.setForeground(new java.awt.Color(255, 0, 0));
        lbAvisoPermisoAmbiental.setText("*");
        panelAgregarProyecto.add(lbAvisoPermisoAmbiental, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 150, -1, 20));

        btPermisoAgua.setText("Agregar Permiso de Agua");
        btPermisoAgua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPermisoAguaActionPerformed(evt);
            }
        });
        panelAgregarProyecto.add(btPermisoAgua, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 190, 176, -1));

        lbAvisoPermisoAgua.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbAvisoPermisoAgua.setForeground(new java.awt.Color(255, 0, 0));
        lbAvisoPermisoAgua.setText("*");
        panelAgregarProyecto.add(lbAvisoPermisoAgua, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 190, -1, 20));

        btMonitoreo.setText("Agregar Monitoreo");
        btMonitoreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMonitoreoActionPerformed(evt);
            }
        });
        panelAgregarProyecto.add(btMonitoreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 270, 176, -1));

        lbAvisoMonitoreo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbAvisoMonitoreo.setForeground(new java.awt.Color(255, 0, 0));
        lbAvisoMonitoreo.setText("*");
        panelAgregarProyecto.add(lbAvisoMonitoreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 340, -1, 20));

        jLabel2.setBackground(new java.awt.Color(102, 102, 102));
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("(Si aun no finaliza el proyecto seleccione en progreso)");
        panelAgregarProyecto.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 120, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/cloudup_icon-icons.com_54402.png"))); // NOI18N
        panelAgregarProyecto.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 200, -1, -1));

        jScrollPane1.setWheelScrollingEnabled(false);

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(204, 204, 255));
        jTextArea1.setColumns(20);
        jTextArea1.setForeground(new java.awt.Color(102, 102, 102));
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(2);
        jTextArea1.setText("Si aun no posee los siguientes archivos,\nsuba un pdf en Blanco.");
        jScrollPane1.setViewportView(jTextArea1);

        panelAgregarProyecto.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 190, 250, 50));

        jTextArea2.setEditable(false);
        jTextArea2.setBackground(new java.awt.Color(204, 204, 255));
        jTextArea2.setColumns(20);
        jTextArea2.setForeground(new java.awt.Color(102, 102, 102));
        jTextArea2.setLineWrap(true);
        jTextArea2.setRows(3);
        jTextArea2.setText("Puede agregar más\nactividades desde \nActualizar Proyecto");
        jScrollPane2.setViewportView(jTextArea2);

        panelAgregarProyecto.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 360, 140, 70));

        jRadioButton1.setForeground(new java.awt.Color(0, 0, 0));
        jRadioButton1.setText("No agregar actividades por ahora");
        panelAgregarProyecto.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 330, -1, -1));

        lbAvisoMonitoreo1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbAvisoMonitoreo1.setForeground(new java.awt.Color(255, 0, 0));
        lbAvisoMonitoreo1.setText("*");
        panelAgregarProyecto.add(lbAvisoMonitoreo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 270, -1, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelAgregarProyecto, javax.swing.GroupLayout.DEFAULT_SIZE, 998, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelAgregarProyecto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigoProyectoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoProyectoKeyTyped
        char validacionnombre = evt.getKeyChar();
        if (Character.isLetter(validacionnombre)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingresar solamente numeros");

        }
    }//GEN-LAST:event_txtCodigoProyectoKeyTyped

    private void btnRegresarPanelTabla1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarPanelTabla1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnRegresarPanelTabla1ActionPerformed

    private void txtNombreProyectoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreProyectoKeyTyped
        char validacionnombre = evt.getKeyChar();
        if (Character.isDigit(validacionnombre)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingresar solamente letras");

        }
    }//GEN-LAST:event_txtNombreProyectoKeyTyped

    private void rdEnProgresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdEnProgresoActionPerformed
        if (rdEnProgreso.isSelected()) {
            dcFechaFinalProyecto.setEnabled(false);
            lbAvisoFechaFinal.setVisible(false);
        }
    }//GEN-LAST:event_rdEnProgresoActionPerformed

    private void btPermisoAmbientalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPermisoAmbientalActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            JOptionPane.showMessageDialog(null, "Archivo seleccionado: " + selectedFile.getAbsolutePath());

            try {
                byte[] pdfBytes;
                pdfBytes = Files.readAllBytes(Paths.get(selectedFile.getAbsolutePath()));
                proyecto.setPermisoAmbiental(pdfBytes);
            } catch (IOException ex) {
                Logger.getLogger(AgregarProyecto.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_btPermisoAmbientalActionPerformed

    private void btPermisoAguaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPermisoAguaActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            JOptionPane.showMessageDialog(null, "Archivo seleccionado: " + selectedFile.getAbsolutePath());

            try {
                byte[] pdfBytes;
                pdfBytes = Files.readAllBytes(Paths.get(selectedFile.getAbsolutePath()));
                proyecto.setPermisoAgua(pdfBytes);
            } catch (IOException ex) {
                Logger.getLogger(AgregarProyecto.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_btPermisoAguaActionPerformed

    private void btAuditoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAuditoriasActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            JOptionPane.showMessageDialog(null, "Archivo seleccionado: " + selectedFile.getAbsolutePath());

            try {
                byte[] pdfBytes;
                pdfBytes = Files.readAllBytes(Paths.get(selectedFile.getAbsolutePath()));
                proyecto.setAuditoria(pdfBytes);
            } catch (IOException ex) {
                Logger.getLogger(AgregarProyecto.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_btAuditoriasActionPerformed

    private void btMonitoreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMonitoreoActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            JOptionPane.showMessageDialog(null, "Archivo seleccionado: " + selectedFile.getAbsolutePath());

            try {
                byte[] pdfBytes;
                pdfBytes = Files.readAllBytes(Paths.get(selectedFile.getAbsolutePath()));
                proyecto.setMonitoreo(pdfBytes);
            } catch (IOException ex) {
                Logger.getLogger(AgregarProyecto.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_btMonitoreoActionPerformed

    private void btAgregarProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregarProyectoActionPerformed
        ProyectoServicio.InsertarProyecto(proyecto);
    }//GEN-LAST:event_btAgregarProyectoActionPerformed

    private void txtActividadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtActividadKeyTyped
        char validacion = evt.getKeyChar();
        if (Character.isDigit(validacion)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingresar solamente Letras");

        }
    }//GEN-LAST:event_txtActividadKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btActividad;
    private javax.swing.JButton btAgregarProyecto;
    private javax.swing.JButton btAuditorias;
    private javax.swing.JButton btMonitoreo;
    private javax.swing.JButton btPermisoAgua;
    private javax.swing.JButton btPermisoAmbiental;
    private javax.swing.JButton btnRegresarPanelTabla1;
    private com.toedter.calendar.JDateChooser dcFechaFinalProyecto;
    private com.toedter.calendar.JDateChooser dcFechaInicioProyecto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JLabel lbAvisoAuditoria;
    private javax.swing.JLabel lbAvisoCodigo;
    private javax.swing.JLabel lbAvisoDescripcion;
    private javax.swing.JLabel lbAvisoFechaFinal;
    private javax.swing.JLabel lbAvisoFechaInicio;
    private javax.swing.JLabel lbAvisoMonitoreo;
    private javax.swing.JLabel lbAvisoMonitoreo1;
    private javax.swing.JLabel lbAvisoNombre;
    private javax.swing.JLabel lbAvisoPermisoAgua;
    private javax.swing.JLabel lbAvisoPermisoAmbiental;
    private javax.swing.JPanel panelAgregarProyecto;
    private javax.swing.JRadioButton rdEnProgreso;
    private javax.swing.JTextField txtActividad;
    private javax.swing.JTextField txtCodigoProyecto;
    private javax.swing.JTextArea txtDescripcionProyecto;
    private javax.swing.JTextField txtNombreProyecto;
    // End of variables declaration//GEN-END:variables
}
