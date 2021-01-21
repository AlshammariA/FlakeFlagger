@Test public void should_fail_if_actual_is_not_lowercase(){
  AssertionInfo info=someInfo();
  try {
    characters.assertLowerCase(info,'A');
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeLowerCase('A'));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
