@Test public void should_return_false_if_array_has_at_least_one_element_not_null(){
  String[] array={null,"Frodo",null};
  assertFalse(Arrays.hasOnlyNullElements(array));
}
