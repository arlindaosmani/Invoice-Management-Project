import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.lang.*;
import java.text.*;

public class InvoiceWriter extends JPanel {
    private InvoiceReader reader = new InvoiceReader();
    private int width=300, height=400;
    private static final String Produktet="Produktet", Sasia="Sasia", Cmimi="Cmimi",TVSH="TVSH E= 18,00%", Totali="TOT. NE EURO";
    private static final String TotaliPaTVSH="TOT. PA TVSH",Data="Data: ",Artikujt="ARTIKUJT: ",NrKuponit="KUPONI FISKAL NR. 001";
    private DecimalFormat format= new DecimalFormat("0.00");
    private String name="";
    private String vendi="";
    private int konvheight= reader.howmany();

    public InvoiceWriter(){
        JFrame frame = new JFrame();
        frame.getContentPane().add(this);
            if(konvheight>1){ 
           frame.setSize(width+16,(height+(konvheight*10)+40));}
                else{
                  frame.setSize(width+16,height+40);
                               }
        frame.setVisible(true);
        frame.setBackground(Color.white);
        this.repaint();
         }

    public void paintComponent(Graphics g){
        String viza="--------------------------------------------";
        Font fontSize1 = new Font( "", Font.PLAIN, 18 ), fontSize2 = new Font( "", Font.PLAIN, 12 );
        g.setColor(Color.black);
        /**/   g.setFont( fontSize1 );
        g.drawString(viza, 20, 10);
        g.drawString(viza, 20,70);
        /**/     g.setFont(fontSize2 );
        g.drawString(viza+"----------------------", 20,100);
        g.drawString(Produktet, 20, 90);
        g.drawString(Sasia, width-90, 90);
        g.drawString(Cmimi, width-50, 90);
        g.drawString(viza+"----------------------", 20,height-180);
        g.drawString(Totali ,20, height-170);
        g.drawString(TVSH ,20, height-150);
        g.drawString(""+reader.getTvsh() , width-40, height-150);
        g.drawString(TotaliPaTVSH ,20, height-130);
        g.drawString(Artikujt+" "+ reader.howmany(), 100, height-70);
        g.drawString(NrKuponit, 20, height-50);
        g.drawString(Data+reader.getDate(g),25, height-10);
        g.drawString(reader.getTime(g), width-100, height-10);
        /**/   g.setFont( fontSize1 );
        String emri= JOptionPane.showInputDialog("Shkruaj emrin e ndermarrjes ");
        if(emri != null){
            name=emri;
            g.drawString("\""+name+"\"", width/3, 40);
        } else{System.exit(0);}
        /**/   g.setFont( fontSize2 );
        String lok=JOptionPane.showInputDialog("Shkruaj lokacionin e ndermarrjes");
        if(lok != null){
            vendi=lok;
            g.drawString(vendi, width/3,55);        }
            else{System.exit(0);}
        reader.setArtikujt();
        reader.getArtikujt(g,konvheight);  
        /**/g.drawString(format.format(reader.getFinalTotalin())+"",width-40, height-170);
               g.drawString(format.format(reader.getTotal())+"", width-40, height-130);
    }
}
