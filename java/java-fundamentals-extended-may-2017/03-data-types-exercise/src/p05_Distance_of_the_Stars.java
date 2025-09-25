public class p05_Distance_of_the_Stars {
    public static void main(String[] args) {

        double proximaCentauri = 4.22D;
        double centerOfOurGalaxy = 26000.0D;
        double milkyWayDiameter = 100000.0D;
        double edgeOfObservableUniverse = 4.65E10D;
        double oneLightYear = 9.45E12D;
        double proximaCentauriDis = proximaCentauri * oneLightYear;
        double centerOfOurGalaxyDis = centerOfOurGalaxy * oneLightYear;
        double milkyWayDiameterDis = milkyWayDiameter * oneLightYear;
        double edgeOfObservableUniverseDis = edgeOfObservableUniverse * oneLightYear;

        System.out.printf("%.2E\n%.2E\n%.2E\n%.2E\n", proximaCentauriDis, centerOfOurGalaxyDis,
                milkyWayDiameterDis, edgeOfObservableUniverseDis);
    }
}
