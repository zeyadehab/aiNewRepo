package code;

public class Operators {







    // fillin the initial values and fill the values with the givens


    public static void RequestFood(Node node)
    {
            if(node.getState().getBudget()>Parse.getRequestBudget() && node.getState().getEnergy()>1 && node.getState().getFood()>1 && node.getState().getMaterials()>1 && node.getTimeofdelay()==0){
                // if(node.getFoodDelay()==true){
                //     if(node.getState().getFood()+Parse.getAmountRequestFood()>50){
                //         node.getState().setFood(50);
                //     }else{
                //         node.getState().setFood(node.getState().getFood()+Parse.getAmountRequestFood());
                //     }
                //     node.setFoodDelay(false);

                // }
                // if(node.getMaterialsDelay()==true){
                //     if(node.getState().getMaterials()+Parse.getAmountRequestMaterials()>50){
                //         node.getState().setMaterials(50);
                //     }else{
                //         node.getState().setMaterials(node.getState().getMaterials()+Parse.getAmountRequestMaterials());
                //     }
                //     node.setMaterialsDelay(false);

                // }
                // if(node.getEnergyDelay()==true){
                //     if(node.getState().getEnergy()+Parse.getAmountRequestEnergy()>50){
                //         node.getState().setEnergy(50);
                //     }else{
                //         node.getState().setEnergy(node.getState().getEnergy()+Parse.getAmountRequestEnergy());
                //     }
                //     node.setEnergyDelay(false);                   

                // }
                node.getState().setBudget(node.getState().getBudget()- Parse.getRequestBudget());
                node.setFoodDelay(true);
                node.setTimeofdelay(Parse.getDelayRequestFood());
                node.getState().setEnergy(node.getState().getEnergy()-1);
                node.getState().setFood(node.getState().getFood()-1);
                node.getState().setMaterials(node.getState().getMaterials()-1);
            }else{
                node.setinvalidAction(1);
                System.out.println("terminate");
            }


    }
    public static void RequestMaterials(Node node)
    {

            if(node.getState().getBudget()>Parse.getRequestBudget() && node.getState().getEnergy()>1 && node.getState().getFood()>1 && node.getState().getMaterials()>1 && node.getTimeofdelay()==0){
                // if(node.getFoodDelay()==true){
                //     if(node.getState().getFood()+Parse.getAmountRequestFood()>50){
                //         node.getState().setFood(50);
                //     }else{
                //         node.getState().setFood(node.getState().getFood()+Parse.getAmountRequestFood());
                //     }
                //     node.setFoodDelay(false);

                // }
                // if(node.getMaterialsDelay()==true){
                //     if(node.getState().getMaterials()+Parse.getAmountRequestMaterials()>50){
                //         node.getState().setMaterials(50);
                //     }else{
                //         node.getState().setMaterials(node.getState().getMaterials()+Parse.getAmountRequestMaterials());
                //     }
                //     node.setMaterialsDelay(false);

                // }
                // if(node.getEnergyDelay()==true){
                //     if(node.getState().getEnergy()+Parse.getAmountRequestEnergy()>50){
                //         node.getState().setEnergy(50);
                //     }else{
                //         node.getState().setEnergy(node.getState().getEnergy()+Parse.getAmountRequestEnergy());
                //     }
                //     node.setEnergyDelay(false);                   

                // }
                node.getState().setBudget(node.getState().getBudget()- Parse.getRequestBudget());
                node.setMaterialsDelay(true); 
                node.setTimeofdelay(Parse.getDelayRequestMaterials());
                node.getState().setEnergy(node.getState().getEnergy()-1);
                node.getState().setFood(node.getState().getFood()-1);
                node.getState().setMaterials(node.getState().getMaterials()-1);
            }else{
                node.setinvalidAction(1);
                System.out.println("terminate");
            } 

    }

