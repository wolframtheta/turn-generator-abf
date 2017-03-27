package com.wolframtheta;

/**
 * @(#)VistaGT.java
 *
 *
 * @author
 * @version 1.00 2009/2/27
 */

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class VistaGT extends JFrame {

	private JLabel label1;
	private JLabel label2;
	public JTextField nombres[];
	public JTextField turnos[];
	public JTextArea resultado;
	public JButton botonGenerar;
	public JCheckBox abiertas;
	public JButton botonSalir;
	private static int PARTICIPANTES = 14;

	public VistaGT() {
		Container contentPane = getContentPane();
		//contentPane.setPreferredSize(new Dimension(500,500));
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		contentPane.setLayout(gridbag);
		c.fill = GridBagConstraints.HORIZONTAL;

		label1 = new JLabel("Participantes");
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 0;
		gridbag.setConstraints(label1, c);
		contentPane.add(label1);

		label2 = new JLabel("Turno");
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 0;
		gridbag.setConstraints(label2, c);
		contentPane.add(label2);

		int i;

		nombres = new JTextField[PARTICIPANTES];
		for (i = 0; i<PARTICIPANTES; i++) {
			nombres[i] = new JTextField(10);
			nombres[i].setPreferredSize(new Dimension(150,25));
			c.weightx = 0.5;
			c.gridx = 0;
			c.gridy = i+1;
			gridbag.setConstraints(nombres[i], c);
			contentPane.add(nombres[i]);
		}

		turnos = new JTextField[PARTICIPANTES];
		for (i = 0; i<PARTICIPANTES; i++) {
			turnos[i] = new JTextField(4);
			turnos[i].setPreferredSize(new Dimension(40,25));
			c.weightx = 0.5;
			c.gridx = 1;
			c.gridy = i+1;
			gridbag.setConstraints(turnos[i], c);
			contentPane.add(turnos[i]);
		}

		c.fill = GridBagConstraints.BOTH;

		resultado = new JTextArea(5, 30);
		resultado.setFont(new Font("Serif", Font.ITALIC, 16));
		resultado.setText("");
		resultado.setLineWrap(true);
		resultado.setWrapStyleWord(true);
		resultado.setEditable(true);
		JScrollPane areaScrollPane = new JScrollPane(resultado);
		areaScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		c.ipady = 40;
		c.weightx = 1.0;
		c.gridwidth = 4;
		c.gridheight = 10;
		c.gridx = 2;
		c.gridy = 1;
		gridbag.setConstraints(areaScrollPane, c);
		contentPane.add(areaScrollPane);

		abiertas = new JCheckBox("Abiertas y pifias?");
		abiertas.setSelected(true);
		contentPane.add(abiertas);

		c.fill = GridBagConstraints.HORIZONTAL;
		botonGenerar = new JButton("Generar");
		c.ipady = 0;
		c.gridx = 3;
		c.gridwidth = 1;
		c.gridy = 11;
		gridbag.setConstraints(botonGenerar, c);
		contentPane.add(botonGenerar);

		c.fill = GridBagConstraints.NONE;
		botonSalir = new JButton("Salir");
		c.ipady = 0;
		c.gridx = 4;
		c.gridwidth = 1;
		c.gridy = 11;
		gridbag.setConstraints(botonSalir, c);
		contentPane.add(botonSalir);

    }


}