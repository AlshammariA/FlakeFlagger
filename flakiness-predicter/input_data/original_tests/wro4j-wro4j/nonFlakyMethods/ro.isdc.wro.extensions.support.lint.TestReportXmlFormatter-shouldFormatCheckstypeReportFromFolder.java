@Test public void shouldFormatCheckstypeReportFromFolder() throws Exception {
  final URL url=getClass().getResource("formatter/xml/checkstyle");
  checkFormattedReportsFromFolder(url,ReportXmlFormatter.FormatterType.CHECKSTYLE);
}
