@Test public void should_fail_if_actual_does_not_end_with_other(){
  when(actual.endsWith(other)).thenReturn(false);
  try {
    paths.assertEndsWithRaw(info,actual,other);
    wasExpectingAssertionError();
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldEndWith(actual,other));
  }
}
