package cl.uchile.dcc.finalreality.model.character;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.Require;
import cl.uchile.dcc.finalreality.model.character.player.AbstractPlayerCharacter;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;

/**
 * A class that holds all the information of a single enemy of the game.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Kathleen Kohler~
 */
public class Enemy extends AbstractCharacter {

  private final int weight;

  private final int damage;

  /**
   * Creates a new enemy with a name, a weight and the queue with the characters ready to
   * play.
   */
  public Enemy(@NotNull final String name, final int weight, int maxHp, int defense, int damage,
               @NotNull final BlockingQueue<GameCharacter> turnsQueue)
      throws InvalidStatValueException {
    super(name, maxHp, defense, turnsQueue);
    Require.statValueAtLeast(1, weight, "Weight");
    this.weight = weight;
    this.damage = damage;
  }


  /**
   * Sets a scheduled executor to make this character (thread) wait for {@code speed / 10}
   * seconds before adding the character to the queue.
   */
  public void waitTurn() {
    scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    scheduledExecutor.schedule(
            /* command = */ this::addToQueue,
            /* delay = */ this.getWeight() / 10,
            /* unit = */ TimeUnit.SECONDS);
  }


  /**
   * Returns the weight of this enemy.
   */
  public int getWeight() {
    return weight;
  }

  public int getDamage() {
    return damage;
  }

  @Override
  public String toString() {
    return "Enemy{weight=%d, maxHp=%d, defense=%d, name='%s'}"
            .formatted(weight, maxHp, defense, damage, name);
  }


  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof final Enemy enemy)) {
      return false;
    }
    return hashCode() == enemy.hashCode()
        && name.equals(enemy.name)
        && weight == enemy.weight
        && maxHp == enemy.maxHp
        && defense == enemy.defense
        && damage == enemy.damage;
  }

  @Override
  public int hashCode() {
    return Objects.hash(Enemy.class, name, weight, maxHp, defense);
  }

  public void atacar(AbstractPlayerCharacter character) throws InvalidStatValueException {
    character.setCurrentHp(character.getCurrentHp() - (this.getDamage()-character.getDefense()));
  }
}
