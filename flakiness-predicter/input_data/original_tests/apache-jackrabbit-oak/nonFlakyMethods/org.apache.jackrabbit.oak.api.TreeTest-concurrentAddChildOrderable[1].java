@Test public void concurrentAddChildOrderable() throws Exception {
  ContentSession s1=repository.login(null,null);
  try {
    Root r1=s1.getLatestRoot();
    Tree t1=r1.getTree("/");
    t1.addChild("node1").orderBefore(null);
    t1.addChild("node2");
    r1.commit();
    ContentSession s2=repository.login(null,null);
    try {
      Root r2=s2.getLatestRoot();
      Tree t2=r2.getTree("/");
      t1=r1.getTree("/");
      t1.addChild("node3");
      r1.commit();
      t2.addChild("node4");
      r2.commit();
      t1=s1.getLatestRoot().getTree("/");
      assertSequence(t1.getChildren(),"node1","node2","node3","node4");
    }
  finally {
      s2.close();
    }
  }
  finally {
    s1.close();
  }
}
