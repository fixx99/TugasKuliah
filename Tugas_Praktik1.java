package tugas_praktik1;
import java.util.LinkedList;

public class Tugas_Praktik1 {
    public static void main(String[] args) {
       //1 deklarasi integer
       int jumlahBaris = 30;
        System.out.println(jumlahBaris);
       
       //2 deklarasi string
       String kalimatBaru = "Deklarasi tipe data String";
        System.out.println(kalimatBaru);
        
       //3 array satu dimensi
       int [] empatAngka = new int [4];
       empatAngka [0] = 07;
       empatAngka [1] = 10;
       empatAngka [2] = 20;
       empatAngka [3] = 23;
       System.out.println("== menampilkan array satu dimensi ==");
       for(int i = 0; i < 4; i++){
           System.out.println(empatAngka[i]);
       }
       
      //4 
       String [][] alfabet = {
           {"p", " s", " n"},
           {"w", " l", " b"},
           {"f", " r", " e"}
        };
        System.out.println("== menampilkan array dua dimensi ==");
        for(int a = 0; a < alfabet.length; a++){
            for(int b = 0; b < alfabet[a].length; b++){
                System.out.print(alfabet [a][b]);
            }
           System.out.println("");
        }
       
       //5 deklarasi linkedlist
       LinkedList<Integer> listAngka = new LinkedList<Integer>();
       
       System.out.println("== deklarasi linkedlist ==");
       
       listAngka.add (26);
       listAngka.add (8);
       listAngka.add (23);
       listAngka.add (24);
       listAngka.add (16);
       
       int x = 0;
       for(Integer i : listAngka){
           System.out.println("index ke " + x + " : " + i);x++;
       };
        System.out.println("jumlah index : " + listAngka.size());
    }
    
}
