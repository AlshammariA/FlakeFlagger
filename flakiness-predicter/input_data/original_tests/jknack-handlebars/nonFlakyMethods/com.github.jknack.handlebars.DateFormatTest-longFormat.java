@Test public void longFormat() throws IOException {
  Date date=date(19,6,2012);
  String expected=DateFormat.getDateInstance(DateFormat.LONG,Locale.getDefault()).format(date);
  shouldCompileTo("{{dateFormat this \"long\"}}",date,expected);
}
