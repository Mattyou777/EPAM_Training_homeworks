import java.util.ArrayList;
import java.util.List;

public class OutOfMemoryErrorThrower1 {

    static void thrower() {
        List<C> list = new ArrayList<>();

        while (true)
            list.add(new C());

    }


}

class C {

    long[] longs = new long[100_000_000];

}