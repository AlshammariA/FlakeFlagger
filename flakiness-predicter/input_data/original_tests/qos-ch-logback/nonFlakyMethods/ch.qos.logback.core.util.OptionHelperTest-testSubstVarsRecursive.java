@Test public void testSubstVarsRecursive(){
  context.putProperty("v1","if");
  context.putProperty("v2","${v3}");
  context.putProperty("v3","works");
  String result=OptionHelper.substVars(text,context);
  assertEquals(expected,result);
}
