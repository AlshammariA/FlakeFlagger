@Test public void should_fail_if_actual_ends_with_first_elements_of_sequence_only(){
  AssertionInfo info=someInfo();
  long[] sequence={6L,20L,22L};
  try {
    arrays.assertEndsWith(info,actual,sequence);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldEndWith(actual,sequence));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
