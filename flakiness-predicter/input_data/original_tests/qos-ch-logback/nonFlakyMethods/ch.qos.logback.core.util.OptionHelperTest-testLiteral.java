@Test public void testLiteral(){
  String noSubst="hello world";
  String result=OptionHelper.substVars(noSubst,context);
  assertEquals(noSubst,result);
}
