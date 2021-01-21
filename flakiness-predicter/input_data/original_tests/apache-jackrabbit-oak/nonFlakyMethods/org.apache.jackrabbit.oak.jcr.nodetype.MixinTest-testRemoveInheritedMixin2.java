public void testRemoveInheritedMixin2() throws Exception {
  try {
    Authorizable user=((JackrabbitSession)superuser).getUserManager().getAuthorizable("admin");
    if (user == null) {
      throw new NotExecutableException();
    }
    Node node=superuser.getNode(user.getPath());
    assertTrue(node.isNodeType(JcrConstants.MIX_REFERENCEABLE));
    node.removeMixin(JcrConstants.MIX_REFERENCEABLE);
  }
 catch (  NoSuchNodeTypeException e) {
  }
 finally {
    superuser.refresh(false);
  }
}
