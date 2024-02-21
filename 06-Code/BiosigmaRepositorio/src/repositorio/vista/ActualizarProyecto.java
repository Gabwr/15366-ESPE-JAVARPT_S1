package repositorio.vista;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import repositorio.modelo.Proyecto;
import java.util.logging.Level;
import java.util.logging.Logger;
import repositorio.controlador.ProyectoServicio;

public class ActualizarProyecto extends javax.swing.JInternalFrame {

    Proyecto proyecto;

    public ActualizarProyecto() {
        initComponents();
        consultarDatos();
    }

    private void consultarDatos() {
        String codigo = InterfazAdminJFrame.getCodigoProyecto();
        try {
            proyecto = ProyectoServicio.BuscarProyecto(codigo);
            txtCodigo.setText(proyecto.getIdProyecto());
            txtNombre.setText(proyecto.getNombreProyecto());
            dcFechaInicio.setDate(proyecto.getFechaInicio());
            
            if(proyecto.getFechaFinal() != null){
            dcFechaFinal.setDate(proyecto.getFechaFinal());
            rdEnProgreso.setSelected(false);
            }
            else{
                rdEnProgreso.setSelected(true);
                dcFechaFinal.setEnabled(false);
            }
            txtDescripcion.setText(proyecto.getDescripcionProyecto());
            String recordatorio;
            if (proyecto.getRecordatorioProyecto() != null) {
                recordatorio = proyecto.getRecordatorioProyecto();
            } else {
                recordatorio = "No existen recordatorios";
            }
            txtRecordatorio.setText(recordatorio);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No se ha podido cargar la información del proyecto");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelActualizarProyecto = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        btnRegresarPanelTabla = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jLabel35 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        txtRecordatorio = new javax.swing.JTextArea();
        dcFechaInicio = new com.toedter.calendar.JDateChooser();
        dcFechaFinal = new com.toedter.calendar.JDateChooser();
        rdEnProgreso = new javax.swing.JRadioButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jButton11 = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jScrollPane14 = new javax.swing.JScrollPane();
        tbActividades = new javax.swing.JTable();
        btPermisoAmbiental = new javax.swing.JButton();
        btPermisoAgua = new javax.swing.JButton();
        btAuditorias = new javax.swing.JButton();
        btMonitoreo = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        PanelActualizarProyecto.setBackground(new java.awt.Color(255, 255, 204));
        PanelActualizarProyecto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Sitka Banner", 1, 30)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 51, 51));
        jLabel8.setText("Actualizar Proyecto");
        PanelActualizarProyecto.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, -1, 37));

