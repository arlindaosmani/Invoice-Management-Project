import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.text.*;

public class InvoiceReader{

    private GregorianCalendar time = new GregorianCalendar();
    private int how_many;
    private String[] produktet; 
    private double[] cmimet;
    private double totali, Finaltotali, totaliTvsh;
    private int h=190, w=30, height=400;
    private DecimalFormat format= new DecimalFormat("0.00");
    
    public String getTime(Graphics g){
        String timee="Ora: "+time.get(Calendar.HOUR_OF_DAY)+":"+time.get(Calendar.MINUTE), AM_PM=""+time.get(Calendar.AM_PM);
        if(AM_PM.equals("0")){
            AM_PM="AM";}
        else{AM_PM="PM";}
        return timee+AM_PM;
    }
   
    public String getLocation(Graphics g){
        String lokacioni= JOptionPane.showInputDialog("Shkruaj lokacionin e ndermarrjes: ");
        return lokacioni;
    }

    public String getDate(Graphics g){
        String data="" +(time.get(Calendar.DATE))+"/"+((time.get(Calendar.MONTH))+1)+"/"+(time.get(Calendar.YEAR));
        return data;
    }

    public double getTvsh(){
        return 0.18; }

    public void setArtikujt(){
        how_many= Integer.parseInt(JOptionPane.showInputDialog("Sa artikuj doni ti regjistroni?"));

        if(how_many<1){
            int vlera= JOptionPane.showConfirmDialog(null, "Ju keni dhene vleren "+how_many+" per artikuj"+ '\n' +"Deshironi te jepni nje vlere tjeter, pasi qe "+how_many+" nuk eshe valide", "Select an Option...",
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);// 0=yes, 1=no, 2=cancel

            if(vlera==0){
                how_many= Integer.parseInt(JOptionPane.showInputDialog("Sa artikuj doni ti regjistroni?"));
            }
            else{System.exit(0);}
            if(how_many<1){ JOptionPane.showMessageDialog(null, "Error: keni dhene vlere jo-valide " + how_many);
                System.exit(0);}

        }
        produktet= new String[how_many];
        cmimet=new double[how_many];

        for(int i=0; i!=produktet.length; i++){

            String inputi=JOptionPane.showInputDialog("Shkruaj emrin e produktin");

            if(inputi==null || inputi.equals("")){

                int hyrje= JOptionPane.showConfirmDialog(null, "Ju nuk keni shkruar emer te produktit."+ '\n' +"Deshironi te nderpritni procesin?", "Zgjidhni njerin opsion..",
                        JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);// 0=yes, 1=no, 2=cancel

                if(hyrje==0 || hyrje==2){
                    System.exit(0);}
                else{ inputi=JOptionPane.showInputDialog("Shkruaj emrin e produktin");}
            }
            else{
                produktet[i]=inputi;}
            String cmimi=JOptionPane.showInputDialog("Shkruaj cmimin(€) e produktit "+ produktet[i]);
            if(cmimi==null || cmimi.equals("")){
                cmimet[i]=0.0;}
            else{
                double Scmimi=Double.parseDouble(cmimi);
                cmimet[i]=Scmimi;}

            System.out.println((i)+". \""+produktet[i]+"\" Cmimi: " + cmimet[i]+" Euro");
        }
    }
    
public int howmany(){
    return how_many;}

    public void getArtikujt(Graphics g, int i){
        boolean ok= true;
        while(ok){
        int increment=20;
                  String hyrja=JOptionPane.showInputDialog("Zgjidh produktet  ");
                  if(hyrja==null || hyrja.equals("")){ok=false;}
                     else{
                        int gt=Integer.parseInt(hyrja);
                  if(gt<0 || gt>how_many){ok=false;}
                     else{ 
                           int sasia= Integer.parseInt(JOptionPane.showInputDialog("Sa produkte "+ produktet[gt]+" deshironi ti bleni"));
                              this.totali=totali;
                              this.Finaltotali=Finaltotali;
                            totali =  (cmimet[gt]*sasia)+ totali;
                            //  System.out.println("____");
                            //  System.out.print("Totali= "+cmimet[gt]+" x " + sasia+ " = "+format.format(totali));
                             totaliTvsh= (totali*0.18)+totali;
                            //  System.out.println("  Totali me tvsh "+format.format(totaliTvsh));
                             Finaltotali= totaliTvsh;
                              i=new Integer(JOptionPane.showInputDialog("Shkruaj numrin e artikullit")).intValue();

g.drawString("                                                           "+ sasia+" x "+ cmimet[gt]+"       "+format.format((cmimet[gt]*sasia)), w, 110+increment*i);
g.drawString(produktet[gt]+"", w, 110+increment*i);                                          
                             }
}
increment+=20;
}}
    
    public double getTotal(){
    this.totali=totali;
        return totali;}

    public double getTotalTvsh(){
    this.totaliTvsh= totaliTvsh;
        return totaliTvsh;}
        
        public double getFinalTotalin(){
        this.Finaltotali=Finaltotali;
        return Finaltotali;}
}