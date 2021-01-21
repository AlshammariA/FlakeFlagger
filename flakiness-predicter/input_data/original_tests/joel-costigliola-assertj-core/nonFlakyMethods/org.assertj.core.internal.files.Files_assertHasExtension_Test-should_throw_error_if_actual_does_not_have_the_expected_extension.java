@Test public void should_throw_error_if_actual_does_not_have_the_expected_extension() throws Exception {
  AssertionInfo info=someInfo();
  when(actual.isFile()).thenReturn(true);
  when(actual.getName()).thenReturn("file.png");
  try {
    files.assertHasExtension(info,actual,expectedExtension);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldHaveExtension(actual,"png",expectedExtension));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
