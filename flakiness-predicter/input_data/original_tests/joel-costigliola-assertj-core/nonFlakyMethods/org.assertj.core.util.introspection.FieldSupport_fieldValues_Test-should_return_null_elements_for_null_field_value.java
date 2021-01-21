@Test public void should_return_null_elements_for_null_field_value(){
  List<Employee> list=newArrayList(null,null);
  Iterable<Long> ages=fieldSupport.fieldValues("id",Long.class,list);
  assertThat(ages).containsExactly(null,null);
  luke.setName(null);
  list=newArrayList(yoda,luke,null,null);
  Iterable<Name> names=fieldSupport.fieldValues("name",Name.class,list);
  assertThat(names).containsExactly(new Name("Yoda"),null,null,null);
  Iterable<String> firstNames=fieldSupport.fieldValues("name.first",String.class,list);
  assertThat(firstNames).containsExactly("Yoda",null,null,null);
}
