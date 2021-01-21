@Test public void should_fail_if_actual_starts_with_first_elements_of_sequence_only(){
  AssertionInfo info=someInfo();
  Object[] sequence={"Leia","Obi-Wan","Han"};
  try {
    arrays.assertStartsWith(info,actual,sequence);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldStartWith(actual,sequence));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
