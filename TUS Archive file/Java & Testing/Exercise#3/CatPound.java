package com.ait.catpound;

import java.util.ArrayList;

public class CatPound {
	private ArrayList<Cat> catCollection;
	
	public CatPound(){
		catCollection = new ArrayList<Cat>();
	}
	
	public int getNumberOfCats() {
		return catCollection.size();
	}
	
	public void addCat(Cat cat) {
		catCollection.add(cat);
	}
	
	public void removeCat(Cat cat) {
		catCollection.remove(cat);
	}
	
	public boolean searchCatName(String name) {
		boolean catFound=false;
		for (Cat cat:catCollection) {
			if(cat.getName().equals(name)) {
				catFound=true;
			}
		}
		return catFound;
	}
	
	public int getNumberOlderThan(int age) {
		int numberOlder=0;
		for (Cat cat:catCollection) {
			if(cat.getAge()>age) {
				numberOlder++;
			}
		}
		return numberOlder;
	}

}
