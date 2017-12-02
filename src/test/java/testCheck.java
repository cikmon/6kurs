import com.sun.xml.internal.bind.v2.model.core.ArrayInfo;
import org.junit.Test;
import org.testng.collections.SetMultiMap;
import sample.Check;
import sample.Ploskosti;

import java.util.ArrayList;
import java.util.LinkedList;

import static junit.framework.TestCase.assertTrue;

public class testCheck {



        @Test
        public void shouldCreateDefaultArrayTest() {
            Check check = new Check();
            {
                Ploskosti p1 = new Ploskosti("1",
                        313, 313, 313, 575, 395, 35, 0, 0, 0,-1000),
                        p2 = new Ploskosti("2",
                                200, 800, 1100, 801, 11, 51, 0, 45, 0,-1000);
                assertTrue(check.start(p1, p2));
            }
            {
                Ploskosti p1 = new Ploskosti("1",
                        150, 50, 750, 35, 395, 35, 0, 0, 0,-1000),
                        p2 = new Ploskosti("2",
                                200, 800, 1100, 801, 11, 51, 0, 45, 0,-1000);
                assertTrue(check.start(p1, p2));
            }



            }

    }


