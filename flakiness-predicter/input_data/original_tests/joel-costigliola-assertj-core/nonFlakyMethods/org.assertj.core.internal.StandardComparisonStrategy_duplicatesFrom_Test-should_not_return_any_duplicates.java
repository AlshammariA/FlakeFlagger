@Test public void should_not_return_any_duplicates(){
  Iterable<?> duplicates=standardComparisonStrategy.duplicatesFrom(newArrayList("Frodo","Sam","Gandalf"));
  assertTrue(isNullOrEmpty(duplicates));
}
