@Test public void should_return_empty_List_if_given_Iterable_is_empty(){
  Iterable<Integer> ages=PropertySupport.instance().propertyValues("ages",Integer.class,emptySet());
  assertThat(ages).isEmpty();
}
