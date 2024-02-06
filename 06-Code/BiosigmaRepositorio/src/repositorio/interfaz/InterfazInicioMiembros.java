package repositorio.interfaz;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class InterfazInicioMiembros extends javax.swing.JInternalFrame {

    String CargoIngreso;
    private int contador = 1;


    public InterfazInicioMiembros(String usuario) {
        this.CargoIngreso = usuario;
        initComponents();
        if (CargoIngreso.equals("Trabajador")) {
            btAgregarMiembro.setVisible(false);
            btnActualizarProyecto.setVisible(false);
            jLUsuarios.setVisible(false);
            jLImgUsuarios.setVisible(false);
        } else if (CargoIngreso.equals("Cliente")) {
            btAgregarMiembro.setVisible(false);
            btnActualizarProyecto.setVisible(false);
            btnAgregarProyecto.setVisible(false);
            jLUsuarios.setVisible(false);
            jLImgUsuarios.setVisible(false);
        }
        PanelBiosigmaLogo.setBackground(new Color(0, 0, 0, 160));
        panelDescripcion.setBackground(new Color(0, 0, 0, 100));
        panelOpciones.setBackground(new Color(0, 0, 0, 160));
        panelOpciones.setVisible(false);
        lbAvisoCorreo.setVisible(false);
        tbPanelesProyectos.setSelectedIndex(0);
    }

    private int recuperarAnioNacimiento(Date anioNacimiento) {
        SimpleDateFormat f1 = new SimpleDateFormat("yyyy");
        String anioNacimientoCadena = f1.format(anioNacimiento);
        int anio = Integer.parseInt(anioNacimientoCadena);
        return anio;
    }

    private void limpiar() {
        txtCedulA.setText("");
        txtCodigo.setText("");
        txtCorreo.setText("");
        txtEdad.setText("");
        txtNombre.setText("");
        cbCargo.setSelectedIndex(0);
        dcFecha.setDate(null);
    }

    private void calcularEdad(int anioNacimiento) {
        LocalDate actual = LocalDate.now();

        int anioActual = actual.getYear();

        int edad = anioActual - anioNacimiento;
        String edadCalculada = edad + "";
        txtEdad.setText(edadCalculada);
    }

    private boolean validarCorreo(String correo) {
        Pattern patron = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mat = patron.matcher(correo);
        return mat.find();
    }

    private boolean validarCedula() {
        if (txtCedulA.getText().isEmpty()) {
            return false;
        } else {
            int[] cedulaContenido = new int[10];
            int cedulaString = Integer.parseInt(txtCedulA.getText());
            int cedulaStringDivisor = cedulaString, cont = 0, iniciador = 0, residuo, cosciente, mul = 0, sumpar = 0, sumimpar = 0, sumtotal = 0, res = 0, comprobador = 0;

            for (iniciador = 9; iniciador >= 0; iniciador--) {
                cosciente = cedulaStringDivisor / 10;
                residuo = cedulaStringDivisor % 10;
                cedulaContenido[iniciador] = residuo;
                cedulaStringDivisor = cosciente;
            }

            if (cedulaContenido[0] == 0 && cedulaContenido[1] == 0) {
                cont++;
            }

            if (cedulaContenido[0] == 2 && cedulaContenido[1] > 4) {
                cont++;
            }

            if (cedulaContenido[0] == 3 && cedulaContenido[1] != 0) {
                cont++;
            }
            for (iniciador = 0; iniciador < 9; iniciador += 2) {
                mul = cedulaContenido[iniciador] * 2;
                if (mul > 9) {
                    mul -= 9;
                }
                sumpar += mul;
            }
            for (iniciador = 1; iniciador < 9; iniciador += 2) {
                sumimpar += cedulaContenido[iniciador];
            }
            sumtotal = sumpar + sumimpar;
            res = sumtotal % 10;
            comprobador = 10 - res;
            if (comprobador == 10) {
                comprobador = 0;
            }
            if (comprobador == cedulaContenido[9] && cont == 0) {
                return true;
            } else {
                return false;
            }
        }
    }

    private boolean validarDatos() {
        boolean validacion = false;
        if ((txtNombre.getText().length() > 0) && validarCedula() && (dcFecha.getDate() != null) && validarCorreo(txtCorreo.getText()) && (!"Seleccione un cargo".equals(cbCargo.getSelectedItem().toString()))) {
            validacion = true;
            return validacion;
        } else {
            return validacion;
        }

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
        jLImgUsuarios = new javax.swing.JLabel();
        jLUsuarios = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        panelPestañas = new javax.swing.JPanel();
        tbPaneles = new javax.swing.JTabbedPane();
        panelPresentacion = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        panelDescripcion = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        panelProyectos = new javax.swing.JPanel();
        tbPanelesProyectos = new javax.swing.JTabbedPane();
        panelTablaProyectos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnAgregarProyecto = new javax.swing.JButton();
        btnAbrirProyecto = new javax.swing.JButton();
        btnActualizarProyecto = new javax.swing.JButton();
        btnRegresarProyectos = new javax.swing.JButton();
        PanelActualizarProyecto = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        btnRegresarPanelTabla = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        panelMiembros = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        btAgregarMiembro = new javax.swing.JButton();
        btnActualizarusuarios = new javax.swing.JButton();
        btnEliminarUsuarios = new javax.swing.JButton();
        txtEdad = new javax.swing.JTextField();
        dcFecha = new com.toedter.calendar.JDateChooser();
        txtCedulA = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        btnRegresarUsuarios = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        cbCargo = new javax.swing.JComboBox<>();
        txtCorreo = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        lbAvisoCorreo = new javax.swing.JLabel();
        lbAvisoNombre = new javax.swing.JLabel();
        lbAvisoCedula = new javax.swing.JLabel();
        lbAvisoFecha = new javax.swing.JLabel();
        lbAvisoCargo = new javax.swing.JLabel();
        tbMiembros = new javax.swing.JTabbedPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbAdmin = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbClientes = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbTrabajadores = new javax.swing.JTable();
        BtnLimpiarUsuarios = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        panelSuperior = new javax.swing.JPanel();
        BotonOpciones = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        panelOpciones = new javax.swing.JPanel();
        btInfoProgramador = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1070, 630));
        setMinimumSize(new java.awt.Dimension(1070, 630));
        setPreferredSize(new java.awt.Dimension(1083, 663));
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
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addContainerGap(66, Short.MAX_VALUE))
        );
        BotonProyectosLayout.setVerticalGroup(
            BotonProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BotonProyectosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(BotonProyectosLayout.createSequentialGroup()
                .addComponent(jLabel11)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelBotones.add(BotonProyectos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 230, 60));

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

        jLImgUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/BotonAgregarMiembro.png"))); // NOI18N

        jLUsuarios.setBackground(new java.awt.Color(51, 0, 51));
        jLUsuarios.setFont(new java.awt.Font("Segoe UI Light", 1, 24)); // NOI18N
        jLUsuarios.setForeground(new java.awt.Color(51, 51, 51));
        jLUsuarios.setText("Usuarios");

        javax.swing.GroupLayout BotonAgregarMiembrosLayout = new javax.swing.GroupLayout(BotonAgregarMiembros);
        BotonAgregarMiembros.setLayout(BotonAgregarMiembrosLayout);
        BotonAgregarMiembrosLayout.setHorizontalGroup(
            BotonAgregarMiembrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BotonAgregarMiembrosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLImgUsuarios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLUsuarios)
                .addContainerGap(89, Short.MAX_VALUE))
        );
        BotonAgregarMiembrosLayout.setVerticalGroup(
            BotonAgregarMiembrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BotonAgregarMiembrosLayout.createSequentialGroup()
                .addGroup(BotonAgregarMiembrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BotonAgregarMiembrosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLImgUsuarios))
                    .addGroup(BotonAgregarMiembrosLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLUsuarios)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        panelBotones.add(BotonAgregarMiembros, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 240, 70));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/colibri_png.png"))); // NOI18N
        panelBotones.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, 160, 140));

        getContentPane().add(panelBotones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 630));

        panelPestañas.setBackground(new java.awt.Color(0, 153, 102));

        tbPaneles.setBackground(new java.awt.Color(255, 255, 255));
        tbPaneles.setTabPlacement(javax.swing.JTabbedPane.RIGHT);

        panelPresentacion.setBackground(new java.awt.Color(51, 102, 0));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/ImagenHidroabanico.jpg"))); // NOI18N

        panelDescripcion.setBackground(new java.awt.Color(0, 0, 0));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/oso5 (1).png"))); // NOI18N

        javax.swing.GroupLayout panelDescripcionLayout = new javax.swing.GroupLayout(panelDescripcion);
        panelDescripcion.setLayout(panelDescripcionLayout);
        panelDescripcionLayout.setHorizontalGroup(
            panelDescripcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDescripcionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 235, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );
        panelDescripcionLayout.setVerticalGroup(
            panelDescripcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Yu Gothic Medium", 1, 36)); // NOI18N
        jLabel1.setText("BIOSIGMA RESPOSITORIO");

        javax.swing.GroupLayout panelPresentacionLayout = new javax.swing.GroupLayout(panelPresentacion);
        panelPresentacion.setLayout(panelPresentacionLayout);
        panelPresentacionLayout.setHorizontalGroup(
            panelPresentacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPresentacionLayout.createSequentialGroup()
                .addGroup(panelPresentacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPresentacionLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addGap(43, 43, 43)
                        .addComponent(panelDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelPresentacionLayout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(jLabel1)))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        panelPresentacionLayout.setVerticalGroup(
            panelPresentacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPresentacionLayout.createSequentialGroup()
                .addContainerGap(131, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGroup(panelPresentacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPresentacionLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel10))
                    .addGroup(panelPresentacionLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(61, 61, 61))
        );

        tbPaneles.addTab("tab1", panelPresentacion);

        panelProyectos.setBackground(new java.awt.Color(0, 51, 0));

        tbPanelesProyectos.setTabPlacement(javax.swing.JTabbedPane.RIGHT);
        tbPanelesProyectos.setEnabled(false);

        panelTablaProyectos.setBackground(new java.awt.Color(102, 102, 102));

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

        btnAgregarProyecto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/1814113_add_more_plus_icon.png"))); // NOI18N
        btnAgregarProyecto.setText("Agregar Proyecto");
        btnAgregarProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProyectoActionPerformed(evt);
            }
        });

        btnAbrirProyecto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/3643772-archive-archives-document-folder-open_113445.png"))); // NOI18N
        btnAbrirProyecto.setText("Abrir Proyecto");

        btnActualizarProyecto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/185042_edit_modify_icon.png"))); // NOI18N
        btnActualizarProyecto.setText("Actualizar Proyecto");
        btnActualizarProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarProyectoActionPerformed(evt);
            }
        });

        btnRegresarProyectos.setText("Regresar");
        btnRegresarProyectos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarProyectosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTablaProyectosLayout = new javax.swing.GroupLayout(panelTablaProyectos);
        panelTablaProyectos.setLayout(panelTablaProyectosLayout);
        panelTablaProyectosLayout.setHorizontalGroup(
            panelTablaProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaProyectosLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelTablaProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTablaProyectosLayout.createSequentialGroup()
                        .addGroup(panelTablaProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnActualizarProyecto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAbrirProyecto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAgregarProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTablaProyectosLayout.createSequentialGroup()
                        .addComponent(btnRegresarProyectos)
                        .addGap(62, 62, 62))))
        );
        panelTablaProyectosLayout.setVerticalGroup(
            panelTablaProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaProyectosLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(103, Short.MAX_VALUE))
            .addGroup(panelTablaProyectosLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(btnAgregarProyecto)
                .addGap(18, 18, 18)
                .addComponent(btnAbrirProyecto)
                .addGap(29, 29, 29)
                .addComponent(btnActualizarProyecto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegresarProyectos)
                .addGap(95, 95, 95))
        );

        tbPanelesProyectos.addTab("tab1", panelTablaProyectos);

        PanelActualizarProyecto.setBackground(new java.awt.Color(0, 102, 0));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel8.setText("Actualizar Proyecto");

        btnRegresarPanelTabla.setText("Regresar");
        btnRegresarPanelTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarPanelTablaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelActualizarProyectoLayout = new javax.swing.GroupLayout(PanelActualizarProyecto);
        PanelActualizarProyecto.setLayout(PanelActualizarProyectoLayout);
        PanelActualizarProyectoLayout.setHorizontalGroup(
            PanelActualizarProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelActualizarProyectoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegresarPanelTabla)
                .addGap(98, 98, 98))
            .addGroup(PanelActualizarProyectoLayout.createSequentialGroup()
                .addGap(256, 256, 256)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(324, Short.MAX_VALUE))
        );
        PanelActualizarProyectoLayout.setVerticalGroup(
            PanelActualizarProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelActualizarProyectoLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 296, Short.MAX_VALUE)
                .addComponent(btnRegresarPanelTabla)
                .addGap(140, 140, 140))
        );

        tbPanelesProyectos.addTab("tab2", PanelActualizarProyecto);

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Yu Gothic Medium", 1, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("PROYECTOS REGISTRADOS");

        javax.swing.GroupLayout panelProyectosLayout = new javax.swing.GroupLayout(panelProyectos);
        panelProyectos.setLayout(panelProyectosLayout);
        panelProyectosLayout.setHorizontalGroup(
            panelProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProyectosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addGap(248, 248, 248))
            .addGroup(panelProyectosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tbPanelesProyectos, javax.swing.GroupLayout.PREFERRED_SIZE, 895, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelProyectosLayout.setVerticalGroup(
            panelProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelProyectosLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tbPanelesProyectos, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tbPaneles.addTab("tab4", panelProyectos);

        panelMiembros.setBackground(new java.awt.Color(28, 0, 51));

        jPanel10.setBackground(new java.awt.Color(153, 153, 153));

        btAgregarMiembro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/1814113_add_more_plus_icon.png"))); // NOI18N
        btAgregarMiembro.setText("Agregar Miembro");
        btAgregarMiembro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgregarMiembroActionPerformed(evt);
            }
        });

        btnActualizarusuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/185042_edit_modify_icon.png"))); // NOI18N
        btnActualizarusuarios.setText("Actualizar Informacion");
        btnActualizarusuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarusuariosActionPerformed(evt);
            }
        });

        btnEliminarUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/185090_delete_garbage_icon.png"))); // NOI18N
        btnEliminarUsuarios.setText("Eliminar Miembro");
        btnEliminarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarUsuariosActionPerformed(evt);
            }
        });

        txtEdad.setEditable(false);

        dcFecha.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dcFechaPropertyChange(evt);
            }
        });

        txtCedulA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCedulAKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedulAKeyTyped(evt);
            }
        });

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        jLabel15.setText("Nombre Completo");

        jLabel24.setText("N° Cédula");

        jLabel25.setText("Fecha de Nacimiento");

        jLabel26.setText("Edad");

        btnRegresarUsuarios.setText("Regresar");
        btnRegresarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarUsuariosActionPerformed(evt);
            }
        });

        jLabel22.setText("Código");

        txtCodigo.setEditable(false);

        jLabel27.setText("Cargo");

        cbCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un cargo", "Administrador", "Trabajador", "Cliente", " " }));
        cbCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCargoActionPerformed(evt);
            }
        });
        cbCargo.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cbCargoPropertyChange(evt);
            }
        });

        txtCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCorreoKeyReleased(evt);
            }
        });

        jLabel28.setText("Correo");

        lbAvisoCorreo.setForeground(new java.awt.Color(204, 0, 0));
        lbAvisoCorreo.setText("*CORREO INVÁLIDO");

        lbAvisoNombre.setForeground(new java.awt.Color(255, 0, 0));
        lbAvisoNombre.setText("*");

        lbAvisoCedula.setForeground(new java.awt.Color(255, 0, 0));
        lbAvisoCedula.setText("*");

        lbAvisoFecha.setForeground(new java.awt.Color(255, 0, 0));
        lbAvisoFecha.setText("*");

        lbAvisoCargo.setForeground(new java.awt.Color(255, 0, 0));
        lbAvisoCargo.setText("*");

        tbAdmin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cédula", "Nombre", "Correo", "Edad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tbAdmin);

        tbMiembros.addTab("Administradores", jScrollPane4);

        tbClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cédula", "Nombre", "Correo", "Edad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tbClientes);

        tbMiembros.addTab("Clientes", jScrollPane5);

        tbTrabajadores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cédula", "Nombre", "Correo", "Edad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbTrabajadores);

        tbMiembros.addTab("Trabajadores", jScrollPane2);

        BtnLimpiarUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/limpiar.png"))); // NOI18N
        BtnLimpiarUsuarios.setText("Limpiar datos");
        BtnLimpiarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLimpiarUsuariosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(tbMiembros, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnActualizarusuarios)
                            .addComponent(btAgregarMiembro, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminarUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtCedulA, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(30, 30, 30)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel26)
                                    .addComponent(jLabel25))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbAvisoNombre)
                                    .addComponent(lbAvisoCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbAvisoFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(jLabel28)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbAvisoCorreo)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel22)
                                            .addComponent(jLabel27))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtCodigo)
                                            .addComponent(cbCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel10Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lbAvisoCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(BtnLimpiarUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRegresarUsuarios)
                                .addGap(15, 15, 15)))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btAgregarMiembro)
                        .addGap(18, 18, 18)
                        .addComponent(btnActualizarusuarios)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminarUsuarios))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tbMiembros, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbAvisoNombre))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(txtCedulA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbAvisoCedula)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel22)
                                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(BtnLimpiarUsuarios)
                                .addGap(32, 32, 32)))
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27)
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbAvisoCargo)))))
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel28)
                                    .addComponent(lbAvisoFecha)
                                    .addComponent(lbAvisoCorreo)))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel25)
                                    .addComponent(dcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26)
                            .addComponent(btnRegresarUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(12, Short.MAX_VALUE))))
        );

        jLabel21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel21.setFont(new java.awt.Font("Yu Gothic Medium", 1, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("REGISTRO");

        javax.swing.GroupLayout panelMiembrosLayout = new javax.swing.GroupLayout(panelMiembros);
        panelMiembros.setLayout(panelMiembrosLayout);
        panelMiembrosLayout.setHorizontalGroup(
            panelMiembrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMiembrosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(440, 440, 440))
            .addGroup(panelMiembrosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        panelMiembrosLayout.setVerticalGroup(
            panelMiembrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMiembrosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tbPaneles.addTab("tab2", panelMiembros);

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
                .addContainerGap(520, Short.MAX_VALUE))
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
        panelSuperior.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BotonOpciones.setBackground(new java.awt.Color(0, 153, 102));
        BotonOpciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonOpcionesMouseClicked(evt);
            }
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

        panelSuperior.add(BotonOpciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(774, 16, 60, -1));

        btInfoProgramador.setText("Información del Programador");
        btInfoProgramador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInfoProgramadorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelOpcionesLayout = new javax.swing.GroupLayout(panelOpciones);
        panelOpciones.setLayout(panelOpcionesLayout);
        panelOpcionesLayout.setHorizontalGroup(
            panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOpcionesLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(btInfoProgramador)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        panelOpcionesLayout.setVerticalGroup(
            panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOpcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btInfoProgramador)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        panelSuperior.add(panelOpciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, 260, 40));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/Vólcan_Cotopaxi.jpg"))); // NOI18N
        panelSuperior.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 6, -1, 180));

        getContentPane().add(panelSuperior, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, 900, 110));

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

    private void BotonOpcionesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonOpcionesMouseEntered
        BotonOpciones.setBackground(new Color(204, 255, 204));
    }//GEN-LAST:event_BotonOpcionesMouseEntered

    private void BotonOpcionesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonOpcionesMouseExited
        BotonOpciones.setBackground(new Color(0, 153, 102));
    }//GEN-LAST:event_BotonOpcionesMouseExited

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        char validacion = evt.getKeyChar();
        if (Character.isDigit(validacion)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingrese solo letras");
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void dcFechaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dcFechaPropertyChange
        if (dcFecha.getDate() != null) {
            int anioNacimiento = recuperarAnioNacimiento(dcFecha.getDate());
            lbAvisoFecha.setVisible(false);
            calcularEdad(anioNacimiento);
        }
    }//GEN-LAST:event_dcFechaPropertyChange

    private void btnRegresarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarUsuariosActionPerformed
        tbPaneles.setSelectedIndex(0);
    }//GEN-LAST:event_btnRegresarUsuariosActionPerformed

    private void btAgregarMiembroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregarMiembroActionPerformed

        DefaultTableModel dtm1 = (DefaultTableModel) tbAdmin.getModel();
        DefaultTableModel dtm2 = (DefaultTableModel) tbClientes.getModel();
        DefaultTableModel dtm3 = (DefaultTableModel) tbTrabajadores.getModel();

        String nombre = txtNombre.getText();
        String cedula = txtCedulA.getText();
        String correo = txtCorreo.getText();
        String edad = txtEdad.getText();

        if (validarDatos() && validarCedula()) {
            if (CargoIngreso.equals("Administrador")) {
                dtm1.addRow(new Object[]{cedula, nombre, correo, edad});
                tbMiembros.setSelectedIndex(0);
                JOptionPane.showMessageDialog(null, "Usuario guardado correctamente.");
            } else if (CargoIngreso.equals("Trabajador")) {
                dtm3.addRow(new Object[]{cedula, nombre, correo, edad});
                tbMiembros.setSelectedIndex(2);
                JOptionPane.showMessageDialog(null, "Usuario guardado correctamente.");
            } else if (CargoIngreso.equals("Cliente")) {
                tbMiembros.setSelectedIndex(1);
                dtm2.addRow(new Object[]{cedula, nombre, correo, edad});
                JOptionPane.showMessageDialog(null, "Usuario guardado correctamente.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese los datos correctamente");
        }

    }//GEN-LAST:event_btAgregarMiembroActionPerformed

    private void txtCorreoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorreoKeyReleased
        if (validarCorreo(txtCorreo.getText())) {
            lbAvisoCorreo.setVisible(false);
        } else {
            lbAvisoCorreo.setVisible(true);
        }
    }//GEN-LAST:event_txtCorreoKeyReleased

    private void cbCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCargoActionPerformed
        String cargo = (String) cbCargo.getSelectedItem();
        if (cargo.equals("Seleccione un cargo")) {
            CargoIngreso = "";
        } else if (cargo.equals("Administrador")) {
            CargoIngreso = "Administrador";
        } else if (cargo.equals("Trabajador")) {
            CargoIngreso = "Trabajador";
        } else if (cargo.equals("Cliente")) {
            CargoIngreso = "Cliente";
        }

    }//GEN-LAST:event_cbCargoActionPerformed

    private void BotonOpcionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonOpcionesMouseClicked
        if (contador == 1) {
            panelOpciones.setVisible(true);
            contador = 2;
        } else if (contador == 2) {
            panelOpciones.setVisible(false);
            contador = 1;
        }
    }//GEN-LAST:event_BotonOpcionesMouseClicked

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
        if (txtNombre.getText().length() == 0) {
            lbAvisoNombre.setVisible(true);
        } else {
            lbAvisoNombre.setVisible(false);
        }
    }//GEN-LAST:event_txtNombreKeyReleased

    private void txtCedulAKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulAKeyReleased
        if (!validarCedula()) {
            lbAvisoCedula.setVisible(true);
        } else {
            lbAvisoCedula.setVisible(false);
        }
    }//GEN-LAST:event_txtCedulAKeyReleased

    private void cbCargoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cbCargoPropertyChange
        if ("Seleccione un cargo".equals(cbCargo.getSelectedItem().toString())) {
            lbAvisoCargo.setVisible(true);
        } else {
            lbAvisoCargo.setVisible(false);
        }
    }//GEN-LAST:event_cbCargoPropertyChange

    private void btInfoProgramadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInfoProgramadorActionPerformed
        JOptionPane.showMessageDialog(null, "=============================================="
                + "\n\tProgramadores:"
                + "\n1.- Gabriel López"
                + "\n2.- Mateo Medranda"
                + "\n3.- Alejandro Obando"
                + "\n4.- Joselyn Morocho"
                + "\n==============================================");
    }//GEN-LAST:event_btInfoProgramadorActionPerformed

    private void txtCedulAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulAKeyTyped
        char validacion = evt.getKeyChar();
        if (Character.isLetter(validacion)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingrese solo digitos");
        }
    }//GEN-LAST:event_txtCedulAKeyTyped

    private void BtnLimpiarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLimpiarUsuariosActionPerformed
        // TODO add your handling code here:
        limpiar();
    }//GEN-LAST:event_BtnLimpiarUsuariosActionPerformed

    private void btnActualizarusuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarusuariosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActualizarusuariosActionPerformed

    private void btnRegresarProyectosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarProyectosActionPerformed
        tbPaneles.setSelectedIndex(0);
    }//GEN-LAST:event_btnRegresarProyectosActionPerformed

    private void btnEliminarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarUsuariosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarUsuariosActionPerformed

    private void btnActualizarProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarProyectoActionPerformed
        tbPanelesProyectos.setSelectedIndex(1);
    }//GEN-LAST:event_btnActualizarProyectoActionPerformed

    private void btnAgregarProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProyectoActionPerformed
        
    }//GEN-LAST:event_btnAgregarProyectoActionPerformed

    private void btnRegresarPanelTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarPanelTablaActionPerformed
       tbPanelesProyectos.setSelectedIndex(0);
    }//GEN-LAST:event_btnRegresarPanelTablaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BotonAgregarMiembros;
    private javax.swing.JPanel BotonOpciones;
    private javax.swing.JPanel BotonProyectos;
    private javax.swing.JButton BtnLimpiarUsuarios;
    private javax.swing.JPanel PanelActualizarProyecto;
    private javax.swing.JPanel PanelBiosigmaLogo;
    private javax.swing.JButton btAgregarMiembro;
    private javax.swing.JButton btInfoProgramador;
    private javax.swing.JButton btnAbrirProyecto;
    private javax.swing.JButton btnActualizarProyecto;
    private javax.swing.JButton btnActualizarusuarios;
    private javax.swing.JButton btnAgregarProyecto;
    private javax.swing.JButton btnEliminarUsuarios;
    private javax.swing.JButton btnRegresarPanelTabla;
    private javax.swing.JButton btnRegresarProyectos;
    private javax.swing.JButton btnRegresarUsuarios;
    private javax.swing.JComboBox<String> cbCargo;
    private com.toedter.calendar.JDateChooser dcFecha;
    private javax.swing.JLabel jLImgUsuarios;
    private javax.swing.JLabel jLUsuarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbAvisoCargo;
    private javax.swing.JLabel lbAvisoCedula;
    private javax.swing.JLabel lbAvisoCorreo;
    private javax.swing.JLabel lbAvisoFecha;
    private javax.swing.JLabel lbAvisoNombre;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelDescripcion;
    private javax.swing.JPanel panelMiembros;
    private javax.swing.JPanel panelOpciones;
    private javax.swing.JPanel panelPestañas;
    private javax.swing.JPanel panelPresentacion;
    private javax.swing.JPanel panelProyectos;
    private javax.swing.JPanel panelSuperior;
    private javax.swing.JPanel panelTablaProyectos;
    private javax.swing.JTable tbAdmin;
    private javax.swing.JTable tbClientes;
    private javax.swing.JTabbedPane tbMiembros;
    private javax.swing.JTabbedPane tbPaneles;
    private javax.swing.JTabbedPane tbPanelesProyectos;
    private javax.swing.JTable tbTrabajadores;
    private javax.swing.JTextField txtCedulA;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
