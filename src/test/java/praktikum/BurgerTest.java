package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;


public class BurgerTest {

    Bun bun;
    Ingredient ingredient1;
    Ingredient ingredient2;
    Burger burger;

    @Before
    public void setUp(){
        bun = new Bun("Sesame bun", 30.0f);
        ingredient1 = new Ingredient(IngredientType.SAUCE, "Ketchup", 12.0f);
        ingredient2 = new Ingredient(IngredientType.FILLING, "Cucumber", 25.5f);
        burger = new Burger();
    }

    @Test
    public void setBunsTest(){
        burger.setBuns(bun);
        Assert.assertEquals("Another bun expected", bun, burger.bun);
    }

    @Test
    public void addIngredientTest(){
        burger.addIngredient(ingredient1);
        List<Ingredient> expected = new ArrayList<>();
        expected.add(ingredient1);
        Assert.assertEquals("Another ingredient expected", expected, burger.ingredients);
    }

    @Test
    public void removeIngredientTest(){
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient1);
        burger.removeIngredient(0);

        List<Ingredient> expected = new ArrayList<>();
        expected.add(ingredient1);
        Assert.assertEquals("Another list of ingredients expected", expected, burger.ingredients);
    }

    //В предыдущих трех тестах можно было использовать моки, но в этом тесте для корректного сравнения объектов нужно
    //чтобы ингредиенты как-то отличались друг от друга
    @Test
    public void moveIngredientTest(){
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);

        List<Ingredient> expected = new ArrayList<>();
        expected.add(ingredient2);
        expected.add(ingredient1);
        Assert.assertEquals("Another list of ingredients expected", expected, burger.ingredients);
    }


}
