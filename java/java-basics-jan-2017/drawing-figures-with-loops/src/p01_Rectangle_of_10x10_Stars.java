public class p01_Rectangle_of_10x10_Stars {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            String text = repeatStr("*", 10);
            System.out.println(text);
        }
    }
    public static String repeatStr (String strToRepeat, int count) {
        String text = "";
        for (int i = 0; i < count; i++) {
            text = text + strToRepeat;
        }
        return text;
    }
}
