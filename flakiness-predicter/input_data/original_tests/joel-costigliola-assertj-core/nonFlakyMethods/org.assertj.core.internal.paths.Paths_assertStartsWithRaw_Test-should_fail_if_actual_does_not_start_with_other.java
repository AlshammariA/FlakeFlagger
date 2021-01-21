@Test public void should_fail_if_actual_does_not_start_with_other(){
  when(actual.startsWith(other)).thenReturn(false);
  try {
    paths.assertStartsWithRaw(info,actual,other);
    wasExpectingAssertionError();
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldStartWith(actual,other));
  }
}
