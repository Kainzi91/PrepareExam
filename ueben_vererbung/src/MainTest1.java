import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest1 {
    @Test
    public void myTest(){
        System.out.println("Hallo");
        Assertions.assertEquals(1,1);
    }

}