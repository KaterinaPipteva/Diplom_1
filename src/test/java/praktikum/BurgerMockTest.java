package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BurgerMockTest {
    Burger burger;

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Before
    public void setUp(){
        burger = new Burger();
    }

    @Test
    public void getPriceWithoutIngredientsTest(){
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(10.0f);
        float actual = burger.getPrice();
        Assert.assertEquals(20.0f, actual, 0.0f);
    }

    @Test
    public void getPriceWithIngredientTest(){
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        Mockito.when(bun.getPrice()).thenReturn(10.0f);
        Mockito.when(ingredient.getPrice()).thenReturn(5.0f);
        float actual = burger.getPrice();
        Assert.assertEquals(25.0f, actual, 0.0f);
    }

    @Test
    public void getPriceWithTwoIngredientsTest(){
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);

        Mockito.when(bun.getPrice()).thenReturn(10.0f);
        Mockito.when(ingredient.getPrice()).thenReturn(5.0f);
        float actual = burger.getPrice();
        Assert.assertEquals(30.0f, actual, 0.0f);
    }

    @Test
    public void getReceiptWithoutIngredientsTest(){
        burger.setBuns(bun);
        Mockito.when(bun.getName()).thenReturn("Sesame bun");
        Mockito.when(bun.getPrice()).thenReturn(10.0f);
        String actual = burger.getReceipt();
        String expected = "(==== Sesame bun ====)\n(==== Sesame bun ====)\n\nPrice: 20.000000\n";
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void getReceiptWithIngredientTest(){
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getName()).thenReturn("Sesame bun");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getName()).thenReturn("Cheese");
        Mockito.when(ingredient.getPrice()).thenReturn(5.0f);
        Mockito.when(bun.getPrice()).thenReturn(10.0f);
        String actual = burger.getReceipt();
        String expected = "(==== Sesame bun ====)\n= filling Cheese =\n(==== Sesame bun ====)\n\nPrice: 25.000000\n";
        Assert.assertEquals(expected, actual);
    }
}
