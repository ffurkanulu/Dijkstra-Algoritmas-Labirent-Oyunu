
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.channels.ScatteringByteChannel;
import java.security.spec.RSAOtherPrimeInfo;
import java.sql.SQLOutput;
import java.util.*;
import java.util.Timer;

public class Program extends JFrame {
    public static int furkan;

    public Program(String title) throws HeadlessException {
        super(title);
    }

    public static void main(String[] args) throws IOException {





      int[][] matris = new int[11][13];

        int eleman;
      try {
         File f=new File("harita.txt");
          Scanner dosya=new Scanner(f);
          for(int a=0;a<11;a++){
              for(int b=0;b<13;b++){
                  eleman=dosya.nextInt();
                  matris[a][b]= eleman;
              }
          }
      }catch (Exception e){
          System.err.println("Hata");
      }

//skoru gosterecek olan label
        JLabel puanlabel=new JLabel();
        puanlabel.setSize(76,63);
        Font f=new Font("sansserif", Font.BOLD, 33);
        puanlabel.setFont(f);


        JFrame jFrame=new JFrame();
        jFrame.setResizable(false);
        JPanel jPanel=new JPanel(new GridLayout(11,13));
        Border blackline = BorderFactory.createLineBorder(Color.black);
        JPanel[][] alanlar=new JPanel[11][13];
        for(int a=0;a<11;a++){
            for(int b=0;b<13;b++){
                JPanel jPanel1=new JPanel();

                jPanel1.setBorder(blackline);
                jPanel.add(jPanel1);


                alanlar[a][b]=jPanel1;
            }}
        for(int a=0;a<11;a++){
            for(int b=0;b<13;b++){
                if(matris[a][b]==0){
                    alanlar[a][b].setBackground(Color.gray);
                }
            }
        }
        KeyListener keyListenerr=new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                furkan=e.getKeyCode();
                System.out.println(furkan);

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        };

