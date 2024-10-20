package org.example;

import org.example.dao.DetallesDAO;
import org.example.model.Pelicula;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Ventana para mostrar los detalles de una película.
 */
public class detalles_peli extends JFrame {
    private int idPelicula;  // Para almacenar el ID de la película seleccionada

    /**
     * Constructor de la ventana.
     *
     * @param idPelicula ID de la película a mostrar.
     */
    // Componentes
    private JLabel peliculaLabel;
    private JTextArea detallesArea;
    private JButton volverBtn;

    // Constructor que acepta el id de la película
    public detalles_peli(int idPelicula) {
        this.idPelicula = idPelicula;  // Guardamos el ID
        initUI();  // Inicializa la interfaz de usuario
        obtenerDetallesPelicula();  // Obtiene los detalles de la película
    }

    // Método para inicializar la interfaz de usuario
    private void initUI() {
        setTitle("Detalles de la Película");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // Cierra solo esta ventana


        // Panel superior para el título
        JPanel panelSuperior = new JPanel();
        peliculaLabel = new JLabel("DETALLES DE LA PELI");
        peliculaLabel.setForeground(Color.BLUE);
        panelSuperior.add(peliculaLabel);

        // JScrollPane para mostrar los detalles
        detallesArea = new JTextArea();
        detallesArea.setEditable(false);  // No se puede editar
        JScrollPane scrollPane = new JScrollPane(detallesArea);

        // Panel inferior para el botón volver
        JPanel panelInferior = new JPanel();
        volverBtn = new JButton("Volver Atrás");
        volverBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Copias_Usuario copia = new Copias_Usuario(idPelicula);
                copia.setVisible(true);
                dispose();
            }
        });
        panelInferior.add(volverBtn);

        // Agregamos los paneles a la ventana
        add(panelSuperior, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);
    }

    // Método para obtener los detalles de la película
    private void obtenerDetallesPelicula() {
        DetallesDAO detallesDAO = new DetallesDAO();
        Pelicula pelicula = null;

        try {
            pelicula = DetallesDAO.obtenerDetallesPelicula(idPelicula);  // Obtiene detalles
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al obtener los detalles de la película: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return; // Salir del método si ocurre un error
        }

        // Si la película existe, se muestran sus detalles
        if (pelicula != null) {
            String detalles = "    ID: " + pelicula.getId() + "\n" +
                    "    Título: " + pelicula.getTitulo() + "\n" +
                    "    Género: " + pelicula.getGenero() + "\n" +
                    "    Año: " + pelicula.getAño() + "\n" +
                    "    Descripción: " + pelicula.getDescripcion() + "\n" +
                    "    Director: " + pelicula.getDirector();
            detallesArea.setText(detalles);  // Establece el texto en el JTextArea
            setTitle("Detalles de: " + pelicula.getTitulo()); // Personaliza el título con el nombre de la película
        } else {
            // Muestra un mensaje si no se encontró la película
            JOptionPane.showMessageDialog(this, "No se encontró la película con ID: " + idPelicula);
        }
    }

}