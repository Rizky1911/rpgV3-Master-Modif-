import java.util.ArrayList;

/*
    NPC merupakan turunan dari Item karena terdapat variabel dan fungsi yang sama
    sehingga untuk membuat NPC hanya perlu mengoveride beberapa fungsi dan method
    sesuai dengan apa yang akan dilakukan npc
*/
public class NPC extends Item{
    //kunci dipindahkan dari ruangan
    private Item  objKunci;
    private boolean isKenal = false;

    public NPC(String nama) {
        super(nama);
        //init kunci
        objKunci = new Item("Kunci");
        objKunci.setDeskripsi("Sebuah kunci kecil yang sudah agak berkarat");

        //aksi npc
        arrAksi.add("Perkenalan dgn NPC");
        arrAksi.add("Minta kunci");
    }
    @Override
    public void prosesAksi(int subPil) {
        //1: perkenalan dengan npc
        //2: buka pintu
        if (subPil == 1) {
            System.out.println(deskripsi);
            isKenal = true;
        } else if (subPil == 2) {
            if (isKenal) {
                //berikan kunci pada player
                if (objKunci==null) {
                    System.out.println("Masa lupa, kunci kan sudah saya berikan!");
                } else
                {
                    System.out.println("Kunci diberikan pada player");
                    objGameInfo.getObjPlayer().addItem(objKunci);     //tambahkan  objek ini pada player
                    objKunci = null;
                }

            } else {
                System.out.println("Siapa anda? kenalan dulu dong");
            }
        }
    }

    @Override
    public void setObjGameInfo(GameInfo objGameInfo) {
        this.objGameInfo = objGameInfo;
        objKunci.setObjGameInfo(objGameInfo);
    }

    @Override
    public ArrayList<String> getAksi() { return arrAksi; }
}
