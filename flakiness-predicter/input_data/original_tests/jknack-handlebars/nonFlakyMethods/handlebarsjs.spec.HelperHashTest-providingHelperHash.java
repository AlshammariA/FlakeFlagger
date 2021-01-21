@Test public void providingHelperHash() throws IOException {
  shouldCompileTo("Goodbye {{cruel}} {{world}}!",$("cruel","cruel"),$("world","world"),"Goodbye cruel world!","helpers hash is available");
  shouldCompileTo("Goodbye {{#iter}}{{cruel}} {{world}}{{/iter}}!",$("iter",new Object[]{$("cruel","cruel")}),$("world","world"),"Goodbye cruel world!","helpers hash is available inside other blocks");
}
