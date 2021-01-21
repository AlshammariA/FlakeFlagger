@Test public void testNullLocation(){
  TreeLocation xyz=nullLocation.getChild("x").getChild("y").getChild("z");
  Assert.assertEquals("x/y/z",xyz.getPath());
  assertEquals("x/y",xyz.getParent().getPath());
  assertEquals("x",xyz.getParent().getParent().getPath());
  assertEquals(nullLocation,xyz.getParent().getParent().getParent());
}
