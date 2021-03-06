/*
 * This file is part of PocketBeasts.
 *
 * PocketBeasts is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * PocketBeasts is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Foobar.  If not, see <https://www.gnu.org/licenses/>.
 */
package uk.ac.tees.cis2001.pocketbeasts;

/**
 *
 * @author James Fairbairn
 * @author Steven Mead
 * @author w9101532
 *
 * Card object class. All cards are based on this object.
 */
public class Card implements Comparable<Card>
{

    protected String id = "";
    protected String name = "";
    protected int manaCost = 0;
    protected int attack = 0;
    protected int health = 0;
    protected int cybernetics = 0; //Amount of cybernetics a card has.
    protected CardStrategy strategy;

    Card()
    {
        
    }

    public Card(String id, String name, int manaCost, int attack, int health, int cybernetics)
    {
        this.id = id;
        this.name = name;
        this.manaCost = manaCost;
        this.attack = attack;
        this.health = health;
        this.cybernetics = cybernetics;
    }

    public Card(Card card)
    {
        this.id = card.id;
        this.name = card.name;
        this.manaCost = card.manaCost;
        this.attack = card.attack;
        this.health = card.health;
        this.cybernetics = card.cybernetics;
    }

    public String getId()
    {
        return this.id;
    }

    public String getName()
    {
        return this.name;
    }

    public int getManaCost()
    {
        return this.manaCost;
    }

    public int getAttack()
    {
        return this.attack;
    }

    public int getHealth()
    {
        return this.health;
    }

    /**
     * Attack function for all cards. Dealing out damage will damage
     * the player's card.
     * @param enemyCard     Input the selected enemy card to deal damage to.
     * @param player        Player is inputted to access table and graveyard in the damage method.
     * @param enemy         Enemy to access enemy's table and graveyard. Because cards damage each other in one go.
     * @return              TODO: Change this.
     */
    public boolean attack(Card enemyCard, Player player, Player enemy)
    {   
        enemyCard.damage(attack, enemy);
        damage(enemyCard.getAttack(), player);
        
        return true;
    }
    
    /**
     * Deducts from available HP.
     * @param amount    Damage dealt.
     * @param player    Player to access table and graveyard.    
     */
    public void damage(int amount, Player player)
    {
        this.health -= amount;
        
        if (health <= 0)
        {
            //Health wont appear in negatives on death.
            health = 0;
            
            player.graveyard.add(this);
            player.table.remove(this);
        }
    }
    
    /**
     * Sets a strategy (action) for a card.
     * @param strategy  Inputs an encapsulated strategy.
     */
    public void setStrategy(CardStrategy strategy)
    {
        this.strategy = strategy;
    }

    /**
     * After being set. Use the action.
     */
    public void useStrategy()
    {
        System.out.println(strategy.toString());
    }

    /**
     * Displays information about each card in simple text.
     * @return      return string of information. 
     */
    @Override
    public String toString()
    {
        return this.name + " (" + this.id + ") Mana Cost(" + this.manaCost + ")"
                + " Attack(" + this.attack + ") Health(" + this.health + ")\n";
    }

    @Override
    public int compareTo(Card o)
    {
        return Integer.compare(this.getManaCost(), o.getManaCost());
    }
}
