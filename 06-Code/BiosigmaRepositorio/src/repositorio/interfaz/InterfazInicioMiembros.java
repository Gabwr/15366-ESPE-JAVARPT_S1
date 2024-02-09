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
        lbCargo.setVisible(false);
        cbCargo.setVisible(false);
        btAgregarCargo.setVisible(false);
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
        cbTipoPersona.setSelectedIndex(0);
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
        if ((txtNombre.getText().length() > 0) && validarCedula() && (dcFecha.getDate() != null) && validarCorreo(txtCorreo.getText()) && (!"Seleccione un cargo".equals(cbTipoPersona.getSelectedItem().toString()))) {
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
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        BotonProyectos = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        BotonAgregarMiembros = new javax.swing.JPanel();
        jLImgUsuarios = new javax.swing.JLabel();
        jLUsuarios = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
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
        jLabel9 = new javax.swing.JLabel();
        panelAbrirProyecto = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
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
        txtCodigo = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        cbTipoPersona = new javax.swing.JComboBox<>();
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
        lbCargo = new javax.swing.JLabel();
        cbCargo = new javax.swing.JComboBox<>();
        btAgregarCargo = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        panelSuperior = new javax.swing.JPanel();
        BotonOpciones = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        panelOpciones = new javax.swing.JPanel();
        btInfoProgramador = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();

        setBorder(null);
        setTitle("Repositorio");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(1075, 653));
        setMinimumSize(new java.awt.Dimension(1075, 653));
        setPreferredSize(new java.awt.Dimension(1075, 653));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelBotones.setBackground(new java.awt.Color(0, 204, 153));
        panelBotones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(101, 206, 97));
        jPanel2.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel2.setBackground(new java.awt.Color(102, 255, 51));
        jLabel2.setFont(new java.awt.Font("Sitka Text", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("BIENVENIDO");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelBotones.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 190, 40));

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

        panelBotones.add(PanelBiosigmaLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 230, 60));

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(102, 204, 255));
        jTextField1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(0, 0, 0));
        jTextField1.setBorder(null);
        panelBotones.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 190, 30));

        jTextField2.setEditable(false);
        jTextField2.setBackground(new java.awt.Color(102, 204, 255));
        jTextField2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(0, 0, 0));
        jTextField2.setBorder(null);
        panelBotones.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 190, 30));

        jLabel3.setBackground(new java.awt.Color(255, 51, 51));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/FondoBienvenidos.png"))); // NOI18N
        panelBotones.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 230, 100));

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
        jLabel5.setFont(new java.awt.Font("Sitka Display", 1, 36)); // NOI18N
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
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        BotonProyectosLayout.setVerticalGroup(
            BotonProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BotonProyectosLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(BotonProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel5))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        panelBotones.add(BotonProyectos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 230, 70));

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
        jLUsuarios.setFont(new java.awt.Font("Sitka Banner", 1, 36)); // NOI18N
        jLUsuarios.setForeground(new java.awt.Color(51, 51, 51));
        jLUsuarios.setText("Usuarios");

        javax.swing.GroupLayout BotonAgregarMiembrosLayout = new javax.swing.GroupLayout(BotonAgregarMiembros);
        BotonAgregarMiembros.setLayout(BotonAgregarMiembrosLayout);
        BotonAgregarMiembrosLayout.setHorizontalGroup(
            BotonAgregarMiembrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BotonAgregarMiembrosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLImgUsuarios)
                .addGap(18, 18, 18)
                .addComponent(jLUsuarios)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        BotonAgregarMiembrosLayout.setVerticalGroup(
            BotonAgregarMiembrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BotonAgregarMiembrosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(BotonAgregarMiembrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLImgUsuarios)
                    .addComponent(jLUsuarios))
                .addContainerGap())
        );

        panelBotones.add(BotonAgregarMiembros, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 240, 60));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/colibri_png.png"))); // NOI18N
        panelBotones.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, 160, 140));

        jButton1.setBackground(new java.awt.Color(255, 204, 255));
        jButton1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 51, 51));
        jButton1.setText("Cerrar Sesión");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panelBotones.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 450, -1, -1));

        jLabel29.setBackground(new java.awt.Color(255, 51, 51));
        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/FondoBienvenidos.png"))); // NOI18N
        panelBotones.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 100));

        getContentPane().add(panelBotones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 630));

        panelPestañas.setBackground(new java.awt.Color(0, 153, 102));

        tbPaneles.setBackground(new java.awt.Color(255, 255, 255));
        tbPaneles.setTabPlacement(javax.swing.JTabbedPane.RIGHT);

        panelPresentacion.setBackground(new java.awt.Color(204, 255, 153));

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDescripcionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setBackground(new java.awt.Color(255, 153, 102));
        jLabel1.setFont(new java.awt.Font("Cambria Math", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("BIOSIGMA RESPOSITORIO");

        javax.swing.GroupLayout panelPresentacionLayout = new javax.swing.GroupLayout(panelPresentacion);
        panelPresentacion.setLayout(panelPresentacionLayout);
        panelPresentacionLayout.setHorizontalGroup(
            panelPresentacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPresentacionLayout.createSequentialGroup()
                .addGroup(panelPresentacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPresentacionLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel10)
                        .addGap(40, 40, 40)
                        .addComponent(panelDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelPresentacionLayout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(jLabel1)))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        panelPresentacionLayout.setVerticalGroup(
            panelPresentacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPresentacionLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(panelPresentacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(95, 95, 95))
        );

        tbPaneles.addTab("tab1", panelPresentacion);

        panelProyectos.setBackground(new java.awt.Color(51, 0, 51));

        tbPanelesProyectos.setTabPlacement(javax.swing.JTabbedPane.RIGHT);
        tbPanelesProyectos.setEnabled(false);

        panelTablaProyectos.setBackground(new java.awt.Color(204, 204, 255));

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
        btnAbrirProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirProyectoActionPerformed(evt);
            }
        });

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

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 51, 51));
        jLabel9.setText("Haga click en el proyecto que desee en la siguiente tabla para poder abrirlo");

        javax.swing.GroupLayout panelTablaProyectosLayout = new javax.swing.GroupLayout(panelTablaProyectos);
        panelTablaProyectos.setLayout(panelTablaProyectosLayout);
        panelTablaProyectosLayout.setHorizontalGroup(
            panelTablaProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaProyectosLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panelTablaProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTablaProyectosLayout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTablaProyectosLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnRegresarProyectos)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTablaProyectosLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                        .addGroup(panelTablaProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnActualizarProyecto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAbrirProyecto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAgregarProyecto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(38, 38, 38))))
        );
        panelTablaProyectosLayout.setVerticalGroup(
            panelTablaProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaProyectosLayout.createSequentialGroup()
                .addGroup(panelTablaProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTablaProyectosLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel9))
                    .addGroup(panelTablaProyectosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnRegresarProyectos)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTablaProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTablaProyectosLayout.createSequentialGroup()
                        .addComponent(btnAbrirProyecto)
                        .addGap(18, 18, 18)
                        .addComponent(btnAgregarProyecto)
                        .addGap(18, 18, 18)
                        .addComponent(btnActualizarProyecto))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        tbPanelesProyectos.addTab("tab1", panelTablaProyectos);

        jLabel13.setFont(new java.awt.Font("Sitka Banner", 1, 14)); // NOI18N
        jLabel13.setText("Nombre Del Proyecto:");

        jLabel14.setFont(new java.awt.Font("Sitka Banner", 1, 14)); // NOI18N
        jLabel14.setText("Código de Proyecto:");

        jLabel17.setFont(new java.awt.Font("Sitka Banner", 1, 14)); // NOI18N
        jLabel17.setText("Descripción del proyecto:");

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Sitka Banner", 1, 14)); // NOI18N
        jLabel18.setText("Fecha de Inicio:");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        jLabel20.setFont(new java.awt.Font("Sitka Banner", 1, 14)); // NOI18N
        jLabel20.setText("Recordatorios:");

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane6.setViewportView(jTextArea2);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Actividades", "Indicador", "Completado", "Fecha realizada"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(jTable2);

        jButton2.setText("Permiso Ambiental");

        jButton3.setText("Evidencias");

        jButton4.setText("Regresar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Permiso de Agua");

        jLabel22.setFont(new java.awt.Font("Sitka Banner", 1, 14)); // NOI18N
        jLabel22.setText("Plan de Manejo Ambiental");

        jLabel30.setFont(new java.awt.Font("Sitka Banner", 1, 14)); // NOI18N
        jLabel30.setText("Fecha de Finalización:");

        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelAbrirProyectoLayout = new javax.swing.GroupLayout(panelAbrirProyecto);
        panelAbrirProyecto.setLayout(panelAbrirProyectoLayout);
        panelAbrirProyectoLayout.setHorizontalGroup(
            panelAbrirProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAbrirProyectoLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panelAbrirProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelAbrirProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(panelAbrirProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField3)
                            .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(panelAbrirProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAbrirProyectoLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(panelAbrirProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addGroup(panelAbrirProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35))
                    .addGroup(panelAbrirProyectoLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(panelAbrirProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAbrirProyectoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(17, 17, 17))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAbrirProyectoLayout.createSequentialGroup()
                .addGroup(panelAbrirProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAbrirProyectoLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelAbrirProyectoLayout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(jLabel22)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelAbrirProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(78, 78, 78))
        );
        panelAbrirProyectoLayout.setVerticalGroup(
            panelAbrirProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAbrirProyectoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton4)
                .addGap(3, 3, 3)
                .addGroup(panelAbrirProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelAbrirProyectoLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelAbrirProyectoLayout.createSequentialGroup()
                        .addGroup(panelAbrirProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(jLabel20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelAbrirProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)))
                .addGroup(panelAbrirProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAbrirProyectoLayout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jButton2))
                    .addGroup(panelAbrirProyectoLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(panelAbrirProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelAbrirProyectoLayout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelAbrirProyectoLayout.createSequentialGroup()
                                .addComponent(jLabel30)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addComponent(jLabel22)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelAbrirProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAbrirProyectoLayout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addGap(16, 16, 16)
                        .addComponent(jButton3))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        tbPanelesProyectos.addTab("tab3", panelAbrirProyecto);

        PanelActualizarProyecto.setBackground(new java.awt.Color(153, 153, 153));

        jLabel8.setFont(new java.awt.Font("Sitka Banner", 1, 30)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 51, 51));
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
            .addGroup(PanelActualizarProyectoLayout.createSequentialGroup()
                .addContainerGap(300, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(177, 177, 177)
                .addComponent(btnRegresarPanelTabla)
                .addGap(18, 18, 18))
        );
        PanelActualizarProyectoLayout.setVerticalGroup(
            PanelActualizarProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelActualizarProyectoLayout.createSequentialGroup()
                .addGroup(PanelActualizarProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelActualizarProyectoLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelActualizarProyectoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnRegresarPanelTabla)))
                .addContainerGap(398, Short.MAX_VALUE))
        );

        tbPanelesProyectos.addTab("tab2", PanelActualizarProyecto);

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Sitka Banner", 1, 36)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 204, 204));
        jLabel16.setText("PROYECTOS REGISTRADOS");

        javax.swing.GroupLayout panelProyectosLayout = new javax.swing.GroupLayout(panelProyectos);
        panelProyectos.setLayout(panelProyectosLayout);
        panelProyectosLayout.setHorizontalGroup(
            panelProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProyectosLayout.createSequentialGroup()
                .addGroup(panelProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelProyectosLayout.createSequentialGroup()
                        .addGap(223, 223, 223)
                        .addComponent(jLabel16))
                    .addGroup(panelProyectosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tbPanelesProyectos, javax.swing.GroupLayout.PREFERRED_SIZE, 885, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelProyectosLayout.setVerticalGroup(
            panelProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelProyectosLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tbPanelesProyectos, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
        );

        tbPaneles.addTab("tab4", panelProyectos);

        panelMiembros.setBackground(new java.awt.Color(28, 0, 51));

        jPanel10.setBackground(new java.awt.Color(255, 255, 204));
        jPanel10.setForeground(new java.awt.Color(153, 153, 255));

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

        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Nombre Completo");

        jLabel24.setForeground(new java.awt.Color(0, 0, 0));
        jLabel24.setText("N° Cédula");

        jLabel25.setForeground(new java.awt.Color(0, 0, 0));
        jLabel25.setText("Fecha de Nacimiento");

        jLabel26.setForeground(new java.awt.Color(0, 0, 0));
        jLabel26.setText("Edad");

        btnRegresarUsuarios.setText("Regresar");
        btnRegresarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarUsuariosActionPerformed(evt);
            }
        });

        txtCodigo.setEditable(false);

        jLabel27.setForeground(new java.awt.Color(0, 0, 0));
        jLabel27.setText("Tipo de Usuario");

        cbTipoPersona.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un tipo", "Administrador", "Trabajador", "Cliente", " " }));
        cbTipoPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoPersonaActionPerformed(evt);
            }
        });
        cbTipoPersona.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cbTipoPersonaPropertyChange(evt);
            }
        });

        txtCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCorreoKeyReleased(evt);
            }
        });

        jLabel28.setForeground(new java.awt.Color(0, 0, 0));
        jLabel28.setText("Correo");

        lbAvisoCorreo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbAvisoCorreo.setForeground(new java.awt.Color(255, 0, 0));
        lbAvisoCorreo.setText("*Correo Inválido");

        lbAvisoNombre.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbAvisoNombre.setForeground(new java.awt.Color(255, 0, 0));
        lbAvisoNombre.setText("*");

        lbAvisoCedula.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbAvisoCedula.setForeground(new java.awt.Color(255, 0, 0));
        lbAvisoCedula.setText("*");

        lbAvisoFecha.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbAvisoFecha.setForeground(new java.awt.Color(255, 0, 0));
        lbAvisoFecha.setText("*");

        lbAvisoCargo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
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

        lbCargo.setForeground(new java.awt.Color(0, 0, 0));
        lbCargo.setText("Cargo:");

        cbCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un tipo", "Administrador", "Trabajador", "Cliente", " " }));
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

        btAgregarCargo.setText("Agregar Cargo");
        btAgregarCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgregarCargoActionPerformed(evt);
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
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel10Layout.createSequentialGroup()
                                                .addComponent(jLabel15)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lbAvisoNombre))
                                            .addGroup(jPanel10Layout.createSequentialGroup()
                                                .addGap(86, 86, 86)
                                                .addComponent(jLabel26)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel10Layout.createSequentialGroup()
                                                .addComponent(jLabel25)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(dcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lbAvisoFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(37, 37, 37)
                                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel28)
                                            .addComponent(jLabel27)
                                            .addComponent(jLabel24)))
                                    .addComponent(lbCargo))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCedulA, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbTipoPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(131, 131, 131)))
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(lbAvisoCedula)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRegresarUsuarios))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbAvisoCargo)
                                    .addComponent(lbAvisoCorreo)
                                    .addComponent(btAgregarCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(tbMiembros, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btAgregarMiembro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnActualizarusuarios, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(BtnLimpiarUsuarios, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminarUsuarios, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(26, 26, 26))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(btnRegresarUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel15)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbAvisoNombre))
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtCedulA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbAvisoCedula)
                                .addComponent(jLabel24)))))
                .addGap(10, 10, 10)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel28)
                        .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbAvisoCorreo)
                        .addComponent(lbAvisoFecha))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel25)
                        .addComponent(dcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27)
                    .addComponent(cbTipoPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbAvisoCargo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCargo)
                    .addComponent(cbCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAgregarCargo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(0, 10, Short.MAX_VALUE)
                        .addComponent(btnActualizarusuarios)
                        .addGap(18, 18, 18)
                        .addComponent(btAgregarMiembro, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BtnLimpiarUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminarUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tbMiembros, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );

        jLabel21.setBackground(new java.awt.Color(51, 51, 0));
        jLabel21.setFont(new java.awt.Font("Rockwell", 0, 36)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 255, 204));
        jLabel21.setText("REGISTRO");

        javax.swing.GroupLayout panelMiembrosLayout = new javax.swing.GroupLayout(panelMiembros);
        panelMiembros.setLayout(panelMiembrosLayout);
        panelMiembrosLayout.setHorizontalGroup(
            panelMiembrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMiembrosLayout.createSequentialGroup()
                .addGap(311, 311, 311)
                .addComponent(jLabel21)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelMiembrosLayout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 24, Short.MAX_VALUE))
        );
        panelMiembrosLayout.setVerticalGroup(
            panelMiembrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMiembrosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        tbPaneles.addTab("tab2", panelMiembros);

        javax.swing.GroupLayout panelPestañasLayout = new javax.swing.GroupLayout(panelPestañas);
        panelPestañas.setLayout(panelPestañasLayout);
        panelPestañasLayout.setHorizontalGroup(
            panelPestañasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tbPaneles, javax.swing.GroupLayout.PREFERRED_SIZE, 896, Short.MAX_VALUE)
        );
        panelPestañasLayout.setVerticalGroup(
            panelPestañasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPestañasLayout.createSequentialGroup()
                .addComponent(tbPaneles, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(panelPestañas, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 840, 520));

        panelSuperior.setBackground(new java.awt.Color(102, 255, 204));
        panelSuperior.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BotonOpciones.setBackground(new java.awt.Color(102, 255, 204));
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
        BotonOpciones.setBackground(new Color(102, 255, 204));
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

    private void cbTipoPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoPersonaActionPerformed
        String cargo = (String) cbTipoPersona.getSelectedItem();
        if (cargo.equals("Seleccione un cargo")) {
            CargoIngreso = "";
            lbAvisoCargo.setVisible(true);
        } else if (cargo.equals("Administrador")) {
            CargoIngreso = "Administrador";
            lbAvisoCargo.setVisible(false);
        } else if (cargo.equals("Trabajador")) {
            CargoIngreso = "Trabajador";
            lbAvisoCargo.setVisible(false);
        } else if (cargo.equals("Cliente")) {
            CargoIngreso = "Cliente";
            lbAvisoCargo.setVisible(false);
        }

    }//GEN-LAST:event_cbTipoPersonaActionPerformed

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

    private void cbTipoPersonaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cbTipoPersonaPropertyChange
        if ("Seleccione un cargo".equals(cbTipoPersona.getSelectedItem().toString())) {
            lbAvisoCargo.setVisible(true);
        } else {
            lbAvisoCargo.setVisible(false);
        }
    }//GEN-LAST:event_cbTipoPersonaPropertyChange

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCargoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCargoActionPerformed

    private void cbCargoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cbCargoPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCargoPropertyChange

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void btnAbrirProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirProyectoActionPerformed
        tbPanelesProyectos.setSelectedIndex(1);
    }//GEN-LAST:event_btnAbrirProyectoActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        tbPanelesProyectos.setSelectedIndex(0);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btAgregarCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregarCargoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btAgregarCargoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BotonAgregarMiembros;
    private javax.swing.JPanel BotonOpciones;
    private javax.swing.JPanel BotonProyectos;
    private javax.swing.JButton BtnLimpiarUsuarios;
    private javax.swing.JPanel PanelActualizarProyecto;
    private javax.swing.JPanel PanelBiosigmaLogo;
    private javax.swing.JButton btAgregarCargo;
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
    private javax.swing.JComboBox<String> cbTipoPersona;
    private com.toedter.calendar.JDateChooser dcFecha;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLImgUsuarios;
    private javax.swing.JLabel jLUsuarios;
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
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JLabel lbAvisoCargo;
    private javax.swing.JLabel lbAvisoCedula;
    private javax.swing.JLabel lbAvisoCorreo;
    private javax.swing.JLabel lbAvisoFecha;
    private javax.swing.JLabel lbAvisoNombre;
    private javax.swing.JLabel lbCargo;
    private javax.swing.JPanel panelAbrirProyecto;
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
