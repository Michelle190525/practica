import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AgendaPersonal extends JFrame {

    private JSpinner spinnerFecha;
    private JSpinner spinnerHora;
    private JTextField campoDescripcion;
    private JTable tablaEventos;
    private DefaultTableModel modeloTabla;

    public AgendaPersonal() {
        setTitle("Agenda Personal");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la ventana

        inicializarComponentes();
    }

    private void inicializarComponentes() {
        setLayout(new BorderLayout());

        // PANEL ENTRADA
        JPanel panelEntrada = new JPanel(new GridLayout(3, 2, 10, 10));
        panelEntrada.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel lblFecha = new JLabel("Fecha (dd/MM/yyyy):");
        spinnerFecha = new JSpinner(new SpinnerDateModel());
        spinnerFecha.setEditor(new JSpinner.DateEditor(spinnerFecha, "dd/MM/yyyy"));

        JLabel lblHora = new JLabel("Hora (HH:mm):");
        spinnerHora = new JSpinner(new SpinnerDateModel());
        spinnerHora.setEditor(new JSpinner.DateEditor(spinnerHora, "HH:mm"));

        JLabel lblDescripcion = new JLabel("Descripción:");
        campoDescripcion = new JTextField();

        panelEntrada.add(lblFecha);
        panelEntrada.add(spinnerFecha);
        panelEntrada.add(lblHora);
        panelEntrada.add(spinnerHora);
        panelEntrada.add(lblDescripcion);
        panelEntrada.add(campoDescripcion);

        add(panelEntrada, BorderLayout.NORTH);

        // PANEL TABLA
        modeloTabla = new DefaultTableModel(new String[]{"Fecha", "Hora", "Descripción"}, 0);
        tablaEventos = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tablaEventos);
        add(scrollPane, BorderLayout.CENTER);

        // PANEL BOTONES
        JPanel panelBotones = new JPanel();
        JButton btnAgregar = new JButton("Agregar");
        JButton btnEliminar = new JButton("Eliminar seleccionado");
        JButton btnSalir = new JButton("Salir");

        panelBotones.add(btnAgregar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnSalir);

        add(panelBotones, BorderLayout.SOUTH);

        // EVENTOS
        btnAgregar.addActionListener(e -> agregarEvento());
        btnEliminar.addActionListener(e -> eliminarEvento());
        btnSalir.addActionListener(e -> dispose());
    }

    private void agregarEvento() {
        String descripcion = campoDescripcion.getText().trim();

        if (descripcion.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "La descripción no puede estar vacía",
                    "Validación",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        Date fecha = (Date) spinnerFecha.getValue();
        Date hora = (Date) spinnerHora.getValue();

        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");

        String strFecha = formatoFecha.format(fecha);
        String strHora = formatoHora.format(hora);

        modeloTabla.addRow(new Object[]{strFecha, strHora, descripcion});

        campoDescripcion.setText("");
        campoDescripcion.requestFocus();
    }

    private void eliminarEvento() {
        int filaSeleccionada = tablaEventos.getSelectedRow();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this,
                    "Selecciona un evento primero",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirmacion = JOptionPane.showConfirmDialog(this,
                "¿Eliminar el evento seleccionado?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {
            modeloTabla.removeRow(filaSeleccionada);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AgendaPersonal().setVisible(true);
        });
    }
}
