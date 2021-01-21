@Test public void concurrentOrderBeforeAllRemoved() throws Exception {
  ContentSession s1=repository.login(null,null);
  try {
    Root r1=s1.getLatestRoot();
    Tree t1=r1.getTree("/").addChild("c");
    t1.addChild("node1").orderBefore(null);
    t1.addChild("node2");
    t1.addChild("node3");
    r1.commit();
    ContentSession s2=repository.login(null,null);
    try {
      Root r2=s2.getLatestRoot();
      Tree t2=r2.getTree("/c");
      t1.remove();
      r1.getTree("/").addChild("c");
      r1.commit();
      assertSequence(t1.getChildren());
      t2.getChild("node3").orderBefore("node1");
      r2.commit();
      assertSequence(t2.getChildren());
    }
  finally {
      s2.close();
    }
  }
  finally {
    s1.close();
  }
}
