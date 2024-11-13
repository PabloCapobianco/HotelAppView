package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RoomView2 {
    private JFrame frame;

    public RoomView2() {
        // Datos de ejemplo declarados localmente
        Object[] roomData = {"1", "2", "1", "$100"};

        // Crear el frame
        frame = new JFrame("Ventana con Campos de Texto y Botones");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Crear el panel principal con un BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Crear el panel de texto con un GridLayout para los labels y JTextFields
        JPanel textPanel = new JPanel(new GridLayout(4, 2, 5, 5)); // 4 filas y 2 columnas

        // Crear labels y campos de texto no editables usando los datos de roomData
        JLabel idLabel = new JLabel("id:");
        JTextField idField = new JTextField(roomData[0].toString());
        idField.setEditable(false); // El campo "id" siempre será no editable

        JLabel singlesLabel = new JLabel("singles:");
        JTextField singlesField = new JTextField(roomData[1].toString());
        singlesField.setEditable(false);

        JLabel doublesLabel = new JLabel("doubles:");
        JTextField doublesField = new JTextField(roomData[2].toString());
        doublesField.setEditable(false);

        JLabel priceLabel = new JLabel("price:");
        JTextField priceField = new JTextField(roomData[3].toString());
        priceField.setEditable(false);

        // Añadir labels y campos de texto al panel de texto
        textPanel.add(idLabel);
        textPanel.add(idField);
        textPanel.add(singlesLabel);
        textPanel.add(singlesField);
        textPanel.add(doublesLabel);
        textPanel.add(doublesField);
        textPanel.add(priceLabel);
        textPanel.add(priceField);

        // Crear el panel de botones
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        // Crear los botones
        JButton saveButton = new JButton("Save");
        saveButton.setEnabled(false); // El botón "Save" comienza deshabilitado

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setEnabled(false); // El botón "Save" comienza deshabilitado

        JButton editButton = new JButton("Edit");
        JButton deleteButton = new JButton("Delete");


        // Añadir los botones al panel de botones
        buttonPanel.add(saveButton);
        buttonPanel.add(cancelButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);


        // Listener para el botón Edit, que habilita los campos de texto y el botón Save
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                singlesField.setEditable(true);
                doublesField.setEditable(true);
                priceField.setEditable(true);
                saveButton.setEnabled(true); // Habilitar el botón "Save" al hacer clic en "Edit"
                cancelButton.setEnabled(true); // Habilitar el botón "Cancel" al hacer clic en "Edit"
                deleteButton.setEnabled(false);
            }
        });

        // Añadir el panel de texto y el panel de botones al panel principal
        mainPanel.add(textPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Añadir el panel principal al frame
        frame.add(mainPanel);

        // Hacer visible la ventana
        frame.setVisible(true);
    }


}
