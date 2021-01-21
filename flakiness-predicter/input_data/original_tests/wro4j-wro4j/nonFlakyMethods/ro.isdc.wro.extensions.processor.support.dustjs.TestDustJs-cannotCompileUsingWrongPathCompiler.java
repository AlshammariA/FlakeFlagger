@Test(expected=WroRuntimeException.class) public void cannotCompileUsingWrongPathCompiler() throws Exception {
  System.setProperty(DustJs.PARAM_COMPILER_PATH,"/invalid/path/to/dust.js");
  victim.compile(null,null);
}
