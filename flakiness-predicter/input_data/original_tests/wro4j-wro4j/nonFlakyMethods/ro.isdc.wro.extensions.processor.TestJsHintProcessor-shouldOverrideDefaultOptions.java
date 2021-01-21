@Test(expected=LinterException.class) public void shouldOverrideDefaultOptions() throws Exception {
  victim=new JsHintProcessor(){
    @Override protected String createDefaultOptions(){
      return "bitwise";
    }
    @Override protected void onLinterException(    final LinterException e,    final Resource resource){
      throw e;
    }
  }
;
  victim.process(null,new StringReader("true & false"),new StringWriter());
}
