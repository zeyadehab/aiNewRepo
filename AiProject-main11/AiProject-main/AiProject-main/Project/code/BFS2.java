
package code;

import java.util.LinkedList;
import java.util.Queue;
import java.util.HashSet;


public class BFS2 {
    // private static HashSet<String> nodeSet = new HashSet<>();

    public static String BFfunction(){
        boolean found = false;
        String finalsString = "";
        int numberOfExpandedNodes = 1;
        int initialProsperityState = Parse.getInitialProsperity();
        int initialEnergyState = Parse.getInitialEnergy();
        int initialFoodState = Parse.getInitialFood();
        int initialMaterialsState = Parse.getInitialMaterials();
        int initialBudgetState = Parse.getStartBudget();
        State initialState = new State(initialProsperityState,initialEnergyState,initialFoodState,initialMaterialsState, initialBudgetState);
        Node initialNode = new Node(initialState,"","",0,0,false,false,false,0);
        Queue<Node> queueOfNodes = new LinkedList<>(); 

        queueOfNodes.add(initialNode);
        // String s = ""+initialNode.getState().getBudget() +initialNode.getState().getEnergy()+initialNode.getState().getMaterials() +initialNode.getState().getFood() +initialNode.getState().getProsperity()+initialNode.getTimeofdelay();
        // nodeSet.add(s);


        while(!queueOfNodes.isEmpty()){
            Node currentNode = queueOfNodes.remove();
            System.out.println(currentNode.printNodeAsString());
            if(currentNode.getState().getProsperity()<=100  ){
                if(currentNode.getinvalidAction()==0){
                String operatorParent=currentNode.getOperator();
                String[] allNextOperations = getAllNextOprations(operatorParent,currentNode.getFoodDelay(),currentNode.getMaterialsDelay(),currentNode.getEnergyDelay(),currentNode.getTimeofdelay());
                for(String operatorOfChild : allNextOperations){
                    int[] newStateValues = currentNode.getStateValues();
                    State newState = new State(newStateValues[0],newStateValues[1],newStateValues[2],newStateValues[3],newStateValues[4]);
                    Node nodeChild = new Node(newState,"", operatorOfChild,  
                                            currentNode.getDepth(), 0,
                                            currentNode.getFoodDelay(),currentNode.getMaterialsDelay(),
                                            currentNode.getEnergyDelay(),currentNode.getTimeofdelay() );                                                                 
                    nodeChild.setDepth(nodeChild.getDepth()+1); 
                    applyOperator(nodeChild);   
                    nodeChild.setPathCost(100000-nodeChild.getState().getBudget());
                    if(currentNode.getParent()!=""){
                         nodeChild.setParent(currentNode.getParent()+","+currentNode.getOperator());
                    }else{
                        nodeChild.setParent(currentNode.getOperator());
                    }
                    // String s2 = ""+nodeChild.getState().getBudget() +nodeChild.getState().getEnergy()+nodeChild.getState().getMaterials() +nodeChild.getState().getFood() +nodeChild.getState().getProsperity()+nodeChild.getTimeofdelay();
                    // if (!nodeSet.contains(s2)) {
                    if(nodeChild.getinvalidAction()==0){
                        queueOfNodes.add(nodeChild);
                        numberOfExpandedNodes++; 
                        // nodeSet.add(s2);          
                        // System.out.println(nodeChild.printNodeAsString());
                        if(nodeChild.getState().getProsperity()>=100){
                            // System.out.println("found");
                            if(nodeChild.getParent()!=""){
                                finalsString = nodeChild.getParent() + ","+nodeChild.getOperator()+";"+nodeChild.getPathCost()+";"+numberOfExpandedNodes;
                            }else{
                                finalsString = nodeChild.getOperator()+";"+nodeChild.getPathCost()+";"+numberOfExpandedNodes;

                            }
                            found = true;
                            break;
                        }
                    }    
                        
                    // }
                }
                
                if(found == true){
                        // System.out.println("found");
                        return finalsString;
                    }
                }
            }else{
                return finalsString = "NOSOLUTION";
            }
            currentNode = null;
            }
        return finalsString;
    }

