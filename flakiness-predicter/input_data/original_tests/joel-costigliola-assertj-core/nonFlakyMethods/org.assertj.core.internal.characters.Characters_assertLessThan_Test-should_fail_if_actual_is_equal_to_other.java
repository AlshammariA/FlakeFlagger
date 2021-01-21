@Test public void should_fail_if_actual_is_equal_to_other(){
  AssertionInfo info=someInfo();
  try {
    characters.assertLessThan(info,'b','b');
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeLess('b','b'));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
