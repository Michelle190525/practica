import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KeyCaptureExample extends JFrame {

    private JList<String> lista;
    private JButton boton;

    public KeyCaptureExample() {
        setTitle("Captura de Tecla 'C'");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());

        String[] elementos = {"Elemento 1", "Elemento 2", "Elemento 3", "Elemento 4"};
        lista = new JList<>(elementos);
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lista.setSelectedIndex(0);

        boton = new JButton("Haz clic aquí");
        boton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Botón presionado"));

        lista.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == 'c' || e.getKeyChar() == 'C') {
                    int index = lista.getSelectedIndex();
                    if (index != -1) {
                        System.out.println("Se presionó 'C' sobre: " + lista.getSelectedValue());
                        JOptionPane.showMessageDialog(null,
                                "Acción sobre " + lista.getSelectedValue(),
                                "Evento capturado",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });

        add(new JScrollPane(lista), BorderLayout.CENTER);
        add(boton, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(KeyCaptureExample::new);
    }
}
