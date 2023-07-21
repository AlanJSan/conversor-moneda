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
import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLightLaf;

import java.awt.Cursor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import java.awt.Component;
import javax.swing.JLabel;
import java.awt.Window.Type;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;
import javax.swing.JPanel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.JToolBar;
import javax.swing.JLayeredPane;
import javax.swing.JInternalFrame;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import java.awt.ComponentOrientation;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConversorGui {

	private JFrame frmConversor;
	private JTextField textMoneda1;
	private JTextField textMoneda2;
	private ConversorMoneda cm = new ConversorMoneda();
	private Moneda[] monedas = Moneda.values();
	private JLabel labelMoneda2;
	private JLabel lblNewLabel;
	private JPanel panel_1;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FlatDarkLaf.setup();//FlatIntelliJLaf, FlatDarculaLaf, FlatDarkLaf
					//FlatLightLaf.setup();
					UIManager.put( "Component.arc", 10 );
					UIManager.put( "TextComponent.arc", 10 );
					UIManager.put( "Button.arc", 1 );
					ConversorGui window = new ConversorGui();
					window.frmConversor.setVisible(true);
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
		frmConversor = new JFrame();
		frmConversor.setTitle("Conversor");
		frmConversor.setResizable(false);
		frmConversor.getContentPane().setBackground(new Color(255, 255, 255));
		frmConversor.getContentPane().setLayout(null);
		
		JLabel labelMoneda1 = new JLabel("");
		labelMoneda2 = new JLabel("");
		labelMoneda1.setFont(new Font("Tahoma", Font.PLAIN, 32));
		labelMoneda1.setBounds(262, 11, 34, 50);
		JComboBox comboMoneda2 = new JComboBox();
		JComboBox comboMoneda1 = new JComboBox();
		textMoneda1 = new JTextField();
		textMoneda2 = new JTextField();


				
		comboMoneda2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				setCurrencySymbol(e, labelMoneda2, comboMoneda2.getSelectedIndex());
				validateAndConvertCurrency(comboMoneda1, comboMoneda2, textMoneda1, textMoneda2);
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 599, 318);
		panel.setLayout(null);
		
		
		comboMoneda1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				setCurrencySymbol(e, labelMoneda1, comboMoneda1.getSelectedIndex());
				validateAndConvertCurrency(comboMoneda2, comboMoneda1, textMoneda2, textMoneda1);
			}
		});
		comboMoneda1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboMoneda1.setBounds(273, 84, 181, 22);
		
		
		comboMoneda2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboMoneda2.setBounds(273, 285, 181, 22);
		for (Moneda moneda : monedas) {
			comboMoneda1.addItem(moneda.descripcion());
			comboMoneda2.addItem(moneda.descripcion());
		}
		comboMoneda2.setSelectedIndex(1);
		
		textMoneda1.setFont(new Font("Tahoma", Font.PLAIN, 32));
		textMoneda1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				validateAndConvertCurrency(comboMoneda1, comboMoneda2, textMoneda1, textMoneda2);	
			}
		});
		textMoneda1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		textMoneda1.setBounds(296, 11, 148, 50);
		textMoneda1.setColumns(10);
		
		textMoneda2.setFont(new Font("Tahoma", Font.PLAIN, 32));
		textMoneda2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				validateAndConvertCurrency(comboMoneda2, comboMoneda1, textMoneda2, textMoneda1);
			}
		});
		textMoneda2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		textMoneda2.setBounds(306, 212, 148, 50);
		textMoneda2.setColumns(10);
		
		
		labelMoneda2.setFont(new Font("Tahoma", Font.PLAIN, 32));
		labelMoneda2.setBounds(273, 212, 34, 50);
		
		panel.add(labelMoneda1);
		panel.add(labelMoneda2);
		panel.add(textMoneda1);
		panel.add(textMoneda2);
		panel.add(comboMoneda1);
		panel.add(comboMoneda2);

		frmConversor.getContentPane().add(panel);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("E:\\JProjects\\conversor\\assets\\transfer-arrows.png"));
		lblNewLabel.setBounds(325, 133, 70, 50);
		panel.add(lblNewLabel);
		
		panel_1 = new JPanel();
		panel_1.setBackground(UIManager.getColor("Button.light"));
		panel_1.setBounds(0, 0, 123, 318);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		btnNewButton = new JButton("Monedas");
		btnNewButton.setBorderPainted(false);
		btnNewButton.setMargin(new Insets(2, 5, 2, 0));
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setIcon(new ImageIcon("E:\\JProjects\\conversor\\assets\\divisa.png"));
		btnNewButton.setBounds(0, 0, 123, 50);
		btnNewButton.setPreferredSize(new Dimension(102, 23));
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_1.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Temperaturas");
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1.setIcon(new ImageIcon("E:\\JProjects\\conversor\\assets\\termometro.png"));
		btnNewButton_1.setMargin(new Insets(2, 5, 2, 0));
		btnNewButton_1.setBounds(0, 49, 123, 50);
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_1.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Longitudes");
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setIcon(new ImageIcon("E:\\JProjects\\conversor\\assets\\regla.png"));
		btnNewButton_2.setMargin(new Insets(2, 5, 2, 0));
		btnNewButton_2.setBounds(0, 99, 123, 50);
		btnNewButton_2.setPreferredSize(new Dimension(102, 23));
		btnNewButton_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_1.add(btnNewButton_2);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(15, 180, 80, 96);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon("E:\\JProjects\\conversor\\assets\\logo-mejorado.png"));
		frmConversor.setBounds(100, 100, 615, 357);
		frmConversor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConversor.setLocationRelativeTo(null);
	}
	
	private boolean isNumeric(String str) {
		return str.matches("\\d+(\\.\\d+)?");
	}
	
	private void validateAndConvertCurrency(JComboBox comboOrigen, JComboBox comboDestino, JTextField textMonedaOrigen, JTextField textMonedaDestino) {
		try {
			String s = textMonedaOrigen.getText();
			
			if(!isNumeric(s) ) {
				//e.consume();
				if(textMonedaOrigen.getText().isEmpty())
					textMonedaDestino.setText("");
			}else {
				String monedaOrigen = monedas[comboOrigen.getSelectedIndex()].name();
				String monedaDestino = monedas[comboDestino.getSelectedIndex()].name();
				textMonedaDestino.setText(cm.convertir(monedaOrigen, monedaDestino, Double.parseDouble(textMonedaOrigen.getText())));
			}	
		} catch (NumberFormatException ex) {
			// TODO: handle exception
			System.out.println(ex);
		}
	}
	
	private void setCurrencySymbol(ItemEvent e, JLabel labelDestino, int comboMonedaOrigenIndex) {
		if(e.getStateChange() == ItemEvent.SELECTED) {
			labelDestino.setText(monedas[comboMonedaOrigenIndex].getSimbolo());
		}
	}
}
