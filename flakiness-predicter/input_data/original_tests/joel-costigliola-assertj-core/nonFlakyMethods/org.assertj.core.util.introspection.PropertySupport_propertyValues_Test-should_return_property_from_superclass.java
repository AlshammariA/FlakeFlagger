@Test public void should_return_property_from_superclass(){
  assertThat(PropertySupport.instance().propertyValues("class",Class.class,employees)).containsExactly(Employee.class,Employee.class);
}
