@Test public void should_fail_if_actual_does_not_contain_value_at_index(){
  AssertionInfo info=someInfo();
  boolean value=true;
  Index index=atIndex(1);
  try {
    arrays.assertContains(info,actual,value,index);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldContainAtIndex(actual,value,index,false));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
