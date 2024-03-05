package repositorio.vista.admin;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import repositorio.controlador.CargoServicio;
import repositorio.controlador.PerfilServicio;
import repositorio.controlador.ServicioPersonas;
import repositorio.modelo.Cargo;
import repositorio.modelo.Perfil;
import repositorio.modelo.Personas;

public class InterfazAdminInsertarUsuario extends javax.swing.JInternalFrame {

    private Perfil perfilIngreso;

    public InterfazAdminInsertarUsuario() {
        initComponents();
        cargarComboPerfil();
        cargarComboCargo();
        lbCargo.setVisible(false);
        cbCargo.setVisible(false);
        lbAvisoCargo.setVisible(false);
        btAgregarCargo.setVisible(false);
    }

    public boolean comprobarExistencia(String cedula) {
        boolean comprobar = true;
        List<Personas> listaComprobar = ServicioPersonas.ListarPersonas();
        for (Personas comprobador : listaComprobar) {
            if (cedula.equals(comprobador.getCedula())) {
                comprobar = false;
            }
        }
        if(comprobar==false){
            JOptionPane.showMessageDialog(null, "Cedula existente");
        }
        return comprobar;
    }

    public static void cargarComboPerfil() {
        List<Perfil> listaPerfiles = new PerfilServicio().ListarPerfiles();
        for (Perfil temp : listaPerfiles) {
            cbTipoPersona.addItem(temp.getId() + " - " + temp.getNombrePerfil());
        }
    }

    public static void cargarComboCargo() {
        List<Cargo> listaCargos = new CargoServicio().ListarCargos();
        for (Cargo temp : listaCargos) {
            cbCargo.addItem(temp.getIdCargo() + " - " + temp.getCargo());
        }
    }

    private boolean validarDatosTrabajador() {
        boolean validacion = false;
        if ((txtNombre.getText().length() > 0) && validarCedula()
                && (dcFecha.getDate() != null) && validarCorreo(txtCorreo.getText())
                && (!"-- Seleccione una opción --".equals(cbTipoPersona.getSelectedItem().toString()))) {
            validacion = true;
            return validacion;
        } else {
            return validacion;
        }
    }

    public String algoritmousuario(String nombre, String Cedula) {
        String usuario = "";
        char pasador;
        for (int inicio = 0; inicio < 3; inicio++) {
            pasador = nombre.trim().charAt(inicio);
            usuario += pasador;
        }
        for (int inicio = 0; inicio < 3; inicio++) {
            pasador = Cedula.trim().charAt(inicio);
            usuario += pasador;
        }
        return usuario;
    }

    private boolean validarDatosOtros() {
        boolean validacion = false;
        if ((txtNombre.getText().length() > 0) && validarCedula() && (dcFecha.getDate() != null) && validarCorreo(txtCorreo.getText())) {
            validacion = true;
            return validacion;
        } else {
            return validacion;
        }

    }

    private boolean validarcontrasenia() {
        boolean validacion = false;
        String contrasenia = pswfContrasenia.getText();
        if (contrasenia.isEmpty() || contrasenia.length() < 5) {
            validacion = false;
        } else {
            validacion = true;
        }
        return validacion;
    }

    private void limpiar() {
        txtCedulA.setText("");
        txtCorreo.setText("");
        txtEdad.setText("");
        txtNombre.setText("");
        cbTipoPersona.setSelectedIndex(0);
        dcFecha.setDate(null);
        lbCargo.setVisible(false);
        cbCargo.setVisible(false);
        lbAvisoCargo.setVisible(false);
        btAgregarCargo.setVisible(false);
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
        txtEdad.setText(edadCalculada);
    }

