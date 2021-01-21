@Test public void should_return_hour_of_day_of_date() throws ParseException {
  String dateAsString="26/08/1994T22:35:00";
  Date date=new SimpleDateFormat("dd/MM/yyyy'T'hh:mm:ss").parse(dateAsString);
  assertEquals(22,hourOfDayOf(date));
}
