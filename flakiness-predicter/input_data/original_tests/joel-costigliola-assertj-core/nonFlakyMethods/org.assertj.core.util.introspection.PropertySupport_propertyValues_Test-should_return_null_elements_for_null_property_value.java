@Test public void should_return_null_elements_for_null_property_value(){
  List<Employee> list=newArrayList(null,null);
  Iterable<Integer> ages=PropertySupport.instance().propertyValues("ages",Integer.class,list);
  assertThat(ages).containsExactly(null,null);
  list=newArrayList(yoda,luke,null,null);
  ages=PropertySupport.instance().propertyValues("age",Integer.class,list);
  assertThat(ages).containsExactly(800,26,null,null);
}
