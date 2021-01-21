@Test public void should_throw_error_when_no_property_nor_public_field_match_one_of_given_names(){
  thrown.expect(IntrospectionError.class);
  new ByNameMultipleExtractor<Employee>("id","name.first","unknown").extract(yoda);
}