       jPanel.addKeyListener(keyListenerr);
        jPanel.setFocusable(true);
        jFrame.add(jPanel);
        // jFrame.setFocusable(false);
        jFrame.setSize(1000,700);

        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);


        Lokasyon lokasyon=new Lokasyon(5,6);
        //kapilar??n lokasyonlar??n?? tutan arrlist
        ArrayList<Lokasyon> lokasyonlar=new ArrayList<>();
        Lokasyon lokasyonA=new Lokasyon(0,3);
        Lokasyon lokasyonB=new Lokasyon(0,10);
        Lokasyon lokasyonC=new Lokasyon(5,0);
        Lokasyon lokasyonD=new Lokasyon(10,3);
        lokasyonlar.add(lokasyonA);lokasyonlar.add(lokasyonB);lokasyonlar.add(lokasyonC);lokasyonlar.add(lokasyonD);
        ArrayList<Integer> dizi=new ArrayList<>();
        dizi.add(0);dizi.add(1);dizi.add(2);dizi.add(3);
        Collections.shuffle(dizi);

        Azman azman=new Azman(lokasyonlar.get(dizi.get(0)));
        int ax=lokasyonlar.get(dizi.get(0)).x;
        int ay=lokasyonlar.get(dizi.get(0)).y;


        Gargamel gargamel=new Gargamel(lokasyonlar.get(dizi.get(1)));
        int gx=lokasyonlar.get(dizi.get(1)).x;
        int gy=lokasyonlar.get(dizi.get(1)).y;


        ShortestPath shortestPath=new ShortestPath();
        //dist azman icin dist1 gargamel i??in
        dist dist=new dist();
        dist dist1=new dist();

         Operasyonlar operasyonlar=new Operasyonlar();
        System.out.println("Hangi karakterle oynamak istersiniz?");
        System.out.println("Tembel ??irin i??in 1 ve enter'a bas??n.");
        System.out.println("Gozluklu ??irin i??in 2 ve enter'a bas??n.");
        Scanner scanner=new Scanner(System.in);
        Scanner scanner1=new Scanner(System.in);
        Scanner scanner2=new Scanner(System.in);
        String oyuncuid=scanner.nextLine();
        //Objeler icin dizi
        int dizi2[]=new int[77];
           for(int a=0;a<77;a++){
               dizi2[a]=a;
           }
           Random random=new Random();
        Timer myTimer =new Timer();
        //dusman yollar matrisi kullanmak ??c??n
        Dusman dusman=new Dusman();
        altin[] altinlar=new altin[5];
        TimerTask altinOlusturucu=new TimerTask() {
            @Override
            public void run() {

                for(int a=0;a<5;a++){

                    int index=random.nextInt(dizi2.length);
                     altin altin1=new altin(dusman.dusmanyollarkod[index][2],dusman.dusmanyollarkod[index][1],5);
                    altinlar[a]=altin1;
                }
            }
        };
            mantar[] mantarlar=new mantar[1];
        TimerTask mantarOlusturucu=new TimerTask() {
            @Override
            public void run() {
                int index=random.nextInt(dizi2.length);
            mantar mantar=new mantar(dusman.dusmanyollarkod[index][2],dusman.dusmanyollarkod[index][1],50);
            mantarlar[0]=mantar;


            }
        };





        if(oyuncuid.equals("1")){

            Oyuncu tembelSirin=new TembelSirin("1","Tembel Sirin",true,lokasyon,"1","Tembel Sirin",true,20);
            try{
                Thread.sleep(2000);
            }catch(InterruptedException e){}
            System.out.println("Tembel Sirini sectiniz");
            //ilk ad??m?? b??z c??zd??r??yoruz kodda yazd??g??m??zla ekranda olanlar??n e??zamanl?? olmas?? i??in.
            int azmanlokasyonkod=operasyonlar.Lokasyon??evirici(azman.lokasyon.y,azman.lokasyon.x);
            int gargamellokasyonkod=operasyonlar.Lokasyon??evirici(gargamel.lokasyon.y,gargamel.lokasyon.x);
            int dostlokasyon=operasyonlar.Lokasyon??evirici(tembelSirin.lokasyon.y,tembelSirin.lokasyon.x);
            dist=shortestPath.yolbulucu(azmanlokasyonkod,dostlokasyon);
            dist1=shortestPath.yolbulucu(gargamellokasyonkod,dostlokasyon);

            jPanel= operasyonlar.haritaciz(1,dist,dist1,jPanel,alanlar,tembelSirin.lokasyon.y,tembelSirin.lokasyon.x,gx,gy,ax,ay);
            myTimer.schedule(altinOlusturucu,0,5000);
            myTimer.schedule(mantarOlusturucu,0,7000);

            while (operasyonlar.OyunBittiMi(lokasyon,tembelSirin)==-1){


                System.out.println("dost lokasyon x:"+tembelSirin.lokasyon.x+" dost lokasyon y:"+tembelSirin.lokasyon.y);
                System.out.println("azman lokasyon x"+azman.lokasyon.x+"azman lokasyon y:"+azman.lokasyon.y);
                System.out.println("gargamel lokasyon x"+gargamel.lokasyon.x+" gargamal lokasyon y:"+gargamel.lokasyon.y);






                System.out.println("Hangi Y??ne hareket edeceksiniz");
                try{
                    Thread.sleep(1000);
                }catch(InterruptedException e){}

                //tembelSirin.HareketEt(yon,lokasyon,matris);
                jPanel=operasyonlar.yolTemizle(jPanel,alanlar,matris);

                tembelSirin.HareketEt(furkan,lokasyon,matris);
                if(gargamel.lokasyon.x==tembelSirin.lokasyon.x && gargamel.lokasyon.y==tembelSirin.lokasyon.y ){
                    System.out.println("Garagamel yakalad??");
                    tembelSirin.setSkor(tembelSirin.Skor-15);
                    System.out.println("Skor: "+tembelSirin.Skor);
                    gargamel.lokasyon.x=gx;
                    gargamel.lokasyon.y=gy;
                    azman.lokasyon.x=ax;
                    azman.lokasyon.y=ay;

                }
                if( azman.lokasyon.x==tembelSirin.lokasyon.x && azman.lokasyon.y==tembelSirin.lokasyon.y){
                    System.out.println("Azman yakald??");
                    tembelSirin.setSkor(tembelSirin.Skor-5);
                    System.out.println("Skor: "+tembelSirin.Skor);
                    gargamel.lokasyon.x=gx;
                    gargamel.lokasyon.y=gy;
                    azman.lokasyon.x=ax;
                    azman.lokasyon.y=ay;

                }
                for(int a=0;a<5;a++){
                    if(tembelSirin.lokasyon.y==altinlar[a].y && tembelSirin.lokasyon.x==altinlar[a].x){
                        System.out.println("PUAN ARTTI");
                        tembelSirin.setSkor(tembelSirin.Skor+5);
                        System.out.println("Skor: "+tembelSirin.Skor);
                    }
                }
                if(tembelSirin.lokasyon.x==mantarlar[0].x && tembelSirin.lokasyon.y==mantarlar[0].y){
                    System.out.println("PUAN ARTTI");
                    tembelSirin.setSkor(tembelSirin.Skor+50);
                    System.out.println("Skor: "+tembelSirin.Skor);

                }

                 azmanlokasyonkod=operasyonlar.Lokasyon??evirici(azman.lokasyon.y,azman.lokasyon.x);
                 gargamellokasyonkod=operasyonlar.Lokasyon??evirici(gargamel.lokasyon.y,gargamel.lokasyon.x);
                 dostlokasyon=operasyonlar.Lokasyon??evirici(tembelSirin.lokasyon.y,tembelSirin.lokasyon.x);
                dist=shortestPath.yolbulucu(azmanlokasyonkod,dostlokasyon);
                dist1=shortestPath.yolbulucu(gargamellokasyonkod,dostlokasyon);
                //jPanel = operasyonlar.yol??iz(dist, dist1, jPanel, alanlar,tembelSirin.lokasyon.y,tembelSirin.lokasyon.x,gargamel.lokasyon.x,gargamel.lokasyon.y,azman.lokasyon.x,azman.lokasyon.y);
                gargamel.HareketEt(dist1,tembelSirin.lokasyon.x,tembelSirin.lokasyon.y);
                azman.HareketEt(dist);

                puanlabel.setText(String.valueOf(tembelSirin.Skor));

                alanlar[0][12].setBackground(Color.white);
                alanlar[0][12].add(puanlabel);
                jPanel = operasyonlar.yol??iz(1,dist, dist1, jPanel, alanlar,tembelSirin.lokasyon.y,tembelSirin.lokasyon.x,gargamel.lokasyon.x,gargamel.lokasyon.y,azman.lokasyon.x,azman.lokasyon.y,altinlar,mantarlar[0]);


                if(gargamel.lokasyon.x==tembelSirin.lokasyon.x && gargamel.lokasyon.y==tembelSirin.lokasyon.y ){
                    System.out.println("Garagamel yakalad??");
                    tembelSirin.setSkor(tembelSirin.Skor-15);
                    System.out.println("Skor: "+tembelSirin.Skor);
                    gargamel.lokasyon.x=gx;
                    gargamel.lokasyon.y=gy;
                    azman.lokasyon.x=ax;
                    azman.lokasyon.y=ay;

                }
                if( azman.lokasyon.x==tembelSirin.lokasyon.x && azman.lokasyon.y==tembelSirin.lokasyon.y){
                    System.out.println("Azman yakald??");
                    tembelSirin.setSkor(tembelSirin.Skor-5);
                    System.out.println("Skor: "+tembelSirin.Skor);
                    gargamel.lokasyon.x=gx;
                    gargamel.lokasyon.y=gy;
                    azman.lokasyon.x=ax;
                    azman.lokasyon.y=ay;

                }
                //lokasyon ceviri b??z??m en buyuk matrisimideki kodlara cev????yor

            }
            System.out.println("OYUN B??TT??");
        }





       else {
            Oyuncu gozl??kl??Sirin=new GozlukluSirin("1","G??zl??kl?? Sirin",true,lokasyon,"2","GozlukluSirin",true,20);
            System.out.println("G??zl??kl?? Sirini sectiniz");
            int azmanlokasyonkod=operasyonlar.Lokasyon??evirici(azman.lokasyon.y,azman.lokasyon.x);
            int gargamellokasyonkod=operasyonlar.Lokasyon??evirici(gargamel.lokasyon.y,gargamel.lokasyon.x);
            int dostlokasyon=operasyonlar.Lokasyon??evirici(gozl??kl??Sirin.lokasyon.y,gozl??kl??Sirin.lokasyon.x);
            dist=shortestPath.yolbulucu(azmanlokasyonkod,dostlokasyon);
            dist1=shortestPath.yolbulucu(gargamellokasyonkod,dostlokasyon);

            jPanel= operasyonlar.haritaciz(2,dist,dist1,jPanel,alanlar,gozl??kl??Sirin.lokasyon.y,gozl??kl??Sirin.lokasyon.x,gx,gy,ax,ay);
            jPanel= operasyonlar.haritaciz(1,dist,dist1,jPanel,alanlar,gozl??kl??Sirin.lokasyon.y,gozl??kl??Sirin.lokasyon.x,gx,gy,ax,ay);
            myTimer.schedule(altinOlusturucu,0,5000);
            myTimer.schedule(mantarOlusturucu,0,7000);
            while (operasyonlar.OyunBittiMi(lokasyon,gozl??kl??Sirin)==-1){
                System.out.println("dost lokasyon x:"+gozl??kl??Sirin.lokasyon.x+" dost lokasyon y:"+gozl??kl??Sirin.lokasyon.y);
                System.out.println("azman lokasyon x"+azman.lokasyon.x+"azman lokasyon y:"+azman.lokasyon.y);
                System.out.println("gargamel lokasyon x"+gargamel.lokasyon.x+" gargamal lokasyon y:"+gargamel.lokasyon.y);

                System.out.println("Hangi Y??ne hareket edeceksiniz");



                try{
                    Thread.sleep(1000);
                }catch(InterruptedException e){}


                jPanel=operasyonlar.yolTemizle(jPanel,alanlar,matris);


               gozl??kl??Sirin.HareketEt(furkan,lokasyon,matris);


                if(gargamel.lokasyon.x==gozl??kl??Sirin.lokasyon.x && gargamel.lokasyon.y==gozl??kl??Sirin.lokasyon.y ){
                    System.out.println("Garagamel yakalad??");
                    gozl??kl??Sirin.setSkor(gozl??kl??Sirin.Skor-15);
                    System.out.println("Skor: "+gozl??kl??Sirin.Skor);
                    gargamel.lokasyon.x=gx;
                    gargamel.lokasyon.y=gy;
                    azman.lokasyon.x=ax;
                    azman.lokasyon.y=ay;

                }
                if( azman.lokasyon.x==gozl??kl??Sirin.lokasyon.x && azman.lokasyon.y==gozl??kl??Sirin.lokasyon.y){
                    System.out.println("Azman yakald??");
                    gozl??kl??Sirin.setSkor(gozl??kl??Sirin.Skor-5);
                    System.out.println("Skor: "+gozl??kl??Sirin.Skor);
                    gargamel.lokasyon.x=gx;
                    gargamel.lokasyon.y=gy;
                    azman.lokasyon.x=ax;
                    azman.lokasyon.y=ay;

                }
                for(int a=0;a<5;a++){
                    if(gozl??kl??Sirin.lokasyon.y==altinlar[a].y && gozl??kl??Sirin.lokasyon.x==altinlar[a].x){
                        System.out.println("PUAN ARTTI");
                        gozl??kl??Sirin.setSkor(gozl??kl??Sirin.Skor+5);
                        System.out.println("Skor: "+gozl??kl??Sirin.Skor);
                    }
                }
                if(gozl??kl??Sirin.lokasyon.x==mantarlar[0].x && gozl??kl??Sirin.lokasyon.y==mantarlar[0].y){
                    System.out.println("PUAN ARTTI");
                    gozl??kl??Sirin.setSkor(gozl??kl??Sirin.Skor+50);
                    System.out.println("Skor: "+gozl??kl??Sirin.Skor);

                }

                azmanlokasyonkod=operasyonlar.Lokasyon??evirici(azman.lokasyon.y,azman.lokasyon.x);
                gargamellokasyonkod=operasyonlar.Lokasyon??evirici(gargamel.lokasyon.y,gargamel.lokasyon.x);
                dostlokasyon=operasyonlar.Lokasyon??evirici(gozl??kl??Sirin.lokasyon.y,gozl??kl??Sirin.lokasyon.x);
                dist=shortestPath.yolbulucu(azmanlokasyonkod,dostlokasyon);
                dist1=shortestPath.yolbulucu(gargamellokasyonkod,dostlokasyon);
                gargamel.HareketEt(dist1,gozl??kl??Sirin.lokasyon.x,gozl??kl??Sirin.lokasyon.y);
                azman.HareketEt(dist);
                puanlabel.setText(String.valueOf(gozl??kl??Sirin.Skor));

                alanlar[0][12].setBackground(Color.white);
                alanlar[0][12].add(puanlabel);
                jPanel = operasyonlar.yol??iz(2,dist, dist1, jPanel, alanlar,gozl??kl??Sirin.lokasyon.y,gozl??kl??Sirin.lokasyon.x,gargamel.lokasyon.x,gargamel.lokasyon.y,azman.lokasyon.x,azman.lokasyon.y,altinlar,mantarlar[0]);

                if(gargamel.lokasyon.x==gozl??kl??Sirin.lokasyon.x && gargamel.lokasyon.y==gozl??kl??Sirin.lokasyon.y ){
                    System.out.println("Garagamel yakalad??");
                    gozl??kl??Sirin.setSkor(gozl??kl??Sirin.Skor-15);
                    System.out.println("Skor: "+gozl??kl??Sirin.Skor);
                    gargamel.lokasyon.x=gx;
                    gargamel.lokasyon.y=gy;
                    azman.lokasyon.x=ax;
                    azman.lokasyon.y=ay;

                }
                if( azman.lokasyon.x==gozl??kl??Sirin.lokasyon.x && azman.lokasyon.y==gozl??kl??Sirin.lokasyon.y){
                    System.out.println("Azman yakald??");
                    gozl??kl??Sirin.setSkor(gozl??kl??Sirin.Skor-5);
                    System.out.println("Skor: "+gozl??kl??Sirin.Skor);
                    gargamel.lokasyon.x=gx;
                    gargamel.lokasyon.y=gy;
                    azman.lokasyon.x=ax;
                    azman.lokasyon.y=ay;

                }



            }
            System.out.println("OYUN B??TT??");


        }


    }
}

