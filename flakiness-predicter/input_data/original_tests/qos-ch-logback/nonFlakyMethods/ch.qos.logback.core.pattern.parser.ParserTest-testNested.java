@Test public void testNested() throws Exception {
{
    Parser p=new Parser("%top %(%child%(%h))");
    Node t=p.parse();
    Node witness=new SimpleKeywordNode("top");
    Node w=witness.next=new Node(Node.LITERAL," ");
    CompositeNode composite=new CompositeNode(BARE);
    w=w.next=composite;
    Node child=new SimpleKeywordNode("child");
    composite.setChildNode(child);
    composite=new CompositeNode(BARE);
    child.next=composite;
    composite.setChildNode(new SimpleKeywordNode("h"));
    assertEquals(witness,t);
  }
}
