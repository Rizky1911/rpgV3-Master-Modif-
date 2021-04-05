import java.util.ArrayList;

/*
    class turunan dari item untuk menampung beberapa item
*/
public class Chest extends Item {

    public Chest(String nama) {
        super(nama);

        arrAksi.add("Deskripsi Chest");
        arrAksi.add("Buka Chest");
    }

    @Override
    public ArrayList<String> getAksi() { return arrAksi; }
}
