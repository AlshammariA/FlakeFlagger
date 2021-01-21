@Test public void should_fail_if_actual_does_not_contain_given_values_only(){
  AssertionInfo info=someInfo();
  short[] expected={6,8,20};
  try {
    arrays.assertContainsOnlyOnce(info,actual,expected);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldContainsOnlyOnce(actual,expected,newLinkedHashSet((short)20),newLinkedHashSet()));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
