@Test public void frLocale() throws IOException {
  Date date=date(19,6,2012);
  String expected=DateFormat.getDateInstance(DateFormat.SHORT,Locale.FRENCH).format(date);
  shouldCompileTo("{{dateFormat this \"short\" \"fr\"}}",date,expected);
}
