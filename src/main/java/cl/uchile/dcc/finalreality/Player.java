package cl.uchile.dcc.finalreality;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.player.AbstractPlayerCharacter;
import cl.uchile.dcc.finalreality.model.weapon.Axe;
import cl.uchile.dcc.finalreality.model.weapon.Bow;
import cl.uchile.dcc.finalreality.model.weapon.Knife;
import cl.uchile.dcc.finalreality.model.weapon.Staff;
import cl.uchile.dcc.finalreality.model.weapon.Sword;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import java.util.ArrayList;

public class Player {

  private final AbstractPlayerCharacter character1;
  private final AbstractPlayerCharacter character2;
  private final AbstractPlayerCharacter character3;
  private final AbstractPlayerCharacter character4;
  public final ArrayList<Weapon> inventory = new ArrayList<>();

  public Player(AbstractPlayerCharacter character1, AbstractPlayerCharacter character2,
                AbstractPlayerCharacter character3, AbstractPlayerCharacter character4) {
    this.character1 = character1;
    this.character2 = character2;
    this.character3 = character3;
    this.character4 = character4;
  }


  public void setInventory() throws InvalidStatValueException {
    Axe axe = new Axe("Axe", 30, 30);
    inventory.add(axe);
    Bow bow = new Bow("Bow", 15, 20);
    inventory.add(bow);
    Knife knife = new Knife("Knife", 20, 30);
    inventory.add(knife);
    Staff staff = new Staff("Staff", 15, 30, 22);
    inventory.add(staff);
    Staff staff2 = new Staff("Staff2", 20, 15, 18);
    inventory.add(staff2);
    Sword sword = new Sword("Sword", 25, 30);
    inventory.add(sword);
  }

}
