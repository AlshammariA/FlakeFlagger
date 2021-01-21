/** 
 * @since oak 1.0 cyclic group membership added in a single set of transientmodifications must be detected upon save.
 */
@Test public void testDetectCyclicMembership() throws Exception {
  Group group1=null;
  Group group2=null;
  Group group3=null;
  UserManager userMgr=getUserManager(root);
  try {
    group1=userMgr.createGroup("group1");
    group2=userMgr.createGroup("group2");
    group3=userMgr.createGroup("group3");
    group1.addMember(group2);
    group2.addMember(group3);
    assertFalse(group3.addMember(group1));
    Tree group3Tree=root.getTree(group3.getPath());
    Set<String> values=Collections.singleton(root.getTree(group1.getPath()).getProperty(JcrConstants.JCR_UUID).getValue(Type.STRING));
    PropertyState prop=PropertyStates.createProperty(REP_MEMBERS,values,Type.WEAKREFERENCES);
    group3Tree.setProperty(prop);
    root.commit();
    fail("Cyclic group membership must be detected");
  }
 catch (  CommitFailedException e) {
  }
 finally {
    if (group1 != null)     group1.remove();
    if (group2 != null)     group2.remove();
    if (group3 != null)     group3.remove();
    root.commit();
  }
}
