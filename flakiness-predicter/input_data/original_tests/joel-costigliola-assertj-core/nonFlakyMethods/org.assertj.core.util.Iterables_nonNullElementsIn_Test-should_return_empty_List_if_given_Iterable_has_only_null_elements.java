@Test public void should_return_empty_List_if_given_Iterable_has_only_null_elements(){
  Collection<String> c=new ArrayList<>();
  c.add(null);
  assertTrue(Iterables.nonNullElementsIn(c).isEmpty());
}
