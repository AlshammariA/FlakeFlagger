@Test public void shouldIgnoreNullLints(){
  final List<String> lints=new ArrayList<String>();
  lints.add(null);
  lints.add(null);
  final ResourceLintReport<String> report=ResourceLintReport.create("uri",lints);
  assertTrue(report.getLints().isEmpty());
}
