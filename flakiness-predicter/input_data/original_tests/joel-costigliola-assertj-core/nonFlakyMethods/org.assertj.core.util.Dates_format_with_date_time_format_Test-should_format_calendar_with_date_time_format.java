@Test public void should_format_calendar_with_date_time_format(){
  Calendar calendar=new GregorianCalendar();
  calendar.set(2011,04,15,14,59,33);
  assertEquals("2011-05-15T14:59:33",formatAsDatetime(calendar));
}
