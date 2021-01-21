@Test public void concurrentAddChildMakeOrderable() throws Exception {
  ContentSession s1=repository.login(null,null);
  try {
    Root r1=s1.getLatestRoot();
    Tree t1=r1.getTree("/");
    t1.addChild("node1");
    t1.addChild("node2");
    r1.commit();
    ContentSession s2=repository.login(null,null);
    try {
      Root r2=s2.getLatestRoot();
      Tree t2=r2.getTree("/");
      t1=r1.getTree("/");
      t1.addChild("node3").orderBefore(null);
      r1.commit();
      List<String> names=Lists.newArrayList();
      for (      Tree t : r1.getTree("/").getChildren()) {
        names.add(t.getName());
      }
      t2.addChild("node4").orderBefore(null);
      r2.commit();
      names.add("node4");
      t1=s1.getLatestRoot().getTree("/");
      assertSequence(t1.getChildren(),names.toArray(new String[names.size()]));
    }
  finally {
      s2.close();
    }
  }
  finally {
    s1.close();
  }
}
