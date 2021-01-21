@Test public void should_return_List_containing_all_elements_in_iterable(){
  String[] expected={"One","Two"};
  Iterable<String> elements=asList(expected);
  ArrayList<String> list=Lists.newArrayList(elements);
  assertArrayEquals(expected,list.toArray());
}
