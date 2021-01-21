@Test public void testCopyInvisibleAcContent() throws Exception {
  deny(childNPath,privilegesFromName(Privilege.JCR_READ_ACCESS_CONTROL));
  allow(targetPath,privilegesFromName(PrivilegeConstants.JCR_ALL));
  testSession.getWorkspace().copy(path,destPath);
  Node copiedNode=testSession.getNode(destPath);
  String childName=Text.getName(childNPath);
  assertTrue(copiedNode.hasNode(childName));
  Node child=copiedNode.getNode(childName);
  assertFalse(child.hasNode(AccessControlConstants.REP_POLICY));
  superuser.refresh(false);
  assertFalse(superuser.nodeExists(targetPath + '/' + childName+ "/rep:policy"));
}
