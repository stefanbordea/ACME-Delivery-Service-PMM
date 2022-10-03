package com.acme.delivery.bootstrap;

import com.acme.delivery.base.BaseComponent;
import com.acme.delivery.domain.Product;
import com.acme.delivery.domain.ProductCategory;
import com.acme.delivery.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Order(2)
@Component
@Profile("generate-products")
@RequiredArgsConstructor
public class ProductSampleContentCreator extends BaseComponent implements CommandLineRunner {
	private final ProductService productService;

	@Override
	public void run(final String... args) throws Exception {
		List<Product> products = List.of(Product.builder()
												.serial("S199999999")
												.name("The Big Bad Wolf")
												.description("Lorem Ipsum is simply dummy text of the printing and t industry")
												.price(BigDecimal.valueOf(3.70))
												.categories(ProductCategory.SOUVLAKI).build(),
										 Product.builder()
												.serial("B1123006700")
												.name("Goody's Burger House")
												.description("Lorem Ipsum is simply dummy text of the printing and typesetting industry")
												.price(BigDecimal.valueOf(4.60))
												.categories(ProductCategory.BURGER).build(),
										 Product.builder()
												.serial("D112389900")
												.name("Caesar`s")
												.description("Lorem Ipsum is simply dummy text of the printing and typesetting industry")
												.price(BigDecimal.valueOf(5.60))
												.categories(ProductCategory.SALADS).build(),
										 Product.builder().serial("L1012309900")
												.name("Chicken mayo parmesan burger")
												.description("Lorem Ipsum is simply dummy text of the printing and typesetting industry")
												.price(BigDecimal.valueOf(5.60))
												.categories(ProductCategory.BURGER).build(),
										 Product.builder().serial("Z1002389910")
												.name("Chicken mayo parmesan burger")
												.description("Lorem Ipsum is simply dummy text of the printing and typesetting industry")
												.price(BigDecimal.valueOf(5.60))
												.categories(ProductCategory.BURGER).build(),
										 Product.builder()
												.serial("Y1002389934")
												.name("Red Bull Energy Drink 250ml")
												.description("Lorem Ipsum is simply dummy text of the printing and typesetting industry")
												.price(BigDecimal.valueOf(1.60))
												.categories(ProductCategory.DRINKS).build(),
										 Product.builder()
												.serial("S199999998")
												.name("Chicago")
												.description("Beef patty, cheese, caramelized onions, iceberg lettuce, tomato, mayo")
												.price(BigDecimal.valueOf(10.50))
												.categories(ProductCategory.BURGER).build(),
										 Product.builder()
												.serial("S199999997")
												.name("Juicy Burger")
												.description("Beef patty,cheese, caramelized onions, iceberglettuce, tomato, mayo ")
												.price(BigDecimal.valueOf(3.70))
												.categories(ProductCategory.BURGER).build(),
										 Product.builder()
												.serial("S199999996")
												.name("Blue cheese-portobello")
												.description("Beef patty, grilled onion, portobello mushroom, blue cheese")
												.price(BigDecimal.valueOf(3.70))
												.categories(ProductCategory.BURGER).build(),
										 Product.builder()
												.serial("S199999995")
												.name("Juicy Chicken")
												.description("Chicken patty, mozarella, tomato, onion, lettuce, BBQ " +
																	 "sauce")
												.price(BigDecimal.valueOf(8.50))
												.categories(ProductCategory.BURGER).build(),
										 Product.builder()
												.serial("S199999994")
												.name("Veggie Burger")
												.description("Grilled vegetables(eqgplants, zucchinis, peppers),tomato, onion, lettuce,sauce")
												.price(BigDecimal.valueOf(9.00))
												.categories(ProductCategory.BURGER).build(),
										 Product.builder()
												.serial("S199999993")
												.name("Pita gyro xoirino")
												.description("Guros xoirinos, patates, ntomata, kremmydi, tzatziki")
												.price(BigDecimal.valueOf(3.00))
												.categories(ProductCategory.SOUVLAKI).build(),
										 Product.builder()
												.serial("S199999992")
												.name("Pita gyro kotopoulo")
												.description("Guros kotopoulo, patates, ntomata, marouli, sos")
												.price(BigDecimal.valueOf(3.00))
												.categories(ProductCategory.SOUVLAKI).build(),
										 Product.builder()
												.serial("S199999991")
												.name("Pita kebap")
												.description("Kebap, patates, ntomata, kremmydi, yiaourti")
												.price(BigDecimal.valueOf(3.00))
												.categories(ProductCategory.SOUVLAKI).build(),
										 Product.builder()
												.serial("S199999990")
												.name("Pita mpifteki laxanikwn")
												.description("Mpifteki laxanikwn,patates, ntomata, kremmydi, yiaourti ")
												.price(BigDecimal.valueOf(2.70))
												.categories(ProductCategory.SOUVLAKI).build(),
										 Product.builder()
												.serial("S199999919")
												.name("Falafel pocket")
												.description("mikro falafel")
												.price(BigDecimal.valueOf(3.30))
												.categories(ProductCategory.FALAFEL).build(),
										 Product.builder()
												.serial("S199999929")
												.name("Falafel giant")
												.description("megalo falafel")
												.price(BigDecimal.valueOf(4.80))
												.categories(ProductCategory.FALAFEL).build(),
										 Product.builder()
												.serial("S199999939")
												.name("Tabuleh")
												.description("klassiko tabuleh")
												.price(BigDecimal.valueOf(2.80))
												.categories(ProductCategory.SALADS).build(),
										 Product.builder()
												.serial("S199999949")
												.name("Hummus")
												.description("hummus apo revithia")
												.price(BigDecimal.valueOf(2.80))
												.categories(ProductCategory.SALADS).build(),
										 Product.builder()
												.serial("S199999959")
												.name("Teriyaki Noodles")
												.description("Noodles, carrots, onions, teriyaki sauce")
												.price(BigDecimal.valueOf(7.40))
												.categories(ProductCategory.NOODLES).build(),
										 Product.builder()
												.serial("S199999969")
												.name("Dan Dan Noodles")
												.description("With chilly oil")
												.price(BigDecimal.valueOf(7.40))
												.categories(ProductCategory.NOODLES).build(),
										 Product.builder()
												.serial("S199999979")
												.name("Pad Thai Noodles")
												.description("Noodles, carrots, onions, teriyaki sauce")
												.price(BigDecimal.valueOf(7.40))
												.categories(ProductCategory.NOODLES).build(),
										 Product.builder()
												.serial("S199999989")
												.name("Noodles with basil and chili")
												.description("Chili, basil & cabbage")
												.price(BigDecimal.valueOf(7.40))
												.categories(ProductCategory.NOODLES).build(),
										 Product.builder()
												.serial("S199999909")
												.name("Edamame")
												.description("soybeans")
												.price(BigDecimal.valueOf(4.50))
												.categories(ProductCategory.SALADS).build(),
										 Product.builder()
												.serial("S199999099")
												.name("Avocado roll (inside out)")
												.description("rolls with avocado & black sesame")
												.price(BigDecimal.valueOf(6.10))
												.categories(ProductCategory.SUSHI).build(),
										 Product.builder()
												.serial("S199999199")
												.name("California (inside out)")
												.description("crab, cucumber, avocado")
												.price(BigDecimal.valueOf(10.80))
												.categories(ProductCategory.SUSHI).build(),
										 Product.builder()
												.serial("S199999299")
												.name("Spicy ebi tempura (inside out)")
												.description("shrimp tempura, avocado, ginger, mayo, sesame")
												.price(BigDecimal.valueOf(11.40))
												.categories(ProductCategory.SUSHI).build(),
										 Product.builder()
												.serial("S199999399")
												.name("Uzumaki")
												.description("crab, cucumber, avocado")
												.price(BigDecimal.valueOf(10.40))
												.categories(ProductCategory.SUSHI).build(),
										 Product.builder()
												.serial("S199999499")
												.name("Tagliatelle")
												.description("24-hour beef ragu, Parmigiano")
												.price(BigDecimal.valueOf(2.80))
												.categories(ProductCategory.PASTA).build(),
										 Product.builder()
												.serial("S199999599")
												.name("Ciriole Carbonara")
												.description("Guanciale, Pecorino, egg, black pepper")
												.price(BigDecimal.valueOf(2.80))
												.categories(ProductCategory.PASTA).build(),
										 Product.builder()
												.serial("S199999699")
												.name("Reginette")
												.description("Rabbit ragu, black olive, toasted pine nuts, sage, Parmigiano")
												.price(BigDecimal.valueOf(2.80))
												.categories(ProductCategory.PASTA).build(),
										 Product.builder()
												.serial("S199999799")
												.name("Crab Pappardelle")
												.description("saffron cream, chives")
												.price(BigDecimal.valueOf(2.80))
												.categories(ProductCategory.PASTA).build(),
										 Product.builder()
												.serial("S199999899")
												.name("Garganelli Cacio e Pepe")
												.description("Pecorino, Parmigiano, black pepper")
												.price(BigDecimal.valueOf(2.80))
												.categories(ProductCategory.PASTA).build(),
										 Product.builder()
												.serial("S199990999")
												.name("Rigatoni alla Norma")
												.description("smoked eggplant, San Marzano tomato, basil, Pecorino")
												.price(BigDecimal.valueOf(2.80))
												.categories(ProductCategory.PASTA).build(),
										 Product.builder()
												.serial("S199991999")
												.name("Tagliatelle al ragu bolognese")
												.description("slow-cooked Βolognese sauce, mushrooms, thyme & ricotta cream")
												.price(BigDecimal.valueOf(2.80))
												.categories(ProductCategory.PASTA).build(),
										 Product.builder()
												.serial("S199992999")
												.name("Bianca")
												.description("mozzarella burrata, prosciutto cotto, grilled cherry tomatoes, pistachio & lemon")
												.price(BigDecimal.valueOf(2.80))
												.categories(ProductCategory.PIZZA).build(),
										 Product.builder()
												.serial("S199993999")
												.name("Margherita")
												.description("an Marzano tomato, mozzarella fior di latte, fresh basil")
												.price(BigDecimal.valueOf(2.80))
												.categories(ProductCategory.PIZZA).build(),
										 Product.builder()
												.serial("S199994999")
												.name("Pepperoni")
												.description("san Marzano Tomato, mozzarella fior di latte, peperoni & Parmesan *spicy!")
												.price(BigDecimal.valueOf(2.80))
												.categories(ProductCategory.SALADS).build(),
										 Product.builder()
												.serial("S199995999")
												.name("Speciale")
												.description("san Marzano tomato, mozzarella fior di latte, sausage, mushrooms, green peppers, sausage & parmesan")
												.price(BigDecimal.valueOf(2.80))
												.categories(ProductCategory.SALADS).build(),
										 Product.builder()
												.serial("S199996999")
												.name("Prosciuto Cotto e Pesto")
												.description("an marzano tomato, mozzarella fior di latte, prosciuto cotto & basil pesto")
												.price(BigDecimal.valueOf(2.80))
												.categories(ProductCategory.SALADS).build(),
										 Product.builder()
												.serial("S199997999")
												.name("Cheese & Bacon")
												.description("mozzarella fior di latte, bacon, parmesan & black pepper")
												.price(BigDecimal.valueOf(2.80))
												.categories(ProductCategory.SALADS).build(),
										 Product.builder()
												.serial("S199998999")
												.name("Pork Sandwich")
												.description("pork, fried potatoes, tomato, onion, cocktail sauce")
												.price(BigDecimal.valueOf(2.80))
												.categories(ProductCategory.SANDWICHES).build(),
										 Product.builder()
												.serial("A199999999")
												.name("Chicken Sandwich")
												.description("chicken, fried potatoes, tomato, onion, cocktail sauce")
												.price(BigDecimal.valueOf(2.80))
												.categories(ProductCategory.SANDWICHES).build(),
										 Product.builder()
												.serial("B199999999")
												.name("Kebab Sandwich")
												.description("kebab, fried potatoes, tomato, onion, cocktail sauce")
												.price(BigDecimal.valueOf(2.80))
												.categories(ProductCategory.SANDWICHES).build(),
										 Product.builder()
												.serial("C199999999")
												.name("Sausage Sandwich")
												.description("sausage, fried potatoes, tomato, onion, cocktail sauce")
												.price(BigDecimal.valueOf(2.80))
												.categories(ProductCategory.SANDWICHES).build(),
										 Product.builder()
												.serial("D199999999")
												.name("Chicken nuggets Sandwich")
												.description("chicken nuggets, fried potatoes, tomato, onion, cocktail sauce")
												.price(BigDecimal.valueOf(2.80))
												.categories(ProductCategory.SANDWICHES).build(),
										 Product.builder()
												.serial("E199999999")
												.name("Cosmopolitan")
												.description("vodka, triple sec, cranberry, and lime")
												.price(BigDecimal.valueOf(2.80))
												.categories(ProductCategory.SALADS).build(),
										 Product.builder()
												.serial("F199999999")
												.name("Aviation")
												.description("crème de violette or crème Yvette, Maraschino liqueur, gin, and lemon juice")
												.price(BigDecimal.valueOf(2.80))
												.categories(ProductCategory.SALADS).build(),
										 Product.builder()
												.serial("G199999999")
												.name("Zombie")
												.description("lime, lemon, and pineapple juices, passion fruit syrup, Angostura bitters, brown sugar, and three different types of rum (light, dark, and 151-proof)")
												.price(BigDecimal.valueOf(2.80))
												.categories(ProductCategory.SALADS).build(),
										 Product.builder()
												.serial("H199999999")
												.name("Mai Tai")
												.description("rum, orange juice, triple sec, and several sweeteners")
												.price(BigDecimal.valueOf(2.80))
												.categories(ProductCategory.SALADS).build(),
										 Product.builder()
												.serial("I199999999")
												.name("Bloody Mary")
												.description("tomato juice, vodka, and spices")
												.price(BigDecimal.valueOf(2.80))
												.categories(ProductCategory.SALADS).build(),
										 Product.builder()
												.serial("J199999999")
												.name("Old Cuban")
												.description("rum, mint leaves, simple syrup, lime juice, Angostura bitters, and a Champagne floater")
												.price(BigDecimal.valueOf(2.80))
												.categories(ProductCategory.SALADS).build(),
										 Product.builder()
												.serial("K199999999")
												.name("Cheese pie")
												.description("Phillo filled with feta cheese")
												.price(BigDecimal.valueOf(2.80))
												.categories(ProductCategory.SALADS).build(),
										 Product.builder()
												.serial("L199999999")
												.name("Spinach pie")
												.description("Phillo filled with feta spinach")
												.price(BigDecimal.valueOf(2.80))
												.categories(ProductCategory.SALADS).build(),
										 Product.builder()
												.serial("M199999999")
												.name("Sausage pie")
												.description("Phillo filled with feta sausage")
												.price(BigDecimal.valueOf(2.80))
												.categories(ProductCategory.SALADS).build(),
										 Product.builder()
												.serial("N199999999")
												.name("Peinirli with cheese")
												.description("gouda&feta")
												.price(BigDecimal.valueOf(2.80))
												.categories(ProductCategory.SALADS).build(),
										 Product.builder()
												.serial("O199999999")
												.name("Koulouri thessalonikis")
												.description("With sesame")
												.price(BigDecimal.valueOf(2.80))
												.categories(ProductCategory.SALADS).build(),
										 Product.builder()
												.serial("P199999999")
												.name("Espresso")
												.description("vodka, triple sec, cranberry, and lime")
												.price(BigDecimal.valueOf(2.80))
												.categories(ProductCategory.SALADS).build(),
										 Product.builder()
												.serial("Q199999999")
												.name("Freddo espresso")
												.description("vodka, triple sec, cranberry, and lime")
												.price(BigDecimal.valueOf(2.80))
												.categories(ProductCategory.SALADS).build(),
										 Product.builder()
												.serial("R199999999")
												.name("Espresso macchiato")
												.description("vodka, triple sec, cranberry, and lime")
												.price(BigDecimal.valueOf(2.80))
												.categories(ProductCategory.SALADS).build(),
										 Product.builder()
												.serial("S099999999")
												.name("Cappuccino")
												.description("vodka, triple sec, cranberry, and lime")
												.price(BigDecimal.valueOf(2.80))
												.categories(ProductCategory.SALADS).build(),
										 Product.builder()
												.serial("T199999999")
												.name("Flat white")
												.description("vodka, triple sec, cranberry, and lime")
												.price(BigDecimal.valueOf(2.80))
												.categories(ProductCategory.SALADS).build(),
										 Product.builder()
												.serial("U199999999")
												.name("Freddo cappuccino")
												.description("vodka, triple sec, cranberry, and lime")
												.price(BigDecimal.valueOf(2.80))
												.categories(ProductCategory.SALADS).build());




										 		productService.createAll(products);
	}
}
