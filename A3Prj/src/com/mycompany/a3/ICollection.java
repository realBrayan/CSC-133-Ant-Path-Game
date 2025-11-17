package com.mycompany.a3;

public interface ICollection {

	
	// Adds a GameObject to the collection
	void add(GameObject newObject);
	
	
	IIterator getIterator();
}
