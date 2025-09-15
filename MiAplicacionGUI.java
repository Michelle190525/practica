import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MiAplicacionGUI extends JFrame {

    private JTextField campoTexto;
    private JButton botonAgregar, botonLimpiar;
    private DefaultListModel<String> modeloLista;
    private JList<String> listaNombres;

    public MiAplicacionGUI() {
        super("Aplicación de Lista de Nombres");
        setLayout(new BorderLayout(10, 10));

        JPanel panelSuperior = new JPanel(new FlowLayout());

        campoTexto = new JTextField(20);
        botonAgregar = new JButton("Agregar");

        panelSuperior.add(new JLabel("Nombre:"));
        panelSuperior.add(campoTexto);
        panelSuperior.add(botonAgregar);

        modeloLista = new DefaultListModel<>();
        listaNombres = new JList<>(modeloLista);
        JScrollPane scrollLista = new JScrollPane(listaNombres);

        JPanel panelInferior = new JPanel(new FlowLayout());
        botonLimpiar = new JButton("Limpiar");
        panelInferior.add(botonLimpiar);

        add(panelSuperior, BorderLayout.NORTH);
        add(scrollLista, BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);

        botonAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String texto = campoTexto.getText().trim();
                if (!texto.isEmpty()) {
                    modeloLista.addElement(texto);
                    campoTexto.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "No se puede agregar un nombre vacío.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        botonLimpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                campoTexto.setText("");
                modeloLista.clear();
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MiAplicacionGUI();
            }
        });
    }
}