        btnRegresarPanelTabla.setText("Regresar");
        btnRegresarPanelTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarPanelTablaActionPerformed(evt);
            }
        });
        PanelActualizarProyecto.add(btnRegresarPanelTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 20, -1, -1));

        jLabel31.setFont(new java.awt.Font("Sitka Banner", 1, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(51, 0, 51));
        jLabel31.setText("Fecha de Finalización:");
        PanelActualizarProyecto.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(703, 54, 136, -1));

        jLabel23.setFont(new java.awt.Font("Sitka Banner", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(51, 0, 51));
        jLabel23.setText("Nombre Del Proyecto:");
        PanelActualizarProyecto.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(243, 54, 136, -1));
        PanelActualizarProyecto.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(243, 78, 136, -1));

        jLabel32.setFont(new java.awt.Font("Sitka Banner", 1, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(51, 0, 51));
        jLabel32.setText("Fecha de Inicio:");
        PanelActualizarProyecto.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 54, 136, -1));

        txtCodigo.setEditable(false);
        txtCodigo.setBackground(new java.awt.Color(153, 153, 153));
        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });
        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoKeyTyped(evt);
            }
        });
        PanelActualizarProyecto.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 78, 136, -1));

        jLabel33.setFont(new java.awt.Font("Sitka Banner", 1, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(51, 0, 51));
        jLabel33.setText("Código de Proyecto:");
        PanelActualizarProyecto.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 54, -1, -1));

        jLabel34.setFont(new java.awt.Font("Sitka Banner", 1, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(51, 0, 51));
        jLabel34.setText("Descripción del proyecto:");
        PanelActualizarProyecto.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 121, 156, -1));

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane8.setViewportView(txtDescripcion);

        PanelActualizarProyecto.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 145, 277, 133));

        jLabel35.setFont(new java.awt.Font("Sitka Banner", 1, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(51, 0, 51));
        jLabel35.setText("Recordatorios:");
        PanelActualizarProyecto.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, 156, -1));

        txtRecordatorio.setColumns(20);
        txtRecordatorio.setRows(5);
        jScrollPane9.setViewportView(txtRecordatorio);

        PanelActualizarProyecto.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(372, 145, 270, 130));
        PanelActualizarProyecto.add(dcFechaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 78, 136, -1));
        PanelActualizarProyecto.add(dcFechaFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(703, 78, 136, -1));

        rdEnProgreso.setForeground(new java.awt.Color(51, 0, 51));
        rdEnProgreso.setText("En progreso");
        rdEnProgreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdEnProgresoActionPerformed(evt);
            }
        });
        PanelActualizarProyecto.add(rdEnProgreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(868, 78, -1, -1));

        jPanel3.setBackground(new java.awt.Color(204, 255, 255));

        jLabel40.setFont(new java.awt.Font("Sitka Banner", 1, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(51, 0, 51));
        jLabel40.setText("Actividad");

        jButton9.setText("Agregar");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jButton9)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel40)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jButton9)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Agregar actividad", jPanel3);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jLabel38.setFont(new java.awt.Font("Sitka Banner", 1, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(51, 0, 51));
        jLabel38.setText("Actividad");

        jButton11.setText("Actualizar");

        jRadioButton1.setForeground(new java.awt.Color(0, 0, 0));
        jRadioButton1.setText("Completada");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.setForeground(new java.awt.Color(0, 0, 0));
        jRadioButton2.setText("En progreso");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Evidencia");

        jButton3.setBackground(new java.awt.Color(204, 204, 255));
        jButton3.setForeground(new java.awt.Color(0, 0, 0));
        jButton3.setText("Cambiar archivo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jButton11)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton2)
                            .addComponent(jRadioButton1)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)))
                .addGap(0, 16, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel38)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton11)
                .addGap(17, 17, 17))
        );

        jTabbedPane1.addTab("Actualizar actividad", jPanel1);

        PanelActualizarProyecto.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 330, 280, 230));

        jButton10.setFont(new java.awt.Font("Sitka Banner", 1, 14)); // NOI18N
        jButton10.setText("Actualizar");
        PanelActualizarProyecto.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 550, -1, 45));

        tbActividades.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane14.setViewportView(tbActividades);

        PanelActualizarProyecto.add(jScrollPane14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 480, 241));

        btPermisoAmbiental.setText("Permiso Ambiental");
        btPermisoAmbiental.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPermisoAmbientalActionPerformed(evt);
            }
        });
        PanelActualizarProyecto.add(btPermisoAmbiental, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 140, -1, -1));

        btPermisoAgua.setText("Permiso de Agua");
        btPermisoAgua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPermisoAguaActionPerformed(evt);
            }
        });
        PanelActualizarProyecto.add(btPermisoAgua, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 180, 130, -1));

        btAuditorias.setText("Auditoria");
        btAuditorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAuditoriasActionPerformed(evt);
            }
        });
        PanelActualizarProyecto.add(btAuditorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 220, 130, -1));

        btMonitoreo.setText("Monitoreo");
        btMonitoreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMonitoreoActionPerformed(evt);
            }
        });
        PanelActualizarProyecto.add(btMonitoreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 260, 130, -1));

        jButton2.setBackground(new java.awt.Color(204, 204, 255));
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("Cambiar archivo");
        PanelActualizarProyecto.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 260, -1, -1));

        jButton5.setBackground(new java.awt.Color(204, 204, 255));
        jButton5.setForeground(new java.awt.Color(0, 0, 0));
        jButton5.setText("Cambiar archivo");
        PanelActualizarProyecto.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 140, -1, -1));

        jButton6.setBackground(new java.awt.Color(204, 204, 255));
        jButton6.setForeground(new java.awt.Color(0, 0, 0));
        jButton6.setText("Cambiar archivo");
        PanelActualizarProyecto.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 180, -1, -1));

        jButton7.setBackground(new java.awt.Color(204, 204, 255));
        jButton7.setForeground(new java.awt.Color(0, 0, 0));
        jButton7.setText("Cambiar archivo");
        PanelActualizarProyecto.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 220, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 234, 204));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/jaguar_prueba_3_742563 (1).png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(764, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        PanelActualizarProyecto.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 1070, 320));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelActualizarProyecto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1072, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelActualizarProyecto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarPanelTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarPanelTablaActionPerformed

    }//GEN-LAST:event_btnRegresarPanelTablaActionPerformed

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void txtCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyTyped
        char validacionnombre = evt.getKeyChar();
        if (Character.isLetter(validacionnombre)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingresar solamente numeros");

        }
    }//GEN-LAST:event_txtCodigoKeyTyped

    private void rdEnProgresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdEnProgresoActionPerformed
        if (rdEnProgreso.isSelected()) {
            dcFechaFinal.setEnabled(false);
            dcFechaFinal.setDate(null);
        } else {
            dcFechaFinal.setEnabled(true);
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

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelActualizarProyecto;
    private javax.swing.JButton btAuditorias;
    private javax.swing.JButton btMonitoreo;
    private javax.swing.JButton btPermisoAgua;
    private javax.swing.JButton btPermisoAmbiental;
    private javax.swing.JButton btnRegresarPanelTabla;
    private com.toedter.calendar.JDateChooser dcFechaFinal;
    private com.toedter.calendar.JDateChooser dcFechaInicio;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JRadioButton rdEnProgreso;
    private javax.swing.JTable tbActividades;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextArea txtRecordatorio;
    // End of variables declaration//GEN-END:variables
}
