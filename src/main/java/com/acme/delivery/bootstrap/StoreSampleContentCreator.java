package com.acme.delivery.bootstrap;

import com.acme.delivery.base.BaseComponent;
import com.acme.delivery.domain.Address;
import com.acme.delivery.domain.Product;
import com.acme.delivery.domain.Store;
import com.acme.delivery.domain.StoreCategory;
import com.acme.delivery.service.ProductService;
import com.acme.delivery.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Order(3)
@Component
@Profile("generate-stores")
@RequiredArgsConstructor
public class StoreSampleContentCreator extends BaseComponent implements CommandLineRunner {

	private final StoreService storeService;

	private final ProductService productService;

	@Override
	public void run(final String... args) throws Exception {

		Set<Product> productsForFirstStore = new HashSet<>();
		productsForFirstStore.add(productService.findBySerial("S199999999"));
		productsForFirstStore.add(productService.findBySerial("B1123006700"));
		productsForFirstStore.add(productService.findBySerial("D112389900"));

		Set<Product> productsForSecondStore = new HashSet<>();
		productsForSecondStore.add(productService.findBySerial("Y1002389934"));

		Set<Product> productsForThirdStore = new HashSet<>();
		productsForThirdStore.add(productService.findBySerial("L1012309900"));
		productsForThirdStore.add(productService.findBySerial("Z1002389910"));
		productsForThirdStore.add(productService.findBySerial("Y1002389934"));

		Set<Product> productsForBurgerShop = new HashSet<>();
		productsForBurgerShop.add(productService.findBySerial("S199999998"));
		productsForBurgerShop.add(productService.findBySerial("S199999997"));
		productsForBurgerShop.add(productService.findBySerial("S199999996"));
		productsForBurgerShop.add(productService.findBySerial("S199999995"));
		productsForBurgerShop.add(productService.findBySerial("S199999994"));

		Set<Product> productsForSouvlakiShop = new HashSet<>();
		productsForSouvlakiShop.add(productService.findBySerial("S199999993"));
		productsForSouvlakiShop.add(productService.findBySerial("S199999992"));
		productsForSouvlakiShop.add(productService.findBySerial("S199999991"));
		productsForSouvlakiShop.add(productService.findBySerial("S199999990"));

		Set<Product> productsForEthnicShop = new HashSet<>();
		productsForEthnicShop.add(productService.findBySerial("S199999919"));
		productsForEthnicShop.add(productService.findBySerial("S199999929"));
		productsForEthnicShop.add(productService.findBySerial("S199999939"));
		productsForEthnicShop.add(productService.findBySerial("S199999949"));

		Set<Product> productsForNoodleBar = new HashSet<>();
		productsForNoodleBar.add(productService.findBySerial("S199999959"));
		productsForNoodleBar.add(productService.findBySerial("S199999969"));
		productsForNoodleBar.add(productService.findBySerial("S199999979"));
		productsForNoodleBar.add(productService.findBySerial("S199999989"));

		Set<Product> productsForSushiBar = new HashSet<>();
		productsForSushiBar.add(productService.findBySerial("S199999909"));
		productsForSushiBar.add(productService.findBySerial("S199999099"));
		productsForSushiBar.add(productService.findBySerial("S199999199"));
		productsForSushiBar.add(productService.findBySerial("S199999299"));
		productsForSushiBar.add(productService.findBySerial("S199999399"));

		Set<Product> productsForPastaBar = new HashSet<>();
		productsForPastaBar.add(productService.findBySerial("S199999499"));
		productsForPastaBar.add(productService.findBySerial("S199999599"));
		productsForPastaBar.add(productService.findBySerial("S199999699"));
		productsForPastaBar.add(productService.findBySerial("S199999799"));
		productsForPastaBar.add(productService.findBySerial("S199999899"));
		productsForPastaBar.add(productService.findBySerial("S199990999"));
		productsForPastaBar.add(productService.findBySerial("S199991999"));

		Set<Product> productsForPizzaBar = new HashSet<>();
		productsForPizzaBar.add(productService.findBySerial("S199992999"));
		productsForPizzaBar.add(productService.findBySerial("S199993999"));
		productsForPizzaBar.add(productService.findBySerial("S199994999"));
		productsForPizzaBar.add(productService.findBySerial("S199995999"));
		productsForPizzaBar.add(productService.findBySerial("S199996999"));
		productsForPizzaBar.add(productService.findBySerial("S199997999"));

		Set<Product> productsForKantina = new HashSet<>();
		productsForKantina.add(productService.findBySerial("S199998999"));
		productsForKantina.add(productService.findBySerial("A199999999"));
		productsForKantina.add(productService.findBySerial("B199999999"));
		productsForKantina.add(productService.findBySerial("C199999999"));
		productsForKantina.add(productService.findBySerial("D199999999"));

		Set<Product> productsForCocktailBar = new HashSet<>();
		productsForCocktailBar.add(productService.findBySerial("E199999999"));
		productsForCocktailBar.add(productService.findBySerial("F199999999"));
		productsForCocktailBar.add(productService.findBySerial("G199999999"));
		productsForCocktailBar.add(productService.findBySerial("H199999999"));
		productsForCocktailBar.add(productService.findBySerial("I199999999"));
		productsForCocktailBar.add(productService.findBySerial("J199999999"));

		Set<Product> productsForBakery = new HashSet<>();
		productsForBakery.add(productService.findBySerial("K199999999"));
		productsForBakery.add(productService.findBySerial("L199999999"));
		productsForBakery.add(productService.findBySerial("M199999999"));
		productsForBakery.add(productService.findBySerial("N199999999"));
		productsForBakery.add(productService.findBySerial("I199999999"));
		productsForBakery.add(productService.findBySerial("O199999999"));

		Set<Product> productsForCoffeeShop = new HashSet<>();
		productsForCoffeeShop.add(productService.findBySerial("P199999999"));
		productsForCoffeeShop.add(productService.findBySerial("Q199999999"));
		productsForCoffeeShop.add(productService.findBySerial("R199999999"));
		productsForCoffeeShop.add(productService.findBySerial("S099999999"));
		productsForCoffeeShop.add(productService.findBySerial("T199999999"));
		productsForCoffeeShop.add(productService.findBySerial("U199999999"));

		List<Store> stores = List.of(Store.builder()
											 .name("Goody's")
											 .phoneNumber("2102525095")
											 .email("info@goodys.com")
										     .openDays("Tue - Sun")
											 .category(StoreCategory.BURGER_HOUSE)
											 .address(Address.builder()
															  .street("28hs Oktovriou")
															  .streetNumber("58")
															  .zipCode("10434")
															  .region("Athens")
															 .build())
											 .productsMenu(productsForFirstStore).build(),
									 Store.builder()
										  .name("Coffee island")
										  .phoneNumber("2130439351")
										  .email("info@coffeeisland.com")
										  .openDays("Mon - Fri")
										  .category(StoreCategory.COFFEE_SHOP)
										  .address(Address.builder()
														  .street("El Alamein")
														  .streetNumber("40")
														  .zipCode("14231")
														  .region("Athens")
														  .build())
										  .productsMenu(productsForSecondStore).build(),
									 Store.builder()
										  .name("Aivali")
										  .phoneNumber("211435360")
										  .email("info@aivali.com")
										  .openDays("24/7")
										  .category(StoreCategory.SOUVLAKI_SHOP)
										  .address(Address.builder()
														  .street("Agias Eleutherias")
														  .streetNumber("40")
														  .zipCode("14050")
														  .region("Athens")
														  .build())
										  .productsMenu(productsForThirdStore).build(),
									 Store.builder()
										  .name("Juicy Grill Athens")
										  .phoneNumber("2155203201")
										  .email("info@juicygrillathens.com")
										  .openDays("24/7")
										  .category(StoreCategory.BURGER_HOUSE)
										  .address(Address.builder()
														  .street("Perikleous")
														  .streetNumber("37")
														  .zipCode("15561")
														  .region("Athens")
														  .build())
										  .productsMenu(productsForBurgerShop).build(),
									 Store.builder()
										  .name("Noodle Bar")
										  .phoneNumber("2107777067")
										  .email("info@noodlebar.com")
										  .openDays("24/7")
										  .category(StoreCategory.ASIAN)
										  .address(Address.builder()
														  .street("Papandreou")
														  .streetNumber("31")
														  .zipCode("15773")
														  .region("Athens")
														  .build())
										  .productsMenu(productsForNoodleBar).build(),
									 Store.builder()
										  .name("Epi to laikoteron")
										  .phoneNumber("2102111887")
										  .email("info@epitolaikoteron.com")
										  .openDays("24/7")
										  .category(StoreCategory.SOUVLAKI_SHOP)
										  .address(Address.builder()
														  .street("Agias Layras")
														  .streetNumber("13")
														  .zipCode("11141")
														  .region("Athens")
														  .build())
										  .productsMenu(productsForSouvlakiShop).build(),
									 Store.builder()
										  .name("Melisses")
										  .phoneNumber("2102520566")
										  .email("info@melisses.com")
										  .openDays("24/7")
										  .category(StoreCategory.STREET_FOOD_SHOP)
										  .address(Address.builder()
														  .street("Trypia")
														  .streetNumber("39")
														  .zipCode("14341")
														  .region("Athens")
														  .build())
										  .productsMenu(productsForKantina).build(),
									 Store.builder()
										  .name("Ap'alloy")
										  .phoneNumber("2155014730")
										  .email("info@apalloy.com")
										  .openDays("24/7")
										  .category(StoreCategory.ETHNIC_SHOP)
										  .address(Address.builder()
														  .street("Themistokleous")
														  .streetNumber("47")
														  .zipCode("10683")
														  .region("Athens")
														  .build())
										  .productsMenu(productsForEthnicShop).build(),
									 Store.builder()
										  .name("Folia")
										  .phoneNumber("2103803840")
										  .email("info@folia.com")
										  .openDays("24/7")
										  .category(StoreCategory.ETHNIC_SHOP)
										  .address(Address.builder()
														  .street("Andrea Metaxa")
														  .streetNumber("9")
														  .zipCode("10681")
														  .region("Athens")
														  .build())
										  .productsMenu(productsForEthnicShop).build(),
									 Store.builder()
										  .name("Kai Sushi Bar")
										  .phoneNumber("2105555025")
										  .email("info@kai.com")
										  .openDays("24/7")
										  .category(StoreCategory.SUSHI_RESTAURANT)
										  .address(Address.builder()
														  .street("Kolokotroni")
														  .streetNumber("30-32")
														  .zipCode("14341")
														  .region("Athens")
														  .build())
										  .productsMenu(productsForSushiBar).build(),
									 Store.builder()
										  .name("Troxalia")
										  .phoneNumber("2130272617")
										  .email("info@troxalia.com")
										  .openDays("24/7")
										  .category(StoreCategory.COFFEE_SHOP)
										  .address(Address.builder()
														  .street("Thiseos")
														  .streetNumber("42")
														  .zipCode("15122")
														  .region("Athens")
														  .build())
										  .productsMenu(productsForCoffeeShop).build(),
									 Store.builder()
										  .name("Meraklides")
										  .phoneNumber("2108628425")
										  .email("info@meraklides.com")
										  .openDays("24/7")
										  .category(StoreCategory.SOUVLAKI_SHOP)
										  .address(Address.builder()
														  .street("Agias Zonis")
														  .streetNumber("60")
														  .zipCode("11256")
														  .region("Athens")
														  .build())
										  .productsMenu(productsForSouvlakiShop).build(),
									 Store.builder()
										  .name("Zambri")
										  .phoneNumber("2106230063")
										  .email("info@zampri.com")
										  .openDays("24/7")
										  .category(StoreCategory.BRUNCH_SHOP)
										  .address(Address.builder()
														  .street("Agiou Dimitrioy")
														  .streetNumber("9")
														  .zipCode("14562")
														  .region("Athens")
														  .build())
										  .productsMenu(productsForCoffeeShop).build(),
									 Store.builder()
										  .name("Falafellas")
										  .phoneNumber("2103239809")
										  .email("info@falafellas.com")
										  .openDays("24/7")
										  .category(StoreCategory.ETHNIC_SHOP)
										  .address(Address.builder()
														  .street("Aiolou")
														  .streetNumber("51")
														  .zipCode("10551")
														  .region("Athens")
														  .build())
										  .productsMenu(productsForEthnicShop).build(),
									 Store.builder()
										  .name("Venetis")
										  .phoneNumber("2106833383")
										  .email("info@thebakers.com")
										  .openDays("24/7")
										  .category(StoreCategory.BAKERY)
										  .address(Address.builder()
														  .street("Pentelis")
														  .streetNumber("1")
														  .zipCode("15234")
														  .region("Athens")
														  .build())
										  .productsMenu(productsForBakery).build(),
									 Store.builder()
										  .name("Pasta bar")
										  .phoneNumber("2130055519")
										  .email("info@pastabar.com")
										  .openDays("24/7")
										  .category(StoreCategory.PASTA_BAR)
										  .address(Address.builder()
														  .street("Dekelias")
														  .streetNumber("136")
														  .zipCode("14341")
														  .region("Athens")
														  .build())
										  .productsMenu(productsForPastaBar).build(),
									 Store.builder()
										  .name("Il Basilico")
										  .phoneNumber("2168095468")
										  .email("info@ilbasilico.com")
										  .openDays("24/7")
										  .category(StoreCategory.PASTA_BAR)
										  .address(Address.builder()
														  .street("Dekelias")
														  .streetNumber("128")
														  .zipCode("14341")
														  .region("Athens")
														  .build())
										  .productsMenu(productsForPastaBar).build(),
									 Store.builder()
										  .name("Dominos's Pizza")
										  .phoneNumber("2106962800")
										  .email("info@dominospizza.com")
										  .openDays("24/7")
										  .category(StoreCategory.PIZZERIA)
										  .address(Address.builder()
														  .street("Dekelias")
														  .streetNumber("69")
														  .zipCode("14341")
														  .region("Athens")
														  .build())
										  .productsMenu(productsForPizzaBar).build(),
									 Store.builder()
										  .name("Kantina o Alekos")
										  .phoneNumber("2102824331")
										  .email("info@alekos.com")
										  .openDays("24/7")
										  .category(StoreCategory.STREET_FOOD_SHOP)
										  .address(Address.builder()
														  .street("Marinou Antipa")
														  .streetNumber("47")
														  .zipCode("14121")
														  .region("Athens")
														  .build())
										  .productsMenu(productsForKantina).build(),
									 Store.builder()
										  .name("Drunk Sinatra")
										  .phoneNumber("2103313733")
										  .email("info@drunksinatra.com")
										  .openDays("24/7")
										  .category(StoreCategory.COCKTAIL_SHOP)
										  .address(Address.builder()
														  .street("Thiseos")
														  .streetNumber("16")
														  .zipCode("10562")
														  .region("Athens")
														  .build())
										  .productsMenu(productsForCocktailBar).build());

			stores.forEach(storeService::create);

	}
}
