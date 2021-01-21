@Test public void should_fail_if_actual_does_not_contain_given_values_exactly(){
  AssertionInfo info=someInfo();
  boolean[] expected={true,true};
  try {
    arrays.assertContainsExactly(info,actual,expected);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldContainExactly(actual,expected,newLinkedHashSet(),newLinkedHashSet(false)));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
