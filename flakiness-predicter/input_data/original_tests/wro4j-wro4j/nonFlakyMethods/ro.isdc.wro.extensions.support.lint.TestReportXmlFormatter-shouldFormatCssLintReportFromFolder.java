@Test public void shouldFormatCssLintReportFromFolder() throws Exception {
  final URL url=getClass().getResource("formatter/xml/csslint");
  checkFormattedReportsFromFolder(url,ReportXmlFormatter.FormatterType.CSSLINT);
}
