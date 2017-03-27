package com.wolframtheta;

import java.util.List;

/**
 * @(#)Personaje.java
 *
 *
 * @author
 * @version 1.00 2009/2/28
 */


public class Personaje {

	String nombre;
	int turno;

    List<String> sorpresa;

    int pifia = 0;

    int abierta = 0;
	public Personaje(final String n, final int t) {
		nombre = new String(n);
		turno = t;
	}

	public String getNombre()
	{
		return nombre;
	}

	public int getTurno()
	{
		return turno;
	}

    public void setPifia(final int pifia)
    {
        this.pifia = pifia;
    }

    public void setAbierta(final int abierta)
    {
        this.abierta = abierta;
    }

    public int getPifia()
    {
        return this.pifia;
    }

    public int getAbierta()
    {
        return this.abierta;
    }

}