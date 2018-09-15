package org.restframework.ms.web;

import org.restframework.ms.protobuf.CustomerProto.Account;
import org.restframework.ms.protobuf.CustomerProto.Accounts;
import org.restframework.ms.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

	@Autowired
	AccountRepository repository;

	@GetMapping(value = "/accounts/{number}", produces = "application/x-protobuf")
	public Account findByNumber(@PathVariable("number") String number) {
		return repository.findByNumber(number);
	}

	@GetMapping(value = "/accounts/customer/{customer}", produces = "application/x-protobuf")
	public Accounts findByCustomer(@PathVariable("customer") Integer customerId) {
		return Accounts.newBuilder().addAllAccount(repository.findByCustomer(customerId)).build();
	}

	@GetMapping(value = "/accounts", produces = "application/x-protobuf")
	public Accounts findAll() {
		return Accounts.newBuilder().addAllAccount(repository.findAll()).build();
	}
}
