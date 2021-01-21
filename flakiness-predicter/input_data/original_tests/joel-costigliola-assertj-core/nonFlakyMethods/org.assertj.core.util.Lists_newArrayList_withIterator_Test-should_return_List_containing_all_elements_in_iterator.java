@Test public void should_return_List_containing_all_elements_in_iterator(){
  String[] expected={"One","Two"};
  Iterator<String> elements=asList(expected).iterator();
  ArrayList<String> list=Lists.newArrayList(elements);
  assertThat(list).containsExactly(expected);
}
