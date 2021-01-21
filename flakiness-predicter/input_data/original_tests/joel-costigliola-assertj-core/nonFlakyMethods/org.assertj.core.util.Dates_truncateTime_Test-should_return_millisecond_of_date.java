@Test public void should_return_millisecond_of_date() throws ParseException {
  Date date=new SimpleDateFormat("dd/MM/yyyy'T'hh:mm:ss:SS").parse("26/08/1994T22:35:17:29");
  Date expectedDate=new SimpleDateFormat("dd/MM/yyyy").parse("26/08/1994");
  assertEquals(expectedDate,truncateTime(date));
}
