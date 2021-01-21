@Test public void testRemoveProperty2() throws Exception {
  Privilege[] privileges=privilegesFromNames(new String[]{"rep:removeProperties"});
  allow(path,privileges);
  superuser.getNode(path).setProperty("newProperty","value");
  superuser.save();
  testSession.refresh(false);
  testSession.getNode(path).setProperty("newProperty",(String)null);
  testSession.save();
}
