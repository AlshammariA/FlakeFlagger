@Test public void should_fail_if_actual_does_not_contains_null_value(){
  AssertionInfo info=someInfo();
  actual.addAll(newArrayList("Luke","Luke"));
  Object[] expected={null};
  try {
    iterables.assertContainsOnlyOnce(someInfo(),actual,expected);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldContainsOnlyOnce(actual,expected,newLinkedHashSet(array((String)null)),newLinkedHashSet()));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
