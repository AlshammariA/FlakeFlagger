@Test public void testLiteral() throws Exception {
  Parser<Object> p=new Parser<Object>("hello");
  Node t=p.parse();
  Converter<Object> head=p.compile(t,converterMap);
  String result=write(head,new Object());
  assertEquals("hello",result);
}
