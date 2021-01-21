@Test public void should_fail_if_file_does_not_have_expected_text_content() throws IOException {
  List<String> diffs=newArrayList("line:1, expected:<line1> but was:<EOF>");
  when(diff.diff(actual,expected,charset)).thenReturn(diffs);
  AssertionInfo info=someInfo();
  try {
    files.assertHasContent(info,actual,expected,charset);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldHaveContent(actual,charset,diffs));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