    public static String[] getAllNextOprations(String operatorName,boolean fooddelay,boolean materialsDelay,boolean energyDelay,int timedelay){
            String [] operators={};
            if(operatorName.equals("")){
                operators=new String[]{"RequestFood","RequestMaterial","RequestEnergy","Build1","Build2"};
            }
            else if(timedelay == 0  ){
                operators=new String[]{"RequestFood","RequestMaterial","RequestEnergy","Build1","Build2"};
            }else{
                operators=new String[]{"Wait","Build1","Build2"};

            }
    return operators;

    }


    public static void applyOperator(Node node){
        if(node.getOperator().equals("RequestFood")){
            if(node.getState().getBudget()>Parse.getRequestBudget() && node.getState().getEnergy()>1 && node.getState().getFood()>1 && node.getState().getMaterials()>1 && node.getTimeofdelay()==0){
                if(node.getFoodDelay()==true){
                        if(node.getState().getFood()+Parse.getAmountRequestFood()>50){
                            node.getState().setFood(50);
                        }else{
                            node.getState().setFood(node.getState().getFood()+Parse.getAmountRequestFood());
                        }
                        node.setFoodDelay(false);

                    }
                    if(node.getMaterialsDelay()==true){
                        if(node.getState().getMaterials()+Parse.getAmountRequestMaterials()>50){
                            node.getState().setMaterials(50);
                        }else{
                            node.getState().setMaterials(node.getState().getMaterials()+Parse.getAmountRequestMaterials());
                        }
                        node.setMaterialsDelay(false);

                    }
                    if(node.getEnergyDelay()==true){
                        if(node.getState().getEnergy()+Parse.getAmountRequestEnergy()>50){
                            node.getState().setEnergy(50);
                        }else{
                            node.getState().setEnergy(node.getState().getEnergy()+Parse.getAmountRequestEnergy());
                        }
                        node.setEnergyDelay(false);                   

                    }
                node.getState().setBudget(node.getState().getBudget()- Parse.getRequestBudget());
                node.setFoodDelay(true);
                node.setTimeofdelay(Parse.getDelayRequestFood());
                node.getState().setEnergy(node.getState().getEnergy()-1);
                node.getState().setFood(node.getState().getFood()-1);
                node.getState().setMaterials(node.getState().getMaterials()-1);
                
            }else{
                node.setinvalidAction(1);
                // System.out.println("terminate");
            }        
        }else if(node.getOperator().equals("RequestMaterial")){
            if(node.getState().getBudget()>Parse.getRequestBudget() && node.getState().getEnergy()>1 && node.getState().getFood()>1 && node.getState().getMaterials()>1 && node.getTimeofdelay()==0){
                if(node.getFoodDelay()==true){
                        if(node.getState().getFood()+Parse.getAmountRequestFood()>50){
                            node.getState().setFood(50);
                        }else{
                            node.getState().setFood(node.getState().getFood()+Parse.getAmountRequestFood());
                        }
                        node.setFoodDelay(false);

                    }
                    if(node.getMaterialsDelay()==true){
                        if(node.getState().getMaterials()+Parse.getAmountRequestMaterials()>50){
                            node.getState().setMaterials(50);
                        }else{
                            node.getState().setMaterials(node.getState().getMaterials()+Parse.getAmountRequestMaterials());
                        }
                        node.setMaterialsDelay(false);

                    }
                    if(node.getEnergyDelay()==true){
                        if(node.getState().getEnergy()+Parse.getAmountRequestEnergy()>50){
                            node.getState().setEnergy(50);
                        }else{
                            node.getState().setEnergy(node.getState().getEnergy()+Parse.getAmountRequestEnergy());
                        }
                        node.setEnergyDelay(false);                   

                    }
                node.getState().setBudget(node.getState().getBudget()- Parse.getRequestBudget());
                node.setMaterialsDelay(true); 
                node.setTimeofdelay(Parse.getDelayRequestMaterials());
                node.getState().setEnergy(node.getState().getEnergy()-1);
                node.getState().setFood(node.getState().getFood()-1);
                node.getState().setMaterials(node.getState().getMaterials()-1);
            }else{
                node.setinvalidAction(1);
                // System.out.println("terminate");
            }         
        }else if(node.getOperator().equals("RequestEnergy")){
            if(node.getState().getBudget()>Parse.getRequestBudget() && node.getState().getEnergy()>1 && node.getState().getFood()>1 && node.getState().getMaterials()>1 && node.getTimeofdelay()==0){
                if(node.getFoodDelay()==true){
                        if(node.getState().getFood()+Parse.getAmountRequestFood()>50){
                            node.getState().setFood(50);
                        }else{
                            node.getState().setFood(node.getState().getFood()+Parse.getAmountRequestFood());
                        }
                        node.setFoodDelay(false);

                    }
                    if(node.getMaterialsDelay()==true){
                        if(node.getState().getMaterials()+Parse.getAmountRequestMaterials()>50){
                            node.getState().setMaterials(50);
                        }else{
                            node.getState().setMaterials(node.getState().getMaterials()+Parse.getAmountRequestMaterials());
                        }
                        node.setMaterialsDelay(false);

                    }
                    if(node.getEnergyDelay()==true){
                        if(node.getState().getEnergy()+Parse.getAmountRequestEnergy()>50){
                            node.getState().setEnergy(50);
                        }else{
                            node.getState().setEnergy(node.getState().getEnergy()+Parse.getAmountRequestEnergy());
                        }
                        node.setEnergyDelay(false);                   

                    }
                node.getState().setBudget(node.getState().getBudget()- Parse.getRequestBudget());
                node.setEnergyDelay(true); 
                node.setTimeofdelay(Parse.getDelayRequestEnergy()); 
                node.getState().setEnergy(node.getState().getEnergy()-1);
                node.getState().setFood(node.getState().getFood()-1);
                node.getState().setMaterials(node.getState().getMaterials()-1);
            }else{
                node.setinvalidAction(1);
                // System.out.println("terminate");
            }        }else if(node.getOperator().equals("Wait")){
            if(node.getState().getBudget()>Parse.getRequestBudget() && node.getState().getEnergy()>1 && node.getState().getFood()>1 && node.getState().getMaterials()>1){
                node.getState().setBudget(node.getState().getBudget()- Parse.getRequestBudget());
                node.getState().setEnergy(node.getState().getEnergy()-1);
                node.getState().setFood(node.getState().getFood()-1);
                node.getState().setMaterials(node.getState().getMaterials()-1);
                if(node.getFoodDelay() == true || node.getMaterialsDelay() == true || node.getEnergyDelay() == true){
                        node.setTimeofdelay(node.getTimeofdelay()-1);
                    }
                    // System.out.println(node.getTimeofdelay());
                    if(node.getTimeofdelay()==-1&& node.getFoodDelay()==true){
                        if(node.getState().getFood()+Parse.getAmountRequestFood()>50){
                            node.getState().setFood(50);
                        }else{
                            node.getState().setFood(node.getState().getFood()+Parse.getAmountRequestFood());
                        }
                        node.setFoodDelay(false);

                    }
                    if(node.getTimeofdelay()==-1&& node.getMaterialsDelay()==true){
                        if(node.getState().getMaterials()+Parse.getAmountRequestMaterials()>50){
                            node.getState().setMaterials(50);
                        }else{
                            node.getState().setMaterials(node.getState().getMaterials()+Parse.getAmountRequestMaterials());
                        }
                        node.setMaterialsDelay(false);

                    }
                    if(node.getTimeofdelay()==-1&& node.getEnergyDelay()==true){
                        if(node.getState().getEnergy()+Parse.getAmountRequestEnergy()>50){
                            node.getState().setEnergy(50);
                        }else{
                            node.getState().setEnergy(node.getState().getEnergy()+Parse.getAmountRequestEnergy());
                        }
                        node.setEnergyDelay(false);                   

                    }
                
            }else{
            node.setinvalidAction(1);
            // System.out.println("terminate");
        } 
       }else if(node.getOperator().equals("Build1")){
        if(node.getState().getBudget()>Parse.getBuild1Budget()&& node.getState().getEnergy()>Parse.getEnergyUseBUILD1() && node.getState().getFood()>Parse.getFoodUseBUILD1() && node.getState().getMaterials()>Parse.getMaterialsUseBUILD1()){
            node.getState().setBudget(node.getState().getBudget()- Parse.getBuild1Budget());
            node.getState().setEnergy(node.getState().getEnergy()-Parse.getEnergyUseBUILD1());
            node.getState().setFood(node.getState().getFood()-Parse.getFoodUseBUILD1());
            node.getState().setMaterials(node.getState().getMaterials()-Parse.getMaterialsUseBUILD1());
            node.getState().setProsperity(node.getState().getProsperity()+Parse.getProsperityBUILD1() );
            if(node.getFoodDelay() == true || node.getMaterialsDelay() == true || node.getEnergyDelay() == true){
                        node.setTimeofdelay(node.getTimeofdelay()-1);
                    }
                   if(node.getTimeofdelay()==-1&& node.getFoodDelay()==true){
                        if(node.getState().getFood()+Parse.getAmountRequestFood() >50){
                            node.getState().setFood(50);
                        }else{
                            node.getState().setFood(node.getState().getFood()+Parse.getAmountRequestFood());
                        }
                        node.setFoodDelay(false);

                    }
                    if(node.getTimeofdelay()==-1&& node.getMaterialsDelay()==true){
                        if(node.getState().getMaterials()+Parse.getAmountRequestMaterials()>50){
                            node.getState().setMaterials(50);
                        }else{
                            node.getState().setMaterials(node.getState().getMaterials()+Parse.getAmountRequestMaterials());
                        }
                        node.setMaterialsDelay(false);

                    }
                    if(node.getTimeofdelay()==-1&& node.getEnergyDelay()==true){
                        if(node.getState().getEnergy()+Parse.getAmountRequestEnergy()>50){
                            node.getState().setEnergy(50);
                        }else{
                            node.getState().setEnergy(node.getState().getEnergy()+Parse.getAmountRequestEnergy());
                        }
                        node.setEnergyDelay(false);                   

                    }
        }else{
            node.setinvalidAction(1);
            // System.out.println("terminate");
        }        
    }else if(node.getOperator().equals("Build2")){
        if(node.getState().getBudget()> Parse.getBuild2Budget()&& node.getState().getEnergy()>Parse.getEnergyUseBUILD2()&& node.getState().getFood()> Parse.getFoodUseBUILD2()&& node.getState().getMaterials()> Parse.getMaterialsUseBUILD2()){
            node.getState().setBudget(node.getState().getBudget()- Parse.getBuild2Budget());
                node.getState().setEnergy(node.getState().getEnergy()-Parse.getEnergyUseBUILD2());
                node.getState().setFood(node.getState().getFood()-Parse.getFoodUseBUILD2());
                node.getState().setMaterials(node.getState().getMaterials()-Parse.getMaterialsUseBUILD2());
                node.getState().setProsperity(node.getState().getProsperity()+ Parse.getProsperityBUILD2());
                if(node.getFoodDelay() == true || node.getMaterialsDelay() == true || node.getEnergyDelay() == true){
                        node.setTimeofdelay(node.getTimeofdelay()-1);
                    }
                       if(node.getTimeofdelay()==-1&& node.getFoodDelay()==true){
                            if(node.getState().getFood()+Parse.getAmountRequestFood()>50){
                                node.getState().setFood(50);
                            }else{
                                node.getState().setFood(node.getState().getFood()+Parse.getAmountRequestFood());
                            }
                            node.setFoodDelay(false);
    
                        }
                        if(node.getTimeofdelay()==-1&& node.getMaterialsDelay()==true){
                            if(node.getState().getMaterials()+Parse.getAmountRequestMaterials()>50){
                                node.getState().setMaterials(50);
                            }else{
                                node.getState().setMaterials(node.getState().getMaterials()+Parse.getAmountRequestMaterials());
                            }
                            node.setMaterialsDelay(false);
    
                        }
                        if(node.getTimeofdelay()==-1&& node.getEnergyDelay()==true){
                            if(node.getState().getEnergy()+Parse.getAmountRequestEnergy()>50){
                                node.getState().setEnergy(50);
                            }else{
                                node.getState().setEnergy(node.getState().getEnergy()+Parse.getAmountRequestEnergy());
                            }
                            node.setEnergyDelay(false);                   
    
                        }
        }  else{
            node.setinvalidAction(1);
            // System.out.println("terminate");
        }
            }
    }



}
