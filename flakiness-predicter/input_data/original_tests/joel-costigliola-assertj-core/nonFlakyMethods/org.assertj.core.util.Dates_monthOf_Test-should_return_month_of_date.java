@Test public void should_return_month_of_date() throws ParseException {
  String dateAsString="26/08/1994";
  Date date=new SimpleDateFormat("dd/MM/yyyy").parse(dateAsString);
  assertEquals(8,monthOf(date));
}
