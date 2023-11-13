package code;

import java.util.*;

import static code.BFS.*;

public class Iterative {


    public static String IterativeFunction(){
        String [] operators;
        boolean finalNode = false;
        String [] operatorsWithOUTWait={"RequestFood","RequestMaterial",
                "RequestEnergy","Build1","Build2"};
        int nodesExpanded=1;
        int moneySpent;
        String finalString="";

        String [] build1build2={"Build1","Build2"};
        // get the initial state of the problem
        System.out.println(LLAPSearch.getLLAPInitialState());

        int initialProsperityState = Parse.getInitialProsperity();
        int initialEnergyState = Parse.getInitialEnergy();
        int initialFoodState = Parse.getInitialFood();
        int initialMaterialsState = Parse.getInitialMaterials();
        int initialBudgetState = Parse.getStartBudget();


        //create new node to start with it
        //another note the operator is the applied operator to produce this node
        //so at the begining null
        State initialState = new State(initialProsperityState,initialEnergyState,initialFoodState,initialMaterialsState, initialBudgetState);
        Node nodeInitial = new Node(initialState,
                "", null,
                0, 0 , false , false , false,0);
        // System.out.println(nodeInitial.getState().getProsperity());
        Queue<Node> stackLevelNodes=new LinkedList<>();
        stackLevelNodes.add(nodeInitial);



        Node currentNodeInitial = stackLevelNodes.remove();
        String [] theNextOperationsInitial= InitialOperators(nodeInitial);
        nodeInitial.setDepth(nodeInitial.getDepth() + 1);
        Map<List<Object>, String> visited = new HashMap<>();

        for (String operator : theNextOperationsInitial) {
            Node nodeChild = null;
            State newState = new State(initialProsperityState,initialEnergyState,initialFoodState,initialMaterialsState, initialBudgetState);
            nodeChild = new Node(newState,
                    operator, operator,
                    nodeInitial.getDepth(), 0 , false , false , false,0);
            stackLevelNodes.add(nodeChild);
        }
        Stack<Node> TempNodes = new Stack<>();
        int level = 1;

        while(true) {
            Queue<Node> container = new LinkedList<>();
            int count = stackLevelNodes.size();
            for (int i = 0 ; i< count ; i++)
            {
                Node temp = stackLevelNodes.remove();
                TempNodes.add(temp);
                container.add(copyNodeValues(temp));


            }
            while (!container.isEmpty())
            {
                stackLevelNodes.add(container.remove());
            }
            while (!TempNodes.isEmpty()) {
                Node currentNode = TempNodes.pop();
                if (currentNode.getState().getProsperity() <= 100) {
                    String[] theNextOperations = getOperators(currentNode);
                    String[] DelayOperations = getDelayOperators(currentNode);
                    if (currentNode.getState().getEnergy() < 50 && currentNode.getState().getMaterials() < 50 && currentNode.getState().getFood() < 50) {
                        theNextOperations = getOperators(currentNode);
                    } else if (currentNode.getState().getEnergy() == 50) {
                        theNextOperations = getOperatorsCantRequestEnergy(currentNode);
                    } else if (currentNode.getState().getFood() == 50) {
                        theNextOperations = getOperatorsCantRequestFood(currentNode);

                    } else if (currentNode.getState().getMaterials() == 50) {
                        theNextOperations = getOperatorsCantRequestMaterials(currentNode);
                    }
                    String applicableOperator = currentNode.getOperator();
                    applyOperator(currentNode, applicableOperator);
                    // if(currentNode.getinvalidAction()!=1){
                    nodesExpanded++;
                    System.out.println(currentNode.printNodeAsString());
                    if (currentNode.getTimeofdelay() == 0) {
                        if (currentNode.getinvalidAction() == 0) {

                                for (String operator : theNextOperations) {
                                    System.out.println(operator);
                                    int[] newStateValues = currentNode.getStateValues();
                                    String nameOfParents = (currentNode.getParent());
                                    nameOfParents += "," + operator;
                                    State newState = new State(newStateValues[0], newStateValues[1], newStateValues[2], newStateValues[3], newStateValues[4]);
                                    Node nodeChild = new Node(newState,
                                            nameOfParents, operator,
                                            currentNode.getDepth(), 0, currentNode.getFoodDelay(), currentNode.getMaterialsDelay(), currentNode.getEnergyDelay(), currentNode.getTimeofdelay());
                                    nodeChild.setDepth(nodeChild.getDepth() + 1);
                                    if(nodeChild.getDepth() <= level)
                                        TempNodes.add(nodeChild);
                                    newState = null;
                                    if (nodeChild.getState().getProsperity() > 100) {
                                        finalNode = true;
                                    }
                                }
                            }
                         else {
                            currentNode = null;
                            System.out.println("terminate first loop");
                        }
                        if (finalNode == true) {
                            System.out.println("Final" + currentNode.printNodeAsString());
                            moneySpent = 100000 - currentNode.getState().getBudget();
                            System.out.println(nodesExpanded);
                            finalString = currentNode.getParent() + ";" + moneySpent + ";" + nodesExpanded + ";";
                            // System.out.println(finalString);

                            break;
                        }
                    } else {
                        if (currentNode.getinvalidAction() == 0) {

                                for (String operator : DelayOperations) {
                                    System.out.println("Delay" + operator + currentNode.getTimeofdelay());
                                    int[] newStateValues = currentNode.getStateValues();
                                    String nameOfParents = (currentNode.getParent());
                                    nameOfParents += "," + operator;
                                    State newState = new State(newStateValues[0], newStateValues[1], newStateValues[2], newStateValues[3], newStateValues[4]);
                                    Node nodeChild = new Node(newState,
                                            nameOfParents, operator,
                                            currentNode.getDepth(), 0, currentNode.getFoodDelay(), currentNode.getMaterialsDelay(), currentNode.getEnergyDelay(), currentNode.getTimeofdelay() - 1);
                                    nodeChild.setDepth(nodeChild.getDepth() + 1);
                                    if(nodeChild.getDepth() <= level)
                                        TempNodes.add(nodeChild);
                                    newState = null;
                                    if (nodeChild.getState().getProsperity() > 100) {
                                        finalNode = true;
                                    }
                                }
                            }
                        else {
                            currentNode = null;
                            System.out.println("terminate second loop");
                        }
                        if (finalNode == true) {
                            System.out.println("Final" + currentNode.printNodeAsString());
                            moneySpent = 100000 - currentNode.getState().getBudget();
                            System.out.println(moneySpent);
                            System.out.println(nodesExpanded);
                            finalString = currentNode.getParent() + ";" + moneySpent + ";" + nodesExpanded + ";";
                            // System.out.println(finalString);


                            break;
                        }
                    }
                    // }else{
                    //     System.out.println("this branch node terminated");
                    //     break;
                    // }
                } else {

                    // System.out.println("Final"+currentNode.printNodeAsString());
                    finalString = "NOSOLUTION";
                }

            }
            level++;

            if(finalNode || finalString == "NOSOLUTION")
            {
                break;
            }
        }
        return finalString;


    }
    public static Node copyNodeValues(Node toBeCopied)
    {
        State newState = new State(0,0,0,0,0);
        Node newNode = new Node(null,"","",0,0,false,false,false,0);
        newState.setBudget(toBeCopied.getState().getBudget());
        newState.setFood(toBeCopied.getState().getFood());
        newState.setEnergy(toBeCopied.getState().getEnergy());
        newState.setMaterials(toBeCopied.getState().getMaterials());
        newState.setProsperity(toBeCopied.getState().getProsperity());

        newNode.setDepth(toBeCopied.getDepth());
        newNode.setEnergyDelay(toBeCopied.getEnergyDelay());
        newNode.setFoodDelay(toBeCopied.getFoodDelay());
        newNode.setMaterialsDelay(toBeCopied.getMaterialsDelay());
        newNode.setOperator(toBeCopied.getOperator());
        newNode.setPathCost(toBeCopied.getPathCost());
        newNode.setTimeofdelay(toBeCopied.getTimeofdelay());
        newNode.setParent(toBeCopied.getParent());
        newNode.setState(newState);
        return newNode;
    }
}

