@Test public void orderBefore() throws Exception {
  ContentSession s=repository.login(null,null);
  try {
    Root r=s.getLatestRoot();
    Tree t=r.getTree("/");
    t.addChild("node1");
    t.addChild("node2");
    t.addChild("node3");
    r.commit();
    t.getChild("node1").orderBefore("node2");
    t.getChild("node3").orderBefore(null);
    assertSequence(t.getChildren(),"node1","node2","node3");
    r.commit();
    assertSequence(t.getChildren(),"node1","node2","node3");
    t.getChild("node3").orderBefore("node2");
    assertSequence(t.getChildren(),"node1","node3","node2");
    r.commit();
    assertSequence(t.getChildren(),"node1","node3","node2");
    t.getChild("node1").orderBefore(null);
    assertSequence(t.getChildren(),"node3","node2","node1");
    r.commit();
    assertSequence(t.getChildren(),"node3","node2","node1");
    assertTrue(t.getProperty(":childOrder") == null);
    assertEquals("must not have any properties",0,t.getPropertyCount());
  }
  finally {
    s.close();
  }
}
