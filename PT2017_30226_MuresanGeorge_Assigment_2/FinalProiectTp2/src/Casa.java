import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by George on 4/8/2017.
 */
public class Casa extends Thread {
    private LinkedBlockingQueue<Client> listaclienti= new LinkedBlockingQueue<>(100);
    private Interfata interfata;
    private CURtime tc;
    private Integer nrCasa;
    public LinkedBlockingQueue<Client> getListaclienti() {
        return listaclienti;
    }

    public void setListaclienti(LinkedBlockingQueue<Client> listaclienti) {
        this.listaclienti = listaclienti;
    }

    public Casa(String name,Interfata interfata,CURtime tc,Integer nrCasa) {
        super(name);
        this.nrCasa=nrCasa;
        this.interfata = interfata;
        this.tc=tc;
        //this.listaclienti = listaclienti;
    }
    public void run()
    {
       try{
           while(true)
           {
                    Client c1=listaclienti.peek();
                    if(c1!=null)
                    {
                        int timpdeasteptare = c1.getTimp();

                        sleep(timpdeasteptare * 1000);

                        stergeclientdinlista();
                    }
           }

        }
        catch(InterruptedException e)
        {
            System.out.println("Intrerupere casa ");
        }
    }

    public synchronized void adaugaclientinlista(Client c )
    {
        listaclienti.add(c);
        notifyAll();
    }
    public synchronized void stergeclientdinlista() throws InterruptedException
    {
        while(listaclienti.size()==0)
            wait();
        Client cl=listaclienti.peek();
        listaclienti.remove(cl);
        System.out.println("Clientul "+cl.getNrc()+" a parasit "+getName()+"  "+" la ora:");
       // String s=tc.ceas();
        //interfata.init(s);
        interfata.init("Clientul "+cl.getNrc()+" a parasit "+getName());
        interfata.stopCasa(nrCasa);
        //tc.ceas();
        notifyAll();

    }
    public synchronized int lungimecoada(){
        notifyAll();
        int sizecoada=listaclienti.size();
        return sizecoada;
    }
}
