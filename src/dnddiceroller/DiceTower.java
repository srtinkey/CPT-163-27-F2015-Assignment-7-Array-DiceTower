package dnddiceroller;

import java.util.ArrayList;
import java.util.List;

/**
 * Dice Tower.
 * A Dice Tower is a tool used by serious gamers use to roll many dice at once.
 * It looks like this www.miniaturescenery.com/Images/PortableDiceTowerLarge.jpg
 * An instance of a dice tower is defined by the number panels it contains to help
 * provide a more regular distribution of die values. The die bounce from panel to
 * panel until they exit the dice tower at the bottom tray.
 * A dice tower will accept a collection of dice and reports their results when
 * they reach the tray at the bottom
 * @author Paul Scarrone
 */

public class DiceTower {
  final int PANEL_COUNT = 3;    // number of panels in dice tower
  List<Die> dice;               // arraylist of die objects
  private int dieNum;           // number rolled by a die
  private int trayValue;        // value of all dice rolled

  /** 
   * constructor
   * no params
   */
  public DiceTower() {
    this.dice = new ArrayList();
    dieNum = 0;
    trayValue = 0;
  }
  
  /** 
   * constructor
   * @param dice  arraylist of die objects
   */
  public DiceTower(List dice) {
    this.dice = dice;
    dieNum = 0;
    trayValue = 0;
  }
  
  /** 
   * dropDice   drop die objects in arraylist through dice tower to roll
   * no params  uses class fields
   * returns nothing
   */
  public void dropDice(){
      // roll the dice as many times as there are panels in dice tower
      for (int cubes = 0; cubes < dice.size(); cubes++){
        for (int rolls = 0; rolls < PANEL_COUNT; rolls++) {
            this.dice.get(cubes).roll();
        }
        trayValue += this.dice.get(cubes).getValue();
      }
  }
  
  /** 
   * trayValue  adds together the roll results of die objects in arraylist
   * @return    sum of roll results
   */
  public int trayValue(){
    // return sum of values of dice
      return trayValue;
  }
}
