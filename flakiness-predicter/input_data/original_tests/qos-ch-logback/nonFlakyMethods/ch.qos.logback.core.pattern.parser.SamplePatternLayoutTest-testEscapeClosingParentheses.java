@Test public void testEscapeClosingParentheses(){
  PatternLayoutBase<Object> plb=getPatternLayoutBase();
  Context context=new ContextBase();
  plb.setContext(context);
  plb.setPattern("x(%OTT\\)y");
  plb.start();
  String s=plb.doLayout(new Object());
  assertEquals("x(123)y",s);
}
