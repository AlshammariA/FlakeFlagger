@Test public void should_allow_assertions_on_method_invocation_result_extracted_from_given_iterable_with_enforcing_return_type() throws Exception {
  assertThat(jedis).extractingResultOf("name",Name.class).containsOnly(new Name("Yoda"),new Name("Darth Vader"));
}
