@Test public void testGetPath(){
  ImmutableTree immutable=new ImmutableTree(mutableTree.getNodeState());
  assertEquals("/",immutable.getPath());
  immutable=immutable.getChild("x");
  assertEquals("/x",immutable.getPath());
  immutable=immutable.getChild("y");
  assertEquals("/x/y",immutable.getPath());
  immutable=immutable.getChild("z");
  assertEquals("/x/y/z",immutable.getPath());
}
