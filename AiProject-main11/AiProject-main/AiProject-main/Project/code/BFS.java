


package code;

import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

public class BFS {
    public static String BFSFunction(){
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
        Queue<Node> queueLevelNodes=new LinkedList<Node>();
        queueLevelNodes.add(nodeInitial);


        
        Node currentNodeInitial = queueLevelNodes.poll();
        String [] theNextOperationsInitial= InitialOperators(nodeInitial);
        nodeInitial.setDepth(nodeInitial.getDepth() + 1);
        for (String operator : theNextOperationsInitial) {
                    Node nodeChild = null;
                    State newState = new State(initialProsperityState,initialEnergyState,initialFoodState,initialMaterialsState, initialBudgetState);
                    nodeChild = new Node(newState, 
                                    operator, operator, 
                                    nodeInitial.getDepth(), 0 , false , false , false,0);              
                    queueLevelNodes.add(nodeChild);
        }

        while (!queueLevelNodes.isEmpty()) {
                 Node currentNode = queueLevelNodes.remove();
                if(currentNode.getState().getProsperity()<=100 && currentNode.getDepth()<4){
                    String [] theNextOperations= getOperators(currentNode);
                    String [] DelayOperations= getDelayOperators(currentNode);
                    if(currentNode.getState().getEnergy()<50&&currentNode.getState().getMaterials()<50&&currentNode.getState().getFood()<50){ 
                        theNextOperations= getOperators(currentNode);
                    }else if(currentNode.getState().getEnergy()==50){
                        theNextOperations=getOperatorsCantRequestEnergy(currentNode);
                    }else if(currentNode.getState().getFood()==50){
                        theNextOperations=getOperatorsCantRequestFood(currentNode);

                    }else if(currentNode.getState().getMaterials()==50){
                        theNextOperations=getOperatorsCantRequestMaterials(currentNode);
                    }
                    String applicableOperator = currentNode.getOperator();
                    applyOperator(currentNode, applicableOperator);
                    // if(currentNode.getinvalidAction()!=1){
                            nodesExpanded++;
                            System.out.println(currentNode.printNodeAsString());
                            if(currentNode.getTimeofdelay()==0){
                                        if(currentNode.getinvalidAction()==0){
                                            for (String operator : theNextOperations) {
                                                System.out.println(operator);
                                                int[] newStateValues = currentNode.getStateValues();
                                                String nameOfParents = (currentNode.getParent());
                                                nameOfParents+=","+operator;
                                                State newState = new State(newStateValues[0],newStateValues[1],newStateValues[2],newStateValues[3],newStateValues[4]);
                                                Node nodeChild = new Node(newState, 
                                                                nameOfParents, operator,  
                                                                currentNode.getDepth(), 0,currentNode.getFoodDelay(),currentNode.getMaterialsDelay(),currentNode.getEnergyDelay(),currentNode.getTimeofdelay());  
                                                nodeChild.setDepth(nodeChild.getDepth()+1);            
                                                queueLevelNodes.add(nodeChild);
                                                newState =null;
                                                if(nodeChild.getState().getProsperity()>100){
                                                    finalNode=true;                                  
                                                }
                                            }
                                        }else{
                                            currentNode=null;
                                            System.out.println("terminate first loop");
                                        }
                                        if(finalNode == true){
                                            System.out.println("Final"+currentNode.printNodeAsString());
                                            moneySpent = 100000 -  currentNode.getState().getBudget();
                                            System.out.println(nodesExpanded);
                                            finalString = currentNode.getParent() + ";"+moneySpent+";"+nodesExpanded+";";
                                            // System.out.println(finalString);

                                            break;                                    
                                        }
                            } else{
                                        if(currentNode.getinvalidAction()==0){
                                            for (String operator : DelayOperations) {
                                                System.out.println("Delay"+operator+currentNode.getTimeofdelay());
                                                int[] newStateValues = currentNode.getStateValues();
                                                String nameOfParents = (currentNode.getParent());
                                                nameOfParents+=","+operator;
                                                State newState = new State(newStateValues[0],newStateValues[1],newStateValues[2],newStateValues[3],newStateValues[4]);
                                                Node nodeChild = new Node(newState, 
                                                                nameOfParents, operator,  
                                                                currentNode.getDepth(), 0,currentNode.getFoodDelay(),currentNode.getMaterialsDelay(),currentNode.getEnergyDelay(),currentNode.getTimeofdelay()-1 );  
                                                nodeChild.setDepth(nodeChild.getDepth()+1);            
                                                queueLevelNodes.add(nodeChild);     
                                                newState =null;  
                                                if(nodeChild.getState().getProsperity()>100){
                                                        finalNode=true;                                  
                                                }                 
                                            }
                                        }else{
                                            currentNode=null;
                                            System.out.println("terminate second loop");
                                        }
                                        if(finalNode == true){
                                            System.out.println("Final"+currentNode.printNodeAsString());
                                            moneySpent = 100000 -  currentNode.getState().getBudget();
                                            System.out.println(moneySpent);
                                            System.out.println(nodesExpanded);                                            
                                            finalString = currentNode.getParent() + ";"+moneySpent+";"+nodesExpanded+";";
                                            // System.out.println(finalString);


                                            break;                                    
                                        }                         
                    }
                        // }else{
                        //     System.out.println("this branch node terminated");
                        //     break;
                        // }
                    } else{

                                // System.out.println("Final"+currentNode.printNodeAsString());
                                finalString="NOSOLUTION";
                            }
        }
        return finalString;


    }

    public static void expand(Node node ){
    
    }

    public static void applyOperator(Node node ,String operator){
        
        if(operator.equals("RequestFood")){
 
            Operators.RequestFood(node);
 
        }else if(operator.equals("RequestMaterial")){
            Operators.RequestMaterials(node);
        }else if(operator.equals("RequestEnergy")){
            Operators.RequestEnergy(node);
        }else if(operator.equals("Wait")){
            Operators.WAIT(node);
        }else if(operator.equals("Build1")){
            Operators.BUILD1(node);
        }else if(operator.equals("Build2")){
            Operators.BUILD2(node);
        }else{
        }

    }


    public static String[] getOperators(Node node){
        String [] operators={};
             operators=new String[]{"RequestFood","RequestMaterial",
                                        "RequestEnergy","Build1","Build2"};

    
        return operators;

    }
    public static String[] getOperatorsCantRequestFood(Node node){
        String [] operators={};
             operators=new String[]{"RequestMaterial",
                                        "RequestEnergy","Build1","Build2"};

    
        return operators;

    }
        public static String[] getOperatorsCantRequestMaterials(Node node){
        String [] operators={};
             operators=new String[]{"RequestFood","RequestMaterial",
                                        "Build1","Build2"};

    
        return operators;

    }
        public static String[] getOperatorsCantRequestEnergy(Node node){
        String [] operators={};
             operators=new String[]{"RequestFood","RequestMaterial",
                                        "Build1","Build2"};

    
        return operators;

    }
    public static String[] InitialOperators(Node node){
        String [] operators={};
             operators=new String[]{"RequestFood","RequestMaterial",
                                        "RequestEnergy","Build1","Build2"};

    
        return operators;

    }    
       public static String[] getDelayOperators(Node node){
        String [] operators={};
             operators=new String[]{"Wait","Build1","Build2"};

    
        return operators;

    }

    // public static bfs(graph, start, goal){
    //     Queue<Node> visited= null;



    // }
}
