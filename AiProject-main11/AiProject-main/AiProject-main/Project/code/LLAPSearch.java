package code;

public class LLAPSearch extends GenericSearch{

    private static String initialState;


    public static String solve(String initialState, String strategy, boolean visualize) {

        setLLAPInitialState(initialState);
        Parse.parse(initialState);
        // Operators.RequestFood();
        // Operators.RequestMaterials();
        // Operators.RequestEnergy();
        if(strategy.equals("BF")){
            return BFS2.BFfunction();
        }
        if(strategy.equals("UC")){
            return UC.UCfunction();
        }
        if(strategy.equals("ID")){
            return Iterative.IterativeFunction();
        }
        return "Solution"; 
    }






    public static String getLLAPInitialState() {
        return initialState;
    }

    public static void setLLAPInitialState(String initialState) {
        LLAPSearch.initialState = initialState;
    }
    public static void main(String[] args) {
        // String inputInitialState = "50;" +
        //         "22,22,22;" +
        //         "50,60,70;" +
        //         "30,2;" +
        //         "19,1;" +
        //         "15,1;" +
        //         "300,5,7,3,20;" +
        //         "500,8,6,3,40;";

        // // Create an instance of LLAPSearch
        // LLAPSearch llapSearch = new LLAPSearch();
        // // Call the solve method with your input initialState
        // String solution = llapSearch.solve(inputInitialState, "BFS", true);

    }
    


}
