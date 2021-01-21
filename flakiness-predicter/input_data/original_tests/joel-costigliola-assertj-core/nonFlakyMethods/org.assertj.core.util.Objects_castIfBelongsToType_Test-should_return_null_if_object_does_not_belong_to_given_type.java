@Test public void should_return_null_if_object_does_not_belong_to_given_type(){
  Object o=4;
  String casted=Objects.castIfBelongsToType(o,String.class);
  assertNull(casted);
}
