@Test public void getChildren(){
  Tree tree=root.getTree("/");
  Iterable<Tree> children=tree.getChildren();
  Set<String> expectedPaths=new HashSet<String>();
  Collections.addAll(expectedPaths,"/x","/y","/z");
  for (  Tree child : children) {
    assertTrue(expectedPaths.remove(child.getPath()));
  }
  assertTrue(expectedPaths.isEmpty());
  assertEquals(3,tree.getChildrenCount(4));
}
