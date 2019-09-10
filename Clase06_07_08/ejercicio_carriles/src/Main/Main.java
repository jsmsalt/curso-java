package Main;

import java.util.ArrayList;

public class Main {

    public static ArrayList<Integer> carriles = new ArrayList<Integer>();

    public static void main(String[] args) {
        carriles.add(0);
        carriles.add(1);
        carriles.add(0);
        carriles.add(0);
        carriles.add(1);
        carriles.add(1);
        carriles.add(0);
        System.out.println("Cantidad de cruces: " + cantidadDeCrucesPosibles());
    }

    public static int cantidadDeCrucesPosibles() {
        if (carriles.size() > 0) {
            int cantidad = 0;
            for (int i = 0; i < carriles.size(); i++) {
                if (carriles.get(i) == 0) {
                    for (int j = 0; j < carriles.size(); j++) {
                        if (carriles.get(i) != carriles.get(j)) {
                            cantidad++;
                        }
                    }
                }
            }

            return cantidad;
        }

        return 0;
    }

    public static int cantidadDeCrucesCarrilesContiguos() {
        if (carriles.size() > 0) {
            int cantidad = 0;
            for (int i = 0; i < (carriles.size()) - 1; i++) {
                if (carriles.get(i) != carriles.get(i + 1)) {
                    cantidad++;
                }
            }

            return cantidad;
        }

        return 0;
    }
}
