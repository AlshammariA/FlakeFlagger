@Test public void should_format_date_with_date_time_format() throws ParseException {
  String dateAsString="26/08/1994";
  SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy");
  assertEquals("1994-08-26T00:00:00",formatAsDatetime(formatter.parse(dateAsString)));
}
