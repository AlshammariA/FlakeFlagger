@Test public void fullFormat() throws IOException {
  Date date=date(19,6,2012);
  String expected=DateFormat.getDateInstance(DateFormat.FULL,Locale.getDefault()).format(date);
  shouldCompileTo("{{dateFormat this \"full\"}}",date,expected);
}
