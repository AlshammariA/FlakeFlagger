@Test public void should_return_empty_List_if_given_Iterable_is_null(){
  Iterable<Integer> ages=PropertySupport.instance().propertyValues("ages",Integer.class,null);
  assertThat(ages).isEmpty();
}
