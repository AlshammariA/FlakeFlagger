@Test public void should_fail_if_actual_does_not_contain_null(){
  AssertionInfo info=someInfo();
  actual=array("Luke","Yoda");
  try {
    arrays.assertContainsNull(info,actual);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldContainNull(actual));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
