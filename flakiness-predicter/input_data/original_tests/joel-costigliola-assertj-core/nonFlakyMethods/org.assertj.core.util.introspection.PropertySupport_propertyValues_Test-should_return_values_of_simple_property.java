@Test public void should_return_values_of_simple_property(){
  Iterable<Integer> ages=PropertySupport.instance().propertyValues("age",Integer.class,employees);
  assertThat(ages).containsExactly(800,26);
}
