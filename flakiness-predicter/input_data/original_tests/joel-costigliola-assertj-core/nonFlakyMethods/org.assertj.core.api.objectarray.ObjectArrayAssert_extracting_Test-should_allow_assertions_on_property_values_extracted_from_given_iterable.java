@Test public void should_allow_assertions_on_property_values_extracted_from_given_iterable() throws Exception {
  assertThat(employees).extracting("age").containsOnly(800,26);
}
