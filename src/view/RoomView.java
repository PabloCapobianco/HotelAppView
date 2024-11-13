package view;

import javax.swing.JFrame;       // Para crear una ventana
import javax.swing.JPanel;       // Para un panel de contenido
import javax.swing.JButton;      // Para un botón
import javax.swing.JLabel;       // Para etiquetas de texto
import javax.swing.JTextField;   // Para campos de texto
import javax.swing.JOptionPane;  // Para cuadros de diálogo
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import .RoomView2;


public class RoomView {
    private JFrame frame;

    // Constructor de RoomView1
    public RoomView() {
        JFrame frame = new JFrame("Ventana de Búsqueda");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        // Crear el panel principal con un layout de BorderLayout
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Crear la sección superior (con el cuadro de texto, drop menu y botón)
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));  // Alineación horizontal


        // Add Button
        JButton addRoomButton = new JButton("Add");
        topPanel.add(addRoomButton);

        // Edit Button
        JButton editRoomButton = new JButton("Edit");
        editRoomButton.setEnabled(false);
        topPanel.add(editRoomButton);

        // Delete Button
        JButton deleteRoomButton = new JButton("Delete");
        deleteRoomButton.setEnabled(false);
        topPanel.add(deleteRoomButton);

        // Acción para el botón Edit
        editRoomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Código que se ejecuta al hacer clic en el botón
                System.out.println("¡Botón clickeado!");
            }
        });

        // Agregar el panel superior al panel principal
        panel.add(topPanel, BorderLayout.NORTH);

        // Crear la sección central (tabla)
        String[] columnNames = {"Number", "Singles", "Doubles", "Price day-night"};
        Object[][] data = {
                {"1", "Single 1", "Double 1", "$100"},
                {"2", "Single 2", "Double 2", "$150"},
                {"3", "Single 3", "Double 3", "$200"},
                {"4", "Single 4", "Double 4", "$250"},
                {"5", "Single 5", "Double 5", "$300"},
                {"6", "Single 6", "Double 6", "$350"}
        };

        JTable table = new JTable(data, columnNames);

        table.setDefaultEditor(Object.class, null);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = table.getSelectedRow(); // Índice de la fila seleccionada
                editRoomButton.setEnabled(true);
                deleteRoomButton.setEnabled(true);

                if (selectedRow != -1) {

                    // Obtener todos los datos de la fila seleccionada y almacenarlos en un único objeto de tipo Object[]
                    Object[] selectedRoom = new Object[table.getColumnCount()]; // Crear un arreglo con el tamaño de las columnas

                    for (int i = 0; i < table.getColumnCount(); i++) {
                        selectedRoom[i] = table.getValueAt(selectedRow, i); // Obtener los valores de la fila y asignarlos al arreglo
                    }

                    // Mostrar los datos en la consola o en otro componente
                    System.out.println("Fila seleccionada: " + selectedRow);
                    for (int i = 0; i < selectedRoom.length; i++) {
                        System.out.println("Columna " + (i + 1) + ": " + selectedRoom[i]);
                    }
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(table); // Agregar barra de desplazamiento
        panel.add(scrollPane, BorderLayout.SOUTH); // Agregar tabla al centro

        // Agregar el panel principal al frame
        frame.add(panel);

        // Mostrar la ventana
        frame.setVisible(true);
    }
}
