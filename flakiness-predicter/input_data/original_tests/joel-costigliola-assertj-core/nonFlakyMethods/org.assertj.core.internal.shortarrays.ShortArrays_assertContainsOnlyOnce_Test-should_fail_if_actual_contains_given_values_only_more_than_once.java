@Test public void should_fail_if_actual_contains_given_values_only_more_than_once(){
  AssertionInfo info=someInfo();
  actual=arrayOf(6,-8,10,-6,-8,10,-8,6);
  short[] expected={6,-8,20};
  try {
    arrays.assertContainsOnlyOnce(info,actual,expected);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldContainsOnlyOnce(actual,expected,newLinkedHashSet((short)20),newLinkedHashSet((short)6,(short)-8)));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
