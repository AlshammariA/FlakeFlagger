@Test public void testUndefinedValues(){
  String withUndefinedValues="${axyz}";
  String result=OptionHelper.substVars(withUndefinedValues,context);
  assertEquals("axyz" + OptionHelper._IS_UNDEFINED,result);
}
