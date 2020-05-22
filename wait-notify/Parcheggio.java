package com.mycompany.scuolajava;

public class Parcheggio 
{
    private int nPosti;
    
    public Parcheggio(int nPosti)
    {
        this.nPosti = nPosti;
    }

    public int getPosti()
    {
        return nPosti;
    }
    
    public synchronized void entra()
    {
        while (nPosti == 0) 
        {
            try
            {
                wait();
            } catch (InterruptedException e) {}
        }
        nPosti--;
    }
    
    public synchronized void esci()
    {
        nPosti++;
        notifyAll();
    }
}