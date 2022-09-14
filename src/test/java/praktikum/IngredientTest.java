package praktikum;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

public class IngredientTest {
    private Faker faker;
    private Random random;
    private String name;
    private float price;
    private IngredientType ingredientType;
    Ingredient ingredient;

    @Before
    public void setUp(){
        faker = new Faker();
        random = new Random();
        name = faker.harryPotter().house();
        price = random.nextFloat();
        ingredientType = IngredientType.SAUCE;
        ingredient = new Ingredient(ingredientType, name, price);
    }

    @Test
    public void getNameOfIngredientTest(){
        String actualName = ingredient.getName();
        Assert.assertEquals("Name of the ingredient is not right", name, actualName);
    }

    @Test
    public void getPriceOfIngredientTest(){
        float actualPrice = ingredient.getPrice();
        Assert.assertEquals("Price of the ingredient is not right", price, actualPrice, 0.0f);
    }


}
