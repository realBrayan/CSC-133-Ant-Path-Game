package com.mycompany.a2;

import java.util.ArrayList;

public class GameObjectCollection implements ICollection{

	private ArrayList<GameObject> gameObjects;
	
	public GameObjectCollection() {
		gameObjects = new ArrayList<>();
	}
	
	@Override
	public void add(GameObject newObject) {
		gameObjects.add(newObject);
	}
	
	public IIterator getIterator() {
		return new GameObjectIterator();
	}
	
	
	private class GameObjectIterator implements IIterator{
		private int currentIndex;

		
		public GameObjectIterator() {
			currentIndex = 0;
		}
		
		@Override
		public boolean hasNext() {
			// check if the current index is less than the size of the list
			return currentIndex < gameObjects.size();
		}

		@Override
		public GameObject getNext() {
			
			GameObject nextObject = gameObjects.get(currentIndex);
			currentIndex++;
			
			return nextObject;
		}
	}
	
	
}
