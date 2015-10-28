package dnddiceroller;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paul Scarrone
 */
public class DnDDiceRoller {

  /**
   * Try out your dies and dice tower
   * @param args the command line arguments
   */
  public static void main(String[] args) {
	for(int i = 0; i < 1000; i++){
	  int d6 = test_oneD6();            // roll die and test value
          // determine results of roll and test
	  if(d6 != -1){
            System.out.println("Die Test Failed with Value: " + d6);
	  } else {
            System.out.println("Die Test complete " + i);
          }
          // roll 2 dice in dicetower and test value
	  int tower = test_diceTowerWithTwoD6();
          // determine results of roll and test
	  if(tower != -1){
            System.out.println("Tower Test Failed with Value: " + tower);
	  } else {
            System.out.println("Tower Test complete " + i);
          }
	}
        System.out.println("That's all folks!");
  }
  
  /**
   * test_oneD6    roll one die and test that value is correct for a 6-sided
   *               regular die
   * @param        none
   * @return       the result of testing:  -1 -> die value is correct
   */
  public static int test_oneD6(){      
	Die die = new Die(6);               // create a die object
	die.roll();                         // roll the die
	int dieValue = die.getValue();      // get value of the die
	if(dieValue >= 1 && dieValue <= 6){
          System.out.println("Die Test value: " + dieValue);
	  return -1;        // Means the die value is correct for a d6
	}else{
	  return dieValue;
	}
  }
  
  /**
   * test_diceTowerWithTwoD6    roll 2 dice and test that total value of dice
   *                            is correct for two 6-sided regular dice
   * @param                     none
   * @return                    the result of testing: -1 -> die value is correct
   */
  public static int test_diceTowerWithTwoD6(){
        // create a die object arraylist
	List<Die> dice = new ArrayList();
        // create die objects and add to the arraylist
	dice.add(new Die(6));           
	dice.add(new Die(6));  
        // create dicetower object and put the die object in it
	DiceTower tower = new DiceTower(dice);            
        tower.dropDice();                       // roll the dice
	int trayValue = tower.trayValue();      // add the value of all dice
	if(trayValue >= 2 && trayValue <= 12){
          System.out.println("Tower Test value: " + trayValue);  
	  return -1;       // means the die value is correct for two d6 dice
	}else{
	  return trayValue;
	}
  }
}
