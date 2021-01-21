@Test public void testComposite() throws Exception {
{
    Parser p=new Parser("hello%(%child)");
    Node t=p.parse();
    Node witness=new Node(Node.LITERAL,"hello");
    CompositeNode composite=new CompositeNode(BARE);
    Node child=new SimpleKeywordNode("child");
    composite.setChildNode(child);
    witness.next=composite;
    assertEquals(witness,t);
  }
{
    Parser p=new Parser("hello%(%child )");
    Node t=p.parse();
    Node witness=new Node(Node.LITERAL,"hello");
    CompositeNode composite=new CompositeNode(BARE);
    Node child=new SimpleKeywordNode("child");
    composite.setChildNode(child);
    witness.next=composite;
    child.next=new Node(Node.LITERAL," ");
    assertEquals(witness,t);
  }
{
    Parser p=new Parser("hello%(%child %h)");
    Node t=p.parse();
    Node witness=new Node(Node.LITERAL,"hello");
    CompositeNode composite=new CompositeNode(BARE);
    Node child=new SimpleKeywordNode("child");
    composite.setChildNode(child);
    child.next=new Node(Node.LITERAL," ");
    child.next.next=new SimpleKeywordNode("h");
    witness.next=composite;
    assertEquals(witness,t);
  }
{
    Parser p=new Parser("hello%(%child %h) %m");
    Node t=p.parse();
    Node witness=new Node(Node.LITERAL,"hello");
    CompositeNode composite=new CompositeNode(BARE);
    Node child=new SimpleKeywordNode("child");
    composite.setChildNode(child);
    child.next=new Node(Node.LITERAL," ");
    child.next.next=new SimpleKeywordNode("h");
    witness.next=composite;
    composite.next=new Node(Node.LITERAL," ");
    composite.next.next=new SimpleKeywordNode("m");
    assertEquals(witness,t);
  }
{
    Parser p=new Parser("hello%( %child \\(%h\\) ) %m");
    Node t=p.parse();
    Node witness=new Node(Node.LITERAL,"hello");
    CompositeNode composite=new CompositeNode(BARE);
    Node child=new Node(Node.LITERAL," ");
    composite.setChildNode(child);
    Node c=child;
    c=c.next=new SimpleKeywordNode("child");
    c=c.next=new Node(Node.LITERAL," (");
    c=c.next=new SimpleKeywordNode("h");
    c=c.next=new Node(Node.LITERAL,") ");
    witness.next=composite;
    composite.next=new Node(Node.LITERAL," ");
    composite.next.next=new SimpleKeywordNode("m");
    assertEquals(witness,t);
  }
}
