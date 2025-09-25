package p1_Paw_Inc.factories;

import p1_Paw_Inc.entities.centers.AdoptionCenter;
import p1_Paw_Inc.entities.centers.CastrationCenter;
import p1_Paw_Inc.entities.centers.CleansingCenter;

public final class CenterFactory {
    public CenterFactory() {
    }

    public static CleansingCenter createCleansingCenter(String name) {
        return new CleansingCenter(name);
    }

    public static AdoptionCenter createAdoptionCenter(String name) {
        return new AdoptionCenter(name);
    }

    public static CastrationCenter createCastrationCenter(String name) {
        return new CastrationCenter(name);
    }
}
