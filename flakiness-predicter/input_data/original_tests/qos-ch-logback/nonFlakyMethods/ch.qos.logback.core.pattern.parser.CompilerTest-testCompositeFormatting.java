@Test public void testCompositeFormatting() throws Exception {
{
    Parser<Object> p=new Parser<Object>("xyz %4.10(ABC)");
    p.setContext(context);
    Node t=p.parse();
    Converter<Object> head=p.compile(t,converterMap);
    String result=write(head,new Object());
    assertEquals("xyz  ABC",result);
  }
{
    Parser<Object> p=new Parser<Object>("xyz %-4.10(ABC)");
    p.setContext(context);
    Node t=p.parse();
    Converter<Object> head=p.compile(t,converterMap);
    String result=write(head,new Object());
    assertEquals("xyz ABC ",result);
  }
{
    Parser<Object> p=new Parser<Object>("xyz %.2(ABC %hello)");
    p.setContext(context);
    Node t=p.parse();
    Converter<Object> head=p.compile(t,converterMap);
    String result=write(head,new Object());
    assertEquals("xyz lo",result);
  }
{
    Parser<Object> p=new Parser<Object>("xyz %.-2(ABC)");
    p.setContext(context);
    Node t=p.parse();
    Converter<Object> head=p.compile(t,converterMap);
    String result=write(head,new Object());
    assertEquals("xyz AB",result);
  }
{
    Parser<Object> p=new Parser<Object>("xyz %30.30(ABC %20hello)");
    p.setContext(context);
    Node t=p.parse();
    Converter<Object> head=p.compile(t,converterMap);
    String result=write(head,new Object());
    assertEquals("xyz       ABC                Hello",result);
  }
}
