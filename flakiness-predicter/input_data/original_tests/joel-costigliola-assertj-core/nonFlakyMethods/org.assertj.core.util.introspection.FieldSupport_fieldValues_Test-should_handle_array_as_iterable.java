@Test public void should_handle_array_as_iterable(){
  List<Long> fieldValuesFromIterable=fieldSupport.fieldValues("id",Long.class,employees);
  List<Long> fieldValuesFromArray=fieldSupport.fieldValues("id",Long.class,employees.toArray(new Employee[0]));
  assertThat(fieldValuesFromArray).isEqualTo(fieldValuesFromIterable);
}
