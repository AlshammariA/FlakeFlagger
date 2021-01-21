@Test public void shouldNotFailWhenNoErrorsAreReported(){
  final LintReport<LinterError> lintReport=new LintReport<LinterError>();
  lintReport.addReport(new ResourceLintReport<LinterError>());
  final StringWriter writer=new StringWriter();
  ReportXmlFormatter.createForLinterError(lintReport,ReportXmlFormatter.FormatterType.LINT).write(new WriterOutputStream(writer));
  assertNotNull(writer.toString());
}
