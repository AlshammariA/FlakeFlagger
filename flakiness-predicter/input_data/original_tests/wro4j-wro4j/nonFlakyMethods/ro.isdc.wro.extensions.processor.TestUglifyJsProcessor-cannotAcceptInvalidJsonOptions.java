@Test(expected=WroRuntimeException.class) public void cannotAcceptInvalidJsonOptions() throws Exception {
  new UglifyJs(UGLIFY){
    protected String createOptionsAsJson() throws IOException {
      return "This is an invalid JSON";
    }
  }
.process("filename","alert(1);");
}
