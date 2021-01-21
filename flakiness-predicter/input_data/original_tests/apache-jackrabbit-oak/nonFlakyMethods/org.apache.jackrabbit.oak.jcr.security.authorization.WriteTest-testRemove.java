@Test public void testRemove() throws Exception {
  Privilege[] rmChildNodes=privilegesFromName(Privilege.JCR_REMOVE_CHILD_NODES);
  allow(path,rmChildNodes);
  assertFalse(testSession.hasPermission(path,javax.jcr.Session.ACTION_REMOVE));
  assertFalse(testSession.hasPermission(childNPath,javax.jcr.Session.ACTION_REMOVE));
}
