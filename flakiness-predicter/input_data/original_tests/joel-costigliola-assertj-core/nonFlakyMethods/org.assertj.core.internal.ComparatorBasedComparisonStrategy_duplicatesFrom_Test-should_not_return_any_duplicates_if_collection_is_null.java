@Test public void should_not_return_any_duplicates_if_collection_is_null(){
  Iterable<?> duplicates=caseInsensitiveComparisonStrategy.duplicatesFrom(null);
  assertTrue(isNullOrEmpty(duplicates));
}
