/**
 * Created by George on 4/8/2017.
 */
public class Client {
    private int nrc;
    private int timpsosire;
    private int timpplecare;
    private int timp;

    public Client(int nrc, int timpsosire, int timpplecare, int timp) {
        this.nrc = nrc;
        this.timpsosire = timpsosire;
        this.timpplecare = timpplecare;
        this.timp = timp;
    }
    public Client()
        {}

    public int getNrc() {
        return nrc;
    }

    public void setNrc(int nrc) {
        this.nrc = nrc;
    }

    public int getTimpsosire() {
        return timpsosire;
    }

    public void setTimpsosire(int timpsosire) {
        this.timpsosire = timpsosire;
    }

    public int getTimpplecare() {
        return timpplecare;
    }

    public void setTimpplecare(int timpplecare) {
        this.timpplecare = timpplecare;
    }

    public int getTimp() {
        return timp;
    }

    public void setTimp(int timp) {
        this.timp = timp;
    }

    public int randomTime(int minservtime,int maxservtime )
    {
        int randtimp=minservtime + (int)(Math.random() * ((maxservtime - minservtime) + 1));
        return randtimp;
    }

}
