@Test public void should_fail_if_actual_has_message_not_ending_with_expected_description(){
  AssertionInfo info=someInfo();
  try {
    throwables.assertHasMessageEndingWith(info,actual,"expected end");
    fail("AssertionError expected");
  }
 catch (  AssertionError err) {
    verify(failures).failure(info,shouldEndWith(actual.getMessage(),"expected end"));
  }
}
