@Test public void should_return_null_if_calendar_is_null(){
  assertNull(formatAsDatetime((Calendar)null));
}
