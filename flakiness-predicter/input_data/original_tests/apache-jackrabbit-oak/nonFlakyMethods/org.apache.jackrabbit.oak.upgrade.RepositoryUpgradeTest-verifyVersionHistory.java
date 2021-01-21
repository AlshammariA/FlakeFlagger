@Test public void verifyVersionHistory() throws RepositoryException {
  Session session=createAdminSession();
  try {
    assertTrue(session.nodeExists("/versionable"));
    Node versionable=session.getNode("/versionable");
    assertTrue(versionable.hasNode("child"));
    Node child=versionable.getNode("child");
    assertTrue(child.hasNode("child2"));
    Node child2=child.getNode("child2");
    assertFalse(versionable.isCheckedOut());
    assertTrue(versionable.hasProperty(JCR_UUID));
    assertFalse(child.isCheckedOut());
    assertTrue(child.hasProperty(JCR_UUID));
    assertFalse(child2.isCheckedOut());
    assertFalse(child2.hasProperty(JCR_UUID));
    VersionManager manager=session.getWorkspace().getVersionManager();
    Version version=manager.getBaseVersion("/versionable");
    Node frozen=version.getFrozenNode();
    assertEquals(versionable.getPrimaryNodeType().getName(),frozen.getProperty(JCR_FROZENPRIMARYTYPE).getString());
    assertEquals(versionable.getMixinNodeTypes()[0].getName(),frozen.getProperty(JCR_FROZENMIXINTYPES).getValues()[0].getString());
    assertEquals(versionable.getIdentifier(),frozen.getProperty(JCR_FROZENUUID).getString());
    Node frozenChild=frozen.getNode("child");
    assertEquals(child.getPrimaryNodeType().getName(),frozenChild.getProperty(JCR_FROZENPRIMARYTYPE).getString());
    assertFalse(frozenChild.hasProperty(JCR_FROZENMIXINTYPES));
    assertEquals("OAK-1789",child.getIdentifier(),frozenChild.getProperty(JCR_FROZENUUID).getString());
    Node frozenChild2=frozenChild.getNode("child2");
    assertEquals(child2.getPrimaryNodeType().getName(),frozenChild2.getProperty(JCR_FROZENPRIMARYTYPE).getString());
    assertFalse(frozenChild2.hasProperty(JCR_FROZENMIXINTYPES));
    assertEquals("OAK-1789",child2.getIdentifier(),frozenChild2.getProperty(JCR_FROZENUUID).getString());
    VersionHistory history=manager.getVersionHistory("/versionable");
    assertTrue(history.isNodeType("rep:VersionablePaths"));
    Property versionablePath=history.getProperty("default");
    assertEquals("/versionable",versionablePath.getString());
  }
  finally {
    session.logout();
  }
}
