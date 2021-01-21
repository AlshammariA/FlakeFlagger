@Test public void should_throw_error_if_actual_does_not_have_the_expected_name() throws Exception {
  AssertionInfo info=someInfo();
  when(actual.getName()).thenReturn("not.expected.name");
  try {
    files.assertHasName(info,actual,expectedName);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldHaveName(actual,expectedName));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
