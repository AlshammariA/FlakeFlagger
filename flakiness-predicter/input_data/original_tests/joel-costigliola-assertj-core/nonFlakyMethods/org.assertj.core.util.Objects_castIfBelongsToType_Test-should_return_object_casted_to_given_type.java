@Test public void should_return_object_casted_to_given_type(){
  Object o="Frodo";
  String casted=Objects.castIfBelongsToType(o,String.class);
  assertSame(casted,o);
}
