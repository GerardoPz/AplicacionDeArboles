package ito;

import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.toedter.calendar.JCalendar;


public class MyApp {

    public LocalDate leerFecha() {
        JFrame frame = new JFrame("Selecciona la fecha de tu corrida de autobus");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());
        JCalendar calendar = new JCalendar();
        frame.add(calendar, BorderLayout.CENTER);
        final LocalDate[] selectedDate = new LocalDate[1];
        JButton button = new JButton("Continuar");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date date = calendar.getDate();
                selectedDate[0] = convertToLocalDate(date);
                frame.dispose();
            }
        });
        frame.add(button, BorderLayout.SOUTH);
        frame.setVisible(true);
        while (selectedDate[0] == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return selectedDate[0];
    }

    private LocalDate convertToLocalDate(Date date) {
        return new java.sql.Date(date.getTime()).toLocalDate();
    }

    public String leerOrigen(String mensaje){
        String origenUsuario = TJOption.leerString(mensaje);
        return origenUsuario;
    }

    public String leerdestino(String mensaje){
        String destinoUsuario = TJOption.leerString(mensaje);
        return destinoUsuario;
    }

    public void runApp(){

    }

    public boolean consultaUsuario(){
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea hacer otra consulta?", "Aviso", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        boolean continuar = true;
            if (respuesta != JOptionPane.YES_OPTION) {
                continuar = false;
                JOptionPane.showMessageDialog(null, "Gracias por tu preferencia, hasta luego!");
            }
        return continuar;
    }
}

