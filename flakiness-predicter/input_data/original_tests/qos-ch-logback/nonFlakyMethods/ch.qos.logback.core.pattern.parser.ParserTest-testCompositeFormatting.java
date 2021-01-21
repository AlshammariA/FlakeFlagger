@Test public void testCompositeFormatting() throws Exception {
  Parser p=new Parser("hello%5(XYZ)");
  Node t=p.parse();
  Node witness=new Node(Node.LITERAL,"hello");
  CompositeNode composite=new CompositeNode(BARE);
  composite.setFormatInfo(new FormatInfo(5,Integer.MAX_VALUE));
  Node child=new Node(Node.LITERAL,"XYZ");
  composite.setChildNode(child);
  witness.next=composite;
  assertEquals(witness,t);
}
