@Test public void should_return_toString_of_date(){
  Date date=new GregorianCalendar(2011,Calendar.JUNE,18,23,53,17).getTime();
  assertEquals("2011-06-18T23:53:17",new StandardRepresentation().toStringOf(date));
}
