package repositorio.vista;

import java.awt.Desktop;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.System.Logger.Level;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import org.bson.diagnostics.Logger;
import repositorio.controlador.ProyectoServicio;
import repositorio.modelo.Proyecto;

public class AbrirProyecto extends javax.swing.JInternalFrame {

    Proyecto proyecto;

    public AbrirProyecto() {
        initComponents();
        consultarDatos();
    }
    private String obtenercodigointerfacez() {
        String codigo="";
        if (InterfazAdminJFrame.getCodigoProyecto() != "") {
            codigo = InterfazAdminJFrame.getCodigoProyecto();
            

        } else if (InterfazTrabajadorJFrame.getCodigoProyecto() != "") {
            codigo = InterfazTrabajadorJFrame.getCodigoProyecto();
            

        }
        return codigo;
    }
    private void consultarDatos() {
        
        try {
            proyecto = ProyectoServicio.BuscarProyecto(obtenercodigointerfacez());
            txtCodigo.setText(proyecto.getIdProyecto());
            txtNombre.setText(proyecto.getNombreProyecto());
            String fechaInicio = new SimpleDateFormat("dd/MM/yyyy").format(proyecto.getFechaInicio());
            String fechaFinal;
            if (proyecto.getFechaFinal() != null) {
                fechaFinal = new SimpleDateFormat("dd/MM/yyyy").format(proyecto.getFechaFinal());
            } else {
                fechaFinal = "En progreso";
            }
            txtFechaInicio.setText(fechaInicio);
            txtFechaFinal.setText(fechaFinal);
            txtDescripcion.setText(proyecto.getDescripcionProyecto());
            String recordatorio;
            if (proyecto.getRecordatorioProyecto() != null) {
                recordatorio = proyecto.getRecordatorioProyecto();
            } else {
                recordatorio = "No existen recordatorios";
            }
            txtRecordatorio.setText(recordatorio);

            if (proyecto.getPermisoAmbiental() != null) {
                lbPermisoAmbiental.setVisible(true);
            } else {
                lbPermisoAmbiental.setVisible(false);
            }
            if (proyecto.getPermisoAgua() != null) {
                lbPermisoAgua.setVisible(true);
            } else {
                lbPermisoAgua.setVisible(false);
            }
            if (proyecto.getAuditoria() != null) {
                lbAuditoria.setVisible(true);
            } else {
                lbAuditoria.setVisible(false);
            }
            if (proyecto.getMonitoreo() != null) {
                lbMonitoreo.setVisible(true);
            } else {
                lbMonitoreo.setVisible(false);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No se ha podido cargar la información del proyecto");
        }
    }

    private void abrirArchivoProyecto(byte[] archivo) {
        if (archivo != null) {
            try{
                Path tempPdf = Files.createTempFile("Archivo Guardado",".pdf");
                Files.copy(new ByteArrayInputStream(archivo),tempPdf, StandardCopyOption.REPLACE_EXISTING);
                
                Desktop.getDesktop().open(tempPdf.toFile());
            }catch(IOException ex){
                
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se ha cargado el documento aún");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelAbrirProyecto = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtFechaInicio = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtRecordatorio = new javax.swing.JTextArea();
        jLabel22 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        txtFechaFinal = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnRegresarPanelTabla1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        tbActividades = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        btPermisoAmbiental = new javax.swing.JButton();
        btPermisoAgua = new javax.swing.JButton();
        btAuditorias = new javax.swing.JButton();
        btMonitoreo = new javax.swing.JButton();
        lbPermisoAmbiental = new javax.swing.JLabel();
        lbPermisoAgua = new javax.swing.JLabel();
        lbAuditoria = new javax.swing.JLabel();
        lbMonitoreo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());

        panelAbrirProyecto.setBackground(new java.awt.Color(204, 204, 255));
        panelAbrirProyecto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/1486486303-alert-bell-notification-education-christmas-bell-church-bell-ring_81235.png"))); // NOI18N
        panelAbrirProyecto.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 250, -1, -1));

        jLabel13.setFont(new java.awt.Font("Sitka Banner", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 51));
        jLabel13.setText("Nombre Del Proyecto:");
        panelAbrirProyecto.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 136, -1));

        jLabel14.setFont(new java.awt.Font("Sitka Banner", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 51));
        jLabel14.setText("Código de Proyecto:");
        panelAbrirProyecto.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 136, -1));

        jLabel17.setFont(new java.awt.Font("Sitka Banner", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 51));
        jLabel17.setText("Descripción del proyecto:");
        panelAbrirProyecto.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 100, 156, -1));

        txtCodigo.setEditable(false);
        txtCodigo.setBackground(new java.awt.Color(204, 204, 204));
        txtCodigo.setForeground(new java.awt.Color(0, 0, 51));
        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoKeyTyped(evt);
            }
        });
        panelAbrirProyecto.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 136, -1));

        txtFechaInicio.setEditable(false);
        txtFechaInicio.setBackground(new java.awt.Color(204, 204, 204));
        txtFechaInicio.setForeground(new java.awt.Color(0, 0, 51));
        txtFechaInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaInicioActionPerformed(evt);
            }
        });
        panelAbrirProyecto.add(txtFechaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 136, -1));

        txtNombre.setEditable(false);
        txtNombre.setBackground(new java.awt.Color(204, 204, 204));
        txtNombre.setForeground(new java.awt.Color(0, 0, 51));
        panelAbrirProyecto.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 136, -1));

        jLabel18.setFont(new java.awt.Font("Sitka Banner", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 51));
        jLabel18.setText("Fecha de Inicio:");
        panelAbrirProyecto.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 136, -1));

        txtDescripcion.setEditable(false);
        txtDescripcion.setBackground(new java.awt.Color(204, 204, 204));
        txtDescripcion.setColumns(20);
        txtDescripcion.setForeground(new java.awt.Color(0, 0, 51));
        txtDescripcion.setRows(5);
        jScrollPane3.setViewportView(txtDescripcion);

        panelAbrirProyecto.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, 254, -1));

        jLabel20.setFont(new java.awt.Font("Sitka Banner", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 51));
        jLabel20.setText("Recordatorios:");
        panelAbrirProyecto.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 240, 156, -1));

        txtRecordatorio.setEditable(false);
        txtRecordatorio.setBackground(new java.awt.Color(204, 204, 204));
        txtRecordatorio.setColumns(20);
        txtRecordatorio.setForeground(new java.awt.Color(0, 0, 51));
        txtRecordatorio.setRows(5);
        jScrollPane6.setViewportView(txtRecordatorio);

        panelAbrirProyecto.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 260, 254, -1));

        jLabel22.setFont(new java.awt.Font("Sitka Banner", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 0, 51));
        jLabel22.setText("Plan de Manejo Ambiental");
        panelAbrirProyecto.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 390, -1, -1));

        jLabel30.setFont(new java.awt.Font("Sitka Banner", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(0, 0, 51));
        jLabel30.setText("Fecha de Finalización:");
        panelAbrirProyecto.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 136, -1));

        txtFechaFinal.setEditable(false);
        txtFechaFinal.setBackground(new java.awt.Color(204, 204, 204));
        txtFechaFinal.setForeground(new java.awt.Color(0, 0, 51));
        panelAbrirProyecto.add(txtFechaFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 136, -1));

        jLabel8.setBackground(new java.awt.Color(204, 255, 204));
        jLabel8.setFont(new java.awt.Font("Sitka Banner", 1, 40)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 204, 204));
        jLabel8.setText("Proyecto Abierto");
        panelAbrirProyecto.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/LogoBiosigmaTransparente.png"))); // NOI18N
        panelAbrirProyecto.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        btnRegresarPanelTabla1.setText("Regresar");
        btnRegresarPanelTabla1.setToolTipText("volver al menú");
        btnRegresarPanelTabla1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarPanelTabla1ActionPerformed(evt);
            }
        });
        panelAbrirProyecto.add(btnRegresarPanelTabla1, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 20, -1, 20));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/FondoProyectos.png"))); // NOI18N
        panelAbrirProyecto.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 0, 260, 60));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/FondoProyectos.png"))); // NOI18N
        panelAbrirProyecto.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 60));

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

        panelAbrirProyecto.add(jScrollPane14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 550, 150));
        panelAbrirProyecto.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1060, -1));

        btPermisoAmbiental.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/ecoicon01_122073.png"))); // NOI18N
        btPermisoAmbiental.setText("Abrir Permiso Ambiental");
        btPermisoAmbiental.setToolTipText("abrir archivo pdf");
        btPermisoAmbiental.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btPermisoAmbiental.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPermisoAmbientalActionPerformed(evt);
            }
        });
        panelAbrirProyecto.add(btPermisoAmbiental, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 130, 200, -1));

        btPermisoAgua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/water_23838.png"))); // NOI18N
        btPermisoAgua.setText("Abrir Permiso de Agua");
        btPermisoAgua.setToolTipText("abrir archivo pdf");
        btPermisoAgua.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btPermisoAgua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPermisoAguaActionPerformed(evt);
            }
        });
        panelAbrirProyecto.add(btPermisoAgua, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 190, 200, -1));

        btAuditorias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/audit_icon_155782.png"))); // NOI18N
        btAuditorias.setText("Abrir Auditoria");
        btAuditorias.setToolTipText("abrir archivo pdf");
        btAuditorias.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btAuditorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAuditoriasActionPerformed(evt);
            }
        });
        panelAbrirProyecto.add(btAuditorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 250, 200, -1));

        btMonitoreo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/monitoring-icon_icon-icons.com_55736.png"))); // NOI18N
        btMonitoreo.setText("Abrir Monitoreo");
        btMonitoreo.setToolTipText("abrir archivo pdf");
        btMonitoreo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btMonitoreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMonitoreoActionPerformed(evt);
            }
        });
        panelAbrirProyecto.add(btMonitoreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 310, 200, -1));

        lbPermisoAmbiental.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/accept_icon-icons.com_74428 (1).png"))); // NOI18N
        panelAbrirProyecto.add(lbPermisoAmbiental, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 130, -1, -1));

        lbPermisoAgua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/accept_icon-icons.com_74428 (1).png"))); // NOI18N
        panelAbrirProyecto.add(lbPermisoAgua, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 190, -1, -1));

        lbAuditoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/accept_icon-icons.com_74428 (1).png"))); // NOI18N
        panelAbrirProyecto.add(lbAuditoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 250, -1, -1));

        lbMonitoreo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/accept_icon-icons.com_74428 (1).png"))); // NOI18N
        panelAbrirProyecto.add(lbMonitoreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 310, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/bubo-bubo-buho-real.png"))); // NOI18N
        panelAbrirProyecto.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 100, -1, -1));

        jLabel23.setFont(new java.awt.Font("Sitka Banner", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 0, 51));
        jLabel23.setText("Plan de Manejo Ambiental");
        panelAbrirProyecto.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 390, -1, -1));

        jLabel24.setFont(new java.awt.Font("Sitka Banner", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 0, 51));
        jLabel24.setText("Actividad");
        panelAbrirProyecto.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 460, 100, -1));
        panelAbrirProyecto.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 490, 140, -1));

        jButton1.setText("Abrir Evidencia");
        jButton1.setToolTipText("abrir pdf");
        panelAbrirProyecto.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 530, 140, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/ImagenFondoAbrirProyecto.png"))); // NOI18N
        panelAbrirProyecto.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelAbrirProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 1051, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelAbrirProyecto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyTyped

    }//GEN-LAST:event_txtCodigoKeyTyped

    private void btnRegresarPanelTabla1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarPanelTabla1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnRegresarPanelTabla1ActionPerformed

    private void txtFechaInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaInicioActionPerformed

    }//GEN-LAST:event_txtFechaInicioActionPerformed

    private void btPermisoAmbientalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPermisoAmbientalActionPerformed
        abrirArchivoProyecto(proyecto.getPermisoAmbiental());
    }//GEN-LAST:event_btPermisoAmbientalActionPerformed

    private void btPermisoAguaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPermisoAguaActionPerformed
        abrirArchivoProyecto(proyecto.getPermisoAgua());
    }//GEN-LAST:event_btPermisoAguaActionPerformed

    private void btAuditoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAuditoriasActionPerformed
        abrirArchivoProyecto(proyecto.getAuditoria());
    }//GEN-LAST:event_btAuditoriasActionPerformed

    private void btMonitoreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMonitoreoActionPerformed
        abrirArchivoProyecto(proyecto.getMonitoreo());
    }//GEN-LAST:event_btMonitoreoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAuditorias;
    private javax.swing.JButton btMonitoreo;
    private javax.swing.JButton btPermisoAgua;
    private javax.swing.JButton btPermisoAmbiental;
    private javax.swing.JButton btnRegresarPanelTabla1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lbAuditoria;
    private javax.swing.JLabel lbMonitoreo;
    private javax.swing.JLabel lbPermisoAgua;
    private javax.swing.JLabel lbPermisoAmbiental;
    private javax.swing.JPanel panelAbrirProyecto;
    private javax.swing.JTable tbActividades;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtFechaFinal;
    private javax.swing.JTextField txtFechaInicio;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextArea txtRecordatorio;
    // End of variables declaration//GEN-END:variables
}
