@Test(expected=WroRuntimeException.class) public void testInvalidOptions() throws Exception {
  jsHint.setOptions("unused:vars");
  jsHint.validate("function test() {\n  alert(1);\n}");
}
