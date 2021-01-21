@Test public void should_fail_if_actual_does_not_contain_value_at_index(){
  AssertionInfo info=someInfo();
  byte value=6;
  Index index=atIndex(1);
  try {
    arrays.assertContains(info,actual,value,index);
  }
 catch (  AssertionError e) {
    byte found=8;
    verify(failures).failure(info,shouldContainAtIndex(actual,value,index,found));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
