/*
 * Copyright © 2022 by yuyu
 * Github: https://github.com/quang2002
 * Facebook: https://www.facebook.com/quang27112002
 */

/**
 *
 * @author yuyu
 */
public class StackArrayList {

    int[] array;
    int cnt = 0;

    public StackArrayList(int size) {
        array = new int[size];
    }

    public StackArrayList() {
        this(1000);
    }

    // push
    // pop
    // top
    // isempty
    public boolean isEmpty() {
        return cnt == 0;
    }

    public void push(int value) {
        if (cnt < array.length) {
            array[cnt] = value;
            cnt++;
        }
    }

    public void pop() {
        if (!isEmpty()) {
            cnt--;
        }
    }

    public Integer top() {
        if (isEmpty()) {
            return null;
        }
        return array[cnt - 1];
    }
}
