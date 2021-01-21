@Test public void should_fail_if_actual_does_not_contain_values(){
  AssertionInfo info=someInfo();
  Object[] expected={"Han","Luke"};
  try {
    iterables.assertContains(info,actual,expected);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldContain(actual,expected,newLinkedHashSet("Han")));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
