@Test public void shortFormat() throws IOException {
  Date date=date(19,6,2012);
  String expected=DateFormat.getDateInstance(DateFormat.SHORT,Locale.getDefault()).format(date);
  shouldCompileTo("{{dateFormat this \"short\"}}",date,expected);
}
