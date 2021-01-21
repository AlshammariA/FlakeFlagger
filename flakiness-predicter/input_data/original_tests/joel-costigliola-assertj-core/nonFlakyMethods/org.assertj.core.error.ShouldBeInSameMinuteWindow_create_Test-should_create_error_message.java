@Test public void should_create_error_message() throws ParseException {
  ErrorMessageFactory factory=shouldBeInSameMinuteWindow(parseDatetime("2011-01-01T05:00:00"),parseDatetime("2011-01-01T05:02:01"));
  String message=factory.create(new TextDescription("Test"),new StandardRepresentation());
  assertThat(message).isEqualTo("[Test] \nExpecting:\n  <2011-01-01T05:00:00>\nto be close to:\n  " + "<2011-01-01T05:02:01>\n" + "by less than one minute (strictly) but difference was: 2m and 1s");
}
