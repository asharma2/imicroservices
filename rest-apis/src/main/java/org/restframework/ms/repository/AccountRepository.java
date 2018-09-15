package org.restframework.ms.repository;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.restframework.ms.protobuf.CustomerProto.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountRepository {

	private Map<String, Account> accounts = Builder.<String, Account>builder()
	        .with("aaa-aaa-aaa", Account.newBuilder().setId(1).setCustomerId(1).setNumber("aaa-aaa-aaa").build())
	        .with("bbb-bbb-bbb", Account.newBuilder().setId(2).setCustomerId(1).setNumber("bbb-bbb-bbb").build())
	        .with("ccc-ccc-ccc", Account.newBuilder().setId(3).setCustomerId(2).setNumber("ccc-ccc-ccc").build())
	        .with("ddd-ddd-ddd", Account.newBuilder().setId(4).setCustomerId(3).setNumber("ddd-ddd-ddd").build()).build();

	private Map<Integer, List<Account>> customersAccount = Builder.<Integer, List<Account>>builder()
	        .with(1, Arrays.asList(Account.newBuilder().setId(1).setCustomerId(1).setNumber("aaa-aaa-aaa").build(),
	                Account.newBuilder().setId(2).setCustomerId(1).setNumber("bbb-bbb-bbb").build()))
	        .with(2, Arrays.asList(Account.newBuilder().setId(3).setCustomerId(2).setNumber("ccc-ccc-ccc").build()))
	        .with(3, Arrays.asList(Account.newBuilder().setId(4).setCustomerId(3).setNumber("ddd-ddd-ddd").build())).build();

	public Account findByNumber(String number) {
		return accounts.get(number);
	}

	public List<? extends Account> findByCustomer(Integer customerId) {
		return customersAccount.get(customerId);
	}

	public List<? extends Account> findAll() {
		return new LinkedList<>(accounts.values());
	}

	protected static class Builder<K, V> {
		Map<K, V> cache = new HashMap<>();

		private Builder() {
		}

		public static <K, V> Builder<K, V> builder() {
			return new Builder<>();
		}

		public Builder<K, V> with(K key, V value) {
			this.cache.put(key, value);
			return this;
		}

		public Map<K, V> build() {
			return cache;
		}

	}
}
