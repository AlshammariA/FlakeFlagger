@Test public void concurrentOrderBeforeRemoved() throws Exception {
  ContentSession s1=repository.login(null,null);
  try {
    Root r1=s1.getLatestRoot();
    Tree t1=r1.getTree("/");
    t1.addChild("node1");
    t1.addChild("node2");
    t1.addChild("node3");
    r1.commit();
    ContentSession s2=repository.login(null,null);
    try {
      Root r2=s2.getLatestRoot();
      Tree t2=r2.getTree("/");
      t1.getChild("node2").orderBefore("node1");
      t1.getChild("node3").remove();
      r1.commit();
      assertSequence(t1.getChildren(),"node2","node1");
      t2.getChild("node3").orderBefore("node1");
      r2.commit();
      assertSequence(t2.getChildren(),"node2","node1");
    }
  finally {
      s2.close();
    }
  }
  finally {
    s1.close();
  }
}
