@Test public void should_return_empty_List_if_iterable_is_empty(){
  Iterable<String> elements=new ArrayList<>();
  ArrayList<String> list=Lists.newArrayList(elements);
  assertTrue(list.isEmpty());
}
