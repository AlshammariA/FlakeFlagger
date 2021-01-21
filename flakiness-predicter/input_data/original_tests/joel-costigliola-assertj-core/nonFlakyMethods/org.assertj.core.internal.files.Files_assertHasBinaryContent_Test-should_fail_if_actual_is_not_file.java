@Test public void should_fail_if_actual_is_not_file(){
  AssertionInfo info=someInfo();
  File notAFile=new File("xyz");
  try {
    files.assertHasBinaryContent(info,notAFile,expected);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeFile(notAFile));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
