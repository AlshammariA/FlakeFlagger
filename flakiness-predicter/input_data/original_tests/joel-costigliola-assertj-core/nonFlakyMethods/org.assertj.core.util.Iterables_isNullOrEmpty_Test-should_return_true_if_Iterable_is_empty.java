@Test public void should_return_true_if_Iterable_is_empty(){
  Iterable<String> i=new StringIterable();
  assertTrue(Iterables.isNullOrEmpty(i));
}
