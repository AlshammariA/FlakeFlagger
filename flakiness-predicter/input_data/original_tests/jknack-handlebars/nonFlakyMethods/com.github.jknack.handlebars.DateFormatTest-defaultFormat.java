@Test public void defaultFormat() throws IOException {
  Date date=date(19,6,2012);
  String expected=DateFormat.getDateInstance(DateFormat.DEFAULT,Locale.getDefault()).format(date);
  shouldCompileTo("{{dateFormat this}}",date,expected);
}
