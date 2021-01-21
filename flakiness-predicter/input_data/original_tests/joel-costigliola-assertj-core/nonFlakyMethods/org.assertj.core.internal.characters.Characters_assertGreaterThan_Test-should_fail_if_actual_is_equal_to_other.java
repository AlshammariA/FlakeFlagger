@Test public void should_fail_if_actual_is_equal_to_other(){
  AssertionInfo someInfo=someInfo();
  try {
    characters.assertGreaterThan(someInfo,'b','b');
  }
 catch (  AssertionError e) {
    verify(failures).failure(someInfo,shouldBeGreater('b','b'));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
