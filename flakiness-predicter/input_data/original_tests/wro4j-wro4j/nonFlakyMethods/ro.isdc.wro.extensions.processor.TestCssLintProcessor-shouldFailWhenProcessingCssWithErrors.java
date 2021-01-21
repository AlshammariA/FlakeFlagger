@Test(expected=CssLintException.class) public void shouldFailWhenProcessingCssWithErrors() throws Exception {
  victim=new CssLintProcessor(){
    @Override protected void onCssLintException(    final CssLintException e,    final Resource resource){
      throw e;
    }
  }
;
  victim.setOptions("import");
  victim.process(null,new StringReader("@import url(more.css);"),new StringWriter());
}
