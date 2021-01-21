@Test public void should_allow_assertions_on_multiple_extracted_values_from_given_iterable() throws Exception {
  assertThat(employees).extracting("name.first","age","id").containsOnly(tuple("Yoda",800,1L),tuple("Luke",26,2L));
}
