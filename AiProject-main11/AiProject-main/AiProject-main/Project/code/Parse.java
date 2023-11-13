package code;
public class Parse {

    private static int initialProsperity;
    private static int initialFood;
    private static int initialMaterials ;
    private static int initialEnergy ; 

    private static int unitPriceFood ;
    private static int unitPriceMaterials ;
    private static int unitPriceEnergy ;
    private static int amountRequestFood ;
    private static int delayRequestFood ;
    private static int amountRequestMaterials ;
    private static int delayRequestMaterials ;
    private static int amountRequestEnergy ;
    private static int delayRequestEnergy ;
    private static int priceBUILD1 ; 
    private static int foodUseBUILD1 ;
    private static int materialsUseBUILD1 ;
    private static int energyUseBUILD1 ;
    private static int prosperityBUILD1 ;
    private static int priceBUILD2 ;
    private static int foodUseBUILD2 ;
    private static int materialsUseBUILD2 ;
    private static int energyUseBUILD2 ;
    private static int prosperityBUILD2 ;
    private static int startBudget = 100000;
    private static boolean request = false;

    private static int requestBudget = 0;
    private static int build1Budget = 0;
    private static int build2Budget = 0;



    public static void parse(String initialState){
        String[] parts = initialState.split(";");
        if (parts.length == 8) {
            initialProsperity = (Integer.parseInt(parts[0]));
            String[] initialFoodParts = parts[1].split(",");
            initialFood = Integer.parseInt(initialFoodParts[0]);
            initialMaterials = Integer.parseInt(initialFoodParts[1]);
            initialEnergy = Integer.parseInt(initialFoodParts[2]);

            String[] unitPriceFoodParts = parts[2].split(",");
            unitPriceFood = Integer.parseInt(unitPriceFoodParts[0]);
            unitPriceMaterials = Integer.parseInt(unitPriceFoodParts[1]);
            unitPriceEnergy = Integer.parseInt(unitPriceFoodParts[2]);

            String[] amountRequestFoodParts = parts[3].split(",");
            amountRequestFood = Integer.parseInt(amountRequestFoodParts[0]);
            delayRequestFood = Integer.parseInt(amountRequestFoodParts[1]);

            String[] amountRequestMaterialsParts = parts[4].split(",");
            amountRequestMaterials = Integer.parseInt(amountRequestMaterialsParts[0]);
            delayRequestMaterials = Integer.parseInt(amountRequestMaterialsParts[1]);

            String[] amountRequestEnergyParts = parts[5].split(",");
            amountRequestEnergy = Integer.parseInt(amountRequestEnergyParts[0]);
            delayRequestEnergy = Integer.parseInt(amountRequestEnergyParts[1]);

            String[] build1Parts = parts[6].split(",");
            priceBUILD1 = Integer.parseInt(build1Parts[0]);
            foodUseBUILD1 = Integer.parseInt(build1Parts[1]);
            materialsUseBUILD1 = Integer.parseInt(build1Parts[2]);
            energyUseBUILD1 = Integer.parseInt(build1Parts[3]);
            prosperityBUILD1 = Integer.parseInt(build1Parts[4]);

            String[] build2Parts = parts[7].split(",");
            priceBUILD2 = Integer.parseInt(build2Parts[0]);
            foodUseBUILD2 = Integer.parseInt(build2Parts[1]);
            materialsUseBUILD2 = Integer.parseInt(build2Parts[2]);
            energyUseBUILD2 = Integer.parseInt(build2Parts[3]);
            prosperityBUILD2 = Integer.parseInt(build2Parts[4]);

            requestBudget=unitPriceFood + unitPriceEnergy + unitPriceMaterials;
            build1Budget=priceBUILD1 + unitPriceFood*foodUseBUILD1 + unitPriceEnergy*energyUseBUILD1 + unitPriceMaterials*materialsUseBUILD1;
            build2Budget=priceBUILD2 + unitPriceFood*foodUseBUILD2 + unitPriceEnergy*energyUseBUILD2 + unitPriceMaterials*materialsUseBUILD2;
            // Now you have all the values assigned to their respective variables.
            // You can use these variables in your Java code as needed.
        } else {
            System.out.println("Invalid input format.");
        }
    }
    public  static int getInitialProsperity() {
        return initialProsperity;
    }

    public static void setInitialProsperity(int initialProsperity) {
        Parse.initialProsperity = initialProsperity;
    }

    public static int getInitialFood() {
        return initialFood;
    }

    public static void setInitialFood(int initialFood) {
        initialFood = initialFood;
    }

    public static int getInitialMaterials() {
        return initialMaterials;
    }

    public static void setInitialMaterials(int initialMaterials) {
        initialMaterials = initialMaterials;
    }

    public static int getInitialEnergy() {
        return initialEnergy;
    }

    public static void setInitialEnergy(int initialEnergy) {
        initialEnergy = initialEnergy;
    }

