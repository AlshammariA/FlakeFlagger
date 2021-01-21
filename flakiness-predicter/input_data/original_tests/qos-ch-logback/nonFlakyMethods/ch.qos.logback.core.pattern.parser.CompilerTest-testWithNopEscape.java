@Test public void testWithNopEscape() throws Exception {
{
    Parser<Object> p=new Parser<Object>("xyz %hello\\_world");
    p.setContext(context);
    Node t=p.parse();
    Converter<Object> head=p.compile(t,converterMap);
    String result=write(head,new Object());
    assertEquals("xyz Helloworld",result);
  }
}
