package ro.san.rodri;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class VentanaPlaca extends  JFrame {
    private JLabel titulo;
    private JTextField campo;
    private  JButton boton;
    private JDialog resp;

    private JLabel respuesta;
    public VentanaPlaca() {
        super("Restriccion Vehicular");
        titulo = new JLabel("INGRESE NUMERO DE PLACA:");
        campo = new JTextField(8);
        boton = new JButton("VERIFICAR");
        resp = new JDialog(this);
        resp.setSize(300,300);
        respuesta = new JLabel("");
        FlowLayout construtor = new FlowLayout();
        setLayout(construtor);
        add(titulo);
        add(campo);
        add(boton);
        resp.add(respuesta);
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verificarPlaca();
            }
        });
    }
    public int getNumeroPlaca( String placa){
        int res = 0;
        for (int i = 0 ; i < placa.length(); i++){
            char c = placa.charAt(i);
            if (c >= '0' && c<= '9'){
                res = res * 10 + Character.getNumericValue(c);


            }
        }
        return res % 10;
    }
    public void verificarPlaca(){
        if (circula()){
            respuesta.setText("su placa circula.");
        }else
            respuesta.setText("su placa no circula");

        resp.setVisible(true);


    }
    public boolean circula() {
        boolean circ = true ;
        String placa = campo.getText();
        Calendar fecha = Calendar.getInstance();
        int dia = fecha.get(Calendar.DAY_OF_WEEK);
        int res= getNumeroPlaca(placa);
        if (res == 0 || res == 1) {
            if ( dia == 2) {
                circ = false;
            }
        }
        if (res == 2 || res == 3) {
            if (dia  == 3) {
                circ = false;
            }
        }
        if (res  == 4 || res == 5) {
            if (dia == 4) {
                circ = false;
            }
        }
        if (res  == 6 || res  == 7) {
            if (dia == 5) {
                circ = false;
            }
        }
        if (res  == 8 || res  == 9) {
            if (dia == 6) {
                circ = false;
            }
        }
        return circ;
    }


}
