package flowersStore.managment;

import flowersStore.flowers.Camomile;
import flowersStore.flowers.Flowers;
import flowersStore.flowers.Rose;
import flowersStore.flowers.Tulip;
import flowersStore.store.FlowerSave;
import flowersStore.store.FlowerStore;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        FlowerStore flowerStore = new FlowerStore();
        Flowers[] buket;
        buket = flowerStore.sell(4,6,2);
        System.out.println();

        File file = new File("store1.txt");
        FlowerSave.save(buket, file);
        outBuket(FlowerSave.load(file));

        System.out.println("notecase state: " + FlowerStore.noteCase);

        buket = flowerStore.sellSequence(2,4,6);

        FlowerSave.save(buket, file);
        outBuket(FlowerSave.load(file));

        System.out.println("notecase state: " + FlowerStore.noteCase);
//        FlowerSave flowerSave = new FlowerSave();
    }
    static void outBuket(Flowers[] buket){
        StringBuilder s = new StringBuilder();
        for (Flowers f:
                buket) {
            if (f instanceof Rose) s.append("ROSE, ");
            if (f instanceof Camomile) s.append("CAMOMILE, ");
            if (f instanceof Tulip) s.append("TULIP, ");
        }
        System.out.println(s);
    }
}
