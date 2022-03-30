package fri.wof;/*
co dokodit:
- questy
  - dat pisomku
  - najst labak
- npc
  - vedieme dialog
    > oslov spoluziak
    Ahoj, bude pisomka
    1) Viem
    2) *******, to fakt?
    3) Aka pisomka?
    Vyber si: 1
    A ucil si sa?
    1) Celu noc
    2) Jasne, ze nie, to dam
    3) *******
    Vyber si: 1
    Tak to sa nemusis bat

    Ahoj, bude pisomka
    1) Viem
    2) *******, to fakt?
    3) Aka pisomka?
    Vyber si: 1
    A ucil si sa?
    1) Celu noc
    2) Jasne, ze nie, to dam
    3) *******
    Vyber si: 2
    Tak to sa nemusis bat

    Ahoj, bude pisomka
    1) Viem
    2) *******, to fakt?
    3) Aka pisomka?
    Vyber si: 1
    A ucil si sa?
    1) Celu noc
    2) Jasne, ze nie, to dam
    3) *******
    Vyber si: 3
    Uprimnu sustrast

    Ahoj, bude pisomka
    1) Viem
    2) *******, to fakt?
    3) Aka pisomka?
    Vyber si: 2
    Nie, robim si srandu

    Ahoj, bude pisomka
    1) Viem
    2) *******, to fakt?
    3) Aka pisomka?
    Vyber si: 3
    Obhajoba BP. Sach-mat

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

import fri.wof.hra.Hra;

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
