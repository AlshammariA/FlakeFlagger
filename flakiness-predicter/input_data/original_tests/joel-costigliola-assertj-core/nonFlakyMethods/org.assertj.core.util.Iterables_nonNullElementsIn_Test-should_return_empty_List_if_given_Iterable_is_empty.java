@Test public void should_return_empty_List_if_given_Iterable_is_empty(){
  Collection<String> c=new ArrayList<>();
  assertTrue(Iterables.nonNullElementsIn(c).isEmpty());
}
