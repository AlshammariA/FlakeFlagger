@Test public void shouldBePossibleToExtendLessCssWithDifferentScriptStream() throws Exception {
  new UglifyJs(UGLIFY){
    @Override protected InputStream getScriptAsStream(){
      return UglifyJs.class.getResourceAsStream(UglifyJs.DEFAULT_UGLIFY_JS);
    }
  }
.process("filename","alert(1);");
}
