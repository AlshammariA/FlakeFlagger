@Test(expected=CssLintException.class) public void shouldOverrideDefaultOptions() throws Exception {
  victim=new CssLintProcessor(){
    @Override protected String createDefaultOptions(){
      return "import";
    }
    @Override protected void onCssLintException(    final CssLintException e,    final Resource resource){
      throw e;
    }
  }
;
  victim.process(null,new StringReader("@import url(more.css);"),new StringWriter());
}