    private boolean validarCorreo(String correo) {
        Pattern patron = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mat = patron.matcher(correo);
        return mat.find();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPInsertar = new javax.swing.JPanel();
        btAgregarMiembro = new javax.swing.JButton();
        txtEdad = new javax.swing.JTextField();
        dcFecha = new com.toedter.calendar.JDateChooser();
        txtCedulA = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        btnRegresarUsuarios = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        cbTipoPersona = new javax.swing.JComboBox<>();
        txtCorreo = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        lbAvisoCorreo = new javax.swing.JLabel();
        lbAvisoNombre = new javax.swing.JLabel();
        lbAvisoCedula = new javax.swing.JLabel();
        lbAvisoFecha = new javax.swing.JLabel();
        lbAvisoCargo = new javax.swing.JLabel();
        lbCargo = new javax.swing.JLabel();
        cbCargo = new javax.swing.JComboBox<>();
        btAgregarCargo = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        BtnLimpiarUsuarios = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        pswfContrasenia = new javax.swing.JPasswordField();
        lbAvisoContrasenia = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        JPInsertar.setBackground(new java.awt.Color(206, 206, 232));
        JPInsertar.setForeground(new java.awt.Color(153, 153, 255));
        JPInsertar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btAgregarMiembro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/1814113_add_more_plus_icon.png"))); // NOI18N
        btAgregarMiembro.setText("Agregar");
        btAgregarMiembro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgregarMiembroActionPerformed(evt);
            }
        });
        JPInsertar.add(btAgregarMiembro, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 370, -1, 50));

        txtEdad.setEditable(false);
        txtEdad.setBackground(new java.awt.Color(255, 204, 204));
        txtEdad.setForeground(new java.awt.Color(0, 51, 51));
        JPInsertar.add(txtEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 90, -1));

        dcFecha.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dcFechaPropertyChange(evt);
            }
        });
        JPInsertar.add(dcFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 124, 140, -1));

        txtCedulA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCedulAKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedulAKeyTyped(evt);
            }
        });
        JPInsertar.add(txtCedulA, new org.netbeans.lib.awtextra.AbsoluteConstraints(471, 84, 165, -1));

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });
        JPInsertar.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 140, -1));

        jLabel15.setForeground(new java.awt.Color(0, 51, 51));
        jLabel15.setText("Nombre Completo");
        JPInsertar.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        jLabel24.setForeground(new java.awt.Color(0, 51, 51));
        jLabel24.setText("N° Cédula");
        JPInsertar.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(391, 87, -1, -1));

        jLabel25.setForeground(new java.awt.Color(0, 51, 51));
        jLabel25.setText("Fecha de Nacimiento");
        JPInsertar.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        jLabel26.setForeground(new java.awt.Color(0, 51, 51));
        jLabel26.setText("Edad");
        JPInsertar.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, -1, -1));

        btnRegresarUsuarios.setText("Regresar");
        btnRegresarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarUsuariosActionPerformed(evt);
            }
        });
        JPInsertar.add(btnRegresarUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 10, -1, -1));

        jLabel27.setForeground(new java.awt.Color(0, 51, 51));
        jLabel27.setText("Tipo de Usuario");
        JPInsertar.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(383, 207, -1, -1));

        cbTipoPersona.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccione una opción --" }));
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
        JPInsertar.add(cbTipoPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(471, 204, 165, -1));

        txtCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCorreoKeyReleased(evt);
            }
        });
        JPInsertar.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(471, 134, 165, -1));

        jLabel28.setForeground(new java.awt.Color(0, 51, 51));
        jLabel28.setText("Correo");
        JPInsertar.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 140, -1, -1));

        lbAvisoCorreo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbAvisoCorreo.setForeground(new java.awt.Color(255, 0, 0));
        lbAvisoCorreo.setText("*Correo Inválido");
        JPInsertar.add(lbAvisoCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(642, 134, -1, -1));

        lbAvisoNombre.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbAvisoNombre.setForeground(new java.awt.Color(255, 0, 0));
        lbAvisoNombre.setText("*");
        JPInsertar.add(lbAvisoNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, -1, -1));

        lbAvisoCedula.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbAvisoCedula.setForeground(new java.awt.Color(255, 0, 0));
        lbAvisoCedula.setText("*");
        JPInsertar.add(lbAvisoCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(642, 74, -1, -1));

        lbAvisoFecha.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbAvisoFecha.setForeground(new java.awt.Color(255, 0, 0));
        lbAvisoFecha.setText("*");
        JPInsertar.add(lbAvisoFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, -1, -1));

        lbAvisoCargo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbAvisoCargo.setForeground(new java.awt.Color(255, 0, 0));
        lbAvisoCargo.setText("*");
        JPInsertar.add(lbAvisoCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(642, 194, -1, -1));

        lbCargo.setForeground(new java.awt.Color(0, 51, 51));
        lbCargo.setText("Cargo:");
        JPInsertar.add(lbCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 260, -1, -1));

        cbCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccione una opción --" }));
        JPInsertar.add(cbCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 260, 165, -1));

        btAgregarCargo.setText("Agregar Cargo");
        btAgregarCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgregarCargoActionPerformed(evt);
            }
        });
        JPInsertar.add(btAgregarCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 260, 121, -1));

        jLabel21.setBackground(new java.awt.Color(51, 51, 0));
        jLabel21.setFont(new java.awt.Font("Sitka Banner", 1, 36)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 204, 204));
        jLabel21.setText("Insertar Usuario");
        JPInsertar.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, -1, 40));

        BtnLimpiarUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/limpiar.png"))); // NOI18N
        BtnLimpiarUsuarios.setText("Limpiar datos");
        BtnLimpiarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLimpiarUsuariosActionPerformed(evt);
            }
        });
        JPInsertar.add(BtnLimpiarUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 370, -1, 50));

        jLabel1.setForeground(new java.awt.Color(0, 51, 51));
        jLabel1.setText("Contraseña");
        JPInsertar.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 314, -1, -1));

        pswfContrasenia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pswfContraseniaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pswfContraseniaKeyReleased(evt);
            }
        });
        JPInsertar.add(pswfContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 311, 170, -1));

        lbAvisoContrasenia.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbAvisoContrasenia.setForeground(new java.awt.Color(255, 0, 0));
        lbAvisoContrasenia.setText("*");
        JPInsertar.add(lbAvisoContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(471, 301, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/LogoBiosigmaTransparente.png"))); // NOI18N
        JPInsertar.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/FondoProyectos.png"))); // NOI18N
        JPInsertar.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(JPInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPInsertar, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dcFechaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dcFechaPropertyChange
        if (dcFecha.getDate() != null) {
            int anioNacimiento = recuperarAnioNacimiento(dcFecha.getDate());
            lbAvisoFecha.setVisible(false);
            calcularEdad(anioNacimiento);
        }
    }//GEN-LAST:event_dcFechaPropertyChange

    private void txtCedulAKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulAKeyReleased
        if (!validarCedula()) {
            lbAvisoCedula.setVisible(true);
        } else {
            lbAvisoCedula.setVisible(false);
        }
    }//GEN-LAST:event_txtCedulAKeyReleased

    private void txtCedulAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulAKeyTyped
        char validacion = evt.getKeyChar();
        if (Character.isLetter(validacion)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingrese solo digitos");
        }
    }//GEN-LAST:event_txtCedulAKeyTyped

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
        if (txtNombre.getText().length() == 0) {
            lbAvisoNombre.setVisible(true);
        } else {
            lbAvisoNombre.setVisible(false);
        }
    }//GEN-LAST:event_txtNombreKeyReleased

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        char validacion = evt.getKeyChar();
        if (Character.isDigit(validacion)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Ingrese solo letras");
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void btnRegresarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarUsuariosActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnRegresarUsuariosActionPerformed

    private void cbTipoPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoPersonaActionPerformed
        String dato = cbTipoPersona.getSelectedItem().toString();
        String perfil[] = dato.split("-");
        int idPerfil = Integer.parseInt(perfil[0].trim());
        perfilIngreso = PerfilServicio.BuscarPerfil(idPerfil);

        if (perfilIngreso.getId() == 2) {
            lbCargo.setVisible(true);
            cbCargo.setVisible(true);
            lbAvisoCargo.setVisible(true);
            btAgregarCargo.setVisible(true);
        } else {
            lbCargo.setVisible(false);
            cbCargo.setVisible(false);
            lbAvisoCargo.setVisible(false);
            btAgregarCargo.setVisible(false);
        }
    }//GEN-LAST:event_cbTipoPersonaActionPerformed

    private void cbTipoPersonaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cbTipoPersonaPropertyChange
        if ("-- Seleccione una opción --".equals(cbTipoPersona.getSelectedItem().toString())) {
            lbAvisoCargo.setVisible(true);
        } else {
            lbAvisoCargo.setVisible(false);
        }
    }//GEN-LAST:event_cbTipoPersonaPropertyChange

    private void txtCorreoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorreoKeyReleased
        if (validarCorreo(txtCorreo.getText())) {
            lbAvisoCorreo.setVisible(false);
        } else {
            lbAvisoCorreo.setVisible(true);
        }
    }//GEN-LAST:event_txtCorreoKeyReleased

    private void btAgregarCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregarCargoActionPerformed

    }//GEN-LAST:event_btAgregarCargoActionPerformed

    private void btAgregarMiembroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregarMiembroActionPerformed

        String nombre = txtNombre.getText();
        String cedula = txtCedulA.getText();
        String correo = txtCorreo.getText();
        Date fechaNacimiento = dcFecha.getDate();
        String usuario = algoritmousuario(nombre, cedula);

        if (validarDatosOtros() && validarCedula() && (perfilIngreso.getId() == 1) && validarcontrasenia()&&comprobarExistencia(cedula)) {
            String contrasenia = ServicioPersonas.encriptar(pswfContrasenia.getText());
            Personas AdminNuevo = new Personas(perfilIngreso.getId(), usuario, contrasenia, cedula, correo, nombre, fechaNacimiento);

            if (ServicioPersonas.InsertarPersonasClienteyAdmin(AdminNuevo)) {
                JOptionPane.showMessageDialog(null, "Datos Ingresados");
                InterfazAdminJFrame.llenarPersonas();
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Datos no Ingresados");
            }

        } else if (validarDatosTrabajador() && validarCedula() && (perfilIngreso.getId() == 2) && validarcontrasenia()) {

            String dato = cbCargo.getSelectedItem().toString();
            String cargo[] = dato.split("-");
            int idCargo = Integer.parseInt(cargo[0].trim());
            Cargo cargoIngreso = CargoServicio.BuscarCargo(idCargo);

            String contrasenia = ServicioPersonas.encriptar(pswfContrasenia.getText());
            Personas TrabajadorNuevo = new Personas(perfilIngreso.getId(), usuario, contrasenia, cedula, correo, nombre, cargoIngreso.getIdCargo(), fechaNacimiento);
            if (ServicioPersonas.InsertarPersonasTrabajadores(TrabajadorNuevo)) {
                JOptionPane.showMessageDialog(null, "Datos Ingresados");
                InterfazAdminJFrame.llenarPersonas();
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Datos no Ingresados");
            }
        } else if (validarDatosOtros() && validarCedula() && (perfilIngreso.getId() != 1) && (perfilIngreso.getId() != 2) && validarcontrasenia()) {
            String contrasenia = ServicioPersonas.encriptar(pswfContrasenia.getText());
            Personas ClienteNuevo = new Personas(perfilIngreso.getId(), usuario, contrasenia, cedula, correo, nombre, fechaNacimiento);

            if (ServicioPersonas.InsertarPersonasClienteyAdmin(ClienteNuevo)) {
                JOptionPane.showMessageDialog(null, "Datos Ingresados");
                InterfazAdminJFrame.llenarPersonas();
                JOptionPane.showMessageDialog(null, "   Su usuario:"+usuario);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Datos no Ingresados");
            }
            limpiar();
        } else {
            JOptionPane.showMessageDialog(null, "complete los campos");
        }
    }//GEN-LAST:event_btAgregarMiembroActionPerformed

    private void BtnLimpiarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLimpiarUsuariosActionPerformed
        // TODO add your handling code here:
        limpiar();
    }//GEN-LAST:event_BtnLimpiarUsuariosActionPerformed

    private void pswfContraseniaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pswfContraseniaKeyPressed
        if (validarcontrasenia()) {
            lbAvisoContrasenia.setVisible(false);
        } else {
            lbAvisoContrasenia.setVisible(true);
        }

    }//GEN-LAST:event_pswfContraseniaKeyPressed

    private void pswfContraseniaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pswfContraseniaKeyReleased
        if (validarcontrasenia()) {
            lbAvisoContrasenia.setVisible(false);
        } else {
            lbAvisoContrasenia.setVisible(true);
        }
    }//GEN-LAST:event_pswfContraseniaKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnLimpiarUsuarios;
    private javax.swing.JPanel JPInsertar;
    private javax.swing.JButton btAgregarCargo;
    private javax.swing.JButton btAgregarMiembro;
    private javax.swing.JButton btnRegresarUsuarios;
    private static javax.swing.JComboBox<String> cbCargo;
    private static javax.swing.JComboBox<String> cbTipoPersona;
    private com.toedter.calendar.JDateChooser dcFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lbAvisoCargo;
    private javax.swing.JLabel lbAvisoCedula;
    private javax.swing.JLabel lbAvisoContrasenia;
    private javax.swing.JLabel lbAvisoCorreo;
    private javax.swing.JLabel lbAvisoFecha;
    private javax.swing.JLabel lbAvisoNombre;
    private javax.swing.JLabel lbCargo;
    private javax.swing.JPasswordField pswfContrasenia;
    private javax.swing.JTextField txtCedulA;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
