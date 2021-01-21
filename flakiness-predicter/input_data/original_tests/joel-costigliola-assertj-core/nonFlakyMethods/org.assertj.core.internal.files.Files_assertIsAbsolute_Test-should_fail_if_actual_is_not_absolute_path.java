@Test public void should_fail_if_actual_is_not_absolute_path(){
  when(actual.isAbsolute()).thenReturn(false);
  AssertionInfo info=someInfo();
  try {
    files.assertIsAbsolute(info,actual);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeAbsolutePath(actual));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
