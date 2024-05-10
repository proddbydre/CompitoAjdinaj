package pista;

public class Pilota extends Thread
{
    private int num;
    private Pista pista; 

    public Pilota(int num, Pista pista)
    {
        this.num = num;
        this.pista = pista;
    }

    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }
    
    @Override
    public void run()
    {
        // Entra in pista

        try
        {   
            // Entra nello spogliatoio
            pista.entrataSpogliatoio(num);
            int tempo1 = 2000  + (int) Math.random() * 2000;
            sleep(tempo1);

            // Esce dallo spogliatoio per entrare in pista
            pista.uscitaSpogliatoio(num);

            // Entra in Pista
            pista.gareggia(num);
            int tempo2 = 2000  + (int) Math.random() * 7000;
            sleep(tempo2);

            // Esce dalla pista
            pista.pit(num);

            // Entra nello spogliatoio per ricambiarsi
            pista.entrataSpogliatoio(num);
            int tempo3 = 2000  + (int) Math.random() * 2000;
            sleep(tempo3);

            // Esce dallo spogliatoio e torna a casa
            pista.uscitaSpogliatoio(num);



        }catch (InterruptedException e){
    
            e.printStackTrace();
        }
    }
}
    

