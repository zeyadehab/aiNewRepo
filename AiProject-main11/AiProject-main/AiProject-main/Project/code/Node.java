package code;

import java.util.Objects;

public class Node implements Comparable<Node> {
    private  State states;
    private  String parent;
    private  String operator;
    private  int depth;
    private  int pathCost;
    private  int invalidAction;
    private boolean FoodDelay;
    private boolean MaterialsDelay;
    private boolean EnergyDelay;
    private int timeofdelay;

    public Node(State states, String parent, String operator, int depth, int pathCost , boolean FoodDelay, boolean MaterialsDelay , boolean EnergyDelay , int timeofdelay) {
        this.states = states;
        this.parent = parent;
        this.operator = operator;
        this.depth = depth;
        this.pathCost = pathCost;
        this.invalidAction = 0;
        this.FoodDelay = FoodDelay;
        this.MaterialsDelay = MaterialsDelay;
        this.EnergyDelay = EnergyDelay;
        this.timeofdelay = timeofdelay;

    }
    public boolean getFoodDelay() {
            return FoodDelay;
    }

    // Setter for FoodDelay
    public void setFoodDelay(boolean FoodDelay) {
        this.FoodDelay = FoodDelay;
    }
    public boolean getMaterialsDelay() {
        return MaterialsDelay;
    }

    // Setter for MaterialsDelay
    public void setMaterialsDelay(boolean MaterialsDelay) {
        this.MaterialsDelay = MaterialsDelay;
    }
        // Getters for EnergyDelay
        public boolean getEnergyDelay() {
            return EnergyDelay;
        }
    
        // Setter for EnergyDelay
        public void setEnergyDelay(boolean EnergyDelay) {
            this.EnergyDelay = EnergyDelay;
        }

    // Getters for timeofdelay
    public int getTimeofdelay() {
        return timeofdelay;
    }

    // Setter for timeofdelay
    public void setTimeofdelay(int timeofdelay) {
        this.timeofdelay = timeofdelay;
    }       
       public int getinvalidAction() {
        return invalidAction;
    }

    public void setinvalidAction(int invalidAction) {
        this.invalidAction = invalidAction;
    }
    public State getState() {
        return states;
    }
    public int[] getStateValues()
    {
        int[] stateValues = new int[5];
        stateValues[0] = states.getProsperity();
        stateValues[1] = states.getEnergy();
        stateValues[2] = states.getFood();
        stateValues[3] = states.getMaterials();
        stateValues[4] = states.getBudget();
        return stateValues;
    }

    // Setter for 'state'
    public void setState(State states) {
        this.states = states;
    }

    // Getter for 'parent'
    public String getParent() {
        return parent;
    }

    // Setter for 'parent'
    public void setParent(String parent) {
        this.parent = parent;
    }

    // Getter for 'operator'
    public String getOperator() {
        return operator;
    }

    // Setter for 'operator'
    public void setOperator(String operator) {
        this.operator = operator;
    }

    // Getter for 'depth'
    public  int getDepth() {
        return this.depth;
    }

    // Setter for 'depth'
    public void setDepth(int depth) {
        this.depth = depth;
    }

    // Getter for 'pathCost'
    public int getPathCost() {
        return pathCost;
    }

    // Setter for 'pathCost'
    public void setPathCost(int pathCost) {
        this.pathCost = pathCost;
    }
   
    public  String printNodeAsString() {
        return " energy: " + this.states.getEnergy() +" prosperity: " + this.states.getProsperity() +" materials: " + this.states.getMaterials() +" food: " + this.states.getFood() + ", Parent: " + this.parent + ", Operator: " + this.operator + ", Depth: " + this.depth + ", Path Cost: " + this.pathCost + " , Time of delay "+ this.timeofdelay + ", Money Spent: " + (100000 - this.getState().getBudget());
    }
    // Node node = new Node("some state", null, "some operator", 0, 10);
    // // Using getter methods to access values
    // String stateValue = node.getState();
    // Node parentValue = node.getParent();
    // String operatorValue = node.getOperator();
    // int depthValue = node.getDepth();
    // int pathCostValue = node.getPathCost();
    public int compareTo(Node other) {
        // Implement comparison logic based on someValue
        return Integer.compare(this.pathCost, other.pathCost);
    }
    // public boolean equals(Object o) {
    //     if (this == o) return true;
    //     if (o == null || getClass() != o.getClass()) return false;
    //     Node node = (Node) o;
    //     return  this.getState().equals(node.getState()) &&
    //             this.getFoodDelay() == node.getFoodDelay() &&
    //             this.getMaterialsDelay() == node.getMaterialsDelay() &&
    //             this.getEnergyDelay() == node.getEnergyDelay() &&
    //             this.getTimeofdelay() == node.getTimeofdelay();
    // }

    // @Override
    // public int hashCode() {
    //     return Objects.hash(this.getState(), this.getFoodDelay(), this.getMaterialsDelay(), this.getEnergyDelay(), this.getTimeofdelay());
    // }
    // // Using setter methods to update values
    // node.setState("new state");
    // node.setParent(new Node("new parent state", null, "parent operator", 1, 20));
    // node.setOperator("new operator");
    // node.setDepth(2);
    // node.setPathCost(30);
    
}
