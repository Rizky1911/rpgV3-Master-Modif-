import java.util.ArrayList;

/*
    Pintu merupakan turunan dari Item karena terdapat variabel dan fungsi yang sama
    sehingga untuk membuat Pintu hanya perlu mengoveride beberapa fungsi dan method
*/
public class Pintu extends Item {

    //constrcutor
    public Pintu(String nama) {
        super(nama);
        //init pilihan
        arrAksi.add("Deskripsikan pintu");
        arrAksi.add("Coba buka pintu");
    }
    @Override
    public void prosesAksi(int subPil) {
        //1: deskripsikan
        //2: buka pintu
        if (subPil==1) {
            System.out.println(deskripsi);
        } else if (subPil==2) {
            //cek apakah mempunyai kunci
            if (objGameInfo.getObjPlayer().cariItem("Kunci")) {
                //kunci ada, pintu terbuka
                System.out.println("Player menggunakan kunci untuk membuka pintu dan pintu terbuka!");
                objGameInfo.setGameOver(true); //game over
            } else {
                //kunci tidak ada
                System.out.println("Player mencboa membuka pintu. TERKUNCI!");
            }
        }
    }

    @Override
    public ArrayList<String> getAksi() {
        return arrAksi;
    }

}
