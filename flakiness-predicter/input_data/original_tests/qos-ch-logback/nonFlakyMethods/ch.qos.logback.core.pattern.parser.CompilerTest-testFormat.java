@Test public void testFormat() throws Exception {
{
    Parser<Object> p=new Parser<Object>("abc %7hello");
    p.setContext(context);
    Node t=p.parse();
    Converter<Object> head=p.compile(t,converterMap);
    String result=write(head,new Object());
    assertEquals("abc   Hello",result);
  }
{
    Parser<Object> p=new Parser<Object>("abc %-7hello");
    p.setContext(context);
    Node t=p.parse();
    Converter<Object> head=p.compile(t,converterMap);
    String result=write(head,new Object());
    assertEquals("abc Hello  ",result);
  }
{
    Parser<Object> p=new Parser<Object>("abc %.3hello");
    p.setContext(context);
    Node t=p.parse();
    Converter<Object> head=p.compile(t,converterMap);
    String result=write(head,new Object());
    assertEquals("abc llo",result);
  }
{
    Parser<Object> p=new Parser<Object>("abc %.-3hello");
    p.setContext(context);
    Node t=p.parse();
    Converter<Object> head=p.compile(t,converterMap);
    String result=write(head,new Object());
    assertEquals("abc Hel",result);
  }
{
    Parser<Object> p=new Parser<Object>("abc %4.5OTT");
    p.setContext(context);
    Node t=p.parse();
    Converter<Object> head=p.compile(t,converterMap);
    String result=write(head,new Object());
    assertEquals("abc  123",result);
  }
{
    Parser<Object> p=new Parser<Object>("abc %-4.5OTT");
    p.setContext(context);
    Node t=p.parse();
    Converter<Object> head=p.compile(t,converterMap);
    String result=write(head,new Object());
    assertEquals("abc 123 ",result);
  }
{
    Parser<Object> p=new Parser<Object>("abc %3.4hello");
    p.setContext(context);
    Node t=p.parse();
    Converter<Object> head=p.compile(t,converterMap);
    String result=write(head,new Object());
    assertEquals("abc ello",result);
  }
{
    Parser<Object> p=new Parser<Object>("abc %-3.-4hello");
    p.setContext(context);
    Node t=p.parse();
    Converter<Object> head=p.compile(t,converterMap);
    String result=write(head,new Object());
    assertEquals("abc Hell",result);
  }
}
