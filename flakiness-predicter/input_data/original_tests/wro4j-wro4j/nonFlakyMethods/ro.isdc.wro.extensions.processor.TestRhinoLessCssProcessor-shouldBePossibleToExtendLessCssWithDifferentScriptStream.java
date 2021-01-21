@Test public void shouldBePossibleToExtendLessCssWithDifferentScriptStream(){
  new LessCss(){
    @Override protected InputStream getScriptAsStream() throws IOException {
      return TestRhinoCoffeeScriptProcessor.class.getResourceAsStream("less.js");
    }
  }
.less("#id {}");
}
