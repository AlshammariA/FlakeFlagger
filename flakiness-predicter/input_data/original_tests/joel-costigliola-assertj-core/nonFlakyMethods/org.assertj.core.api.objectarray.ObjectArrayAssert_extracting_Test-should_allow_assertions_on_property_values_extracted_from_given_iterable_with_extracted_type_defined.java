@Test public void should_allow_assertions_on_property_values_extracted_from_given_iterable_with_extracted_type_defined() throws Exception {
  assertThat(employees).extracting("name",Name.class).containsOnly(new Name("Yoda"),new Name("Luke","Skywalker"));
}
