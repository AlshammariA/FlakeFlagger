@Test public void should_return_values_of_nested_property(){
  Iterable<String> firstNames=PropertySupport.instance().propertyValues("name.first",String.class,employees);
  assertThat(firstNames).containsExactly("Yoda","Luke");
}
