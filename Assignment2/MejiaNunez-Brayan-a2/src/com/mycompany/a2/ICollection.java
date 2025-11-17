package com.mycompany.a2;

public interface ICollection {

	
	// Adds a GameObject to the collection
	void add(GameObject newObject);
	
	
	IIterator getIterator();
}
