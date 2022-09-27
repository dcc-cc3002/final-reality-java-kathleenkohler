package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.Require;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

/**
 * A class that holds all the information of a mage in the game.
 *
 * <p>All mage have a name, a maximum amount of <i>hit points</i>
 * (maxHp), a defense value, a maximum amount of <i>mana</i>
 * (maxMp), a queue of {@link GameCharacter}s that are
 * waiting for their turn ({@code turnsQueue}), and can equip a {@link Weapon}.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Kathleen Kohler~
 */
public abstract class AbstractMage extends AbstractPlayerCharacter{

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

    // region : ACCESSORS

    /**
     * Returns the character's current MP.
     */
    public int getCurrentMp() {
        return currentMp;
    }

    /**
     * Sets the character's current MP.
     */
    public void setCurrentMp(final int currentMp) throws InvalidStatValueException {
        Require.statValueAtLeast(0, currentMp, "Current MP");
        Require.statValueAtMost(maxMp, currentMp, "Current MP");
        this.currentMp = currentMp;
    }

    /**
     * Returns the character's max MP.
     */
    public int getMaxMp() {
        return maxMp;
    }
    // endregion



}
