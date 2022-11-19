import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class ToppingTest {
    Topping cream = ToppingFactory.getTopping(ToppingType.CREAM);
    Topping caramel = ToppingFactory.getTopping(ToppingType.CARAMEL);
    Topping milk = ToppingFactory.getTopping(ToppingType.MILK);
    @Test
    public void getCostTest() {
        cream = Mockito.mock(Topping.class);
        caramel = Mockito.mock(Topping.class);
        milk = Mockito.mock(Topping.class);
        Mockito.when(cream.getCost()).thenReturn(10000);
        Mockito.when(caramel.getCost()).thenReturn(10000);
        Mockito.when(milk.getCost()).thenReturn(8000);
        int cost = cream.getCost() + caramel.getCost() + milk.getCost();
        assertEquals(28000, cost);
    }
}