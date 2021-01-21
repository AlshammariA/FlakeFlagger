@Test public void should_fail_if_actual_does_not_contain_given_values_only(){
  AssertionInfo info=someInfo();
  long[] expected={6L,8L,20L};
  try {
    arrays.assertContainsOnly(info,actual,expected);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldContainOnly(actual,expected,newLinkedHashSet(20L),newLinkedHashSet(10L)));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
