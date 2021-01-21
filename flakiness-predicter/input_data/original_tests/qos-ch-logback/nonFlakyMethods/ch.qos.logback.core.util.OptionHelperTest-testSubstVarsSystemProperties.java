@Test public void testSubstVarsSystemProperties(){
  System.setProperty("v1","if");
  System.setProperty("v2","works");
  String result=OptionHelper.substVars(text,context);
  assertEquals(expected,result);
  System.clearProperty("v1");
  System.clearProperty("v2");
}
