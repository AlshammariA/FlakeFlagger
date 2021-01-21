@Test public void largeChildList() throws CommitFailedException {
  Tree tree=root.getTree("/");
  Set<String> added=new HashSet<String>();
  Tree large=tree.addChild("large");
  for (int c=0; c < 10000; c++) {
    String name="n" + c;
    added.add(name);
    large.addChild(name);
  }
  root.commit();
  for (  Tree child : large.getChildren()) {
    assertTrue(added.remove(child.getName()));
  }
  assertTrue(added.isEmpty());
}
