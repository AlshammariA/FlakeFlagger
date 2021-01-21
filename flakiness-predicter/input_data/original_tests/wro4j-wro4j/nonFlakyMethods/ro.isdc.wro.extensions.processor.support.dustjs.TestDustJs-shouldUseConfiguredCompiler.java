@Test public void shouldUseConfiguredCompiler() throws Exception {
  final File temp=WroUtil.createTempFile();
  IOUtils.copy(victim.getDefaultCompilerStream(),new FileOutputStream(temp));
  System.setProperty(DustJs.PARAM_COMPILER_PATH,temp.getPath());
  assertEquals("(function(){dust.register(null,body_0);function body_0(chk,ctx){return chk;}return body_0;})();",victim.compile(null,null));
}
