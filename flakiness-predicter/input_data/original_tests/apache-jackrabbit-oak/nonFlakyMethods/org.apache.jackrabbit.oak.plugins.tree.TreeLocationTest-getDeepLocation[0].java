@Test public void getDeepLocation(){
  TreeLocation p=TreeLocation.create(root,"/z/1/2/p");
  assertNotNull(p.getProperty());
  assertEquals("/z/1/2/p",p.getPath());
  TreeLocation n=TreeLocation.create(root,"/z/1/2/3/4");
  assertNull(n.getTree());
  assertNull(n.getProperty());
  assertEquals("/z/1/2/3/4",n.getPath());
  TreeLocation two=n.getParent().getParent();
  assertNotNull(two.getTree());
  assertEquals("/z/1/2",two.getPath());
}
