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
 * @author w9101532
 */
public class Class_CyberWarrior extends Player
{  
    /**
     * Unique cards for this class.
     */
    public final Card[] CYBERWARRIOR_CARDS = new Card[] 
    {
        new Card("AI", "Armoured Imp", 3, 1, 5, 1), //3 mana, 1 attack, 5 HP, 1 cybernetic slot.
        new Card("AD", "Armoured Demon", 3, 2, 5, 1), //3 mana, 2 attack, 5 HP, 1 cybernetic slot.
        new Card("TK", "Tank", 5, 3, 7, 0), //5 mana, 3 attack, 7 HP, 0 cybernetic slot.
        new Card("TT", "Tyrant", 10, 8, 15, 0) //10 mana, 8 attack, 15 HP, 0 cybernetic slot.
    }; 
    
    /**
     * Constructor.
     * @param name  Input a name for the user. 
     */
    public Class_CyberWarrior(String name)
    {
        super("Cyber Warrior " + name);
        this.deck.addToDeck(CYBERWARRIOR_CARDS); //Add unique cards to deck.
    }   
}
