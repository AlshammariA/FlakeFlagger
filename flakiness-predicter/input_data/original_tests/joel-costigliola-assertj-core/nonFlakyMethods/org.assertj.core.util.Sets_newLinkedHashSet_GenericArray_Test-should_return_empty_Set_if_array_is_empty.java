@Test public void should_return_empty_Set_if_array_is_empty(){
  LinkedHashSet<Object> set=Sets.newLinkedHashSet(new Object[0]);
  assertTrue(set.isEmpty());
}
