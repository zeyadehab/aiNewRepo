package code;

public class State {
    private  int Prosperity;
    private  int Food;
    private  int Materials ;
    private  int Energy ;

    public int getBudget() {
        return Budget;
    }

    public void setBudget(int budget) {
        Budget = budget;
    }

    private int Budget;
    public State(int Prosperity, int Energy , int Food , int Materials, int Budget){
//        this.Prosperity=Operators.initialProsperity;
//        this.Energy=Operators.initialEnergy;
//        this.Food=Operators.initialFood;
//        this.Materials=Operators.initialMaterials;
        this.Prosperity=Prosperity;
        this.Energy=Energy;
        this.Food=Food;
        this.Materials=Materials;
        this.Budget = Budget;
    }
//    public State(State state)
//    {
//        this.Prosperity = state.getProsperity();
//        this.Energy = state.getEnergy();
//        this.Food = state.getFood();
//        this.Materials = state.getMaterials();
//    }


    public  int getProsperity() {
        return Prosperity;
    }

    public  int getFood() {
        return Food;
    }

    public  int getMaterials() {
        return Materials;
    }

    public  int getEnergy() {
        return Energy;
    }

    // Setters
    public  void setProsperity(int prosperity) {
        this.Prosperity = prosperity;
    }

    public  void setFood(int food) {
        this.Food = food;
    }

    public  void setMaterials(int materials) {
        this.Materials = materials;
    }

    public  void setEnergy(int energy) {
        this.Energy = energy;
    }

}
