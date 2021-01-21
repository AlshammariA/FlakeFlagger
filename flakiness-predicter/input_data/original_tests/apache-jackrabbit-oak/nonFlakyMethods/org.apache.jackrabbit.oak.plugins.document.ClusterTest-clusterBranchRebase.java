/** 
 * Test for OAK-1254
 */
@Test public void clusterBranchRebase() throws Exception {
  DocumentMK mk1=createMK(1,0);
  mk1.commit("/","+\"test\":{}",null,null);
  mk1.runBackgroundOperations();
  DocumentMK mk2=createMK(2,0);
  DocumentMK mk3=createMK(3,0);
  KernelNodeStore ns3=new KernelNodeStore(mk3);
  traverse(ns3.getRoot(),"/");
  String b3=mk3.branch(null);
  b3=mk3.commit("/","+\"mk3\":{}",b3,null);
  assertTrue(mk3.nodeExists("/test",b3));
  mk2.commit("/","+\"test/mk21\":{}",null,null);
  mk2.runBackgroundOperations();
  mk3.runBackgroundOperations();
  String base3=mk3.getHeadRevision();
  assertFalse(mk3.nodeExists("/test/mk21",b3));
  b3=mk3.rebase(b3,base3);
  mk2.commit("/","+\"test/mk22\":{}",null,null);
  mk2.runBackgroundOperations();
  mk3.runBackgroundOperations();
  NodeState base=ns3.retrieve(base3);
  assertNotNull(base);
  NodeState branchHead=ns3.retrieve(b3);
  assertNotNull(branchHead);
  TrackingDiff diff=new TrackingDiff();
  branchHead.compareAgainstBaseState(base,diff);
  assertEquals(1,diff.added.size());
  assertEquals(Sets.newHashSet("/mk3"),diff.added);
  assertEquals(new HashSet<String>(),diff.deleted);
  mk1.dispose();
  mk2.dispose();
  mk3.dispose();
}
