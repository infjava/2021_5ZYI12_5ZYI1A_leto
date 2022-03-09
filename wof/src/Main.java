/*
co dokodit:
- questy
  - dat pisomku
  - najst labak
- npc
  - vedieme dialog
  - bojovat
  - dava questy
  - obchoduje
  - priklady:
    - ucitel
    - spoluziak
- itemy
  - vypisu sa pri vstupe do miestnosti
  - zdvihnut
    > zdvihni "nazov"
  - pouzit
    > pouzi "nazov"
  - odhodit
    > odhod "nazov"
  - predat
- peniaze
- dalsie miestnosti
 */

/**
 * Hlavna trieda hry WoF s metodou main - spustanie v NB
 *
 * @author Lubomir Sadlon
 * @version 21.2.2012
 */
public class Main {

    /**
     * @param args parametre programu
     */
    public static void main(String[] args) {
        Hra hra = new Hra();
        hra.hraj();
    }
}
