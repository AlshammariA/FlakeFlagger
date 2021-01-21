@Test public void commitHookChangesOnBranch() throws Exception {
  final int NUM_NODES=DocumentRootBuilder.UPDATE_LIMIT / 2;
  final int NUM_PROPS=10;
  DocumentNodeStore ns=new DocumentMK.Builder().getNodeStore();
  NodeBuilder builder=ns.getRoot().builder();
  for (int i=0; i < NUM_NODES; i++) {
    NodeBuilder c=builder.child("n" + i);
    for (int j=0; j < NUM_PROPS; j++) {
      c.setProperty("q" + j,"value");
      c.setProperty("p" + j,"value");
    }
  }
  try {
    ns.merge(builder,CompositeHook.compose(Arrays.asList(new TestHook("p"),new TestHook("q"),FAILING_HOOK)),CommitInfo.EMPTY);
    fail("merge must fail and reset changes done by commit hooks");
  }
 catch (  CommitFailedException e) {
  }
  for (int i=0; i < NUM_NODES; i++) {
    NodeBuilder c=builder.getChildNode("n" + i);
    assertTrue(c.exists());
    for (int j=0; j < NUM_PROPS; j++) {
      PropertyState p=c.getProperty("p" + j);
      assertNotNull(p);
      assertEquals("value",p.getValue(Type.STRING));
      p=c.getProperty("q" + j);
      assertNotNull(p);
      assertEquals("value",p.getValue(Type.STRING));
    }
  }
  ns.merge(builder,CompositeHook.compose(Arrays.<CommitHook>asList(new TestHook("p"),new TestHook("q"))),CommitInfo.EMPTY);
  builder=ns.getRoot().builder();
  for (int i=0; i < NUM_NODES; i++) {
    NodeBuilder c=builder.getChildNode("n" + i);
    assertTrue(c.exists());
    for (int j=0; j < NUM_PROPS; j++) {
      PropertyState p=c.getProperty("p" + j);
      assertNotNull(p);
      assertEquals("test",p.getValue(Type.STRING));
      p=c.getProperty("q" + j);
      assertNotNull(p);
      assertEquals("test",p.getValue(Type.STRING));
    }
  }
  ns.dispose();
}
