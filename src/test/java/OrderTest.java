import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
class OrderTest {
    @Mock
    Beverage americano;
    @Mock
    Beverage cappuccino;
    @Mock
    Beverage espresso;

    @Test
    public void orderPaymentTest1() throws FileNotFoundException {
        OrderService orderService = new OrderService();
        cappuccino = Mockito.mock(Beverage.class);
        espresso = Mockito.mock(Beverage.class);
        americano = Mockito.mock(Beverage.class);
        Mockito.when(americano.getCost()).thenReturn(60000);
        Mockito.when(espresso.getCost()).thenReturn(40000);
        Mockito.when(cappuccino.getCost()).thenReturn(50000);
        orderService.addBeverage(americano);
        orderService.addBeverage(cappuccino);
        orderService.addBeverage(espresso);
        assertEquals(150000, orderService.payment());
    }

    @Test
    public void orderPaymentTest2() throws FileNotFoundException {
        OrderService orderService = new OrderService();
        cappuccino = Mockito.mock(Beverage.class);
        espresso = Mockito.mock(Beverage.class);
        americano = Mockito.mock(Beverage.class);
        Mockito.when(americano.getCost()).thenReturn(0);
        Mockito.when(espresso.getCost()).thenReturn(0);
        Mockito.when(cappuccino.getCost()).thenReturn(0);
        orderService.addBeverage(americano);
        orderService.addBeverage(cappuccino);
        orderService.addBeverage(espresso);
        assertEquals(0, orderService.payment());
    }

    @Test
    public void orderPaymentTest3() throws FileNotFoundException {
        OrderService orderService = new OrderService();
        cappuccino = Mockito.mock(Beverage.class);
        espresso = Mockito.mock(Beverage.class);
        americano = Mockito.mock(Beverage.class);
        Mockito.when(americano.getCost()).thenReturn(-60000);
        Mockito.when(espresso.getCost()).thenReturn(-10000);
        Mockito.when(cappuccino.getCost()).thenReturn(0);
        orderService.addBeverage(americano);
        orderService.addBeverage(cappuccino);
        orderService.addBeverage(espresso);
        assertEquals(0, orderService.payment());
    }
}