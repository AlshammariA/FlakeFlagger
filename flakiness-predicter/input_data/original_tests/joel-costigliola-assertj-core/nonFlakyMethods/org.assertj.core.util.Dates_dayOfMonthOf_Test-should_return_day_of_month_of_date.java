@Test public void should_return_day_of_month_of_date() throws ParseException {
  String dateAsString="26/08/1994";
  Date date=new SimpleDateFormat("dd/MM/yyyy").parse(dateAsString);
  assertEquals(26,dayOfMonthOf(date));
}