    public static void RequestEnergy(Node node)
    {
            if(node.getState().getBudget()>Parse.getRequestBudget() && node.getState().getEnergy()>1 && node.getState().getFood()>1 && node.getState().getMaterials()>1 && node.getTimeofdelay()==0){
                // if(node.getFoodDelay()==true){
                //     if(node.getState().getFood()+Parse.getAmountRequestFood()>50){
                //         node.getState().setFood(50);
                //     }else{
                //         node.getState().setFood(node.getState().getFood()+Parse.getAmountRequestFood());
                //     }
                //     node.setFoodDelay(false);

                // }
                // if(node.getMaterialsDelay()==true){
                //     if(node.getState().getMaterials()+Parse.getAmountRequestMaterials()>50){
                //         node.getState().setMaterials(50);
                //     }else{
                //         node.getState().setMaterials(node.getState().getMaterials()+Parse.getAmountRequestMaterials());
                //     }
                //     node.setMaterialsDelay(false);

                // }
                // if(node.getEnergyDelay()==true){
                //     if(node.getState().getEnergy()+Parse.getAmountRequestEnergy()>50){
                //         node.getState().setEnergy(50);
                //     }else{
                //         node.getState().setEnergy(node.getState().getEnergy()+Parse.getAmountRequestEnergy());
                //     }
                //     node.setEnergyDelay(false);                   

                // }
                node.getState().setBudget(node.getState().getBudget()- Parse.getRequestBudget());
                node.setEnergyDelay(true); 
                node.setTimeofdelay(Parse.getDelayRequestEnergy()); 
                node.getState().setEnergy(node.getState().getEnergy()-1);
                node.getState().setFood(node.getState().getFood()-1);
                node.getState().setMaterials(node.getState().getMaterials()-1);
            }else{
                node.setinvalidAction(1);
                System.out.println("terminate");
            }
    }
    
    public static void WAIT(Node node)
    {

            if(node.getState().getBudget()>Parse.getRequestBudget() && node.getState().getEnergy()>1 && node.getState().getFood()>1 && node.getState().getMaterials()>1){
                node.getState().setBudget(node.getState().getBudget()- Parse.getRequestBudget());
                node.getState().setEnergy(node.getState().getEnergy()-1);
                node.getState().setFood(node.getState().getFood()-1);
                node.getState().setMaterials(node.getState().getMaterials()-1);
                    System.out.println(node.getTimeofdelay());
                    if(node.getTimeofdelay()==0&& node.getFoodDelay()==true){
                        if(node.getState().getFood()+Parse.getAmountRequestFood()>50){
                            node.getState().setFood(50);
                        }else{
                            node.getState().setFood(node.getState().getFood()+Parse.getAmountRequestFood());
                        }
                        node.setFoodDelay(false);

                    }
                    if(node.getTimeofdelay()==0&& node.getMaterialsDelay()==true){
                        if(node.getState().getMaterials()+Parse.getAmountRequestMaterials()>50){
                            node.getState().setMaterials(50);
                        }else{
                            node.getState().setMaterials(node.getState().getMaterials()+Parse.getAmountRequestMaterials());
                        }
                        node.setMaterialsDelay(false);

                    }
                    if(node.getTimeofdelay()==0&& node.getEnergyDelay()==true){
                        if(node.getState().getEnergy()+Parse.getAmountRequestEnergy()>50){
                            node.getState().setEnergy(50);
                        }else{
                            node.getState().setEnergy(node.getState().getEnergy()+Parse.getAmountRequestEnergy());
                        }
                        node.setEnergyDelay(false);                   

                    }
                
            }else{
            node.setinvalidAction(1);
            System.out.println("terminate");
        }
    }

