@Test public void should_not_return_any_duplicates_if_collection_is_empty(){
  Iterable<?> duplicates=caseInsensitiveComparisonStrategy.duplicatesFrom(new ArrayList<String>());
  assertTrue(isNullOrEmpty(duplicates));
}
