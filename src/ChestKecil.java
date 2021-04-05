/*
    class turunan dari chest untuk menampung 1 item dan item tersebut dapat diambil
*/
public class ChestKecil extends Chest {
    private Item objItem;

    public ChestKecil(String nama, String item, String deskripsi) {
        super(nama);

        //init item
        objItem = new Item(item);
        objItem.setDeskripsi(deskripsi);
    }

    @Override
    public void prosesAksi(int subPil) {
        //1: deskripsi chest
        //2: buka chest
        if (subPil == 1) {
            System.out.println(deskripsi);
        } else if (subPil == 2) {
            if (objItem==null) {
                System.out.println("Chest kosong");
            } else {
                System.out.println("Anda mendapatkan "+objItem.nama+" dari dalam chest kecil");
                objGameInfo.getObjPlayer().addItem(objItem);     //tambahkan  objek ini pada player
                objItem = null;
            }
        }
    }
    @Override
    public void setObjGameInfo(GameInfo objGameInfo) {
        this.objGameInfo = objGameInfo;
        objItem.setObjGameInfo(objGameInfo);
    }
}
