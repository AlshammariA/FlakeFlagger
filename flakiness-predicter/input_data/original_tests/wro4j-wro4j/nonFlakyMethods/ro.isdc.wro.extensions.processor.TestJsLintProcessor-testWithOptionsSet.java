@Test(expected=LinterException.class) public void testWithOptionsSet() throws Exception {
  final ResourcePostProcessor processor=new JsLintProcessor(){
    @Override protected void onLinterException(    final LinterException e,    final Resource resource){
      throw e;
    }
  }
.setOptionsAsString("maxerr=1");
  processor.process(new StringReader("alert(;"),new StringWriter());
}
