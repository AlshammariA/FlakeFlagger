/** 
 * Test from Jackrabbit: JCR-3635 (OAK-940) <p/> Tests the case when a node already has a manual set JcrConstants.JCR_FROZENUUID property and is versioned. The manual set frozenUuid will overwrite the one that is automatically assigned by the VersionManager, which should not happen
 */
public void testCopyFrozenUuidProperty() throws Exception {
  Node firstNode=testRootNode.addNode(nodeName1);
  firstNode.setPrimaryType(JcrConstants.NT_UNSTRUCTURED);
  firstNode.addMixin(JcrConstants.MIX_VERSIONABLE);
  firstNode.getSession().save();
  Version firstNodeVersion=firstNode.checkin();
  firstNode.checkout();
  Node secondNode=testRootNode.addNode(nodeName2);
  secondNode.setPrimaryType(JcrConstants.NT_UNSTRUCTURED);
  secondNode.addMixin(JcrConstants.MIX_VERSIONABLE);
  Property firstNodeVersionFrozenUuid=firstNodeVersion.getFrozenNode().getProperty(JcrConstants.JCR_FROZENUUID);
  secondNode.setProperty(JcrConstants.JCR_FROZENUUID,firstNodeVersionFrozenUuid.getValue());
  secondNode.getSession().save();
  Version secondNodeVersion=secondNode.checkin();
  secondNode.checkout();
  Property secondBodeVersionFrozenUuid=secondNodeVersion.getFrozenNode().getProperty(JcrConstants.JCR_FROZENUUID);
  assertFalse(JcrConstants.JCR_FROZENUUID + " should not be the same for two different versions of different nodes! ",secondBodeVersionFrozenUuid.getValue().equals(firstNodeVersionFrozenUuid.getValue()));
}
