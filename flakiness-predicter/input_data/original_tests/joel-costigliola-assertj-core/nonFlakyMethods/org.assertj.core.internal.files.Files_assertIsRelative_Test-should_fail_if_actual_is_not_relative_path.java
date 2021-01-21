@Test public void should_fail_if_actual_is_not_relative_path(){
  when(actual.isAbsolute()).thenReturn(true);
  AssertionInfo info=someInfo();
  try {
    files.assertIsRelative(info,actual);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeRelativePath(actual));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
