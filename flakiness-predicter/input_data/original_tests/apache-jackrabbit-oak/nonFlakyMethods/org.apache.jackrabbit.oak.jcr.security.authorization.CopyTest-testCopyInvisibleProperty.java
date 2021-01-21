@Test public void testCopyInvisibleProperty() throws Exception {
  deny(childNPath,privilegesFromName(PrivilegeConstants.REP_READ_PROPERTIES));
  allow(targetPath,privilegesFromName(Privilege.JCR_ALL));
  testSession.getWorkspace().copy(path,destPath);
  Node copiedNode=testSession.getNode(destPath);
  String childName=Text.getName(childNPath);
  assertTrue(copiedNode.hasNode(childName));
  assertFalse(copiedNode.hasProperty(childName + '/' + propertyName1));
  superuser.refresh(false);
  assertFalse(superuser.nodeExists(destPath + '/' + childName+ '/'+ propertyName1));
}
