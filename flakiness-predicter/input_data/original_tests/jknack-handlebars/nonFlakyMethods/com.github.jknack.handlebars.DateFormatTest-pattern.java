@Test public void pattern() throws IOException {
  Date date=date(19,6,2012);
  String expected=new SimpleDateFormat("dd/MM/yyyy",Locale.getDefault()).format(date);
  shouldCompileTo("{{dateFormat this \"dd/MM/yyyy\"}}",date,expected);
}
