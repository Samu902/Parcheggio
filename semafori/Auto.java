package com.mycompany.scuolajava;

public class Auto extends Thread 
{
    private String nome;
    private Parcheggio park;
    
    public Auto (String n, Parcheggio p)
    {
        nome = n;
        park = p;
        start();
    }
    
    @Override
    public void run()
    {
        while(true)
        {
            try
            {
                sleep((long)(Math.random() * 200)); //Tempo fuori dal parcheggio
            } catch (InterruptedException e) {}
            
            synchronized (park)
            {
                park.entra();
                System.out.println("Auto " + nome + " è entrata (posti disponibili = " + park.getPosti() + ")");
            }
            
            try
            {
                sleep((long)(Math.random() * 200)); //Tempo dentro al parcheggio
            } catch (InterruptedException e) {}
            
            
            synchronized (park)
            {
                park.esci();
                System.out.println("Auto " + nome + " è uscita (posti disponibili = " + park.getPosti() + ")");
            }
        }
    }
}
