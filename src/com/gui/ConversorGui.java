package com.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;

import com.conversor.ConversorMoneda;
import com.conversor.Moneda;

import java.awt.Cursor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class ConversorGui {

	private JFrame frame;
	private JTextField textMoneda1;
	private JTextField textMoneda2;
	private ConversorMoneda cm = new ConversorMoneda();
	private Moneda[] monedas = Moneda.values();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConversorGui window = new ConversorGui();
					window.frame.setVisible(true);
					window.textMoneda1.requestFocus();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ConversorGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.getContentPane().setLayout(null);
		
		JComboBox comboMoneda1 = new JComboBox();
		comboMoneda1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboMoneda1.setBounds(82, 49, 96, 22);
		frame.getContentPane().add(comboMoneda1);
		
		JComboBox comboMoneda2 = new JComboBox();
		comboMoneda2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboMoneda2.setBounds(282, 49, 96, 22);
		frame.getContentPane().add(comboMoneda2);
		for (Moneda moneda : monedas) {
			comboMoneda1.addItem(moneda.descripcion());
			comboMoneda2.addItem(moneda.descripcion());
		}
		comboMoneda2.setSelectedIndex(1);
		
		textMoneda1 = new JTextField();
		textMoneda1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				validateAndConvertCurrency(e, comboMoneda1, comboMoneda2, textMoneda1, textMoneda2);	
			}
		});
		textMoneda1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		textMoneda1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		textMoneda1.setCaretColor(new Color(0, 0, 0));
		textMoneda1.setBounds(92, 115, 86, 20);
		frame.getContentPane().add(textMoneda1);
		textMoneda1.setColumns(10);
		
		textMoneda2 = new JTextField();
		textMoneda2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				validateAndConvertCurrency(e, comboMoneda2, comboMoneda1, textMoneda2, textMoneda1);
			}
		});
		textMoneda2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		textMoneda2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		textMoneda2.setBounds(292, 115, 86, 20);
		frame.getContentPane().add(textMoneda2);
		textMoneda2.setColumns(10);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
	}
	
	private boolean isNumeric(String str) {
		return str.matches("\\d+(\\.\\d+)?");
	}
	
	private void validateAndConvertCurrency(KeyEvent e, JComboBox comboOrigen, JComboBox comboDestino, JTextField textMonedaOrigen, JTextField textMonedaDestino) {
		try {
			String s =  String.valueOf(e.getKeyChar());
			if(!isNumeric(s) && (e.getKeyCode() != 8 && e.getKeyCode() != 127)) {
				e.consume();
			}else {
				String monedaOrigen = monedas[comboOrigen.getSelectedIndex()].name();
				String monedaDestino = monedas[comboDestino.getSelectedIndex()].name();
				textMonedaDestino.setText(
						textMonedaOrigen.getText().isEmpty() ? "" 
								: cm.convertir(monedaOrigen, monedaDestino, Double.parseDouble(textMonedaOrigen.getText())));
			}	
		} catch (NumberFormatException ex) {
			// TODO: handle exception
			System.out.println(ex);
		}
	}

}
