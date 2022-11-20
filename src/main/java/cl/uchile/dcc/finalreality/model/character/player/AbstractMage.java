package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidEquippedWeapon;
import cl.uchile.dcc.finalreality.exceptions.InvalidSpell;
import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.Require;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import java.util.concurrent.BlockingQueue;
import org.jetbrains.annotations.NotNull;


/**
 * An abstract class that holds all the information of a mage in the game.
 *
 * <p>All mage have a name, a maximum amount of <i>hit points</i>
 * (maxHp), a defense value, a maximum amount of <i>mana</i>
 * (maxMp), a queue of {@link GameCharacter}s that are
 * waiting for their turn ({@code turnsQueue}), and can equip a {@link Weapon}.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Kathleen Kohler~
 */
public abstract class AbstractMage extends AbstractPlayerCharacter implements MageCharacter {
  protected int currentMp;
  protected final int maxMp;

  /**
     * Creates a new character.
     *
     * @param name
     *     the character's name
     * @param maxHp
     *     the character's max hp
     * @param defense
     *     the character's defense
     * @param turnsQueue
     *     the queue with the characters waiting for their turn
     */
  protected AbstractMage(final @NotNull String name, final int maxHp, final int defense,
                        int maxMp, final @NotNull BlockingQueue<GameCharacter> turnsQueue)
            throws InvalidStatValueException {
    super(name, maxHp, defense, turnsQueue);
    Require.statValueAtLeast(0, maxMp, "Max MP");
    this.maxMp = maxMp;
    this.currentMp = maxMp;
  }

  @Override
  public int getCurrentMp() {
    return currentMp;
  }

  @Override
  public void setCurrentMp(int currentMp) throws InvalidStatValueException {
    Require.statValueAtLeast(0, currentMp, "Current MP");
    Require.statValueAtMost(maxMp, currentMp, "Current MP");
    this.currentMp = currentMp;
  }

  @Override
  public int getMaxMp() {
    return maxMp;
  }

  @Override
  public void poison(Enemy enemy) throws InvalidSpell {
    throw new InvalidSpell();
  }

  @Override
  public void thunder(Enemy enemy) throws InvalidSpell {
    throw new InvalidSpell();
  }

  @Override
  public void fire(Enemy enemy) throws InvalidSpell {
    throw new InvalidSpell();
  }

  @Override
  public void paralysis(Enemy enemy) throws InvalidSpell {
    throw new InvalidSpell();
  }

  @Override
  public void cure(AbstractPlayerCharacter character) throws InvalidSpell {
    throw new InvalidSpell();
  }

}
