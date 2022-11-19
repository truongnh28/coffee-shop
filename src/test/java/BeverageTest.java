import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
class BeverageTest {
    Beverage americano = BeverageFactory.getBeverage(BeverageType.AMERICANO);
    Beverage cappuccino = BeverageFactory.getBeverage(BeverageType.CAPPUCCINO);
    Beverage espresso = BeverageFactory.getBeverage(BeverageType.ESPRESSO);
    @Test
    public void getCostTest() {
        americano = Mockito.mock(Beverage.class);
        cappuccino = Mockito.mock(Beverage.class);
        espresso = Mockito.mock(Beverage.class);
        Mockito.when(americano.getCost()).thenReturn(60000);
        Mockito.when(cappuccino.getCost()).thenReturn(50000);
        Mockito.when(espresso.getCost()).thenReturn(40000);
        int cost = americano.getCost() + cappuccino.getCost() + espresso.getCost();
        assertEquals(150000, cost);
    }
}