@Test public void should_fail_if_actual_has_message_not_starting_with_expected_description(){
  AssertionInfo info=someInfo();
  try {
    throwables.assertHasMessageStartingWith(info,actual,"expected start");
    fail("AssertionError expected");
  }
 catch (  AssertionError err) {
    verify(failures).failure(info,shouldStartWith(actual.getMessage(),"expected start"));
  }
}
