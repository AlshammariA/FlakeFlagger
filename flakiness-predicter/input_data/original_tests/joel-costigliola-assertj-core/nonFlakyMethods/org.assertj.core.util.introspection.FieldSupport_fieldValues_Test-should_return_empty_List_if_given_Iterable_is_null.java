@Test public void should_return_empty_List_if_given_Iterable_is_null(){
  Iterable<Long> ids=fieldSupport.fieldValues("ids",Long.class,(Iterable<Long>)null);
  assertEquals(emptyList(),ids);
}
