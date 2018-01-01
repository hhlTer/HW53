package flowersStore.store;

import flowersStore.flowers.Camomile;
import flowersStore.flowers.Flowers;
import flowersStore.flowers.Rose;
import flowersStore.flowers.Tulip;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public interface FlowerSave {
    static void save(Flowers[] buket, File filename){
        try{
            StringBuilder dataFile = new StringBuilder();
            FileWriter writer = new FileWriter(filename,false);
            for (Flowers fl:
                 buket) {
                dataFile.append(fl.getClass().getName().replace('.', ' ').split(" ")[2]).append("\n");
            }
            writer.write(dataFile.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static Flowers[] load(File file){
        int count = 0;

        try {
            Scanner reader = new Scanner(file);
            while (reader.hasNext()){
                count++;
                reader.nextLine();
            }
        }catch (IOException e){
        }
        Flowers[] buket = new Flowers[count];
        try {
            FileReader reader = new FileReader(file);
            int c;
            int i = 0;
            StringBuilder s = new StringBuilder();
            while ((c=reader.read()) != -1){
                if ((char)c != '\n') s.append((char) c);
                else {
                    switch (s.toString()) {
                        case "Rose":
                            buket[i] = new Rose();
                            break;
                        case "Tulip":
                            buket[i] = new Tulip();
                            break;
                        default:
                            buket[i] = new Camomile();
                            break;
                    }
                    i++;
                    s = new StringBuilder();
                }
            }
        }catch (IOException e){

        }
        return buket;
    }
}
