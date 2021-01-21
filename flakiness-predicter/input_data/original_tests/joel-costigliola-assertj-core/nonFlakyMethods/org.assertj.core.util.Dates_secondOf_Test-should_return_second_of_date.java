@Test public void should_return_second_of_date() throws ParseException {
  String dateAsString="26/08/1994T22:35:17";
  Date date=new SimpleDateFormat("dd/MM/yyyy'T'hh:mm:ss").parse(dateAsString);
  assertEquals(17,secondOf(date));
}
