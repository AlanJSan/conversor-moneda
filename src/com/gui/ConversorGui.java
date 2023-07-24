package com.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import com.conversor.Conversor;
import com.conversor.ConversorMoneda;
import com.conversor.ConversorTemperatura;
import com.conversor.ConversorLongitud;
import com.conversor.Moneda;
import com.conversor.Temperatura;
import com.formdev.flatlaf.FlatDarkLaf;

import java.awt.Cursor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ConversorGui {

	private JFrame frmConversor;
	private JTextField textValor1;
	private JTextField textValor2;
	private JComboBox comboValor1;
	private JComboBox comboValor2;
	private JLabel labelValor2;
	private JLabel lblNewLabel;
	private JPanel panel_1;
	private JButton btnMonedas;
	private JButton btnTemperaturas;
	private JButton btnLongitudes;
	private JLabel labelLogo;
	private JLabel labelValor1;
    private Conversor<?> conversorActual = new ConversorMoneda();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FlatDarkLaf.setup();
					UIManager.put( "Button.arc", 1 );
					ConversorGui window = new ConversorGui();
					window.frmConversor.setVisible(true);
					window.textValor1.requestFocus();
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
		frmConversor = new JFrame();
		frmConversor.setTitle("Conversor");
		frmConversor.setResizable(false);
		frmConversor.getContentPane().setBackground(new Color(255, 255, 255));
		frmConversor.getContentPane().setLayout(null);
		
		labelValor1 = new JLabel("");
		labelValor2 = new JLabel("");
		labelValor1.setFont(new Font("Tahoma", Font.PLAIN, 32));
		labelValor1.setBounds(190, 45, 34, 50);
		comboValor2 = new JComboBox();
		comboValor1 = new JComboBox();
		textValor1 = new JTextField();
		textValor2 = new JTextField();

		comboValor2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				setCurrencySymbol(e, labelValor2, comboValor2.getSelectedIndex());
				validateAndConvertValue(comboValor1, comboValor2, textValor1, textValor2);
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 599, 318);
		panel.setLayout(null);
		
		
		comboValor1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				setCurrencySymbol(e, labelValor1, comboValor1.getSelectedIndex());
				validateAndConvertValue(comboValor2, comboValor1, textValor2, textValor1);
			}
		});
		comboValor1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboValor1.setBounds(372, 45, 181, 50);
		
		
		comboValor2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboValor2.setBounds(372, 197, 181, 50);
		setComboBoxItems();
		
		textValor1.setFont(new Font("Tahoma", Font.PLAIN, 32));
		textValor1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				validateAndConvertValue(comboValor1, comboValor2, textValor1, textValor2);	
			}
		});
		textValor1.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		textValor1.setBounds(224, 45, 148, 50);
		textValor1.setColumns(10);
		
		textValor2.setFont(new Font("Tahoma", Font.PLAIN, 32));
		textValor2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				validateAndConvertValue(comboValor2, comboValor1, textValor2, textValor1);
			}
		});
		textValor2.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		textValor2.setBounds(224, 197, 148, 50);
		textValor2.setColumns(10);
		
		
		labelValor2.setFont(new Font("Tahoma", Font.PLAIN, 32));
		labelValor2.setBounds(190, 197, 34, 50);
		
		panel.add(labelValor1);
		panel.add(labelValor2);
		panel.add(textValor1);
		panel.add(textValor2);
		panel.add(comboValor1);
		panel.add(comboValor2);

		frmConversor.getContentPane().add(panel);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("E:\\JProjects\\conversor\\assets\\transfer-arrows.png"));
		lblNewLabel.setBounds(325, 118, 70, 50);
		panel.add(lblNewLabel);
		
		panel_1 = new JPanel();
		panel_1.setBackground(UIManager.getColor("Button.light"));
		panel_1.setBounds(0, 0, 123, 318);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		btnMonedas = new JButton("Monedas");
		btnMonedas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				cambiarConversor(new ConversorMoneda());
				labelValor1.setVisible(true);
				labelValor2.setVisible(true);
				setComboBoxItems();
			}
		});
		btnMonedas.setBorderPainted(false);
		btnMonedas.setMargin(new Insets(2, 5, 2, 0));
		btnMonedas.setHorizontalAlignment(SwingConstants.LEFT);
		btnMonedas.setIcon(new ImageIcon("E:\\JProjects\\conversor\\assets\\divisa.png"));
		btnMonedas.setBounds(0, 0, 123, 50);
		btnMonedas.setPreferredSize(new Dimension(102, 23));
		btnMonedas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_1.add(btnMonedas);
		
		btnTemperaturas = new JButton("Temperaturas");
		btnTemperaturas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				cambiarConversor(new ConversorTemperatura());
				setDefaultContent();
				setComboBoxItems();
				labelValor1.setVisible(false);
				labelValor2.setVisible(false);
			}
		});
		btnTemperaturas.setBorderPainted(false);
		btnTemperaturas.setHorizontalAlignment(SwingConstants.LEFT);
		btnTemperaturas.setIcon(new ImageIcon("E:\\JProjects\\conversor\\assets\\termometro.png"));
		btnTemperaturas.setMargin(new Insets(2, 5, 2, 0));
		btnTemperaturas.setBounds(0, 49, 123, 50);
		btnTemperaturas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_1.add(btnTemperaturas);
		
		btnLongitudes = new JButton("Longitudes");
		btnLongitudes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				cambiarConversor(new ConversorLongitud());
				setDefaultContent();
				setComboBoxItems();
				labelValor1.setVisible(false);
				labelValor2.setVisible(false);
			}
		});
		btnLongitudes.setBorderPainted(false);
		btnLongitudes.setHorizontalAlignment(SwingConstants.LEFT);
		btnLongitudes.setIcon(new ImageIcon("E:\\JProjects\\conversor\\assets\\regla.png"));
		btnLongitudes.setMargin(new Insets(2, 5, 2, 0));
		btnLongitudes.setBounds(0, 99, 123, 50);
		btnLongitudes.setPreferredSize(new Dimension(102, 23));
		btnLongitudes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_1.add(btnLongitudes);
		
		labelLogo = new JLabel("");
		labelLogo.setHorizontalAlignment(SwingConstants.CENTER);
		labelLogo.setBounds(15, 180, 80, 96);
		panel_1.add(labelLogo);
		labelLogo.setIcon(new ImageIcon("E:\\JProjects\\conversor\\assets\\logo-mejorado.png"));
		frmConversor.setBounds(100, 100, 615, 357);
		frmConversor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConversor.setLocationRelativeTo(null);
	}
	
	private boolean isNumeric(String str) {
		return str.matches("\\d+(\\.\\d+)?");
	}
	
	private void validateAndConvertValue(JComboBox comboOrigen, JComboBox comboDestino, JTextField textOrigen, JTextField textDestino) {
		try {
			String s = textOrigen.getText();
			
			if(!isNumeric(s) ) {
				if(textOrigen.getText().isEmpty())
					textDestino.setText("");
			}else {
				String valorOrigen = conversorActual.getValues()[comboOrigen.getSelectedIndex()].name();
				String valorDestino = conversorActual.getValues()[comboDestino.getSelectedIndex()].name();
				textDestino.setText(conversorActual.convertir(valorOrigen, valorDestino, Double.parseDouble(textOrigen.getText())));
			}	
		} catch (NumberFormatException ex) {
			// TODO: handle exception
			System.out.println(ex);
		}
	}
	
	private void setCurrencySymbol(ItemEvent e, JLabel labelDestino, int comboOrigenIndex) {
		if(e.getStateChange() == ItemEvent.SELECTED && labelValor1.isVisible()) {
			labelDestino.setText(Moneda.values()[comboOrigenIndex].getSimbolo());
		}
	}
	
	private void cambiarConversor(Conversor<?> nuevoConversor) {
        conversorActual = nuevoConversor;
    }
	
	private void setComboBoxItems() {
		comboValor1.removeAllItems();
		comboValor2.removeAllItems();
		for (Enum<?> value : conversorActual.getValues()) {
			System.out.println(value);
			comboValor1.addItem(value);
			comboValor2.addItem(value);
		}
		comboValor2.setSelectedIndex(1);
	}
	
	private void setDefaultContent() {
		textValor1.setText("");
		textValor2.setText("");
		textValor1.requestFocus();
	}
}
