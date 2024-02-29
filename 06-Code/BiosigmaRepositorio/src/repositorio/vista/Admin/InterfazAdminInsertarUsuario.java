package repositorio.vista.Admin;

import com.mongodb.MongoException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import repositorio.controlador.ServicioPersonas;
import repositorio.modelo.Personas;

public class InterfazAdminInsertarUsuario extends javax.swing.JInternalFrame {

    String CargoIngreso;
    private int contador = 1;

    public InterfazAdminInsertarUsuario() {
        initComponents();
        lbCargo.setVisible(false);
        cbCargo.setVisible(false);
        lbAvisoCargo.setVisible(false);
        btAgregarCargo.setVisible(false);
    }

    private boolean validarDatosTrabajador() {
        boolean validacion = false;
        if ((txtNombre.getText().length() > 0) && validarCedula()
                && (dcFecha.getDate() != null) && validarCorreo(txtCorreo.getText())
                && (!"Seleccione un cargo".equals(cbTipoPersona.getSelectedItem().toString()))) {
            validacion = true;
            return validacion;
        } else {
            return validacion;
        }
    }

    public String algoritmousuario(String nombre, String Cedula) {
        String usuario = null;
        char pasador;
        for (int inicio = 0; inicio < 3; inicio++) {
            pasador = nombre.charAt(inicio);
            usuario += pasador;
        }
        for (int inicio = 3; inicio > 0; inicio--) {
            pasador = nombre.charAt(inicio);
            usuario += pasador;
        }
        return usuario;

    }

    private boolean validarDatosOtros() {
        boolean validacion = false;
        if ((txtNombre.getText().length() > 0) && validarCedula()
                && (dcFecha.getDate() != null) && validarCorreo(txtCorreo.getText())) {
            validacion = true;
            return validacion;
        } else {
            return validacion;
        }

    }

