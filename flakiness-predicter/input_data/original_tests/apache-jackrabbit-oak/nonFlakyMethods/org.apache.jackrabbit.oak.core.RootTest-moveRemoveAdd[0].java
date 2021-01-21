@Test public void moveRemoveAdd(){
  Root root=session.getLatestRoot();
  Tree x=root.getTree("/x");
  Tree z=root.getTree("/z");
  z.setProperty("p","1");
  root.move("/z","/x/z");
  root.getTree("/x/z").remove();
  assertFalse(z.exists());
  x.addChild("z");
  assertEquals(Status.NEW,z.getStatus());
  x.getChild("z").setProperty("p","2");
  PropertyState p=z.getProperty("p");
  assertNotNull(p);
  assertEquals("2",p.getValue(Type.STRING));
}
