@Test public void testComposite() throws Exception {
{
    Context c=new ContextBase();
    Parser<Object> p=new Parser<Object>("%(ABC %hello)");
    p.setContext(c);
    Node t=p.parse();
    Converter<Object> head=p.compile(t,converterMap);
    String result=write(head,new Object());
    StatusPrinter.print(c);
    assertEquals("ABC Hello",result);
  }
{
    Parser<Object> p=new Parser<Object>("%(ABC %hello)");
    p.setContext(context);
    Node t=p.parse();
    Converter<Object> head=p.compile(t,converterMap);
    String result=write(head,new Object());
    assertEquals("ABC Hello",result);
  }
}