    public static int getUnitPriceFood() {
        return unitPriceFood;
    }

    public static void setUnitPriceFood(int unitPriceFood) {
        unitPriceFood = unitPriceFood;
    }

    public static int getUnitPriceMaterials() {
        return unitPriceMaterials;
    }

    public static void setUnitPriceMaterials(int unitPriceMaterials) {
        unitPriceMaterials = unitPriceMaterials;
    }

    public static int getUnitPriceEnergy() {
        return unitPriceEnergy;
    }

    public static void setUnitPriceEnergy(int unitPriceEnergy) {
        unitPriceEnergy = unitPriceEnergy;
    }

    public static int getAmountRequestFood() {
        return amountRequestFood;
    }

    public static void setAmountRequestFood(int amountRequestFood) {
        amountRequestFood = amountRequestFood;
    }

    public static int getDelayRequestFood() {
        return delayRequestFood;
    }

    public static void setDelayRequestFood(int delayRequestFood) {
        delayRequestFood = delayRequestFood;
    }

    public static int getAmountRequestMaterials() {
        return amountRequestMaterials;
    }

    public static void setAmountRequestMaterials(int amountRequestMaterials) {
        amountRequestMaterials = amountRequestMaterials;
    }

    public static int getDelayRequestMaterials() {
        return delayRequestMaterials;
    }

    public static void setDelayRequestMaterials(int delayRequestMaterials) {
        delayRequestMaterials = delayRequestMaterials;
    }

    public static int getAmountRequestEnergy() {
        return  amountRequestEnergy;
    }

    public static void setAmountRequestEnergy(int amountRequestEnergy) {
         amountRequestEnergy = amountRequestEnergy;
    }

    public static int getDelayRequestEnergy() {
        return  delayRequestEnergy;
    }

    public static void setDelayRequestEnergy(int delayRequestEnergy) {
         delayRequestEnergy = delayRequestEnergy;
    }

    public static int getPriceBUILD1() {
        return  priceBUILD1;
    }

    public static void setPriceBUILD1(int priceBUILD1) {
         priceBUILD1 = priceBUILD1;
    }

    public static int getFoodUseBUILD1() {
        return  foodUseBUILD1;
    }

    public static void setFoodUseBUILD1(int foodUseBUILD1) {
         foodUseBUILD1 = foodUseBUILD1;
    }

    public static int getMaterialsUseBUILD1() {
        return  materialsUseBUILD1;
    }

    public static void setMaterialsUseBUILD1(int materialsUseBUILD1) {
         materialsUseBUILD1 = materialsUseBUILD1;
    }

    public static int getEnergyUseBUILD1() {
        return  energyUseBUILD1;
    }

    public static void setEnergyUseBUILD1(int energyUseBUILD1) {
         energyUseBUILD1 = energyUseBUILD1;
    }

    public static int getProsperityBUILD1() {
        return  prosperityBUILD1;
    }

    public static void setProsperityBUILD1(int prosperityBUILD1) {
         prosperityBUILD1 = prosperityBUILD1;
    }

    public static int getPriceBUILD2() {
        return  priceBUILD2;
    }

    public static void setPriceBUILD2(int priceBUILD2) {
         priceBUILD2 = priceBUILD2;
    }

    public static int getFoodUseBUILD2() {
        return  foodUseBUILD2;
    }

    public static void setFoodUseBUILD2(int foodUseBUILD2) {
         foodUseBUILD2 = foodUseBUILD2;
    }

    public static int getMaterialsUseBUILD2() {
        return  materialsUseBUILD2;
    }

    public static void setMaterialsUseBUILD2(int materialsUseBUILD2) {
         materialsUseBUILD2 = materialsUseBUILD2;
    }

    public static int getEnergyUseBUILD2() {
        return  energyUseBUILD2;
    }

    public static void setEnergyUseBUILD2(int energyUseBUILD2) {
         energyUseBUILD2 = energyUseBUILD2;
    }

    public static int getProsperityBUILD2() {
        return  prosperityBUILD2;
    }

    public static void setProsperityBUILD2(int prosperityBUILD2) {
         prosperityBUILD2 = prosperityBUILD2;
    }

    public static int getStartBudget() {
        return  startBudget;
    }

    public static void setStartBudget(int startBudget) {
         startBudget = startBudget;
    }

    public static boolean isRequest() {
        return  request;
    }

    public static void setRequest(boolean request) {
        request = request;
    }

    public static int getRequestBudget() {
        return requestBudget;
    }

    public static void setRequestBudget(int requestBudget) {
        requestBudget = requestBudget;
    }

    public static int getBuild1Budget() {
        return build1Budget;
    }

    public static void setBuild1Budget(int build1Budget) {
        build1Budget = build1Budget;
    }

    public static int getBuild2Budget() {
        return build2Budget;
    }

    public static void setBuild2Budget(int build2Budget) {
        build2Budget = build2Budget;
    }


}