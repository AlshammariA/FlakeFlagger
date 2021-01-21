@Test public void removeWithConcurrentOrderBefore() throws Exception {
  ContentSession s1=repository.login(null,null);
  try {
    Root r1=s1.getLatestRoot();
    Tree t1=r1.getTree("/").addChild("c");
    t1.addChild("node1").orderBefore(null);
    t1.addChild("node2");
    r1.commit();
    ContentSession s2=repository.login(null,null);
    try {
      Root r2=s2.getLatestRoot();
      Tree t2=r2.getTree("/c");
      t1=r1.getTree("/c");
      t1.getChild("node2").orderBefore("node1");
      r1.commit();
      assertSequence(t1.getChildren(),"node2","node1");
      t2.remove();
      r2.commit();
      assertFalse(r2.getTree("/").hasChild("c"));
    }
  finally {
      s2.close();
    }
  }
  finally {
    s1.close();
  }
}
