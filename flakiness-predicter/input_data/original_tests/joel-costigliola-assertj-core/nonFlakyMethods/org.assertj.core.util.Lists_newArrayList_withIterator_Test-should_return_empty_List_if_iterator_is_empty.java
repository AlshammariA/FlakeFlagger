@Test public void should_return_empty_List_if_iterator_is_empty(){
  Iterator<String> elements=new ArrayList<String>().iterator();
  ArrayList<String> list=Lists.newArrayList(elements);
  assertThat(list).isEmpty();
}
