package praktikum;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Random;
@RunWith(Parameterized.class)
public class IngredientTypeTest {
    private Faker faker;
    private Random random;
    private String name;
    private float price;
    private IngredientType ingredientType;
    Ingredient ingredient;

    public IngredientTypeTest(IngredientType ingredientType){
        this.ingredientType = ingredientType;
    }

    @Parameterized.Parameters
    public static Object[][] getIngredientTypeData(){
        return new Object[][]{
            {IngredientType.SAUCE},
            {IngredientType.FILLING}
        };
    }

    @Before
    public void setUp(){
        faker = new Faker();
        random = new Random();
        name = faker.harryPotter().house();
        price = random.nextFloat();
        ingredient = new Ingredient(ingredientType, name, price);

    }

    @Test
    public void getIngredientTypeFromIngredientTest(){
        IngredientType actualIngredientType = ingredient.getType();
        Assert.assertEquals("IngredientType is not right", ingredientType, actualIngredientType);
    }

}
