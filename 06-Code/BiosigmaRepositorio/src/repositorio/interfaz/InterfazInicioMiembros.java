package repositorio.interfaz;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import javax.swing.JOptionPane;

public class InterfazInicioMiembros extends javax.swing.JInternalFrame {

    public InterfazInicioMiembros() {
        initComponents();
        PanelBiosigmaLogo.setBackground(new Color(0, 0, 0, 160));
        panelDescripcion.setBackground(new Color(0, 0, 0, 100));
    }

    private int recuperarAnioNacimiento(Date anioNacimiento) {
        SimpleDateFormat f1 = new SimpleDateFormat("yyyy");
        String anioNacimientoCadena = f1.format(anioNacimiento);
        int anio = Integer.parseInt(anioNacimientoCadena);
        return anio;
    }

    private void calcularEdad(int anioNacimiento) {
        LocalDate actual = LocalDate.now();

        int anioActual = actual.getYear();

        int edad = anioActual - anioNacimiento;
            String edadCalculada = edad + "";
            txtEdadMiembro.setText(edadCalculada);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBotones = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        PanelBiosigmaLogo = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        BotonProyectos = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        BotonAgregarMiembros = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        BotonAgregarClientes = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        panelPestañas = new javax.swing.JPanel();
        tbPaneles = new javax.swing.JTabbedPane();
        panelPresentacion = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        panelDescripcion = new javax.swing.JPanel();
        panelProyectos = new javax.swing.JPanel();
        panelTablaProyectos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        panelMiembros = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        txtEdadMiembro = new javax.swing.JTextField();
        dcFechaMiembro = new com.toedter.calendar.JDateChooser();
        txtCedulaMiembro = new javax.swing.JTextField();
        txtNombreMiembro = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        txtCodigoMiembro = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        panelClientes = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        panelSuperior = new javax.swing.JPanel();
        BotonOpciones = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1070, 630));
        setMinimumSize(new java.awt.Dimension(1070, 630));
        setPreferredSize(new java.awt.Dimension(1070, 630));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelBotones.setBackground(new java.awt.Color(0, 204, 153));
        panelBotones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(101, 206, 97));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setBackground(new java.awt.Color(102, 255, 51));
        jLabel2.setFont(new java.awt.Font("Sitka Text", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
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

        panelBotones.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 190, 40));

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

        panelBotones.add(PanelBiosigmaLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 230, 60));

        jLabel3.setBackground(new java.awt.Color(255, 51, 51));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/FondoBienvenidos.png"))); // NOI18N
        panelBotones.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 130));

        BotonProyectos.setBackground(new java.awt.Color(0, 204, 153));
        BotonProyectos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonProyectosMouseClicked(evt);
            }
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

        panelBotones.add(BotonProyectos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 230, 60));

        BotonAgregarMiembros.setBackground(new java.awt.Color(0, 204, 153));
        BotonAgregarMiembros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonAgregarMiembrosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotonAgregarMiembrosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotonAgregarMiembrosMouseExited(evt);
            }
        });

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/BotonAgregarMiembro.png"))); // NOI18N

        jLabel17.setBackground(new java.awt.Color(51, 0, 51));
        jLabel17.setFont(new java.awt.Font("Segoe UI Light", 1, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(51, 51, 51));
        jLabel17.setText("Miembros");

        javax.swing.GroupLayout BotonAgregarMiembrosLayout = new javax.swing.GroupLayout(BotonAgregarMiembros);
        BotonAgregarMiembros.setLayout(BotonAgregarMiembrosLayout);
        BotonAgregarMiembrosLayout.setHorizontalGroup(
            BotonAgregarMiembrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BotonAgregarMiembrosLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addGap(18, 18, 18))
        );
        BotonAgregarMiembrosLayout.setVerticalGroup(
            BotonAgregarMiembrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BotonAgregarMiembrosLayout.createSequentialGroup()
                .addGroup(BotonAgregarMiembrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BotonAgregarMiembrosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel13))
                    .addGroup(BotonAgregarMiembrosLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel17)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        panelBotones.add(BotonAgregarMiembros, new org.netbeans.lib.awtextra.AbsoluteConstraints(-6, 290, 240, 70));

        BotonAgregarClientes.setBackground(new java.awt.Color(0, 204, 153));
        BotonAgregarClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonAgregarClientesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotonAgregarClientesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotonAgregarClientesMouseExited(evt);
            }
        });

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/BotonAgregarCliente.png"))); // NOI18N

        jLabel18.setBackground(new java.awt.Color(51, 0, 51));
        jLabel18.setFont(new java.awt.Font("Segoe UI Light", 1, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(51, 51, 51));
        jLabel18.setText("Clientes");

        javax.swing.GroupLayout BotonAgregarClientesLayout = new javax.swing.GroupLayout(BotonAgregarClientes);
        BotonAgregarClientes.setLayout(BotonAgregarClientesLayout);
        BotonAgregarClientesLayout.setHorizontalGroup(
            BotonAgregarClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BotonAgregarClientesLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(jLabel18)
                .addGap(33, 33, 33))
        );
        BotonAgregarClientesLayout.setVerticalGroup(
            BotonAgregarClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BotonAgregarClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BotonAgregarClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(jLabel14))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        panelBotones.add(BotonAgregarClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 230, 70));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/colibri_png.png"))); // NOI18N
        panelBotones.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, 160, 140));

        getContentPane().add(panelBotones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 630));

        panelPestañas.setBackground(new java.awt.Color(0, 153, 102));

        tbPaneles.setBackground(new java.awt.Color(255, 255, 255));
        tbPaneles.setTabPlacement(javax.swing.JTabbedPane.RIGHT);

        panelPresentacion.setBackground(new java.awt.Color(51, 102, 0));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/ImagenHidroabanico.jpg"))); // NOI18N

        panelDescripcion.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout panelDescripcionLayout = new javax.swing.GroupLayout(panelDescripcion);
        panelDescripcion.setLayout(panelDescripcionLayout);
        panelDescripcionLayout.setHorizontalGroup(
            panelDescripcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );
        panelDescripcionLayout.setVerticalGroup(
            panelDescripcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 319, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelPresentacionLayout = new javax.swing.GroupLayout(panelPresentacion);
        panelPresentacion.setLayout(panelPresentacionLayout);
        panelPresentacionLayout.setHorizontalGroup(
            panelPresentacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPresentacionLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addGap(43, 43, 43)
                .addComponent(panelDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        panelPresentacionLayout.setVerticalGroup(
            panelPresentacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPresentacionLayout.createSequentialGroup()
                .addContainerGap(134, Short.MAX_VALUE)
                .addGroup(panelPresentacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPresentacionLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(88, 88, 88))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPresentacionLayout.createSequentialGroup()
                        .addComponent(panelDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61))))
        );

        tbPaneles.addTab("tab1", panelPresentacion);

        panelProyectos.setBackground(new java.awt.Color(0, 51, 0));

        panelTablaProyectos.setBackground(new java.awt.Color(51, 51, 51));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre ", "Completado", "Recordatorios"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/1814113_add_more_plus_icon.png"))); // NOI18N
        jButton1.setText("Agregar Proyecto");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/3643772-archive-archives-document-folder-open_113445.png"))); // NOI18N
        jButton2.setText("Abrir Proyecto");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/185042_edit_modify_icon.png"))); // NOI18N
        jButton3.setText("Actualizar Proyecto");

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/185090_delete_garbage_icon.png"))); // NOI18N
        jButton4.setText("Eliminar Proyecto");

        javax.swing.GroupLayout panelTablaProyectosLayout = new javax.swing.GroupLayout(panelTablaProyectos);
        panelTablaProyectos.setLayout(panelTablaProyectosLayout);
        panelTablaProyectosLayout.setHorizontalGroup(
            panelTablaProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaProyectosLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(panelTablaProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );
        panelTablaProyectosLayout.setVerticalGroup(
            panelTablaProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaProyectosLayout.createSequentialGroup()
                .addGroup(panelTablaProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTablaProyectosLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelTablaProyectosLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(29, 29, 29)
                        .addComponent(jButton3)
                        .addGap(27, 27, 27)
                        .addComponent(jButton4)))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jLabel16.setFont(new java.awt.Font("Yu Gothic Medium", 1, 24)); // NOI18N
        jLabel16.setText("PROYECTOS REGISTRADOS");

        javax.swing.GroupLayout panelProyectosLayout = new javax.swing.GroupLayout(panelProyectos);
        panelProyectos.setLayout(panelProyectosLayout);
        panelProyectosLayout.setHorizontalGroup(
            panelProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProyectosLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(panelProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelProyectosLayout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(242, 242, 242))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelProyectosLayout.createSequentialGroup()
                        .addComponent(panelTablaProyectos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))))
        );
        panelProyectosLayout.setVerticalGroup(
            panelProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelProyectosLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelTablaProyectos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        tbPaneles.addTab("tab4", panelProyectos);

        panelMiembros.setBackground(new java.awt.Color(28, 0, 51));

        jPanel10.setBackground(new java.awt.Color(51, 51, 51));

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cédula", "Nombre", "Cargo", "Correo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable3);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/1814113_add_more_plus_icon.png"))); // NOI18N
        jButton6.setText("Agregar Miembro");

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/185042_edit_modify_icon.png"))); // NOI18N
        jButton9.setText("Actualizar Informacion");

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/185090_delete_garbage_icon.png"))); // NOI18N
        jButton10.setText("Eliminar Miembro");

        txtEdadMiembro.setEditable(false);

        dcFechaMiembro.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dcFechaMiembroPropertyChange(evt);
            }
        });

        txtNombreMiembro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreMiembroKeyTyped(evt);
            }
        });

        jLabel15.setText("Nombre Completo");

        jLabel24.setText("N° Cédula");

        jLabel25.setText("Fecha de Nacimiento");

        jLabel26.setText("Edad");

        jButton11.setText("Regresar");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jLabel22.setText("Código");

        txtCodigoMiembro.setEditable(false);

        jLabel27.setText("Cargo");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtCedulaMiembro, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(30, 30, 30)
                                .addComponent(txtNombreMiembro, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel25)
                                    .addComponent(jLabel26))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dcFechaMiembro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(txtEdadMiembro, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton11)
                                .addContainerGap())
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel27))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCodigoMiembro, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25))))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jButton6)
                        .addGap(18, 18, 18)
                        .addComponent(jButton9)
                        .addGap(18, 18, 18)
                        .addComponent(jButton10))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 160, Short.MAX_VALUE)
                        .addComponent(jButton11))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15)
                                    .addComponent(txtNombreMiembro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel24)
                                    .addComponent(txtCedulaMiembro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel22)
                                    .addComponent(txtCodigoMiembro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel27)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25)
                            .addComponent(dcFechaMiembro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26)
                            .addComponent(txtEdadMiembro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jLabel21.setFont(new java.awt.Font("Yu Gothic Medium", 1, 24)); // NOI18N
        jLabel21.setText("MIEMBROS REGISTRADOS");

        javax.swing.GroupLayout panelMiembrosLayout = new javax.swing.GroupLayout(panelMiembros);
        panelMiembros.setLayout(panelMiembrosLayout);
        panelMiembrosLayout.setHorizontalGroup(
            panelMiembrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMiembrosLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMiembrosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel21)
                .addGap(249, 249, 249))
        );
        panelMiembrosLayout.setVerticalGroup(
            panelMiembrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMiembrosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );

        tbPaneles.addTab("tab2", panelMiembros);

        panelClientes.setBackground(new java.awt.Color(18, 75, 59));

        jPanel9.setBackground(new java.awt.Color(51, 51, 51));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/1814113_add_more_plus_icon.png"))); // NOI18N
        jButton5.setText("Agregar Cliente");

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/185042_edit_modify_icon.png"))); // NOI18N
        jButton7.setText("Actualizar Informacion");

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/185090_delete_garbage_icon.png"))); // NOI18N
        jButton8.setText("Eliminar Cliente");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(35, 35, 35))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addGap(32, 32, 32)
                .addComponent(jButton7)
                .addGap(30, 30, 30)
                .addComponent(jButton8)
                .addGap(87, 87, 87))
        );

        jLabel20.setFont(new java.awt.Font("Yu Gothic Medium", 1, 24)); // NOI18N
        jLabel20.setText("CLIENTES REGISTRADOS");

        javax.swing.GroupLayout panelClientesLayout = new javax.swing.GroupLayout(panelClientes);
        panelClientes.setLayout(panelClientesLayout);
        panelClientesLayout.setHorizontalGroup(
            panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelClientesLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelClientesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel20)
                .addGap(249, 249, 249))
        );
        panelClientesLayout.setVerticalGroup(
            panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelClientesLayout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(jLabel20)
                .addGap(18, 18, 18)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        tbPaneles.addTab("tab3", panelClientes);

        jLabel23.setFont(new java.awt.Font("Yu Gothic Medium", 1, 24)); // NOI18N
        jLabel23.setText("Proyecto Seleccionado");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(308, Short.MAX_VALUE)
                .addComponent(jLabel23)
                .addGap(274, 274, 274))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel23)
                .addContainerGap(453, Short.MAX_VALUE))
        );

        tbPaneles.addTab("tab5", jPanel1);

        javax.swing.GroupLayout panelPestañasLayout = new javax.swing.GroupLayout(panelPestañas);
        panelPestañas.setLayout(panelPestañasLayout);
        panelPestañasLayout.setHorizontalGroup(
            panelPestañasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPestañasLayout.createSequentialGroup()
                .addComponent(tbPaneles, javax.swing.GroupLayout.PREFERRED_SIZE, 896, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelPestañasLayout.setVerticalGroup(
            panelPestañasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPestañasLayout.createSequentialGroup()
                .addComponent(tbPaneles)
                .addContainerGap())
        );

        getContentPane().add(panelPestañas, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 840, 520));

        panelSuperior.setBackground(new java.awt.Color(0, 153, 102));

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

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/Vólcan_Cotopaxi.jpg"))); // NOI18N

        javax.swing.GroupLayout panelSuperiorLayout = new javax.swing.GroupLayout(panelSuperior);
        panelSuperior.setLayout(panelSuperiorLayout);
        panelSuperiorLayout.setHorizontalGroup(
            panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSuperiorLayout.createSequentialGroup()
                .addContainerGap(94, Short.MAX_VALUE)
                .addComponent(jLabel19)
                .addGap(80, 80, 80)
                .addComponent(BotonOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelSuperiorLayout.setVerticalGroup(
            panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSuperiorLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(BotonOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSuperiorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );

        getContentPane().add(panelSuperior, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, 840, 110));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonProyectosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonProyectosMouseClicked
        tbPaneles.setSelectedIndex(1);
    }//GEN-LAST:event_BotonProyectosMouseClicked

    private void BotonProyectosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonProyectosMouseEntered
        BotonProyectos.setBackground(new Color(204, 255, 204));
    }//GEN-LAST:event_BotonProyectosMouseEntered

    private void BotonProyectosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonProyectosMouseExited
        BotonProyectos.setBackground(new Color(0, 204, 153));
    }//GEN-LAST:event_BotonProyectosMouseExited

    private void BotonAgregarMiembrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonAgregarMiembrosMouseClicked
        tbPaneles.setSelectedIndex(2);
    }//GEN-LAST:event_BotonAgregarMiembrosMouseClicked

    private void BotonAgregarMiembrosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonAgregarMiembrosMouseEntered
        BotonAgregarMiembros.setBackground(new Color(204, 255, 204));
    }//GEN-LAST:event_BotonAgregarMiembrosMouseEntered

    private void BotonAgregarMiembrosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonAgregarMiembrosMouseExited
        BotonAgregarMiembros.setBackground(new Color(0, 204, 153));
    }//GEN-LAST:event_BotonAgregarMiembrosMouseExited

    private void BotonAgregarClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonAgregarClientesMouseClicked
        tbPaneles.setSelectedIndex(3);
    }//GEN-LAST:event_BotonAgregarClientesMouseClicked

    private void BotonAgregarClientesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonAgregarClientesMouseEntered
        BotonAgregarClientes.setBackground(new Color(204, 255, 204));
    }//GEN-LAST:event_BotonAgregarClientesMouseEntered

    private void BotonAgregarClientesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonAgregarClientesMouseExited
        BotonAgregarClientes.setBackground(new Color(0, 204, 153));
    }//GEN-LAST:event_BotonAgregarClientesMouseExited

    private void BotonOpcionesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonOpcionesMouseEntered
        BotonOpciones.setBackground(new Color(204, 255, 204));
    }//GEN-LAST:event_BotonOpcionesMouseEntered

    private void BotonOpcionesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonOpcionesMouseExited
        BotonOpciones.setBackground(new Color(0, 153, 102));
    }//GEN-LAST:event_BotonOpcionesMouseExited

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void txtNombreMiembroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreMiembroKeyTyped
        char validacion = evt.getKeyChar();
        if (Character.isDigit(validacion)) {
            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "Ingrese solo letras");
        }
    }//GEN-LAST:event_txtNombreMiembroKeyTyped

    private void dcFechaMiembroPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dcFechaMiembroPropertyChange
        if(dcFechaMiembro.getDate() != null){
            int anioNacimiento = recuperarAnioNacimiento(dcFechaMiembro.getDate());
            calcularEdad(anioNacimiento);
        }
    }//GEN-LAST:event_dcFechaMiembroPropertyChange

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        tbPaneles.setSelectedIndex(0);
    }//GEN-LAST:event_jButton11ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BotonAgregarClientes;
    private javax.swing.JPanel BotonAgregarMiembros;
    private javax.swing.JPanel BotonOpciones;
    private javax.swing.JPanel BotonProyectos;
    private javax.swing.JPanel PanelBiosigmaLogo;
    private com.toedter.calendar.JDateChooser dcFechaMiembro;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelClientes;
    private javax.swing.JPanel panelDescripcion;
    private javax.swing.JPanel panelMiembros;
    private javax.swing.JPanel panelPestañas;
    private javax.swing.JPanel panelPresentacion;
    private javax.swing.JPanel panelProyectos;
    private javax.swing.JPanel panelSuperior;
    private javax.swing.JPanel panelTablaProyectos;
    private javax.swing.JTabbedPane tbPaneles;
    private javax.swing.JTextField txtCedulaMiembro;
    private javax.swing.JTextField txtCodigoMiembro;
    private javax.swing.JTextField txtEdadMiembro;
    private javax.swing.JTextField txtNombreMiembro;
    // End of variables declaration//GEN-END:variables
}
