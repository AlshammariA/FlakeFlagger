@Test public void should_return_empty_List_if_given_Iterable_is_empty(){
  Iterable<Long> ids=fieldSupport.fieldValues("ids",Long.class,emptySet());
  assertEquals(emptyList(),ids);
}
