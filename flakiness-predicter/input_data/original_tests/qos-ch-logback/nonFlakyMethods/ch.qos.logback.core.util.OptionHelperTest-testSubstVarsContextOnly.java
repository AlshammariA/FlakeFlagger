@Test public void testSubstVarsContextOnly(){
  context.putProperty("v1","if");
  context.putProperty("v2","works");
  String result=OptionHelper.substVars(text,context);
  assertEquals(expected,result);
}
