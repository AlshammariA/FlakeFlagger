@Test public void moveOrderableNodes() throws Exception {
  ContentSession s=repository.login(null,null);
  try {
    Root r=s.getLatestRoot();
    Tree t=r.getTree("/");
    Tree c=t.addChild("c");
    c.addChild("node1").orderBefore(null);
    c.addChild("node2");
    t.addChild("node3");
    r.commit();
    r.move("/node3","/c/node3");
    assertSequence(c.getChildren(),"node1","node2","node3");
    r.commit();
    assertSequence(c.getChildren(),"node1","node2","node3");
  }
  finally {
    s.close();
  }
}
