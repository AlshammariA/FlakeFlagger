@Test public void should_fail_if_actual_contains_duplicates(){
  AssertionInfo info=someInfo();
  Collection<String> duplicates=newLinkedHashSet("Luke","Yoda");
  actual.addAll(duplicates);
  try {
    iterables.assertDoesNotHaveDuplicates(info,actual);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldNotHaveDuplicates(actual,duplicates));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
