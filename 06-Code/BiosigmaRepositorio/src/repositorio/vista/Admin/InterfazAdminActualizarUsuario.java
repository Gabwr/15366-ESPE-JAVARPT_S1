package repositorio.vista.admin;

import com.toedter.calendar.JTextFieldDateEditor;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
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
import repositorio.vista.admin.InterfazCambiarContrasenia;
import repositorio.vista.cargo.ConsultarCargo;

public class InterfazAdminActualizarUsuario extends javax.swing.JInternalFrame {

    private Perfil perfilIngreso;
    String CargoIngreso;
    private int contador = 1;
    String cedulapersona = null;
    public static String cedulaContrasenia = null;
    private Calendar hoy = null;
    
    public InterfazAdminActualizarUsuario() {
        initComponents();
        restringirJcalendar();
        cbCargo.setVisible(false);
        btAgregarCargo.setVisible(false);
        lbCargo.setVisible(false);
        lbAvisoCargo.setVisible(false);
        lbAvisoCedula.setVisible(false);
        lbAvisoCorreo.setVisible(false);
        lbAvisoFecha.setVisible(false);
        lbAvisoNombre.setVisible(false);
        lbAvisoTipoUsuario.setVisible(false);
        cedulapersona = InterfazAdminJFrame.codigoUsuario;
        cargarPersona();
    }
    
