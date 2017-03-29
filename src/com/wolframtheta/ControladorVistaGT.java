package com.wolframtheta;

/**
 * @(#)ControladorVistaGT.java
 *
 *
 * @author
 * @version 1.00 2009/2/28
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Random;
import java.util.Vector;

public class ControladorVistaGT implements ActionListener, WindowListener {

	private VistaGT VGT = null;
	private Random generator;
	private boolean abiertasAct = true;

    private int pifia = 0;

    private int abierta = 0;
	public ControladorVistaGT() {
		VGT = new VistaGT();
		generator  = new Random();

		VGT.setTitle("ANIMA: Generador Turnos");
		VGT.pack();
		VGT.setSize(600, 450);
		VGT.setResizable(false);
		VGT.setLocation(150,50);
		VGT.setVisible(true);

		VGT.botonSalir.addActionListener(this);
		VGT.botonGenerar.addActionListener(this);
		VGT.abiertas.addActionListener(this);
		VGT.addWindowListener(this);
	}

	private int generarTurno(final int t)
	{
        abierta = 0;
        pifia = 0;
		int tirada = generator.nextInt(100)+1;
		int turnoFinal = tirada;
		if (abiertasAct)
		{
			int i = 0;
			if (tirada>=90+i)
			{
				tirada = generator.nextInt(100)+1;
				turnoFinal += tirada;
				if (i<10)
                {
                    i++;
                }
                ++abierta;
			}
			else if (tirada == 1)
            {
                turnoFinal = -125;
                pifia = 1;
            }
            else if (tirada == 2)
            {
                turnoFinal = -100;
                pifia = 2;
            }
            else if (tirada == 3)
            {
                turnoFinal = -75;
                pifia = 3;
            }
		}
		return turnoFinal+t;
	}

	@Override
    public void actionPerformed( final ActionEvent event ){
		if (event.getSource() == VGT.botonGenerar)
		{
			VGT.resultado.setText("");
			Vector<Personaje> vp = new Vector<Personaje>();
			String listaNombres[] = new String[10];
			for (int i = 0; i<10; i++)
			{
				listaNombres[i] = new String(VGT.nombres[i].getText());
				if (listaNombres[i].length() != 0)
				{
					int turnoFinal = generarTurno(Integer.parseInt(VGT.turnos[i].getText()));

					Personaje p = new Personaje(VGT.nombres[i].getText(), turnoFinal);
                    p.setAbierta(abierta);
                    p.setPifia(pifia);
					vp.add(p);
				}
			}

			int imin=0;
			int tmin;
            Vector<Personaje> vp2 = new Vector<Personaje>();
            vp2.addAll(vp);
			while (vp.size() > 0) {
				tmin = -1000;
				for (int i = 0; i<vp.size(); i++)
				{
					if (vp.elementAt(i).getTurno() > tmin)
					{
						imin = i;
						tmin = vp.elementAt(i).getTurno();
					}
				}
				String s = VGT.resultado.getText();
                VGT.resultado.setText(s + vp.elementAt(imin).getNombre() + " "
                    + vp.elementAt(imin).getTurno()
                    + (vp.elementAt(imin).getAbierta() > 0 ? " | Abierta: "
                        + vp.elementAt(imin).getAbierta() : "")
                    + (vp.elementAt(imin).getPifia() > 0 ? " | Pifia: "
                        + vp.elementAt(imin).getPifia() : "") + "\n");
                vp.removeElementAt(imin);
			}
            String finalRes = VGT.resultado.getText() + "\n";
            for (Personaje pj : vp2)
            {
                for (Personaje pj1 : vp2)
                {
                    if (pj.getTurno() - pj1.getTurno() > 150)
                    {
                        finalRes += pj.getNombre() + " consigue sorpresa a " + pj1.getNombre() + "\n";
                    }
                }
            }
            VGT.resultado.setText(finalRes);
		}
		else if (event.getSource() == VGT.abiertas)
		{
			if (VGT.abiertas.isSelected()) { abiertasAct = true; }
            else
            {
                abiertasAct = false;
            }
		}
		else if (event.getSource() == VGT.botonSalir)
		{
			System.exit(0);
		}
	}

	@Override
    public void windowClosing(final WindowEvent e)
	{
		System.exit(0);
	}
	@Override
    public void windowOpened(final WindowEvent e)
	{
	}
	@Override
    public void windowClosed(final WindowEvent e)
	{
	}
	@Override
    public void windowIconified(final WindowEvent e)
	{
	}
	@Override
    public void windowDeiconified(final WindowEvent e)
	{
	}
	@Override
    public void windowActivated(final WindowEvent e)
	{
	}
	@Override
    public void windowDeactivated(final WindowEvent e)
	{
	}

}