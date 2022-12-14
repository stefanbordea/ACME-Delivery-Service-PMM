package com.acme.delivery.bootstrap;

import com.acme.delivery.base.BaseComponent;
import com.acme.delivery.domain.Account;
import com.acme.delivery.domain.Address;
import com.acme.delivery.domain.Card;
import com.acme.delivery.service.AccountService;
import com.acme.delivery.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Order(1)
@Component
@Profile("generate-accounts")
@RequiredArgsConstructor
public class AccountSampleContentCreator extends BaseComponent implements CommandLineRunner {

	private final AccountService accountService;
	private final CardService cardService;

	@Override
	public void run(final String... args) throws Exception {

		List<Account> accounts = List.of(
				Account.builder()
					   .email("vicpan98@victoriapan.com")
					   .password("yhubJI587nnkj&(*4")
					   .phoneNumber("6969696969")
					   .addresses(Set.of(Address.builder()
												.street("Thivaidos")
												.streetNumber("22")
												.zipCode("14232")
												.region("Athens").build(),
										Address.builder().street("Mpotsari")
											   .streetNumber("46")
											   .zipCode("15628")
											   .region("Thessaloniki").build(),
										Address.builder().street("Likoyrgou")
											   .streetNumber("18")
											   .zipCode("14231")
											   .region("Larisa").build())).build(),
				Account.builder()
					   .email("stefanbordea@stefanbordea.com")
					   .password("GEWja8ge528")
					   .phoneNumber("6952281961")
					   .addresses(Set.of(Address.builder()
												.street("Solonos")
												.streetNumber("109")
												.zipCode("11144")
												.region("Athens").build(),
										 Address.builder().street("Anonimou")
												.streetNumber("8")
												.zipCode("10445")
												.region("Athens").build())).build(),
				Account.builder()
					   .email("antonischam@antonischamalidis.com")
					   .password("ghr#%75bfwsEGR")
					   .phoneNumber("6977852369")
					   .addresses(Set.of(Address.builder()
												.street("Kritis")
												.streetNumber("12")
												.zipCode("24100")
												.region("Nea Ionia").build(),
										 Address.builder().street("Nikiti")
												.streetNumber("20")
												.zipCode("63088")
												.region("Chalkidiki").build(),
										 Address.builder().street("Souliou")
												.streetNumber("7")
												.zipCode("41501")
												.region("Nikaia").build())).build(),
				Account.builder()
					   .email("isidora42@gmail.com")
					   .password("abfwe188ufhHUR")
					   .phoneNumber("6936145202")
					   .addresses(Set.of(Address.builder()
												.street("Dodekanisoy")
												.streetNumber("15")
												.zipCode("22222")
												.region("Voula").build())).build(),
				Account.builder()
					   .email("iliaspapadakis48@gmail.com")
					   .password("hut984y52983yDQt")
					   .phoneNumber("6902516798")
					   .addresses(Set.of(Address.builder()
												.street("Kosta Varnalis")
												.streetNumber("20")
												.zipCode("56123")
												.region("Xanthi").build(),
										 Address.builder().street("Perikleous")
												.streetNumber("32")
												.zipCode("78650")
												.region("Xania").build(),
										 Address.builder().street("Paparouna")
												.streetNumber("57")
												.zipCode("96321")
												.region("Ioannina").build())).build());

			accountService.createAll(accounts);
//			accounts.forEach(account -> accountService.create(account));


			List<Card> cards = List.of(Card.builder()
										   .account(accountService.findByEmail("vicpan98@victoriapan.com"))
										   .cardName("VISA")
										   .cardNumber("4543204433616335")
										   .cardExpirationDate(LocalDate.of(2024,10,12))
										   .cardSecurityCode("892")
										   .build(),
									   Card.builder()
										   .account(accountService.findByEmail("vicpan98@victoriapan.com"))
										   .cardName("MASTERCARD")
										   .cardNumber("4284633339758614")
										   .cardExpirationDate(LocalDate.of(2026,04,01))
										   .cardSecurityCode("573")
										   .build(),
									   Card.builder()
										   .account(accountService.findByEmail("stefanbordea@stefanbordea.com"))
										   .cardName("AMERICAN EXPRESS")
										   .cardNumber("3755342791682858")
										   .cardExpirationDate(LocalDate.of(2023,10,16))
										   .cardSecurityCode("8255")
										   .build(),
									   Card.builder()
										   .account(accountService.findByEmail("stefanbordea@stefanbordea.com"))
										   .cardName("MASTERCARD")
										   .cardNumber("3755373642314050")
										   .cardExpirationDate(LocalDate.of(2029,06,16))
										   .cardSecurityCode("6554")
										   .build(),
									   Card.builder()
										   .account(accountService.findByEmail("antonischam@antonischamalidis.com"))
										   .cardName("VISA")
										   .cardNumber("4255927062266968")
										   .cardExpirationDate(LocalDate.of(2027,12,01))
										   .cardSecurityCode("535")
										   .build(),
									   Card.builder()
										   .account(accountService.findByEmail("antonischam@antonischamalidis.com"))
										   .cardName("VISA")
										   .cardNumber("2559211183726800")
										   .cardExpirationDate(LocalDate.of(2026,01,01))
										   .cardSecurityCode("367")
										   .build(),
									   Card.builder()
										   .account(accountService.findByEmail("isidora42@gmail.com"))
										   .cardName("VISA")
										   .cardNumber("4255927062266968")
										   .cardExpirationDate(LocalDate.of(2027,12,01))
										   .cardSecurityCode("535")
										   .build(),
									   Card.builder()
										   .account(accountService.findByEmail("isidora42@gmail.com"))
										   .cardName("VISA")
										   .cardNumber("4093487036831765")
										   .cardExpirationDate(LocalDate.of(2025,07,25))
										   .cardSecurityCode("745")
										   .build(),
									   Card.builder()
										   .account(accountService.findByEmail("iliaspapadakis48@gmail.com"))
										   .cardName("VISA")
										   .cardNumber("3765485112552700")
										   .cardExpirationDate(LocalDate.of(2022,05,12))
										   .cardSecurityCode("745")
										   .build(),
									   Card.builder()
										   .account(accountService.findByEmail("iliaspapadakis48@gmail.com"))
										   .cardName("AMERICAN EXPRESS")
										   .cardNumber("3766121202849462")
										   .cardExpirationDate(LocalDate.of(2024,02,04))
										   .cardSecurityCode("967")
										   .build());


			cards.forEach(card -> cardService.create(card));
	}
}
