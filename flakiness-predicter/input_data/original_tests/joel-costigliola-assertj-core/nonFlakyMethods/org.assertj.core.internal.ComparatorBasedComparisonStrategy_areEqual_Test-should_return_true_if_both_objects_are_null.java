@Test public void should_return_true_if_both_objects_are_null(){
  assertTrue(caseInsensitiveComparisonStrategy.areEqual(null,null));
}
