@Test(expected=NullPointerException.class) public void cannotCreateBuilderWithNullLintReport(){
  ReportXmlFormatter.create(null,ReportXmlFormatter.FormatterType.LINT);
}
