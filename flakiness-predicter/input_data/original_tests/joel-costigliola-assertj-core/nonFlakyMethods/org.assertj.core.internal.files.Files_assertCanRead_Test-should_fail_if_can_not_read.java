@Test public void should_fail_if_can_not_read(){
  when(actual.canRead()).thenReturn(false);
  AssertionInfo info=someInfo();
  try {
    files.assertCanRead(info,actual);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeReadable(actual));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
