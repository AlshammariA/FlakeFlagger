@Test public void should_fail_if_actual_contains_given_values_more_than_once(){
  AssertionInfo info=someInfo();
  actual.addAll(newArrayList("Luke","Luke",null,null));
  Object[] expected={"Luke","Luke","Yoda","Han",null};
  try {
    iterables.assertContainsOnlyOnce(someInfo(),actual,expected);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldContainsOnlyOnce(actual,expected,newLinkedHashSet("Han"),newLinkedHashSet("Luke",null)));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
