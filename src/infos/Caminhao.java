package infos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Caminhao {

    public static List<Integer> PorteCaminhoes = new ArrayList<Integer>(Arrays.asList(0, 1, 2));

    public static boolean verficacao() {
        if (PorteCaminhoes.contains(Menu.respostaCaminhao)) {
            return true;
        } else {
            return false;
        }
    }
    
   



}
