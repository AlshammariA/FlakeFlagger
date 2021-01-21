/** 
 * Test if a new applicable policy can be applied within a sub-tree where AC-modification is allowed.
 * @see <a href="https://issues.apache.org/jira/browse/JCR-2869">JCR-2869</a>
 */
@Test public void testSetNewPolicy() throws Exception {
  Privilege[] privileges=privilegesFromNames(new String[]{REP_WRITE,Privilege.JCR_READ_ACCESS_CONTROL,Privilege.JCR_MODIFY_ACCESS_CONTROL});
  allow(path,privileges);
  AccessControlPolicyIterator it=testAcMgr.getApplicablePolicies(childNPath);
  while (it.hasNext()) {
    AccessControlPolicy plc=it.nextAccessControlPolicy();
    testAcMgr.setPolicy(childNPath,plc);
    testSession.save();
    testAcMgr.removePolicy(childNPath,plc);
    testSession.save();
  }
}
