@Test public void should_fail_if_can_not_write(){
  when(actual.canWrite()).thenReturn(false);
  AssertionInfo info=someInfo();
  try {
    files.assertCanWrite(info,actual);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeWritable(actual));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
