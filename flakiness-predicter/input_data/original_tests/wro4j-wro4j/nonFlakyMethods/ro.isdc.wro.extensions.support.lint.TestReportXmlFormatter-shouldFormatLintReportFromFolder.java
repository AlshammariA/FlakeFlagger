@Test public void shouldFormatLintReportFromFolder() throws Exception {
  final URL url=getClass().getResource("formatter/xml/lint");
  checkFormattedReportsFromFolder(url,ReportXmlFormatter.FormatterType.LINT);
}
