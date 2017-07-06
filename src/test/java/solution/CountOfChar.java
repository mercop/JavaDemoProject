package solution;

import java.util.Comparator;
import java.util.TreeSet;

class MyObject{
    public char value;
    public int count = 0;

    @Override
    public int hashCode() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Character && obj.equals(this.value))
            return true;

        return super.equals(obj);
    }
}

class MyComparator implements Comparator<MyObject> {

    public int compare(MyObject o1, MyObject o2) {
        if(o1.count == o2.count)
            return 0;
        return o1.count > o2.count ? -1: 1;
    }
}
