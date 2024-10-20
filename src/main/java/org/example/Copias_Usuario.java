package org.example;

import org.example.dao.CopiasDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

/**
 * Interfaz gráfica para gestionar copias de usuario.
 */
public class Copias_Usuario extends JFrame {
    private JList<String> listaCopias;
    private JButton cerrarSesionBtn;
    private int idUsuario; // Para almacenar el ID del usuario

    /**
     * Constructor de la interfaz.
     *
     * @param idUsuario ID del usuario actual.
     */
    public Copias_Usuario(int idUsuario) {
        this.idUsuario = idUsuario; // Asignar el ID del usuario
        setTitle("Copias de Usuario");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // Panel general
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Label en la parte superior
        JLabel label = new JLabel("MIS PELÍCULAS", SwingConstants.CENTER);
        label.setForeground(Color.BLUE);
        panel.add(label, BorderLayout.NORTH);


        // Inicializar la lista de copias
        listaCopias = new JList<>();
        JScrollPane scrollPane = new JScrollPane(listaCopias);
        listaCopias.setForeground(Color.black);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Cargar las copias del usuario
        cargarCopiasUsuario(idUsuario);

        // Añadir listener para doble clic en la lista
        listaCopias.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) { // Doble clic
                    String selectedValue = listaCopias.getSelectedValue();
                    System.out.println("Valor seleccionado: " + selectedValue); // Imprime el valor seleccionado

                    if (selectedValue != null) {
                        try {
                            // Suponiendo que el formato es "Nombre de la película   :Registro: [número]"
                            String[] parts = selectedValue.split("    : Registro: ");
                            if (parts.length == 2) { // Verifica que se haya dividido correctamente
                                int idPelicula = Integer.parseInt(parts[1]); // Obtiene el ID de la película
                                mostrarDetallesPelicula(idPelicula); // Llama al método para mostrar detalles
                            } else {
                                System.out.println("Formato de texto seleccionado incorrecto. Partes: " + parts.length);
                            }
                        } catch (NumberFormatException ex) {
                            System.out.println("Error al convertir el ID de la película: " + ex.getMessage());
                        } catch (ArrayIndexOutOfBoundsException ex) {
                            System.out.println("Error: " + ex.getMessage());
                        }
                    }
                }
            }
        });
        // Botón para cerrar sesión
        cerrarSesionBtn = new JButton("Cerrar Sesión");
        cerrarSesionBtn.addActionListener(e -> cerrarSesion());
        panel.add(cerrarSesionBtn, BorderLayout.SOUTH);

        // Añadir el panel a la ventana
        add(panel);
    }

    private void cargarCopiasUsuario(int idUsuario) {
        CopiasDAO copiasDAO = new CopiasDAO();
        try {
            List<String> copias = CopiasDAO.obtenerCopiasPorUsuario(idUsuario); // Esto debería devolver la lista de copias
            DefaultListModel<String> model = new DefaultListModel<>();
            if (copias.isEmpty()) {
                model.addElement("No hay copias disponibles."); // Mensaje si no hay copias
            } else {
                for (String copia : copias) {
                    // Suponiendo que copia tiene el formato "Nombre de la película : Registro: : [número]"
                    String[] parts = copia.split("    : Registro: ");
                    if (parts.length == 2) {
                        String titulo = parts[0]; // Toma solo el título
                        model.addElement("   "+titulo + "    : Registro: " + parts[1]); // Agrega el título y el ID
                    }
                }
            }
            listaCopias.setModel(model);
        } catch (Exception e) {
            System.err.println("Error al cargar las copias: " + e.getMessage());
            JOptionPane.showMessageDialog(this, "Error al cargar las copias: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void mostrarDetallesPelicula(int idPelicula) {
        detalles_peli detallesPeli = new detalles_peli(idPelicula); // Asegúrate de tener un constructor que acepte idPelicula
        detallesPeli.setVisible(true); // Mostrar la nueva ventana
        this.dispose(); // Cerrar la ventana actual
    }

    private void cerrarSesion() {
        System.out.println("Sesión cerrada"); // Mensaje de debug
        dispose();
    }
}