    public static void BUILD1(Node node)
    {   if(node.getState().getBudget()>Parse.getBuild1Budget()&& node.getState().getEnergy()>Parse.getEnergyUseBUILD1() && node.getState().getFood()>Parse.getFoodUseBUILD1() && node.getState().getMaterials()>Parse.getMaterialsUseBUILD1()){
            node.getState().setBudget(node.getState().getBudget()- Parse.getBuild1Budget());
            node.getState().setEnergy(node.getState().getEnergy()-Parse.getEnergyUseBUILD1());
            node.getState().setFood(node.getState().getFood()-Parse.getFoodUseBUILD1());
            node.getState().setMaterials(node.getState().getMaterials()-Parse.getMaterialsUseBUILD1());
            node.getState().setProsperity(node.getState().getProsperity()+Parse.getProsperityBUILD1() );
                   if(node.getTimeofdelay()==0&& node.getFoodDelay()==true){
                        if(node.getState().getFood()+Parse.getAmountRequestFood() >50){
                            node.getState().setFood(50);
                        }else{
                            node.getState().setFood(node.getState().getFood()+Parse.getAmountRequestFood());
                        }
                        node.setFoodDelay(false);

                    }
                    if(node.getTimeofdelay()==0&& node.getMaterialsDelay()==true){
                        if(node.getState().getMaterials()+Parse.getAmountRequestMaterials()>50){
                            node.getState().setMaterials(50);
                        }else{
                            node.getState().setMaterials(node.getState().getMaterials()+Parse.getAmountRequestMaterials());
                        }
                        node.setMaterialsDelay(false);

                    }
                    if(node.getTimeofdelay()==0&& node.getEnergyDelay()==true){
                        if(node.getState().getEnergy()+Parse.getAmountRequestEnergy()>50){
                            node.getState().setEnergy(50);
                        }else{
                            node.getState().setEnergy(node.getState().getEnergy()+Parse.getAmountRequestEnergy());
                        }
                        node.setEnergyDelay(false);                   

                    }
    }else{
        node.setinvalidAction(1);
        System.out.println("terminate");
    }
}
    public static void BUILD2(Node node)
    {   if(node.getState().getBudget()> Parse.getBuild2Budget()&& node.getState().getEnergy()>Parse.getEnergyUseBUILD2()&& node.getState().getFood()> Parse.getFoodUseBUILD2()&& node.getState().getMaterials()> Parse.getMaterialsUseBUILD2()){
        node.getState().setBudget(node.getState().getBudget()- Parse.getBuild2Budget());
            node.getState().setEnergy(node.getState().getEnergy()-Parse.getEnergyUseBUILD2());
            node.getState().setFood(node.getState().getFood()-Parse.getFoodUseBUILD2());
            node.getState().setMaterials(node.getState().getMaterials()-Parse.getMaterialsUseBUILD2());
            node.getState().setProsperity(node.getState().getProsperity()+ Parse.getProsperityBUILD2());
                   if(node.getTimeofdelay()==0&& node.getFoodDelay()==true){
                        if(node.getState().getFood()+Parse.getAmountRequestFood()>50){
                            node.getState().setFood(50);
                        }else{
                            node.getState().setFood(node.getState().getFood()+Parse.getAmountRequestFood());
                        }
                        node.setFoodDelay(false);

                    }
                    if(node.getTimeofdelay()==0&& node.getMaterialsDelay()==true){
                        if(node.getState().getMaterials()+Parse.getAmountRequestMaterials()>50){
                            node.getState().setMaterials(50);
                        }else{
                            node.getState().setMaterials(node.getState().getMaterials()+Parse.getAmountRequestMaterials());
                        }
                        node.setMaterialsDelay(false);

                    }
                    if(node.getTimeofdelay()==0&& node.getEnergyDelay()==true){
                        if(node.getState().getEnergy()+Parse.getAmountRequestEnergy()>50){
                            node.getState().setEnergy(50);
                        }else{
                            node.getState().setEnergy(node.getState().getEnergy()+Parse.getAmountRequestEnergy());
                        }
                        node.setEnergyDelay(false);                   

                    }
    }  else{
        node.setinvalidAction(1);
        System.out.println("terminate");
    }
    }


    public static void main(String[] args) {
        System.out.println(LLAPSearch.getLLAPInitialState());
    }
}
