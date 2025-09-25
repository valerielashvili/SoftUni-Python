package p05_Random_Array_List;

public class Main {
    public static void main(String[] args) {
        RandomArrayList ral = new RandomArrayList<>();
        ral.add("someText");
        ral.add("newElement");
        ral.add("...");
        ral.add(5);
        ral.add("string");
        System.out.println(ral.getRandomElement());
    }
}
