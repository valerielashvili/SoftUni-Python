public class p02_NumbersEndingIn7 {
    public static void main (String[] args) {
        for (int i = 1; i < 1000; i++) { //Второ решение for (int i =7; i < 1000; i +=10)
            if (i % 10 ==7) {
            System.out.println(i);
            }
        }
    }
}
