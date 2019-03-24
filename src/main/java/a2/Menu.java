package a2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Menu {

  private HashMap<String, HashMap<String, Float>> pizzaSet;
  private HashMap<String, Float> drinkSet;
  private List<String> toppingList;
  private Float toppingPrice;


  List<String> getPizzaTypes() {
    return new ArrayList<>(pizzaSet.keySet());
  }

  List<String> getPizzaToppings() {
    return toppingList;
  }

  List<String> getPizzaSizes(String pizzaType) {
    return new ArrayList<>(pizzaSet.get(pizzaType).keySet());
  }

  List<String> getDrinks() {
    return new ArrayList<>(drinkSet.keySet());
  }

  void setDrinks(HashMap<String, Float> drinkSet) {
    this.drinkSet = drinkSet;
  }

  Float getPizzaPrice(String pizzaType, String pizzaSize, int numExtraToppings) {
    return this.pizzaSet.get(pizzaType).get(pizzaSize) + numExtraToppings * this.toppingPrice;
  }

  Float getDrinkPrice(String currDrink) {
    return this.drinkSet.get(currDrink);
  }

  String getMenuItem(String menuItem) {
    menuItem = menuItem.toLowerCase();
    StringBuilder menuItemString = new StringBuilder();
    if (this.pizzaSet.containsKey(menuItem)) {
      String pizzaString = menuItem + ": ";
      menuItemString.append(pizzaString);
      menuItemString.append(getPizzaSizesAsString(menuItem));

    } else if (this.drinkSet.containsKey(menuItem)) {
      String drinkString = menuItem + ": ($" + this.drinkSet.get(menuItem).toString() + ")";
      menuItemString.append(drinkString);
    } else {
      menuItemString.append("Item not found");
    }
    return menuItemString.toString().toUpperCase();
  }

  private String getPizzaSizesAsString(String type) {
    StringBuilder menuString = new StringBuilder();
    for (String size : this.pizzaSet.get(type).keySet()) {
      menuString.append(size);
      menuString.append(" ($");
      menuString.append(this.pizzaSet.get(type).get(size).toString());
      menuString.append(") ");
    }
    return menuString.toString().toUpperCase();
  }

  void setToppings(List<String> toppingList) {
    this.toppingList = toppingList;
  }

  void setPizzas(HashMap<String, HashMap<String, Float>> pizzaSet) {
    this.pizzaSet = pizzaSet;
  }

  public String toString() {
    StringBuilder menuString = new StringBuilder();
    menuString.append("Pizzas:\n");
    for (String type : this.pizzaSet.keySet()) {
      String pizzaString = "- " + type + " ";
      menuString.append(pizzaString);
      menuString.append(" ");
      menuString.append(getPizzaSizesAsString(type));
      menuString.append("\n");
    }
    menuString.append("Drinks:\n");
    for (String drink : this.drinkSet.keySet()) {
      String drinkString = "- " + drink + " ($";
      menuString.append(drinkString);
      menuString.append(this.drinkSet.get(drink).toString());
      menuString.append(")\n");
    }
    menuString.append("Additional Toppings: ($");
    menuString.append(this.toppingPrice);
    menuString.append(")");
    return menuString.toString().toUpperCase();
  }

  void setToppingPrice(Float toppingPrice) {
    this.toppingPrice = toppingPrice;
  }

}
