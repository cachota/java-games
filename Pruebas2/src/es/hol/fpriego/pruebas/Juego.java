package es.hol.fpriego.pruebas;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class Juego extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Juego(){
		
		this.add(new Main());
		
		this.setResizable(false);
		pack();
		
		this.setTitle("Prueba Animacion");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {                
                JFrame ex = new Juego();
                ex.setVisible(true);                
            }
        });
	}

}
