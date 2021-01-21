@Test(expected=LinterException.class) public void shouldFailWhenScriptContainsErrors() throws Exception {
  final ResourcePostProcessor processor=new JsLintProcessor(){
    @Override protected void onLinterException(    final LinterException e,    final Resource resource){
      throw e;
    }
    @Override protected String createDefaultOptions(){
      return "maxerr=1";
    }
  }
;
  processor.process(new StringReader("alert(;"),new StringWriter());
}
