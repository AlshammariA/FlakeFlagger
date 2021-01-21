@Test public void mediumFormat() throws IOException {
  Date date=date(19,6,2012);
  String expected=DateFormat.getDateInstance(DateFormat.MEDIUM,Locale.getDefault()).format(date);
  shouldCompileTo("{{dateFormat this \"medium\"}}",date,expected);
}
