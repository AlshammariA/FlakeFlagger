@Test public void should_fail_if_actual_contains_given_values(){
  AssertionInfo info=someInfo();
  short[] expected={6,8,20};
  try {
    arrays.assertDoesNotContain(info,actual,expected);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldNotContain(actual,expected,newLinkedHashSet((short)6,(short)8)));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
