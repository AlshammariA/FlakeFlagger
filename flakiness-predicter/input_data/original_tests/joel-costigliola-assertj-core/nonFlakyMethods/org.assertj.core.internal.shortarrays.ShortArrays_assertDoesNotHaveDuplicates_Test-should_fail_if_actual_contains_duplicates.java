@Test public void should_fail_if_actual_contains_duplicates(){
  AssertionInfo info=someInfo();
  actual=arrayOf(6,8,6,8);
  try {
    arrays.assertDoesNotHaveDuplicates(info,actual);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldNotHaveDuplicates(actual,newLinkedHashSet((short)6,(short)8)));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
