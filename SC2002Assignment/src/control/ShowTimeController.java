package control;

import java.util.ArrayList;

import entity.Cineplex;
import entity.DataPath;
import entity.Serialization;

public class ShowTimeController {
    public static void addShowTime() {
        ArrayList<Cineplex> cineplexList = (ArrayList<Cineplex>) Serialization.readSerializedObject(DataPath.CINEPLEX);
        
     
    }
}
