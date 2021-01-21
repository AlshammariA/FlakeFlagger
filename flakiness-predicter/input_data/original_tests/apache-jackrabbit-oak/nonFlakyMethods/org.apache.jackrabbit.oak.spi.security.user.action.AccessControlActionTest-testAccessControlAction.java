@Test public void testAccessControlAction() throws Exception {
  UserManager userMgr=getUserManager(root);
  Group gr=null;
  try {
    gr=userMgr.createGroup("actionTestGroup");
    root.commit();
    assertAcAction(gr,PrivilegeConstants.JCR_READ);
  }
  finally {
    root.refresh();
    if (gr != null) {
      gr.remove();
    }
    root.commit();
  }
}
