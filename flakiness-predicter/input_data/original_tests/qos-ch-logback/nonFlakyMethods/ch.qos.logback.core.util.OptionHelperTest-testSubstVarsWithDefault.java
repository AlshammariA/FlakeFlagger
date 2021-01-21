@Test public void testSubstVarsWithDefault(){
  context.putProperty("v1","if");
  String textWithDefault="Testing ${v1} variable substitution ${v2:-toto}";
  String resultWithDefault="Testing if variable substitution toto";
  String result=OptionHelper.substVars(textWithDefault,context);
  assertEquals(resultWithDefault,result);
}
