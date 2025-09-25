package p06_Stack_of_Strings;

import java.util.ArrayList;

class StackOfStrings {
    private ArrayList<String> data;

    StackOfStrings() {
        this.data = new ArrayList<>();
    }

    void push(String item) {
        this.data.add(item);
    }

    String pop() {
        return this.data.remove(this.data.size() - 1);
    }

    String peek() {
        return this.data.get(this.data.size() - 1);
    }

    boolean isEmpty() {
        return this.data.size() == 0;
    }
}
