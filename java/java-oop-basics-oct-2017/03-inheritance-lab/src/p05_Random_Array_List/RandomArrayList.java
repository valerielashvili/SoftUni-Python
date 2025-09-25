package p05_Random_Array_List;

import java.util.ArrayList;
import java.util.Random;

class RandomArrayList<Object> extends ArrayList {
    private Random rnd;

    RandomArrayList() {
        this.rnd = new Random();
    }

    Object getRandomElement() {
        int index = this.rnd.nextInt(super.size());
        Object element = (Object) super.get(index);
        super.set(index, super.remove(super.size() - 1));
        return element;
    }
}
