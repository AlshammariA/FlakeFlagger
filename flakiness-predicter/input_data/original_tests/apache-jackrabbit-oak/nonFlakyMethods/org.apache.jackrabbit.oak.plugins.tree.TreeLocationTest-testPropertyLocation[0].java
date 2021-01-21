@Test public void testPropertyLocation(){
  TreeLocation a=TreeLocation.create(root,"/a");
  assertNotNull(a.getProperty());
  TreeLocation abc=a.getChild("b").getChild("c");
  assertEquals("/a/b/c",abc.getPath());
  assertNull(abc.getProperty());
  TreeLocation ab=abc.getParent();
  assertEquals("/a/b",ab.getPath());
  assertNull(ab.getProperty());
  assertEquals(a.getProperty(),ab.getParent().getProperty());
}
