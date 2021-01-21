@Test public void should_fail_if_actual_does_not_contain_null(){
  AssertionInfo info=someInfo();
  actual=newArrayList("Luke","Yoda");
  try {
    iterables.assertContainsNull(info,actual);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldContainNull(actual));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
