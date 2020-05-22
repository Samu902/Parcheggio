package com.mycompany.scuolajava;

import java.util.concurrent.Semaphore;

public class Parcheggio 
{
    private int nPosti;
    private Semaphore postiLiberi;
    private Semaphore postiOccupati;
    
    public Parcheggio(int nPosti)
    {
        this.nPosti = nPosti;
        postiLiberi = new Semaphore(nPosti, true);
        postiOccupati = new Semaphore(0, true);
    }

    public int getPosti()
    {
        return nPosti;
    }
    
    public synchronized void entra()
    {
        try
        {
            postiLiberi.acquire();
        } catch (InterruptedException e) {}
        nPosti--;
        postiOccupati.release();
    }
    
    public synchronized void esci()
    {
        try
        {
            postiOccupati.acquire();
        } catch (InterruptedException e) {}
        nPosti++;
        postiLiberi.release();
    }
}
