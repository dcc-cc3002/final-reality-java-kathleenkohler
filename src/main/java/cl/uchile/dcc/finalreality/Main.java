package cl.uchile.dcc.finalreality;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.Engineer;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.character.player.Thief;
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage;
import cl.uchile.dcc.finalreality.model.weapon.Axe;
import cl.uchile.dcc.finalreality.model.weapon.Bow;
import cl.uchile.dcc.finalreality.model.weapon.Knife;
import cl.uchile.dcc.finalreality.model.weapon.Staff;
import cl.uchile.dcc.finalreality.model.weapon.Sword;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {

  public static void main(String[] args)
            throws InterruptedException, InvalidStatValueException {
    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();


    var knife = new Knife("knife", 8, 20);
    System.out.println("name: " + knife.getName() + ", damage: " + knife.getDamage());
    System.out.println(" ,weight: " + knife.getWeight());
    var axe = new Axe("axe", 2, 30);
    System.out.println("name: " + axe.getName() + ", damage: " + axe.getDamage());
    System.out.println(" ,weight: " + axe.getWeight());
    var bow = new Bow("bow", 5, 25);
    System.out.println("name: " + bow.getName() + ", damage: " + bow.getDamage());
    System.out.println(" ,weight: " + bow.getWeight());
    var staff = new Staff("staff", 3, 18);
    System.out.println("name: " + staff.getName() + ", damage: " + staff.getDamage());
    System.out.println(" ,weight: " + staff.getWeight());
    var sword = new Sword("sword", 1, 7);
    System.out.println("name: " + sword.getName() + ", damage: " + sword.getDamage());
    System.out.println(" ,weight: " + sword.getWeight());

    var knife2 = new Knife("knife", 8, 20);
    System.out.println(knife2);
    var axe2 = new Axe("axe2", 2, 30);
    System.out.println(axe2);
    var bow2 = new Bow("bow", 5, 25);
    System.out.println(bow2);
    var staff2 = new Staff("staff2", 7, 28);
    System.out.println(staff2);
    var sword2 = new Sword("sword2", 1, 7);
    System.out.println(sword2);

    System.out.println(knife.equals(knife2));
    System.out.println(axe.equals(axe2));
    System.out.println(bow2.equals(bow));
    System.out.println(staff2.equals(staff));
    System.out.println(sword.equals(sword2));



    var thief1 = new Thief("thief1", 10, 10, queue);
    System.out.println("name: " + thief1.getName() + ", maxhp: " + thief1.getMaxHp());
    System.out.println(" ,defense: " + thief1.getDefense());
    thief1.equip(knife2);
    thief1.waitTurn();

    var thief2 = new Thief("thief1", 10, 10, queue);
    System.out.println(thief2);
    thief1.equip(knife2);
    thief1.waitTurn();

    var knight1 = new Knight("knight1", 13, 10, queue);
    System.out.println("name: " + knight1.getName() + ", maxhp: " + knight1.getMaxHp());
    System.out.println(" ,defense: " + knight1.getDefense());
    System.out.println(" ,currentHp: " + knight1.getCurrentHp());
    knight1.setCurrentHp(10);
    System.out.println("name: " + knight1.getName() + " ,defense: " + knight1.getDefense());
    System.out.println(" ,currentHp: " + knight1.getCurrentHp());
    knight1.equip(knife2);
    System.out.println(knight1.getName() + " equipped Weapon: " + knight1.getEquippedWeapon());
    knight1.waitTurn();

    var engineer1 = new Engineer("engineer", 18, 15, queue);
    System.out.println("name: " + engineer1.getName() + ", maxhp: " + engineer1.getMaxHp());
    System.out.println(" ,defense: " + engineer1.getDefense());
    System.out.println(engineer1.getName() + " equipped Weapon: " + engineer1.getEquippedWeapon());
    engineer1.equip(axe);
    System.out.println(engineer1.getName() + " equipped Weapon: " + engineer1.getEquippedWeapon());
    engineer1.equip(bow);
    System.out.println(engineer1.getName() + " equipped Weapon: " + engineer1.getEquippedWeapon());
    engineer1.waitTurn();

    var knight2 = new Knight("knight", 13, 10, queue);
    System.out.println(knight2);
    knight2.equip(knife2);
    knight2.waitTurn();

    var engineer2 = new Engineer("engineer", 18, 15, queue);
    System.out.println(engineer2);
    engineer2.equip(knife2);
    engineer2.waitTurn();
    System.out.println(thief2.equals(thief1));
    System.out.println(thief2.equals(knight1));
    System.out.println(knight2.equals(knight1));
    System.out.println(engineer1.equals(knight1));
    System.out.println(engineer2.equals(engineer1));


    var whitemage1 = new WhiteMage("whitemage", 10, 10, 20, queue);
    whitemage1.equip(knife2);
    whitemage1.waitTurn();

    var blackmage1 = new BlackMage("blackmage", 30, 10, 15, queue);
    System.out.println("name: " + blackmage1.getName() + ", maxhp: " + blackmage1.getMaxHp());
    System.out.println(" ,defense: " + blackmage1.getDefense());
    System.out.println(" ,maxMp: " + blackmage1.getMaxMp());
    System.out.println(blackmage1.getName() + ", current hp: " + blackmage1.getCurrentHp());
    System.out.println(" ,currentmp: " + blackmage1.getCurrentMp());
    blackmage1.setCurrentMp(10);
    blackmage1.setCurrentHp(23);
    System.out.println(blackmage1.getName() + ", current hp: " + blackmage1.getCurrentHp());
    System.out.println(" ,currentmp: " + blackmage1.getCurrentMp());
    blackmage1.equip(knife2);
    blackmage1.waitTurn();


    var whitemage2 = new WhiteMage("whitemage", 20, 10, 20, queue);
    System.out.println(whitemage2);
    whitemage2.equip(knife2);
    whitemage2.waitTurn();

    var blackmage2 = new BlackMage("blackmage", 30, 10, 15, queue);
    System.out.println(blackmage2);
    blackmage2.equip(knife2);
    blackmage2.waitTurn();

    System.out.println(blackmage2.equals(blackmage1));
    System.out.println(blackmage2.equals(whitemage1));
    System.out.println(whitemage1.equals(whitemage2));
    System.out.println(whitemage2.equals(knight1));

    var enemy = new Enemy("enemy", 20, 13, 10, queue);
    var enemy2 = new Enemy("enemy", 26, 13, 10, queue);
    System.out.println("name: " + enemy.getName() + ", weight: " + enemy.getWeight());
    System.out.println(", maxhp: " + enemy.getMaxHp() + " ,defense: " + enemy.getDefense());
    System.out.println(enemy2);
    System.out.println(enemy.equals(enemy2));
    enemy.waitTurn();
    enemy2.waitTurn();

    // Waits for 6 seconds to ensure that all characters have finished waiting
    Thread.sleep(6000);
    while (!queue.isEmpty()) {
      // Pops and prints the names of the characters of the queue to illustrate the turns
      // order
      System.out.println(queue.poll().toString());

    }
  }
}
