@Test public void should_not_fail_if_collections_is_empty_or_null(){
  List<String> hobbits=newArrayList();
  caseInsensitiveComparisonStrategy.iterableRemoves(hobbits,"SAM");
  caseInsensitiveComparisonStrategy.iterableRemoves(null,"SAM ");
}
