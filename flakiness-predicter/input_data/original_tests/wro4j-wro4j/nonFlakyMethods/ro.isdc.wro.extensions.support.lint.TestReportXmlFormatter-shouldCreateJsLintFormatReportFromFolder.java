@Test public void shouldCreateJsLintFormatReportFromFolder() throws Exception {
  final URL url=getClass().getResource("formatter/xml/jslint");
  checkFormattedReportsFromFolder(url,ReportXmlFormatter.FormatterType.JSLINT);
}
