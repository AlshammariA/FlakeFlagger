@Test public void should_fail_if_actual_does_not_contain_value_at_index(){
  float value=6f;
  AssertionInfo info=someInfo();
  Index index=atIndex(1);
  try {
    arrays.assertContains(info,actual,value,index);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldContainAtIndex(actual,value,index,8f));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
