package pista;

public class Pista 
{
    private int pilotiMaxPista = 4;
    private int pilotiMaxSpogliatoio = 2; 


    public synchronized void entrataSpogliatoio(int num)
    {
        while(pilotiMaxSpogliatoio==0)
        {
            System.out.println("Lo spogliatoio ha raggiunto il massimo di piloti, il pilota: " + num + " attende il suo turno");
            try 
            {
                wait();
            } catch (InterruptedException e) 
            {

                e.printStackTrace();
            }
        }

        if(pilotiMaxSpogliatoio>0)
        {
            pilotiMaxSpogliatoio--;
        }
        System.out.println("Il pilota " + num + " entra nello spogliatoio");
    }

    public synchronized void uscitaSpogliatoio(int num) 
    {
        pilotiMaxSpogliatoio++;
        System.out.println("Il pilota " + num + " ha lasciato lo spogliatoio.");
        notify();
    }




    public synchronized void gareggia(int num)
    {
        while (pilotiMaxPista == 0) 
        {
            System.out.println("La pista ha raggiunto il massimo di piloti, il pilota: " + num + " attende il suo turno");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    
        if (pilotiMaxPista > 0) 
        {
            pilotiMaxPista--;
        }
    
        System.out.println("Il pilota " + num + " entra in pista e gareggia");
    }
    
    public synchronized void pit(int num) 
    {
        pilotiMaxPista++;
        System.out.println("Il pilota: " + num + " rientra nei pit e aspetta per entrare nello spogliatoio");
        notify();  
    }

}

