@Test public void should_fail_if_actual_does_not_contain_value_at_index(){
  AssertionInfo info=someInfo();
  Index index=atIndex(1);
  try {
    arrays.assertContains(info,actual,"Han",index);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldContainAtIndex(actual,"Han",index,"Luke"));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
