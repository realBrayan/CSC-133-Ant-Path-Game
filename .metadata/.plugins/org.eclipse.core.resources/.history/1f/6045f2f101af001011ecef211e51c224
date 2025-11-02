package com.mycompany.a1;
import java.util.ArrayList;
import java.util.Random;
import com.codename1.charts.util.ColorUtil;
import com.codename1.charts.models.Point;

public class GameWorld {
	
	private ArrayList<GameObject> gameObjects;
	private int clock;
	private int lives;
	private int lastFlagNum; // To know when the game has been won.
	
	public GameWorld() {
		this.gameObjects = new ArrayList<>();
		this.clock = 0;
		this.lives = 3;
	}
	
	
	public void init() {

		gameObjects.clear();
		
		
		// Create flags
		Flag flag1 = new Flag(1, new Point(200.0f, 200.0f));
		gameObjects.add(flag1);
		gameObjects.add(new Flag(2, new Point(200.0f, 800.0f)));
        gameObjects.add(new Flag(3, new Point(700.0f, 800.0f)));
        gameObjects.add(new Flag(4, new Point(900.0f, 400.0f)));
        this.lastFlagNum = 4;		
		
        // Add Ant
        gameObjects.add(new Ant(flag1.getLocation(), 40, 50, 2));
        
        // Add Spiders
        gameObjects.add(new Spider());
        gameObjects.add(new Spider());
        
        // Add Food Stations
        gameObjects.add(new FoodStation());
        gameObjects.add(new FoodStation());
        gameObjects.add(new FoodStation());
        gameObjects.add(new FoodStation());
	}
	
	public void accelerateAnt() {
		Ant ant = getTheAnt();
		if (ant != null) {
			ant.setSpeed(ant.getSpeed() + 5);
			System.out.println("Accelerating the ant.");
		}
	}
	
	public void brakeAnt() {
		Ant ant = getTheAnt();
        if (ant != null) {
            ant.setSpeed(ant.getSpeed() - 5);
            System.out.println("Braking the ant.");
        }
	}
	
	public void turnAntLeft() {
		Ant ant = getTheAnt();
        if (ant != null) {
            ant.setHeading(ant.getHeading() - 5);
            System.out.println("Turning left.");
        }
	}
	
	public void turnAntRight() {
        Ant ant = getTheAnt();
        if (ant != null) {
            ant.setHeading(ant.getHeading() + 5);
            System.out.println("Turning right.");
        }
    }
	
    public void pretendFlagCollision(int flagNum) {
        Ant ant = getTheAnt();
        if (ant != null) {
            
            if (flagNum == ant.getLastFlagReached() + 1) {
                ant.setLastFlagReached(flagNum);
                System.out.println("Collided with flag " + flagNum);
                // Check for win condition
                if (flagNum == this.lastFlagNum) {
                    System.out.println("Game over, you win! Total time: " + this.clock);
                    exitGame();
                }
            }
        }
    }

    public void pretendFoodCollision() {
        Ant ant = getTheAnt();
        FoodStation station = getRandomFoodStation();
        
        if (ant != null && station != null) {
            int foodAmount = station.getCapacity();
            ant.setFoodLevel(ant.getFoodLevel() + foodAmount);
            station.setCapacity(0);
            station.setColor(ColorUtil.rgb(150, 220, 150)); // Faded green
            gameObjects.add(new FoodStation()); // Add a new station
            System.out.println("Collided with a food station.");
        }
    }

    public void pretendSpiderCollision() {
        Ant ant = getTheAnt();
        if (ant != null) {
            ant.setHealthLevel(ant.getHealthLevel() - 1);
            ant.fadeColor();
            System.out.println("Collided with a spider.");
            checkAntState(); // Check if this collision caused a loss
        }
    }

    public void tickClock() {
        this.clock++;
        Ant ant = getTheAnt();

        // Update all movable objects 
        for (GameObject obj : gameObjects) {
            if (obj instanceof Moveable) {
                ((Moveable) obj).move();
            }
        }
        
        // Ant's food level decreases 
        if (ant != null) {
            ant.setFoodLevel(ant.getFoodLevel() - ant.getFoodConsumptionRate());
        }
        
        System.out.println("Clock has ticked. Current time: " + this.clock);
        checkAntState(); // Check if ant lost a life
    }
    
    public void displayGameState() {
        Ant ant = getTheAnt();
        if (ant != null) {
            System.out.println("--- Game State ---");
            System.out.println("Lives left: " + this.lives);
            System.out.println("Clock: " + this.clock);
            System.out.println("Highest Flag Reached: " + ant.getLastFlagReached());
            System.out.println("Ant Food Level: " + ant.getFoodLevel());
            System.out.println("Ant Health Level: " + ant.getHealthLevel());
            System.out.println("------------------");
        }
    }

    public void outputMap() {
        System.out.println("\n--- World Map ---");
        for (GameObject obj : gameObjects) {
            System.out.println(obj.toString());
        }
        System.out.println("-----------------\n");
    }

    public void exitGame() {
        System.exit(0);
    }

    private void checkAntState() {
        Ant ant = getTheAnt();
        if (ant != null) {
            if (ant.getHealthLevel() <= 0 || ant.getFoodLevel() <= 0) {
                this.lives--;
                System.out.println("You lost a life! Lives remaining: " + this.lives);
                if (this.lives <= 0) {
                    System.out.println("Game over, you failed!");
                    exitGame();
                } else {
                    // Re-initialize the world for the next life
                    init();
                }
            }
        }
    }

    private Ant getTheAnt() {
        for (GameObject obj : gameObjects) {
            if (obj instanceof Ant) {
                return (Ant) obj;
            }
        }
        return null;
    }

    private FoodStation getRandomFoodStation() {
        ArrayList<FoodStation> stations = new ArrayList<>();
        for (GameObject obj : gameObjects) {
            if (obj instanceof FoodStation) {
                if (((FoodStation) obj).getCapacity() > 0) {
                    stations.add((FoodStation) obj);
                }
            }
        }
        if (stations.size() > 0) {
            return stations.get(new Random().nextInt(stations.size()));
        }
        return null;
    }
    
    public void changeAntConsumptionRate() {
        Ant ant = getTheAnt();
        if (ant != null) {
            Random rand = new Random();
            int change = rand.nextInt(5) - 2;
            if (change == 0) {
                change = 1; // make sure it's non-zero
            }

            int currentRate = ant.getFoodConsumptionRate();
            int newRate = currentRate + change;

            // If the new rate would be zero or negative, set it to the old rate + 1.
            if (newRate <= 0) {
                ant.setFoodConsumption(currentRate + 1);
            } else {
                ant.setFoodConsumption(newRate);
            }
            System.out.println("Ant's food consumption rate has been changed.");
        }
    }
    
}
