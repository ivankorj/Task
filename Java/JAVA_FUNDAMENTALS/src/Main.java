public class Main {
    public static void main(String[] args) {

        FirstApp firstApp = new FirstApp();
        DataTypes dataTypes = new DataTypes();
        Operators operators = new Operators();
        Array arrays = new Array();

        firstApp.startFirstApp(args);
        dataTypes.startDataTypes();
        operators.startOperators();
        arrays.startArrays();
    }
}
