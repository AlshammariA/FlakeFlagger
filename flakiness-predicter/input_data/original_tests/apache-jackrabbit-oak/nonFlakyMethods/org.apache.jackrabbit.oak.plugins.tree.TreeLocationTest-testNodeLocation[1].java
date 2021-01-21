@Test public void testNodeLocation(){
  TreeLocation x=TreeLocation.create(root,"/x");
  assertNotNull(x.getTree());
  TreeLocation xyz=x.getChild("y").getChild("z");
  assertEquals("/x/y/z",xyz.getPath());
  assertNull(xyz.getTree());
  TreeLocation xy=xyz.getParent();
  assertEquals("/x/y",xy.getPath());
  assertNull(xy.getTree());
  assertEquals(x.getTree(),xy.getParent().getTree());
}
