package hackerrank;

import java.util.HashMap;
import java.util.Map;

public class FurnitureOrder implements FurnitureOrderInterface {
    /**
     * TODO: Create a map of Furniture items to order quantities
     */
	private HashMap<Furniture, Integer> furnitureMap = null; 
    /**
     * Initialize a new mapping of Furniture types to order quantities.
     */
    FurnitureOrder() {
    	furnitureMap = new HashMap<>();
    }

    public void addToOrder(final Furniture type, final int furnitureCount) {
    	if (furnitureMap.containsKey(type)) {
    		int prevCount = furnitureMap.get(type);
    		furnitureMap.put(type, prevCount + furnitureCount);
    	} else {
    		furnitureMap.put(type, furnitureCount);
    	}
    }

    public HashMap<Furniture, Integer> getOrderedFurniture() {
        return furnitureMap;
    }

    public float getTotalOrderCost() {
    	float totalCost = 0f;
        for (Map.Entry<Furniture, Integer> entry : furnitureMap.entrySet()) {
        	if (Furniture.CHAIR.equals(entry.getKey())) {
        		totalCost = totalCost + (Furniture.CHAIR.cost() * entry.getValue());
        	} else if (Furniture.TABLE.equals(entry.getKey())) {
        		totalCost = totalCost + (Furniture.TABLE.cost() * entry.getValue());
        	} else {
        		totalCost = totalCost + (Furniture.COUCH.cost() * entry.getValue());
        	}
        }
        return totalCost;
    }

    public int getTypeCount(Furniture type) {
       return furnitureMap.get(type);
    }

    public float getTypeCost(Furniture type) {
        for (Furniture f : Furniture.values()) {
        	if (f == type) {
        		return f.cost();
        	}
        }
        return 0f;
    }

    public int getTotalOrderQuantity() {
    	int totalQuantity = 0;
        for (Map.Entry<Furniture, Integer> entry : furnitureMap.entrySet()) {
        	totalQuantity = totalQuantity + entry.getValue(); 
        }
        return totalQuantity;
    }
}
