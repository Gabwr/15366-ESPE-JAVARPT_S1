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

public class InterfazAdminActualizarUsuario extends javax.swing.JInternalFrame {

    String CargoIngreso;
    private int contador = 1;
    private String cedulapersona=null;
    
    public InterfazAdminActualizarUsuario() {
        initComponents();
        cbCargo.setVisible(false);
        lbAvisoCargo.setVisible(false);
        btAgregarCargo.setVisible(false);
        cargarComboCargo();
        cargarComboPerfil();
        InterfazAdminJFrame interfaz_Admin = new InterfazAdminJFrame();
        cedulapersona= interfaz_Admin.codigoUsuario;
        
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
    
    public void cargarPersona(){
        Personas persona = ServicioPersonas.BuscarPorCodigoClienteyAdmin(cedulapersona);
        txtCedulA.setText(persona.getCedula());
        txtCorreo.setText(persona.getCorreo());
        calcularEdad(persona.getFechaNacimiento().getYear());
        txtNombre.setText(persona.getNombre());
        if(persona.getIdPerfil()==1){
            cbTipoPersona.setSelectedIndex(persona.getIdPerfil());
        }else if(persona.getIdPerfil()==2){
            cbTipoPersona.setSelectedIndex(persona.getIdPerfil());
            cbCargo.setSelectedIndex(persona.getCargo());
        }else{
            cbTipoPersona.setSelectedIndex(persona.getIdPerfil());
        }
        dcFecha.setDate(persona.getFechaNacimiento());
    }
    private void limpiar() {
        txtCedulA.setText("");
        txtCorreo.setText("");
        txtEdad.setText("");
        txtNombre.setText("");
        cbTipoPersona.setSelectedIndex(0);
        dcFecha.setDate(null);
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
        jButton1 = new javax.swing.JButton();

        JPInsertar.setBackground(new java.awt.Color(102, 102, 255));
        JPInsertar.setForeground(new java.awt.Color(153, 153, 255));

        btAgregarMiembro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/1814113_add_more_plus_icon.png"))); // NOI18N
        btAgregarMiembro.setText("Agregar");
        btAgregarMiembro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgregarMiembroActionPerformed(evt);
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

        jLabel21.setBackground(new java.awt.Color(255, 255, 102));
        jLabel21.setFont(new java.awt.Font("Rockwell", 0, 36)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 102));
        jLabel21.setText("Actualizar Usuario");

        BtnLimpiarUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/limpiar.png"))); // NOI18N
        BtnLimpiarUsuarios.setText("Limpiar datos");
        BtnLimpiarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLimpiarUsuariosActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/restablecer-la-contrasena.png"))); // NOI18N
        jButton1.setText("Cambiar Contraseña");

        javax.swing.GroupLayout JPInsertarLayout = new javax.swing.GroupLayout(JPInsertar);
        JPInsertar.setLayout(JPInsertarLayout);
        JPInsertarLayout.setHorizontalGroup(
            JPInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPInsertarLayout.createSequentialGroup()
                .addGroup(JPInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPInsertarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(JPInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(JPInsertarLayout.createSequentialGroup()
                                .addGroup(JPInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(JPInsertarLayout.createSequentialGroup()
                                        .addGroup(JPInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, JPInsertarLayout.createSequentialGroup()
                                                .addComponent(jLabel25)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(dcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, JPInsertarLayout.createSequentialGroup()
                                                .addComponent(jLabel15)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(JPInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbAvisoFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbAvisoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(53, 53, 53))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPInsertarLayout.createSequentialGroup()
                                        .addGap(86, 86, 86)
                                        .addComponent(jLabel26)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(61, 61, 61)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                                .addGroup(JPInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPInsertarLayout.createSequentialGroup()
                                        .addComponent(jLabel28)
                                        .addGap(6, 6, 6))))
                            .addGroup(JPInsertarLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(JPInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(JPInsertarLayout.createSequentialGroup()
                                        .addComponent(btAgregarCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(24, 24, 24)
                                        .addComponent(lbCargo))
                                    .addComponent(jLabel24)))))
                    .addGroup(JPInsertarLayout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(btAgregarMiembro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnLimpiarUsuarios)))
                .addGroup(JPInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPInsertarLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(JPInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JPInsertarLayout.createSequentialGroup()
                                .addGroup(JPInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCedulA, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbTipoPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addGroup(JPInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbAvisoCargo)
                                    .addComponent(lbAvisoCorreo)
                                    .addComponent(lbAvisoCedula)))
                            .addComponent(cbCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(JPInsertarLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jButton1)))
                .addContainerGap(23, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPInsertarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel21)
                .addGap(192, 192, 192))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPInsertarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegresarUsuarios)
                .addContainerGap())
        );
        JPInsertarLayout.setVerticalGroup(
            JPInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPInsertarLayout.createSequentialGroup()
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(JPInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(lbAvisoNombre)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JPInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCedulA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbAvisoCedula)
                        .addComponent(jLabel24)))
                .addGap(27, 27, 27)
                .addGroup(JPInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(JPInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel28)
                        .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbAvisoCorreo)
                        .addComponent(lbAvisoFecha))
                    .addGroup(JPInsertarLayout.createSequentialGroup()
                        .addGroup(JPInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25))
                        .addGap(6, 6, 6)))
                .addGap(42, 42, 42)
                .addGroup(JPInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27)
                    .addComponent(cbTipoPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbAvisoCargo))
                .addGap(36, 36, 36)
                .addGroup(JPInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbCargo)
                    .addComponent(btAgregarCargo))
                .addGap(41, 41, 41)
                .addGroup(JPInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAgregarMiembro, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnLimpiarUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(10, 10, 10)
                .addComponent(btnRegresarUsuarios)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JPInsertar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JPInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAgregarMiembroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregarMiembroActionPerformed

        String nombre = txtNombre.getText();
        String cedula = txtCedulA.getText();
        String correo = txtCorreo.getText();
        String edad = txtEdad.getText();

        if (validarDatos() && validarCedula()) {
            if (CargoIngreso.equals("Administrador")) {
                JOptionPane.showMessageDialog(null, "Usuario guardado correctamente.");
            } else if (CargoIngreso.equals("Trabajador")) {
                JOptionPane.showMessageDialog(null, "Usuario guardado correctamente.");
            } else if (CargoIngreso.equals("Cliente")) {
                JOptionPane.showMessageDialog(null, "Usuario guardado correctamente.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese los datos correctamente");
        }
    }//GEN-LAST:event_btAgregarMiembroActionPerformed

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
        this.setVisible(false);
    }//GEN-LAST:event_btnRegresarUsuariosActionPerformed

    private void cbTipoPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoPersonaActionPerformed
        String cargo = (String) cbTipoPersona.getSelectedItem();
        if (cargo.equals("Seleccione un cargo")) {
            CargoIngreso = "";
            cbCargo.setVisible(false);
            lbAvisoCargo.setVisible(false);
            btAgregarCargo.setVisible(false);
        } else if (cargo.equals("Administrador")) {
            CargoIngreso = "Administrador";
            cbCargo.setVisible(false);
            lbAvisoCargo.setVisible(false);
            btAgregarCargo.setVisible(false);
        } else if (cargo.equals("Trabajador")) {
            CargoIngreso = "Trabajador";
            cbCargo.setVisible(true);
            lbAvisoCargo.setVisible(true);
            btAgregarCargo.setVisible(true);
        } else if (cargo.equals("Cliente")) {
            CargoIngreso = "Cliente";
            cbCargo.setVisible(false);
            lbAvisoCargo.setVisible(false);
            btAgregarCargo.setVisible(false);
        }
    }//GEN-LAST:event_cbTipoPersonaActionPerformed

    private void cbTipoPersonaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cbTipoPersonaPropertyChange
        if ("Seleccione un cargo".equals(cbTipoPersona.getSelectedItem().toString())) {
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

    private void cbCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCargoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCargoActionPerformed

    private void cbCargoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cbCargoPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCargoPropertyChange

    private void btAgregarCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregarCargoActionPerformed

    }//GEN-LAST:event_btAgregarCargoActionPerformed

    private void BtnLimpiarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLimpiarUsuariosActionPerformed
        // TODO add your handling code here:
        limpiar();
    }//GEN-LAST:event_BtnLimpiarUsuariosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnLimpiarUsuarios;
    private javax.swing.JPanel JPInsertar;
    private javax.swing.JButton btAgregarCargo;
    private javax.swing.JButton btAgregarMiembro;
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
    private javax.swing.JLabel lbAvisoCargo;
    private javax.swing.JLabel lbAvisoCedula;
    private javax.swing.JLabel lbAvisoCorreo;
    private javax.swing.JLabel lbAvisoFecha;
    private javax.swing.JLabel lbAvisoNombre;
    private javax.swing.JLabel lbCargo;
    private javax.swing.JTextField txtCedulA;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
