package flowersStore.store;

import flowersStore.flowers.*;

import java.math.BigDecimal;

public class FlowerStore {
    public static BigDecimal noteCase;

    public Flowers[] sell(int roseCount, int camomileCount, int tulipCount){
        int count = roseCount + camomileCount + tulipCount;
        Flowers[] arrayFlowers = new Flowers[count];
        for (int i = 0; i < count; i++) {
            if (i < roseCount) arrayFlowers[i] = new Rose();
            else if (i >= roseCount & i < roseCount + camomileCount)
                arrayFlowers[i] = new Camomile();
            else arrayFlowers[i] = new Tulip();
        }
        BigDecimal roseCost = Rose.cost.multiply(new BigDecimal(roseCount));
        BigDecimal cammCost = Camomile.cost.multiply(new BigDecimal(camomileCount));
        BigDecimal tulpCost = Tulip.cost.multiply(new BigDecimal(tulipCount));
        if (noteCase == null) noteCase = new BigDecimal(0);
        noteCase = noteCase.add(roseCost.add(cammCost.add(tulpCost)));
        return arrayFlowers;
    }
    public Flowers[] sellSequence(int roseCount, int camomileCount, int tulipCount){
        int count = roseCount + camomileCount + tulipCount;
        Flowers[] arrayFlowers = new Flowers[count];
        BigDecimal roseCost = Rose.cost.multiply(new BigDecimal(roseCount));
        BigDecimal cammCost = Camomile.cost.multiply(new BigDecimal(camomileCount));
        BigDecimal tulpCost = Tulip.cost.multiply(new BigDecimal(tulipCount));
        for (int i = 0; i < count;) {
            if (roseCount > 0){
                arrayFlowers[i++] = new Rose();
                roseCount--;
            }
            if (camomileCount > 0){
                arrayFlowers[i++] = new Camomile();
                camomileCount--;
            }
            if (tulipCount > 0){
                arrayFlowers[i++] = new Tulip();
                tulipCount--;
            }
        }
        if (noteCase == null) noteCase = new BigDecimal(0);
        noteCase = noteCase.add(roseCost.add(cammCost.add(tulpCost)));
        return arrayFlowers;
    }
}
