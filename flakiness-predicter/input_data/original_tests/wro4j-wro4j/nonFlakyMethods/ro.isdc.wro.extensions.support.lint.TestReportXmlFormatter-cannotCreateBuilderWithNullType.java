@Test(expected=NullPointerException.class) public void cannotCreateBuilderWithNullType(){
  ReportXmlFormatter.create(new LintReport<LintItem>(),null);
}
