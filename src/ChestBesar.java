/*
    class turunan dari chest untuk menampung 2 item dan item tersebut dapat diambil
*/
public class ChestBesar extends Chest {
    private Item objItem1, objItem2;

    public ChestBesar(String nama, String item1, String deskripsi1, String item2, String deskripsi2) {
        super(nama);

        objItem1 = new Item(item1);
        objItem1.setDeskripsi(deskripsi1);
        objItem2 = new Item(item2);
        objItem2.setDeskripsi(deskripsi2);
    }

    @Override
    public void prosesAksi(int subPil) {
        //1: deskripsi chest
        //2: buka chest
        if (subPil == 1) {
            System.out.println(deskripsi);
        } else if (subPil == 2) {
            if (objGameInfo.getObjPlayer().cariItem("Kunci Mysterius")){
                if (objItem1==null && objItem2==null) {
                    System.out.println("Chest kosong");
                } else {
                    System.out.println("Anda mendapatkan "+objItem1.nama+" dan "+objItem2.nama+" dari dalam chest kecil");
                    objGameInfo.getObjPlayer().addItem(objItem1);     //tambahkan  objek ini pada player
                    objItem1 = null;
                    objGameInfo.getObjPlayer().addItem(objItem2);     //tambahkan  objek ini pada player
                    objItem2 = null;
                }
            }else {
                System.out.println("Memerlukan Kunci untuk Membuka chest");
            }

        }
    }
    @Override
    public void setObjGameInfo(GameInfo objGameInfo) {
        this.objGameInfo = objGameInfo;
        objItem1.setObjGameInfo(objGameInfo);
        objItem2.setObjGameInfo(objGameInfo);
    }
}