        public void restringirJcalendar() {
        hoy = Calendar.getInstance();
        hoy.add(Calendar.YEAR, -18);
        Date restriccion = hoy.getTime();
        dcFecha.setMaxSelectableDate(restriccion);
        JTextFieldDateEditor editor = (JTextFieldDateEditor) dcFecha.getDateEditor();
        editor.setEditable(false);
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


    private boolean validarDatosOtros() {
        boolean validacion = false;
        if ((txtNombre.getText().length() > 0) && validarCedula() && (dcFecha.getDate() != null)
                && validarCorreo(txtCorreo.getText())) {
            validacion = true;
            return validacion;
        } else {
            return validacion;
        }

    }

    public static void cargarComboPerfil(int idPerfil) {
        List<Perfil> listaPerfiles = new PerfilServicio().ListarPerfiles();
        for (Perfil temp : listaPerfiles) {
                cbTipoPersona.addItem(temp.getId() + " - " + temp.getNombrePerfil());
            
        }
    }

    public boolean comprobarExistencia(String cedula) {
        boolean comprobar = false;
        List<Personas> listaComprobar = ServicioPersonas.ListarPersonas();
        for (Personas comprobador : listaComprobar) {
            if (cedula.equals(comprobador.getCedula())) {
                comprobar = true;
            }

        }
        return comprobar;
    }

    public static void cargarComboCargo(int idCargo) {
        List<Cargo> listaCargos = new CargoServicio().ListarCargos();
        
        for (Cargo temp : listaCargos) {
            if (temp.getIdCargo() != idCargo) {
                cbCargo.addItem(temp.getIdCargo() + " - " + temp.getCargo());
            }
        }
    }

    public void cargarPersona() {
        Personas persona = ServicioPersonas.BuscarPorCodigoClienteyAdmin(cedulapersona);
        txtCedulA.setText(persona.getCedula());
        txtCorreo.setText(persona.getCorreo());
        calcularEdad(persona.getFechaNacimiento().getYear());
        txtNombre.setText(persona.getNombre());
        Perfil perfil = PerfilServicio.BuscarPerfil(persona.getIdPerfil());
        
        cargarComboPerfil(persona.getIdPerfil());
        dcFecha.setDate(persona.getFechaNacimiento());
        cbTipoPersona.setSelectedItem(persona.getIdPerfil()+" - "+perfil.getNombrePerfil());
        if (persona.getIdPerfil() != 2) {
            cargarComboCargo(-1);
        } else {
            Cargo cargo = CargoServicio.BuscarCargo(persona.getCargo());
            cbCargo.addItem(cargo.getIdCargo() + " - " + cargo.getCargo());
            cargarComboCargo(persona.getCargo());
        }
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
            int cedulaStringDivisor = cedulaString, cont = 0, iniciador = 0, residuo,
                    cosciente, mul = 0, sumpar = 0, sumimpar = 0, sumtotal = 0, res = 0, comprobador = 0;

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

        Dp_Contrasenia = new javax.swing.JDesktopPane();
        JPInsertar = new javax.swing.JPanel();
        btActualizarMiembro = new javax.swing.JButton();
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
        lbAvisoTipoUsuario = new javax.swing.JLabel();
        lbCargo = new javax.swing.JLabel();
        cbCargo = new javax.swing.JComboBox<>();
        btAgregarCargo = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbAvisoCargo = new javax.swing.JLabel();

        JPInsertar.setBackground(new java.awt.Color(102, 102, 255));
        JPInsertar.setForeground(new java.awt.Color(153, 153, 255));
        JPInsertar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btActualizarMiembro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/1814113_add_more_plus_icon.png"))); // NOI18N
        btActualizarMiembro.setText("Actualizar");
        btActualizarMiembro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btActualizarMiembroActionPerformed(evt);
            }
        });
        JPInsertar.add(btActualizarMiembro, new org.netbeans.lib.awtextra.AbsoluteConstraints(177, 339, -1, 43));

        txtEdad.setEditable(false);
        JPInsertar.add(txtEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 77, -1));

        dcFecha.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dcFechaPropertyChange(evt);
            }
        });
        JPInsertar.add(dcFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 143, 106, -1));

        txtCedulA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCedulAKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedulAKeyTyped(evt);
            }
        });
        JPInsertar.add(txtCedulA, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 80, 165, -1));

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });
        JPInsertar.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 84, 118, -1));

        jLabel15.setText("Nombre Completo");
        JPInsertar.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 87, -1, -1));

        jLabel24.setText("N° Cédula");
        JPInsertar.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 90, -1, -1));

        jLabel25.setText("Fecha de Nacimiento");
        JPInsertar.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 143, -1, -1));

        jLabel26.setText("Edad");
        JPInsertar.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 210, -1, -1));

        btnRegresarUsuarios.setText("Regresar");
        btnRegresarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarUsuariosActionPerformed(evt);
            }
        });
        JPInsertar.add(btnRegresarUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 20, -1, -1));

        jLabel27.setText("Tipo de Usuario");
        JPInsertar.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(321, 210, -1, -1));

        cbTipoPersona.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un Usuario" }));
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
        JPInsertar.add(cbTipoPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(415, 207, 165, -1));

        txtCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCorreoKeyReleased(evt);
            }
        });
        JPInsertar.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 140, 165, -1));

        jLabel28.setText("Correo");
        JPInsertar.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 140, -1, -1));

        lbAvisoCorreo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbAvisoCorreo.setForeground(new java.awt.Color(255, 0, 0));
        lbAvisoCorreo.setText("*Correo Inválido");
        JPInsertar.add(lbAvisoCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 140, -1, -1));

        lbAvisoNombre.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbAvisoNombre.setForeground(new java.awt.Color(255, 0, 0));
        lbAvisoNombre.setText("*");
        JPInsertar.add(lbAvisoNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(236, 74, 12, -1));

        lbAvisoCedula.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbAvisoCedula.setForeground(new java.awt.Color(255, 0, 0));
        lbAvisoCedula.setText("*");
        JPInsertar.add(lbAvisoCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 70, -1, -1));

        lbAvisoFecha.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbAvisoFecha.setForeground(new java.awt.Color(255, 0, 0));
        lbAvisoFecha.setText("*");
        JPInsertar.add(lbAvisoFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(236, 133, -1, -1));

        lbAvisoTipoUsuario.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbAvisoTipoUsuario.setForeground(new java.awt.Color(255, 0, 0));
        lbAvisoTipoUsuario.setText("*");
        JPInsertar.add(lbAvisoTipoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 200, -1, -1));

        lbCargo.setText("Cargo:");
        JPInsertar.add(lbCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(357, 263, -1, -1));

        cbCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un Cargo" }));
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
        JPInsertar.add(cbCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(415, 260, 165, -1));

        btAgregarCargo.setText("Agregar Cargo");
        btAgregarCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgregarCargoActionPerformed(evt);
            }
        });
        JPInsertar.add(btAgregarCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 275, 121, -1));

        jLabel21.setBackground(new java.awt.Color(255, 255, 102));
        jLabel21.setFont(new java.awt.Font("Rockwell", 0, 36)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 102));
        jLabel21.setText("Actualizar Usuario");
        JPInsertar.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(222, 0, -1, 40));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/restablecer-la-contrasena.png"))); // NOI18N
        jButton1.setText("Cambiar Contraseña");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        JPInsertar.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(412, 341, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/LogoBiosigmaTransparente.png"))); // NOI18N
        JPInsertar.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 50));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/FondoProyectos.png"))); // NOI18N
        JPInsertar.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 50));

        lbAvisoCargo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbAvisoCargo.setForeground(new java.awt.Color(255, 0, 0));
        lbAvisoCargo.setText("*");
        JPInsertar.add(lbAvisoCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 260, -1, -1));

        Dp_Contrasenia.setLayer(JPInsertar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout Dp_ContraseniaLayout = new javax.swing.GroupLayout(Dp_Contrasenia);
        Dp_Contrasenia.setLayout(Dp_ContraseniaLayout);
        Dp_ContraseniaLayout.setHorizontalGroup(
            Dp_ContraseniaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 779, Short.MAX_VALUE)
            .addGroup(Dp_ContraseniaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(JPInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 779, Short.MAX_VALUE))
        );
        Dp_ContraseniaLayout.setVerticalGroup(
            Dp_ContraseniaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 412, Short.MAX_VALUE)
            .addGroup(Dp_ContraseniaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(JPInsertar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Dp_Contrasenia)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addComponent(Dp_Contrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btActualizarMiembroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btActualizarMiembroActionPerformed
        String nombre = txtNombre.getText();
        String cedula = txtCedulA.getText();
        String correo = txtCorreo.getText();
        String usuario = algoritmousuario(nombre, cedula);
        String dato = cbTipoPersona.getSelectedItem().toString();
        String perfil[] = dato.split("-");
        int idPerfil = Integer.parseInt(perfil[0].trim());
        Date fechaNacimiento = dcFecha.getDate();
        perfilIngreso = PerfilServicio.BuscarPerfil(idPerfil);

        if (validarDatosOtros() && validarCedula() && (perfilIngreso.getId() == 1) && 
                comprobarExistencia(cedula)) {

            Personas AdminNuevo = new Personas(perfilIngreso.getId(), usuario, cedula, 
                    correo, nombre, fechaNacimiento);

            if (ServicioPersonas.ActualizarPersonasClientesAdmin(AdminNuevo)) {
                JOptionPane.showMessageDialog(null, "Datos Ingresados");
                InterfazAdminJFrame.llenarPersonas();
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Datos no Ingresados");
            }

        } else if (validarDatosTrabajador() && validarCedula() && (perfilIngreso.getId() == 2)) {

            dato = cbCargo.getSelectedItem().toString();
            String cargo[] = dato.split("-");
            int idCargo = Integer.parseInt(cargo[0].trim());
            Cargo cargoIngreso = CargoServicio.BuscarCargo(idCargo);

            Personas TrabajadorNuevo = new Personas(perfilIngreso.getId(), usuario, cedula, 
                    correo, nombre, fechaNacimiento, cargoIngreso.getIdCargo());
            if (ServicioPersonas.ActualizarPersonasTrabajador(TrabajadorNuevo)) {
                JOptionPane.showMessageDialog(null, "Datos Ingresados");
                InterfazAdminJFrame.llenarPersonas();
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Datos no Ingresados");
            }

        } else if (validarDatosOtros() && validarCedula() && (perfilIngreso.getId() != 1) 
                && (perfilIngreso.getId() != 2)) {
            Personas ClienteNuevo = new Personas(perfilIngreso.getId(), usuario, cedula,
                    correo, nombre, fechaNacimiento);

            if (ServicioPersonas.ActualizarPersonasClientesAdmin(ClienteNuevo)) {
                JOptionPane.showMessageDialog(null, "Datos Ingresados");
                InterfazAdminJFrame.llenarPersonas();
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Datos no Ingresados");
            }
            limpiar();
        } else {
            JOptionPane.showMessageDialog(null, "complete los campos");
        }
    }//GEN-LAST:event_btActualizarMiembroActionPerformed

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
        String perfil[] = null;
        int idPerfil = 0;
        if (cbTipoPersona.getSelectedIndex() == 0) {
            lbCargo.setVisible(false);
            cbCargo.setVisible(false);
            btAgregarCargo.setVisible(false);
            lbAvisoTipoUsuario.setVisible(true);
        } else{
            perfil = dato.split("-");
            idPerfil = Integer.parseInt(perfil[0].trim());
            perfilIngreso = PerfilServicio.BuscarPerfil(idPerfil);
            if (perfilIngreso.getId() == 2) {
            lbAvisoTipoUsuario.setVisible(false);
            lbCargo.setVisible(true);
            cbCargo.setVisible(true);
            lbAvisoCargo.setVisible(true);
            btAgregarCargo.setVisible(true);
        } else {
            lbAvisoTipoUsuario.setVisible(false);
            lbCargo.setVisible(false);
            cbCargo.setVisible(false);
            lbAvisoCargo.setVisible(false);
            btAgregarCargo.setVisible(false);
        }
        }
    }//GEN-LAST:event_cbTipoPersonaActionPerformed

    private void cbTipoPersonaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cbTipoPersonaPropertyChange
        if ("Seleccione un cargo".equals(cbTipoPersona.getSelectedItem().toString())) {
            lbAvisoTipoUsuario.setVisible(true);
        } else {
            lbAvisoTipoUsuario.setVisible(false);
        }
    }//GEN-LAST:event_cbTipoPersonaPropertyChange

    private void txtCorreoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorreoKeyReleased
        if (validarCorreo(txtCorreo.getText())) {
            lbAvisoCorreo.setVisible(false);
        } else {
            lbAvisoCorreo.setVisible(true);
        }
    }//GEN-LAST:event_txtCorreoKeyReleased

    private void cbCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCargoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCargoActionPerformed

    private void cbCargoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cbCargoPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCargoPropertyChange

    private void btAgregarCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregarCargoActionPerformed
        ConsultarCargo cargo = new ConsultarCargo();
        cargo.setVisible(true);
    }//GEN-LAST:event_btAgregarCargoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        cedulaContrasenia = txtCedulA.getText();
        InterfazCambiarContrasenia contrasenia = new InterfazCambiarContrasenia();
        Dp_Contrasenia.add(contrasenia);
        contrasenia.show();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane Dp_Contrasenia;
    private javax.swing.JPanel JPInsertar;
    private javax.swing.JButton btActualizarMiembro;
    private javax.swing.JButton btAgregarCargo;
    private javax.swing.JButton btnRegresarUsuarios;
    private static javax.swing.JComboBox<String> cbCargo;
    private static javax.swing.JComboBox<String> cbTipoPersona;
    private com.toedter.calendar.JDateChooser dcFecha;
    private javax.swing.JButton jButton1;
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
    private javax.swing.JLabel lbAvisoCorreo;
    private javax.swing.JLabel lbAvisoFecha;
    private javax.swing.JLabel lbAvisoNombre;
    private javax.swing.JLabel lbAvisoTipoUsuario;
    private javax.swing.JLabel lbCargo;
    private javax.swing.JTextField txtCedulA;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
