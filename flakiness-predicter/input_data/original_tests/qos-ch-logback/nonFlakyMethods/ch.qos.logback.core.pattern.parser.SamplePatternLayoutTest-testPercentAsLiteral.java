@Test public void testPercentAsLiteral(){
  PatternLayoutBase<Object> plb=getPatternLayoutBase();
  Context context=new ContextBase();
  plb.setContext(context);
  plb.setPattern("hello \\% world");
  plb.start();
  String s=plb.doLayout(new Object());
  assertEquals("hello % world",s);
}
