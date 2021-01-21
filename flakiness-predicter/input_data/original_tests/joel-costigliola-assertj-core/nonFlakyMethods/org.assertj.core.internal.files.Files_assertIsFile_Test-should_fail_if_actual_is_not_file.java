@Test public void should_fail_if_actual_is_not_file(){
  when(actual.isFile()).thenReturn(false);
  AssertionInfo info=someInfo();
  try {
    files.assertIsFile(info,actual);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeFile(actual));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
