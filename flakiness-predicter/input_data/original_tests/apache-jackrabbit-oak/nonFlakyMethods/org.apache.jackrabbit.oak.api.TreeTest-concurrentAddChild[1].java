@Test public void concurrentAddChild() throws Exception {
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
      t1=r1.getTree("/");
      t1.addChild("node4");
      r1.commit();
      t2.addChild("node5");
      r2.commit();
      r1=s1.getLatestRoot();
      t1=r1.getTree("/");
      Set<String> names=Sets.newHashSet();
      for (      Tree t : t1.getChildren()) {
        names.add(t.getName());
      }
      assertEquals(Sets.newHashSet("node1","node2","node3","node4","node5"),names);
    }
  finally {
      s2.close();
    }
  }
  finally {
    s1.close();
  }
}