    private boolean validarcontrasenia() {
        boolean validacion = false;
        String contrasenia = pswfContrasenia.getText();
        if (contrasenia.isEmpty() && contrasenia.length() < 5) {
            validacion = true;
        } else {
            validacion = false;
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

        JPInsertar.setBackground(new java.awt.Color(255, 255, 204));
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

        jLabel21.setBackground(new java.awt.Color(51, 51, 0));
        jLabel21.setFont(new java.awt.Font("Rockwell", 0, 36)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 51, 204));
        jLabel21.setText("Insertar Usuario");

        BtnLimpiarUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/limpiar.png"))); // NOI18N
        BtnLimpiarUsuarios.setText("Limpiar datos");
        BtnLimpiarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLimpiarUsuariosActionPerformed(evt);
            }
        });

        jLabel1.setText("Contraseña");

        pswfContrasenia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pswfContraseniaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pswfContraseniaKeyReleased(evt);
            }
        });

        lbAvisoContrasenia.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbAvisoContrasenia.setForeground(new java.awt.Color(255, 0, 0));
        lbAvisoContrasenia.setText("*");

        javax.swing.GroupLayout JPInsertarLayout = new javax.swing.GroupLayout(JPInsertar);
        JPInsertar.setLayout(JPInsertarLayout);
        JPInsertarLayout.setHorizontalGroup(
            JPInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPInsertarLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(JPInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPInsertarLayout.createSequentialGroup()
                        .addGroup(JPInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JPInsertarLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(btAgregarCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(189, 189, 189)
                                .addComponent(lbCargo))
                            .addGroup(JPInsertarLayout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(JPInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel27)
                                    .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, JPInsertarLayout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addComponent(jLabel24))))
                            .addGroup(JPInsertarLayout.createSequentialGroup()
                                .addGroup(JPInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addGroup(JPInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, JPInsertarLayout.createSequentialGroup()
                                            .addComponent(jLabel15)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, JPInsertarLayout.createSequentialGroup()
                                            .addComponent(jLabel25)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(dcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(JPInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbAvisoFecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbAvisoNombre)
                                    .addComponent(pswfContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(JPInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCedulA, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbTipoPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbAvisoContrasenia, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(JPInsertarLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btAgregarMiembro)
                        .addGap(104, 104, 104)
                        .addComponent(BtnLimpiarUsuarios)
                        .addGap(115, 115, 115)))
                .addGroup(JPInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPInsertarLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(JPInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbAvisoCargo)
                            .addComponent(lbAvisoCorreo)
                            .addComponent(lbAvisoCedula))
                        .addContainerGap(76, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPInsertarLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRegresarUsuarios)
                        .addContainerGap())))
            .addGroup(JPInsertarLayout.createSequentialGroup()
                .addGap(275, 275, 275)
                .addComponent(jLabel21)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JPInsertarLayout.setVerticalGroup(
            JPInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPInsertarLayout.createSequentialGroup()
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(JPInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbAvisoNombre)
                        .addComponent(jLabel24))
                    .addGroup(JPInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCedulA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbAvisoCedula)))
                .addGap(18, 18, 18)
                .addGroup(JPInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addComponent(dcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(JPInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbAvisoFecha)
                        .addComponent(jLabel28)
                        .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbAvisoCorreo)))
                .addGap(38, 38, 38)
                .addGroup(JPInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPInsertarLayout.createSequentialGroup()
                        .addGroup(JPInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27)
                            .addComponent(cbTipoPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbAvisoCargo))
                        .addGap(34, 34, 34)
                        .addGroup(JPInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbCargo)
                            .addComponent(cbCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btAgregarCargo))
                        .addGap(18, 18, 18)
                        .addGroup(JPInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(pswfContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbAvisoContrasenia))
                        .addGap(37, 37, 37)
                        .addGroup(JPInsertarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btAgregarMiembro, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnLimpiarUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPInsertarLayout.createSequentialGroup()
                        .addComponent(btnRegresarUsuarios)
                        .addContainerGap())))
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
        String cargo = (String) cbTipoPersona.getSelectedItem();
        if (cargo.equals("Seleccione un cargo")) {
            CargoIngreso = "";
            lbCargo.setVisible(false);
            cbCargo.setVisible(false);
            lbAvisoCargo.setVisible(false);
            btAgregarCargo.setVisible(false);
        } else if (cargo.equals("Administrador")) {
            CargoIngreso = "Administrador";
            lbCargo.setVisible(false);
            cbCargo.setVisible(false);
            lbAvisoCargo.setVisible(false);
            btAgregarCargo.setVisible(false);

        } else if (cargo.equals("Trabajador")) {
            CargoIngreso = "Trabajador";
            lbCargo.setVisible(true);
            cbCargo.setVisible(true);
            lbAvisoCargo.setVisible(true);
            btAgregarCargo.setVisible(true);
        } else if (cargo.equals("Cliente")) {
            CargoIngreso = "Cliente";
            lbCargo.setVisible(false);
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

    private void btAgregarMiembroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregarMiembroActionPerformed

        String nombre = txtNombre.getText();
        String cedula = txtCedulA.getText();
        String correo = txtCorreo.getText();
        Date fechaNacimiento = dcFecha.getDate();
        String usuario = algoritmousuario(nombre, cedula);
        int PerfilId = 0;
        int cargoId = 0;
        if (validarDatosOtros() && validarCedula() && CargoIngreso.equals("Administrador") && validarcontrasenia()) {
            String contrasenia = ServicioPersonas.encriptar(pswfContrasenia.getText());
            PerfilId = 1;
            Personas AdminNuevo = new Personas(PerfilId, usuario, contrasenia,
                    cedula, correo, nombre, fechaNacimiento);

            if (ServicioPersonas.InsertarPersonasClienteyAdmin(AdminNuevo)) {
                JOptionPane.showMessageDialog(null, "Datos Ingresados");
            } else {
                JOptionPane.showMessageDialog(null, "Datos no Ingresados");
            }
        } else if (validarDatosTrabajador() && validarCedula() && CargoIngreso.equals("Trabajador") && validarcontrasenia()) {
            String contrasenia = ServicioPersonas.encriptar(pswfContrasenia.getText());
            PerfilId = 3;
            Personas TrabajadorNuevo = new Personas(PerfilId, usuario, contrasenia, cedula, correo, nombre, fechaNacimiento);

            if (ServicioPersonas.InsertarPersonasTrabajadores(TrabajadorNuevo)) {
                JOptionPane.showMessageDialog(null, "Datos Ingresados");
            } else {
                JOptionPane.showMessageDialog(null, "Datos no Ingresados");
            }
        } else if (validarDatosOtros() && validarCedula() && CargoIngreso.equals("Cliente")
                && validarcontrasenia()) {
            String contrasenia = ServicioPersonas.encriptar(pswfContrasenia.getText());
            PerfilId = 2;
            Personas ClienteNuevo = new Personas(PerfilId, usuario, contrasenia,
                    cedula, correo, nombre, fechaNacimiento);

            if (ServicioPersonas.InsertarPersonasClienteyAdmin(ClienteNuevo)) {
                JOptionPane.showMessageDialog(null, "Datos Ingresados");
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
    private javax.swing.JComboBox<String> cbCargo;
    private javax.swing.JComboBox<String> cbTipoPersona;
    private com.toedter.calendar.JDateChooser dcFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
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
