@Test public void testBasic() throws Exception {
{
    Parser<Object> p=new Parser<Object>("abc %hello");
    p.setContext(context);
    Node t=p.parse();
    Converter<Object> head=p.compile(t,converterMap);
    String result=write(head,new Object());
    assertEquals("abc Hello",result);
  }
{
    Parser<Object> p=new Parser<Object>("abc %hello %OTT");
    p.setContext(context);
    Node t=p.parse();
    Converter<Object> head=p.compile(t,converterMap);
    String result=write(head,new Object());
    assertEquals("abc Hello 123",result);
  }
}
