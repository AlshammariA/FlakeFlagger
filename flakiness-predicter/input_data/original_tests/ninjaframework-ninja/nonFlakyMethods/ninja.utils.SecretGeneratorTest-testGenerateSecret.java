@Test public void testGenerateSecret(){
  assertEquals("5EJYQbXUb81LhuSoNO5l4eh2ZrNPoUBzZaGNixcPOFUsKzRkpTOeu9sm8CGUKaXZ",SecretGenerator.generateSecret(new Random(323232L)));
  assertEquals("oC8rHI6rDAiYSgMKHP6b4NlWG8UDdo5ALy66t3h2A5mhwWIBGjdyeFDBCoUn8Cov",SecretGenerator.generateSecret(new Random(2L)));
  assertEquals("0C27oI94jXZkXyB0ID8ZPq1zinxNmrenSwItFwRXphCKOC6ZwGTFX3nYZsYKafxw",SecretGenerator.generateSecret(new Random(3L)));
}
