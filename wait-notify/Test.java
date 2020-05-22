package com.mycompany.scuolajava;

import java.util.ArrayList;

public class Test 
{
    public static void main(String[] args)
    {
        Parcheggio p = new Parcheggio(10);
        ArrayList<Auto> auto = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            auto.add(new Auto(i + "", p));
    }
}
