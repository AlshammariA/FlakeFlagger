@Test public void testFormattingInfo() throws Exception {
{
    Parser p=new Parser("%45x");
    Node t=p.parse();
    FormattingNode witness=new SimpleKeywordNode("x");
    witness.setFormatInfo(new FormatInfo(45,Integer.MAX_VALUE));
    assertEquals(witness,t);
  }
{
    Parser p=new Parser("%4.5x");
    Node t=p.parse();
    FormattingNode witness=new SimpleKeywordNode("x");
    witness.setFormatInfo(new FormatInfo(4,5));
    assertEquals(witness,t);
  }
{
    Parser p=new Parser("%-4.5x");
    Node t=p.parse();
    FormattingNode witness=new SimpleKeywordNode("x");
    witness.setFormatInfo(new FormatInfo(4,5,false,true));
    assertEquals(witness,t);
  }
{
    Parser p=new Parser("%-4.-5x");
    Node t=p.parse();
    FormattingNode witness=new SimpleKeywordNode("x");
    witness.setFormatInfo(new FormatInfo(4,5,false,false));
    assertEquals(witness,t);
  }
{
    Parser p=new Parser("%-4.5x %12y");
    Node t=p.parse();
    FormattingNode witness=new SimpleKeywordNode("x");
    witness.setFormatInfo(new FormatInfo(4,5,false,true));
    Node n=witness.next=new Node(Node.LITERAL," ");
    n=n.next=new SimpleKeywordNode("y");
    ((FormattingNode)n).setFormatInfo(new FormatInfo(12,Integer.MAX_VALUE));
    assertEquals(witness,t);
  }
}
